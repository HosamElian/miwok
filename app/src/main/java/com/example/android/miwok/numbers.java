package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class numbers extends AppCompatActivity {

    MediaPlayer mMediaPlayer;
    AudioManager mAudioManager;
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

    final ArrayList<Word> numbersen = new ArrayList<>();

        numbersen.add(new  Word("one","lutti",R.drawable.number_one,R.raw.number_one));
        numbersen.add(new  Word("two","otiiko",R.drawable.number_two,R.raw.number_two));
        numbersen.add(new  Word("three","tolookosu",R.drawable.number_three,R.raw.number_three));
        numbersen.add(new  Word("four","oyyisa",R.drawable.number_four,R.raw.number_four));
        numbersen.add(new  Word("five","massokka",R.drawable.number_five,R.raw.number_five));
        numbersen.add(new  Word("six","temmokka",R.drawable.number_six,R.raw.number_six));
        numbersen.add(new  Word("seven","kenekaku",R.drawable.number_seven,R.raw.number_seven));
        numbersen.add(new  Word("eight","kawinta",R.drawable.number_eight,R.raw.number_eight));
        numbersen.add(new  Word("nine","wo'e",R.drawable.number_nine,R.raw.number_nine));
        numbersen.add(new  Word("ten","na'aacha",R.drawable.number_ten,R.raw.number_ten));


        WordAdapter adapter = new WordAdapter(this, numbersen, R.color.category_numbers);

        WordAdapter itemsAdapter =
                new WordAdapter(this, numbersen, R.color.category_numbers );


        ListView listView =  findViewById(R.id.list);

        listView.setOnItemClickListener ( new AdapterView.OnItemClickListener ( ) {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
              Word word= numbersen.get ( position);
              releaseMediaPlayer ();
                mMediaPlayer = MediaPlayer.create (numbers.this,word.getAudioplayer () );
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
//    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
//        @Override
//        public void onAudioFocusChange(int focusChange) {
//            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
//                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {  // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
//                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
//                // our app is allowed to continue playing sound but at a lower volume. We'll treat
//                // both cases the same way because our app is playing short sound files.
//
//                // Pause playback and reset player to the start of the file. That way, we can
//                // play the word from the beginning when we resume playback.
//                mMediaPlayer.pause();
//                mMediaPlayer.seekTo(0);  } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
//                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
//                mMediaPlayer.start();
//            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
//                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
//                // Stop playback and clean up resources
//                releaseMediaPlayer();
//            }
//        }
//    };


}

/*  String [] numberseng = new String[10];
        numberseng[0]="one";
        numberseng[1]="two";
        numberseng[2]="three";
        numberseng[3]="four";
        numberseng[4]="five";
        numberseng[5]="sex";
        numberseng[6]="seven";
        numberseng[7]="eight";
        numberseng[8]="nine";
        numberseng[9]="ten";*/
//        numbersen.add("one");
//        numbersen.add("two");
//        numbersen.add("three");
//        numbersen.add("four");
//        numbersen.add("five");
//        numbersen.add("sex");
//        numbersen.add("seven");
//        numbersen.add("eight");
//        numbersen.add("nine");
//        numbersen.add("ten");


