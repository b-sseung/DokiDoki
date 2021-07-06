package com.dokidoki;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
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

public class Cherry6_Adachi_Episode1_3 extends AppCompatActivity {

    int episode_number = 0;

    ImageView cherry6_background, cherry6_background2, cherry6_introduce_chuge, cherry_testButton, cherry006_case1_message;

    ImageView cherry006_normal_text, cherry006_75_black;
    OutlineTextView cherry006_case2_textView1, cherry006_case2_textView2, cherry006_case2_textView3;

    TextView cherry6_menu_button;
    LinearLayout cherry6_next_button;

    OutlineTextView cherry6_textView1, cherry6_textView2;
    OutlineTextView cherry6_case2_textView1, cherry6_case2_textView2, cherry6_case2_textView3;
    TextView cherry6_case1, cherry6_case2, cherry6_case3, cherry6_case4;

    OutlineTextView cherry006_count, cherry006_back_episode;

    String[] cherry6_text = new String[]{"삐비비비비비----", "굿바이 20대의 나, ", "안녕 30대의 나", //0, 1, 2
                                    "생일 축하 메세지는", "엄마와 츠게가 보낸 두 개 뿐", //3, 4
                                    "이걸로 내 생일 이벤트는 끝", "서른이 되어도 20대 때와 똑같은 하루가 시작된다.", //5, 6
                                    "\"분명 읽었는데 답장이 왜 없지?\"",  "나름 나를 신경써서 문자를 보냈던 츠게는", "며칠이 지나도 답이 없는 나에게 화가 났고,", //7, 8, 9
                                    "나는 그의 화를 풀어주기 위해 그 날 야근을 하지 못했다.", //10
                                    "이제 출근 준비 해야겠다.", //11
                                    "출근하는 길에 항상 사먹는 치킨마요와 참치마요 주먹밥을 사러 왔다.", "\"네, 280엔입니다.\"", //12, 13
                                    "\"500엔 받았습니다.\"", "'왔다 더블 마요'", //14, 15
                                    "방금 뭐지?", //16
                                    "\"....네? 방금 그 말은... 뭔가요?\"", "\"무슨 말이요?\"", //17, 18
                                    "내가 잘못 들은건가..?", "나는 도망치듯이 주먹밥 가게를 벗어났다." //19, 20
                                    };

    boolean value1 = true, value2 = true, value3 = true, value4 = true, value5 = true, value6 = true,
            value7 = true, value8 = true, value9 = true, value10 = true, value11 = true;


    int[] cherry6_image = new int[]{R.drawable.cherry006_adachi_play_episode1_11_background1, R.drawable.cherry006_adachi_play_episode1_11_background2, //0, 1
                    R.drawable.cherry006_adachi_play_episode1_12_background1, R.drawable.cherry006_adachi_play_episode1_12_background2, //2, 3
                    R.drawable.cherry006_adachi_play_episode1_12_case1_background1, R.drawable.cherry006_adachi_play_episode1_12_case1_background2, //4, 5
                    R.drawable.cherry006_adachi_play_episode1_13_background1, R.drawable.cherry006_adachi_play_episode1_13_background2, //6, 7
                    R.drawable.cherry006_adachi_play_episode1_13_background3, R.drawable.cherry006_adachi_play_episode1_13_background4, //8, 9
                    R.drawable.cherry006_adachi_play_episode1_13_background5,  R.drawable.cherry006_adachi_play_episode1_13_case1_background1, //10, 11
                    R.drawable.cherry006_adachi_play_episode1_13_case1_background2, R.drawable.cherry006_adachi_play_episode1_13_case2_background1 //12, 13
                    };

    Handler handler = new Handler();

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
        setContentView(R.layout.cherry006_activity_adachi_episode1_3);

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

        cherry6_background = findViewById(R.id.cherry6_background);
        cherry6_background2 = findViewById(R.id.cherry6_background2);
        cherry6_menu_button = findViewById(R.id.cherry6_menu_button);
        cherry6_next_button = findViewById(R.id.cherry6_next_button);

        cherry6_case2_textView1 = findViewById(R.id.cherry006_case2_textView1);
        cherry6_case2_textView2 = findViewById(R.id.cherry006_case2_textView2);
        cherry6_case2_textView3 = findViewById(R.id.cherry006_case2_textView3);

        cherry6_textView1 = findViewById(R.id.cherry6_textview1);
        cherry6_textView2 = findViewById(R.id.cherry6_textview2);
        cherry6_case1 = findViewById(R.id.cherry6_case1);
        cherry6_case2 = findViewById(R.id.cherry6_case2);
        cherry6_case3 = findViewById(R.id.cherry6_case3);
        cherry6_case4 = findViewById(R.id.cherry6_case4);

        cherry6_introduce_chuge = findViewById(R.id.cherry6_introduce_chuge);
        cherry006_case1_message = findViewById(R.id.cherry006_case1_message);

        cherry006_normal_text = findViewById(R.id.cherry006_normal_text);
        cherry006_75_black = findViewById(R.id.cherry006_75_black);
        cherry006_case2_textView1 = findViewById(R.id.cherry006_case2_textView1);
        cherry006_case2_textView2 = findViewById(R.id.cherry006_case2_textView2);
        cherry006_case2_textView3 = findViewById(R.id.cherry006_case2_textView3);

        cherry006_count = findViewById(R.id.cherry006_count);
        cherry006_back_episode = findViewById(R.id.cherry006_back_episode);

//        cherry_testButton = findViewById(R.id.cherry_testButton);

//        cherry_testButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                episode_number -= 2;
//                clickFunc(episode_number);
//            }
//        });

        cherry6_next_button.setVisibility(View.INVISIBLE);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                episode_number = 1;
                cherry6_next_button.setVisibility(View.VISIBLE);
                Cherry6_Thread1 thread1 = new Cherry6_Thread1();
                thread1.start();
            }
        }, 3000);

        cherry6_menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (episode_number != 2 && episode_number != 6 && episode_number != 11 &&
                        episode_number != 13 && episode_number != 15 && episode_number != 18) {
                    clickFunc();
                }
                Intent intent = new Intent(getApplicationContext(), Cherry100_Episode_Pause.class);
                startActivityForResult(intent, 101);
            }
        });

        cherry006_back_episode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value5 = false;
                value6 = false;
                if (play) playSound(false);

                Intent intent = new Intent(getApplicationContext(), Cherry1_MainActivity.class);
                startActivity(intent);

                overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
            }
        });

        cherry6_case1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (episode_number == 4) {
//                    cherry_testButton.setVisibility(View.INVISIBLE);
                    cherry6_next_button.setVisibility(View.INVISIBLE);
                    episode_number = 5;
                    cherry6_case1.setVisibility(View.INVISIBLE);
                    cherry6_case2.setVisibility(View.INVISIBLE);

                    cherry6_textView1.setText("");
                    cherry6_textView2.setText("");
                    cherry6_background.setImageResource(cherry6_image[4]);

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Cherry6_Thread3 thread3 = new Cherry6_Thread3();
                            thread3.start();
                            cherry6_next_button.setVisibility(View.VISIBLE);
                        }
                    }, 1500);
                }
            }
        });

        cherry6_case2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (episode_number == 4) {
//                    cherry_testButton.setVisibility(View.INVISIBLE);
                    cherry6_next_button.setVisibility(View.INVISIBLE);
                    episode_number = 7;
                    cherry6_case1.setVisibility(View.INVISIBLE);
                    cherry6_case2.setVisibility(View.INVISIBLE);

                    cherry6_textView1.setText("");
                    cherry6_textView2.setText("");
                    cherry6_background.setImageResource(cherry6_image[4]);

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Cherry6_Thread4 thread4 = new Cherry6_Thread4();
                            thread4.start();
                            cherry6_next_button.setVisibility(View.VISIBLE);
                        }
                    }, 1500);
                }
            }
        });

        cherry6_case3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                episode_number = 17;
                cherry6_case3.setVisibility(View.INVISIBLE);
                cherry6_case4.setVisibility(View.INVISIBLE);
                cherry6_next_button.setVisibility(View.VISIBLE);
                cherry6_textView1.setText("");
                cherry6_textView2.setText("");
                cherry6_background.setImageResource(cherry6_image[11]);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Cherry6_Thread11 thread11 = new Cherry6_Thread11();
                        thread11.start();
                        cherry6_next_button.setVisibility(View.VISIBLE);
                    }
                }, 1500);
            }
        });

        cherry6_case4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                episode_number = 16;
                cherry6_case3.setVisibility(View.INVISIBLE);
                cherry6_case4.setVisibility(View.INVISIBLE);
                cherry6_textView1.setText("");
                cherry6_textView2.setText("");
                cherry6_background.setImageResource(cherry6_image[13]);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Cherry6_Thread10 thread10 = new Cherry6_Thread10();
                        thread10.start();
                        cherry6_next_button.setVisibility(View.VISIBLE);
                    }
                }, 1500);
            }
        });

        cherry6_next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickFunc();
            }
        });
    }

    public void clickFunc(){
        if (episode_number == 1){
            if (play) playSound(false);
            value1 = false;
            cherry6_next_button.setVisibility(View.INVISIBLE);
            episode_number = 2;
            cherry6_textView1.setText(cherry6_text[0]);
            cherry6_textView2.setText(cherry6_text[1] + cherry6_text[2]);
            cherry6_next_button.setVisibility(View.VISIBLE);
//            cherry_testButton.setVisibility(View.VISIBLE);
        } else if (episode_number == 2){
//            cherry_testButton.setVisibility(View.INVISIBLE);
            cherry6_next_button.setVisibility(View.INVISIBLE);
            episode_number = 3;
            cherry6_textView1.setText("");
            cherry6_textView2.setText("");
            cherry6_background.setImageResource(cherry6_image[3]);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry6_Thread2 thread2 = new Cherry6_Thread2();
                    thread2.start();
                    cherry6_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 3) {
            if (play) playSound(false);
            cherry6_next_button.setVisibility(View.INVISIBLE);
            value2 = false;
            episode_number = 4;
            cherry6_textView1.setText(cherry6_text[3]);
            cherry6_textView2.setText(cherry6_text[4]);
            cherry6_case1.setVisibility(View.VISIBLE);
            cherry6_case2.setVisibility(View.VISIBLE);
            cherry6_background2.clearAnimation();
            if (cherry6_background2.getVisibility() == View.VISIBLE)
                cherry6_background2.setVisibility(View.INVISIBLE);
//            cherry_testButton.setVisibility(View.VISIBLE);
        } else if (episode_number == 5) {
            if (play) playSound(false);
            value3 = false;
            cherry6_next_button.setVisibility(View.INVISIBLE);
            episode_number = 6;
            cherry6_background.setImageResource(cherry6_image[5]);
            cherry6_textView1.setText(cherry6_text[5]);
            cherry6_textView2.setText(cherry6_text[11]);
            cherry6_next_button.setVisibility(View.VISIBLE);
            cherry6_introduce_chuge.setVisibility(View.INVISIBLE);
            cherry006_case1_message.setVisibility(View.VISIBLE);
//            cherry_testButton.setVisibility(View.VISIBLE);
        } else if (episode_number == 7){
            if (play) playSound(false);
            value4 = false;
            cherry6_next_button.setVisibility(View.INVISIBLE);
            episode_number = 8;
            cherry6_textView1.setText(cherry6_text[7]);
            cherry6_textView2.setText("");
            cherry6_next_button.setVisibility(View.VISIBLE);
            cherry6_introduce_chuge.setVisibility(View.INVISIBLE);
//            cherry_testButton.setVisibility(View.VISIBLE);
        } else if (episode_number == 8) {
            cherry6_next_button.setVisibility(View.INVISIBLE);
            cherry006_75_black.setVisibility(View.VISIBLE);
            cherry006_normal_text.setVisibility(View.VISIBLE);
//            cherry_testButton.setVisibility(View.INVISIBLE);

            Animation inAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.activity_alpha_in);
            cherry006_75_black.startAnimation(inAnim);
            cherry006_normal_text.startAnimation(inAnim);

            cherry006_back_episode.setVisibility(View.VISIBLE);
            updateDB();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    FrameLayout layout = findViewById(R.id.cherry006_normal_layout);
                    float temp1 = layout.getHeight();
                    float temp2 = cherry006_normal_text.getHeight();
                    float temp = (temp1 - temp2) * -1;

                    TranslateAnimation move = new TranslateAnimation(0, 0, 0, temp);
                    move.setDuration(500);
                    move.setFillAfter(true);
                    move.setAnimationListener(new normalAnimListener());
                    cherry006_normal_text.startAnimation(move);

                }
            }, 1000);
        } else if (episode_number == 6){
//            cherry_testButton.setVisibility(View.INVISIBLE);
            cherry6_next_button.setVisibility(View.INVISIBLE);
            episode_number = 10;
            cherry6_textView1.setText("");
            cherry6_textView2.setText("");
            cherry6_background.setImageResource(cherry6_image[6]);
            cherry006_case1_message.setVisibility(View.INVISIBLE);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry6_Thread7 thread7 = new Cherry6_Thread7();
                    thread7.start();
                    cherry6_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 10) {
            if (play) playSound(false);
            value7 = false;
            cherry6_next_button.setVisibility(View.INVISIBLE);
            episode_number = 11;
            cherry6_background.setImageResource(cherry6_image[7]);
            cherry6_textView1.setText(cherry6_text[12]);
            cherry6_textView2.setText(cherry6_text[13]);
            cherry6_next_button.setVisibility(View.VISIBLE);
//            cherry_testButton.setVisibility(View.VISIBLE);
        } else if (episode_number == 11){
//            cherry_testButton.setVisibility(View.INVISIBLE);
            cherry6_next_button.setVisibility(View.INVISIBLE);
            episode_number = 12;
            cherry6_textView1.setText("");
            cherry6_textView2.setText("");
            cherry6_background.setImageResource(cherry6_image[8]);
            cherry006_case1_message.setVisibility(View.INVISIBLE);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry6_Thread8 thread8 = new Cherry6_Thread8();
                    thread8.start();
                    cherry6_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 12){
            if (play) playSound(false);
            value8 = false;
            cherry6_next_button.setVisibility(View.INVISIBLE);
            episode_number = 13;
            cherry6_background.setImageResource(cherry6_image[9]);
            cherry6_textView1.setText(cherry6_text[14]);
            cherry6_textView2.setText(cherry6_text[15]);
            cherry6_next_button.setVisibility(View.VISIBLE);
//            cherry_testButton.setVisibility(View.VISIBLE);
        } else if (episode_number == 13){
//            cherry_testButton.setVisibility(View.INVISIBLE);
            cherry6_next_button.setVisibility(View.INVISIBLE);
            episode_number = 14;
            cherry6_textView1.setText("");
            cherry6_textView2.setText("");
            cherry6_background.setImageResource(cherry6_image[10]);
            cherry006_case1_message.setVisibility(View.INVISIBLE);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry6_Thread9 thread9 = new Cherry6_Thread9();
                    thread9.start();
                    cherry6_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 14){
            if (play) playSound(false);
            value9 = false;
            cherry6_next_button.setVisibility(View.INVISIBLE);
//            episode_number = 15;
            cherry6_case3.setVisibility(View.VISIBLE);
            cherry6_case4.setVisibility(View.VISIBLE);
            cherry6_textView1.setText(cherry6_text[16]);
//            cherry6_textView2.setText(cherry6_text[17]);
//            cherry6_next_button.setVisibility(View.VISIBLE);
//            cherry_testButton.setVisibility(View.VISIBLE);
        } else if (episode_number == 15){
            Intent intent = new Intent(getApplicationContext(), Cherry7_Adachi_Episode1_4.class);
            startActivity(intent);

            overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
            finish();
        } else if (episode_number == 16){
            if (play) playSound(false);
            value10 = false;
            cherry6_textView1.setText(cherry6_text[19]);
            cherry6_textView2.setText(cherry6_text[20]);
            episode_number = 15;
        } else if (episode_number == 17){
            if (play) playSound(false);
            value11 = false;
            cherry6_next_button.setVisibility(View.INVISIBLE);
            episode_number = 18;
            cherry6_textView1.setText(cherry6_text[17]);
            cherry6_textView2.setText(cherry6_text[18]);
            cherry6_next_button.setVisibility(View.VISIBLE);
//            cherry_testButton.setVisibility(View.VISIBLE);
        } else if (episode_number == 18){
            cherry6_next_button.setVisibility(View.INVISIBLE);
            episode_number = 16;
            cherry6_textView1.setText("");
            cherry6_textView2.setText("");
            cherry6_background.setImageResource(cherry6_image[13]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry6_Thread10 thread10 = new Cherry6_Thread10();
                    thread10.start();
                    cherry6_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        }
    }

    class Cherry6_Thread1 extends Thread{
        int text1_time = 0;
        int text2_time = 0;
        int text3_time = 0;

        String[] text1_list = cherry6_text[0].split("");
        String[] text2_list = cherry6_text[1].split("");
        String[] text3_list = cherry6_text[2].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value1 && !play) playSound(true);

            while (value1 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry6_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }


            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value1 && play) playSound(false);
                    cherry6_background.setImageResource(cherry6_image[1]);
                }
            });

            try {
                if (value1) Thread.sleep(1500);
            } catch (Exception e) { }

            if (value1 && !play) playSound(true);

            while (value1 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry6_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value1 && play) playSound(false);

            try {
                Thread.sleep(1000);
            } catch (Exception e) { }

            if (value1 && !play) playSound(true);

            while (value1 && text3_time < text3_list.length){
                text2_build.append(text3_list[text3_time]);
                cherry6_textView2.setText(text2_build.toString());
                text3_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value1 && play) playSound(false);

            if (value1) episode_number = 2;

//            handler.post(new Runnable() {
//                @Override
//                public void run() {
//                    if (value1) cherry_testButton.setVisibility(View.VISIBLE);
//                }
//            });
        }
    }

    class Cherry6_Thread2 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry6_text[3].split("");
        String[] text2_list = cherry6_text[4].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value2 && !play) playSound(true);

            while (value2 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry6_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value2) {
                        cherry6_background2.setImageResource(cherry6_image[2]);
                        cherry6_background2.setVisibility(View.VISIBLE);
                        Animation inAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.activity_alpha_in);
                        cherry6_background2.startAnimation(inAnim);
                    }
                }
            });

            if (value2 && play) playSound(false);

            try {
                if (value2) Thread.sleep(1500);
            } catch (Exception e) { }

            if (value2 && !play) playSound(true);

            while (value2 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry6_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (value2 && play) playSound(false);
                    if (value2) {
                        Animation outAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.activity_alpha_out);
                        outAnimListenter animListenter = new outAnimListenter(cherry6_background2);

                        outAnim.setAnimationListener(animListenter);
                        cherry6_background2.startAnimation(outAnim);
                    }
//                    if (value2) cherry_testButton.setVisibility(View.VISIBLE);
                }
            }, 500);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (value2) cherry6_case1.setVisibility(View.VISIBLE);
                    if (value2) cherry6_case2.setVisibility(View.VISIBLE);
                    if (value2) cherry6_next_button.setVisibility(View.INVISIBLE);
                }
            }, 1000);

            if (value2) episode_number = 4;
        }
    }

    class Cherry6_Thread3 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry6_text[5].split("");
        String[] text2_list = cherry6_text[11].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (value3) cherry6_introduce_chuge.setVisibility(View.VISIBLE);
                }
            }, 500);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (value3) cherry6_introduce_chuge.setVisibility(View.INVISIBLE);
                }
            }, 2000);

            try {
                Thread.sleep(1000);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value3) {
                        cherry006_case1_message.setVisibility(View.VISIBLE);
                        Animation inAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.activity_alpha_in);
                        cherry006_case1_message.startAnimation(inAnim);
                    }
                }
            });

            try {
                Thread.sleep(250);
            } catch (Exception e) { }

            if (value3 && !play) playSound(true);

            while (value3 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry6_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value3 && play) playSound(false);

            try {
                Thread.sleep(1500);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value3) cherry6_background.setImageResource(cherry6_image[5]);
                    if (value3) cherry006_case1_message.setVisibility(View.INVISIBLE);
                }
            });

            try {
                Thread.sleep(500);
            } catch (Exception e) { }

            if (value3 && !play) playSound(true);

            while (value3 && text2_time < text2_list.length) {
                text2_build.append(text2_list[text2_time]);
                cherry6_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value3 && play) playSound(false);

            if (value3) episode_number = 6;

//            handler.post(new Runnable() {
//                @Override
//                public void run() {
//                    if (value3) cherry_testButton.setVisibility(View.VISIBLE);
//                }
//            });
        }
    }

    class Cherry6_Thread4 extends Thread{
        int text1_time = 0;

        String[] text1_list = cherry6_text[7].split("");

        StringBuilder text1_build = new StringBuilder();

        @Override
        public void run() {

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (value4) cherry6_introduce_chuge.setVisibility(View.VISIBLE);
                }
            }, 500);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (value4) cherry6_introduce_chuge.setVisibility(View.INVISIBLE);
                }
            }, 2000);

            try {
                Thread.sleep(1000);
            } catch (Exception e) { }

            if (value4 && !play) playSound(true);

            while (value4 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry6_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value4 && play) playSound(false);

//            handler.post(new Runnable() {
//                @Override
//                public void run() {
//                    if (value4) cherry_testButton.setVisibility(View.VISIBLE);
//                }
//            });

            if (value4) episode_number = 8;
        }
    }

    class Cherry6_Thread5 extends Thread{
        int text1_time = 0;
        int text2_time = 0;
        int text3_time = 0;

        String[] text1_list = cherry6_text[8].split("");
        String[] text2_list = cherry6_text[9].split("");
        String[] text3_list = cherry6_text[10].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();
        StringBuilder text3_build = new StringBuilder();

        @Override
        public void run() {

            if (value5 && !play) playSound(true);

            while (value5 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry006_case2_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value5 && play) playSound(false);

            if (value5 && !play) playSound(true);

            while (value5 && text2_time < text2_list.length) {
                text2_build.append(text2_list[text2_time]);
                cherry006_case2_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value5 && play) playSound(false);

            if (value5 && !play) playSound(true);

            while (value5 && text3_time < text3_list.length) {
                text3_build.append(text3_list[text3_time]);
                cherry006_case2_textView3.setText(text3_build.toString());
                text3_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value5 && play) playSound(false);

            handler.post(new Runnable() {
                @Override
                public void run() {
//                    if (value5) cherry_testButton.setVisibility(View.VISIBLE);
                    if (value5) cherry006_back_episode.setVisibility(View.VISIBLE);
                }
            });

            if (value5) episode_number = 9;

            Cherry6_Thread6 thread6 = new Cherry6_Thread6();
            thread6.start();
        }
    }

    class Cherry6_Thread6 extends Thread{
        int text1_time = 60;

        String text = "초 후에 자동으로 이동합니다.";

        @Override
        public void run() {
            while (value6 && text1_time > 0) {
                cherry006_count.setText(text1_time + text);
                try {
                    Thread.sleep(1000);
                } catch (Exception e){ }

                text1_time--;
            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value6) {

                        Intent intent = new Intent(getApplicationContext(), Cherry1_MainActivity.class);
                        startActivity(intent);

                        overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
                        finish();
                    }
                }
            });
        }
    }

    class Cherry6_Thread7 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry6_text[12].split("");
        String[] text2_list = cherry6_text[13].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value7 && !play) playSound(true);

            while (value7 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry6_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value7 && play) playSound(false);

            try {
                Thread.sleep(1500);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value7) cherry6_background.setImageResource(cherry6_image[7]);
                }
            });

            try {
                Thread.sleep(500);
            } catch (Exception e) { }

            if (value7 && !play) playSound(true);

            while (value7 && text2_time < text2_list.length) {
                text2_build.append(text2_list[text2_time]);
                cherry6_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value7 && play) playSound(false);

            if (value7) episode_number = 11;
        }
    }

    class Cherry6_Thread8 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry6_text[14].split("");
        String[] text2_list = cherry6_text[15].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value8 && !play) playSound(true);

            while (value8 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry6_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value8 && play) playSound(false);

            try {
                Thread.sleep(1500);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value8) cherry6_background.setImageResource(cherry6_image[9]);
                }
            });

            try {
                Thread.sleep(500);
            } catch (Exception e) { }

            if (value8 && !play) playSound(true);

            while (value8 && text2_time < text2_list.length) {
                text2_build.append(text2_list[text2_time]);
                cherry6_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value8 && play) playSound(false);

            if (value8) episode_number = 13;
        }
    }

    class Cherry6_Thread9 extends Thread{
        int text1_time = 0;

        String[] text1_list = cherry6_text[16].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            try {
                Thread.sleep(1000);
            } catch (Exception e) { }

            if (value9 && !play) playSound(true);

            while (value9 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry6_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value9 && play) playSound(false);

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value9) cherry6_next_button.setVisibility(View.INVISIBLE);
                    if (value9) cherry6_case3.setVisibility(View.VISIBLE);
                    if (value9) cherry6_case4.setVisibility(View.VISIBLE);
                }
            });
        }
    }

    class Cherry6_Thread10 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry6_text[19].split("");
        String[] text2_list = cherry6_text[20].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value10 && !play) playSound(true);

            while (value10 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry6_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value10 && play) playSound(false);

            try {
                Thread.sleep(1000);
            } catch (Exception e) { }

            if (value10 && !play) playSound(true);

            while (value10 && text2_time < text2_list.length) {
                text2_build.append(text2_list[text2_time]);
                cherry6_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value10 && play) playSound(false);


            if (value10) episode_number = 15;
        }
    }

    class Cherry6_Thread11 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry6_text[17].split("");
        String[] text2_list = cherry6_text[18].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value11 && !play) playSound(true);

            while (value11 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry6_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value11 && play) playSound(false);

            try {
                Thread.sleep(1500);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value11) cherry6_background.setImageResource(cherry6_image[12]);
                }
            });

            try {
                Thread.sleep(500);
            } catch (Exception e) { }

            if (value11 && !play) playSound(true);

            while (value11 && text2_time < text2_list.length) {
                text2_build.append(text2_list[text2_time]);
                cherry6_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value11 && play) playSound(false);


            if (value11) episode_number = 18;
        }
    }

    public void updateDB(){
        Cherry_Database database = Cherry_Database.getInstance(UseAll.mainContext);

        String sql = "UPDATE " +  Cherry_Database.table1 + " SET isLock='false' WHERE charactor = 'adachi' and number = 1" ;
        database.execSQL(sql) ;
    }



    class normalAnimListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            Cherry6_Thread5 thread5 = new Cherry6_Thread5();
            thread5.start();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }

    class outAnimListenter implements Animation.AnimationListener{

        View view;

        public outAnimListenter(View view){
            this.view = view;
        }

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            view.setVisibility(View.INVISIBLE);
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
