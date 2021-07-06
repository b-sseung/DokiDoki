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

public class Cherry5_Adachi_Episode1_2 extends AppCompatActivity {

    ImageView cherry5_background, cherry5_introduce_kurosawa;
    int[] cherry5_background_image = new int[]{R.drawable.cherry005_adachi_play_episode1_07_background1, R.drawable.cherry005_adachi_play_episode1_07_background2,
                        R.drawable.cherry005_adachi_play_episode1_08_background1, R.drawable.cherry005_adachi_play_episode1_08_background2,
                        R.drawable.cherry005_adachi_play_episode1_08_background3, R.drawable.cherry005_adachi_play_episode1_09_background1,
                        R.drawable.cherry005_adachi_play_episode1_09_background2, R.drawable.cherry005_adachi_play_episode1_10_background1,
                        R.drawable.cherry005_adachi_play_episode1_10_case1_background1, R.drawable.cherry005_adachi_play_episode1_10_case1_background2,
                        R.drawable.cherry005_adachi_play_episode1_10_case2_background1, R.drawable.cherry005_adachi_play_episode1_10_case2_background2,
                        R.drawable.cherry005_adachi_play_episode1_10_case2_background3, R.drawable.cherry005_adachi_play_episode1_10_case2_background4};

    String cherry5_text1, cherry5_text2, cherry5_text3, cherry5_text4, cherry5_text5, cherry5_text6, cherry5_text7,
            cherry5_text8, cherry5_text9, cherry5_text10, cherry5_text11, cherry5_text12, cherry5_text13, cherry5_text14,
            cherry5_text15, cherry5_text16, cherry5_text17;

    boolean value1 = true, value2 = true, value3 = true, value4 = true, value5 = true, value6 = true, value7 = true, value8 = true, value9 = true;

    TextView textView1, textView2;

    TextView cherry5_case1, cherry5_case2;

    TextView cherry5_menu_button;
    LinearLayout cherry5_next_button;
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
        setContentView(R.layout.cherry005_activity_adachi_episode1_2);

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

        cherry5_background = findViewById(R.id.cherry5_background);
        cherry5_introduce_kurosawa = findViewById(R.id.cherry5_introduce_kurosawa);

        textView1 = findViewById(R.id.cherry5_textview1);
        textView2 = findViewById(R.id.cherry5_textview2);

        cherry5_next_button = findViewById(R.id.cherry5_next_button);
        cherry5_menu_button = findViewById(R.id.cherry5_menu_button);

        cherry5_text1 = "내가 원해서 동정인게 아니다.";
        cherry5_text2 = "지금까지 좋아했던 사람도 있었고 회사에 괜찮은 사람도 있다고 생각한다.";
        cherry5_text3 = "하지만 내가 먼저 고백하는 일은 절대 불가능...";
        cherry5_text4 = "잘될 리도 없고, 그 이후를 생각하면 너무 어색하다.";
        cherry5_text5 = "\"쿠로사와씨, 와인 좋아하시죠?\"";
        cherry5_text6 = "멀리서 대화소리가 들려서 봐 보니,";
        cherry5_text7 = "동기인 쿠로사와가 여직원들과 대화를 나누고 있었다.";
        cherry5_text8 = "쿠로사와. 영업부의 에이스로 5년 연속 실적 1위를 차지.";
        cherry5_text9 = "상사도 여직원들의 평가도 최고인 상큼한 꽃미남.";
        cherry5_text10 = "동기라는 점과 성별을 빼고는 공통점이 하나도 없는 남자.";
        cherry5_text11 = "그런 그가 점점 자신 쪽으로 다가온다.";
        cherry5_text12 = "\"고생했어\"";
        cherry5_text13 = "\"응? 응\"";
        cherry5_text14 = "미소가 눈부셔";
        cherry5_text15 = "나는 쿠로사와를 뒤로 하고 허겁지겁 서둘러 자리에 앉았다.";
        cherry5_text16 = "만약 내게 쿠로사와가 가진 매력 중 단 하나라도 있었다면...";
        cherry5_text17 = "아니다, 없는 걸 바라지 말자.";

        sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        soundId = sound.load(this, R.raw.shorttypingsound, 0);

        if (UseAll.player != null && UseAll.player.isPlaying()) UseAll.soundStop();
        UseAll.soundStart(5);

        cherry5_case1 = findViewById(R.id.cherry5_case1);
        cherry5_case2 = findViewById(R.id.cherry5_case2);

        cherry5_next_button.setVisibility(View.INVISIBLE);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                episode_number = 1;
                Cherry5_Thread1 thread1 = new Cherry5_Thread1();
                thread1.start();
                cherry5_next_button.setVisibility(View.VISIBLE);
            }
        }, 3000);

        cherry5_menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (episode_number != 2 && episode_number != 4 && episode_number != 6 &&
                        episode_number != 8 && episode_number != 10 &&
                        episode_number != 13 && episode_number != 15 && episode_number != 17){
                    clickFunc();
                }

                Intent intent = new Intent(getApplicationContext(), Cherry100_Episode_Pause.class);
                startActivityForResult(intent, 101);
            }
        });

        cherry5_case1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                episode_number = 12;
                cherry5_background.setImageResource(cherry5_background_image[8]);
                cherry5_case1.setVisibility(View.INVISIBLE);
                cherry5_case2.setVisibility(View.INVISIBLE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Cherry5_Thread7 thread7 = new Cherry5_Thread7();
                        thread7.start();
                        cherry5_next_button.setVisibility(View.VISIBLE);
                    }
                }, 1500);
            }
        });

        cherry5_case2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cherry5_next_button.setVisibility(View.INVISIBLE);
                episode_number = 16;
                cherry5_case1.setVisibility(View.INVISIBLE);
                cherry5_case2.setVisibility(View.INVISIBLE);

                textView1.setText("");
                textView2.setText("");
                cherry5_background.setImageResource(cherry5_background_image[10]);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Cherry5_Thread9 thread9 = new Cherry5_Thread9();
                        thread9.start();
                        cherry5_next_button.setVisibility(View.VISIBLE);
                    }
                }, 1500);
            }
        });

        cherry5_next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickFunc();
            }
        });
    }

    public void clickFunc(){
        if (episode_number == 1){
            if (play) playSound(false);
            cherry5_next_button.setVisibility(View.INVISIBLE);
            value1 = false;
            episode_number = 2;
            textView1.setText(cherry5_text1);
            textView2.setText(cherry5_text2);
            cherry5_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 2){
            cherry5_next_button.setVisibility(View.INVISIBLE);
            episode_number = 3;
            textView1.setText("");
            textView2.setText("");
            cherry5_background.setImageResource(cherry5_background_image[1]);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry5_Thread2 thread2 = new Cherry5_Thread2();
                    thread2.start();
                    cherry5_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 3){
            if (play) playSound(false);
            cherry5_next_button.setVisibility(View.INVISIBLE);
            value2 = false;
            episode_number = 4;
            textView1.setText(cherry5_text3);
            textView2.setText(cherry5_text4);
            cherry5_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 4){
            cherry5_next_button.setVisibility(View.INVISIBLE);
            episode_number = 5;
            textView1.setText("");
            textView2.setText("");
            cherry5_background.setImageResource(cherry5_background_image[2]);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry5_Thread3 thread3 = new Cherry5_Thread3();
                    thread3.start();
                    cherry5_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 5){
            if (play) playSound(false);
            cherry5_next_button.setVisibility(View.INVISIBLE);
            value3 = false;
            episode_number = 6;
            textView1.setText(cherry5_text5);
            textView2.setText(cherry5_text6);
            cherry5_background.setImageResource(cherry5_background_image[3]);
            cherry5_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 6){
            cherry5_next_button.setVisibility(View.INVISIBLE);
            episode_number = 7;
            textView1.setText("");
            textView2.setText("");
            cherry5_background.setImageResource(cherry5_background_image[4]);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry5_Thread4 thread4 = new Cherry5_Thread4();
                    thread4.start();
                    cherry5_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 7){
            if (play) playSound(false);
            cherry5_next_button.setVisibility(View.INVISIBLE);
            value4 = false;
            episode_number = 8;
            textView1.setText(cherry5_text7);
            cherry5_introduce_kurosawa.setVisibility(View.INVISIBLE);
            cherry5_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 8){
            cherry5_next_button.setVisibility(View.INVISIBLE);
            episode_number = 9;
            textView1.setText("");
            textView2.setText("");
            cherry5_background.setImageResource(cherry5_background_image[5]);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry5_Thread5 thread5 = new Cherry5_Thread5();
                    thread5.start();
                }
            }, 1500);
        } else if (episode_number == 9) {
            if (play) playSound(false);
            cherry5_next_button.setVisibility(View.INVISIBLE);
            value5 = false;
            episode_number = 10;
            textView1.setText(cherry5_text9);
            textView2.setText(cherry5_text10);
            cherry5_background.setImageResource(cherry5_background_image[6]);
            cherry5_introduce_kurosawa.setVisibility(View.INVISIBLE);
            cherry5_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 10){
            if (play) playSound(false);
            cherry5_next_button.setVisibility(View.INVISIBLE);
            episode_number = 11;
            textView1.setText("");
            textView2.setText("");
            cherry5_background.setImageResource(cherry5_background_image[7]);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry5_Thread6 thread6 = new Cherry5_Thread6();
                    thread6.start();
                    cherry5_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 11){
            if (play) playSound(false);
            cherry5_next_button.setVisibility(View.INVISIBLE);
            value6 = false;
            textView1.setText(cherry5_text11);
            cherry5_case1.setVisibility(View.VISIBLE);
            cherry5_case2.setVisibility(View.VISIBLE);
        } else if (episode_number == 12){
            if (play) playSound(false);
            cherry5_next_button.setVisibility(View.INVISIBLE);
            value7 = false;
            episode_number = 13;
            textView2.setText(cherry5_text12);
            cherry5_background.setImageResource(cherry5_background_image[8]);
            cherry5_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 13){
            cherry5_next_button.setVisibility(View.INVISIBLE);
            episode_number = 14;
            textView1.setText("");
            textView2.setText("");
            cherry5_background.setImageResource(cherry5_background_image[9]);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry5_Thread8 thread8 = new Cherry5_Thread8();
                    thread8.start();
                    cherry5_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 14){
            if (play) playSound(false);
            cherry5_next_button.setVisibility(View.INVISIBLE);
            value8 = false;
            episode_number = 15;
            textView1.setText(cherry5_text13);
            textView2.setText(cherry5_text14);
            cherry5_introduce_kurosawa.setVisibility(View.INVISIBLE);
            cherry5_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 15){
            cherry5_next_button.setVisibility(View.INVISIBLE);
            episode_number = 16;
            textView1.setText("");
            textView2.setText("");
            cherry5_background.setImageResource(cherry5_background_image[10]);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry5_Thread9 thread9 = new Cherry5_Thread9();
                    thread9.start();
                    cherry5_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 16){
            if (play) playSound(false);
            cherry5_next_button.setVisibility(View.INVISIBLE);
            value9 = false;
            episode_number = 17;
            textView1.setText(cherry5_text16);
            textView2.setText(cherry5_text17);
            cherry5_background.setImageResource(cherry5_background_image[13]);
            cherry5_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 17) {
            Intent intent = new Intent(getApplicationContext(), Cherry6_Adachi_Episode1_3.class);
            startActivity(intent);

            overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
            finish();
        }
    }

    class Cherry5_Thread1 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry5_text1.split("");
        String[] text2_list = cherry5_text2.split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value1 && !play) playSound(true);

            while (value1 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                textView1.setText(text1_build.toString());
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
                textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value1 && play) playSound(false);

            if (value1) episode_number = 2;
        }
    }

    class Cherry5_Thread2 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry5_text3.split("");
        String[] text2_list = cherry5_text4.split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value2 && !play) playSound(true);

            while (value2 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                textView1.setText(text1_build.toString());
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
                textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value2 && play) playSound(false);

            if (value2) episode_number = 4;
        }
    }

    class Cherry5_Thread3 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry5_text5.split("");
        String[] text2_list = cherry5_text6.split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value3 && !play) playSound(true);

            while (value3 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                textView1.setText(text1_build.toString());
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
                    if (value3) cherry5_background.setImageResource(cherry5_background_image[3]);
                    if (value3 && !play) playSound(true);
                }
            });

            while (value3 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value3 && play) playSound(false);

            if (value3) episode_number = 6;
        }
    }

    class Cherry5_Thread4 extends Thread{
        int text1_time = 0;

        String[] text1_list = cherry5_text7.split("");

        StringBuilder text1_build = new StringBuilder();

        @Override
        public void run() {

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value4) cherry5_introduce_kurosawa.setVisibility(View.VISIBLE);
                }
            });

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (value4) cherry5_introduce_kurosawa.setVisibility(View.INVISIBLE);
                }
            }, 2000);

            if (value4 && !play) playSound(true);

            while (value4 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value4 && play) playSound(false);


            if (value4) episode_number = 8;
        }
    }

    class Cherry5_Thread5 extends Thread{
        int text1_time = 0;
        int text2_time = 0;
        int text3_time = 0;

        String[] text1_list = cherry5_text8.split("");
        String[] text2_list = cherry5_text9.split("");
        String[] text3_list = cherry5_text10.split("");
        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();
        StringBuilder text3_build = new StringBuilder();

        @Override
        public void run() {

            if (value5 && !play) playSound(true);


            while (value5 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value5) cherry5_next_button.setVisibility(View.VISIBLE);
                    if (value5 && play) playSound(false);
                }
            });

            try {
                if (value5) Thread.sleep(1500);
            } catch (Exception e) { }

            if (value5 && !play) playSound(true);


            while (value5 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value5 && play) playSound(false);

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value5) textView1.setText(text2_build.toString());
                    if (value5) textView2.setText("");
                    if (value5) cherry5_background.setImageResource(cherry5_background_image[6]);
                }
            });

            try {
                if (value5) Thread.sleep(100);
            } catch (Exception e) { }

            if (value5 && !play) playSound(true);

            while (value5 && text3_time < text3_list.length){
                text3_build.append(text3_list[text3_time]);
                textView2.setText(text3_build.toString());
                text3_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value5 && play) playSound(false);

            if (value5) episode_number = 10;
        }
    }

    class Cherry5_Thread6 extends Thread{
        int text1_time = 0;

        String[] text1_list = cherry5_text11.split("");
        StringBuilder text1_build = new StringBuilder();

        @Override
        public void run() {
            if (value6 && !play) playSound(true);

            while (value6 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                textView1.setText(text1_build.toString());
                text1_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value6) cherry5_case1.setVisibility(View.VISIBLE);
                    if (value6) cherry5_case2.setVisibility(View.VISIBLE);
                    if (value6) cherry5_next_button.setVisibility(View.INVISIBLE);
                    if (value6 && play) playSound(false);
                }
            });
        }
    }

    class Cherry5_Thread7 extends Thread{
        int text2_time = 0;

        String[] text2_list = cherry5_text12.split("");
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value7 && !play) playSound(true);

            while (value7 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value7 && play) playSound(false);


            if (value7) episode_number = 13;
        }
    }

    class Cherry5_Thread8 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry5_text13.split("");
        String[] text2_list = cherry5_text14.split("");
        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value8 && !play) playSound(true);

            while (value8 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                textView1.setText(text1_build.toString());
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
                textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value8 && play) playSound(false);

            if (value8) episode_number = 15;
        }
    }

    class Cherry5_Thread9 extends Thread{
        int text1_time = 0;
        int text2_time = 0;
        int text3_time = 0;

        String[] text1_list = cherry5_text15.split("");
        String[] text2_list = cherry5_text16.split("");
        String[] text3_list = cherry5_text17.split("");
        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();
        StringBuilder text3_build = new StringBuilder();

        @Override
        public void run() {
            if (value9 && !play) playSound(true);

            while (value9 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                textView1.setText(text1_build.toString());
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
                    if (value9) cherry5_next_button.setVisibility(View.VISIBLE);
                    if (value9) cherry5_background.setImageResource(cherry5_background_image[11]);
                }
            });

            try {
                if (value9) Thread.sleep(500);
            } catch (Exception e) { }

            if (value9 && !play) playSound(true);

            while (value9 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                textView2.setText(text2_build.toString());
                text2_time++;

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
                    if (value9) textView1.setText(text2_build.toString());
                    if (value9) textView2.setText("");
                    if (value9) cherry5_background.setImageResource(cherry5_background_image[12]);
                }
            });

            try {
                if (value9) Thread.sleep(500);
            } catch (Exception e) { }

            if (value9 && !play) playSound(true);

            while (value9 && text3_time < text3_list.length){
                text3_build.append(text3_list[text3_time]);
                textView2.setText(text3_build.toString());
                text3_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value9) cherry5_background.setImageResource(cherry5_background_image[13]);
                    if (value9 && play) playSound(false);
                }
            });

            if (value9) episode_number = 17;
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
