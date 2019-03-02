package dto;



import entity.Brand;
import entity.Type;

import java.io.Serializable;
import java.util.List;

/**
 * @author MelloChan
 * @date 2018/6/1
 */
public class KindDTO implements Serializable{
    private static final long serialVersionUID = -3473317516461170708L;
    private List<Type>types;
    private List<Brand>brands;

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    @Override
    public String toString() {
        return "KindDTO{" +
                "types=" + types +
                ", brands=" + brands +
                '}';
    }
}
