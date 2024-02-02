package com.example.neww.model;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    private int id;
    private String login;
    private String password;
    private String post;

    public String getLogin(){
        return login;
    }
    public String getPassword(){
        return password;
    }
    public String getPost(){
        return post;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setId(int id){
        this.id = id;
    }
}
