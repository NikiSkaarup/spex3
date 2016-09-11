package model;

/**
 * Created by Niki on 2016-09-10.
 *
 * @author Niki
 */
public class User {

    private int id;
    private String username;
    private int balance;

    public User() {
    }

    public User(int id, String username, int balance) {
        this.id = id;
        this.username = username;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return id + "," + username + "," + balance;
    }
}
