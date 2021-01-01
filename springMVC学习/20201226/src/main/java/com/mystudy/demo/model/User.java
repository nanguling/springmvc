package com.mystudy.demo.model;

public class User {
    private String username;
    private String passward;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", passward='" + passward + '\'' +
                '}';
    }
}
