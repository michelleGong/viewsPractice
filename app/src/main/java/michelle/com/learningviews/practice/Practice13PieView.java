package michelle.com.learningviews.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michelle on 11/16/2017.
 * 文字描述 算法不精确
 * @des
 */

public class Practice13PieView extends View {


    List<PieItem> pieItems;

    //划线，斜线部分的长度
    int lineOffset = 50;
    //划线，水平部分的长度
    int lineLandscape = 70;

    public final String[] defaultColorBox = {"#66CCCC", "#CCFF66", "#FF99CC", "#FF9999", "#FFFFFF",
            "#FFCC99", "#666699", "#FFCC00", "#993366"};

    {
        pieItems = new ArrayList<>();
        try {
           pieItems.add(new PieItem(Color.parseColor(defaultColorBox[0]), 30, "Adfg",true));
            pieItems.add(new PieItem(Color.parseColor(defaultColorBox[1]), 10, "Bgf"));
            pieItems.add(new PieItem(Color.parseColor(defaultColorBox[2]), 15, "Cfgs"));
            pieItems.add(new PieItem(Color.parseColor(defaultColorBox[3]), 15, "Ddfg"));
            pieItems.add(new PieItem(Color.parseColor(defaultColorBox[4]), 20, "Esdg"));
            pieItems.add(new PieItem(Color.parseColor(defaultColorBox[5]), 5, "Ffgfgs"));
            pieItems.add(new PieItem(Color.parseColor(defaultColorBox[6]), 5, "G4gdf"));
       /*     pieItems.add(new PieItem(Color.parseColor(defaultColorBox[0]), 25, "Adfadf"));
            pieItems.add(new PieItem(Color.parseColor(defaultColorBox[1]), 25, "Bssfdfe"));
            pieItems.add(new PieItem(Color.parseColor(defaultColorBox[2]), 25, "Csssef"));
            pieItems.add(new PieItem(Color.parseColor(defaultColorBox[3]), 25, "Dsfegg"));*/

//            pieItems.add(new PieItem(Color.parseColor(defaultColorBox[4]),15,"E"));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void setPieItems(List<PieItem> pieItems) throws Exception {
        int sum = 0;
        for (PieItem item : pieItems) {
            sum += item.percentage;
        }
        if (sum != 100) {
            throw new Exception("the data for the pie is inCorrent,please check if the sum of the item's percentage is 100");
        }
        this.pieItems = pieItems;
    }

    public Practice13PieView(Context context) {
        super(context);
    }

    public Practice13PieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice13PieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Practice13PieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int viewWidth = getWidth();
        int viewHeight = getHeight();
        int radius = viewWidth > viewHeight ? viewHeight / 2 - 40 : viewWidth / 2 - 40;

        int cx = viewWidth / 2;
        int cy = viewHeight / 2;


        //从180开始画扇形，已经划过的角度，
        // 选中的圆心 和 指线
        // <90时，左上（x-  y-;
        // >90 && <180 右上 （x+ y-）;
        // >180 && < 270  右下 （x+, y+）;
        // >270 && < 360  左下 （x- y+）
        int allSweepedAngle = 0;
        int startAngle = 180;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        Rect rect = new Rect(cx - radius, cy - radius,
                cx + radius, cy + radius);
        RectF rectF = new RectF(rect);

        //for selected
        int selectedStartAngele = 0;
        int selectedSweepAngle = 0;
        PieItem selectedItem = null;
        for (PieItem item : pieItems) {

            paint.setColor(item.itemColor);
            int currentSweepAngle = (int) (item.percentage * 360 / 100);
            Log.d("debug", "item.percentage:" + item.percentage + "    currentSweepAngle:" + currentSweepAngle + " startAngel :" + startAngle + "  allSweep:" + allSweepedAngle);
            if (item.isCurrent) {
                selectedStartAngele = startAngle;
                selectedSweepAngle = currentSweepAngle;
                selectedItem = item;


            } else {
                canvas.drawArc(rectF, startAngle, currentSweepAngle, true, paint);
                //中线角度
                double midcourtLine = startAngle + currentSweepAngle/2;
                drawDiscription(radius,cx,cy,canvas,paint,midcourtLine,item.discrib);
            }
            startAngle += currentSweepAngle;
            allSweepedAngle += currentSweepAngle;

        }

        if(selectedItem == null){
            return;
        }
        // -----draw the select arc-----
        //扇形角度的中线
        double selectedMidCourtLine = selectedStartAngele + selectedSweepAngle / 2;
        Log.d("******", "selectedStart :" + selectedStartAngele + "  selectedSweepAngle:" + selectedSweepAngle + "******"
                + Math.tan(Math.toRadians(225.0)) + "  " + Math.tan(Math.toRadians(315.0)) + "  " + Math.tan(Math.toRadians(405.0)) + "  " + Math.tan(Math.toRadians(495.0)));
        //左上 tan +  左下 tan -  右上 tan -  右下 tan+
        Log.d("******", "translateSweep :" + selectedMidCourtLine + "  tan:" + Math.tan(Math.toRadians(selectedMidCourtLine)) + "******");
        //计算弧度
//        double hudu = Math.PI * 2.0 * translateSweep/360.0;

        //计算正切，对边比临边，即y/x
        int y1 = Math.abs((int) ctan(selectedMidCourtLine) * 20);
        int x1 = 1 * 20;
        Log.d("****", y1 + "   " + x1);

        //平移画布，注意中线在不同象限，平移的方向不一样
        if (selectedMidCourtLine - 180 > 0 && selectedMidCourtLine - 180 < 90) {
            Log.d("*****", "1111111111111");
            canvas.translate(-x1, -y1);
        } else if (selectedMidCourtLine - 180 > 90 && selectedMidCourtLine - 180 < 180) {
            Log.d("*****", "2222222222222");
            canvas.translate(x1, -y1);
        } else if (selectedMidCourtLine - 180 > 180 && selectedMidCourtLine - 180 < 270) {
            Log.d("*****", "3333333333333");
            canvas.translate(x1, y1);
        } else if (selectedMidCourtLine - 180 > 270 && selectedMidCourtLine - 180 < 360) {
            Log.d("*****", "4444444444444");
            canvas.translate(-x1, y1);
        }
        paint.setColor(selectedItem.itemColor);
        canvas.drawArc(rectF, selectedStartAngele, selectedSweepAngle, true, paint);
        drawDiscription(radius,cx,cy,canvas,paint,selectedMidCourtLine,selectedItem.discrib);
        //---------------------draw selected arc-------

    }



    private void drawDiscription(int radius, int cx, int cy, Canvas canvas, Paint paint, double midcourtLine,String dispStr){

        // 这里的参数300，表示字符串的长度，当满300时，就会换行，也可以使用“\r\n”来实现换行
        //--- 画线------
        paint.setStrokeWidth(2);
        paint.setColor(Color.BLACK);
        paint.setTextSize(28);
        int[] startLine1 = cMethod(radius,midcourtLine);
        int[] endLine1 = cMethod(radius+lineOffset,midcourtLine);
        if (midcourtLine - 180 > 0 && midcourtLine - 180 < 90) {
            Log.d("###", "1111111111111");
            canvas.drawLine(cx-startLine1[0],cy-startLine1[1],cx-endLine1[0],cy-endLine1[1],paint);
            canvas.drawLine(cx-endLine1[0],cy-endLine1[1],cx-endLine1[0]-lineLandscape,cy-endLine1[1],paint);
        } else if (midcourtLine - 180 > 90 && midcourtLine - 180 < 180) {
            Log.d("###", "2222222222222");

            canvas.drawLine(cx+startLine1[0],cy-startLine1[1],cx+endLine1[0],cy-endLine1[1],paint);
            canvas.drawLine(cx+endLine1[0],cy-endLine1[1],cx+endLine1[0]+lineLandscape,cy-endLine1[1],paint);
            canvas.drawText(dispStr,cx+endLine1[0]+lineLandscape+8,cy-endLine1[1],paint);
        } else if (midcourtLine - 180 > 180 && midcourtLine - 180 < 270) {
            Log.d("###", "3333333333333");
            canvas.drawLine(cx+startLine1[0],cy+startLine1[1],cx+endLine1[0],cy+endLine1[1],paint);
            canvas.drawLine(cx+endLine1[0],cy+endLine1[1],cx+endLine1[0]+lineLandscape,cy+endLine1[1],paint);
            canvas.drawText(dispStr,cx+endLine1[0]+lineLandscape+8,cy+endLine1[1],paint);
        } else if (midcourtLine - 180 > 270 && midcourtLine - 180 < 360) {
            Log.d("###", "4444444444444");
            canvas.drawLine(cx-startLine1[0],cy+startLine1[1],cx-endLine1[0],cy+endLine1[1],paint);
            canvas.drawLine(cx-endLine1[0],cy+endLine1[1],cx-endLine1[0]-lineLandscape,cy+endLine1[1],paint);
        }

    }

    /**
     * 求角的正切，四舍五入。
     * @param angleNumber
     * @return
     */
    private long ctan(double angleNumber){
        return Math.round(Math.tan(Math.toRadians(angleNumber)));
    }


    /**
     * 计算二元二次方程组
     * y2 + x2 = r2
     * tan@ = y/x
     *
     * 返回 x， y 数组
     */
    private int[] cMethod(int radius,double angleNumber){


       double tan =  ctan(angleNumber);

       double powr = Math.pow(radius,2);

       double m = 1 + Math.pow(tan,2);

       double r = powr/m;

       int x = (int) Math.sqrt(r);

       int y = (int) tan * x;

       Log.d("###",x+"   "+y);
        //注意y要取正值
       return new int[]{Math.abs(x),Math.abs(y)};

    }

    class PieItem {
        int itemColor;
        double percentage;
        String discrib;
        boolean isCurrent = false;

        public PieItem(int itemColor, double percentage, String discrib) throws Exception {
            this.itemColor = itemColor;

            if (percentage < 0 || percentage > 100) {
                throw new Exception("Pie item percentage should between 0 and 100");
            }

            this.percentage = percentage;
            this.discrib = discrib;
        }

        public PieItem(int itemColor, double percentage, String discrib, boolean isCurrent) throws Exception {
            this.itemColor = itemColor;
            if (percentage < 0 || percentage > 100) {

                throw new Exception("Pie item percentage should between 0 and 100");
            }
            this.percentage = percentage;
            this.discrib = discrib;
            this.isCurrent = isCurrent;
        }
    }


}
