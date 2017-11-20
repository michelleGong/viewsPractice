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

public class Practice1ColorView extends View {


    public Practice1ColorView(Context context) {
        super(context);
    }

    public Practice1ColorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice1ColorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //draw a green rect
        Paint paint = new Paint();
        paint.setARGB(255,0,255,0);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawRect(50,50,150,150,paint);

        //cover the green rect using red color
        canvas.drawColor(Color.parseColor("#88880000"));

        canvas.drawRGB(255,0,255);
        canvas.drawARGB(80,0,255,255);
    }
}
