package com.example.api;

import com.google.gson.annotations.SerializedName;

public class Post {
    private int id;
    private String names;
    private String username;
    private String rol;
    private String created_at;
    private String updated_at;

   /* public  Post(){

    }

    public Post(int id, String names, String username, String rol, String created_at, String updated_at) {
        this.id = id;
        this.names = names;
        this.username = username;
        this.rol = rol;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
