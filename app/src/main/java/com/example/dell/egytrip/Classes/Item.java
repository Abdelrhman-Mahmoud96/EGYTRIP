package com.example.dell.egytrip.Classes;

public class Item {

    String name;
    String address;
    String phone;
    int description;
    int[] img;

    public Item(String c_name, int[] c_img , String c_address, String c_phone, int c_description)
    {
        name = c_name;
        img = c_img;
        address = c_address;
        phone = c_phone;
        description = c_description;
    }

    public String getName() {
        return name;
    }

    public int[] getImg() {
        return img;
    }

    public int getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
