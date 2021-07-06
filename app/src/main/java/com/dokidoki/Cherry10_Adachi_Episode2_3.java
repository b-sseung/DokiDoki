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

public class Cherry10_Adachi_Episode2_3 extends AppCompatActivity {

    ImageView cherry10_background;
    TextView cherry10_menu_button;

    OutlineTextView cherry10_textView1, cherry10_textView2;

    String[] cherry10_text = new String[]{"다시 생각해보니 마음을 읽을 수 있다는 것도", "모두 나의 망상이고 환청이라는 가설이 떠올랐어", //0, 1
            "저 쿠로사와가 ", "나 같은 걸 좋아할 리가...", "\"과장님 분명 제출은 다음 주 아니었습니까?\"", //2, 3, 4
            "말 소리가 들려 보니 우라베와 과장님이 이야기 하고 있었다.", "\"내일 아침까지 필요한 거야 부탁해\"", //5, 6
            "\"알겠습니다\"", "대화가 끝난 우라베는 ", "내 옆으로 점점 다가왔다.", //7, 8, 9
            "\"하..\"", "'엄청 화내겠지? 유미, 결혼기념일 당일에 약속 취소라니...'", //10, 11
            "발이 닿아 우라베의 마음의 소리가 들리고 있었다.", "\"아다치...\"", //12, 13
            "사정은 딱하지만... 나도 내 일이 있다고!", "\"죄송해요... 하지만 저 오늘 중요한 약속이 있어서...\"", //14, 15
            "결혼기념일...이라니까... 도와주자...", "\"저기... 저라도 괜찮다면 도와드릴까요?\"", //16, 17
            "\"항상 고마워.. 진짜 고마워\"", "결국 또 일이 늘어버렸네", //18, 19
            "나의 완곡한 태도에 우라베는", "나에게 일을 떠넘지기 못했고,", "나는 제 시간에 퇴근할 수 있었다." //20, 21, 22

    };

    int[] cherry10_image = new int[]{R.drawable.cherry010_adachi_play_episode2_11_background1, R.drawable.cherry010_adachi_play_episode2_11_background2, //0, 1
            R.drawable.cherry010_adachi_play_episode2_11_background3, R.drawable.cherry010_adachi_play_episode2_11_background4, //2, 3
            R.drawable.cherry010_adachi_play_episode2_11_background5, R.drawable.cherry010_adachi_play_episode2_11_background6, //4, 5
            R.drawable.cherry010_adachi_play_episode2_11_background7, R.drawable.cherry010_adachi_play_episode2_11_background8, //6, 7
            R.drawable.cherry010_adachi_play_episode2_12_background1, R.drawable.cherry010_adachi_play_episode2_12_background2, //8, 9
            R.drawable.cherry010_adachi_play_episode2_12_background3, R.drawable.cherry010_adachi_play_episode2_12_background4, //10, 11
            R.drawable.adachi_collection004_background, //12
            R.drawable.cherry010_adachi_play_episode2_12_background6, R.drawable.cherry010_adachi_play_episode2_12_background7 //13, 14
    };

    boolean value1 = true, value2 = true, value3 = true, value4 = true, value5 = true, value6 = true, value7 = true,
        value8 = true, value9 = true, value10 = true;

    LinearLayout cherry10_next_button;

    TextView cherry10_case1, cherry10_case2;
    ImageView cherry10_75_black, cherry10_normal_text;
    OutlineTextView cherry10_back_episode, cherry10_count, cherry10_ending_textView1, cherry10_ending_textView2, cherry10_ending_textView3;
    FrameLayout cherry10_normal_layout;

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
        setContentView(R.layout.cherry010_activity_adachi_episode2_3);


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
        UseAll.soundStart(15);

        cherry10_background = findViewById(R.id.cherry10_background);
        cherry10_menu_button = findViewById(R.id.cherry10_menu_button);

        cherry10_textView1 = findViewById(R.id.cherry10_textview1);
        cherry10_textView2 = findViewById(R.id.cherry10_textview2);

        cherry10_next_button = findViewById(R.id.cherry10_next_button);

        cherry10_case1 = findViewById(R.id.cherry10_case1);
        cherry10_case2 = findViewById(R.id.cherry10_case2);

        cherry10_75_black = findViewById(R.id.cherry10_75_black);
        cherry10_normal_layout = findViewById(R.id.cherry10_normal_layout);
        cherry10_normal_text = findViewById(R.id.cherry10_normal_text);
        cherry10_back_episode = findViewById(R.id.cherry10_back_episode);
        cherry10_count = findViewById(R.id.cherry10_count);
        cherry10_ending_textView1 = findViewById(R.id.cherry10_ending_textView1);
        cherry10_ending_textView2 = findViewById(R.id.cherry10_ending_textView2);
        cherry10_ending_textView3 = findViewById(R.id.cherry10_ending_textView3);

        cherry10_menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (episode_number != 2 && episode_number != 4 && episode_number != 6 && episode_number != 8
                        && episode_number != 10 && episode_number != 14 && episode_number != 16 && episode_number != 18){
                    clickFunc();
                }

                Intent intent = new Intent(getApplicationContext(), Cherry100_Episode_Pause.class);
                startActivityForResult(intent, 101);
            }
        });

        cherry10_next_button.setVisibility(View.INVISIBLE);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                episode_number = 1;
                cherry10_next_button.setVisibility(View.VISIBLE);
                Cherry10_Thread1 thread1 = new Cherry10_Thread1();
                thread1.start();
            }
        }, 3000);

        cherry10_case1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (episode_number == 12){
                    cherry10_next_button.setVisibility(View.INVISIBLE);
                    episode_number = 13;
                    cherry10_case1.setVisibility(View.INVISIBLE);
                    cherry10_case2.setVisibility(View.INVISIBLE);
                    cherry10_textView1.setText("");
                    cherry10_textView2.setText("");
                    cherry10_background.setImageResource(cherry10_image[12]);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Cherry10_Thread7 thread7 = new Cherry10_Thread7();
                            thread7.start();
                            cherry10_next_button.setVisibility(View.VISIBLE);
                        }
                    }, 1500);
                }
            }
        });

        cherry10_case2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (episode_number == 12){
                    cherry10_next_button.setVisibility(View.INVISIBLE);
                    episode_number = 15;
                    cherry10_case1.setVisibility(View.INVISIBLE);
                    cherry10_case2.setVisibility(View.INVISIBLE);
                    cherry10_textView1.setText("");
                    cherry10_textView2.setText("");
                    cherry10_background.setImageResource(cherry10_image[11]);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Cherry10_Thread9 thread9 = new Cherry10_Thread9();
                            thread9.start();
                            cherry10_next_button.setVisibility(View.VISIBLE);
                        }
                    }, 1500);
                }
            }
        });

        cherry10_back_episode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (play) playSound(false);
                value8 = false;
                Intent intent = new Intent(getApplicationContext(), Cherry1_MainActivity.class);
                startActivity(intent);

                overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
            }
        });

        cherry10_next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickFunc();
            }
        });
    }

    public void clickFunc(){
        if (episode_number == 1) {
            if (play) playSound(false);
            value1 = false;
            cherry10_next_button.setVisibility(View.INVISIBLE);
            episode_number = 2;
            cherry10_textView1.setText(cherry10_text[0]);
            cherry10_textView2.setText(cherry10_text[1]);
            cherry10_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 2){
            cherry10_next_button.setVisibility(View.INVISIBLE);
            episode_number = 3;
            cherry10_textView1.setText("");
            cherry10_textView2.setText("");
            cherry10_background.setImageResource(cherry10_image[1]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry10_Thread2 thread2 = new Cherry10_Thread2();
                    thread2.start();
                    cherry10_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 3){
            if (play) playSound(false);
            value2 = false;
            cherry10_next_button.setVisibility(View.INVISIBLE);
            episode_number = 4;
            cherry10_background.setImageResource(cherry10_image[3]);
            String temp = cherry10_text[2] + cherry10_text[3];
            cherry10_textView1.setText(temp);
            cherry10_textView2.setText(cherry10_text[4]);
            cherry10_next_button.setVisibility(View.VISIBLE);
        }
        else if (episode_number == 4){
            cherry10_next_button.setVisibility(View.INVISIBLE);
            episode_number = 5;
            cherry10_textView1.setText("");
            cherry10_textView2.setText("");
            cherry10_background.setImageResource(cherry10_image[4]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry10_Thread3 thread3 = new Cherry10_Thread3();
                    thread3.start();
                    cherry10_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 5){
            if (play) playSound(false);
            value3 = false;
            cherry10_next_button.setVisibility(View.INVISIBLE);
            episode_number = 6;
            cherry10_textView1.setText(cherry10_text[5]);
            cherry10_textView2.setText(cherry10_text[6]);
            cherry10_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 6){
            cherry10_next_button.setVisibility(View.INVISIBLE);
            episode_number = 7;
            cherry10_textView1.setText("");
            cherry10_textView2.setText("");
            cherry10_background.setImageResource(cherry10_image[5]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry10_Thread4 thread4 = new Cherry10_Thread4();
                    thread4.start();
                    cherry10_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        }
        else if (episode_number == 7){
            if (play) playSound(false);
            value4 = false;
            cherry10_next_button.setVisibility(View.INVISIBLE);
            episode_number = 8;
            cherry10_background.setImageResource(cherry10_image[7]);
            cherry10_textView1.setText(cherry10_text[7]);
            String temp = cherry10_text[8] + cherry10_text[9];
            cherry10_textView2.setText(temp);
            cherry10_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 8){
            cherry10_next_button.setVisibility(View.INVISIBLE);
            episode_number = 9;
            cherry10_textView1.setText("");
            cherry10_textView2.setText("");
            cherry10_background.setImageResource(cherry10_image[8]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry10_Thread5 thread5 = new Cherry10_Thread5();
                    thread5.start();
                    cherry10_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 9){
            if (play) playSound(false);
            value5 = false;
            cherry10_next_button.setVisibility(View.INVISIBLE);
            episode_number = 10;
            cherry10_textView1.setText(cherry10_text[10]);
            cherry10_textView2.setText(cherry10_text[11]);
            cherry10_next_button.setVisibility(View.VISIBLE);
        }
        else if (episode_number == 10){
            cherry10_next_button.setVisibility(View.INVISIBLE);
            episode_number = 11;
            cherry10_textView1.setText("");
            cherry10_textView2.setText("");
            cherry10_background.setImageResource(cherry10_image[9]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry10_Thread6 thread6 = new Cherry10_Thread6();
                    thread6.start();
                    cherry10_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 11){
            if (play) playSound(false);
            value6 = false;
            cherry10_next_button.setVisibility(View.INVISIBLE);
            cherry10_case1.setVisibility(View.VISIBLE);
            cherry10_case2.setVisibility(View.VISIBLE);
            episode_number = 12;
            cherry10_background.setImageResource(cherry10_image[10]);
            cherry10_textView1.setText(cherry10_text[12]);
            cherry10_textView2.setText(cherry10_text[13]);
        } else if (episode_number == 13) {
            if (play) playSound(false);
            value7 = false;
            cherry10_next_button.setVisibility(View.INVISIBLE);
            cherry10_case1.setVisibility(View.INVISIBLE);
            cherry10_case2.setVisibility(View.INVISIBLE);
            episode_number = 14;
            cherry10_textView1.setText(cherry10_text[14]);
            cherry10_textView2.setText(cherry10_text[15]);
            cherry10_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 14) {
            cherry10_next_button.setVisibility(View.INVISIBLE);
            cherry10_75_black.setVisibility(View.VISIBLE);
            cherry10_normal_text.setVisibility(View.VISIBLE);
//            cherry_testButton.setVisibility(View.INVISIBLE);

            Animation inAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.activity_alpha_in);
            cherry10_75_black.startAnimation(inAnim);
            cherry10_normal_text.startAnimation(inAnim);

            cherry10_back_episode.setVisibility(View.VISIBLE);
            cherry10updateDB();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    FrameLayout layout = findViewById(R.id.cherry10_normal_layout);
                    float temp1 = layout.getHeight();
                    float temp2 = cherry10_normal_text.getHeight();
                    float temp = (temp1 - temp2) * -1;

                    TranslateAnimation move = new TranslateAnimation(0, 0, 0, temp);
                    move.setDuration(500);
                    move.setFillAfter(true);
                    move.setAnimationListener(new normalAnimListener());
                    cherry10_normal_text.startAnimation(move);

                }
            }, 1000);
        } else if (episode_number == 15) {
            if (play) playSound(false);
            value9 = false;
            cherry10_next_button.setVisibility(View.INVISIBLE);
            cherry10_case1.setVisibility(View.INVISIBLE);
            cherry10_case2.setVisibility(View.INVISIBLE);
            episode_number = 16;
            cherry10_textView1.setText(cherry10_text[16]);
            cherry10_textView2.setText(cherry10_text[17]);
            cherry10_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 16){
            cherry10_next_button.setVisibility(View.INVISIBLE);
            episode_number = 17;
            cherry10_textView1.setText("");
            cherry10_textView2.setText("");
            cherry10_background.setImageResource(cherry10_image[13]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry10_Thread10 thread10 = new Cherry10_Thread10();
                    thread10.start();
                    cherry10_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 17){
            if (play) playSound(false);
            value10 = false;
            cherry10_next_button.setVisibility(View.INVISIBLE);
            episode_number = 18;
            cherry10_background.setImageResource(cherry10_image[14]);
            cherry10_textView1.setText(cherry10_text[18]);
            cherry10_textView2.setText(cherry10_text[19]);
            cherry10_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 18){
            Intent intent = new Intent(getApplicationContext(), Cherry101_AdachiEpisodeClearActivity.class);
            intent.putExtra("position", 2);

            startActivity(intent);

            overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
            finish();
        }
    }

    class Cherry10_Thread1 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry10_text[0].split("");
        String[] text2_list = cherry10_text[1].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value1 && !play) playSound(true);

            while (value1 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry10_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value1 && play) playSound(false);

            try {
                if (value1) Thread.sleep(1500);
            } catch (Exception e) { }

            if (value1 && !play) playSound(true);

            while (value1 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry10_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value1 && play) playSound(false);

            if (value1) episode_number = 2;
        }
    }

    class Cherry10_Thread2 extends Thread {
        int text1_time = 0;
        int text2_time = 0;
        int text3_time = 0;

        String[] text1_list = cherry10_text[2].split("");
        String[] text2_list = cherry10_text[3].split("");
        String[] text3_list = cherry10_text[4].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value2 && !play) playSound(true);

            while (value2 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry10_textView1.setText(text1_build.toString());
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
                    if (value2 ) cherry10_background.setImageResource(cherry10_image[2]);
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value2 && !play) playSound(true);

            while (value2 && text2_time < text2_list.length){
                text1_build.append(text2_list[text2_time]);
                cherry10_textView1.setText(text1_build.toString());
                text2_time++;

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
                    if (value2) cherry10_background.setImageResource(cherry10_image[3]);
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value2 && !play) playSound(true);

            while (value2 && text3_time < text3_list.length){
                text2_build.append(text3_list[text3_time]);
                cherry10_textView2.setText(text2_build.toString());
                text3_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value2 && play) playSound(false);

            if (value2) episode_number = 4;
        }
    }

    class Cherry10_Thread3 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry10_text[5].split("");
        String[] text2_list = cherry10_text[6].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value3 && !play) playSound(true);

            while (value3 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry10_textView1.setText(text1_build.toString());
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
                cherry10_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value3 && play) playSound(false);

            if (value3) episode_number = 6;
        }
    }

    class Cherry10_Thread4 extends Thread {
        int text1_time = 0;
        int text2_time = 0;
        int text3_time = 0;

        String[] text1_list = cherry10_text[7].split("");
        String[] text2_list = cherry10_text[8].split("");
        String[] text3_list = cherry10_text[9].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value4 && !play) playSound(true);

            while (value4 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry10_textView1.setText(text1_build.toString());
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
                    if (value4) cherry10_background.setImageResource(cherry10_image[6]);
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value4 && !play) playSound(true);

            while (value4 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry10_textView2.setText(text2_build.toString());
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
                    if (value4) cherry10_background.setImageResource(cherry10_image[7]);
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value4 && !play) playSound(true);

            while (value4 && text3_time < text3_list.length){
                text2_build.append(text3_list[text3_time]);
                cherry10_textView2.setText(text2_build.toString());
                text3_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value4 && play) playSound(false);

            if (value4) episode_number = 8;
        }
    }

    class Cherry10_Thread5 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry10_text[10].split("");
        String[] text2_list = cherry10_text[11].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value5 && !play) playSound(true);

            while (value5 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry10_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value5 && play) playSound(false);

            try {
                if (value5) Thread.sleep(1500);
            } catch (Exception e) { }

            if (value5 && !play) playSound(true);

            while (value5 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry10_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value5 && play) playSound(false);

            if (value5) episode_number = 10;
        }
    }

    class Cherry10_Thread6 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry10_text[12].split("");
        String[] text2_list = cherry10_text[13].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value6 && !play) playSound(true);

            while (value6 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry10_textView1.setText(text1_build.toString());
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
                    if (value6) cherry10_background.setImageResource(cherry10_image[10]);
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value6 && !play) playSound(true);

            while (value6 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry10_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value6 && play) playSound(false);

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value6) {
                        cherry10_next_button.setVisibility(View.INVISIBLE);
                        cherry10_case1.setVisibility(View.VISIBLE);
                        cherry10_case2.setVisibility(View.VISIBLE);
                    }
                }
            });

            if (value6) episode_number = 12;
        }
    }

    class Cherry10_Thread7 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry10_text[14].split("");
        String[] text2_list = cherry10_text[15].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value7 && !play) playSound(true);

            while (value7 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry10_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value7 && play) playSound(false);

            try {
                if (value7) Thread.sleep(1500);
            } catch (Exception e) { }

            if (value7 && !play) playSound(true);

            while (value7 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry10_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value7 && play) playSound(false);

            if (value7) episode_number = 14;
        }
    }

    class Cherry10_Thread8 extends Thread {
        int text1_time = 0;
        int text2_time = 0;
        int text3_time = 0;

        String[] text1_list = cherry10_text[20].split("");
        String[] text2_list = cherry10_text[21].split("");
        String[] text3_list = cherry10_text[22].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();
        StringBuilder text3_build = new StringBuilder();

        @Override
        public void run() {

            if (value8 && !play) playSound(true);

            while (value8 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry10_ending_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value8 && play) playSound(false);

            if (value8 && !play) playSound(true);

            while (value8 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry10_ending_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value8 && play) playSound(false);

            if (value8 && !play) playSound(true);

            while (value8 && text3_time < text3_list.length){
                text3_build.append(text3_list[text3_time]);
                cherry10_ending_textView3.setText(text3_build.toString());
                text3_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value8 && play) playSound(false);

            int text_time = 60;
            String text = "초 후에 자동으로 이동합니다.";

            while (value10 && text_time > 0) {
                cherry10_count.setText(text_time + text);
                try {
                    Thread.sleep(1000);
                } catch (Exception e){ }

                text_time--;
            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value10) {

                        Intent intent = new Intent(getApplicationContext(), Cherry1_MainActivity.class);
                        startActivity(intent);

                        overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
                        finish();
                    }
                }
            });
        }
    }

    class Cherry10_Thread9 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry10_text[16].split("");
        String[] text2_list = cherry10_text[17].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value9 && !play) playSound(true);

            while (value9 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry10_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value9 && play) playSound(false);

            try {
                if (value9) Thread.sleep(1500);
            } catch (Exception e) { }

            if (value9 && !play) playSound(true);

            while (value9 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry10_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value9 && play) playSound(false);

            if (value9) episode_number = 16;
        }
    }

    class Cherry10_Thread10 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry10_text[18].split("");
        String[] text2_list = cherry10_text[19].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value10 && !play) playSound(true);

            while (value10 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry10_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value10 && play) playSound(false);

            try {
                if (value10) Thread.sleep(1500);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    cherry10_background.setImageResource(cherry10_image[14]);
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value10 && !play) playSound(true);

            while (value10 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry10_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value10 && play) playSound(false);

            if (value10) episode_number = 18;
        }
    }


    public void cherry10updateDB(){
        Cherry_Database database = Cherry_Database.getInstance(UseAll.mainContext);

        String sql = "UPDATE " +  Cherry_Database.table1 + " SET isLock='false' WHERE charactor = 'adachi' and number = 4" ;
        database.execSQL(sql) ;
    }

    class normalAnimListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            Cherry10_Thread8 thread8 = new Cherry10_Thread8();
            thread8.start();
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
