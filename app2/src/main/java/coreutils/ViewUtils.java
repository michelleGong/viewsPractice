package coreutils;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

public class ViewUtils {


    /**
     *
     * @param dpvalue
     * @param mContext  Activity 或者 Application 都可以，本API中的context不需要必须是Activity
     *
     * @return
     */
    public static final float dp2px(int dpvalue, Context mContext){
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dpvalue,mContext.getResources().getDisplayMetrics());
    }


    /**
     * dp转px
     * Resources.getSystem 返回Resources
     * @param dpvalue
     * @return
     */
    public static final float dp2px(int dpvalue){
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dpvalue, Resources.getSystem().getDisplayMetrics());
    }

}
