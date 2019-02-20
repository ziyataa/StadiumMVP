package com.ziyata.stadiummvp.network;

import com.ziyata.stadiummvp.model.StadiumResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("/api/v1/json/1/search_all_teams.php")
    Call<StadiumResponse> getStadiumResponse(
            @Query("l") String l
    );

    @GET("/api/v1/json/1/lookupteam.php")
    Call<StadiumResponse> getStadiumResponse(
            @Query("id") int id
    );
}
