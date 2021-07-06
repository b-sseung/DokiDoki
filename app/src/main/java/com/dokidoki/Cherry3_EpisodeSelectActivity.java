package com.dokidoki;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class Cherry3_EpisodeSelectActivity extends AppCompatActivity implements Cherry3_Episode_Item.OnAdachiEpisodeClickLisner {

    HashMap<Integer, Cherry3_Episode_Item> items = new HashMap<>();

    ImageView[] thumnailImageView, titleImageView, selectImageView;
    ImageView cherry003_episode_background, cherry003_episode_story;

    int position = -1;

    View decorView;
    int	uiOption;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if( hasFocus ) {
            decorView.setSystemUiVisibility(uiOption);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cherry003_activity_adachi_episode_select);

        //상단바 없애기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        decorView = getWindow().getDecorView();
        uiOption = getWindow().getDecorView().getSystemUiVisibility();
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH )
            uiOption |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN )
            uiOption |= View.SYSTEM_UI_FLAG_FULLSCREEN;
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT )
            uiOption |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility( uiOption );

        while (items.isEmpty()) loadAdachiEpicoseData();

        if (UseAll.player != null && UseAll.player.isPlaying()) UseAll.soundStop();
        UseAll.soundStart(1);


        cherry003_episode_background = findViewById(R.id.cherry003_adachi_episode_background);
        cherry003_episode_story = findViewById(R.id.adachi_episode_story);

        TextView cherry3_back_button = findViewById(R.id.cherry3_back_button);

        ProgressBar cherry3_progress = findViewById(R.id.cherry3_progressBar);

        ImageView cherry3_size = findViewById(R.id.cherry3_size);
        LinearLayout cherry3_layout = findViewById(R.id.cherry3_layout);

        cherry3_layout.setLayoutParams(new FrameLayout.LayoutParams(UseAll.width, UseAll.height));
        thumnailImageView = new ImageView[items.size()];
        titleImageView = new ImageView[items.size()];
        selectImageView = new ImageView[items.size()];

        for (int i = 1; i < 7; i++){
            int thumnail = getResources().getIdentifier("cherry003_adachi_episode"+ i + "_thumnail", "id", getApplication().getPackageName());
            int title = getResources().getIdentifier("cherry003_adachi_episode"+ i + "_text", "id", getApplication().getPackageName());
            int select = getResources().getIdentifier("cherry003_adachi_episode"+ i + "_select", "id", getApplication().getPackageName());

            thumnailImageView[i-1] = (ImageView) findViewById(thumnail);
            titleImageView[i-1] = (ImageView) findViewById(title);
            selectImageView[i-1] = (ImageView) findViewById(select);

            boolean value;
            Cherry3_Episode_Item item = items.get(i);

            Log.d("tlqkf", i + " : " + item.getLock());

            if (item.getLock().equals("true")) {
                value = true;

                if (item.getBackground() == 0){
                    thumnailImageView[i-1].setImageResource(item.getThumnail());
                } else {
                    thumnailImageView[i-1].setImageResource(item.getThumnail());
                    titleImageView[i-1].setImageResource(R.drawable.cherry003_adachi_episode_lock_text);
                }

            } else {

                thumnailImageView[i-1].setImageResource(item.getThumnail());
                titleImageView[i-1].setImageResource(item.getText());

                value = false;
            }

            int num = i-1;

            titleImageView[i-1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OnAdachiEpisodeClickLisner(value, item, num);
                    Log.d("tlqkf", "click");
                }
            });
        }

        cherry3_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                if (loadTable3() == 0) {
                    intent = new Intent(getApplicationContext(), Cherry2_CharacterSelectActivity.class);
                } else {
                    intent = new Intent(getApplicationContext(), Cherry1_MainActivity.class);
                }

                startActivity(intent);

                overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
                finish();
            }
        });

        cherry003_episode_story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cherry3_progress.setVisibility(View.VISIBLE);

                Intent intent = new Intent(getApplicationContext(), Cherry1_MainActivity.class);

                if (position == 0){
//                    intent = new Intent(getApplicationContext(), Cherry7_Adachi_Episode1_4.class);
//                    intent = new Intent(getApplicationContext(), Cherry101_AdachiEpisodeClearActivity.class);

                    intent = new Intent(getApplicationContext(), Cherry4_Adachi_Episode1_1.class);
                } else if (position == 1){
                    intent = new Intent(getApplicationContext(), Cherry8_Adachi_Episode2_1.class);
//                    intent = new Intent(getApplicationContext(), Cherry10_Adachi_Episode2_3.class);
                } else if (position == 2){
                    intent = new Intent(getApplicationContext(), Cherry11_Adachi_Episode3_1.class);
//                    intent = new Intent(getApplicationContext(), Cherry14_Adachi_Episode3_4.class);
                }

                startActivity(intent);

                overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
                finish();
            }
        });
    }

    public void loadAdachiEpicoseData(){
        Cherry_Database database = Cherry_Database.getInstance(UseAll.mainContext);

        String sql = "select _id " + " , charactor " + " , number " + " , isLock " + " , background " + " , thumnail " + " , text " + " , story "
                + "from " + Cherry_Database.table2 + " "
                + "order by number asc";

        Log.d("database", sql);

        Cursor cursor = database.rawQuery(sql);
        int recordCound = cursor.getCount();

        Log.d("tlqkf", String.valueOf(recordCound));

        if (recordCound == 0){
            Cherry_Database.addEpisode(UseAll.mainContext, "adachi");
        }

        for (int i = 0; i < recordCound; i++){
            cursor.moveToNext();

            int id = cursor.getInt(0);
            String charactor = cursor.getString(1);
            int number = cursor.getInt(2);
            String isLock = cursor.getString(3);
            int background = cursor.getInt(4);
            int thumnail = cursor.getInt(5);
            int text = cursor.getInt(6);
            int story = cursor.getInt(7);

            Log.d("tlqkf", "episode : " + isLock + ", " + background + ", " + thumnail + ", " + text + ", " + story);

            items.put(number, new Cherry3_Episode_Item(id, charactor, number, isLock, background, thumnail, text, story));
        }
    }

    @Override
    public void OnAdachiEpisodeClickLisner(boolean value, Cherry3_Episode_Item item, int position) {
        if (!value) {
            cherry003_episode_background.setImageResource(item.getBackground());
            cherry003_episode_background.setVisibility(View.VISIBLE);
            cherry003_episode_story.setImageResource(item.getStory());
            cherry003_episode_story.setVisibility(View.VISIBLE);

            for (int i = 0; i < selectImageView.length; i++){
                if (selectImageView[i] != null) selectImageView[i].setVisibility(View.INVISIBLE);
            }

            selectImageView[position].setVisibility(View.VISIBLE);
            Log.d("tlqkf", "p" + position);


            this.position = position;
        } else {
            Log.d("tlqkf", "true");
        }
    }

    public int loadTable3(){
        Cherry_Database database = Cherry_Database.getInstance(UseAll.mainContext);

        String sql = "select charactor, level from " + Cherry_Database.table3;
        Log.d("tlqkf", sql);

        Cursor cursor = database.rawQuery(sql);

        if (cursor.getCount() == 0) return 0;

        cursor.moveToNext();
        return cursor.getInt(1);
    }

    @Override
    protected void onStart() {
        super.onStart();
        UseAll.playValue = true;
        if (UseAll.player != null && !UseAll.player.isPlaying()){
            UseAll.soundStart(UseAll.playerNum);
        }
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        UseAll.playValue = false;
        UseAll.soundPause();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), Cherry1_MainActivity.class);
        startActivity(intent);

        overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
    }
}
