package com.cookandroid.helloandroid.retrofit;
import com.cookandroid.helloandroid.model.Checkup;
import com.cookandroid.helloandroid.model.CheckupDTO;


import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CheckupAPI
{
    @GET("/checkup/get-all")
    Call<List<Checkup>> getAllCheckups();

    @POST("/checkup/save")
    Call<Checkup> save(@Body Checkup checkup);



}
