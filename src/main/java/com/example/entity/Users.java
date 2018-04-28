package com.example.entity;

import javax.persistence.Entity;

@Entity
public class Users {
    private Integer id;
    private String username;
    private String password;
    private String telephone;
    private String address;

    public Users() {
    }

    public Users(Integer id, String username, String password, String telephone, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.telephone = telephone;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (!id.equals(users.id)) return false;
        if (!username.equals(users.username)) return false;
        if (!password.equals(users.password)) return false;
        if (!telephone.equals(users.telephone)) return false;
        return address.equals(users.address);
    }

}
