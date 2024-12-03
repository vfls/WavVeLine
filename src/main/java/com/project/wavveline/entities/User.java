package com.project.wavveline.entities;

public class User {

    int id;
    private String name;
    private String username;
    private String password;
    private String email;
    private String title;

    public User(int id, String name, String username, String password, String email, String title) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.title = title;
    }
    public User(String name, String username, String password, String email, String title) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

