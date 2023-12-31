package com.example.android.miwok;

        import androidx.appcompat.app.AppCompatActivity;

        import android.media.MediaPlayer;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ListView;

        import java.util.ArrayList;

public class phrases extends AppCompatActivity {

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

        final ArrayList<Word> phrases = new ArrayList<>();

        phrases.add(new  Word("Where are you going?","minto wuksus",R.raw.phrase_where_are_you_going));
        phrases.add(new  Word("What is your name?","tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        phrases.add(new  Word("My name is...","oyaaset...",R.raw.phrase_my_name_is));
        phrases.add(new  Word("How are you feeling?","michәksәs?",R.raw.phrase_how_are_you_feeling));
        phrases.add(new  Word("I’m feeling good.","kuchi achit",R.raw.phrase_im_feeling_good));
        phrases.add(new  Word("Are you coming?","әәnәs'aa?",R.raw.phrase_are_you_coming));
        phrases.add(new  Word("Yes, I’m coming.","hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        phrases.add(new  Word("I’m coming.","әәnәm",R.raw.phrase_im_coming));
        phrases.add(new  Word("Let’s go.","yoowutis",R.raw.phrase_lets_go));
        phrases.add(new  Word("Come here.","әnni'nem",R.raw.phrase_come_here));


        WordAdapter adapter = new WordAdapter(this,phrases, R.color.category_phrases);

        WordAdapter itemsAdapter =
                new WordAdapter(this, phrases, R.color.category_phrases );


        ListView listView =  findViewById(R.id.list);

        listView.setOnItemClickListener ( new AdapterView.OnItemClickListener ( ) {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word= phrases.get ( position);
                releaseMediaPlayer ();
                mMediaPlayer = MediaPlayer.create (phrases.this,word.getAudioplayer () );
                mMediaPlayer.start ();
                mMediaPlayer.setOnCompletionListener ( mCompletionListener );
            }
        });


        listView.setAdapter(itemsAdapter);


    }
    private void releaseMediaPlayer(){
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

