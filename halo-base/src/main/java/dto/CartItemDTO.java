package dto;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author MelloChan
 * @date 2018/6/2
 */
public class CartItemDTO implements Serializable {
    private static final long serialVersionUID = 6966010392610826703L;
    @Min(1)
    private Integer proId;
    @NotBlank
    private String imgUrl;
    @NotBlank
    private String title;
    @Min(1)
    private Integer price;
    @Min(1)
    private Integer number;

    public Integer getProId() {
        return proId;
    }

    public void setId(Integer proId) {
        this.proId = proId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CartItemDTO{" +
                "proId=" + proId +
                ", imgUrl='" + imgUrl + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", number=" + number +
                '}';
    }
}
