package com.example.android.miwok;

        import androidx.appcompat.app.AppCompatActivity;

        import android.media.MediaPlayer;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ListView;

        import java.util.ArrayList;

public class familyMembers extends AppCompatActivity {

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

        final ArrayList<Word> family = new ArrayList<>();

        family.add(new  Word("father","әpә",R.drawable.family_father,R.raw.family_father));
        family.add(new  Word("mother","әṭa",R.drawable.family_mother,R.raw.family_mother));
        family.add(new  Word("son","angsi",R.drawable.family_son,R.raw.family_son));
        family.add(new  Word("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
        family.add(new  Word("older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        family.add(new  Word("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        family.add(new  Word("older sister","teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        family.add(new  Word("younger sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        family.add(new  Word("grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        family.add(new  Word("grandfather","paapa",R.drawable.family_grandfather,R.raw.family_grandfather));


        WordAdapter adapter = new WordAdapter(this,family, R.color.category_family);

        WordAdapter itemsAdapter =
                new WordAdapter(this, family, R.color.category_family );


        ListView listView =  findViewById(R.id.list);

        listView.setOnItemClickListener ( new AdapterView.OnItemClickListener ( ) {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word= family.get ( position);
                releaseMediaPlayer ();
                mMediaPlayer = MediaPlayer.create (familyMembers.this,word.getAudioplayer () );
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

