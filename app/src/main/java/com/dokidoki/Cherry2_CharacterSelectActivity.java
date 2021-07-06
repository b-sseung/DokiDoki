package com.dokidoki;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Cherry2_CharacterSelectActivity extends AppCompatActivity {

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
        setContentView(R.layout.cherry002_activity_character_select);

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

        TextView back_button = findViewById(R.id.back_button);

        TextView kurosawa_first = findViewById(R.id.character_kurosawa_first);
        TextView kurosawa_select = findViewById(R.id.character_kurosawa_second);
        TextView kurosawa_lock = findViewById(R.id.character_kurosawa_lock);
        TextView kurosawa_lock_no_text = findViewById(R.id.character_kurosawa_lock_no_text);

        TextView chuge_first = findViewById(R.id.character_chuge_first);
        TextView chuge_select = findViewById(R.id.character_chuge_second);
        TextView chuge_lock = findViewById(R.id.character_chuge_lock);
        TextView chuge_lock_no_text = findViewById(R.id.character_chuge_lock_no_text);

        TextView adachi_first = findViewById(R.id.character_adachi_first);
        TextView adachi_select = findViewById(R.id.character_adachi_second);
        TextView adachi_text = findViewById(R.id.adachi_text);

        FrameLayout cherry002_layout = findViewById(R.id.cherry002_layout);
        cherry002_layout.setLayoutParams(new FrameLayout.LayoutParams(UseAll.width, UseAll.height));

        deleteTable2();
        deleteTable3();


        kurosawa_lock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "선택하신 캐릭터는 준비 중입니다.", Toast.LENGTH_LONG).show();
                adachi_select.setVisibility(View.INVISIBLE);
                adachi_text.setVisibility(View.INVISIBLE);
            }
        });

        kurosawa_lock_no_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "선택하신 캐릭터는 준비 중입니다.", Toast.LENGTH_LONG).show();
                adachi_select.setVisibility(View.INVISIBLE);
                adachi_text.setVisibility(View.INVISIBLE);

                kurosawa_lock.setVisibility(View.VISIBLE);
                kurosawa_lock_no_text.setVisibility(View.INVISIBLE);
                chuge_lock.setVisibility(View.VISIBLE);
                chuge_lock_no_text.setVisibility(View.INVISIBLE);
            }
        });


        chuge_lock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "선택하신 캐릭터는 준비 중입니다.", Toast.LENGTH_LONG).show();
                adachi_select.setVisibility(View.INVISIBLE);
                adachi_text.setVisibility(View.INVISIBLE);
            }
        });

        chuge_lock_no_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "선택하신 캐릭터는 준비 중입니다.", Toast.LENGTH_LONG).show();
                adachi_select.setVisibility(View.INVISIBLE);
                adachi_text.setVisibility(View.INVISIBLE);

                kurosawa_lock.setVisibility(View.VISIBLE);
                kurosawa_lock_no_text.setVisibility(View.INVISIBLE);
                chuge_lock.setVisibility(View.VISIBLE);
                chuge_lock_no_text.setVisibility(View.INVISIBLE);
            }
        });


        adachi_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adachi_select.setVisibility(View.VISIBLE);
                adachi_text.setVisibility(View.VISIBLE);

                kurosawa_lock.setVisibility(View.INVISIBLE);
                kurosawa_lock_no_text.setVisibility(View.VISIBLE);
                chuge_lock.setVisibility(View.INVISIBLE);
                chuge_lock_no_text.setVisibility(View.VISIBLE);
            }
        });

        adachi_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.addLevel(UseAll.mainContext, "adachi");

                Intent intent = new Intent(getApplicationContext(), Cherry3_EpisodeSelectActivity.class);
                startActivity(intent);

                overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);

                finish();
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Cherry1_MainActivity.class);
                startActivity(intent);

                overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
            }
        });
    }

    public void deleteTable2(){

        String sql = "delete from " + Cherry_Database.table2;
        Cherry_Database.print(sql);

        database.execSQL(sql);
    }

    public void deleteTable3(){
        String sql = "delete from " + Cherry_Database.table3;
        Cherry_Database.print(sql);

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

    @Override
    public void onBackPressed() {
        UseAll.soundPause();

        Intent intent = new Intent(getApplicationContext(), Cherry1_MainActivity.class);
        startActivity(intent);

        overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);

        finish();
    }
}
