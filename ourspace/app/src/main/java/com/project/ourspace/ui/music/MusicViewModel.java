package com.project.ourspace.ui.music;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MusicViewModel extends ViewModel {

    public static class Song {
        private String name;
        private String url;

        Song(String n, String u){
            assert n != null;
            this.name = n;
            this.url = u;
        }

        public String getName() { return name; }
        String getUrl(){ return url; }
    }
    private MutableLiveData<String> titleText;
    private Song[] songs;

    public MusicViewModel() {
        titleText = new MutableLiveData<>();
        titleText.setValue("Jazzy Tunes");
    }

    LiveData<String> getTitle() {
        return titleText;
    }
}