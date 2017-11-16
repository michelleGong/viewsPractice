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

public class Practice5Oval extends View {

    public Practice5Oval(Context context) {
        super(context);
    }

    public Practice5Oval(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice5Oval(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawOval(100,100,500,200,paint);
    }
}
