package com.async;

class Payload {
    Integer id;
    String name;
    String password;

    public Payload() {
    }

    public Payload(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "Payload{id=" + this.id + ", name='" + this.name + '\'' + ", password='" + this.password + '\'' + '}';
    }
}

