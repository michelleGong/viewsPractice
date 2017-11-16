package michelle.com.learningviews.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Michelle on 11/16/2017.
 *
 * @des
 */

public class Practice3Rect extends View {

    public Practice3Rect(Context context) {
        super(context);
    }

    public Practice3Rect(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice3Rect(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int viewWidth = getWidth();
        int viewHeight = getHeight();

        int width = 400;
        int left = viewWidth/2 - width/2;
        int top = viewHeight/2 - width/2;
        int right = viewWidth/2 + width/2;
        int bottom = viewHeight/2 + width/2;

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        Rect rect = new Rect(left,top,right,bottom);
        canvas.drawRect(rect,paint);

    }
}
