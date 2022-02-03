package com.example.viewpager2demo.ApiPackage;

public class ApproveOrRejectRequest {
    int userId;
    String status;

    public ApproveOrRejectRequest(int userId, String status) {
        this.userId = userId;
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public String getStatus() {
        return status;
    }
}
