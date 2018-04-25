package com.example.android.retrofitworkshop;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public static final String ARTIST_NAME = "artist_name";
    public static final String SONG_TITLE = "song_title";


    @BindView(R.id.input_artist_edittext)
    protected TextInputEditText artistNameEditText;
    @BindView(R.id.input_song_edittext)
    protected TextInputEditText songEditText;

    private LyricsFragment lyricsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.submit_button)
    protected void submitClicked () {

        // create new instance of fragment, set up bundle for editText info, and bring fragment into view

        if(artistNameEditText.getText().toString().isEmpty() || songEditText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Both fields are required. Try again!", Toast.LENGTH_LONG).show();

        } else {

            lyricsFragment = LyricsFragment.newInstance();

            Bundle bundle = new Bundle();
            bundle.putString(ARTIST_NAME, artistNameEditText.getText().toString());
            bundle.putString(SONG_TITLE, songEditText.getText().toString());
            lyricsFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, lyricsFragment).commit();

        }


    }

    @Override
    public void onBackPressed() {
        //check if fragment is in view and remove it
        if(lyricsFragment.isVisible()) {
            getSupportFragmentManager().beginTransaction().remove(lyricsFragment).commit();

            // I ADDED THIS
//            artistNameEditText.setText("");
//            songEditText.setText("");
        } else {
            super.onBackPressed();
        }

    }
}
