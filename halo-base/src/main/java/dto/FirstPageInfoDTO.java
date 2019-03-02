package dto;

import java.io.Serializable;

/**
 * @author SAIKAII
 * @date 2018/6/17
 */
public class FirstPageInfoDTO implements Serializable {
    private static final long serialVersionUID = 7731108150511793822L;
    private Integer totalOrder;
    private Integer noHandledOrder;
    private Integer zeroStock;
    private Integer totalTurnover;
    private Integer meiZu;
    private Integer meiLan;

    public FirstPageInfoDTO(Integer totalOrder, Integer noHandledOrder, Integer zeroStock, Integer totalTurnover, Integer meiZu, Integer meiLan) {
        this.totalOrder = totalOrder;
        this.noHandledOrder = noHandledOrder;
        this.zeroStock = zeroStock;
        this.totalTurnover = totalTurnover;
        this.meiZu = meiZu;
        this.meiLan = meiLan;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(Integer totalOrder) {
        this.totalOrder = totalOrder;
    }

    public Integer getNoHandledOrder() {
        return noHandledOrder;
    }

    public void setNoHandledOrder(Integer noHandledOrder) {
        this.noHandledOrder = noHandledOrder;
    }

    public Integer getZeroStock() {
        return zeroStock;
    }

    public void setZeroStock(Integer zeroStock) {
        this.zeroStock = zeroStock;
    }

    public Integer getTotalTurnover() {
        return totalTurnover;
    }

    public void setTotalTurnover(Integer totalTurnover) {
        this.totalTurnover = totalTurnover;
    }

    public Integer getMeiZu() {
        return meiZu;
    }

    public void setMeiZu(Integer meiZu) {
        this.meiZu = meiZu;
    }

    public Integer getMeiLan() {
        return meiLan;
    }

    public void setMeiLan(Integer meiLan) {
        this.meiLan = meiLan;
    }

    @Override
    public String toString() {
        return "FirstPageInfoDTO{" +
                "totalOrder=" + totalOrder +
                ", noHandledOrder=" + noHandledOrder +
                ", zeroStock=" + zeroStock +
                ", totalTurnover=" + totalTurnover +
                ", meiZu=" + meiZu +
                ", meiLan=" + meiLan +
                '}';
    }
}