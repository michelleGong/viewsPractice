package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice12CameraRotateFixedView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 100);
    Point point2 = new Point(600, 100);

    public Practice12CameraRotateFixedView(Context context) {
        super(context);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Camera camera = new Camera();
        Matrix matrix = new Matrix();



        canvas.save();
        camera.save();
        camera.rotateX(30);
        //将三维的camera整合到二维的matrix中
        camera.getMatrix(matrix);
        matrix.preTranslate(-(point1.x + bitmap.getWidth()/2),-(point1.y + bitmap.getHeight()/2));
        matrix.postTranslate(point1.x + bitmap.getWidth()/2,point1.y + bitmap.getHeight()/2);
        camera.restore();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();


        matrix.reset();
        canvas.save();
        camera.save();
        camera.rotateY(25);
        camera.getMatrix(matrix);
        matrix.preTranslate(-(point2.x + bitmap.getWidth()/2),-(point2.y + bitmap.getHeight()/2));
        matrix.postTranslate(point2.x + bitmap.getWidth()/2,point2.y + bitmap.getHeight()/2);
        camera.restore();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
