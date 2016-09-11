package model;

/**
 * Created by Niki on 2016-09-10.
 *
 * @author Niki
 */
public class Cupcake {

    private int id;
    private int toppingId;
    private int bottomId;

    public Cupcake() {
    }

    public Cupcake(int id, int toppingId, int bottomId) {
        this.id = id;
        this.toppingId = toppingId;
        this.bottomId = bottomId;
    }

    public Cupcake(int toppingId, int bottomId) {
        this.toppingId = toppingId;
        this.bottomId = bottomId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getToppingId() {
        return toppingId;
    }

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
    }

    public int getBottomId() {
        return bottomId;
    }

    public void setBottomId(int bottomId) {
        this.bottomId = bottomId;
    }
}
