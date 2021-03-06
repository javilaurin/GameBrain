package com.laurinware.gamebrain;

import com.laurinware.gamebrain.Model.Game;
import com.laurinware.gamebrain.Model.Platform;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IGDBApiEndpointInterface {

    String API_user_key = "65b027ed363c5f179d4bdef0da2fc91f";

    // Request method and URL specified in the annotation

    @Headers({"user-key: 65b027ed363c5f179d4bdef0da2fc91f", "Accept: application/json"})
    @GET("/games/")
    Call<ArrayList<Game>> getAllGames();

    @Headers({"user-key: 65b027ed363c5f179d4bdef0da2fc91f", "Accept:application/json"})
    @GET("/games/{id}")
    Call<ArrayList<Game>> getGameByID(@Path("id") int id);

    @Headers({"user-key:" + API_user_key, "accept:application/json"})
    @GET("/games/")
    Call<ArrayList<Game>> searchGame(@Query("search") String search_query);
    // TODO add cover


    @Headers({"user-key: 65b027ed363c5f179d4bdef0da2fc91f", "Accept: application/json"})
    @GET("/platforms/?fields=id,name,logo")
    Call<ArrayList<Platform>> getAllPlatforms();
}
