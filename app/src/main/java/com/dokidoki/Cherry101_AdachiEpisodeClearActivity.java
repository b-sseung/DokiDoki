package com.dokidoki;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class Cherry101_AdachiEpisodeClearActivity extends AppCompatActivity {

    OutlineTextView cherry011_clear_main, cherry011_clear_next;

    int last = 0, next = 0;

    int last_thumnail = 0;

    ImageView cherry101_title, cherry101_background;

    int[] title = new int[]{R.drawable.cherry004_adachi_play_episode1_title, R.drawable.cherry008_adachi_play_episode2_title,
                            R.drawable.cherry011_adachi_play_episode3_title};
    boolean value = false;
    int level = 0;

    HashMap<Integer, Cherry3_Episode_Item> array = new HashMap<>();

    Cherry_Database database = Cherry_Database.getInstance(UseAll.mainContext);

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
        setContentView(R.layout.cherry101_episode_clear);

        //상단바 없애기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //네비게이션바 없애기
        decorView = getWindow().getDecorView();
        uiOption = getWindow().getDecorView().getSystemUiVisibility();
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH )
            uiOption |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN )
            uiOption |= View.SYSTEM_UI_FLAG_FULLSCREEN;
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT )
            uiOption |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility( uiOption );

        cherry011_clear_main = findViewById(R.id.cherry011_clear_main);
        cherry011_clear_next = findViewById(R.id.cherry011_clear_next);

        cherry101_background = findViewById(R.id.cherry101_background);
        cherry101_title = findViewById(R.id.cherry101_title);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", -1);

        checkLastLock();

        level = loadLevel();
        if (level < position) updateLevel(position);

        if (title.length >= position+1) {
            if (array.get(position+1).getLock().equals("true")){
                OpenNextEpisode(position+1);
                array.get(position+1).setLock("false");
            }
            value = true;
        }

        cherry101_background.setImageResource(array.get(position).getBackground());
        cherry101_title.setImageResource(title[position-1]);

        if (UseAll.player != null && UseAll.player.isPlaying()) UseAll.soundStop();
        UseAll.soundStart(9);

        cherry011_clear_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Cherry1_MainActivity.class);
                startActivity(intent1);

                overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
                finish();
            }
        });

        cherry011_clear_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("tiqkf", "position : " + position + ", " + array.get(position+1).getLock());

                if (value && array.get(position+1).getLock().equals("false")) {
                    if (position == 1){
                        Intent intent = new Intent(getApplicationContext(), Cherry8_Adachi_Episode2_1.class);
                        startActivity(intent);

                        overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
                        finish();
                    } else if (position == 2){
                        Intent intent = new Intent(getApplicationContext(), Cherry11_Adachi_Episode3_1.class);
                        startActivity(intent);

                        overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
                        finish();
                    }
                } else {
                    Intent intent = new Intent(getApplicationContext(), Cherry102_No_NextEpisode.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void checkLastLock(){

        String sql = "select _id, charactor, number, isLock, background, thumnail, text, story "
                + " from " + Cherry_Database.table2 + " WHERE charactor = 'adachi' " + "order by number asc";

        database.execSQL(sql);

        Cursor cursor = database.rawQuery(sql);
        int recordCound = cursor.getCount();

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

            array.put(number, new Cherry3_Episode_Item(id, charactor, number, isLock, background, thumnail, text, story));
        }

    }

    public void updateLevel(int position){
        String sql = "UPDATE " + Cherry_Database.table3 + " SET level = " + position + " WHERE charactor = 'adachi'";
        database.execSQL(sql);
    }

    public int loadLevel(){
        String sql = "select charactor, level " + " from " + Cherry_Database.table3;
        database.execSQL(sql);

        Cursor cursor = database.rawQuery(sql);

        cursor.moveToNext();

        return cursor.getInt(1);
    }

    public void OpenNextEpisode(int position){

        String sql = "UPDATE " +  Cherry_Database.table2 + " SET isLock='false' WHERE charactor = 'adachi' and number = " + position;
        database.execSQL(sql);
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

}
