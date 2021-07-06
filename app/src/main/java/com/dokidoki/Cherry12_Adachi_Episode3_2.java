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

public class Cherry12_Adachi_Episode3_2 extends AppCompatActivity {

    ImageView cherry12_background;
    TextView cherry12_menu_button;

    OutlineTextView cherry12_textView1, cherry12_textView2;

    String[] cherry12_text = new String[]{"그런데 역시 능력 있는 사람은 말하는 것도 일하는 것도 다르네", "\"왜 그래?\"", //0, 1
            "\"쿠로사와는 업무능력도 뛰어나고", "주변의 신뢰도 받고 있으니까 어쩐지 대단한 것 같아서\"", //2, 3
            "\"갑자기 웬 칭찬이야?", "자 이제 일에 집중하자\"", //4, 5
            "그러면서 쿠로사와는 ", "나에게 가까이 다가왔다.", "\"미안 어? 어디였지?\"", //6, 7, 8
            "\"이건가?\"", "종이에 손이 닿자 쿠로사와의 마음의 소리가 점점 들려온다.", //9, 10
            "뭐라고 하는 거지?", "'예전부터 아다치한테서는 좋은 냄새가 나 어디 걸 쓰는 거지?'", //11, 12
            "'좋아 조만간 마트에서 알아보자", "그리고 목에 있는 점 너무 섹시해 어쩌면 이거 나만 아는 거 아냐?'", //13, 14
            "'목에 있는 점, 위험해 위험하다고 점!'", "\"잠깐만 화장실 좀 다녀올게\"", //15, 16
            "\"진짜 있네 점이... ", "몰랐어", "아니야 이건 내 망상이야\"", "내 망상이 아니었어\"", //17, 18, 19, 20
            "이 모든게 나의 망상이길 바랬다.", "쿠로사와의 마음도, 타인이 나를 바라보는 차가운 시선도.",
            "망상이 사실이 되었을 때 나의 자존감은 바닥으로 내리꽂혔다.", //21, 22, 23
            "그러니까 이 녀석의 마음은 진심이네", "미안 이 상황은 나한테 완전 과부하야", //24, 25
            "그것보다 왜 나 같은 사람을 좋아해?", "이 녀석, 일을 너무 많이 해서 머리가 이상해진 건가?", //26, 27
            "\"엣취!\"", "\"너 괜찮아?\"" //28, 29
    };

    int[] cherry12_image = new int[]{R.drawable.cherry012_adachi_play_episode3_4_background1, R.drawable.cherry012_adachi_play_episode3_4_background2, //0, 1
            R.drawable.cherry012_adachi_play_episode3_4_background3, R.drawable.cherry012_adachi_play_episode3_4_background4, //2, 3
            R.drawable.cherry012_adachi_play_episode3_4_background5, R.drawable.cherry012_adachi_play_episode3_4_background6, //4, 5
            R.drawable.cherry012_adachi_play_episode3_4_background7, R.drawable.cherry012_adachi_play_episode3_4_background8, //6, 7
            R.drawable.cherry012_adachi_play_episode3_4_background9, R.drawable.cherry012_adachi_play_episode3_5_background1, //8, 9
            R.drawable.cherry012_adachi_play_episode3_5_background2, R.drawable.cherry012_adachi_play_episode3_5_background3, //10, 11
            R.drawable.cherry012_adachi_play_episode3_5_background4, R.drawable.cherry012_adachi_play_episode3_5_background5, //12, 13
            R.drawable.cherry012_adachi_play_episode3_5_background6, R.drawable.cherry012_adachi_play_episode3_5_background7, //14, 15
            R.drawable.cherry012_adachi_play_episode3_5_background8, R.drawable.cherry012_adachi_play_episode3_6_background1, //16, 17
            R.drawable.cherry012_adachi_play_episode3_6_background2, R.drawable.cherry012_adachi_play_episode3_6_background3, //18, 19
            R.drawable.cherry012_adachi_play_episode3_6_background4, R.drawable.cherry012_adachi_play_episode3_6_background5, //20, 21
            R.drawable.cherry012_adachi_play_episode3_6_background6, R.drawable.cherry012_adachi_play_episode3_6_background7, //22, 23
            R.drawable.cherry012_adachi_play_episode3_6_background8, R.drawable.cherry012_adachi_play_episode3_6_background9 //24, 25
    };

    boolean value1 = true, value2 = true, value3 = true, value4 = true, value5 = true, value6 = true, value7 = true,
            value8 = true, value9 = true, value10 = true, value11 = true, value12 = true, value13 = true, value14 = true;

    LinearLayout cherry12_next_button;

    TextView cherry12_case1, cherry12_case2;
    ImageView cherry12_75_black, cherry12_bad_text;
    OutlineTextView cherry12_back_episode, cherry12_count, cherry12_ending_textView1, cherry12_ending_textView2, cherry12_ending_textView3;
    FrameLayout cherry12_bad_layout;

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
        setContentView(R.layout.cherry012_activity_adachi_episode3_2);

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
        UseAll.soundStart(8);

        cherry12_background = findViewById(R.id.cherry12_background);
        cherry12_menu_button = findViewById(R.id.cherry12_menu_button);

        cherry12_textView1 = findViewById(R.id.cherry12_textview1);
        cherry12_textView2 = findViewById(R.id.cherry12_textview2);

        cherry12_next_button = findViewById(R.id.cherry12_next_button);

        cherry12_case1 = findViewById(R.id.cherry12_case1);
        cherry12_case2 = findViewById(R.id.cherry12_case2);

        cherry12_75_black = findViewById(R.id.cherry12_75_black);
        cherry12_bad_layout = findViewById(R.id.cherry12_bad_layout);
        cherry12_bad_text = findViewById(R.id.cherry12_bad_text);
        cherry12_back_episode = findViewById(R.id.cherry12_back_episode);
        cherry12_count = findViewById(R.id.cherry12_count);
        cherry12_ending_textView1 = findViewById(R.id.cherry12_ending_textView1);
        cherry12_ending_textView2 = findViewById(R.id.cherry12_ending_textView2);
        cherry12_ending_textView3 = findViewById(R.id.cherry12_ending_textView3);

        cherry12_menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (){
//                    clickFunc();
//                }
                clickFunc();

                Intent intent = new Intent(getApplicationContext(), Cherry100_Episode_Pause.class);
                startActivityForResult(intent, 101);
            }
        });

        cherry12_next_button.setVisibility(View.INVISIBLE);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                episode_number = 1;
                cherry12_next_button.setVisibility(View.VISIBLE);
                Cherry12_Thread1 thread1 = new Cherry12_Thread1();
                thread1.start();
            }
        }, 3000);

        cherry12_case1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (episode_number == 18) {
                    cherry12_next_button.setVisibility(View.INVISIBLE);
                    episode_number = 19;
                    cherry12_case1.setVisibility(View.INVISIBLE);
                    cherry12_case2.setVisibility(View.INVISIBLE);
                    cherry12_textView2.setText("");
                    cherry12_background.setImageResource(cherry12_image[19]);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Cherry12_Thread10 thread10 = new Cherry12_Thread10();
                            thread10.start();
                            cherry12_next_button.setVisibility(View.VISIBLE);
                        }
                    }, 1500);
                }
            }
        });

        cherry12_case2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (episode_number == 18) {
                    cherry12_next_button.setVisibility(View.INVISIBLE);
                    episode_number = 21;
                    cherry12_case1.setVisibility(View.INVISIBLE);
                    cherry12_case2.setVisibility(View.INVISIBLE);
                    cherry12_textView2.setText("");
                    cherry12_background.setImageResource(cherry12_image[19]);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Cherry12_Thread10 thread10 = new Cherry12_Thread10();
                            thread10.start();
                            cherry12_next_button.setVisibility(View.VISIBLE);
                        }
                    }, 1500);
                }
            }
        });

        cherry12_back_episode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value10 = false;
                if (play) playSound(false);

                Intent intent = new Intent(getApplicationContext(), Cherry1_MainActivity.class);
                startActivity(intent);

                overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
                finish();
            }
        });

        cherry12_next_button.setOnClickListener(new View.OnClickListener() {
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
            cherry12_next_button.setVisibility(View.INVISIBLE);
            episode_number = 2;
            cherry12_background.setImageResource(cherry12_image[1]);
            cherry12_textView1.setText(cherry12_text[0]);
            cherry12_textView2.setText(cherry12_text[1]);
            cherry12_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 2){
            cherry12_next_button.setVisibility(View.INVISIBLE);
            episode_number = 3;
            cherry12_textView1.setText("");
            cherry12_textView2.setText("");
            cherry12_background.setImageResource(cherry12_image[2]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry12_Thread2 thread2 = new Cherry12_Thread2();
                    thread2.start();
                    cherry12_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 3){
            if (play) playSound(false);
            value2 = false;
            cherry12_next_button.setVisibility(View.INVISIBLE);
            episode_number = 4;
            cherry12_background.setImageResource(cherry12_image[3]);
            cherry12_textView1.setText(cherry12_text[2]);
            cherry12_textView2.setText(cherry12_text[3]);
            cherry12_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 4){
            cherry12_next_button.setVisibility(View.INVISIBLE);
            episode_number = 5;
            cherry12_textView1.setText("");
            cherry12_textView2.setText("");
            cherry12_background.setImageResource(cherry12_image[4]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry12_Thread3 thread3 = new Cherry12_Thread3();
                    thread3.start();
                    cherry12_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 5){
            if (play) playSound(false);
            value3 = false;
            cherry12_next_button.setVisibility(View.INVISIBLE);
            episode_number = 6;
            cherry12_background.setImageResource(cherry12_image[5]);
            cherry12_textView1.setText(cherry12_text[4]);
            cherry12_textView2.setText(cherry12_text[5]);
            cherry12_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 6){
            cherry12_next_button.setVisibility(View.INVISIBLE);
            episode_number = 7;
            cherry12_textView1.setText("");
            cherry12_textView2.setText("");
            cherry12_background.setImageResource(cherry12_image[6]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry12_Thread4 thread4 = new Cherry12_Thread4();
                    thread4.start();
                    cherry12_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 7){
            if (play) playSound(false);
            value4 = false;
            cherry12_next_button.setVisibility(View.INVISIBLE);
            episode_number = 8;
            cherry12_background.setImageResource(cherry12_image[8]);
            String temp = cherry12_text[6] + cherry12_text[7];
            cherry12_textView1.setText(temp);
            cherry12_textView2.setText(cherry12_text[8]);
            cherry12_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 8){
            cherry12_next_button.setVisibility(View.INVISIBLE);
            episode_number = 9;
            cherry12_textView1.setText("");
            cherry12_textView2.setText("");
            cherry12_background.setImageResource(cherry12_image[9]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry12_Thread5 thread5 = new Cherry12_Thread5();
                    thread5.start();
                    cherry12_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 9){
            if (play) playSound(false);
            value5 = false;
            cherry12_next_button.setVisibility(View.INVISIBLE);
            episode_number = 10;
            cherry12_background.setImageResource(cherry12_image[10]);
            cherry12_textView1.setText(cherry12_text[9]);
            cherry12_textView2.setText(cherry12_text[10]);
            cherry12_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 10){
            if (UseAll.player != null && UseAll.player.isPlaying()) UseAll.soundStop();
            UseAll.soundStart(23);
            cherry12_next_button.setVisibility(View.INVISIBLE);
            episode_number = 11;
            cherry12_textView1.setText("");
            cherry12_textView2.setText("");
            cherry12_background.setImageResource(cherry12_image[11]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry12_Thread6 thread6 = new Cherry12_Thread6();
                    thread6.start();
                    cherry12_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 11){
            if (play) playSound(false);
            value6 = false;
            cherry12_next_button.setVisibility(View.INVISIBLE);
            episode_number = 12;
            cherry12_background.setImageResource(cherry12_image[12]);
            cherry12_textView1.setText(cherry12_text[11]);
            cherry12_textView2.setText(cherry12_text[12]);
            cherry12_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 12){
            cherry12_next_button.setVisibility(View.INVISIBLE);
            episode_number = 13;
            cherry12_textView1.setText("");
            cherry12_textView2.setText("");
            cherry12_background.setImageResource(cherry12_image[13]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry12_Thread7 thread7 = new Cherry12_Thread7();
                    thread7.start();
                    cherry12_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 13){
            if (play) playSound(false);
            value7 = false;
            cherry12_next_button.setVisibility(View.INVISIBLE);
            episode_number = 14;
            cherry12_background.setImageResource(cherry12_image[14]);
            cherry12_textView1.setText(cherry12_text[13]);
            cherry12_textView2.setText(cherry12_text[14]);
            cherry12_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 14){
            cherry12_next_button.setVisibility(View.INVISIBLE);
            episode_number = 15;
            cherry12_textView1.setText("");
            cherry12_textView2.setText("");
            cherry12_background.setImageResource(cherry12_image[15]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry12_Thread8 thread8 = new Cherry12_Thread8();
                    thread8.start();
                    cherry12_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 15){
            if (play) playSound(false);
            value8 = false;
            cherry12_next_button.setVisibility(View.INVISIBLE);
            episode_number = 16;
            cherry12_background.setImageResource(cherry12_image[16]);
            cherry12_textView1.setText(cherry12_text[15]);
            cherry12_textView2.setText(cherry12_text[16]);
            cherry12_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 16){
            cherry12_next_button.setVisibility(View.INVISIBLE);
            episode_number = 17;
            cherry12_textView1.setText("");
            cherry12_textView2.setText("");
            cherry12_background.setImageResource(cherry12_image[17]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry12_Thread9 thread9 = new Cherry12_Thread9();
                    thread9.start();
                    cherry12_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 17){
            if (play) playSound(false);
            value9 = false;
            cherry12_next_button.setVisibility(View.INVISIBLE);
            cherry12_case1.setVisibility(View.VISIBLE);
            cherry12_case2.setVisibility(View.VISIBLE);
            episode_number = 18;
            cherry12_background.setImageResource(cherry12_image[18]);
            String temp = cherry12_text[17] + cherry12_text[18];
            cherry12_textView1.setText(temp);
        } else if (episode_number == 19){
            if (play) playSound(false);
            value10 = false;
            cherry12_next_button.setVisibility(View.INVISIBLE);
            episode_number = 20;
            cherry12_textView2.setText(cherry12_text[19]);
            cherry12_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 20){
            cherry12_next_button.setVisibility(View.INVISIBLE);
            cherry12_75_black.setVisibility(View.VISIBLE);
            cherry12_bad_text.setVisibility(View.VISIBLE);
//            cherry_testButton.setVisibility(View.INVISIBLE);

            Animation inAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.activity_alpha_in);
            cherry12_75_black.startAnimation(inAnim);
            cherry12_bad_text.startAnimation(inAnim);

            cherry12_back_episode.setVisibility(View.VISIBLE);
            cherry12updateDB();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    FrameLayout layout = findViewById(R.id.cherry12_bad_layout);
                    float temp1 = layout.getHeight();
                    float temp2 = cherry12_bad_text.getHeight();
                    float temp = (temp1 - temp2) * -1;

                    TranslateAnimation move = new TranslateAnimation(0, 0, 0, temp);
                    move.setDuration(500);
                    move.setFillAfter(true);
                    move.setAnimationListener(new badAnimListener());
                    cherry12_bad_text.startAnimation(move);

                }
            }, 1000);
        } else if (episode_number == 21){
            if (play) playSound(false);
            value10 = false;
            cherry12_next_button.setVisibility(View.INVISIBLE);
            episode_number = 22;
            cherry12_textView2.setText(cherry12_text[20]);
            cherry12_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 22){
            if (UseAll.player != null && UseAll.player.isPlaying()) UseAll.soundStop();
            UseAll.soundStart(19);
            cherry12_next_button.setVisibility(View.INVISIBLE);
            episode_number = 23;
            cherry12_textView1.setText("");
            cherry12_textView2.setText("");
            cherry12_background.setImageResource(cherry12_image[20]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry12_Thread12 thread12 = new Cherry12_Thread12();
                    thread12.start();
                    cherry12_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 23){
            if (play) playSound(false);
            value12 = false;
            cherry12_next_button.setVisibility(View.INVISIBLE);
            episode_number = 24;
            cherry12_background.setImageResource(cherry12_image[21]);
            cherry12_textView1.setText(cherry12_text[24]);
            cherry12_textView2.setText(cherry12_text[25]);
            cherry12_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 24){
            cherry12_next_button.setVisibility(View.INVISIBLE);
            episode_number = 25;
            cherry12_textView1.setText("");
            cherry12_textView2.setText("");
            cherry12_background.setImageResource(cherry12_image[22]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry12_Thread13 thread13 = new Cherry12_Thread13();
                    thread13.start();
                    cherry12_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 25){
            if (play) playSound(false);
            value13 = false;
            cherry12_next_button.setVisibility(View.INVISIBLE);
            episode_number = 26;
            cherry12_background.setImageResource(cherry12_image[23]);
            cherry12_textView1.setText(cherry12_text[26]);
            cherry12_textView2.setText(cherry12_text[27]);
            cherry12_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 26){
            cherry12_next_button.setVisibility(View.INVISIBLE);
            episode_number = 27;
            cherry12_textView1.setText("");
            cherry12_textView2.setText("");
            cherry12_background.setImageResource(cherry12_image[24]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry12_Thread14 thread14 = new Cherry12_Thread14();
                    thread14.start();
                    cherry12_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 27){
            if (play) playSound(false);
            value14 = false;
            cherry12_next_button.setVisibility(View.INVISIBLE);
            episode_number = 28;
            cherry12_background.setImageResource(cherry12_image[25]);
            cherry12_textView1.setText(cherry12_text[28]);
            cherry12_textView2.setText(cherry12_text[29]);
            cherry12_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 28) {
            Intent intent = new Intent(getApplicationContext(), Cherry13_Adachi_Episode3_3.class);
            startActivity(intent);

            overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
            finish();
        }
    }

    class Cherry12_Thread1 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry12_text[0].split("");
        String[] text2_list = cherry12_text[1].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value1 && !play) playSound(true);

            while (value1 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry12_textView1.setText(text1_build.toString());
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
                    if (value1){
                        cherry12_background.setImageResource(cherry12_image[1]);
                    }
                }
            });

            try {
                if (value1) Thread.sleep(500);
            } catch (Exception e) { }

            if (value1 && !play) playSound(true);

            while (value1 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry12_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value1 && play) playSound(false);

            if (value1) episode_number = 2;
        }
    }

    class Cherry12_Thread2 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry12_text[2].split("");
        String[] text2_list = cherry12_text[3].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value2 && !play) playSound(true);

            while (value2 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry12_textView1.setText(text1_build.toString());
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
                    if (value2){
                        cherry12_background.setImageResource(cherry12_image[3]);
                    }
                }
            });

            try {
                if (value2) Thread.sleep(500);
            } catch (Exception e) { }

            if (value2 && !play) playSound(true);

            while (value2 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry12_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value2 && play) playSound(false);

            if (value2) episode_number = 4;
        }
    }

    class Cherry12_Thread3 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry12_text[4].split("");
        String[] text2_list = cherry12_text[5].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value3 && !play) playSound(true);

            while (value3 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry12_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value3 && play) playSound(false);

            try {
                if (value3) Thread.sleep(1500);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value3){
                        cherry12_background.setImageResource(cherry12_image[5]);
                    }
                }
            });

            try {
                if (value3) Thread.sleep(500);
            } catch (Exception e) { }

            if (value3 && !play) playSound(true);

            while (value3 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry12_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value3 && play) playSound(false);

            if (value3) episode_number = 6;
        }
    }

    class Cherry12_Thread4 extends Thread {
        int text1_time = 0;
        int text2_time = 0;
        int text3_time = 0;

        String[] text1_list = cherry12_text[6].split("");
        String[] text2_list = cherry12_text[7].split("");
        String[] text3_list = cherry12_text[8].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value4 && !play) playSound(true);

            while (value4 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry12_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value4 && play) playSound(false);

            try {
                if (value4) Thread.sleep(1000);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value4){
                        cherry12_background.setImageResource(cherry12_image[7]);
                    }
                }
            });

            if (value4 && !play) playSound(true);

            while (value4 && text2_time < text2_list.length){
                text1_build.append(text2_list[text2_time]);
                cherry12_textView1.setText(text1_build.toString());
                text2_time++;

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
                    if (value4){
                        cherry12_background.setImageResource(cherry12_image[8]);
                    }
                }
            });

            try {
                if (value4) Thread.sleep(500);
            } catch (Exception e) { }

            if (value4 && !play) playSound(true);

            while (value4 && text3_time < text3_list.length){
                text2_build.append(text3_list[text3_time]);
                cherry12_textView2.setText(text2_build.toString());
                text3_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value4 && play) playSound(false);

            if (value4) episode_number = 8;
        }
    }

    class Cherry12_Thread5 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry12_text[9].split("");
        String[] text2_list = cherry12_text[10].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value5 && !play) playSound(true);

            while (value5 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry12_textView1.setText(text1_build.toString());
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
                    if (value5){
                        cherry12_background.setImageResource(cherry12_image[10]);
                    }
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value5 && !play) playSound(true);

            while (value5 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry12_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value5 && play) playSound(false);

            if (value5) episode_number = 10;
        }
    }

    class Cherry12_Thread6 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry12_text[11].split("");
        String[] text2_list = cherry12_text[12].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value6 && !play) playSound(true);

            while (value6 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry12_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value6 && play) playSound(false);

            try {
                if (value6) Thread.sleep(1500);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value6){
                        cherry12_background.setImageResource(cherry12_image[12]);
                    }
                }
            });

            try {
                if (value6) Thread.sleep(500);
            } catch (Exception e) { }

            if (value6 && !play) playSound(true);

            while (value6 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry12_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value6 && play) playSound(false);

            if (value6) episode_number = 12;
        }
    }

    class Cherry12_Thread7 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry12_text[13].split("");
        String[] text2_list = cherry12_text[14].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value7 && !play) playSound(true);

            while (value7 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry12_textView1.setText(text1_build.toString());
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
                    if (value7){
                        cherry12_background.setImageResource(cherry12_image[14]);
                    }
                }
            });

            try {
                if (value7) Thread.sleep(500);
            } catch (Exception e) { }

            if (value7 && !play) playSound(true);

            while (value7 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry12_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value7 && play) playSound(false);

            if (value7) episode_number = 14;
        }
    }

    class Cherry12_Thread8 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry12_text[15].split("");
        String[] text2_list = cherry12_text[16].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value8 && !play) playSound(true);

            while (value8 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry12_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value8 && play) playSound(false);

            try {
                if (value8) Thread.sleep(1500);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value8){
                        cherry12_background.setImageResource(cherry12_image[16]);
                    }
                }
            });

            try {
                if (value8) Thread.sleep(500);
            } catch (Exception e) { }

            if (value8 && !play) playSound(true);

            while (value8 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry12_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value8 && play) playSound(false);

            if (value8) episode_number = 16;
        }
    }

    class Cherry12_Thread9 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry12_text[17].split("");
        String[] text2_list = cherry12_text[18].split("");

        StringBuilder text1_build = new StringBuilder();

        @Override
        public void run() {

            if (value9 && !play) playSound(true);

            while (value9 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry12_textView1.setText(text1_build.toString());
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
                    if (value9){
                        cherry12_background.setImageResource(cherry12_image[18]);
                    }
                }
            });

            try {
                if (value9) Thread.sleep(1000);
            } catch (Exception e) { }

            if (value9 && !play) playSound(true);

            while (value9 && text2_time < text2_list.length) {
                text1_build.append(text2_list[text2_time]);
                cherry12_textView1.setText(text1_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value9 && play) playSound(false);

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value9) {
                        cherry12_next_button.setVisibility(View.INVISIBLE);
                        cherry12_case1.setVisibility(View.VISIBLE);
                        cherry12_case2.setVisibility(View.VISIBLE);
                    }
                }
            });

            if (value9) episode_number = 18;
        }
    }

    class Cherry12_Thread10 extends Thread {
        int text2_time = 0;

        String[] text2_list = (episode_number == 19) ?cherry12_text[19].split("") : cherry12_text[20].split("");

        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value10 && !play) playSound(true);

            while (value10 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry12_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value10 && play) playSound(false);

            if (value10) episode_number = (episode_number == 19) ? 20 : 22;
        }
    }

    class Cherry12_Thread11 extends Thread {
        int text1_time = 0;
        int text2_time = 0;
        int text3_time = 0;

        String[] text1_list = cherry12_text[21].split("");
        String[] text2_list = cherry12_text[22].split("");
        String[] text3_list = cherry12_text[23].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();
        StringBuilder text3_build = new StringBuilder();

        @Override
        public void run() {

            if (value11 && !play) playSound(true);

            while (value11 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry12_ending_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value11 && play) playSound(false);

            if (value11 && !play) playSound(true);

            while (value11 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry12_ending_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value11 && play) playSound(false);

            if (value11 && !play) playSound(true);

            while (value11 && text3_time < text3_list.length){
                text3_build.append(text3_list[text3_time]);
                cherry12_ending_textView3.setText(text3_build.toString());
                text3_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value11 && play) playSound(false);

            int text_time = 60;
            String text = "초 후에 자동으로 이동합니다.";

            while (value11 && text_time > 0) {
                cherry12_count.setText(text_time + text);
                try {
                    Thread.sleep(1000);
                } catch (Exception e){ }

                text_time--;
            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value11) {

                        Intent intent = new Intent(getApplicationContext(), Cherry1_MainActivity.class);
                        startActivity(intent);

                        overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
                        finish();
                    }
                }
            });
        }
    }

    class Cherry12_Thread12 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry12_text[24].split("");
        String[] text2_list = cherry12_text[25].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value12 && !play) playSound(true);

            while (value12 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry12_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value12 && play) playSound(false);

            try {
                if (value12) Thread.sleep(1500);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value12){
                        cherry12_background.setImageResource(cherry12_image[21]);
                    }
                }
            });

            try {
                if (value12) Thread.sleep(500);
            } catch (Exception e) { }

            if (value12 && !play) playSound(true);

            while (value12 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry12_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value12 && play) playSound(false);

            if (value12) episode_number = 24;
        }
    }

    class Cherry12_Thread13 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry12_text[26].split("");
        String[] text2_list = cherry12_text[27].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value13 && !play) playSound(true);

            while (value13 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry12_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value13 && play) playSound(false);

            try {
                if (value13) Thread.sleep(1500);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value13){
                        cherry12_background.setImageResource(cherry12_image[23]);
                    }
                }
            });

            try {
                if (value13) Thread.sleep(500);
            } catch (Exception e) { }

            if (value13 && !play) playSound(true);

            while (value13 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry12_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value13 && play) playSound(false);

            if (value13) episode_number = 26;
        }
    }

    class Cherry12_Thread14 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry12_text[28].split("");
        String[] text2_list = cherry12_text[29].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value14 && !play) playSound(true);

            while (value14 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry12_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value14 && play) playSound(false);

            try {
                if (value14) Thread.sleep(1500);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value14){
                        cherry12_background.setImageResource(cherry12_image[25]);
                    }
                }
            });

            try {
                if (value14) Thread.sleep(500);
            } catch (Exception e) { }

            if (value14 && !play) playSound(true);

            while (value14 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry12_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value14 && play) playSound(false);

            if (value14) episode_number = 28;
        }
    }


    public void cherry12updateDB(){
        Cherry_Database database = Cherry_Database.getInstance(UseAll.mainContext);

        String sql = "UPDATE " +  Cherry_Database.table1 + " SET isLock='false' WHERE charactor = 'adachi' and number = 5" ;
        database.execSQL(sql) ;
    }

    class badAnimListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            Cherry12_Thread11 thread11 = new Cherry12_Thread11();
            thread11.start();
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