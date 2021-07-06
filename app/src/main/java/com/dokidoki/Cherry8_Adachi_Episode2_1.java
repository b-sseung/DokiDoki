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

public class Cherry8_Adachi_Episode2_1 extends AppCompatActivity {

    ImageView cherry8_background;
    TextView cherry8_menu_button;

    OutlineTextView cherry8_textView1, cherry8_textView2;

    FrameLayout cherry8_title;

    String[] cherry8_text = new String[]{"삐비비비비-----", "내가 마법사가 된지 1주일이 지났다.", //0, 1
            "그럼에도 불구하고 언제나 그래왔듯이", "나는 일어나자마자 출근 준비를 하고,", //2, 3
            "출근 길에 주먹밥 가게에 들린다.", "이게 나의 출근 루트이니까", //4, 5
            "그런 와중에 나의 적응 능력은 놀라울 따름이다", "퀵페이 모바일을 이용하여 결제하고,", //6, 7
            "일찍 일어나 러시아워도 피해서", "이 정도면 일부러 나한테 부딪히는 사람은 거의 없다.",  //8, 9
            "이 힘이 망상이든 마법이든", "매일의 생활은 바뀌지 않는다.",  //10, 11
            "만약 그 미신이 사실이라면", "동정을 졸업하게 되면 ",  //12, 13
            "이 힘도 사라지게 되겠지만..", "그것도 현실적으론 거의 불가능에 가깝겠지..", //14, 15
            "\"막 올라갔다보네\"", "먼저 엘리베이터를 타고 올라가서", "마음을 읽어야할 사람의 마음을 읽지 못했다.", //16, 17, 18
            "\"먼저 타세요\"", "다음 엘리베이터에는 사람이 별로 안탔으면 좋겠다", //19, 20
            "엘리베이터가 떠난 후, 막 도착한 쿠로사와가 말을 걸어온다.", "\"좋은 아침. 오늘 일찍 왔네\"",  //21, 22
            "\"응\"", "언제 이렇게 가까이 왔지?" //23, 24
    };

    int[] cherry8_image = new int[]{R.drawable.cherry008_adachi_play_episode2_1_background1, R.drawable.cherry008_adachi_play_episode2_1_background2, //0, 1
            R.drawable.cherry008_adachi_play_episode2_1_background3, R.drawable.cherry008_adachi_play_episode2_1_background4, //2, 3
            R.drawable.cherry008_adachi_play_episode2_2_background1, R.drawable.cherry008_adachi_play_episode2_2_background2, //4, 5
            R.drawable.cherry008_adachi_play_episode2_2_background3, R.drawable.cherry008_adachi_play_episode2_2_background4, //6, 7
            R.drawable.cherry008_adachi_play_episode2_2_background5, R.drawable.cherry008_adachi_play_episode2_3_background1, //8, 9
            R.drawable.cherry008_adachi_play_episode2_3_background2, R.drawable.cherry008_adachi_play_episode2_3_background3, //10, 11
            R.drawable.cherry008_adachi_play_episode2_4_background1, R.drawable.cherry008_adachi_play_episode2_4_background2, //12, 13
            R.drawable.cherry008_adachi_play_episode2_4_background4, //14
            R.drawable.adachi_collection003_background, //15
            R.drawable.cherry008_adachi_play_episode2_5_background1, R.drawable.cherry008_adachi_play_episode2_5_background2, //16, 17
            R.drawable.cherry008_adachi_play_episode2_5_background3, R.drawable.cherry008_adachi_play_episode2_5_background4 //18, 19

    };

    boolean value1 = true, value2 = true, value3 = true, value4 = true, value5 = true, value6 = true, value7 = true,
        value8 = true, value9 = true, value10 = true, value11 = true, value12 = true, value13 = true;

    LinearLayout cherry8_next_button;

    TextView cherry8_case1, cherry8_case2;
    ImageView cherry8_75_black, cherry8_bad_text;
    OutlineTextView cherry8_back_episode, cherry8_count, cherry8_ending_textView1, cherry8_ending_textView2, cherry8_ending_textView3;
    FrameLayout cherry8_bad_layout;

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
        setContentView(R.layout.cherry008_activity_adachi_episode2_1);

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
        UseAll.soundStart(5);

        cherry8_background = findViewById(R.id.cherry8_background);
        cherry8_menu_button = findViewById(R.id.cherry8_menu_button);

        cherry8_textView1 = findViewById(R.id.cherry8_textview1);
        cherry8_textView2 = findViewById(R.id.cherry8_textview2);

        cherry8_next_button = findViewById(R.id.cherry8_next_button);

        cherry8_title = findViewById(R.id.cherry8_title);

        cherry8_case1 = findViewById(R.id.cherry8_case1);
        cherry8_case2 = findViewById(R.id.cherry8_case2);

        cherry8_75_black = findViewById(R.id.cherry8_75_black);
        cherry8_bad_layout = findViewById(R.id.cherry8_bad_layout);
        cherry8_bad_text = findViewById(R.id.cherry8_bad_text);
        cherry8_back_episode = findViewById(R.id.cherry8_back_episode);
        cherry8_count = findViewById(R.id.cherry8_count);
        cherry8_ending_textView1 = findViewById(R.id.cherry8_ending_textView1);
        cherry8_ending_textView2 = findViewById(R.id.cherry8_ending_textView2);
        cherry8_ending_textView3 = findViewById(R.id.cherry8_ending_textView3);

        cherry8_menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (episode_number != 2 && episode_number != 4 && episode_number != 6 && episode_number != 8
                        && episode_number != 10 && episode_number != 12 && episode_number != 14 && episode_number != 18
                        && episode_number != 20 && episode_number != 22 && episode_number != 24){
                    clickFunc();
                }

                Intent intent = new Intent(getApplicationContext(), Cherry100_Episode_Pause.class);
                startActivityForResult(intent, 101);
            }
        });

        Animation outAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.activity_alpha_out);
        OutAnimationListener animListener = new OutAnimationListener();
        outAnim.setAnimationListener(animListener);

        cherry8_title.setVisibility(View.VISIBLE);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                cherry8_title.startAnimation(outAnim);
            }
        }, 3000);

        cherry8_next_button.setVisibility(View.INVISIBLE);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                episode_number = 1;
                cherry8_next_button.setVisibility(View.VISIBLE);
                Cherry8_Thread1 thread1 = new Cherry8_Thread1();
                thread1.start();
            }
        }, 5000);

        cherry8_case1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (episode_number == 16){
                    cherry8_next_button.setVisibility(View.INVISIBLE);
                    episode_number = 17;
                    cherry8_case1.setVisibility(View.INVISIBLE);
                    cherry8_case2.setVisibility(View.INVISIBLE);
                    cherry8_textView1.setText("");
                    cherry8_textView2.setText("");
                    cherry8_background.setImageResource(cherry8_image[15]);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Cherry8_Thread9 thread9 = new Cherry8_Thread9();
                            thread9.start();
                            cherry8_next_button.setVisibility(View.VISIBLE);
                        }
                    }, 1500);
                }
            }
        });

        cherry8_case2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (episode_number == 16){
                    cherry8_next_button.setVisibility(View.INVISIBLE);
                    episode_number = 19;
                    cherry8_case1.setVisibility(View.INVISIBLE);
                    cherry8_case2.setVisibility(View.INVISIBLE);
                    cherry8_textView1.setText("");
                    cherry8_textView2.setText("");
                    cherry8_background.setImageResource(cherry8_image[13]);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Cherry8_Thread11 thread11 = new Cherry8_Thread11();
                            thread11.start();
                            cherry8_next_button.setVisibility(View.VISIBLE);
                        }
                    }, 1500);
                }
            }
        });

        cherry8_back_episode.setOnClickListener(new View.OnClickListener() {
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

        cherry8_next_button.setOnClickListener(new View.OnClickListener() {
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
            cherry8_next_button.setVisibility(View.INVISIBLE);
            episode_number = 2;
            cherry8_background.setImageResource(cherry8_image[1]);
            cherry8_textView1.setText(cherry8_text[0]);
            cherry8_textView2.setText(cherry8_text[1]);
            cherry8_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 2){
            cherry8_next_button.setVisibility(View.INVISIBLE);
            episode_number = 3;
            cherry8_textView1.setText("");
            cherry8_textView2.setText("");
            cherry8_background.setImageResource(cherry8_image[2]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry8_Thread2 thread2 = new Cherry8_Thread2();
                    thread2.start();
                    cherry8_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 3){
            if (play) playSound(false);
            value2 = false;
            cherry8_next_button.setVisibility(View.INVISIBLE);
            episode_number = 4;
            cherry8_background.setImageResource(cherry8_image[3]);
            cherry8_textView1.setText(cherry8_text[2]);
            cherry8_textView2.setText(cherry8_text[3]);
            cherry8_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 4){
            cherry8_next_button.setVisibility(View.INVISIBLE);
            episode_number = 5;
            cherry8_textView1.setText("");
            cherry8_textView2.setText("");
            cherry8_background.setImageResource(cherry8_image[4]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry8_Thread3 thread3 = new Cherry8_Thread3();
                    thread3.start();
                    cherry8_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 5) {
            if (play) playSound(false);
            value3 = false;
            cherry8_next_button.setVisibility(View.INVISIBLE);
            episode_number = 6;
            cherry8_textView1.setText(cherry8_text[4]);
            cherry8_textView2.setText(cherry8_text[5]);
            cherry8_next_button.setVisibility(View.VISIBLE);
        }
        else if (episode_number == 6){
            cherry8_next_button.setVisibility(View.INVISIBLE);
            episode_number = 7;
            cherry8_textView1.setText("");
            cherry8_textView2.setText("");
            cherry8_background.setImageResource(cherry8_image[5]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry8_Thread4 thread4 = new Cherry8_Thread4();
                    thread4.start();
                    cherry8_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 7){
            if (play) playSound(false);
            value4 = false;
            cherry8_next_button.setVisibility(View.INVISIBLE);
            episode_number = 8;
            cherry8_textView1.setText(cherry8_text[6]);
            cherry8_textView2.setText(cherry8_text[7]);
            cherry8_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 8){
            cherry8_next_button.setVisibility(View.INVISIBLE);
            episode_number = 9;
            cherry8_textView1.setText("");
            cherry8_textView2.setText("");
            cherry8_background.setImageResource(cherry8_image[6]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry8_Thread5 thread5 = new Cherry8_Thread5();
                    thread5.start();
                    cherry8_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 9){
            if (play) playSound(false);
            value5 = false;
            cherry8_next_button.setVisibility(View.INVISIBLE);
            episode_number = 10;
            cherry8_background.setImageResource(cherry8_image[7]);
            cherry8_textView1.setText(cherry8_text[8]);
            cherry8_textView2.setText(cherry8_text[9]);
            cherry8_next_button.setVisibility(View.VISIBLE);
        }
        else if (episode_number == 10){
            cherry8_next_button.setVisibility(View.INVISIBLE);
            episode_number = 11;
            cherry8_textView1.setText("");
            cherry8_textView2.setText("");
            cherry8_background.setImageResource(cherry8_image[8]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry8_Thread6 thread6 = new Cherry8_Thread6();
                    thread6.start();
                    cherry8_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 11){
            if (play) playSound(false);
            value6 = false;
            cherry8_next_button.setVisibility(View.INVISIBLE);
            episode_number = 12;
            cherry8_textView1.setText(cherry8_text[10]);
            cherry8_textView2.setText(cherry8_text[11]);
            cherry8_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 12){
            cherry8_next_button.setVisibility(View.INVISIBLE);
            episode_number = 13;
            cherry8_textView1.setText("");
            cherry8_textView2.setText("");
            cherry8_background.setImageResource(cherry8_image[9]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry8_Thread7 thread7 = new Cherry8_Thread7();
                    thread7.start();
                    cherry8_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 13){
            if (play) playSound(false);
            value7 = false;
            cherry8_next_button.setVisibility(View.INVISIBLE);
            episode_number = 14;
            cherry8_background.setImageResource(cherry8_image[11]);
            cherry8_textView1.setText(cherry8_text[12]);
            String temp = cherry8_text[13] + cherry8_text[14];
            cherry8_textView2.setText(temp);
            cherry8_next_button.setVisibility(View.VISIBLE);
        }
        else if (episode_number == 14){
            cherry8_next_button.setVisibility(View.INVISIBLE);
            episode_number = 15;
            cherry8_textView1.setText("");
            cherry8_textView2.setText("");
            cherry8_background.setImageResource(cherry8_image[12]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry8_Thread8 thread8 = new Cherry8_Thread8();
                    thread8.start();
                    cherry8_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 15){
            if (play) playSound(false);
            value8 = false;
            cherry8_next_button.setVisibility(View.INVISIBLE);
            episode_number = 16;
            cherry8_case1.setVisibility(View.VISIBLE);
            cherry8_case2.setVisibility(View.VISIBLE);
            cherry8_textView1.setText(cherry8_text[15]);
        } else if (episode_number == 17){
            if (play) playSound(false);
            value9 = false;
            cherry8_next_button.setVisibility(View.INVISIBLE);
            episode_number = 18;
            cherry8_textView1.setText(cherry8_text[16]);
            cherry8_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 18){
            cherry8_next_button.setVisibility(View.INVISIBLE);
            cherry8_75_black.setVisibility(View.VISIBLE);
            cherry8_bad_text.setVisibility(View.VISIBLE);
//            cherry_testButton.setVisibility(View.INVISIBLE);

            Animation inAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.activity_alpha_in);
            cherry8_75_black.startAnimation(inAnim);
            cherry8_bad_text.startAnimation(inAnim);

            cherry8_back_episode.setVisibility(View.VISIBLE);
            cherry8updateDB();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    FrameLayout layout = findViewById(R.id.cherry8_bad_layout);
                    float temp1 = layout.getHeight();
                    float temp2 = cherry8_bad_text.getHeight();
                    float temp = (temp1 - temp2) * -1;

                    TranslateAnimation move = new TranslateAnimation(0, 0, 0, temp);
                    move.setDuration(500);
                    move.setFillAfter(true);
                    move.setAnimationListener(new badAnimListener());
                    cherry8_bad_text.startAnimation(move);

                }
            }, 1000);
        } else if (episode_number == 19){
            if (play) playSound(false);
            value11 = false;
            cherry8_next_button.setVisibility(View.INVISIBLE);
            episode_number = 20;
            cherry8_background.setImageResource(cherry8_image[14]);
            cherry8_textView1.setText(cherry8_text[19]);
            cherry8_textView2.setText(cherry8_text[20]);
            cherry8_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 20){
            if (UseAll.player != null && UseAll.player.isPlaying()) UseAll.soundStop();
            UseAll.soundStart(3);
            cherry8_next_button.setVisibility(View.INVISIBLE);
            episode_number = 21;
            cherry8_textView1.setText("");
            cherry8_textView2.setText("");
            cherry8_background.setImageResource(cherry8_image[16]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry8_Thread12 thread12 = new Cherry8_Thread12();
                    thread12.start();
                    cherry8_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 21){
            if (play) playSound(false);
            value12 = false;
            cherry8_next_button.setVisibility(View.INVISIBLE);
            episode_number = 22;
            cherry8_textView1.setText(cherry8_text[21]);
            cherry8_textView2.setText(cherry8_text[22]);
            cherry8_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 22){
            cherry8_next_button.setVisibility(View.INVISIBLE);
            episode_number = 23;
            cherry8_textView1.setText("");
            cherry8_textView2.setText("");
            cherry8_background.setImageResource(cherry8_image[17]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry8_Thread13 thread13 = new Cherry8_Thread13();
                    thread13.start();
                    cherry8_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 23){
            if (play) playSound(false);
            value13 = false;
            cherry8_next_button.setVisibility(View.INVISIBLE);
            episode_number = 24;
            cherry8_background.setImageResource(cherry8_image[19]);
            cherry8_textView1.setText(cherry8_text[23]);
            cherry8_textView2.setText(cherry8_text[24]);
            cherry8_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 24){
            Intent intent = new Intent(getApplicationContext(), Cherry9_Adachi_Episode2_2.class);
            startActivity(intent);

            overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
            finish();
        }
    }

    class Cherry8_Thread1 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry8_text[0].split("");
        String[] text2_list = cherry8_text[1].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value1 && !play) playSound(true);

            while (value1 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry8_textView1.setText(text1_build.toString());
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
                        cherry8_background.setImageResource(cherry8_image[1]);
                    }
                }
            });

            try {
                if (value1) Thread.sleep(500);
            } catch (Exception e) { }

            if (value1 && !play) playSound(true);

            while (value1 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry8_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value1 && play) playSound(false);

            if (value1) episode_number = 2;
        }
    }

    class Cherry8_Thread2 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry8_text[2].split("");
        String[] text2_list = cherry8_text[3].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value2 && !play) playSound(true);

            while (value2 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry8_textView1.setText(text1_build.toString());
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
                        cherry8_background.setImageResource(cherry8_image[3]);
                    }
                }
            });

            try {
                if (value2) Thread.sleep(500);
            } catch (Exception e) { }

            if (value2 && !play) playSound(true);

            while (value2 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry8_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value2 && play) playSound(false);

            if (value2) episode_number = 4;
        }
    }

    class Cherry8_Thread3 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry8_text[4].split("");
        String[] text2_list = cherry8_text[5].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value3 && !play) playSound(true);

            while (value3 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry8_textView1.setText(text1_build.toString());
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
                cherry8_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value3 && play) playSound(false);

            if (value3) episode_number = 6;
        }
    }

    class Cherry8_Thread4 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry8_text[6].split("");
        String[] text2_list = cherry8_text[7].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value4 && !play) playSound(true);

            while (value4 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry8_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value4 && play) playSound(false);

            try {
                if (value4) Thread.sleep(1500);
            } catch (Exception e) { }

            if (value4 && !play) playSound(true);

            while (value4 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry8_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value4 && play) playSound(false);

            if (value4) episode_number = 8;
        }
    }

    class Cherry8_Thread5 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry8_text[8].split("");
        String[] text2_list = cherry8_text[9].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value5 && !play) playSound(true);

            while (value5 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry8_textView1.setText(text1_build.toString());
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
                        cherry8_background.setImageResource(cherry8_image[7]);
                    }
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value5 && !play) playSound(true);

            while (value5 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry8_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value5 && play) playSound(false);

            if (value5) episode_number = 10;
        }
    }

    class Cherry8_Thread6 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry8_text[10].split("");
        String[] text2_list = cherry8_text[11].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value6 && !play) playSound(true);

            while (value6 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry8_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value6 && play) playSound(false);

            try {
                if (value6) Thread.sleep(1500);
            } catch (Exception e) { }

            if (value6 && !play) playSound(true);

            while (value6 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry8_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value6 && play) playSound(false);

            if (value6) episode_number = 12;
        }
    }

    class Cherry8_Thread7 extends Thread{
        int text1_time = 0;
        int text2_time = 0;
        int text3_time = 0;

        String[] text1_list = cherry8_text[12].split("");
        String[] text2_list = cherry8_text[13].split("");
        String[] text3_list = cherry8_text[14].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value7 && !play) playSound(true);

            while (value7 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry8_textView1.setText(text1_build.toString());
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
                        cherry8_background.setImageResource(cherry8_image[10]);
                    }
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value7 && !play) playSound(true);

            while (value7 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry8_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value7 && play) playSound(false);

            try {
                if (value7) Thread.sleep(500);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value7){
                        cherry8_background.setImageResource(cherry8_image[11]);
                    }
                }
            });

            try {
                if (value7) Thread.sleep(300);
            } catch (Exception e) { }

            if (value7 && !play) playSound(true);

            while (value7 && text3_time < text3_list.length){
                text2_build.append(text3_list[text3_time]);
                cherry8_textView2.setText(text2_build.toString());
                text3_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value7 && play) playSound(false);

            if (value7) episode_number = 14;
        }
    }

    class Cherry8_Thread8 extends Thread{
        int text1_time = 0;

        String[] text1_list = cherry8_text[15].split("");

        StringBuilder text1_build = new StringBuilder();

        @Override
        public void run() {

            if (value8 && !play) playSound(true);

            while (value8 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry8_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value8 && play) playSound(false);

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value8){
                        cherry8_case1.setVisibility(View.VISIBLE);
                        cherry8_case2.setVisibility(View.VISIBLE);
                        cherry8_next_button.setVisibility(View.INVISIBLE);
                    }
                }
            });

            if (value8) episode_number = 16;
        }
    }

    class Cherry8_Thread9 extends Thread{
        int text1_time = 0;

        String[] text1_list = cherry8_text[16].split("");

        StringBuilder text1_build = new StringBuilder();

        @Override
        public void run() {

            if (value9 && !play) playSound(true);

            while (value9 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry8_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value9 && play) playSound(false);

            if (value9) episode_number = 18;
        }
    }

    class Cherry8_Thread10 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry8_text[17].split("");
        String[] text2_list = cherry8_text[18].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value10 && !play) playSound(true);

            while (value10 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry8_ending_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value10 && play) playSound(false);

            if (value10 && !play) playSound(true);

            while (value10 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry8_ending_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value10 && play) playSound(false);

            int text_time = 60;
            String text = "초 후에 자동으로 이동합니다.";

            while (value10 && text_time > 0) {
                cherry8_count.setText(text_time + text);
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

    class Cherry8_Thread11 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry8_text[19].split("");
        String[] text2_list = cherry8_text[20].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value11 && !play) playSound(true);

            while (value11 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry8_textView1.setText(text1_build.toString());
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
                    if (value11){
                        cherry8_background.setImageResource(cherry8_image[14]);
                    }
                }
            });

            try {
                if (value11) Thread.sleep(500);
            } catch (Exception e) { }


            if (value11 && !play) playSound(true);

            while (value11 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry8_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value11 && play) playSound(false);

            if (value11) episode_number = 20;
        }
    }

    class Cherry8_Thread12 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry8_text[21].split("");
        String[] text2_list = cherry8_text[22].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value12 && !play) playSound(true);

            while (value12 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry8_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value12 && play) playSound(false);

            try {
                if (value12) Thread.sleep(1500);
            } catch (Exception e) { }

            if (value12 && !play) playSound(true);

            while (value12 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry8_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value12 && play) playSound(false);

            if (value12) episode_number = 22;
        }
    }

    class Cherry8_Thread13 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry8_text[23].split("");
        String[] text2_list = cherry8_text[24].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value13 && !play) playSound(true);

            while (value13 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry8_textView1.setText(text1_build.toString());
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
                    if (value13) {
                        cherry8_background.setImageResource(cherry8_image[18]);
                    }
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value13 && !play) playSound(true);

            while (value13 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry8_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value13 && play) playSound(false);

            try {
                if (value13) Thread.sleep(1000);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value13) {
                        cherry8_background.setImageResource(cherry8_image[19]);
                    }
                }
            });

            if (value13) episode_number = 24;
        }
    }

    public void cherry8updateDB(){
        Cherry_Database database = Cherry_Database.getInstance(UseAll.mainContext);

        String sql = "UPDATE " +  Cherry_Database.table1 + " SET isLock='false' WHERE charactor = 'adachi' and number = 3" ;
        database.execSQL(sql) ;
    }


    private class OutAnimationListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if (episode_number == 0) {
                cherry8_title.setVisibility(View.INVISIBLE);
                return;
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }

    class badAnimListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            Cherry8_Thread10 thread10 = new Cherry8_Thread10();
            thread10.start();
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
