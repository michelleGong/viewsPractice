package com.yarward.mango.app2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.TypedValue;
import android.view.View;

import coreutils.ViewUtils;

public class TestView extends View {

    Paint mPatient = new Paint(Paint.ANTI_ALIAS_FLAG);
    private static final float RADIUS = ViewUtils.dp2px(100);

    Path path = new Path();
    PathMeasure pathMeasure;

    public TestView(Context context) {
        super(context);
    }

    /**
     * 测量之后，如果和上次测量结果不一样，会回调这个方法
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //clockwise  couter-Clockwise 顺时针  逆时针
        path.addCircle(getWidth()/2,getHeight()/2,RADIUS, Path.Direction.CW);
        path.addRect(getWidth()/2-RADIUS,(float) getHeight()/2,
                getWidth()/2 + RADIUS,getHeight()/2 + RADIUS * 2,
                Path.Direction.CW);
        // winding 蜿蜒  方向，结果的是否为0 判断内部外部，
        // even-odd  不管方向，交点数的奇偶数 判断内部外部，
        //填充类型
        path.setFillType(Path.FillType.WINDING);


        pathMeasure = new PathMeasure(path,false);
        pathMeasure.getLength();// 路径的长度

    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawCircle((float) getWidth()/2,(float) getHeight()/2,
//                ViewUtils.dp2px(150),mPatient);


        canvas.drawPath(path,mPatient);

    }
}
