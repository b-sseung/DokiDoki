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

public class Cherry13_Adachi_Episode3_3 extends AppCompatActivity {

    ImageView cherry13_background;
    TextView cherry13_menu_button;

    OutlineTextView cherry13_textView1, cherry13_textView2;

    String[] cherry13_text = new String[]{"\"괜찮아 정말 쌀쌀해졌네\"", "갑자기 쿠로사와가 자신의 가방에서 무언가를 찾고 있다.", //0, 1
            "잠시 후 목도리를 꺼내 나에게 건넨다.", "\"빌려줄게\"", //2, 3
            "\"고마워\"", "\"자\"", //4, 5
            "\"아냐, 네가 해 네가 감기 걸리면 다들 곤란해지잖아 나는 딱히...\"", "\"괜찮아 자\"", //6, 7
            "'아다치는 자신에 대한 평가가 너무 낮아'", "쿠로사와의 마음의 소리가 들려오기 시작한다.", //8, 9
            "'항상 주변 분위기를 파악하고 한발 뒤로 물러나고", "오늘 아침에도 엘리베이터 순서를 양보하고,", //10, 11
            "선배의 일을 떠맡게 되어도 싫은 내색도 안 하고", "사실은 정말 착하고 좋은 녀석인데...", //12, 13
            "게다가 일도 꼼꼼하고 확실하게 해", "그런 점을 나는...'", //14, 15
            "\"됐다. 잘 어울리네\"", "쿠로사와의 속마음을 마지막까지는 다 듣지 못했다.", //16, 17
            "하지만... 나에 대해서 이만큼 생각해주는 사람이 있을 줄은 상상도 못 했어", "큰일이다 울 것 같아", //18, 19
            "\"그럼 갈까?\"", "나는 나올 것 같은 눈물을 참고 앞장서 걷기 시작했다.", //20, 21
            "\"아다치, 아직 전철 있어?\"", "\"응?\"", //22, 23
            "나는 쿠로사와의 말을 듣고 서둘러 전차 시간표를 확인했다.", "\"막차 끊겼네\"", //24, 25
            "\"역시\"", "\"그래도 괜찮아 PC방 같은 데서 자면 돼 오늘, 고마웠어 갈게\"" //26, 27
    };

    int[] cherry13_image = new int[]{R.drawable.cherry013_adachi_play_episode3_7_background1, R.drawable.cherry013_adachi_play_episode3_7_background2, //0, 1
            R.drawable.cherry013_adachi_play_episode3_7_background3, R.drawable.cherry013_adachi_play_episode3_7_background4, //2, 3
            R.drawable.cherry013_adachi_play_episode3_7_background5, R.drawable.cherry013_adachi_play_episode3_7_background6, //4, 5
            R.drawable.cherry013_adachi_play_episode3_7_background7, R.drawable.cherry013_adachi_play_episode3_7_background8, //6, 7
            R.drawable.cherry013_adachi_play_episode3_7_background9, R.drawable.cherry013_adachi_play_episode3_7_background10, //8, 9
            R.drawable.cherry013_adachi_play_episode3_7_background11, R.drawable.cherry013_adachi_play_episode3_7_background12, //10, 11
            R.drawable.cherry013_adachi_play_episode3_7_background13, R.drawable.cherry013_adachi_play_episode3_8_background1, //12, 13
            R.drawable.cherry013_adachi_play_episode3_8_background2, R.drawable.cherry013_adachi_play_episode3_8_background3, //14, 15
            R.drawable.cherry013_adachi_play_episode3_8_background4, R.drawable.cherry013_adachi_play_episode3_8_background5, //16, 17
            R.drawable.cherry013_adachi_play_episode3_9_background1, R.drawable.cherry013_adachi_play_episode3_9_background2, //18, 19
            R.drawable.cherry013_adachi_play_episode3_9_background3, R.drawable.cherry013_adachi_play_episode3_9_background4, //20, 21
            R.drawable.cherry013_adachi_play_episode3_9_background5 //22
    };

    boolean value1 = true, value2 = true, value3 = true, value4 = true, value5 = true, value6 = true, value7 = true,
            value8 = true, value9 = true, value10 = true, value11 = true, value12 = true, value13 = true;

    LinearLayout cherry13_next_button;

    TextView cherry13_case1, cherry13_case2;

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
        setContentView(R.layout.cherry013_activity_adachi_episode3_3);

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
        UseAll.soundStart(19);

        cherry13_background = findViewById(R.id.cherry13_background);
        cherry13_menu_button = findViewById(R.id.cherry13_menu_button);

        cherry13_textView1 = findViewById(R.id.cherry13_textview1);
        cherry13_textView2 = findViewById(R.id.cherry13_textview2);

        cherry13_next_button = findViewById(R.id.cherry13_next_button);

        cherry13_case1 = findViewById(R.id.cherry13_case1);
        cherry13_case2 = findViewById(R.id.cherry13_case2);

        cherry13_menu_button.setOnClickListener(new View.OnClickListener() {
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

        cherry13_next_button.setVisibility(View.INVISIBLE);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                episode_number = 1;
                cherry13_next_button.setVisibility(View.VISIBLE);
                Cherry13_Thread1 thread1 = new Cherry13_Thread1();
                thread1.start();
            }
        }, 3000);

        cherry13_case1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (episode_number == 4){
                    cherry13_next_button.setVisibility(View.INVISIBLE);
                    episode_number = 5;
                    cherry13_case1.setVisibility(View.INVISIBLE);
                    cherry13_case2.setVisibility(View.INVISIBLE);
                    cherry13_textView1.setText("");
                    cherry13_textView2.setText("");
                    cherry13_background.setImageResource(cherry13_image[3]);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Cherry13_Thread3 thread3 = new Cherry13_Thread3();
                            thread3.start();
                            cherry13_next_button.setVisibility(View.VISIBLE);
                        }
                    }, 1500);
                }
            }
        });

        cherry13_case2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (episode_number == 4){
                    cherry13_next_button.setVisibility(View.INVISIBLE);
                    episode_number = 7;
                    cherry13_case1.setVisibility(View.INVISIBLE);
                    cherry13_case2.setVisibility(View.INVISIBLE);
                    cherry13_textView1.setText("");
                    cherry13_textView2.setText("");
                    cherry13_background.setImageResource(cherry13_image[3]);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Cherry13_Thread3 thread3 = new Cherry13_Thread3();
                            thread3.start();
                            cherry13_next_button.setVisibility(View.VISIBLE);
                        }
                    }, 1500);
                }
            }
        });

        cherry13_next_button.setOnClickListener(new View.OnClickListener() {
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
            cherry13_next_button.setVisibility(View.INVISIBLE);
            episode_number = 2;
            cherry13_background.setImageResource(cherry13_image[1]);
            cherry13_textView1.setText(cherry13_text[0]);
            cherry13_textView2.setText(cherry13_text[1]);
            cherry13_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 2){
            cherry13_next_button.setVisibility(View.INVISIBLE);
            episode_number = 3;
            cherry13_textView1.setText("");
            cherry13_textView2.setText("");
            cherry13_background.setImageResource(cherry13_image[2]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry13_Thread2 thread2 = new Cherry13_Thread2();
                    thread2.start();
                    cherry13_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 3){
            if (play) playSound(false);
            value2 = false;
            cherry13_next_button.setVisibility(View.INVISIBLE);
            cherry13_case1.setVisibility(View.VISIBLE);
            cherry13_case2.setVisibility(View.VISIBLE);
            episode_number = 4;
            cherry13_textView1.setText(cherry13_text[2]);
            cherry13_textView2.setText(cherry13_text[3]);
        } else if (episode_number == 5){
            if (play) playSound(false);
            value3 = false;
            cherry13_next_button.setVisibility(View.INVISIBLE);
            cherry13_case1.setVisibility(View.INVISIBLE);
            cherry13_case2.setVisibility(View.INVISIBLE);
            episode_number = 8;
            cherry13_background.setImageResource(cherry13_image[4]);
            cherry13_textView1.setText(cherry13_text[4]);
            cherry13_textView2.setText(cherry13_text[5]);
            cherry13_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 7){
            if (play) playSound(false);
            value3 = false;
            cherry13_next_button.setVisibility(View.INVISIBLE);
            cherry13_case1.setVisibility(View.INVISIBLE);
            cherry13_case2.setVisibility(View.INVISIBLE);
            episode_number = 8;
            cherry13_background.setImageResource(cherry13_image[4]);
            cherry13_textView1.setText(cherry13_text[6]);
            cherry13_textView2.setText(cherry13_text[7]);
            cherry13_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 8){
            if (UseAll.player != null && UseAll.player.isPlaying()) UseAll.soundStop();
            UseAll.soundStart(13);
            cherry13_next_button.setVisibility(View.INVISIBLE);
            episode_number = 9;
            cherry13_textView1.setText("");
            cherry13_textView2.setText("");
            cherry13_background.setImageResource(cherry13_image[5]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry13_Thread4 thread4 = new Cherry13_Thread4();
                    thread4.start();
                    cherry13_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 9){
            if (play) playSound(false);
            value4 = false;
            cherry13_next_button.setVisibility(View.INVISIBLE);
            episode_number = 10;
            cherry13_background.setImageResource(cherry13_image[6]);
            cherry13_textView1.setText(cherry13_text[8]);
            cherry13_textView2.setText(cherry13_text[9]);
            cherry13_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 10){
            cherry13_next_button.setVisibility(View.INVISIBLE);
            episode_number = 11;
            cherry13_textView1.setText("");
            cherry13_textView2.setText("");
            cherry13_background.setImageResource(cherry13_image[7]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry13_Thread5 thread5 = new Cherry13_Thread5();
                    thread5.start();
                    cherry13_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 11){
            if (play) playSound(false);
            value5 = false;
            cherry13_next_button.setVisibility(View.INVISIBLE);
            episode_number = 12;
            cherry13_background.setImageResource(cherry13_image[8]);
            cherry13_textView1.setText(cherry13_text[10]);
            cherry13_textView2.setText(cherry13_text[11]);
            cherry13_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 12){
            cherry13_next_button.setVisibility(View.INVISIBLE);
            episode_number = 13;
            cherry13_textView1.setText("");
            cherry13_textView2.setText("");
            cherry13_background.setImageResource(cherry13_image[9]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry13_Thread6 thread6 = new Cherry13_Thread6();
                    thread6.start();
                    cherry13_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 13){
            if (play) playSound(false);
            value6 = false;
            cherry13_next_button.setVisibility(View.INVISIBLE);
            episode_number = 14;
            cherry13_background.setImageResource(cherry13_image[10]);
            cherry13_textView1.setText(cherry13_text[12]);
            cherry13_textView2.setText(cherry13_text[13]);
            cherry13_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 14){
            cherry13_next_button.setVisibility(View.INVISIBLE);
            episode_number = 15;
            cherry13_textView1.setText("");
            cherry13_textView2.setText("");
            cherry13_background.setImageResource(cherry13_image[11]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry13_Thread7 thread7 = new Cherry13_Thread7();
                    thread7.start();
                    cherry13_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 15){
            if (play) playSound(false);
            value7 = false;
            cherry13_next_button.setVisibility(View.INVISIBLE);
            episode_number = 16;
            cherry13_background.setImageResource(cherry13_image[12]);
            cherry13_textView1.setText(cherry13_text[14]);
            cherry13_textView2.setText(cherry13_text[15]);
            cherry13_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 16){
            cherry13_next_button.setVisibility(View.INVISIBLE);
            episode_number = 17;
            cherry13_textView1.setText("");
            cherry13_textView2.setText("");
            cherry13_background.setImageResource(cherry13_image[13]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry13_Thread8 thread8 = new Cherry13_Thread8();
                    thread8.start();
                    cherry13_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 17){
            if (play) playSound(false);
            value8 = false;
            cherry13_next_button.setVisibility(View.INVISIBLE);
            episode_number = 18;
            cherry13_background.setImageResource(cherry13_image[14]);
            cherry13_textView1.setText(cherry13_text[16]);
            cherry13_textView2.setText(cherry13_text[17]);
            cherry13_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 18){
            cherry13_next_button.setVisibility(View.INVISIBLE);
            episode_number = 19;
            cherry13_textView1.setText("");
            cherry13_textView2.setText("");
            cherry13_background.setImageResource(cherry13_image[15]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry13_Thread9 thread9 = new Cherry13_Thread9();
                    thread9.start();
                    cherry13_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 19){
            if (play) playSound(false);
            value9 = false;
            cherry13_next_button.setVisibility(View.INVISIBLE);
            episode_number = 20;
            cherry13_background.setImageResource(cherry13_image[16]);
            cherry13_textView1.setText(cherry13_text[18]);
            cherry13_textView2.setText(cherry13_text[19]);
            cherry13_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 20){
            cherry13_next_button.setVisibility(View.INVISIBLE);
            episode_number = 21;
            cherry13_textView1.setText("");
            cherry13_textView2.setText("");
            cherry13_background.setImageResource(cherry13_image[17]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry13_Thread10 thread10 = new Cherry13_Thread10();
                    thread10.start();
                    cherry13_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 21){
            if (play) playSound(false);
            value10 = false;
            cherry13_next_button.setVisibility(View.INVISIBLE);
            episode_number = 22;
            cherry13_textView1.setText(cherry13_text[20]);
            cherry13_textView2.setText(cherry13_text[21]);
            cherry13_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 22){
            cherry13_next_button.setVisibility(View.INVISIBLE);
            episode_number = 23;
            cherry13_textView1.setText("");
            cherry13_textView2.setText("");
            cherry13_background.setImageResource(cherry13_image[18]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry13_Thread11 thread11 = new Cherry13_Thread11();
                    thread11.start();
                    cherry13_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 23){
            if (play) playSound(false);
            value11 = false;
            cherry13_next_button.setVisibility(View.INVISIBLE);
            episode_number = 24;
            cherry13_background.setImageResource(cherry13_image[19]);
            cherry13_textView1.setText(cherry13_text[22]);
            cherry13_textView2.setText(cherry13_text[23]);
            cherry13_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 24){
            cherry13_next_button.setVisibility(View.INVISIBLE);
            episode_number = 25;
            cherry13_textView1.setText("");
            cherry13_textView2.setText("");
            cherry13_background.setImageResource(cherry13_image[20]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry13_Thread12 thread12 = new Cherry13_Thread12();
                    thread12.start();
                    cherry13_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 25){
            if (play) playSound(false);
            value12 = false;
            cherry13_next_button.setVisibility(View.INVISIBLE);
            episode_number = 26;
            cherry13_textView1.setText(cherry13_text[24]);
            cherry13_textView2.setText(cherry13_text[25]);
            cherry13_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 26){
            cherry13_next_button.setVisibility(View.INVISIBLE);
            episode_number = 27;
            cherry13_textView1.setText("");
            cherry13_textView2.setText("");
            cherry13_background.setImageResource(cherry13_image[21]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry13_Thread13 thread13 = new Cherry13_Thread13();
                    thread13.start();
                    cherry13_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 27){
            if (play) playSound(false);
            value13 = false;
            cherry13_next_button.setVisibility(View.INVISIBLE);
            episode_number = 28;
            cherry13_background.setImageResource(cherry13_image[22]);
            cherry13_textView1.setText(cherry13_text[26]);
            cherry13_textView2.setText(cherry13_text[27]);
            cherry13_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 28) {
            Intent intent = new Intent(getApplicationContext(), Cherry14_Adachi_Episode3_4.class);
            startActivity(intent);

            overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
            finish();
        }
    }

    class Cherry13_Thread1 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry13_text[0].split("");
        String[] text2_list = cherry13_text[1].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value1 && !play) playSound(true);

            while (value1 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry13_textView1.setText(text1_build.toString());
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
                        cherry13_background.setImageResource(cherry13_image[1]);
                    }
                }
            });

            try {
                if (value1) Thread.sleep(500);
            } catch (Exception e) { }

            if (value1 && !play) playSound(true);

            while (value1 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry13_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value1 && play) playSound(false);

            if (value1) episode_number = 2;
        }
    }

    class Cherry13_Thread2 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry13_text[2].split("");
        String[] text2_list = cherry13_text[3].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value2 && !play) playSound(true);

            while (value2 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry13_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value2 && play) playSound(false);

            try {
                if (value2) Thread.sleep(1500);
            } catch (Exception e) { }

            if (value2 && !play) playSound(true);

            while (value2 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry13_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value2 && play) playSound(false);

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value2) {
                        cherry13_next_button.setVisibility(View.INVISIBLE);
                        cherry13_case1.setVisibility(View.VISIBLE);
                        cherry13_case2.setVisibility(View.VISIBLE);
                    }
                }
            });

            if (value2) episode_number = 4;
        }
    }

    class Cherry13_Thread3 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = (episode_number == 5) ? cherry13_text[4].split("") : cherry13_text[6].split("");
        String[] text2_list = (episode_number == 5) ? cherry13_text[5].split("") : cherry13_text[7].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value3 && !play) playSound(true);

            while (value3 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry13_textView1.setText(text1_build.toString());
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
                    if (value3) cherry13_background.setImageResource(cherry13_image[4]);
                }
            });

            try {
                if (value3) Thread.sleep(500);
            } catch (Exception e) { }

            if (value3 && !play) playSound(true);

            while (value3 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry13_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value3 && play) playSound(false);

            if (value3) episode_number = 8;
        }
    }

    class Cherry13_Thread4 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry13_text[8].split("");
        String[] text2_list = cherry13_text[9].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value4 && !play) playSound(true);

            while (value4 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry13_textView1.setText(text1_build.toString());
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
                    if (value4) cherry13_background.setImageResource(cherry13_image[6]);
                }
            });

            try {
                if (value4) Thread.sleep(500);
            } catch (Exception e) { }

            if (value4 && !play) playSound(true);

            while (value4 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry13_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value4 && play) playSound(false);

            if (value4) episode_number = 10;
        }
    }

    class Cherry13_Thread5 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry13_text[10].split("");
        String[] text2_list = cherry13_text[11].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value5 && !play) playSound(true);

            while (value5 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry13_textView1.setText(text1_build.toString());
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
                    if (value5) cherry13_background.setImageResource(cherry13_image[8]);
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value5 && !play) playSound(true);

            while (value5 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry13_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value5 && play) playSound(false);

            if (value5) episode_number = 12;
        }
    }

    class Cherry13_Thread6 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry13_text[12].split("");
        String[] text2_list = cherry13_text[13].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value6 && !play) playSound(true);

            while (value6 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry13_textView1.setText(text1_build.toString());
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
                    if (value6) cherry13_background.setImageResource(cherry13_image[10]);
                }
            });

            try {
                if (value6) Thread.sleep(500);
            } catch (Exception e) { }

            if (value6 && !play) playSound(true);

            while (value6 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry13_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value6 && play) playSound(false);

            if (value6) episode_number = 14;
        }
    }

    class Cherry13_Thread7 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry13_text[14].split("");
        String[] text2_list = cherry13_text[15].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value7 && !play) playSound(true);

            while (value7 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry13_textView1.setText(text1_build.toString());
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
                    if (value7) cherry13_background.setImageResource(cherry13_image[12]);
                }
            });

            try {
                if (value7) Thread.sleep(500);
            } catch (Exception e) { }

            if (value7 && !play) playSound(true);

            while (value7 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry13_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value7 && play) playSound(false);

            if (value7) episode_number = 16;
        }
    }

    class Cherry13_Thread8 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry13_text[16].split("");
        String[] text2_list = cherry13_text[17].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value8 && !play) playSound(true);

            while (value8 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry13_textView1.setText(text1_build.toString());
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
                    if (value8) cherry13_background.setImageResource(cherry13_image[14]);
                }
            });

            try {
                if (value8) Thread.sleep(500);
            } catch (Exception e) { }

            if (value8 && !play) playSound(true);

            while (value8 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry13_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value8 && play) playSound(false);

            if (value8) episode_number = 18;
        }
    }

    class Cherry13_Thread9 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry13_text[18].split("");
        String[] text2_list = cherry13_text[19].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value9 && !play) playSound(true);

            while (value9 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry13_textView1.setText(text1_build.toString());
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
                    if (value9) cherry13_background.setImageResource(cherry13_image[16]);
                }
            });

            try {
                if (value9) Thread.sleep(500);
            } catch (Exception e) { }

            if (value9 && !play) playSound(true);

            while (value9 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry13_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value9 && play) playSound(false);

            if (value9) episode_number = 20;
        }
    }

    class Cherry13_Thread10 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry13_text[20].split("");
        String[] text2_list = cherry13_text[21].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value10 && !play) playSound(true);

            while (value10 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry13_textView1.setText(text1_build.toString());
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
                cherry13_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value10 && play) playSound(false);

            if (value10) episode_number = 22;
        }
    }

    class Cherry13_Thread11 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry13_text[22].split("");
        String[] text2_list = cherry13_text[23].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value11 && !play) playSound(true);

            while (value11 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry13_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value11 && play) playSound(false);

            try {
                if (value11) Thread.sleep(1500);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value11) cherry13_background.setImageResource(cherry13_image[19]);
                }
            });

            try {
                if (value11) Thread.sleep(500);
            } catch (Exception e) { }

            if (value11 && !play) playSound(true);

            while (value11 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry13_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value11 && play) playSound(false);

            if (value11) episode_number = 24;
        }
    }

    class Cherry13_Thread12 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry13_text[24].split("");
        String[] text2_list = cherry13_text[25].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value12 && !play) playSound(true);

            while (value12 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry13_textView1.setText(text1_build.toString());
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
                cherry13_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value12 && play) playSound(false);

            if (value12) episode_number = 26;
        }
    }

    class Cherry13_Thread13 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry13_text[26].split("");
        String[] text2_list = cherry13_text[27].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value13 && !play) playSound(true);

            while (value13 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry13_textView1.setText(text1_build.toString());
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
                    if (value13) cherry13_background.setImageResource(cherry13_image[22]);
                }
            });

            try {
                if (value13) Thread.sleep(500);
            } catch (Exception e) { }

            if (value13 && !play) playSound(true);

            while (value13 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry13_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value13 && play) playSound(false);

            if (value13) episode_number = 28;
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