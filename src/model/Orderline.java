package model;

/**
 * Created by Niki on 2016-09-10.
 *
 * @author Niki
 */
public class Orderline {

    private int cupcakeId;
    private int orderId;
    private int amount;

    public Orderline() {
    }

    public Orderline(int cupcakeId, int orderId, int amount) {
        this.cupcakeId = cupcakeId;
        this.orderId = orderId;
        this.amount = amount;
    }

    public int getCupcakeId() {
        return cupcakeId;
    }

    public void setCupcakeId(int cupcakeId) {
        this.cupcakeId = cupcakeId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
