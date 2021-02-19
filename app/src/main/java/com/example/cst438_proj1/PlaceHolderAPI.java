package com.example.cst438_proj1;

import androidx.room.Query;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;



public interface PlaceHolderAPI {
    @GET("positions.json")
    Call<List<SeachCred>> getSearchInfo(
            @retrofit2.http.Query("description") String obName,
            @retrofit2.http.Query("location") String jobLocation);
//    @GET("positions.json?description={job}")
//    Call<List<SeachCred>> getSearchInfo(@Path("job") String jobName);
}
