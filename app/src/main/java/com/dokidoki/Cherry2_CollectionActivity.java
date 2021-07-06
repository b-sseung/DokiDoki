package com.dokidoki;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Cherry2_CollectionActivity extends AppCompatActivity implements Cherry2_Collection_Fragment_Adachi.OnAdachiImageClickLisner,
        Cherry2_Collection_Fragment_Kurosawa.OnKurosawaImageClickLisner, Cherry2_Collection_Fragment_Chuge.OnChugeImageClickLisner {

    ViewPager cherry002_pager;

    TextView cherry002_collection_back_button;

    ArrayList<Cherry2_Collection_Item> adachi_items = new ArrayList<>();
    ArrayList<Cherry2_Collection_Item> kurosawa_items = new ArrayList<>();
    ArrayList<Cherry2_Collection_Item> chuge_items = new ArrayList<>();

    Cherry2_Collection_Fragment_Adachi adachi_fragment;
    Cherry2_Collection_Fragment_Kurosawa kurosawa_fragment;
    Cherry2_Collection_Fragment_Chuge chuge_fragment;

    ImageView cherry002_pre, cherry002_next, cherry002_name;
    int position = 0;
    int[] name_image = new int[]{R.drawable.cherry002_collection_name_adachi, R.drawable.cherry002_collection_name_coming1, R.drawable.cherry002_collection_name_coming2};

    FrameLayout cherry002_item_select_layout;
    ImageView cherry002_item_select_background, cherry002_item_select_text, cherry002_select_item_close;

    Animation inAnim, outAnim;

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
        setContentView(R.layout.cherry002_activity_collections);

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


        cherry002_pager = findViewById(R.id.cherry002_pager);
        cherry002_pager.setOffscreenPageLimit(3);

        PagerAdapter PA = new PagerAdapter(getSupportFragmentManager());
        adachi_fragment = new Cherry2_Collection_Fragment_Adachi();
        kurosawa_fragment = new Cherry2_Collection_Fragment_Kurosawa();
        chuge_fragment = new Cherry2_Collection_Fragment_Chuge();

        while (adachi_items.isEmpty() && kurosawa_items.isEmpty() && chuge_items.isEmpty()) loadCollectionData();

        PA.addItem(adachi_fragment);
        PA.addItem(kurosawa_fragment);
        PA.addItem(chuge_fragment);

        cherry002_pager.setAdapter(PA);

        cherry002_pre = findViewById(R.id.cherry002_collection_pre_button);
        cherry002_next = findViewById(R.id.cherry002_collection_next_button);
        cherry002_name = findViewById(R.id.cherry002_collection_name);

        cherry002_item_select_layout = findViewById(R.id.cherry002_item_select);
        cherry002_item_select_background = findViewById(R.id.cherry002_item_select_background);
        cherry002_item_select_text = findViewById(R.id.cherry002_item_select_text);
        cherry002_select_item_close = findViewById(R.id.cherry002_select_item_close);

        inAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.activity_alpha_in);
        outAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.activity_alpha_out);
        OutAnimListener outListener = new OutAnimListener();
        outAnim.setAnimationListener(outListener);

        LinearLayout cherry002_collection_layout = findViewById(R.id.cherry002_collection_layout);
        cherry002_collection_layout.setLayoutParams(new FrameLayout.LayoutParams(UseAll.width, UseAll.height));

        cherry002_collection_back_button = findViewById(R.id.cherry002_collection_back_button);

        Log.d("1818", adachi_items.size() + ", " + kurosawa_items.size() + ", " + chuge_items.size());

        if (UseAll.player != null && UseAll.player.isPlaying()) UseAll.soundStop();
        UseAll.soundStart(3);

        cherry002_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = (position == 0) ? 2 : position - 1;
                cherry002_name.setImageResource(name_image[position]);
                cherry002_pager.setCurrentItem(position);
            }
        });

        cherry002_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = (position == 2) ? 0 : position + 1;
                cherry002_name.setImageResource(name_image[position]);
                cherry002_pager.setCurrentItem(position);
            }
        });

        //스와이프 막기
        cherry002_pager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        cherry002_select_item_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cherry002_item_select_layout.startAnimation(outAnim);
            }
        });

        cherry002_item_select_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cherry002_item_select_text.setVisibility(View.VISIBLE);
            }
        });

        cherry002_item_select_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cherry002_item_select_text.setVisibility(View.INVISIBLE);
            }
        });

        cherry002_collection_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Cherry1_MainActivity.class);
                startActivity(intent);

                overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);
                finish();
            }
        });
    }

    public void loadCollectionData(){
        Cherry_Database database = Cherry_Database.getInstance(UseAll.mainContext);

        String sql = "select _id " + " , charactor " + " , number " + " , isLock " + " , background " + " , text "
                + "from " + Cherry_Database.table1 + " "
                + "order by number asc";

        Log.d("database", sql);

        Cursor cursor = database.rawQuery(sql);
        int recordCound = cursor.getCount();

        Log.d("tlqkf", String.valueOf(recordCound));

        if (recordCound == 0){
            Cherry_Database.addTable1Data(UseAll.mainContext);
        }

        for (int i = 0; i < recordCound; i++){
            cursor.moveToNext();

            int id = cursor.getInt(0);
            String charactor = cursor.getString(1);
            int number = cursor.getInt(2);
            String isLock = cursor.getString(3);
            int background = cursor.getInt(4);
            int text = cursor.getInt(5);

            Log.d("1818", id + ", " + charactor + ", " + number + ", " + isLock + ", " + background + ", " + text);

            if (charactor.equals("adachi")){
                adachi_items.add(new Cherry2_Collection_Item(id, charactor, number, isLock, background, text));
            } else if (charactor.equals("kurosawa")){
                kurosawa_items.add(new Cherry2_Collection_Item(id, charactor, number, isLock, background, text));
            } else if (charactor.equals("chuge")){
                chuge_items.add(new Cherry2_Collection_Item(id, charactor, number, isLock, background, text));
            }
        }

        Bundle bundle1 = new Bundle();
        bundle1.putParcelableArrayList("adachi", adachi_items);
        adachi_fragment.setArguments(bundle1);

        Bundle bundle2 = new Bundle();
        bundle2.putParcelableArrayList("kurosawa", kurosawa_items);
        kurosawa_fragment.setArguments(bundle2);

        Bundle bundle3 = new Bundle();
        bundle3.putParcelableArrayList("chuge", chuge_items);
        chuge_fragment.setArguments(bundle3);


    }


    @Override
    public void OnAdachiImageClickLisner(boolean value, int backgroundId, int textId) {
        if (!value) {
            cherry002_item_select_background.setImageResource(backgroundId);
            cherry002_item_select_text.setImageResource(textId);
            cherry002_item_select_layout.setVisibility(View.VISIBLE);
            cherry002_item_select_layout.startAnimation(inAnim);
        }

        Log.d("1818", "click " + backgroundId + ", " + textId);
    }

    @Override
    public void OnKurosawaImageClickLisner(boolean value, int backgroundId, int textId) {
        if (!value) {
            cherry002_item_select_background.setImageResource(backgroundId);
            cherry002_item_select_text.setImageResource(textId);
            cherry002_item_select_layout.setVisibility(View.VISIBLE);
            cherry002_item_select_layout.startAnimation(inAnim);
        }

        Log.d("1818", "click " + backgroundId + ", " + textId);
    }

    @Override
    public void OnChugeImageClickLisner(boolean value, int backgroundId, int textId) {
        if (!value) {
            cherry002_item_select_background.setImageResource(backgroundId);
            cherry002_item_select_text.setImageResource(textId);
            cherry002_item_select_layout.setVisibility(View.VISIBLE);
            cherry002_item_select_layout.startAnimation(inAnim);
        }

        Log.d("1818", "click " + backgroundId + ", " + textId);
    }

    class OutAnimListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            cherry002_item_select_layout.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }

    class PagerAdapter extends FragmentStatePagerAdapter {

        ArrayList<Fragment> items = new ArrayList<>();

        public PagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        public void addItem(Fragment item){
            items.add(item);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }

        @Override
        public int getCount() {
            return items.size();
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
        Intent intent = new Intent(getApplicationContext(), Cherry1_MainActivity.class);
        startActivity(intent);

        overridePendingTransition(R.anim.activity_alpha_in, R.anim.activity_alpha_out);

        UseAll.soundPause();
        finish();
    }
}
