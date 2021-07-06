package com.dokidoki;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class OutlineTextView extends AppCompatTextView {

    private boolean stroke = false;
    private float strokeWidth = 0.0f;
    private int strokeColor;

    public OutlineTextView(@NonNull Context context) {
        super(context);
    }

    public OutlineTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initView(context, attrs);
    }

    public OutlineTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs){
        TypedArray type = context.obtainStyledAttributes(attrs, R.styleable.OutlineTextView);

        //외곽선 유무
        stroke = type.getBoolean(R.styleable.OutlineTextView_textStroke, false);

        //외곽선 두께
        strokeWidth = type.getFloat(R.styleable.OutlineTextView_textStrokeWidth, 0.0f);

        //외곽선
        strokeColor = type.getColor(R.styleable.OutlineTextView_textStrokeColor, 0xffffffff);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (stroke){
            ColorStateList states = getTextColors();
            getPaint().setStyle(Paint.Style.STROKE);
            getPaint().setStrokeWidth(strokeWidth);
            setTextColor(strokeColor);
            super.onDraw(canvas);

            getPaint().setStyle(Paint.Style.FILL);
            setTextColor(states);
        }
        super.onDraw(canvas);
    }
}
