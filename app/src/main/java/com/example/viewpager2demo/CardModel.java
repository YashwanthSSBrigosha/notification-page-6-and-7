package com.example.viewpager2demo;

public class CardModel {
    int userId;
    String name, number, std, subject, date, time;

    public CardModel(int userId,String name, String number, String std, String subject, String date, String time) {
        this.userId = userId;
        this.name = name;
        this.number = number;
        this.std = std;
        this.subject = subject;
        this.date = date;
        this.time = time;
    }

    public int getUserId(){
        return userId;
    }

    public void setUserId(){
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
