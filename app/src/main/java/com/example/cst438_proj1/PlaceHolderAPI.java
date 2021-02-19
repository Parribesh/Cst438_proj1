package com.example.cst438_proj1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlaceHolderAPI {
    @GET("posts")
    Call<List<SeachCred>> getSearchInfo();
}
