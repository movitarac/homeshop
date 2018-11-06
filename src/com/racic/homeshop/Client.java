package com.racic.homeshop;

public class Client {
    private String fullname;
    private String address;

    public Client(String fullname, String address) {
        this.fullname = fullname;
        this.address = address;
    }

    public String getFullname() {
        return fullname;
    }

    public String getAddress() {
        return address;
    }
}
