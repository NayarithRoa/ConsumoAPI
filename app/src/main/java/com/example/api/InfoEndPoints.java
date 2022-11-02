package com.example.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface InfoEndPoints {
    @GET("api/users/")
    Call<InfoResponse> getInfo();

    @POST("api/users")
    Call<InfoResponseGet> postInfo();
}

