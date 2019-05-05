package com.yarward.viewpractice_a10;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DebugUtils;
import android.util.Log;
import android.view.View;

/**
 * @author MichelleHong
 * @version 1.0 created in learningViews
 * @des
 * @Date 2018/6/12
 */

public class ServiceStarLevelView extends View {

    private final String TAG = "ServiceStarLevelView";
    private Context mContext;
    private float starsCount;
    private Bitmap bitmap_bg;
    private Bitmap bitmap_star_full;
    private Bitmap bitmap_star_half;
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public ServiceStarLevelView(Context context) {
        this(context,null);
    }

    public ServiceStarLevelView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ServiceStarLevelView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        setAttributes(attrs);
    }
    {
        bitmap_bg = BitmapFactory.decodeResource(getResources(),R.mipmap.bg_star_level);
        bitmap_star_full = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_fullstar_white);
        bitmap_star_half = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_halfstar_white);
    }


    public void setStars(float stars){
        this.starsCount = stars;
        invalidate();
    }

    private void setAttributes(AttributeSet attributes){
        TypedArray mArray = mContext.obtainStyledAttributes(attributes,R.styleable.servicestarlevel);
        starsCount = mArray.getFloat(R.styleable.servicestarlevel_stars,0);
        mArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        Log.i(TAG, "view :  "+ width+"  *  "+height);
        int bg_width = bitmap_bg.getWidth();
        int bg_height = bitmap_bg.getHeight();
        Log.i(TAG, "bg :  "+ bg_width+"  *  "+bg_height);
        float sacleX = Math.round((float) width/(float) bg_width);
        float sacleY = Math.round((float) height/(float) bg_height);
        Log.i(TAG, "sacle :  "+ sacleX+"  *  "+sacleY);


//        Matrix matrix = new Matrix();
        canvas.save();
//        matrix.postScale(sacleX,sacleY);
//        canvas.concat(matrix);
        canvas.drawBitmap(bitmap_bg,0,0,mPaint);
//        matrix.reset();
        canvas.restore();

        int fullCount = (int)Math.floor(starsCount);
        int halfCount = (int)Math.ceil(starsCount - fullCount);

        Log.i(TAG,fullCount + "    "+ halfCount);
        int spaceWidth = MetricsUtils.dp2px(mContext,6);

        int starHeight = bitmap_star_full.getHeight();
        int starWidth = bitmap_star_full.getWidth();

        int paddingTop = (height - starHeight)/2;

        canvas.save();
        canvas.rotate(-11.0f,0,paddingTop);
        for(int i = 1 ; i <= fullCount ; i++){

//            starWidth = (int) (starWidth * (sacleY > sacleX ? sacleX : sacleY));
            int x = spaceWidth * i + starWidth *(i -1);
//            matrix.postScale(sacleY > sacleX ? sacleX : sacleY,sacleY > sacleX ? sacleX : sacleY,x + starWidth/2,paddingTop + starHeight/2);
//            canvas.concat(matrix);
            canvas.drawBitmap(bitmap_star_full,x,paddingTop,mPaint);
//            matrix.reset();
        }


        if(halfCount == 1){
            int x = spaceWidth * (fullCount + 1) + starWidth * fullCount;
            canvas.drawBitmap(bitmap_star_half,x,paddingTop,mPaint);
        }


        canvas.restore();





    }
}
