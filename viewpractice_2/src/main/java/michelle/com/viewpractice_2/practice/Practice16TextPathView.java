package michelle.com.viewpractice_2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice16TextPathView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint pathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path textPath = new Path();
    String text = "Hello HenCoder";

    public Practice16TextPathView(Context context) {
        super(context);
    }

    public Practice16TextPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice16TextPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setTextSize(120);

        // 使用 Paint.getTextPath() 来获取文字的 Path

        pathPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText(text, 50, 200, paint);
      /*  paint.getTextPath(text,0,text.length(),50,400,textPath);

        canvas.drawPath(textPath, pathPaint);*/



        paint.getTextPath(text,0,text.length(),50,500,textPath);


        canvas.drawPath(textPath,pathPaint);

        Path underline = new Path();

        textPath.op(underline, Path.Op.INTERSECT);

        pathPaint.setColor(Color.RED);
//        canvas.drawPath(underline,pathPaint);


        Paint mStroke = new Paint();
        mStroke.setStyle(Paint.Style.FILL_AND_STROKE);
        mStroke.setStrokeWidth(10);

        Path strokedOutline = new Path();
        mStroke.getFillPath(textPath, strokedOutline);

        underline.op(strokedOutline, Path.Op.DIFFERENCE);

        canvas.drawPath(underline,pathPaint);



    }
}
