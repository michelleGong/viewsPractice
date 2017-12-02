package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Practice12MeasureTextView extends View {
    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text1 = "三个月内你胖了";
    String text2 = "4.5";
    String text3 = "公斤";

    private final String TAG = "MeasureText";

    public Practice12MeasureTextView(Context context) {
        super(context);
    }

    public Practice12MeasureTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12MeasureTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint1.setTextSize(60);
        paint2.setTextSize(120);
        paint2.setColor(Color.parseColor("#E91E63"));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.measureText 测量出文字宽度，让文字可以相邻绘制



        canvas.drawText(text1, 50, 200, paint1);

        Rect bound = new Rect();
        paint1.getTextBounds(text1,0,text1.length(),bound);

        Log.d(TAG,"bound ---top:"+bound.top+"  right:"+bound.right+"  bottom:"+bound.bottom+"   left:"+bound.left);

        float offset1 = paint1.measureText(text1);
        Log.d(TAG,"offset1---"+offset1+"");
        canvas.drawText(text2, 50 + offset1, 200, paint2);
        float offset2 = paint2.measureText(text2);
        Log.d(TAG,"offset2---"+offset2+"");
        canvas.drawText(text3, 50 + offset1 + offset2, 200, paint1);
    }
}
