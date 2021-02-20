package com.example.cst438_proj1;

import androidx.room.Query;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface PlaceHolderAPI {
    @GET("about")
    Call<List<SeachCred>> getSearchInfo(@Header("APP_KEY") String key,
                                        @Body SeachCred search
                                       );
}
