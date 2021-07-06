package com.dokidoki;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Cherry7_Adachi_Episode1_4 extends AppCompatActivity {

    ImageView cherry7_background;
    TextView cherry7_menu_button;

    OutlineTextView cherry7_textView1, cherry7_textView2;

    String[] cherry7_text = new String[]{"신호등을 기다리던 중 또 이상한 소리가 들리기 시작한다.", "'왜 이렇게 늦어?'", //0, 1
            "'회사 가기 싫다'", "'그 인간은 안 잘리나?'", //2, 3
            "어떻게 된 거지?", "지금 들리는 이건 도대체 뭐야?", //4, 5
            "아까 그건 대체 뭐야?", "뭐가 어떻게 된거야 진짜", //6, 7
            "출근한 우라베가 나에게 말을 걸어온다.", "\"좋은 아침이야 30대를 즐겨보자고\"", //8, 9
            "'정말이지 오늘도 아침부터 칙칙하네'", "설마 나...",  //10, 11
            "아니겠지...?", "나는 천천히 우라베에게 다가갔다.", //12, 13
            "'농담도 안 통하고 하지만 아다치는 착하니까", "무리한 업무를 부탁해도 잘 받아주잖아'", //14, 15
            "\"진짜야?\"", "\"왜 그래? 마법사\"", //16, 17
            "\"네?\"", "그 순간 나는 어제 우라베가 말한 것이 떠올랐다.", //18, 19
            "설마..", " 설마!", "내가 진짜 마법사가 된 거야?", // 20, 21, 22
            "알 수 없는 상황에 나는 일단 집으로 돌아갔다.", //23
            "나에게 생긴 이 능력은 다른 사람의 속마음이 들리는 것이었고,", "시간이 지나도 없어지지 않자 점차 밖으로 나가서",
            "누군가를 만나는 일도 줄어들게 되었다." //24, 25, 26
    };

    int[] cherry7_image = new int[]{R.drawable.cherry007_adachi_play_episode1_14_background1, R.drawable.cherry007_adachi_play_episode1_14_background2, //0, 1
            R.drawable.cherry007_adachi_play_episode1_14_background3, R.drawable.cherry007_adachi_play_episode1_14_background4, //2, 3
            R.drawable.cherry007_adachi_play_episode1_14_background5, R.drawable.cherry007_adachi_play_episode1_15_background1, //4, 5
            R.drawable.cherry007_adachi_play_episode1_15_background2, R.drawable.cherry007_adachi_play_episode1_15_background3, //6, 7
            R.drawable.cherry007_adachi_play_episode1_15_background4, R.drawable.cherry007_adachi_play_episode1_15_background5, //8, 9
            R.drawable.cherry007_adachi_play_episode1_15_background6, R.drawable.cherry007_adachi_play_episode1_15_background7, //10, 11
            R.drawable.cherry007_adachi_play_episode1_16_background1, R.drawable.cherry007_adachi_play_episode1_16_background2, //12, 13
            R.drawable.cherry007_adachi_play_episode1_16_background3, R.drawable.cherry007_adachi_play_episode1_16_background4, //14, 15
            R.drawable.cherry007_adachi_play_episode1_16_background5, R.drawable.cherry007_adachi_play_episode1_16_background6, //16, 17
            R.drawable.cherry007_adachi_play_episode1_16_background7, R.drawable.cherry007_adachi_play_episode1_16_background8, //18, 19
            R.drawable.cherry007_adachi_play_episode1_16_background9, R.drawable.adachi_collection002_background //20, 21
    };

    boolean value1 = true, value2 = true, value3 = true, value4 = true, value5 = true, value6 = true, value7 = true,
            value8 = true, value9 = true, value10 = true, value11 = true, value12 = true, value13 = true, value14 = true;

    LinearLayout cherry7_next_button;

    TextView cherry7_case1, cherry7_case2;

    ImageView cherry007_75_black, cherry007_bad_text;
    OutlineTextView cherry007_case2_textView1, cherry007_case2_textView2, cherry007_case2_textView3;
    OutlineTextView cherry007_back_episode, cherry007_count;

    Handler handler = new Handler();
    int episode_number = 0;

    SoundPool sound;
    int soundId, streamId;
    boolean play = false;

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
        setContentView(R.layout.cherry007_activity_adachi_episode1_4);

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

        sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        soundId = sound.load(this, R.raw.shorttypingsound, 1);

        if (UseAll.player != null && UseAll.player.isPlaying()) UseAll.soundStop();
        UseAll.soundStart(4);

        cherry7_background = findViewById(R.id.cherry7_background);
        cherry7_menu_button = findViewById(R.id.cherry7_menu_button);

        cherry7_textView1 = findViewById(R.id.cherry7_textview1);
        cherry7_textView2 = findViewById(R.id.cherry7_textview2);

        cherry7_next_button = findViewById(R.id.cherry7_next_button);

        cherry7_next_button.setVisibility(View.INVISIBLE);

        cherry7_case1 = findViewById(R.id.cherry7_case1);
        cherry7_case2 = findViewById(R.id.cherry7_case2);

        cherry007_bad_text = findViewById(R.id.cherry007_bad_text);
        cherry007_75_black = findViewById(R.id.cherry007_75_black);
        cherry007_case2_textView1 = findViewById(R.id.cherry007_case2_textView1);
        cherry007_case2_textView2 = findViewById(R.id.cherry007_case2_textView2);
        cherry007_case2_textView3 = findViewById(R.id.cherry007_case2_textView3);
        cherry007_back_episode = findViewById(R.id.cherry007_back_episode);
        cherry007_count = findViewById(R.id.cherry007_count);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                episode_number = 1;
                cherry7_next_button.setVisibility(View.VISIBLE);
                Cherry7_Thread1 thread1 = new Cherry7_Thread1();
                thread1.start();
            }
        }, 3000);

        cherry7_menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (episode_number != 2 && episode_number != 4 && episode_number != 8 &&
                        episode_number != 10 && episode_number !=  12&& episode_number !=  14 &&
                        episode_number != 16 && episode_number != 18 && episode_number != 20 &&
                        episode_number != 22 && episode_number != 24){
                    clickFunc();
                }

                Intent intent = new Intent(getApplicationContext(), Cherry100_Episode_Pause.class);
                startActivityForResult(intent, 101);
            }
        });

        cherry7_case1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (episode_number == 6) {
                    cherry7_next_button.setVisibility(View.INVISIBLE);
                    episode_number = 7;
                    cherry7_case1.setVisibility(View.INVISIBLE);
                    cherry7_case2.setVisibility(View.INVISIBLE);
                    cherry7_textView1.setText("");
                    cherry7_textView2.setText("");
                    cherry7_background.setImageResource(cherry7_image[5]);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Cherry7_Thread4 thread4 = new Cherry7_Thread4();
                            thread4.start();
                            cherry7_next_button.setVisibility(View.VISIBLE);
                        }
                    }, 1500);
                }
            }
        });

        cherry7_case2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (episode_number == 6) {
                    cherry7_next_button.setVisibility(View.INVISIBLE);
                    episode_number = 23;
                    cherry7_case1.setVisibility(View.INVISIBLE);
                    cherry7_case2.setVisibility(View.INVISIBLE);
                    cherry7_textView1.setText("");
                    cherry7_textView2.setText("");
                    cherry7_background.setImageResource(cherry7_image[21]);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Cherry7_Thread12 thread12 = new Cherry7_Thread12();
                            thread12.start();
                            cherry7_next_button.setVisibility(View.VISIBLE);
                        }
                    }, 1500);
                }
            }
        });

        cherry007_back_episode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (play) playSound(false);
                value14 = false;
                Intent intent = new Intent(getApplicationContext(), Cherry1_MainActivity.class);
                startActivity(intent);

                overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
            }
        });

        cherry7_next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickFunc();
            }
        });
    }

    public void clickFunc(){
        Log.d("tlqkf", "number : " + episode_number);


        if (episode_number == 1){
            if (play) playSound(false);
            value1 = false;
            cherry7_next_button.setVisibility(View.INVISIBLE);
            episode_number = 2;
            cherry7_background.setImageResource(cherry7_image[1]);
            cherry7_textView1.setText(cherry7_text[0]);
            cherry7_textView2.setText(cherry7_text[1]);
            cherry7_next_button.setVisibility(View.VISIBLE);
//            cherry_testButton.setVisibility(View.VISIBLE);
        } else if (episode_number == 2){
//                    cherry_testButton.setVisibility(View.INVISIBLE);
            cherry7_next_button.setVisibility(View.INVISIBLE);
            episode_number = 3;
            cherry7_textView1.setText("");
            cherry7_textView2.setText("");
            cherry7_background.setImageResource(cherry7_image[2]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry7_Thread2 thread2 = new Cherry7_Thread2();
                    thread2.start();
                    cherry7_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 3){
            if (play) playSound(false);
            value2 = false;
            cherry7_next_button.setVisibility(View.INVISIBLE);
            episode_number = 4;
            cherry7_background.setImageResource(cherry7_image[3]);
            cherry7_textView1.setText(cherry7_text[2]);
            cherry7_textView2.setText(cherry7_text[3]);
            cherry7_next_button.setVisibility(View.VISIBLE);
//            cherry_testButton.setVisibility(View.VISIBLE);
        } else if (episode_number == 4){
//                    cherry_testButton.setVisibility(View.INVISIBLE);
            cherry7_next_button.setVisibility(View.INVISIBLE);
            episode_number = 5;
            cherry7_textView1.setText("");
            cherry7_textView2.setText("");
            cherry7_background.setImageResource(cherry7_image[4]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry7_Thread3 thread3 = new Cherry7_Thread3();
                    thread3.start();
                    cherry7_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 5){
            if (play) playSound(false);
            value3 = false;
            cherry7_next_button.setVisibility(View.INVISIBLE);
            episode_number = 6;
            cherry7_case1.setVisibility(View.VISIBLE);
            cherry7_case2.setVisibility(View.VISIBLE);
            cherry7_background.setImageResource(cherry7_image[4]);
            cherry7_textView1.setText(cherry7_text[4]);
            cherry7_textView2.setText(cherry7_text[5]);
//            cherry_testButton.setVisibility(View.VISIBLE);
        } else if (episode_number == 7){
            if (play) playSound(false);
            value4 = false;
            cherry7_next_button.setVisibility(View.INVISIBLE);
            episode_number = 8;
            cherry7_background.setImageResource(cherry7_image[6]);
            cherry7_textView1.setText(cherry7_text[6]);
            cherry7_textView2.setText(cherry7_text[7]);
            cherry7_next_button.setVisibility(View.VISIBLE);
//            cherry_testButton.setVisibility(View.VISIBLE);
        } else if (episode_number == 8){
            cherry7_next_button.setVisibility(View.INVISIBLE);
            episode_number = 9;
            cherry7_textView1.setText("");
            cherry7_textView2.setText("");
            cherry7_background.setImageResource(cherry7_image[7]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry7_Thread5 thread5 = new Cherry7_Thread5();
                    thread5.start();
                    cherry7_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 9){
            if (play) playSound(false);
            value5 = false;
            cherry7_next_button.setVisibility(View.INVISIBLE);
            episode_number = 10;
            cherry7_background.setImageResource(cherry7_image[8]);
            cherry7_textView1.setText(cherry7_text[8]);
            cherry7_textView2.setText(cherry7_text[9]);
            cherry7_next_button.setVisibility(View.VISIBLE);
//            cherry_testButton.setVisibility(View.VISIBLE);
        } else if (episode_number == 10){
//                    cherry_testButton.setVisibility(View.INVISIBLE);
            cherry7_next_button.setVisibility(View.INVISIBLE);
            episode_number = 11;
            cherry7_textView1.setText("");
            cherry7_textView2.setText("");
            cherry7_background.setImageResource(cherry7_image[9]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry7_Thread6 thread6 = new Cherry7_Thread6();
                    thread6.start();
                    cherry7_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 11){
            if (play) playSound(false);
            value6 = false;
            cherry7_next_button.setVisibility(View.INVISIBLE);
            episode_number = 12;
            cherry7_background.setImageResource(cherry7_image[11]);
            cherry7_textView1.setText(cherry7_text[10]);
            cherry7_textView2.setText(cherry7_text[11]);
            cherry7_next_button.setVisibility(View.VISIBLE);
//            cherry_testButton.setVisibility(View.VISIBLE);
        } else if (episode_number == 12){
//                    cherry_testButton.setVisibility(View.INVISIBLE);
            cherry7_next_button.setVisibility(View.INVISIBLE);
            episode_number = 13;
            cherry7_textView1.setText("");
            cherry7_textView2.setText("");
            cherry7_background.setImageResource(cherry7_image[12]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry7_Thread7 thread7 = new Cherry7_Thread7();
                    thread7.start();
                    cherry7_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 13){
            if (play) playSound(false);
            value7 = false;
            cherry7_next_button.setVisibility(View.INVISIBLE);
            episode_number = 14;
            cherry7_background.setImageResource(cherry7_image[13]);
            cherry7_textView1.setText(cherry7_text[12]);
            cherry7_textView2.setText(cherry7_text[13]);
            cherry7_next_button.setVisibility(View.VISIBLE);
//            cherry_testButton.setVisibility(View.VISIBLE);
        } else if (episode_number == 14){
//                    cherry_testButton.setVisibility(View.INVISIBLE);
            cherry7_next_button.setVisibility(View.INVISIBLE);
            episode_number = 15;
            cherry7_textView1.setText("");
            cherry7_textView2.setText("");
            cherry7_background.setImageResource(cherry7_image[14]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry7_Thread8 thread8 = new Cherry7_Thread8();
                    thread8.start();
                    cherry7_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 15){
            if (play) playSound(false);
            value8 = false;
            cherry7_next_button.setVisibility(View.INVISIBLE);
            episode_number = 16;
            cherry7_textView1.setText(cherry7_text[14]);
            cherry7_textView2.setText(cherry7_text[15]);
            cherry7_next_button.setVisibility(View.VISIBLE);
//            cherry_testButton.setVisibility(View.VISIBLE);
        } else if (episode_number == 16){
//                    cherry_testButton.setVisibility(View.INVISIBLE);
            cherry7_next_button.setVisibility(View.INVISIBLE);
            episode_number = 17;
            cherry7_textView1.setText("");
            cherry7_textView2.setText("");
            cherry7_background.setImageResource(cherry7_image[15]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry7_Thread9 thread9 = new Cherry7_Thread9();
                    thread9.start();
                    cherry7_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 17){
            if (play) playSound(false);
            value9 = false;
            cherry7_next_button.setVisibility(View.INVISIBLE);
            episode_number = 18;
            cherry7_textView1.setText(cherry7_text[16]);
            cherry7_textView2.setText(cherry7_text[17]);
            cherry7_background.setImageResource(cherry7_image[16]);
            cherry7_next_button.setVisibility(View.VISIBLE);
//            cherry_testButton.setVisibility(View.VISIBLE);
        } else if (episode_number == 18){
//                    cherry_testButton.setVisibility(View.INVISIBLE);
            cherry7_next_button.setVisibility(View.INVISIBLE);
            episode_number = 19;
            cherry7_textView1.setText("");
            cherry7_textView2.setText("");
            cherry7_background.setImageResource(cherry7_image[17]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry7_Thread10 thread10 = new Cherry7_Thread10();
                    thread10.start();
                    cherry7_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 19){
            if (play) playSound(false);
            value10 = false;
            cherry7_next_button.setVisibility(View.INVISIBLE);
            episode_number = 20;
            cherry7_textView1.setText(cherry7_text[18]);
            cherry7_textView2.setText(cherry7_text[19]);
            cherry7_next_button.setVisibility(View.VISIBLE);
//            cherry_testButton.setVisibility(View.VISIBLE);
        } else if (episode_number == 20){
//                    cherry_testButton.setVisibility(View.INVISIBLE);
            cherry7_next_button.setVisibility(View.INVISIBLE);
            episode_number = 21;
            cherry7_textView1.setText("");
            cherry7_textView2.setText("");
            cherry7_background.setImageResource(cherry7_image[18]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry7_Thread11 thread11 = new Cherry7_Thread11();
                    thread11.start();
                    cherry7_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 21){
            if (play) playSound(false);
            value11 = false;
            cherry7_next_button.setVisibility(View.INVISIBLE);
            episode_number = 22; //22는 에피소드1 클리어 화면
            cherry7_background.setImageResource(cherry7_image[20]);
            String temp = cherry7_text[20] + cherry7_text[21];
            cherry7_textView1.setText(temp);
            cherry7_textView2.setText(cherry7_text[22]);
            cherry7_next_button.setVisibility(View.VISIBLE);
//            cherry_testButton.setVisibility(View.VISIBLE);
        } else if (episode_number == 22){
            Intent intent = new Intent(getApplicationContext(), Cherry101_AdachiEpisodeClearActivity.class);
            intent.putExtra("position", 1);

            startActivity(intent);

            overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
            finish();
        } else if (episode_number == 23){
            if (play) playSound(false);
            value12 = false;
            cherry7_next_button.setVisibility(View.INVISIBLE);
            episode_number = 24;
            cherry7_textView1.setText(cherry7_text[23]);
            cherry7_next_button.setVisibility(View.VISIBLE);
//            cherry_testButton.setVisibility(View.VISIBLE);
        } else if (episode_number == 24){
            cherry7_next_button.setVisibility(View.INVISIBLE);
            cherry007_75_black.setVisibility(View.VISIBLE);
            cherry007_bad_text.setVisibility(View.VISIBLE);
//            cherry_testButton.setVisibility(View.INVISIBLE);

            Animation inAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.activity_alpha_in);
            cherry007_75_black.startAnimation(inAnim);
            cherry007_bad_text.startAnimation(inAnim);

            cherry007_back_episode.setVisibility(View.VISIBLE);
            cherry7updateDB();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    FrameLayout layout = findViewById(R.id.cherry007_bad_layout);
                    float temp1 = layout.getHeight();
                    float temp2 = cherry007_bad_text.getHeight();
                    float temp = (temp1 - temp2) * -1;

                    TranslateAnimation move = new TranslateAnimation(0, 0, 0, temp);
                    move.setDuration(500);
                    move.setFillAfter(true);
                    move.setAnimationListener(new badAnimListener());
                    cherry007_bad_text.startAnimation(move);

                }
            }, 1000);
        }
    }

    class Cherry7_Thread1 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry7_text[0].split("");
        String[] text2_list = cherry7_text[1].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value1 && !play) playSound(true);

            while (value1 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry7_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value1 && play) playSound(false);

            try {
                if (value1) Thread.sleep(1500);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value1) cherry7_background.setImageResource(cherry7_image[1]);
                    if (value1) cherry7_next_button.setVisibility(View.VISIBLE);

                }
            });

            try {
                if (value1) Thread.sleep(500);
            } catch (Exception e) { }

            if (value1 && !play) playSound(true);

            while (value1 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry7_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value1 && play) playSound(false);

            if (value1) episode_number = 2;
        }
    }

    class Cherry7_Thread2 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry7_text[2].split("");
        String[] text2_list = cherry7_text[3].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value2 && !play) playSound(true);

            while (value2 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry7_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value2 && play) playSound(false);

            try {
                if (value2) Thread.sleep(1500);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value2) cherry7_background.setImageResource(cherry7_image[3]);
                }
            });

            try {
                if (value2) Thread.sleep(500);
            } catch (Exception e) { }

            if (value2 && !play) playSound(true);

            while (value2 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry7_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value2 && play) playSound(false);

            if (value2) episode_number = 4;
        }
    }

    class Cherry7_Thread3 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry7_text[4].split("");
        String[] text2_list = cherry7_text[5].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value3 && !play) playSound(true);

            while (value3 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry7_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value3 && play) playSound(false);

            try {
                if (value3) Thread.sleep(1500);
            } catch (Exception e) { }

            if (value3 && !play) playSound(true);

            while (value3 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry7_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value3 && play) playSound(false);

            if (value3) episode_number = 6;
        }
    }

    class Cherry7_Thread4 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry7_text[6].split("");
        String[] text2_list = cherry7_text[7].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value4 && !play) playSound(true);

            while (value4 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry7_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value4 && play) playSound(false);

            try {
                if (value4) Thread.sleep(1500);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value4) cherry7_background.setImageResource(cherry7_image[6]);
                }
            });

            try {
                if (value4) Thread.sleep(500);
            } catch (Exception e) { }

            if (value4 && !play) playSound(true);

            while (value4 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry7_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value4 && play) playSound(false);

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value4){
                        cherry7_next_button.setVisibility(View.INVISIBLE);
                        cherry7_case1.setVisibility(View.VISIBLE);
                        cherry7_case2.setVisibility(View.VISIBLE);
                    }
                }
            });

            if (value4) episode_number = 8;
        }
    }

    class Cherry7_Thread5 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry7_text[8].split("");
        String[] text2_list = cherry7_text[9].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value5 && !play) playSound(true);

            while (value5 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry7_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value5 && play) playSound(false);

            try {
                if (value5) Thread.sleep(1500);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value5) cherry7_background.setImageResource(cherry7_image[8]);
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value5 && !play) playSound(true);

            while (value5 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry7_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value5 && play) playSound(false);

            if (value5) episode_number = 10;
        }
    }

    class Cherry7_Thread6 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry7_text[10].split("");
        String[] text2_list = cherry7_text[11].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value6 && !play) playSound(true);

            while (value6 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry7_textView1.setText(text1_build.toString());
                text1_time++;

                if (text1_time == text1_list.length/2){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (value6) cherry7_background.setImageResource(cherry7_image[10]);
                        }
                    });
                }
                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value6 && play) playSound(false);

            try {
                if (value6) Thread.sleep(2000);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value6) cherry7_background.setImageResource(cherry7_image[11]);
                }
            });

            try {
                if (value6) Thread.sleep(1500);
            } catch (Exception e) { }

            if (value6 && !play) playSound(true);

            while (value6 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry7_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value6 && play) playSound(false);

            if (value6) episode_number = 12;
        }
    }

    class Cherry7_Thread7 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry7_text[12].split("");
        String[] text2_list = cherry7_text[13].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value7 && !play) playSound(true);

            while (value7 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry7_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value7 && play) playSound(false);

            try {
                if (value7) Thread.sleep(1500);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value7) cherry7_background.setImageResource(cherry7_image[13]);
                }
            });

            try {
                if (value7) Thread.sleep(500);
            } catch (Exception e) { }

            if (value7 && !play) playSound(true);

            while (value7 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry7_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value7 && play) playSound(false);

            if (value7) episode_number = 14;
        }
    }

    class Cherry7_Thread8 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry7_text[14].split("");
        String[] text2_list = cherry7_text[15].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value8 && !play) playSound(true);

            while (value8 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry7_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value8 && play) playSound(false);

            try {
                if (value8) Thread.sleep(1500);
            } catch (Exception e) { }

            if (value8 && !play) playSound(true);

            while (value8 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry7_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value8 && play) playSound(false);

            if (value8) episode_number = 16;
        }
    }

    class Cherry7_Thread9 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry7_text[16].split("");
        String[] text2_list = cherry7_text[17].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value9 && !play) playSound(true);

            while (value9 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry7_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value9 && play) playSound(false);

            try {
                if (value9) Thread.sleep(1500);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value9) cherry7_background.setImageResource(cherry7_image[16]);
                }
            });

            try {
                if (value9) Thread.sleep(500);
            } catch (Exception e) { }

            if (value9 && !play) playSound(true);

            while (value9 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry7_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value9 && play) playSound(false);

            if (value9) episode_number = 18;
        }
    }

    class Cherry7_Thread10 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry7_text[18].split("");
        String[] text2_list = cherry7_text[19].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value10 && !play) playSound(true);

            while (value10 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry7_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value10 && play) playSound(false);

            try {
                if (value10) Thread.sleep(1500);
            } catch (Exception e) { }

            if (value10 && !play) playSound(true);

            while (value10 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry7_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value10 && play) playSound(false);

            if (value10) episode_number = 20;
        }
    }

    class Cherry7_Thread11 extends Thread{
        int text1_time = 0;
        int text2_time = 0;
        int text3_time = 0;

        String[] text1_list = cherry7_text[20].split("");
        String[] text2_list = cherry7_text[21].split("");
        String[] text3_list = cherry7_text[22].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value11 && !play) playSound(true);

            while (value11 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry7_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value11 && play) playSound(false);

            try {
                if (value11) Thread.sleep(2000);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value11) cherry7_background.setImageResource(cherry7_image[19]);
                }
            });

            try {
                if (value11) Thread.sleep(500);
            } catch (Exception e) { }

            if (value11 && !play) playSound(true);

            while (value11 && text2_time < text2_list.length){
                text1_build.append(text2_list[text2_time]);
                cherry7_textView1.setText(text1_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value11 && play) playSound(false);

            try {
                if (value11) Thread.sleep(2000);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value11) cherry7_background.setImageResource(cherry7_image[20]);
                }
            });

            try {
                if (value11) Thread.sleep(500);
            } catch (Exception e) { }

            if (value11 && !play) playSound(true);

            while (value11 && text3_time < text3_list.length){
                text2_build.append(text3_list[text3_time]);
                cherry7_textView2.setText(text2_build.toString());
                text3_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value11 && play) playSound(false);

            if (value11) episode_number = 22;
        }
    }

    class Cherry7_Thread12 extends Thread{
        int text1_time = 0;

        String[] text1_list = cherry7_text[23].split("");

        StringBuilder text1_build = new StringBuilder();

        @Override
        public void run() {

            if (value12 && !play) playSound(true);

            while (value12 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry7_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value12 && play) playSound(false);

            if (value12) episode_number = 24;
        }
    }

    class Cherry7_Thread13 extends Thread{
        int text1_time = 0;
        int text2_time = 0;
        int text3_time = 0;

        String[] text1_list = cherry7_text[24].split("");
        String[] text2_list = cherry7_text[25].split("");
        String[] text3_list = cherry7_text[26].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();
        StringBuilder text3_build = new StringBuilder();

        @Override
        public void run() {

            if (value13 && !play) playSound(true);

            while (value13 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry007_case2_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value13 && play) playSound(false);

            if (value13 && !play) playSound(true);

            while (value13 && text2_time < text2_list.length) {
                text2_build.append(text2_list[text2_time]);
                cherry007_case2_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value13 && play) playSound(false);

            if (value13 && !play) playSound(true);

            while (value13 && text3_time < text3_list.length) {
                text3_build.append(text3_list[text3_time]);
                cherry007_case2_textView3.setText(text3_build.toString());
                text3_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value13 && play) playSound(false);

            handler.post(new Runnable() {
                @Override
                public void run() {
//                    if (value13) cherry_testButton.setVisibility(View.VISIBLE);
                    if (value13) cherry007_back_episode.setVisibility(View.VISIBLE);
                }
            });

            Cherry7_Thread14 thread14 = new Cherry7_Thread14();
            thread14.start();
        }
    }

    class Cherry7_Thread14 extends Thread{
        int text1_time = 60;

        String text = "초 후에 자동으로 이동합니다.";

        @Override
        public void run() {
            while (value14 && text1_time > 0) {
                cherry007_count.setText(text1_time + text);
                try {
                    Thread.sleep(1000);
                } catch (Exception e){ }

                text1_time--;
            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value14) {

                        Intent intent = new Intent(getApplicationContext(), Cherry1_MainActivity.class);
                        startActivity(intent);

                        overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
                        finish();
                    }
                }
            });
        }
    }

    public void cherry7updateDB(){
        Cherry_Database database = Cherry_Database.getInstance(UseAll.mainContext);

        String sql = "UPDATE " +  Cherry_Database.table1 + " SET isLock='false' WHERE charactor = 'adachi' and number = 2" ;
        database.execSQL(sql) ;
    }



    class badAnimListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            Cherry7_Thread13 thread13 = new Cherry7_Thread13();
            thread13.start();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }

    public void playSound(boolean value){
        if (value){
            streamId = sound.play(soundId, 1.0F, 1.0F, 1, -1, 1.0F);
            play = true;
        } else {
            sound.stop(streamId);
            play = false;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101){
            if (resultCode == UseAll.request_number_1){
                Intent intent = new Intent(getApplicationContext(),Cherry1_MainActivity.class);
                startActivity(intent);

                overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
                finish();
            } else if (resultCode == UseAll.request_number_2){
                Intent intent = new Intent(getApplicationContext(),Cherry3_EpisodeSelectActivity.class);
                startActivity(intent);

                overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
                finish();
            }
        }
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

        Intent intent = new Intent(getApplicationContext(), Cherry100_Episode_Pause.class);
        startActivityForResult(intent, 101);

    }
}
