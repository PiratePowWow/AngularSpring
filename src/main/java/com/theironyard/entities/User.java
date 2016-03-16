package com.theironyard.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by PiratePowWow on 3/16/16.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    int id;
    @Column(nullable=false, unique = true)
    String username;
    @NotNull
    String address;
    @NotNull
    String email;

    public User(int id, String username, String address, String email) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.email = email;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
