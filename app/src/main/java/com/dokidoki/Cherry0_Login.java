package com.dokidoki;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class Cherry0_Login extends AppCompatActivity {

    ImageView cherry0_yes_button, cherry0_no_button;
    EditText cherry0_edit_id, cherry0_edit_pw;

    HashMap<String, String> data = new HashMap<>();

    View decorView;
    int	uiOption;

    Intent intent;

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
        setContentView(R.layout.cherry000_login_activity);

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


        cherry0_yes_button = findViewById(R.id.cherry000_yes_button);
        cherry0_no_button = findViewById(R.id.cherry000_no_button);

        cherry0_edit_id = findViewById(R.id.cherry0_edit_id);
        cherry0_edit_pw = findViewById(R.id.cherry0_edit_pw);

        while (data.isEmpty()) loadTable4();

        intent = new Intent();

        Log.d("tlqkf", "hashmap : " + data.size());
        cherry0_yes_button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                String edit_id = cherry0_edit_id.getText().toString();
                String edit_pw = cherry0_edit_pw.getText().toString();

                String temp = data.getOrDefault(edit_id, "NULL");
                UseAll.playValue = false;

                Log.d("tlqkf", temp);

                if (temp.equals("NULL")){
                    Log.d("tlqkf", temp);
                    func();
                } else {
                    if (!temp.equals(edit_pw)){
                        Log.d("tlqkf", edit_pw);
                        func();
                    } else {
                        addLogin(edit_id, edit_pw);
                        finish();
                    }
                }
            }
        });

        cherry0_no_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cherry0_edit_id.setText("");
                cherry0_edit_pw.setText("");
            }
        });
    }

    @Override
    public void onBackPressed() {
        setResult(UseAll.result_number_5, intent);
        finish();
    }


    public void addLogin(String id, String pw){
        Cherry_Database database = Cherry_Database.getInstance(UseAll.mainContext);

        String sql = "insert into " + Cherry_Database.table5 +  "(number, login_id, login_password) values (" +
                "'" + 1 + "', " +
                "'" + id + "', " +
                "'" + pw + "')";

        database.execSQL(sql);
    }

    public void func(){
        Intent intent = new Intent(getApplicationContext(), Cherry0_Login_Error.class);
        startActivity(intent);

        overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
    }

    public void loadTable4(){
        Cherry_Database database = Cherry_Database.getInstance(UseAll.mainContext);

        String sql = "select login_id, login_password "
                + "from " + Cherry_Database.table4;

        Cursor cursor = database.rawQuery(sql);
        int recordCound = 0;

        try{
            recordCound = cursor.getCount();
        } catch (Exception ex){
            Cherry_Database.addIdPassWord(UseAll.mainContext);
        }

        Log.d("tlqkf", String.valueOf(recordCound));

        if (recordCound == 0){
            Cherry_Database.addIdPassWord(UseAll.mainContext);
        }


        for (int i = 0; i < recordCound; i++){

            cursor.moveToNext();

            String login_id = cursor.getString(0);
            String login_pw = cursor.getString(1);

            data.put(login_id, login_pw);
        }

    }


    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        Log.d("tlqkf", "home");
        UseAll.soundPause();
    }
}
