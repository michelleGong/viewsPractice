package michelle.com.learningviews.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Michelle on 11/16/2017.
 *
 * @des
 */

public class Practice9PathView extends View {

    Paint paint = new Paint();
    Path path = new Path();

    {
// 使用 path 对图形进行描述（这段描述代码不必看懂）
        path.addArc(200, 200, 400, 400, -225, 225);
        path.arcTo(400, 200, 600, 400, -180, 225, false);
        path.lineTo(400, 542);

    }

    public Practice9PathView(Context context) {
        super(context);
    }

    public Practice9PathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Practice9PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        paint.setStyle(Paint.Style.STROKE);

   /*     int w = getWidth();
        int r = 100;
        path.addArc((w/2-2*r),r,w/2,3*r,160,210);
        path.arcTo(w/2,r,w/2+2*r,3*r,180,235,true);
        path.lineTo(w/2,4*r+50);
//        path.close();*/


        canvas.drawPath(path,paint);
    }
}
