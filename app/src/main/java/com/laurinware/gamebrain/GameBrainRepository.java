package com.laurinware.gamebrain;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.laurinware.gamebrain.Model.Game;
import com.laurinware.gamebrain.Model.Platform;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GameBrainRepository extends AndroidViewModel{
    RemoteDataSource remoteDataSource;
    public MutableLiveData<List<Game>> gamesList;
    private List<Game> emptyList;

    public GameBrainRepository(@NonNull Application application){
        super(application);
        remoteDataSource = new RemoteDataSource();
        emptyList = new List<Game>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @NonNull
            @Override
            public Iterator<Game> iterator() {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(@NonNull T[] ts) {
                return null;
            }

            @Override
            public boolean add(Game game) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(@NonNull Collection<? extends Game> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, @NonNull Collection<? extends Game> collection) {
                return false;
            }

            @Override
            public boolean removeAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Game get(int i) {
                return null;
            }

            @Override
            public Game set(int i, Game game) {
                return null;
            }

            @Override
            public void add(int i, Game game) {

            }

            @Override
            public Game remove(int i) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @NonNull
            @Override
            public ListIterator<Game> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<Game> listIterator(int i) {
                return null;
            }

            @NonNull
            @Override
            public List<Game> subList(int i, int i1) {
                return null;
            }
        };
        gamesList = new MutableLiveData<List<Game>>();
        gamesList.setValue(emptyList);
    }

    public LiveData<List<Game>> getSearchedGames(String search_query){
        gamesList.postValue(remoteDataSource.searchGames(search_query));
        return gamesList;
    }

    public List<Platform> getAllPlatforms(){
        return remoteDataSource.getAllPlatforms();
    }

}

