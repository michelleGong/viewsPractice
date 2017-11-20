package michelle.com.learningviews.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Michelle on 11/16/2017.
 *
 * @des
 */

public class Practice2CricleView extends View {





    public Practice2CricleView(Context context) {
        super(context);
    }

    public Practice2CricleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2CricleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * practice the view's x and y Position
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // draw four circle in the center of the view
        // radius 300 ,margin between circle 100
        int radius = 150;
        int margin = 30;

        //1. the width and height of the view
        int w = getWidth();
        int h = getHeight();

        //计算圆心
        int radius_w_left = w/2 - radius - margin;
        int radius_w_right = w/2 + radius + margin;
        int radius_h_top = h/2 - radius - margin;
        int radius_h_bottom = h/2 + radius + margin;

        Paint paint = new Paint();

        //开启抗锯齿，开启文字图片边缘更平滑
        paint.setAntiAlias(true);

        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(radius_w_left,radius_h_top,radius,paint);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(radius_w_right,radius_h_top,radius,paint);

        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(radius_w_left,radius_h_bottom,radius,paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(50);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(radius_w_right,radius_h_bottom,radius,paint);

    }
}
