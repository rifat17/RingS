package com.example.ringersschool.Model;

public class Students {

    String name;
    String card_id;
    int roll_no;
    String dob;
    public Students(String id, String name, String card_id, int roll_no, String dob) {
        this.id = id;
        this.name = name;
        this.card_id = card_id;
        this.roll_no = roll_no;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id;




}
