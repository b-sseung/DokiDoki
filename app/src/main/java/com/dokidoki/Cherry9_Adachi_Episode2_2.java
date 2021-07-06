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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Cherry9_Adachi_Episode2_2 extends AppCompatActivity {

    ImageView cherry9_background;
    TextView cherry9_menu_button;

    OutlineTextView cherry9_textView1, cherry9_textView2;

    String[] cherry9_text = new String[]{"\"방금 올라갔나 보네", "계단으로 갈래?\"", //0, 1
            "\"에? 우리 사무실은 10층이잖아\"", "\"운동도 되고 좋은데\"", //2, 3
            "나의 반응에 활짝 웃는 쿠로사와", "눈부셔", //4, 5
            "엘리베이터가 도착하자 서둘러 올라탔고,", "쿠로사와는 타는 사람들과 인사를 나눈다.", //6, 7
            "이런 녀석은 10대 때 동정을 졸업했을 거야", "분명 최고의 인기를 누리는 인생을 살아왔겠지", //8, 9
            "큰일났다", "들어오는 사람들 때문에 쿠로사와랑 너무 가까워졌어", //10, 11
            "\'운이 좋은데? 설마 아침부터 만날 줄이야", "너무 쳐다보면 의심하겠지?\'", //12, 13
            "이 녀석, 회사에 좋아하는 사람이 있는 거야?", "누구야? 최고의 인기남 쿠로사와가 좋아하는 행운아는?", //14, 15
            "\"죄송합니다, 내릴게요\"", "그 순간 뒤에서 나가는 사람에게 밀려 중심을 잃을 것 같다.", //16, 17
            "최대한 중심을 잡아보려고 했지만", "뒤에서 밀려오는 힘에 속수무책이었다.", //18, 19
            "나는 중심을 잃고 얼떨결에 쿠로사와와 카베동 자세가 되어버렸다.", "\"미안 괜찮아?\"", //20, 21
            "'아침부터 이렇게 운이 좋아도 되는 거야? 엄청 두근거려", "심장 소리를 아다치한테 들키진 않을까?'", //22, 23
            "응?", "이건 또 무슨 소리야?", //24, 25
            "나와 쿠로사와는 카베동 자세 그대로", "10층에 도착하여 엘리베이터에서 내렸다.", //26, 27
            "\"오늘도 힘내자\"", "\"그..그래\"", //28, 29
            "대답은 했지만 정신이 없다.", "아까 그 속마음... ", "설마 나?" //30, 31, 32
    };

    int[] cherry9_image = new int[]{R.drawable.cherry009_adachi_play_episode2_6_background1, R.drawable.cherry009_adachi_play_episode2_6_background2, //0, 1
            R.drawable.cherry009_adachi_play_episode2_6_background3, R.drawable.cherry009_adachi_play_episode2_6_background4, //2, 3
            R.drawable.cherry009_adachi_play_episode2_6_background5, R.drawable.cherry009_adachi_play_episode2_6_background6, //4, 5
            R.drawable.cherry009_adachi_play_episode2_6_background7, R.drawable.cherry009_adachi_play_episode2_7_background1, //6, 7
            R.drawable.cherry009_adachi_play_episode2_7_background2, R.drawable.cherry009_adachi_play_episode2_7_background3, //8, 9
            R.drawable.cherry009_adachi_play_episode2_7_background4, R.drawable.cherry009_adachi_play_episode2_7_background5, //10, 11
            R.drawable.cherry009_adachi_play_episode2_7_background6, R.drawable.cherry009_adachi_play_episode2_8_background1, //12, 13
            R.drawable.cherry009_adachi_play_episode2_8_background2, R.drawable.cherry009_adachi_play_episode2_8_background3, //14, 15
            R.drawable.cherry009_adachi_play_episode2_9_background1, R.drawable.cherry009_adachi_play_episode2_9_background2, //16, 17
            R.drawable.cherry009_adachi_play_episode2_9_background3, R.drawable.cherry009_adachi_play_episode2_9_background4, //18, 19
            R.drawable.cherry009_adachi_play_episode2_9_background5, R.drawable.cherry009_adachi_play_episode2_9_case1_background1, //20, 21
            R.drawable.cherry009_adachi_play_episode2_10_background1, R.drawable.cherry009_adachi_play_episode2_10_background2, //22, 23
            R.drawable.cherry009_adachi_play_episode2_10_background3, R.drawable.cherry009_adachi_play_episode2_10_background4, //24, 25
            R.drawable.cherry009_adachi_play_episode2_10_background5, R.drawable.cherry009_adachi_play_episode2_10_background6 //26, 27
    };

    boolean value1 = true, value2 = true, value3 = true, value4 = true, value5 = true, value6 = true, value7 = true,
            value8 = true, value9 = true, value10 = true, value11 = true, value12 = true, value13 = true, value14 = true,
            value15 = true, value16 = true;

    LinearLayout cherry9_next_button;

    TextView cherry9_case1, cherry9_case2;

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
        setContentView(R.layout.cherry009_activity_adachi_episode2_2);

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
        UseAll.soundStart(3);

        cherry9_background = findViewById(R.id.cherry9_background);
        cherry9_menu_button = findViewById(R.id.cherry9_menu_button);

        cherry9_textView1 = findViewById(R.id.cherry9_textview1);
        cherry9_textView2 = findViewById(R.id.cherry9_textview2);

        cherry9_next_button = findViewById(R.id.cherry9_next_button);

        cherry9_case1 = findViewById(R.id.cherry9_case1);
        cherry9_case2 = findViewById(R.id.cherry9_case2);

        cherry9_menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (episode_number != 2 && episode_number != 4 && episode_number != 6 && episode_number != 8
                        && episode_number != 10 && episode_number != 12 && episode_number != 14 && episode_number != 16
                        && episode_number != 20 && episode_number != 22 && episode_number != 24 && episode_number != 26
                        && episode_number != 28 && episode_number != 30 && episode_number != 32){
                    clickFunc();
                }

                Intent intent = new Intent(getApplicationContext(), Cherry100_Episode_Pause.class);
                startActivityForResult(intent, 101);
            }
        });

        cherry9_next_button.setVisibility(View.INVISIBLE);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                episode_number = 1;
                cherry9_next_button.setVisibility(View.VISIBLE);
                Cherry9_Thread1 thread1 = new Cherry9_Thread1();
                thread1.start();
            }
        }, 3000);

        cherry9_case1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (episode_number == 18){
                    cherry9_next_button.setVisibility(View.INVISIBLE);
                    cherry9_case1.setVisibility(View.INVISIBLE);
                    cherry9_case2.setVisibility(View.INVISIBLE);
                    episode_number = 19;
                    cherry9_textView1.setText("");
                    cherry9_textView2.setText("");
                    cherry9_background.setImageResource(cherry9_image[21]);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Cherry9_Thread10 thread10 = new Cherry9_Thread10();
                            thread10.start();
                            cherry9_next_button.setVisibility(View.VISIBLE);
                        }
                    }, 1500);
                }
            }
        });

        cherry9_case2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (episode_number == 18){
                    cherry9_next_button.setVisibility(View.INVISIBLE);
                    cherry9_case1.setVisibility(View.INVISIBLE);
                    cherry9_case2.setVisibility(View.INVISIBLE);
                    episode_number = 21;
                    cherry9_textView1.setText("");
                    cherry9_textView2.setText("");
                    cherry9_background.setImageResource(cherry9_image[17]);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Cherry9_Thread11 thread11 = new Cherry9_Thread11();
                            thread11.start();
                            cherry9_next_button.setVisibility(View.VISIBLE);
                        }
                    }, 1500);
                }
            }
        });

        cherry9_next_button.setOnClickListener(new View.OnClickListener() {
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
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 2;
            cherry9_background.setImageResource(cherry9_image[2]);
            cherry9_textView1.setText(cherry9_text[0]);
            cherry9_textView2.setText(cherry9_text[1]);
            cherry9_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 2){
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 3;
            cherry9_textView1.setText("");
            cherry9_textView2.setText("");
            cherry9_background.setImageResource(cherry9_image[3]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry9_Thread2 thread2 = new Cherry9_Thread2();
                    thread2.start();
                    cherry9_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 3){
            if (play) playSound(false);
            value2 = false;
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 4;
            cherry9_background.setImageResource(cherry9_image[4]);
            cherry9_textView1.setText(cherry9_text[2]);
            cherry9_textView2.setText(cherry9_text[3]);
            cherry9_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 4){
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 5;
            cherry9_textView1.setText("");
            cherry9_textView2.setText("");
            cherry9_background.setImageResource(cherry9_image[5]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry9_Thread3 thread3 = new Cherry9_Thread3();
                    thread3.start();
                    cherry9_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 5){
            if (play) playSound(false);
            value3 = false;
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 6;
            cherry9_background.setImageResource(cherry9_image[6]);
            cherry9_textView1.setText(cherry9_text[4]);
            cherry9_textView2.setText(cherry9_text[5]);
            cherry9_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 6){
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 7;
            cherry9_textView1.setText("");
            cherry9_textView2.setText("");
            cherry9_background.setImageResource(cherry9_image[7]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry9_Thread4 thread4 = new Cherry9_Thread4();
                    thread4.start();
                    cherry9_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 7){
            if (play) playSound(false);
            value4 = false;
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 8;
            cherry9_background.setImageResource(cherry9_image[8]);
            cherry9_textView1.setText(cherry9_text[6]);
            cherry9_textView2.setText(cherry9_text[7]);
            cherry9_next_button.setVisibility(View.VISIBLE);
        }  else if (episode_number == 8){
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 9;
            cherry9_textView1.setText("");
            cherry9_textView2.setText("");
            cherry9_background.setImageResource(cherry9_image[9]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry9_Thread5 thread5 = new Cherry9_Thread5();
                    thread5.start();
                    cherry9_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 9){
            if (play) playSound(false);
            value5 = false;
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 10;
            cherry9_background.setImageResource(cherry9_image[10]);
            cherry9_textView1.setText(cherry9_text[8]);
            cherry9_textView2.setText(cherry9_text[9]);
            cherry9_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 10){
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 11;
            cherry9_textView1.setText("");
            cherry9_textView2.setText("");
            cherry9_background.setImageResource(cherry9_image[11]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry9_Thread6 thread6 = new Cherry9_Thread6();
                    thread6.start();
                    cherry9_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 11){
            if (play) playSound(false);
            value6 = false;
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 12;
            cherry9_background.setImageResource(cherry9_image[12]);
            cherry9_textView1.setText(cherry9_text[10]);
            cherry9_textView2.setText(cherry9_text[11]);
            cherry9_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 12){
            if (UseAll.player != null && UseAll.player.isPlaying()) UseAll.soundStop();
            UseAll.soundStart(23);
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 13;
            cherry9_textView1.setText("");
            cherry9_textView2.setText("");
            cherry9_background.setImageResource(cherry9_image[13]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry9_Thread7 thread7 = new Cherry9_Thread7();
                    thread7.start();
                    cherry9_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 13){
            if (play) playSound(false);
            value7 = false;
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 14;
            cherry9_textView1.setText(cherry9_text[12]);
            cherry9_textView2.setText(cherry9_text[13]);
            cherry9_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 14){
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 15;
            cherry9_textView1.setText("");
            cherry9_textView2.setText("");
            cherry9_background.setImageResource(cherry9_image[14]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry9_Thread8 thread8 = new Cherry9_Thread8();
                    thread8.start();
                    cherry9_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 15){
            if (play) playSound(false);
            value8 = false;
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 16;
            cherry9_background.setImageResource(cherry9_image[15]);
            cherry9_textView1.setText(cherry9_text[14]);
            cherry9_textView2.setText(cherry9_text[15]);
            cherry9_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 16){
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 17;
            cherry9_textView1.setText("");
            cherry9_textView2.setText("");
            cherry9_background.setImageResource(cherry9_image[16]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry9_Thread9 thread9 = new Cherry9_Thread9();
                    thread9.start();
                    cherry9_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 17){
            if (play) playSound(false);
            value9 = false;
            cherry9_next_button.setVisibility(View.INVISIBLE);
            cherry9_case1.setVisibility(View.VISIBLE);
            cherry9_case2.setVisibility(View.VISIBLE);
            episode_number = 18;
            cherry9_textView1.setText(cherry9_text[16]);
            cherry9_textView2.setText(cherry9_text[17]);
        } else if (episode_number == 19){
            if (play) playSound(false);
            value10 = false;
            cherry9_next_button.setVisibility(View.INVISIBLE);
            cherry9_case1.setVisibility(View.INVISIBLE);
            cherry9_case2.setVisibility(View.INVISIBLE);
            episode_number = 20;
            cherry9_textView1.setText(cherry9_text[18]);
            cherry9_textView2.setText(cherry9_text[19]);
            cherry9_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 20){
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 21;
            cherry9_textView1.setText("");
            cherry9_textView2.setText("");
            cherry9_background.setImageResource(cherry9_image[17]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry9_Thread11 thread11 = new Cherry9_Thread11();
                    thread11.start();
                    cherry9_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 21){
            if (play) playSound(false);
            value11 = false;
            cherry9_next_button.setVisibility(View.INVISIBLE);
            cherry9_case1.setVisibility(View.INVISIBLE);
            cherry9_case2.setVisibility(View.INVISIBLE);
            episode_number = 22;
            cherry9_textView1.setText(cherry9_text[20]);
            cherry9_textView2.setText(cherry9_text[21]);
            cherry9_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 22){
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 23;
            cherry9_textView1.setText("");
            cherry9_textView2.setText("");
            cherry9_background.setImageResource(cherry9_image[18]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry9_Thread12 thread12 = new Cherry9_Thread12();
                    thread12.start();
                    cherry9_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 23){
            if (play) playSound(false);
            value12 = false;
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 24;
            cherry9_background.setImageResource(cherry9_image[19]);
            cherry9_textView1.setText(cherry9_text[22]);
            cherry9_textView2.setText(cherry9_text[23]);
            cherry9_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 24){
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 25;
            cherry9_textView1.setText("");
            cherry9_textView2.setText("");
            cherry9_background.setImageResource(cherry9_image[20]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry9_Thread13 thread13 = new Cherry9_Thread13();
                    thread13.start();
                    cherry9_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 25){
            if (play) playSound(false);
            value13 = false;
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 26;
            cherry9_textView1.setText(cherry9_text[24]);
            cherry9_textView2.setText(cherry9_text[25]);
            cherry9_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 26){
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 27;
            cherry9_textView1.setText("");
            cherry9_textView2.setText("");
            cherry9_background.setImageResource(cherry9_image[22]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry9_Thread14 thread14 = new Cherry9_Thread14();
                    thread14.start();
                    cherry9_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 27){
            if (play) playSound(false);
            value14 = false;
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 28;
            cherry9_textView1.setText(cherry9_text[26]);
            cherry9_textView2.setText(cherry9_text[27]);
            cherry9_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 28){
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 29;
            cherry9_textView1.setText("");
            cherry9_textView2.setText("");
            cherry9_background.setImageResource(cherry9_image[23]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry9_Thread15 thread15 = new Cherry9_Thread15();
                    thread15.start();
                    cherry9_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 29){
            if (play) playSound(false);
            value15 = false;
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 30;
            cherry9_background.setImageResource(cherry9_image[24]);
            cherry9_textView1.setText(cherry9_text[28]);
            cherry9_textView2.setText(cherry9_text[29]);
            cherry9_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 30){
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 31;
            cherry9_textView1.setText("");
            cherry9_textView2.setText("");
            cherry9_background.setImageResource(cherry9_image[25]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry9_Thread16 thread16 = new Cherry9_Thread16();
                    thread16.start();
                    cherry9_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 31){
            if (play) playSound(false);
            value16 = false;
            cherry9_next_button.setVisibility(View.INVISIBLE);
            episode_number = 32;
            cherry9_background.setImageResource(cherry9_image[27]);
            cherry9_textView1.setText(cherry9_text[30]);
            String temp = cherry9_text[31] + cherry9_text[32];
            cherry9_textView2.setText(temp);
            cherry9_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 32){
            Intent intent = new Intent(getApplicationContext(), Cherry10_Adachi_Episode2_3.class);
            startActivity(intent);

            overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
        }
    }

    class Cherry9_Thread1 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry9_text[0].split("");
        String[] text2_list = cherry9_text[1].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value1 && !play) playSound(true);

            while (value1 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry9_textView1.setText(text1_build.toString());
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
                        cherry9_background.setImageResource(cherry9_image[1]);
                    }
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value1 && !play) playSound(true);

            while (value1 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry9_textView2.setText(text2_build.toString());
                text2_time++;

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
                        cherry9_background.setImageResource(cherry9_image[2]);
                    }
                }
            });

            if (value1) episode_number = 2;
        }
    }

    class Cherry9_Thread2 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry9_text[2].split("");
        String[] text2_list = cherry9_text[3].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value2 && !play) playSound(true);

            while (value2 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry9_textView1.setText(text1_build.toString());
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
                        cherry9_background.setImageResource(cherry9_image[4]);
                    }
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value2 && !play) playSound(true);

            while (value2 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry9_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value2 && play) playSound(false);

            if (value2) episode_number = 4;
        }
    }

    class Cherry9_Thread3 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry9_text[4].split("");
        String[] text2_list = cherry9_text[5].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value3 && !play) playSound(true);

            while (value3 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry9_textView1.setText(text1_build.toString());
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
                        cherry9_background.setImageResource(cherry9_image[6]);
                    }
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value3 && !play) playSound(true);

            while (value3 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry9_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value3 && play) playSound(false);

            if (value3) episode_number = 6;
        }
    }

    class Cherry9_Thread4 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry9_text[6].split("");
        String[] text2_list = cherry9_text[7].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value4 && !play) playSound(true);

            while (value4 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry9_textView1.setText(text1_build.toString());
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
                    if (value4){
                        cherry9_background.setImageResource(cherry9_image[8]);
                    }
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value4 && !play) playSound(true);

            while (value4 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry9_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value4 && play) playSound(false);

            if (value4) episode_number = 8;
        }
    }

    class Cherry9_Thread5 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry9_text[8].split("");
        String[] text2_list = cherry9_text[9].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value5 && !play) playSound(true);

            while (value5 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry9_textView1.setText(text1_build.toString());
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
                        cherry9_background.setImageResource(cherry9_image[10]);
                    }
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value5 && !play) playSound(true);

            while (value5 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry9_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value5 && play) playSound(false);

            if (value5) episode_number = 10;
        }
    }

    class Cherry9_Thread6 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry9_text[10].split("");
        String[] text2_list = cherry9_text[11].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value6 && !play) playSound(true);

            while (value6 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry9_textView1.setText(text1_build.toString());
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
                        cherry9_background.setImageResource(cherry9_image[12]);
                    }
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value6 && !play) playSound(true);

            while (value6 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry9_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value6 && play) playSound(false);

            if (value6) episode_number = 12;
        }
    }

    class Cherry9_Thread7 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry9_text[12].split("");
        String[] text2_list = cherry9_text[13].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value7 && !play) playSound(true);

            while (value7 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry9_textView1.setText(text1_build.toString());
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
                cherry9_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value7 && play) playSound(false);

            if (value7) episode_number = 14;
        }
    }

    class Cherry9_Thread8 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry9_text[14].split("");
        String[] text2_list = cherry9_text[15].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value8 && !play) playSound(true);

            while (value8 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry9_textView1.setText(text1_build.toString());
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
                        cherry9_background.setImageResource(cherry9_image[15]);
                    }
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value8 && !play) playSound(true);

            while (value8 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry9_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value8 && play) playSound(false);

            if (value8) episode_number = 16;
        }
    }

    class Cherry9_Thread9 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry9_text[16].split("");
        String[] text2_list = cherry9_text[17].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value9 && !play) playSound(true);

            while (value9 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry9_textView1.setText(text1_build.toString());
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
                cherry9_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value9 && play) playSound(false);

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value9){
                        cherry9_case1.setVisibility(View.VISIBLE);
                        cherry9_case2.setVisibility(View.VISIBLE);
                        cherry9_next_button.setVisibility(View.INVISIBLE);
                    }
                }
            });

            if (value9) episode_number = 18;
        }
    }

    class Cherry9_Thread10 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry9_text[18].split("");
        String[] text2_list = cherry9_text[19].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value10 && !play) playSound(true);

            while (value10 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry9_textView1.setText(text1_build.toString());
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
                cherry9_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value10 && play) playSound(false);

            if (value10) episode_number = 20;
        }
    }

    class Cherry9_Thread11 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry9_text[20].split("");
        String[] text2_list = cherry9_text[21].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value11 && !play) playSound(true);

            while (value11 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry9_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value11 && play) playSound(false);

            try {
                if (value11) Thread.sleep(1500);
            } catch (Exception e) { }

            if (value11 && !play) playSound(true);

            while (value11 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry9_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value11 && play) playSound(false);

            if (value11) episode_number = 22;
        }
    }

    class Cherry9_Thread12 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry9_text[22].split("");
        String[] text2_list = cherry9_text[23].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value12 && !play) playSound(true);

            while (value12 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry9_textView1.setText(text1_build.toString());
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
                    if (value12) {
                        cherry9_background.setImageResource(cherry9_image[19]);
                    }
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value12 && !play) playSound(true);

            while (value12 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry9_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value12 && play) playSound(false);

            if (value12) episode_number = 24;
        }
    }

    class Cherry9_Thread13 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry9_text[24].split("");
        String[] text2_list = cherry9_text[25].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value13 && !play) playSound(true);

            while (value13 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry9_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value13 && play) playSound(false);

            try {
                if (value13) Thread.sleep(1500);
            } catch (Exception e) { }

            if (value13 && !play) playSound(true);

            while (value13 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry9_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value13 && play) playSound(false);

            if (value13) episode_number = 26;
        }
    }

    class Cherry9_Thread14 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry9_text[26].split("");
        String[] text2_list = cherry9_text[27].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value14 && !play) playSound(true);

            while (value14 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry9_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value14 && play) playSound(false);

            try {
                if (value14) Thread.sleep(1500);
            } catch (Exception e) { }

            if (value14 && !play) playSound(true);

            while (value14 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry9_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value14 && play) playSound(false);

            if (value14) episode_number = 28;
        }
    }

    class Cherry9_Thread15 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry9_text[28].split("");
        String[] text2_list = cherry9_text[29].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value15 && !play) playSound(true);

            while (value15 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry9_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value15 && play) playSound(false);

            try {
                if (value15) Thread.sleep(1500);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value15) {
                        cherry9_background.setImageResource(cherry9_image[24]);
                    }
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value15 && !play) playSound(true);

            while (value15 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry9_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value15 && play) playSound(false);

            if (value15) episode_number = 30;
        }
    }

    class Cherry9_Thread16 extends Thread {
        int text1_time = 0;
        int text2_time = 0;
        int text3_time = 0;

        String[] text1_list = cherry9_text[30].split("");
        String[] text2_list = cherry9_text[31].split("");
        String[] text3_list = cherry9_text[32].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value16 && !play) playSound(true);

            while (value16 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry9_textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value16 && play) playSound(false);

            try {
                if (value16) Thread.sleep(1500);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value16) {
                        cherry9_background.setImageResource(cherry9_image[26]);
                    }
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value16 && !play) playSound(true);

            while (value16 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry9_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value16 && play) playSound(false);

            try {
                if (value16) Thread.sleep(1500);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value16) {
                        cherry9_background.setImageResource(cherry9_image[27]);
                    }
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value16 && !play) playSound(true);

            while (value16 && text3_time < text3_list.length){
                text2_build.append(text3_list[text3_time]);
                cherry9_textView2.setText(text2_build.toString());
                text3_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value16 && play) playSound(false);

            if (value16) episode_number = 32;
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
