package michelle.com.viewpractice_2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import michelle.com.viewpractice_2.R;

public class Practice14MaskFilterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    public Practice14MaskFilterView(Context context) {
        super(context);
    }

    public Practice14MaskFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice14MaskFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.what_the_fuck);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 用 Paint.setMaskFilter 来设置不同的 BlurMaskFilter

        BlurMaskFilter blurMaskFilter1 = new BlurMaskFilter(50, BlurMaskFilter.Blur.NORMAL);
        BlurMaskFilter blurMaskFilter2 = new BlurMaskFilter(50, BlurMaskFilter.Blur.INNER);
        BlurMaskFilter blurMaskFilter3 = new BlurMaskFilter(50, BlurMaskFilter.Blur.OUTER);
        BlurMaskFilter blurMaskFilter4 = new BlurMaskFilter(50, BlurMaskFilter.Blur.SOLID);


        // 第一个：NORMAL
        paint.setMaskFilter(blurMaskFilter1);
        canvas.drawBitmap(bitmap, 100, 50, paint);

        // 第二个：INNER
        paint.setMaskFilter(blurMaskFilter2);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 200, 50, paint);

        // 第三个：OUTER
        paint.setMaskFilter(blurMaskFilter3);
        canvas.drawBitmap(bitmap, 100, bitmap.getHeight() + 100, paint);

        // 第四个：SOLID
        paint.setMaskFilter(blurMaskFilter4);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 200, bitmap.getHeight() + 100, paint);
    }
}
