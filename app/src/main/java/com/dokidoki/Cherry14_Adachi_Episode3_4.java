package com.dokidoki;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Cherry14_Adachi_Episode3_4 extends AppCompatActivity {

    ImageView cherry14_background;
    TextView cherry14_menu_button;

    OutlineTextView cherry14_textView1, cherry14_textView2;

    String[] cherry14_text = new String[]{"\"잠깐만, 자고 갈래?", "우리집에서 자고 가 여기서 택시로 기본요금 거리거든\"", //0, 1
            "쿠로사와 집에서 자는게 편하긴 하겠지...?", "\"그럼 그래도 될까?\"", //2, 3
            "쿠로사와의 마음을 아는데 가도 될까...?", "\"저기 그러니까...\"", //4, 5
            "\"제대로 못 자면 힘들잖아\"", "\"하지만 너한테 민폐가...\"", //6, 7
            "\"전혀 민폐 아니야\"", "\"에?\"",//8, 9
            "\"하지만...\"", "그 순간 나는 더 이상 피할 수 없음을 느꼈다.", //10, 11
            "\"그렇게 하자\"", "그가 다가와 어깨에 손을 올리자 이상한 것이 눈 앞에 펼쳐졌다.", //12, 13
            "이게 ", "도대체 ", "뭐야?", "설마 ", "쿠로사와의 ", "상상?", //14, 15, 16, 17, 18, 19
            "\"아다치\"", "정말 이대로 쿠로사와의 집에 가도 괜찮은 걸까?" //20, 21
    };

    int[] cherry14_image = new int[]{R.drawable.cherry014_adachi_play_episode3_10_background1, R.drawable.cherry014_adachi_play_episode3_10_background2, //0, 1
            R.drawable.cherry014_adachi_play_episode3_10_background3, R.drawable.cherry014_adachi_play_episode3_10_background4, //2, 3
            R.drawable.cherry014_adachi_play_episode3_10_background5, R.drawable.cherry014_adachi_play_episode3_10_background6, //4, 5
            R.drawable.cherry014_adachi_play_episode3_10_background7, R.drawable.cherry014_adachi_play_episode3_10_background8, //6, 7
            R.drawable.cherry014_adachi_play_episode3_11_background1, R.drawable.cherry014_adachi_play_episode3_11_background2, //8, 9
            R.drawable.cherry014_adachi_play_episode3_11_background3, R.drawable.cherry014_adachi_play_episode3_11_background4, //10, 11
            R.drawable.cherry014_adachi_play_episode3_11_background5, R.drawable.cherry014_adachi_play_episode3_11_background6, //12, 13
            R.drawable.cherry014_adachi_play_episode3_11_background7, R.drawable.cherry014_adachi_play_episode3_11_background8, //14, 15
            R.drawable.cherry014_adachi_play_episode3_11_background9, R.drawable.cherry014_adachi_play_episode3_11_background10 //16, 17
    };

    boolean value1 = true, value2 = true, value3 = true, value4 = true, value5 = true, value6 = true, value7 = true, value8 = true;

    LinearLayout cherry14_next_button;

    TextView cherry14_case1, cherry14_case2;

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
        setContentView(R.layout.cherry014_activity_adachi_episode3_4);

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
        UseAll.soundStart(23);

        cherry14_background = findViewById(R.id.cherry14_background);
        cherry14_menu_button = findViewById(R.id.cherry14_menu_button);

        cherry14_textView1 = findViewById(R.id.cherry14_textview1);
        cherry14_textView2 = findViewById(R.id.cherry14_textview2);

        cherry14_next_button = findViewById(R.id.cherry14_next_button);

        cherry14_case1 = findViewById(R.id.cherry14_case1);
        cherry14_case2 = findViewById(R.id.cherry14_case2);

        cherry14_menu_button.setOnClickListener(new View.OnClickListener() {
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

        cherry14_next_button.setVisibility(View.INVISIBLE);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                episode_number = 1;
                cherry14_next_button.setVisibility(View.VISIBLE);
                Cherry14_Thread1 thread1 = new Cherry14_Thread1();
                thread1.start();
            }
        }, 3000);

        cherry14_case1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (episode_number == 2) {
                    cherry14_next_button.setVisibility(View.INVISIBLE);
                    cherry14_case1.setVisibility(View.INVISIBLE);
                    cherry14_case2.setVisibility(View.INVISIBLE);
                    episode_number = 3;
                    cherry14_textView1.setText("");
                    cherry14_textView2.setText("");
                    cherry14_background.setImageResource(cherry14_image[2]);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Cherry14_Thread2 thread2 = new Cherry14_Thread2();
                            thread2.start();
                            cherry14_next_button.setVisibility(View.VISIBLE);
                        }
                    }, 1500);
                }
            }
        });

        cherry14_case2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (episode_number == 2) {
                    cherry14_next_button.setVisibility(View.INVISIBLE);
                    cherry14_case1.setVisibility(View.INVISIBLE);
                    cherry14_case2.setVisibility(View.INVISIBLE);
                    episode_number = 5;
                    cherry14_textView1.setText("");
                    cherry14_textView2.setText("");
                    cherry14_background.setImageResource(cherry14_image[2]);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Cherry14_Thread2 thread2 = new Cherry14_Thread2();
                            thread2.start();
                            cherry14_next_button.setVisibility(View.VISIBLE);
                        }
                    }, 1500);
                }
            }
        });

        cherry14_next_button.setOnClickListener(new View.OnClickListener() {
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
            cherry14_next_button.setVisibility(View.INVISIBLE);
            cherry14_case1.setVisibility(View.VISIBLE);
            cherry14_case2.setVisibility(View.VISIBLE);
            episode_number = 2;
            cherry14_background.setImageResource(cherry14_image[1]);
            cherry14_textView1.setText(cherry14_text[0]);
            cherry14_textView2.setText(cherry14_text[1]);
        } else if (episode_number == 3) {
            if (play) playSound(false);
            value2 = false;
            cherry14_next_button.setVisibility(View.INVISIBLE);
            cherry14_case1.setVisibility(View.INVISIBLE);
            cherry14_case2.setVisibility(View.INVISIBLE);
            episode_number = 6;
            cherry14_textView1.setText(cherry14_text[2]);
            cherry14_textView2.setText(cherry14_text[3]);
            cherry14_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 5) {
            if (play) playSound(false);
            value2 = false;
            cherry14_next_button.setVisibility(View.INVISIBLE);
            cherry14_case1.setVisibility(View.INVISIBLE);
            cherry14_case2.setVisibility(View.INVISIBLE);
            episode_number = 6;
            cherry14_textView1.setText(cherry14_text[4]);
            cherry14_textView2.setText(cherry14_text[5]);
            cherry14_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 6){
            cherry14_next_button.setVisibility(View.INVISIBLE);
            episode_number = 7;
            cherry14_textView1.setText("");
            cherry14_textView2.setText("");
            cherry14_background.setImageResource(cherry14_image[3]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry14_Thread3 thread3 = new Cherry14_Thread3();
                    thread3.start();
                    cherry14_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 7){
            if (play) playSound(false);
            value3 = false;
            cherry14_next_button.setVisibility(View.INVISIBLE);
            episode_number = 8;
            cherry14_background.setImageResource(cherry14_image[4]);
            cherry14_textView1.setText(cherry14_text[6]);
            cherry14_textView2.setText(cherry14_text[7]);
            cherry14_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 8){
            cherry14_next_button.setVisibility(View.INVISIBLE);
            episode_number = 9;
            cherry14_textView1.setText("");
            cherry14_textView2.setText("");
            cherry14_background.setImageResource(cherry14_image[5]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry14_Thread4 thread4 = new Cherry14_Thread4();
                    thread4.start();
                    cherry14_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 9){
            if (play) playSound(false);
            value4 = false;
            cherry14_next_button.setVisibility(View.INVISIBLE);
            episode_number = 10;
            cherry14_background.setImageResource(cherry14_image[6]);
            cherry14_textView1.setText(cherry14_text[8]);
            cherry14_textView2.setText(cherry14_text[9]);
            cherry14_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 10){
            cherry14_next_button.setVisibility(View.INVISIBLE);
            episode_number = 11;
            cherry14_textView1.setText("");
            cherry14_textView2.setText("");
            cherry14_background.setImageResource(cherry14_image[7]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry14_Thread5 thread5 = new Cherry14_Thread5();
                    thread5.start();
                    cherry14_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 11){
            if (play) playSound(false);
            value5 = false;
            cherry14_next_button.setVisibility(View.INVISIBLE);
            episode_number = 12;
            cherry14_textView1.setText(cherry14_text[10]);
            cherry14_textView2.setText(cherry14_text[11]);
            cherry14_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 12){
            cherry14_next_button.setVisibility(View.INVISIBLE);
            episode_number = 13;
            cherry14_textView1.setText("");
            cherry14_textView2.setText("");
            cherry14_background.setImageResource(cherry14_image[8]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry14_Thread6 thread6 = new Cherry14_Thread6();
                    thread6.start();
                    cherry14_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 13){
            if (play) playSound(false);
            value6 = false;
            cherry14_next_button.setVisibility(View.INVISIBLE);
            episode_number = 14;
            cherry14_background.setImageResource(cherry14_image[9]);
            cherry14_textView1.setText(cherry14_text[12]);
            cherry14_textView2.setText(cherry14_text[13]);
            cherry14_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 14){
            if (UseAll.player != null && UseAll.player.isPlaying()) UseAll.soundStop();
            UseAll.soundStart(9);
            cherry14_next_button.setVisibility(View.INVISIBLE);
            episode_number = 15;
            cherry14_textView1.setText("");
            cherry14_textView2.setText("");
            cherry14_background.setImageResource(cherry14_image[10]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry14_Thread7 thread7 = new Cherry14_Thread7();
                    thread7.start();
                    cherry14_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 15){
            if (play) playSound(false);
            value7 = false;
            cherry14_next_button.setVisibility(View.INVISIBLE);
            episode_number = 16;
            cherry14_background.setImageResource(cherry14_image[15]);
            String temp1 = cherry14_text[14] + cherry14_text[15] + cherry14_text[16];
            String temp2 = cherry14_text[17] + cherry14_text[18] + cherry14_text[19];
            cherry14_textView1.setText(temp1);
            cherry14_textView2.setText(temp2);
            cherry14_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 16){
            if (UseAll.player != null && UseAll.player.isPlaying()) UseAll.soundStop();
            UseAll.soundStart(12);
            cherry14_next_button.setVisibility(View.INVISIBLE);
            episode_number = 17;
            cherry14_textView1.setText("");
            cherry14_textView2.setText("");
            cherry14_background.setImageResource(cherry14_image[16]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry14_Thread8 thread8 = new Cherry14_Thread8();
                    thread8.start();
                    cherry14_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 17){
            if (play) playSound(false);
            value8 = false;
            cherry14_next_button.setVisibility(View.INVISIBLE);
            episode_number = 18;
            cherry14_background.setImageResource(cherry14_image[17]);
            cherry14_textView1.setText(cherry14_text[20]);
            cherry14_textView2.setText(cherry14_text[21]);
            cherry14_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 18) {
            Intent intent = new Intent(getApplicationContext(), Cherry101_AdachiEpisodeClearActivity.class);
            intent.putExtra("position", 3);

            startActivity(intent);

            overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
            finish();
        }

    }

    class Cherry14_Thread1 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry14_text[0].split("");
        String[] text2_list = cherry14_text[1].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value1 && !play) playSound(true);

            while (value1 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry14_textView1.setText(text1_build.toString());
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
                        cherry14_background.setImageResource(cherry14_image[1]);
                    }
                }
            });

            try {
                if (value1) Thread.sleep(500);
            } catch (Exception e) { }

            if (value1 && !play) playSound(true);

            while (value1 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry14_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value1 && play) playSound(false);

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value1) {
                        cherry14_next_button.setVisibility(View.INVISIBLE);
                        cherry14_case1.setVisibility(View.VISIBLE);
                        cherry14_case2.setVisibility(View.VISIBLE);
                    }
                }
            });

            if (value1) episode_number = 2;
        }
    }

    class Cherry14_Thread2 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = (episode_number == 3) ? cherry14_text[2].split("") : cherry14_text[4].split("");
        String[] text2_list = (episode_number == 3) ? cherry14_text[3].split("") : cherry14_text[5].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value2 && !play) playSound(true);

            while (value2 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry14_textView1.setText(text1_build.toString());
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
                cherry14_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value2 && play) playSound(false);

            if (value2) episode_number = 6;
        }
    }

    class Cherry14_Thread3 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry14_text[6].split("");
        String[] text2_list = cherry14_text[7].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value3 && !play) playSound(true);

            while (value3 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry14_textView1.setText(text1_build.toString());
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
                        cherry14_background.setImageResource(cherry14_image[4]);
                    }
                }
            });

            try {
                if (value3) Thread.sleep(500);
            } catch (Exception e) { }

            if (value3 && !play) playSound(true);

            while (value3 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry14_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value3 && play) playSound(false);

            if (value3) episode_number = 8;
        }
    }

    class Cherry14_Thread4 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry14_text[8].split("");
        String[] text2_list = cherry14_text[9].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value4 && !play) playSound(true);

            while (value4 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry14_textView1.setText(text1_build.toString());
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
                        cherry14_background.setImageResource(cherry14_image[6]);
                    }
                }
            });

            try {
                if (value4) Thread.sleep(500);
            } catch (Exception e) { }

            if (value4 && !play) playSound(true);

            while (value4 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry14_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value4 && play) playSound(false);

            if (value4) episode_number = 10;
        }
    }

    class Cherry14_Thread5 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry14_text[10].split("");
        String[] text2_list = cherry14_text[11].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value5 && !play) playSound(true);

            while (value5 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry14_textView1.setText(text1_build.toString());
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
                cherry14_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value5 && play) playSound(false);

            if (value5) episode_number = 12;
        }
    }

    class Cherry14_Thread6 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry14_text[12].split("");
        String[] text2_list = cherry14_text[13].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value6 && !play) playSound(true);

            while (value6 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry14_textView1.setText(text1_build.toString());
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
                        cherry14_background.setImageResource(cherry14_image[9]);
                    }
                }
            });

            try {
                if (value6) Thread.sleep(500);
            } catch (Exception e) { }

            if (value6 && !play) playSound(true);

            while (value6 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry14_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value6 && play) playSound(false);

            if (value6) episode_number = 14;
        }
    }

    class Cherry14_Thread7 extends Thread {
        int text1_time = 0;
        int text2_time = 0;
        int text3_time = 0;
        int text4_time = 0;
        int text5_time = 0;
        int text6_time = 0;

        String[] text1_list = cherry14_text[14].split("");
        String[] text2_list = cherry14_text[15].split("");
        String[] text3_list = cherry14_text[16].split("");
        String[] text4_list = cherry14_text[17].split("");
        String[] text5_list = cherry14_text[18].split("");
        String[] text6_list = cherry14_text[19].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value7 && !play) playSound(true);

            while (value7 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry14_textView1.setText(text1_build.toString());
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
                        cherry14_background.setImageResource(cherry14_image[11]);
                    }
                }
            });

            try {
                if (value7) Thread.sleep(500);
            } catch (Exception e) { }

            if (value7 && !play) playSound(true);

            while (value7 && text2_time < text2_list.length) {
                text1_build.append(text2_list[text2_time]);
                cherry14_textView1.setText(text1_build.toString());
                text2_time++;

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
                        cherry14_background.setImageResource(cherry14_image[12]);
                    }
                }
            });

            try {
                if (value7) Thread.sleep(500);
            } catch (Exception e) { }

            if (value7 && !play) playSound(true);

            while (value7 && text3_time < text3_list.length) {
                text1_build.append(text3_list[text3_time]);
                cherry14_textView1.setText(text1_build.toString());
                text3_time++;

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
                        cherry14_background.setImageResource(cherry14_image[13]);
                    }
                }
            });

            try {
                if (value7) Thread.sleep(500);
            } catch (Exception e) { }

            if (value7 && !play) playSound(true);

            while (value7 && text4_time < text4_list.length){
                text2_build.append(text4_list[text4_time]);
                cherry14_textView2.setText(text2_build.toString());
                text4_time++;

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
                        cherry14_background.setImageResource(cherry14_image[14]);
                    }
                }
            });

            try {
                if (value7) Thread.sleep(500);
            } catch (Exception e) { }

            if (value7 && !play) playSound(true);

            while (value7 && text5_time < text5_list.length){
                text2_build.append(text5_list[text5_time]);
                cherry14_textView2.setText(text2_build.toString());
                text5_time++;

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
                        cherry14_background.setImageResource(cherry14_image[15]);
                    }
                }
            });

            try {
                if (value7) Thread.sleep(500);
            } catch (Exception e) { }

            if (value7 && !play) playSound(true);

            while (value7 && text6_time < text6_list.length){
                text2_build.append(text6_list[text6_time]);
                cherry14_textView2.setText(text2_build.toString());
                text6_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value7 && play) playSound(false);

            if (value7) episode_number = 16;
        }
    }

    class Cherry14_Thread8 extends Thread {
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry14_text[20].split("");
        String[] text2_list = cherry14_text[21].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value8 && !play) playSound(true);

            while (value8 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry14_textView1.setText(text1_build.toString());
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
                        cherry14_background.setImageResource(cherry14_image[17]);
                    }
                }
            });

            try {
                if (value8) Thread.sleep(500);
            } catch (Exception e) { }

            if (value8 && !play) playSound(true);

            while (value8 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry14_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value8 && play) playSound(false);

            if (value8) episode_number = 18;
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
