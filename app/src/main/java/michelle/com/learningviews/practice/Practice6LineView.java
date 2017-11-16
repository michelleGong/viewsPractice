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

public class Practice6Line extends View {

    public Practice6Line(Context context) {
        super(context);
    }

    public Practice6Line(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice6Line(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Practice6Line(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setStrokeWidth(20);
        paint.setColor(Color.YELLOW);
        canvas.drawLine(10,10,300,300,paint);
    }
}
