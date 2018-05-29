package com.laurinware.gamebrain;

import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.laurinware.gamebrain.Model.Game;
import com.laurinware.gamebrain.Model.Platform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.laurinware.gamebrain.MainActivity.BASE_URL;

public class RemoteDataSource {

    private Retrofit retrofitInstance;
    private IGDBApiEndpointInterface apiService;
    private List<Game> gameList;
    private List<Platform> platformList;

    public RemoteDataSource() {
        // Creating retrofit instance
        retrofitInstance = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofitInstance.create(IGDBApiEndpointInterface.class);

    }

    public Retrofit getRetrofitInstance() {
        return retrofitInstance;
    }

    public void setRetrofitInstance(Retrofit retrofitInstance) {
        this.retrofitInstance = retrofitInstance;
    }

    public IGDBApiEndpointInterface getApiService() {
        return apiService;
    }

    public void setApiService(IGDBApiEndpointInterface apiService) {
        this.apiService = apiService;
    }

    public LiveData<List<Game>> getAllGames(){
        return null;
    }

    public List<Game> getGameByID() {
        // Obtaining data in JSON format
        int id = 11544;
        Call<ArrayList<Game>> call = apiService.getGameByID(id);
        call.enqueue(new Callback<ArrayList<Game>>() {
            @Override
            public void onResponse(Call<ArrayList<Game>> call, Response<ArrayList<Game>> response) {
                int statusCode = response.code();
                gameList = response.body();
                Log.d("JSON", "Success");
                Log.d("GAME", "Game: " + gameList.get(0).name + ", Developers: " + gameList.get(0).developers.toString());
            }

            @Override
            public void onFailure(Call<ArrayList<Game>> call, Throwable t) {
                // Log error here since request failed
                Log.d("FAILURE", "Failure. URL: " + call.request().url());
                Log.d("FAILURE", "Headers: \n" + call.request().headers());
                Log.d("FAILURE", "Throwable: " + t.getMessage());
            }
        });

        return gameList;
    }

    public List<Game> searchGames(String search_query) {
        // Obtaining data in JSON format
        int id = 11544;
        Call<ArrayList<Game>> call = apiService.searchGame(search_query);
        call.enqueue(new Callback<ArrayList<Game>>() {
            @Override
            public void onResponse(Call<ArrayList<Game>> call, Response<ArrayList<Game>> response) {
                int statusCode = response.code();
                gameList = response.body();
                Log.d("JSON", "Success");
                Log.d("GAME", "Game: " + gameList.get(0).name + ", Developers: " + gameList.get(0).developers.toString());
            }

            @Override
            public void onFailure(Call<ArrayList<Game>> call, Throwable t) {
                // Log error here since request failed
                Log.d("FAILURE", "Failure. URL: " + call.request().url());
                Log.d("FAILURE", "Headers: \n" + call.request().headers());
                Log.d("FAILURE", "Throwable: " + t.getMessage());
            }
        });

        return gameList;
    }

    public List<Platform> getAllPlatforms(){
        Call<ArrayList<Platform>> call = apiService.getAllPlatforms();
        call.enqueue(new Callback<ArrayList<Platform>>() {
            @Override
            public void onResponse(Call<ArrayList<Platform>> call, Response<ArrayList<Platform>> response) {
                int statusCode = response.code();
                platformList = response.body();
                Log.d("JSON", "Success");
                Log.d("GAME", "Platform: " + platformList.get(0).name);
            }

            @Override
            public void onFailure(Call<ArrayList<Platform>> call, Throwable t) {
                // Log error here since request failed
                Log.d("FAILURE", "Failure. URL: " + call.request().url());
                Log.d("FAILURE", "Headers: \n" + call.request().headers());
                Log.d("FAILURE", "Throwable: " + t.getMessage());
            }
        });
        return platformList;
    }
}
