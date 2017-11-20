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

public class Practice8ArcView extends View {

    public Practice8ArcView(Context context) {
        super(context);
    }

    public Practice8ArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8ArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Practice8ArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        //顺时针为+ ,逆时针为 - （startAngle,sweepAngle）
        //弧形: useCenter false
        canvas.drawArc(100,100,800,500,-30,-120,false,paint);
        //扇形
        canvas.drawArc(100,100,800,500,60,60,true,paint);
        //弧线

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(100,100,800,500,10,50,false,paint);
        canvas.drawArc(100,100,800,500,120,50,false,paint);

    }
}
