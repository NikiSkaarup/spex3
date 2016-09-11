package model;

/**
 * Created by Niki on 2016-09-10.
 *
 * @author Niki
 */
public class Order {

    private int id;
    private int userId;
    private boolean pickedUp;

    public Order() {
    }

    public Order(int id, int userId, boolean pickedUp) {
        this.id = id;
        this.userId = userId;
        this.pickedUp = pickedUp;
    }

    public Order(int userId, boolean pickedUp) {
        this.userId = userId;
        this.pickedUp = pickedUp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isPickedUp() {
        return pickedUp;
    }

    public void setPickedUp(boolean pickedUp) {
        this.pickedUp = pickedUp;
    }
}
