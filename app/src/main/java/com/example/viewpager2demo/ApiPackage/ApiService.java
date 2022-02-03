package com.example.viewpager2demo.ApiPackage;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @Headers({"orgurl:brigosha.classroom.digital",
            "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwicGhvbmUiOiIrOTE5ODEyMTY4NTk5IiwidXJsIjoiYnJpZ29zaGEuY2xhc3Nyb29tLmRpZ2l0YWwiLCJvcmdJZCI6ImY4NjA4NDk3LWZiMzQtNGFiZC1hOGFkLTNmYjdlZDczZjUxZCIsImJyb3dzZXJMb2dpbkNvZGUiOiIrOTE5ODEyMTY4NTk5MTc2ZjJlMmI3LTgxODktNDM3ZC1hZDhiLTFlMzhhNGY4ZWIwOCIsImRldmljZUxvZ2luQ29kZSI6bnVsbCwiaWF0IjoxNjQzMDA4MTk1fQ.2IApiBdeHGiJ0igyeNDcfNjLZ8eOSaIK2QGmJAUXpw8"})
    @GET("notification/registered-users")
    Call<PendingStudentsDetail> getPendingStudentsDetails(@Query("status") String status);

    @Headers({"orgurl:brigosha.classroom.digital",
            "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwicGhvbmUiOiIrOTE5ODEyMTY4NTk5IiwidXJsIjoiYnJpZ29zaGEuY2xhc3Nyb29tLmRpZ2l0YWwiLCJvcmdJZCI6ImY4NjA4NDk3LWZiMzQtNGFiZC1hOGFkLTNmYjdlZDczZjUxZCIsImJyb3dzZXJMb2dpbkNvZGUiOiIrOTE5ODEyMTY4NTk5MTc2ZjJlMmI3LTgxODktNDM3ZC1hZDhiLTFlMzhhNGY4ZWIwOCIsImRldmljZUxvZ2luQ29kZSI6bnVsbCwiaWF0IjoxNjQzMDA4MTk1fQ.2IApiBdeHGiJ0igyeNDcfNjLZ8eOSaIK2QGmJAUXpw8"})
    @POST("user/updateStatus")
    Call<ApproveOrRejectResponse> getRejectResponse(@Body ApproveOrRejectRequest approveOrRejectRequest);
}
