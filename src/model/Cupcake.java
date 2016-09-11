package model;

/**
 * Created by Niki on 2016-09-10.
 *
 * @author Niki
 */
public class Cupcake {

    private int id;
    private Part topping;
    private Part bottom;

    public Cupcake() {
    }

    public Cupcake(int id, Part topping, Part bottom) {
        this.id = id;
        this.topping = topping;
        this.bottom = bottom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Part getTopping() {
        return topping;
    }

    public void setTopping(Part topping) {
        this.topping = topping;
    }

    public Part getBottom() {
        return bottom;
    }

    public void setBottom(Part bottom) {
        this.bottom = bottom;
    }

}
