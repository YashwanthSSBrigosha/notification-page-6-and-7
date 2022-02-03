package com.example.viewpager2demo.ApiPackage;

import java.util.ArrayList;
import java.util.Date;

public class Item {
    public int id;
    public String name;
    public Object reqId;
    public Object refId;
    public String email;
    public String phone;
    public String _details;
    public ArrayList<String> role;
    public String permission;
    public String status;
    public Date updatedAt;
    public Date createdAt;
    public String submittedOnDate;
    public String rejectedOnDate;
    public String submittedOnTime;
    public String rejectedOnTime;
    public Details details;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Object getReqId() {
        return reqId;
    }

    public Object getRefId() {
        return refId;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String get_details() {
        return _details;
    }

    public ArrayList<String> getRole() {
        return role;
    }

    public String getPermission() {
        return permission;
    }

    public String getStatus() {
        return status;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getSubmittedOnDate() {
        return submittedOnDate;
    }

    public String getRejectedOnDate() {
        return rejectedOnDate;
    }

    public String getSubmittedOnTime() {
        return submittedOnTime;
    }

    public String getRejectedOnTime() {
        return rejectedOnTime;
    }

    public Details getDetails() {
        return details;
    }
}
