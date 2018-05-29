package com.laurinware.gamebrain;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.laurinware.gamebrain.Model.Game;

import java.util.List;

public class GameNamesViewModel extends AndroidViewModel {
    private GameBrainRepository mRepository;

    private LiveData<List<Game>> mGames;


    public GameNamesViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Game>> getGamesNames(){
        return mGames;
    }

    public void insert(Game game){
    //    mRepository.insertGame(game);
    }
}
