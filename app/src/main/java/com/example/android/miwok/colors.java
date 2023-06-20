package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class colors extends AppCompatActivity {

    MediaPlayer mMediaPlayer;
    MediaPlayer.OnCompletionListener mCompletionListener =( new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer ();
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> colors = new ArrayList<> ( );


        colors.add ( new Word ( "red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red ) );
        colors.add ( new Word ( "green", "chokokki", R.drawable.color_green, R.raw.color_green ) );
        colors.add ( new Word ( "brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown ) );
        colors.add ( new Word ( "gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray ) );
        colors.add ( new Word ( "black", "kululli", R.drawable.color_black, R.raw.color_black ) );
        colors.add ( new Word ( "white", "kelelli", R.drawable.color_white, R.raw.color_white ) );
        colors.add ( new Word ( "dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow ) );


        WordAdapter adapter = new WordAdapter(this,colors, R.color.category_colors);

        WordAdapter itemsAdapter =
                new WordAdapter(this, colors, R.color.category_colors );


        ListView listView =  findViewById(R.id.list);

        listView.setOnItemClickListener ( new AdapterView.OnItemClickListener ( ) {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word= colors.get ( position);
                releaseMediaPlayer ();
                mMediaPlayer = MediaPlayer.create (colors.this,word.getAudioplayer () );
                mMediaPlayer.start ();
                mMediaPlayer.setOnCompletionListener ( mCompletionListener );
            }
        });


        listView.setAdapter(itemsAdapter);


    }
    public void releaseMediaPlayer(){
        if( mMediaPlayer!=null){
            mMediaPlayer.release ();

        }


    }
    @Override
    protected void onStop() {
        super.onStop ( );
        releaseMediaPlayer();
    }
}


