package com.dokidoki;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Cherry2_Collection_Fragment_Chuge extends Fragment {

    ImageView[] imageViews;
    private Activity activity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.cherry002_collection_chuge_fragment, container, false);

        ArrayList<Cherry2_Collection_Item> items = getArguments().getParcelableArrayList("chuge");
        imageViews = new ImageView[items.size()];

        for (int i = 0; i < items.size(); i++) {
            Cherry2_Collection_Item item = items.get(i);

            String a = (i < 9) ? "0"+(i+1) : ""+(i+1);
            int k = getResources().getIdentifier("cherry002_collection_chuge_"+a, "id", rootView.getContext().getPackageName());

            imageViews[i] = (ImageView) rootView.findViewById(k);
            imageViews[i].setVisibility(View.VISIBLE);

            Log.d("1818", item.getNumber() + item.getIsLock());

            boolean value;

            if (item.getIsLock().equals("true")) {
                imageViews[i].setImageResource(R.drawable.cherry002_collection_lock_image);
                value = true;
            } else {
                imageViews[i].setImageResource(item.getImageId());
                value = false;
            }

            imageViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((Cherry2_Collection_Fragment_Chuge.OnChugeImageClickLisner) activity).OnChugeImageClickLisner(value, item.getImageId(), item.getTextId());
                }
            });
        }

        return rootView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof Activity) {
            // 사용될 activity 에 context 정보 가져오는 부분
            this.activity = (Activity)context;
        }
    }

    public interface OnChugeImageClickLisner {

        public void OnChugeImageClickLisner(boolean value, int backgroundId, int textId);
    }
}

