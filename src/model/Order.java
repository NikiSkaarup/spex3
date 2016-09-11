package model;

/**
 * Created by Niki on 2016-09-10.
 *
 * @author Niki
 */
public class Order {

    private int id;
    private User user;
    private boolean pickedUp;

    public Order() {
    }

    public Order(int id, User user, boolean pickedUp) {
        this.id = id;
        this.user = user;
        this.pickedUp = pickedUp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isPickedUp() {
        return pickedUp;
    }

    public void setPickedUp(boolean pickedUp) {
        this.pickedUp = pickedUp;
    }
}
