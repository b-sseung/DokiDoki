package com.dokidoki;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Cherry100_Episode_Pause extends AppCompatActivity {

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
        setContentView(R.layout.cherry100_activity_episode_menu);

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

        ImageView cherry5_top_no_text = findViewById(R.id.cherry5_top_no_text);
        ImageView cherry5_top_text = findViewById(R.id.cherry5_top_text);

        ImageView cherry5_go_main_button = findViewById(R.id.cherry5_go_main_button);
        ImageView cherry5_go_episode_button = findViewById(R.id.cherry5_go_episode_button);
        ImageView cherry5_close_button = findViewById(R.id.cherry5_close_button);

        cherry5_go_main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(UseAll.request_number_1);

                overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
                finish();

            }
        });

        cherry5_go_episode_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(UseAll.request_number_2);

                overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
                finish();

            }
        });

        cherry5_close_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
                UseAll.soundStart(UseAll.playerNum);
                finish();

            }
        });
    }

    @Override
    public void onBackPressed() {
        UseAll.soundStart(UseAll.playerNum);

        finish();
    }
}
