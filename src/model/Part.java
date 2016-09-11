package model;

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

    public Part() {
    }

    public Part(int id, String name, boolean topping, boolean bottom) {
        this.id = id;
        this.name = name;
        this.topping = topping;
        this.bottom = bottom;
    }

    public Part(String name, boolean topping, boolean bottom) {
        this.name = name;
        this.topping = topping;
        this.bottom = bottom;
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
}
