package model;

import java.math.BigDecimal;

/**
 * Created by Niki on 2016-09-10.
 *
 * @author Niki
 */
public class Part {

    private int id;
    private String name;
    private boolean topping;
    private boolean bottom;
    private BigDecimal price;

    public Part() {
        id = 0;
    }

    public Part(int id, String name, boolean topping, boolean bottom) {
        this.id = id;
        this.name = name;
        this.topping = topping;
        this.bottom = bottom;
    }

    public Part(int id, String name, boolean topping, boolean bottom, BigDecimal
            price) {
        this.id = id;
        this.name = name;
        this.topping = topping;
        this.bottom = bottom;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTopping() {
        return topping;
    }

    public void setTopping(boolean topping) {
        this.topping = topping;
    }

    public boolean isBottom() {
        return bottom;
    }

    public void setBottom(boolean bottom) {
        this.bottom = bottom;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
