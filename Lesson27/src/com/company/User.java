package com.company;

public class User implements Comparable<User>{
    private String login;
    private String password;
    private String request;
    private int priority;

    public User(){
        login = "login";
        password = "password";
        priority = 0;
    }

    public User(String login, String password, int priority) {
        this.login = login;
        this.password = password;
        this.priority = priority;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(User o) {
        if (this.getPriority() > ((User)o).getPriority()) return 1;
        else if (getPriority() < ((User)o).getPriority()) return -1;
        else return 0;
    }
}
