package com.halo.cloud.store.server.service;

import com.auth0.jwt.interfaces.Claim;

import com.halo.cloud.dto.CartDTO;
import com.halo.cloud.dto.CartItemDTO;
import com.halo.cloud.store.server.util.RedisUtil;
import com.halo.cloud.util.GsonUtil;
import com.halo.cloud.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * @author MelloChan
 * @date 2018/6/4
 */
@Service
public class CartService {

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 加入购物车
     *
     * @param cartItemDTO 加入的购物车商品
     * @param request     请求流
     */
    public Cookie insertCartItem(CartItemDTO cartItemDTO,
                                 HttpServletRequest request) throws UnsupportedEncodingException {
        // 获取cookie的购物车信息
        CartDTO cartDTO = getCartDTOByCookie(request);
        String token = request.getHeader("access_token");
        Map<String, Claim> claims = TokenUtil.verifyToken(token);
        if (null != claims) {
            int id = claims.get("uid").asInt();
            cartDTO = (CartDTO) redisUtil.get("cart:" + id);
        }

        // 购物车为空 初始化购物车
        if (cartDTO == null) {
            cartDTO = new CartDTO();
        }
        // 将商品加入购物车
        List<CartItemDTO> carts = addItem(cartDTO, cartItemDTO);
        // 更新购物车商品列表 商品总数 商品总价
        cartDTO.setCarts(carts);
        cartDTO.setTotalNumber(cartDTO.getTotalNumber() + 1);
        cartDTO.setTotalPrice(cartDTO.getTotalPrice() + cartItemDTO.getPrice());
        // 保存购物车信息并且返回相应cookie
        return saveCartAndGetCookie(token, cartDTO);
    }

    /**
     * 获取cookie的购物车信息
     */
    private CartDTO getCartDTOByCookie(HttpServletRequest request) throws UnsupportedEncodingException {
        CartDTO cartDTO = null;
        Cookie[] cookies = request.getCookies();
        // 获取cookie是否有cart信息
        if (null != cookies && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if ("cart" .equals(URLDecoder.decode(cookie.getName(), "utf-8"))) {
                    String cartJson = URLDecoder.decode(cookie.getValue(), "utf-8");
                    cartDTO = (CartDTO) GsonUtil.jsonToObject(cartJson, CartDTO.class);
                    break;
                }
            }
        }
        return cartDTO;
    }

    /**
     * 购物车商品数不少于0 循环遍历是否有相同商品
     */
    private List<CartItemDTO> addItem(CartDTO cartDTO, CartItemDTO cartItemDTO) {
        List<CartItemDTO> carts = cartDTO.getCarts();
        boolean flag = false;
        if (carts.size() > 0) {
            for (CartItemDTO cartItem : carts) {
                if (cartItemDTO.getProId().equals(cartItem.getProId())) {
                    // 增加相同商品数量
                    cartItem.setNumber(cartItem.getNumber() + cartItemDTO.getNumber());
                    flag = true;
                    break;
                }
            }
        }
        //  新商品 直接添加到购物车
        if (!flag) {
            carts.add(cartItemDTO);
        }
        return carts;
    }

    /**
     * 登录状态下存入redis 并清除cookie
     * 未登录状态下 直接设置cookie
     */
    private Cookie saveCartAndGetCookie(String token, CartDTO cartDTO) throws UnsupportedEncodingException {
        Cookie cookie;
        Map<String, Claim> claims = TokenUtil.verifyToken(token);
        if (claims != null) {
            int id = claims.get("uid").asInt();
            redisUtil.add("cart:" + id, cartDTO);
            cookie = new Cookie("cart", null);
            cookie.setPath("/");
            cookie.setMaxAge(0);
        } else {
            String cartJson = GsonUtil.toJsonString(cartDTO);
            cookie = new Cookie("cart", URLEncoder.encode(cartJson, "utf-8"));
            cookie.setPath("/");
            cookie.setMaxAge(12 * 60 * 60);
        }
        return cookie;
    }

    /**
     * 获取购物车信息
     */
    public CartDTO getCart(HttpServletRequest request) throws UnsupportedEncodingException {
        CartDTO cartDTO;
        String token = request.getHeader("access_token");
        Map<String, Claim> claims = TokenUtil.verifyToken(token);
        if (claims != null) {
            int id = claims.get("uid").asInt();
            cartDTO = (CartDTO) redisUtil.get("cart:" + id);
            if (cartDTO == null) {
                cartDTO = getCartDTOByCookie(request);
            }
        } else {
            cartDTO = getCartDTOByCookie(request);
        }
        if (cartDTO == null) {
            cartDTO = new CartDTO();
        }
        return cartDTO;
    }

    /**
     * 更新(增加或减少)购物车某件商品的数量
     */
    public Cookie updateCart(Integer id, Integer quantity, HttpServletRequest request) throws UnsupportedEncodingException {
        CartDTO cartDTO = getCart(request);
        List<CartItemDTO> carts = cartDTO.getCarts();
        for (CartItemDTO item : carts) {
            if (item.getProId().equals(id)) {
                cartDTO.setTotalPrice(cartDTO.getTotalPrice() - item.getNumber() * item.getPrice());
                cartDTO.setTotalNumber(cartDTO.getTotalNumber() - item.getNumber());
                item.setNumber(quantity);
                cartDTO.setTotalPrice(cartDTO.getTotalPrice() + quantity * item.getPrice());
                cartDTO.setTotalNumber(cartDTO.getTotalNumber() + quantity);
                break;
            }
        }
        String token = request.getHeader("access_token");
        return saveCartAndGetCookie(token, cartDTO);
    }

    /**
     * 删除购物车中某件商品
     */
    public Cookie deleteCart(Integer id, HttpServletRequest request) throws UnsupportedEncodingException {
        CartDTO cartDTO = getCart(request);
        List<CartItemDTO> carts = cartDTO.getCarts();
        for (CartItemDTO item : carts) {
            if (item.getProId().equals(id)) {
                cartDTO.setTotalNumber(cartDTO.getTotalNumber() - item.getNumber());
                cartDTO.setTotalPrice(cartDTO.getTotalPrice() - item.getNumber() * item.getPrice());
                carts.remove(item);
                break;
            }
        }
        String token = request.getHeader("access_token");
        return saveCartAndGetCookie(token, cartDTO);
    }

}
