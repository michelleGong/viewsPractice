package michelle.com.viewpractice_2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice12PathEffectView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();

    public Practice12PathEffectView(Context context) {
        super(context);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setStyle(Paint.Style.STROKE);

        path.moveTo(50, 100);
        path.rLineTo(50, 100);
        path.rLineTo(80, -150);
        path.rLineTo(100, 100);
        path.rLineTo(70, -120);
        path.rLineTo(150, 80);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        // 第一处：CornerPathEffect
        paint.setPathEffect(new CornerPathEffect(20));
        canvas.drawPath(path, paint);


        // 第二处：DiscretePathEffect
        paint.setPathEffect(new DiscretePathEffect(20,5));
        canvas.save();
        canvas.translate(500, 0);
        canvas.drawPath(path, paint);
        canvas.restore();


        // 第三处：DashPathEffect
        paint.setPathEffect(new DashPathEffect(new float[]{20,10,5,10},5));
        canvas.save();
        canvas.translate(0, 200);
        canvas.drawPath(path, paint);
        canvas.restore();


        // 第四处：PathDashPathEffect
        Path dashPath = new Path();
        dashPath.lineTo(20, -30);
        dashPath.lineTo(40, 0);
        dashPath.close();
        paint.setPathEffect(new PathDashPathEffect(dashPath,40,0, PathDashPathEffect.Style.TRANSLATE));
        canvas.save();
        canvas.translate(500, 200);
        canvas.drawPath(path, paint);
        canvas.restore();



        // 第五处：SumPathEffect
        PathEffect dashEffect = new DashPathEffect(new float[]{20, 10}, 0);
        PathEffect discreteEffect = new DiscretePathEffect(20, 5);
        paint.setPathEffect(new SumPathEffect(dashEffect,discreteEffect));
        canvas.save();
        canvas.translate(0, 400);
        canvas.drawPath(path, paint);
        canvas.restore();


        // 第六处：ComposePathEffect
        canvas.save();
        canvas.translate(500, 400);
        paint.setPathEffect(new ComposePathEffect(dashEffect,discreteEffect));
        canvas.drawPath(path, paint);
        canvas.restore();
    }
}
