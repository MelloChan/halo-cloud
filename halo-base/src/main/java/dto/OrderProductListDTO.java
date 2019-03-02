package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author MelloChan
 * @date 2018/6/13
 */
public class OrderProductListDTO implements Serializable {
    private static final long serialVersionUID = 2894200833125257136L;
    private String id;
    private Date gmtUpdated;
    private List<OrderProductDTO>products;
    private Integer price;
    private Short status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getGmtUpdated() {
        return gmtUpdated;
    }

    public void setGmtUpdated(Date gmtUpdated) {
        this.gmtUpdated = gmtUpdated;
    }

    public List<OrderProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<OrderProductDTO> products) {
        this.products = products;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderProductListDTO{" +
                "id='" + id + '\'' +
                ", gmtUpdated=" + gmtUpdated +
                ", products=" + products +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}
