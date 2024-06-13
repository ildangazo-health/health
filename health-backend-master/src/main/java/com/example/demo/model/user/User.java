package com.example.demo.model.user;

import  jakarta.persistence.Entity;
import  jakarta.persistence.GeneratedValue;
import  jakarta.persistence.GenerationType;
import  jakarta.persistence.Id;

@Entity
public class User {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // 여기서는 increasing key로 primary key를 자동생성해주지만, 나는 id를 primary key로 생성해줬기 때문에 필요없다
    private String id; // 이게 id
    private String password;
    private String email;

    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getName(){return name;}

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ",name='" + name + '\'' +
                '}';
    }
}

