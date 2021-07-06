package com.dokidoki;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Cherry1_MainActivity extends AppCompatActivity {

    Cherry_Database database;
    ProgressBar cherry001_progressBar;

    boolean StartOrReset = true;
    int level = 0;
    boolean value = true;

    ImageView mainImage;

    View decorView;
    int	uiOption;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.d("tlqkf", mainImage.getWidth() + ", " + mainImage.getHeight());
        UseAll.width = mainImage.getWidth();
        UseAll.height = mainImage.getHeight();

        if( hasFocus ) {
            decorView.setSystemUiVisibility(uiOption);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cherry001_activity_main);

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


        if (UseAll.mainContext == null) UseAll.mainContext = this;
        database = Cherry_Database.getInstance(UseAll.mainContext);
        database.open();

        cherry001_progressBar = findViewById(R.id.cherry001_progressBar);

        TextView startButton = findViewById(R.id.main_start_button);
        TextView restartButton = findViewById(R.id.main_restart_button);
        TextView collectionButton = findViewById(R.id.main_collection_button);

        if (UseAll.player != null && UseAll.player.isPlaying()) UseAll.soundStop();
        UseAll.soundStart(1);

        loadTable1();
        loadTable5();

        Cherry_Database_Update.updateTable1();

        if (value){
            Intent intent = new Intent(getApplicationContext(), Cherry0_Login.class);
            startActivityForResult(intent, UseAll.request_number_4);

            overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
        }

        if (loadTable2() != 0){
            restartButton.setVisibility(View.VISIBLE);
            Cherry_Database_Update.updateAdachiTable2();
        } else {
            restartButton.setVisibility(View.INVISIBLE);
        }

        String name = loadTable2Charactor();
        level = loadTable3();

        UseAll.intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        UseAll.intentFilter.addAction(Intent.ACTION_SCREEN_ON);

        UseAll.receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF) ) {
//                    Log.d("Broadcast Test", "SCREEN_OFF");
                    if (UseAll.player != null && UseAll.player.isPlaying()) UseAll.soundPause();
                } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON) ) {
//                    Log.d("Broadcast Test", "SCREEN_ON");
                    if (UseAll.playValue) UseAll.soundStart(UseAll.playerNum);
                }
            }
        };

        registerReceiver(UseAll.receiver, UseAll.intentFilter);

        mainImage = findViewById(R.id.imageView);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;

                Log.d("tlqkf", "start : " + StartOrReset + ", " + level);

                if (StartOrReset) {
                    intent = new Intent(getApplicationContext(), Cherry2_CharacterSelectActivity.class);
                } else {
                    intent = new Intent(getApplicationContext(), Cherry103_New_StartMessage.class);
                }

                startActivity(intent);

                overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
            }
        });

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Cherry1_MainActivity.class);

                if (name.equals("adachi")){
                    intent = new Intent(getApplicationContext(), Cherry3_EpisodeSelectActivity.class);
                } else if (name.equals("kurosawa")){

                } else if (name.equals("chuge")){

                }

                startActivity(intent);

                overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
                finish();
            }
        });

        collectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cherry001_progressBar.setVisibility(View.VISIBLE);
                
                Intent intent = new Intent(getApplicationContext(), Cherry2_CollectionActivity.class);
                startActivity(intent);

                overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
                finish();
            }
        });
    }

    public void loadTable1(){

        String sql = "select _id " + " , charactor " + " , number " + " , isLock " + " , background " + " , text "
                + "from " + Cherry_Database.table1 + " "
                + "order by number asc";

        Log.d("database", sql);

        Cursor cursor = database.rawQuery(sql);
        int recordCound = cursor.getCount();

        Log.d("tlqkf", String.valueOf(recordCound));

        if (recordCound == 0) {
            Cherry_Database.addTable1Data(UseAll.mainContext);
        }
    }

    public int loadTable2(){

        String sql = "select _id from " + Cherry_Database.table2;

        Log.d("tlqkf", sql);
        Cursor cursor = database.rawQuery(sql);

        try{
            return cursor.getCount();
        } catch (Exception e) {
            return 0;
        }
    }

    public String loadTable2Charactor(){

        String sql = "select charactor from " + Cherry_Database.table2;

        Log.d("tlqkf", sql);

        Cursor cursor = database.rawQuery(sql);

        if (cursor.getCount() > 0) StartOrReset = false;

        if (cursor.getCount() == 0) return "";

        cursor.moveToNext();

        Log.d("tlqkf", "charactor : " + cursor.getString(0) + ", " + cursor.getCount());
        return cursor.getString(0);
    }

    public int loadTable3(){
        String sql = "select charactor, level from " + Cherry_Database.table3;
        Log.d("tlqkf", sql);

        Cursor cursor = database.rawQuery(sql);

        if (cursor.getCount() == 0) return 0;

        cursor.moveToNext();
        return cursor.getInt(1);
    }

    public void loadTable5() {
        String sql = "select login_id, login_password from " + Cherry_Database.table5;
        Log.d("tlqkf", sql);

        Cursor cursor = database.rawQuery(sql);

        try {
            if (cursor.getCount() > 0) {
                value = false;
            } else {
                value = true;
            }
        } catch (Exception ex) {
            value = true;
        }

        Log.d("tlqkf", "value : " + value);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode== UseAll.result_number1){
            finish();
        } else if (requestCode == UseAll.request_number_4){
            if (resultCode == 5){
                finish();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        UseAll.playValue = true;
        Log.d("tlqkf", "start");
        if (UseAll.player != null && !UseAll.player.isPlaying()){
            UseAll.soundStart(UseAll.playerNum);
            Log.d("tlqkf", "new Sound");
        }
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        UseAll.playValue = false;
        Log.d("tlqkf", "home");
        UseAll.soundPause();
    }

    @Override
    public void onBackPressed() {
        ActivityCompat.finishAffinity(this);
        System.exit(0);
    }
}