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

public class Cherry11_Adachi_Episode3_1 extends AppCompatActivity {

    ImageView cherry11_background;
    TextView cherry11_menu_button;

    OutlineTextView cherry11_textView1, cherry11_textView2;

    FrameLayout cherry11_title;

    String[] cherry11_text = new String[]{"일을 하다 보니 어느덧 해가 졌다.", "\"왜 이렇게 안 끝나! 결국 일을 다 떠맡게 됐잖아 정말\"", //0, 1
            "\"아직도 안 갔어?\"", "\"쿠로사와\"", //2, 3
            "\"이거 마셔 후배들한테 주고 남은거야\"", "갑자기 쿠로사와는 나에게 캔커피를 권했다.", //4, 5
            "낮에 있었던 일 때문에 심란하지만", "날 위해서 산건 아니니까.... 괜찮겠지?", //6, 7
            "'사실 널 위해 산 거야'", "당황하지 마. 이건 분명 환청일 거야", //8, 9
            "평소대로 대화를 끝내고 다시 일하는 거야 그렇게만 하면 돼", "\"고마워 그럼, 잘 가\"", //10, 11
            "나는 서둘러 인사하고 노트북 쪽으로 몸을 돌렸다.", "그런데... 왜 안 가지..?", //12, 13
            "\"이거, 사지마 문구 거야?\"", "갑자기 다가온 쿠로사와로 인해 심장이 쿵쾅거린다.", //14, 15
            "\"응 과거의 거래 데이터를 정리해달라고 해서\"", "\"기왕 정리할 거면 데이터가 더 있는 게 좋겠어\"", //16, 17
            "\"지금도 일이 많은데...\"", "\"도와줄게. 잠깐만 있어봐, 지금 자료 가져올게\"", //18, 19
            "\"그렇지만...\"", //20
            "쿠로사와는 정말로 자료를 가지러 갔고", "결국 단둘이 있게 됐다." //21, 22
    };

    int[] cherry11_image = new int[]{R.drawable.cherry011_adachi_play_episode3_1_background1, R.drawable.cherry011_adachi_play_episode3_1_background2, //0, 1
            R.drawable.cherry011_adachi_play_episode3_1_background3, R.drawable.cherry011_adachi_play_episode3_1_background4, //2, 3
            R.drawable.cherry011_adachi_play_episode3_1_background5, R.drawable.cherry011_adachi_play_episode3_1_background6, //4, 5
            R.drawable.cherry011_adachi_play_episode3_1_background7, R.drawable.cherry011_adachi_play_episode3_1_background8, //6, 7
            R.drawable.cherry011_adachi_play_episode3_2_background1, R.drawable.cherry011_adachi_play_episode3_2_background2, //8, 9
            R.drawable.cherry011_adachi_play_episode3_2_background3, R.drawable.cherry011_adachi_play_episode3_2_background4, //10, 11
            R.drawable.cherry011_adachi_play_episode3_2_background5, R.drawable.cherry011_adachi_play_episode3_3_background1, //12, 13
            R.drawable.cherry011_adachi_play_episode3_3_background2, R.drawable.cherry011_adachi_play_episode3_3_background3, //14, 15
            R.drawable.cherry011_adachi_play_episode3_3_background4, R.drawable.cherry011_adachi_play_episode3_3_background5, //16, 17
            R.drawable.cherry011_adachi_play_episode3_3_background6 //18

    };

    boolean value1 = true, value2 = true, value3 = true, value4 = true, value5 = true, value6 = true, value7 = true,
            value8 = true, value9 = true, value10 = true, value11 = true;

    LinearLayout cherry11_next_button;

    TextView cherry11_case1, cherry11_case2;

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
        setContentView(R.layout.cherry011_activity_adachi_episode3_1);

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
        UseAll.soundStart(6);

        cherry11_background = findViewById(R.id.cherry11_background);
        cherry11_menu_button = findViewById(R.id.cherry11_menu_button);

        cherry11_textView1 = findViewById(R.id.cherry11_textview1);
        cherry11_textView2 = findViewById(R.id.cherry11_textview2);

        cherry11_next_button = findViewById(R.id.cherry11_next_button);

        cherry11_title = findViewById(R.id.cherry11_title);

        cherry11_case1 = findViewById(R.id.cherry11_case1);
        cherry11_case2 = findViewById(R.id.cherry11_case2);

        cherry11_menu_button.setOnClickListener(new View.OnClickListener() {
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

        Animation outAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.activity_alpha_out);
        OutAnimationListener animListener = new OutAnimationListener();
        outAnim.setAnimationListener(animListener);

        cherry11_title.setVisibility(View.VISIBLE);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                cherry11_title.startAnimation(outAnim);
            }
        }, 3000);

        cherry11_next_button.setVisibility(View.INVISIBLE);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                episode_number = 1;
                cherry11_next_button.setVisibility(View.INVISIBLE);
                cherry11_background.setImageResource(cherry11_image[0]);
                Cherry11_Thread1 thread1 = new Cherry11_Thread1();
                thread1.start();
                cherry11_next_button.setVisibility(View.VISIBLE);
            }
        }, 5000);

        cherry11_case1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (episode_number == 18) {
                    cherry11_next_button.setVisibility(View.INVISIBLE);
                    episode_number = 19;
                    cherry11_case1.setVisibility(View.INVISIBLE);
                    cherry11_case2.setVisibility(View.INVISIBLE);
                    cherry11_textView1.setText("");
                    cherry11_textView2.setText("");
                    cherry11_background.setImageResource(cherry11_image[16]);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Cherry11_Thread10 thread10 = new Cherry11_Thread10();
                            thread10.start();
                            cherry11_next_button.setVisibility(View.VISIBLE);
                        }
                    }, 1500);
                }
            }
        });

        cherry11_case2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (episode_number == 18) {
                    cherry11_next_button.setVisibility(View.INVISIBLE);
                    episode_number = 21;
                    cherry11_case1.setVisibility(View.INVISIBLE);
                    cherry11_case2.setVisibility(View.INVISIBLE);
                    cherry11_textView1.setText("");
                    cherry11_textView2.setText("");
                    cherry11_background.setImageResource(cherry11_image[16]);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Cherry11_Thread10 thread10 = new Cherry11_Thread10();
                            thread10.start();
                            cherry11_next_button.setVisibility(View.VISIBLE);
                        }
                    }, 1500);
                }
            }
        });

        cherry11_next_button.setOnClickListener(new View.OnClickListener() {
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
            cherry11_next_button.setVisibility(View.INVISIBLE);
            episode_number = 2;
            cherry11_background.setImageResource(cherry11_image[1]);
            cherry11_textView1.setText(cherry11_text[0]);
            cherry11_textView2.setText(cherry11_text[1]);
            cherry11_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 2){
            cherry11_next_button.setVisibility(View.INVISIBLE);
            episode_number = 3;
            cherry11_textView1.setText("");
            cherry11_textView2.setText("");
            cherry11_background.setImageResource(cherry11_image[2]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry11_Thread2 thread2 = new Cherry11_Thread2();
                    thread2.start();
                    cherry11_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 3){
            if (play) playSound(false);
            value2 = false;
            cherry11_next_button.setVisibility(View.INVISIBLE);
            episode_number = 4;
            cherry11_background.setImageResource(cherry11_image[4]);
            cherry11_textView1.setText(cherry11_text[2]);
            cherry11_textView2.setText(cherry11_text[3]);
            cherry11_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 4){
            cherry11_next_button.setVisibility(View.INVISIBLE);
            episode_number = 5;
            cherry11_textView1.setText("");
            cherry11_textView2.setText("");
            cherry11_background.setImageResource(cherry11_image[5]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry11_Thread3 thread3 = new Cherry11_Thread3();
                    thread3.start();
                    cherry11_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 5){
            if (play) playSound(false);
            value3 = false;
            cherry11_next_button.setVisibility(View.INVISIBLE);
            episode_number = 6;
            cherry11_textView1.setText(cherry11_text[4]);
            cherry11_textView2.setText(cherry11_text[5]);
            cherry11_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 6){
            cherry11_next_button.setVisibility(View.INVISIBLE);
            episode_number = 7;
            cherry11_textView1.setText("");
            cherry11_textView2.setText("");
            cherry11_background.setImageResource(cherry11_image[6]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry11_Thread4 thread4 = new Cherry11_Thread4();
                    thread4.start();
                    cherry11_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 7){
            if (play) playSound(false);
            value4 = false;
            cherry11_next_button.setVisibility(View.INVISIBLE);
            episode_number = 8;
            cherry11_background.setImageResource(cherry11_image[7]);
            cherry11_textView1.setText(cherry11_text[6]);
            cherry11_textView2.setText(cherry11_text[7]);
            cherry11_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 8){
            if (UseAll.player != null && UseAll.player.isPlaying()) UseAll.soundStop();
            UseAll.soundStart(23);
            cherry11_next_button.setVisibility(View.INVISIBLE);
            episode_number = 9;
            cherry11_textView1.setText("");
            cherry11_textView2.setText("");
            cherry11_background.setImageResource(cherry11_image[8]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry11_Thread5 thread5 = new Cherry11_Thread5();
                    thread5.start();
                    cherry11_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 9){
            if (play) playSound(false);
            value5 = false;
            cherry11_next_button.setVisibility(View.INVISIBLE);
            episode_number = 10;
            cherry11_background.setImageResource(cherry11_image[9]);
            cherry11_textView1.setText(cherry11_text[8]);
            cherry11_textView2.setText(cherry11_text[9]);
            cherry11_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 10){
            cherry11_next_button.setVisibility(View.INVISIBLE);
            episode_number = 11;
            cherry11_textView1.setText("");
            cherry11_textView2.setText("");
            cherry11_background.setImageResource(cherry11_image[10]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry11_Thread6 thread6 = new Cherry11_Thread6();
                    thread6.start();
                    cherry11_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 11){
            if (play) playSound(false);
            value6 = false;
            cherry11_next_button.setVisibility(View.INVISIBLE);
            episode_number = 12;
            cherry11_textView1.setText(cherry11_text[10]);
            cherry11_textView2.setText(cherry11_text[11]);
            cherry11_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 12){
            cherry11_next_button.setVisibility(View.INVISIBLE);
            episode_number = 13;
            cherry11_textView1.setText("");
            cherry11_textView2.setText("");
            cherry11_background.setImageResource(cherry11_image[11]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry11_Thread7 thread7 = new Cherry11_Thread7();
                    thread7.start();
                    cherry11_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 13){
            if (play) playSound(false);
            value7 = false;
            cherry11_next_button.setVisibility(View.INVISIBLE);
            episode_number = 14;
            cherry11_background.setImageResource(cherry11_image[12]);
            cherry11_textView1.setText(cherry11_text[12]);
            cherry11_textView2.setText(cherry11_text[13]);
            cherry11_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 14){
            cherry11_next_button.setVisibility(View.INVISIBLE);
            episode_number = 15;
            cherry11_textView1.setText("");
            cherry11_textView2.setText("");
            cherry11_background.setImageResource(cherry11_image[13]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry11_Thread8 thread8 = new Cherry11_Thread8();
                    thread8.start();
                    cherry11_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 15){
            if (play) playSound(false);
            value8 = false;
            cherry11_next_button.setVisibility(View.INVISIBLE);
            episode_number = 16;
            cherry11_textView1.setText(cherry11_text[14]);
            cherry11_textView2.setText(cherry11_text[15]);
            cherry11_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 16){
            cherry11_next_button.setVisibility(View.INVISIBLE);
            episode_number = 17;
            cherry11_textView1.setText("");
            cherry11_textView2.setText("");
            cherry11_background.setImageResource(cherry11_image[14]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry11_Thread9 thread9 = new Cherry11_Thread9();
                    thread9.start();
                    cherry11_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 17){
            if (play) playSound(false);
            value9 = false;
            cherry11_next_button.setVisibility(View.INVISIBLE);
            cherry11_case1.setVisibility(View.VISIBLE);
            cherry11_case2.setVisibility(View.VISIBLE);
            episode_number = 18;
            cherry11_background.setImageResource(cherry11_image[15]);
            cherry11_textView1.setText(cherry11_text[16]);
            cherry11_textView2.setText(cherry11_text[17]);
        } else if (episode_number == 19){
            if (play) playSound(false);
            value10 = false;
            cherry11_next_button.setVisibility(View.INVISIBLE);
            cherry11_case1.setVisibility(View.INVISIBLE);
            cherry11_case2.setVisibility(View.INVISIBLE);
            episode_number = 22;
            cherry11_background.setImageResource(cherry11_image[16]);
            cherry11_textView1.setText(cherry11_text[18]);
            cherry11_textView2.setText(cherry11_text[19]);
            cherry11_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 21){
            if (play) playSound(false);
            value10 = false;
            cherry11_next_button.setVisibility(View.INVISIBLE);
            cherry11_case1.setVisibility(View.INVISIBLE);
            cherry11_case2.setVisibility(View.INVISIBLE);
            episode_number = 22;
            cherry11_background.setImageResource(cherry11_image[16]);
            cherry11_textView1.setText(cherry11_text[20]);
            cherry11_textView2.setText(cherry11_text[19]);
            cherry11_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 22){
            cherry11_next_button.setVisibility(View.INVISIBLE);
            episode_number = 23;
            cherry11_textView1.setText("");
            cherry11_textView2.setText("");
            cherry11_background.setImageResource(cherry11_image[17]);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Cherry11_Thread11 thread11 = new Cherry11_Thread11();
                    thread11.start();
                    cherry11_next_button.setVisibility(View.VISIBLE);
                }
            }, 1500);
        } else if (episode_number == 23){
            if (play) playSound(false);
            value11 = false;
            cherry11_next_button.setVisibility(View.INVISIBLE);
            episode_number = 24;
            cherry11_background.setImageResource(cherry11_image[18]);
            cherry11_textView1.setText(cherry11_text[21]);
            cherry11_textView2.setText(cherry11_text[22]);
            cherry11_next_button.setVisibility(View.VISIBLE);
        } else if (episode_number == 24) {
            Intent intent = new Intent(getApplicationContext(), Cherry12_Adachi_Episode3_2.class);
            startActivity(intent);

            overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
            finish();
        }
    }

    class Cherry11_Thread1 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry11_text[0].split("");
        String[] text2_list = cherry11_text[1].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value1 && !play) playSound(true);

            while (value1 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry11_textView1.setText(text1_build.toString());
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
                        cherry11_background.setImageResource(cherry11_image[1]);
                    }
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value1 && !play) playSound(true);

            while (value1 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry11_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value1 && play) playSound(false);

            if (value1) episode_number = 2;
        }
    }

    class Cherry11_Thread2 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry11_text[2].split("");
        String[] text2_list = cherry11_text[3].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value2 && !play) playSound(true);

            while (value2 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry11_textView1.setText(text1_build.toString());
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
                        cherry11_background.setImageResource(cherry11_image[3]);
                    }
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value2){
                        cherry11_background.setImageResource(cherry11_image[4]);
                    }
                }
            });

            if (value2 && !play) playSound(true);

            while (value2 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry11_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value2 && play) playSound(false);

            if (value2) episode_number = 4;
        }
    }

    class Cherry11_Thread3 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry11_text[4].split("");
        String[] text2_list = cherry11_text[5].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value3 && !play) playSound(true);

            while (value3 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry11_textView1.setText(text1_build.toString());
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
                cherry11_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value3 && play) playSound(false);

            if (value3) episode_number = 6;
        }
    }

    class Cherry11_Thread4 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry11_text[6].split("");
        String[] text2_list = cherry11_text[7].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value4 && !play) playSound(true);

            while (value4 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry11_textView1.setText(text1_build.toString());
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
                    if (value4) cherry11_background.setImageResource(cherry11_image[7]);
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value4 && !play) playSound(true);

            while (value4 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry11_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value4 && play) playSound(false);

            if (value4) episode_number = 8;
        }
    }

    class Cherry11_Thread5 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry11_text[8].split("");
        String[] text2_list = cherry11_text[9].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value5 && !play) playSound(true);

            while (value5 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry11_textView1.setText(text1_build.toString());
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
                    if (value5) cherry11_background.setImageResource(cherry11_image[9]);
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value5 && !play) playSound(true);

            while (value5 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry11_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value5 && play) playSound(false);

            if (value5) episode_number = 10;
        }
    }

    class Cherry11_Thread6 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry11_text[10].split("");
        String[] text2_list = cherry11_text[11].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value6 && !play) playSound(true);

            while (value6 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry11_textView1.setText(text1_build.toString());
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
                cherry11_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value6 && play) playSound(false);

            if (value6) episode_number = 12;
        }
    }

    class Cherry11_Thread7 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry11_text[12].split("");
        String[] text2_list = cherry11_text[13].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value7 && !play) playSound(true);

            while (value7 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry11_textView1.setText(text1_build.toString());
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
                    if (value7) cherry11_background.setImageResource(cherry11_image[12]);
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value7 && !play) playSound(true);

            while (value7 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry11_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value7 && play) playSound(false);

            if (value7) episode_number = 14;
        }
    }

    class Cherry11_Thread8 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry11_text[14].split("");
        String[] text2_list = cherry11_text[15].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value8 && !play) playSound(true);

            while (value8 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry11_textView1.setText(text1_build.toString());
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
                cherry11_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value8 && play) playSound(false);

            if (value8) episode_number = 16;
        }
    }

    class Cherry11_Thread9 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry11_text[16].split("");
        String[] text2_list = cherry11_text[17].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value9 && !play) playSound(true);

            while (value9 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry11_textView1.setText(text1_build.toString());
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
                    if (value9) cherry11_background.setImageResource(cherry11_image[15]);
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value9 && !play) playSound(true);

            while (value9 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry11_textView2.setText(text2_build.toString());
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
                        cherry11_next_button.setVisibility(View.INVISIBLE);
                        cherry11_case1.setVisibility(View.VISIBLE);
                        cherry11_case2.setVisibility(View.VISIBLE);
                    }
                }
            });

            if (value9) episode_number = 18;
        }
    }

    class Cherry11_Thread10 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = (episode_number == 19) ? cherry11_text[18].split("") : cherry11_text[20].split("");
        String[] text2_list = cherry11_text[19].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value10 && !play) playSound(true);

            while (value10 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry11_textView1.setText(text1_build.toString());
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
                cherry11_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value10 && play) playSound(false);

            if (value10) episode_number = 22;
        }
    }

    class Cherry11_Thread11 extends Thread{
        int text1_time = 0;
        int text2_time = 0;

        String[] text1_list = cherry11_text[21].split("");
        String[] text2_list = cherry11_text[22].split("");

        StringBuilder text1_build = new StringBuilder();
        StringBuilder text2_build = new StringBuilder();

        @Override
        public void run() {

            if (value11 && !play) playSound(true);

            while (value11 && text1_time < text1_list.length) {
                text1_build.append(text1_list[text1_time]);
                cherry11_textView1.setText(text1_build.toString());
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
                    if (value11) cherry11_background.setImageResource(cherry11_image[18]);
                }
            });

            try {
                if (value5) Thread.sleep(500);
            } catch (Exception e) { }

            if (value11 && !play) playSound(true);

            while (value11 && text2_time < text2_list.length){
                text2_build.append(text2_list[text2_time]);
                cherry11_textView2.setText(text2_build.toString());
                text2_time++;

                try {
                    Thread.sleep(50);
                } catch (Exception e) { }
            }

            if (value11 && play) playSound(false);

            if (value11) episode_number = 24;
        }
    }


    private class OutAnimationListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if (episode_number == 0) {
                cherry11_title.setVisibility(View.INVISIBLE);
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

