package michelle.com.learningviews.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Michelle on 11/16/2017.
 *
 * @des
 */

public class Practice4PointView extends View {


    public Practice4PointView(Context context) {
        super(context);
    }

    public Practice4PointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice4PointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();

        //点的大小
        paint.setStrokeWidth(50);

        //点的形状 圆头
        paint.setStrokeCap(Paint.Cap.ROUND);

        canvas.drawPoint(100,100,paint);

        //平头
        paint.setStrokeCap(Paint.Cap.BUTT);

        canvas.drawPoint(100,200,paint);


        //方头
        paint.setStrokeCap(Paint.Cap.SQUARE);

        canvas.drawPoint(100,300,paint);



/*
        paint.setStrokeWidth(10);
        float[] points = {600,50,650,50,100,650,700,100};

        canvas.drawPoints(points,paint);*/


    }
}
