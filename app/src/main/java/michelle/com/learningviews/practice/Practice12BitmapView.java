package michelle.com.learningviews.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import michelle.com.learningviews.R;

/**
 * Created by Michelle on 11/16/2017.
 *
 *
 * has lots of thing to study
 * @des
 */

public class Practice12BitmapView extends View {



    public Practice12BitmapView(Context context) {
        super(context);
    }

    public Practice12BitmapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12BitmapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Practice12BitmapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        options.inJustDecodeBounds = true;

        Bitmap animal = ((BitmapDrawable)getResources().getDrawable(R.drawable.animal)).getBitmap();

        //------------null------
//        Bitmap animal = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.animal,options);
        if(animal == null){
            Log.e("BitMap","null--------");
        }
        canvas.drawBitmap(animal,100,100,paint);

    }
}
