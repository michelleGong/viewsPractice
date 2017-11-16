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

public class Practice7RoundRect extends View {

    public Practice7RoundRect(Context context) {
        super(context);
    }

    public Practice7RoundRect(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice7RoundRect(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Practice7RoundRect(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        //5，6参数为圆角的横向半径和纵向半径

        canvas.drawRoundRect(100,100,800,500,50,50,paint);
    }
}
