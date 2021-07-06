package com.dokidoki;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.Window;

public class UseAll {

    static int request_number_1 = 1; //cherry5_go_main
    static int request_number_2 = 2; //cherry5_go_episode
    //static int request_number_3 = 3; //cherry5_close
    static int request_number_4 = 4; //cherry0_Login
    static int result_number_5 = 5; //cherry0_Login

    static int result_number1 = 1001; //cherry0_login

    static String dbName = "cherry_database";
    static int oldVersion = 0;

    static int width, height;

    static Context mainContext;

    static public MediaPlayer player = null;
    static int playerPosition;
    static int playerNum;
    static boolean playValue = true;


    public static void soundStart(int num){
        if (player == null){
            int music = mainContext.getResources().getIdentifier("soundtrack"+ num, "raw", mainContext.getPackageName());

            playerNum = num;
            player = MediaPlayer.create(UseAll.mainContext, music);
            player.setLooping(true);
            player.start();
        } else if (!player.isPlaying()){

            if (num == playerNum){
                player.seekTo(playerPosition);
                Log.d("tlqkf", "same");
            } else {
                int music = mainContext.getResources().getIdentifier("soundtrack"+ num, "raw", mainContext.getPackageName());

                playerNum = num;
                player = MediaPlayer.create(UseAll.mainContext, music);
                player.setLooping(true);
                Log.d("tlqkf", "difference");
            }

            player.start();

        }
    }

    public static void soundPause(){
        player.pause();
        playerPosition = player.getCurrentPosition();
        Log.d("tlqkf", "soundpause");
    }

    public static void soundStop(){
        player.stop();
        player = null;
        Log.d("tlqkf", "soundstop");
    }

    public static BroadcastReceiver receiver;
    public static IntentFilter intentFilter = new IntentFilter();

    public static Window window;
    public static View 	decorView;
    public static int	uiOption;

    public static void hideNavigationBar() {
        decorView = window.getDecorView();
        uiOption = window.getDecorView().getSystemUiVisibility();
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH )
            uiOption |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN )
            uiOption |= View.SYSTEM_UI_FLAG_FULLSCREEN;
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT )
            uiOption |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
    }

}
