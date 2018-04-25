package com.example.android.retrofitworkshop;

import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitMusicApiCalls {

    // http://square.github.io/retrofit/
    //https://lyricsovh.docs.apiary.io/#reference/0/lyrics-of-a-song/search

    @GET("{artist}/{title}")
    Call<SongLyrics> getSongLyrics(@Path("artist") String artist, @Path("title") String title);
                                                            //^^^passes in artist and title into URL path, has to match @GET





    class SongLyrics {

        @SerializedName("lyrics")           //matches key from Body example from website
        private String lyrics;

        public String getLyrics() {
            return lyrics;
        }
    }


}
