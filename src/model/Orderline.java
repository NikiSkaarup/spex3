package model;

import java.math.BigDecimal;

/**
 * Created by Niki on 2016-09-10.
 *
 * @author Niki
 */
public class OrderLine {

    private Cupcake cupcake;
    private Order order;
    private int amount;

    public OrderLine() {
    }

    public OrderLine(Cupcake cupcake, Order order, int amount) {
        this.cupcake = cupcake;
        this.order = order;
        this.amount = amount;
    }

    public Cupcake getCupcake() {
        return cupcake;
    }

    public void setCupcake(Cupcake cupcake) {
        this.cupcake = cupcake;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getTotalPrice() {
        return (cupcake.getTopping().getPrice()
                .add(cupcake.getBottom().getPrice()))
                .multiply(new BigDecimal(amount));
    }

}
