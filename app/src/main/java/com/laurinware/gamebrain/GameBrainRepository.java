package com.laurinware.gamebrain;


import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.laurinware.gamebrain.Model.Game;
import com.laurinware.gamebrain.Model.Platform;

import java.util.List;

public class GameBrainRepository {
    RemoteDataSource remoteDataSource;

    public GameBrainRepository(Application application){
        remoteDataSource = new RemoteDataSource();
    }

    public List<Game> getSearchedGames(String search_query){
        return remoteDataSource.searchGames(search_query);
    }

    public List<Platform> getAllPlatforms(){
        return remoteDataSource.getAllPlatforms();
    }

}

