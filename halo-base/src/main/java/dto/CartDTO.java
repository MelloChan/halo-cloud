package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MelloChan
 * @date 2018/6/2
 */
public class CartDTO implements Serializable {
    private static final long serialVersionUID = 7998590239294856704L;
    private List<CartItemDTO>carts;
    private Integer totalNumber;
    private Integer totalPrice;
    public CartDTO(){
        this.carts=new ArrayList<>();
        this.totalNumber=0;
        this.totalPrice=0;
    }
    public List<CartItemDTO> getCarts() {
        return carts;
    }

    public void setCarts(List<CartItemDTO> carts) {
        this.carts = carts;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "CartDTO{" +
                "carts=" + carts +
                ", totalNumber=" + totalNumber +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
