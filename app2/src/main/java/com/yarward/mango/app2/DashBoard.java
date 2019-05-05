package com.yarward.mango.app2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import coreutils.ViewUtils;

/**
 * 仪表盘
 */
public class DashBoard extends View {
    Paint mPatient = new Paint(Paint.ANTI_ALIAS_FLAG);
    private static final float RADIUS = ViewUtils.dp2px(100);
    private static final float ANGLE = 120;
    private static final int DASH_WIDTH = 2;
    private static final int LENGTH= 100;
    Path dash = new Path();  //刻度
    Path path = new Path();  //弧度
    PathMeasure pathMeasure;
    PathDashPathEffect pathDashPathEffect;





    public DashBoard(Context context) {
        super(context);
    }

    public DashBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DashBoard(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // for 计算弧的长度
        path.addArc(getWidth()/2 - RADIUS,
                getHeight()/2 - RADIUS,
                getWidth()/2 + RADIUS,
                getHeight()/2 + RADIUS,
                90 + ANGLE/2,
                360 - ANGLE
                );
        pathMeasure = new PathMeasure(path,false);
        float lengthArc = pathMeasure.getLength(); //弧的长度



        if(pathDashPathEffect == null){
            //画20个刻度
            pathDashPathEffect = new PathDashPathEffect(dash,(lengthArc - DASH_WIDTH - 2)/19,0, PathDashPathEffect.Style.ROTATE);
        }
    }

    public DashBoard(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    {
        mPatient.setStyle(Paint.Style.STROKE);
        mPatient.setStrokeWidth(ViewUtils.dp2px(3));
        //画仪表盘的刻度
        dash.addRect(0,0,ViewUtils.dp2px(DASH_WIDTH),ViewUtils.dp2px(10), Path.Direction.CCW);
//        mPatient.setPathEffect(new PathDashPathEffect(dash,50,0, PathDashPathEffect.Style.ROTATE));
    }




    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //缺口120度,画原图形
        canvas.drawArc(getWidth()/2 - RADIUS,
                getHeight()/2 - RADIUS,
                getWidth()/2 + RADIUS,
                getHeight()/2 + RADIUS,
                90 + ANGLE/2,
                360 - ANGLE,
                false,  //扇形or 弧形
                mPatient);

        //画仪表盘的刻度
        dash.addRect(0,0,ViewUtils.dp2px(2),ViewUtils.dp2px(10), Path.Direction.CCW);
        mPatient.setPathEffect(pathDashPathEffect);
        // 画刻度
        canvas.drawArc(getWidth()/2 - RADIUS,
                getHeight()/2 - RADIUS,
                getWidth()/2 + RADIUS,
                getHeight()/2 + RADIUS,
                90 + ANGLE/2,
                360 - ANGLE,
                false,  //扇形or 弧形
                mPatient);
        mPatient.setPathEffect(null);

        canvas.drawLine(getWidth()/2,getHeight()/2,(float) (getWidth()/2 - Math.sin(ANGLE/2) * RADIUS),(float)( getHeight()/2 + Math.cos(ANGLE/2) * RADIUS),mPatient);

    }
}
