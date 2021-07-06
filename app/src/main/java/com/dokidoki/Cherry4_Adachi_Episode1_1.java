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

public class Cherry4_Adachi_Episode1_1 extends AppCompatActivity {

    int episode_number = 0;

    OutlineTextView textView_1, textView_2;

    int episode1_4_select_num = 0;

    ImageView cherry4_textBox;

    LinearLayout next_button;
    boolean value1 = true, value2 = true, value3 = true, value4 = true, value5 = true, value6 = true, value7 = true,
            value8 = true, value9 = true, value10 = true;

    ImageView cherry4_background;

    ImageView introduce_adachi, introduce_urabe;

    TextView cherry4_case1, cherry4_case2;
    TextView cherry4_case3, cherry4_case4;
    TextView cherry4_case5, cherry4_case6;

    FrameLayout episode1_title;

    Handler handler = new Handler();

    Animation outAnim;

    String[] text = new String[]{"현재 29살 364일의 나", "언제나 그렇듯 나는 지금 회사에 출근 중이다.", //0, 1
            "출근 후 일하고 있는 나에게", "부서 직속 선배인 우라베 선배가 말을 걸어온다.", //2, 3
            "\"있잖아 아다치,", "지금까지 아무하고도 안 사귀어 봤다는 게 사실이야?\"", //4, 5
            "\"갑자기 왜 그래요?\"", "\"정말이야?\"", //6, 7
            "\"뭐...네...\"", "\"그럼 아다치 동정이야?\"", //8, 9
            "\"목소리 너무 커요\"", "\"이거 성희롱이에요\"", //10, 11
            "\"사실이었구나 그래\"", "\"너 지금 몇살이지?\"", //12, 13
            "\"내일이면 서른인데요\"", "\"진짜야? 서른이 넘어도 동정이면 마법사가 돼버린다\"", //14, 15
            "\"마법사라뇨...", "\"마법사라뇨...", //16, 17
            "그런 미신 믿으세요?\"", "알겠으니까 이제 일이나 하세요\"", //18, 19
            "우라베는 아무런 대답도 하지 않고 자리로 돌아갔다." //20
    };

    int[] image = new int[]{R.drawable.cherry004_adachi_play_episode1_1_background1, R.drawable.cherry004_adachi_play_episode1_2_background1,
                        R.drawable.cherry004_adachi_play_episode1_2_background2, R.drawable.cherry004_adachi_play_episode1_3_background1,
                        R.drawable.cherry004_adachi_play_episode1_3_case1_background1, R.drawable.cherry004_adachi_play_episode1_3_case2_background1,
                        R.drawable.cherry004_adachi_play_episode1_4_background1, R.drawable.cherry004_adachi_play_episode1_4_background2,
                        R.drawable.cherry004_adachi_play_episode1_5_background1, R.drawable.cherry004_adachi_play_episode1_5_background2,
                        R.drawable.cherry004_adachi_play_episode1_6_background1, R.drawable.cherry004_adachi_play_episode1_6_background2};

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
        setContentView(R.layout.cherry004_activity_adachi_episode1_1);

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

        next_button = findViewById(R.id.adachi_episode1_next_button);

        cherry4_background = findViewById(R.id.cherry4_background);

        introduce_adachi = findViewById(R.id.adachi_episode1_introduce_adachi);
        introduce_urabe = findViewById(R.id.adachi_episode1_introduce_urabe);

        episode1_title = findViewById(R.id.cherry4_title);

        cherry4_textBox = findViewById(R.id.cherry4_textBox);

        TextView menu = findViewById(R.id.adachi_episode1_menu_button);
        textView_1 = findViewById(R.id.adachi_episode1_textview1);
        textView_2 = findViewById(R.id.adachi_episode1_textview2);

        cherry4_case1 = findViewById(R.id.cherry4_case1);
        cherry4_case2 = findViewById(R.id.cherry4_case2);
        cherry4_case3 = findViewById(R.id.cherry4_case3);
        cherry4_case4 = findViewById(R.id.cherry4_case4);
        cherry4_case5 = findViewById(R.id.cherry4_case5);
        cherry4_case6 = findViewById(R.id.cherry4_case6);

        sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        soundId = sound.load(this, R.raw.shorttypingsound, 1);

        if (UseAll.player != null && UseAll.player.isPlaying()) UseAll.soundStop();
        UseAll.soundStart(5);

        outAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.activity_alpha_out);
        OutAnimationListener animListener = new OutAnimationListener();
        outAnim.setAnimationListener(animListener);

        episode1_title.setVisibility(View.VISIBLE);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                episode1_title.startAnimation(outAnim);
            }
        }, 3000);

        next_button.setVisibility(View.INVISIBLE);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                episode_number = 1;
                Cherry4_episode1_1_Text Thread_Episode1_1 = new Cherry4_episode1_1_Text();
                Thread_Episode1_1.start();
                next_button.setVisibility(View.VISIBLE);
            }
        }, 5000);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (episode_number != 2 && episode_number != 4 && episode_number != 7 &&
                        episode_number != 10 && episode_number != 12 &&
                        episode_number !=  15 && episode_number != 17 ){
                    clickFunc();
                }

                Intent intent = new Intent(getApplicationContext(), Cherry100_Episode_Pause.class);
                startActivityForResult(intent, 101);
            }
        });

        cherry4_case1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_1.setText("");
                textView_2.setText("");
                cherry4_background.setImageResource(image[4]);
                cherry4_case1.setVisibility(View.INVISIBLE);
                cherry4_case2.setVisibility(View.INVISIBLE);

                episode_number = 6;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Cherry4_episode1_3_1_Text Thread_Episode1_3_1 = new Cherry4_episode1_3_1_Text();
                        Thread_Episode1_3_1.start();
                        next_button.setVisibility(View.VISIBLE);
                    }
                }, 1500);
            }
        });

        cherry4_case2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_1.setText("");
                textView_2.setText("");
                cherry4_background.setImageResource(image[5]);
                cherry4_case1.setVisibility(View.INVISIBLE);
                cherry4_case2.setVisibility(View.INVISIBLE);

                episode_number = 8;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Cherry4_episode1_3_2_Text Thread_Episode1_3_2 = new Cherry4_episode1_3_2_Text();
                        Thread_Episode1_3_2.start();
                        next_button.setVisibility(View.VISIBLE);
                    }
                }, 1500);
            }
        });

        cherry4_case3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_1.setText("");
                textView_2.setText("");
                cherry4_background.setImageResource(image[6]);
                cherry4_case3.setVisibility(View.INVISIBLE);
                cherry4_case4.setVisibility(View.INVISIBLE);

                episode1_4_select_num = 1;
                episode_number = 9;

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Cherry4_episode1_4_1_Text Thread_Episode1_4_1 = new Cherry4_episode1_4_1_Text();
                        Thread_Episode1_4_1.start();
                        next_button.setVisibility(View.VISIBLE);
                    }
                }, 1500);
            }
        });

        cherry4_case4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_1.setText("");
                textView_2.setText("");
                cherry4_background.setImageResource(image[6]);
                cherry4_case3.setVisibility(View.INVISIBLE);
                cherry4_case4.setVisibility(View.INVISIBLE);

                episode1_4_select_num = 2;
                episode_number = 9;

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Cherry4_episode1_4_1_Text Thread_Episode1_4_1 = new Cherry4_episode1_4_1_Text();
                        Thread_Episode1_4_1.start();
                        next_button.setVisibility(View.VISIBLE);
                    }
                }, 1500);
            }
        });

        cherry4_case5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_1.setText(text[17]);
                textView_2.setText("");
                cherry4_background.setImageResource(image[9]);
                cherry4_case5.setVisibility(View.INVISIBLE);
                cherry4_case6.setVisibility(View.INVISIBLE);

                episode1_4_select_num = 1;
                episode_number = 14;

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Cherry4_episode1_5_2_Text Thread_Episode1_5_2 = new Cherry4_episode1_5_2_Text();
                        Thread_Episode1_5_2.start();
                        next_button.setVisibility(View.VISIBLE);
                    }
                }, 1500);
            }
        });

        cherry4_case6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_1.setText(text[17]);
                textView_2.setText("");
                cherry4_background.setImageResource(image[9]);
                cherry4_case5.setVisibility(View.INVISIBLE);
                cherry4_case6.setVisibility(View.INVISIBLE);

                episode1_4_select_num = 2;
                episode_number = 14;

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Cherry4_episode1_5_2_Text Thread_Episode1_5_2 = new Cherry4_episode1_5_2_Text();
                        Thread_Episode1_5_2.start();
                        next_button.setVisibility(View.VISIBLE);
                    }
                }, 1500);
            }
        });


        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickFunc();
            }
        });
    }

    public void clickFunc(){
        if (episode_number == 1){
            if (play) playSound(false);
            next_button.setVisibility(View.INVISIBLE);
            value1 = false;
            episode_number = 2;
            textView_1.setText(text[0]);
            textView_2.setText(text[1]);
            introduce_adachi.setVisibility(View.INVISIBLE);
            next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 2) {
            next_button.setVisibility(View.INVISIBLE);
            textView_1.setText("");
            textView_2.setText("");
            episode_number = 3;
            cherry4_background.setImageResource(image[1]);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry4_episode1_2_Text Thread_Episode1_2 = new Cherry4_episode1_2_Text();
                    Thread_Episode1_2.start();
                    next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 3) {
            if (play) playSound(false);
            next_button.setVisibility(View.INVISIBLE);
            value2 = false;
            episode_number = 4;
            textView_1.setText(text[2]);
            textView_2.setText(text[3]);
            introduce_urabe.setVisibility(View.INVISIBLE);
            cherry4_background.setImageResource(image[2]);
            next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 4) {
            next_button.setVisibility(View.INVISIBLE);
            episode_number = 5;
            textView_1.setText("");
            textView_2.setText("");
            cherry4_background.setImageResource(image[3]);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry4_episode1_3_Text Thread_Episode1_3 = new Cherry4_episode1_3_Text();
                    Thread_Episode1_3.start();
                    next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 5){
            if (play) playSound(false);
            next_button.setVisibility(View.INVISIBLE);
            value3 = false;
            textView_1.setText(text[4]);
            textView_2.setText(text[5]);
            cherry4_case1.setVisibility(View.VISIBLE);
            cherry4_case2.setVisibility(View.VISIBLE);
        } else if (episode_number == 6){
            if (play) playSound(false);
            next_button.setVisibility(View.INVISIBLE);
            value4 = false;
            episode_number = 7;
            textView_1.setText(text[6]);
            textView_2.setText(text[7]);
            next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 7){
            next_button.setVisibility(View.INVISIBLE);
            episode_number = 8;
            textView_1.setText("");
            textView_2.setText("");
            cherry4_background.setImageResource(image[5]);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry4_episode1_3_2_Text Thread_Episode1_3_2 = new Cherry4_episode1_3_2_Text();
                    Thread_Episode1_3_2.start();
                    next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 8){
            if (play) playSound(false);
            next_button.setVisibility(View.INVISIBLE);
            value5 = false;
            textView_1.setText(text[8]);
            textView_2.setText(text[9]);
            cherry4_case3.setVisibility(View.VISIBLE);
            cherry4_case4.setVisibility(View.VISIBLE);
        } else if (episode_number == 9){
            if (play) playSound(false);
            next_button.setVisibility(View.INVISIBLE);
            value6 = false;
            episode_number = 10;
            if (episode1_4_select_num == 1){
                textView_1.setText(text[10]);
            } else {
                textView_1.setText(text[11]);
            }
            textView_2.setText(text[12]);
            next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 10){
            next_button.setVisibility(View.INVISIBLE);
            episode_number = 11;
            textView_1.setText("");
            textView_2.setText("");
            cherry4_background.setImageResource(image[7]);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry4_episode1_4_2_Text Thread_Episode1_4_2 = new Cherry4_episode1_4_2_Text();
                    Thread_Episode1_4_2.start();
                    next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 11){
            if (play) playSound(false);
            next_button.setVisibility(View.INVISIBLE);
            value7 = false;
            episode_number = 12;
            textView_1.setText(text[13]);
            textView_2.setText(text[14]);
            next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 12) {
            next_button.setVisibility(View.INVISIBLE);
            episode_number = 13;
            textView_1.setText("");
            textView_2.setText("");
            cherry4_background.setImageResource(image[8]);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry4_episode1_5_1_Text Thread_Episode1_5_1 = new Cherry4_episode1_5_1_Text();
                    Thread_Episode1_5_1.start();
                    next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 13){
            if (play) playSound(false);
            next_button.setVisibility(View.INVISIBLE);
            value8 = false;
            textView_1.setText(text[15]);
            textView_2.setText(text[16]);
            cherry4_case5.setVisibility(View.VISIBLE);
            cherry4_case6.setVisibility(View.VISIBLE);
        } else if (episode_number == 14){
            if (play) playSound(false);
            next_button.setVisibility(View.INVISIBLE);
            value9 = false;
            episode_number = 15;
            textView_1.setText(text[17]);
            if (episode1_4_select_num == 1){
                textView_2.setText(text[18]);
            } else {
                textView_2.setText(text[19]);
            }
            next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 15) {
            next_button.setVisibility(View.INVISIBLE);
            episode_number = 16;
            textView_1.setText("");
            textView_2.setText("");
            cherry4_background.setImageResource(image[10]);
            cherry4_textBox.setVisibility(View.INVISIBLE);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry4_episode1_6_Text Thread_Episode1_6 = new Cherry4_episode1_6_Text();
                    Thread_Episode1_6.start();
                }
            }, 1500);
        } else if (episode_number == 16){
            if (play) playSound(false);
            next_button.setVisibility(View.INVISIBLE);
            value10 = false;
            episode_number = 17;
            textView_1.setText(text[20]);
            cherry4_background.setImageResource(image[11]);
            next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 17){
            next_button.setVisibility(View.INVISIBLE);

            Intent intent = new Intent(getApplicationContext(), Cherry5_Adachi_Episode1_2.class);
            startActivity(intent);

            overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
            finish();
        }
    }

    class Cherry4_episode1_1_Text extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = text[0].split("");
        String[] text2_list = text[1].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value1 && !play) playSound(true);

            while (value1 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                textView_1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value1 && play) playSound(false);

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value1)introduce_adachi.setVisibility(View.VISIBLE);
                }
            });

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (value1)introduce_adachi.setVisibility(View.INVISIBLE);
                }
            }, 2000);

            try {
                if (value5) Thread.sleep(1500);
            } catch (Exception e) { }

            if (value1 && !play) playSound(true);

            while (value1 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                textView_2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value1 && play) playSound(false);

            if (value1) episode_number = 2;
        }
    }

    class Cherry4_episode1_2_Text extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = text[2].split("");
        String[] text2_list = text[3].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value2 && !play) playSound(true);

            while (value2 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                textView_1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            try {
                if (value5) Thread.sleep(1500);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value2) cherry4_background.setImageResource(image[2]);
                    if (value2 && play) playSound(false);
                }
            });

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (value2) introduce_urabe.setVisibility(View.VISIBLE);
                }
            }, 500);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (value2) introduce_urabe.setVisibility(View.INVISIBLE);
                }
            }, 2000);



            if (value2 && !play) playSound(true);

            while (value2 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                textView_2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value2 && play) playSound(false);

            if (value2) episode_number = 4;
        }
    }

    class Cherry4_episode1_3_Text extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = text[4].split("");
        String[] text2_list = text[5].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value3 && !play) playSound(true);

            while (value3 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                textView_1.setText(text1_build.toString());
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
                textView_2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value3) cherry4_case1.setVisibility(View.VISIBLE);
                    if (value3) cherry4_case2.setVisibility(View.VISIBLE);
                    if (value3 && play) playSound(false);
                }
            });

            if (value3) next_button.setVisibility(View.INVISIBLE);
        }
    }

    class Cherry4_episode1_3_1_Text extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = text[6].split("");
        String[] text2_list = text[7].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value4 && !play) playSound(true);

            while (value4 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                textView_1.setText(text1_build.toString());
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
                textView_2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value4 && play) playSound(false);

            if (value4) episode_number = 7;
        }
    }

    class Cherry4_episode1_3_2_Text extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = text[8].split("");
        String[] text2_list = text[9].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value5 && !play) playSound(true);

            while (value5 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                textView_1.setText(text1_build.toString());
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
                textView_2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value5){
                        cherry4_case3.setVisibility(View.VISIBLE);
                        cherry4_case4.setVisibility(View.VISIBLE);
                        next_button.setVisibility(View.INVISIBLE);
                        if (value5 && play) playSound(false);
                    }
                }
            });
        }
    }

    class Cherry4_episode1_4_1_Text extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list;
        String[] text2_list = text[12].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();
        @Override
        public void run() {
            if (episode1_4_select_num == 1) {
                text1_list = text[10].split("");
            } else {
                text1_list = text[11].split("");
            }

            if (value6 && !play) playSound(true);

            while (value6 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                textView_1.setText(text1_build.toString());
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

            while (value6 && text2_time < text2_list.length) {
                text2_build.append(text2_list[text2_time]);
                textView_2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) {    }
            }

            if (value6 && play) playSound(false);

            if (value6) episode_number = 10;
        }
    }

    class Cherry4_episode1_4_2_Text extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = text[13].split("");
        String[] text2_list = text[14].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();
        @Override
        public void run() {

            if (value7 && !play) playSound(true);

            while (value7 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                textView_1.setText(text1_build.toString());
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
                textView_2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value7 && play) playSound(false);

            if (value7) episode_number = 12;
        }
    }

    class Cherry4_episode1_5_1_Text extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = text[15].split("");
        String[] text2_list = text[16].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();
        @Override
        public void run() {

            if (value8 && !play) playSound(true);

            while (value8 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                textView_1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value8 && play) playSound(false);

            try {
                Thread.sleep(1500);
            } catch (Exception e) { }

            if (value8 && !play) playSound(true);

            while (value8 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                textView_2.setText(text2_build.toString());
                text2_time++;

                try {
                    if (value8) Thread.sleep(50);
                } catch (Exception e) { }
            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value8){
                        cherry4_case5.setVisibility(View.VISIBLE);
                        cherry4_case6.setVisibility(View.VISIBLE);
                        next_button.setVisibility(View.INVISIBLE);
                        if (play) playSound(false);
                    }
                }
            });
        }
    }

    class Cherry4_episode1_5_2_Text extends Thread{
        int text2_time = 0;

        String[] text2_list;

        StringBuilder text2_build = new StringBuilder();
        @Override
        public void run() {
            if (episode1_4_select_num == 1) {
                text2_list = text[18].split("");
            } else {
                text2_list = text[19].split("");
            }

            if (value9) textView_1.setText(text[17]);

            try {
                if (value9) Thread.sleep(1000);
            } catch (Exception e) { }

            if (value9 && !play) playSound(true);

            while (value9 && text2_time < text2_list.length) {
                text2_build.append(text2_list[text2_time]);
                textView_2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value9 && play) playSound(false);

            if (value9) episode_number = 15;
        }
    }


    class Cherry4_episode1_6_Text extends Thread{
        int text1_time = 0;

        String[] text1_list = text[20].split("");

        StringBuilder text1_build = new StringBuilder();

        @Override
        public void run() {

            try {
                if (value10) Thread.sleep(500);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value10) cherry4_background.setImageResource(image[11]);
                }
            });

            try {
                if (value10) Thread.sleep(1000);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value10){
                        cherry4_textBox.setVisibility(View.VISIBLE);
                        next_button.setVisibility(View.VISIBLE);
                        if (!play) playSound(true);
                    }
                }
            });

            while (value10 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                textView_1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value10 && play) playSound(false);

            if (value10) episode_number = 17;
        }
    }


    private class OutAnimationListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if (episode_number == 0) {
                episode1_title.setVisibility(View.INVISIBLE);
                return;
            }
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

            } else if (resultCode == UseAll.request_number_2){
                Intent intent = new Intent(getApplicationContext(),Cherry3_EpisodeSelectActivity.class);
                startActivity(intent);

                overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
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
