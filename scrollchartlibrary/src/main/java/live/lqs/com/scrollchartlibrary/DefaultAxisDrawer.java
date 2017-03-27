package live.lqs.com.scrollchartlibrary;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.Collections;
import java.util.List;

/**
 * Created by dell on 2017/3/27.
 */

public class DefaultAxisDrawer implements IAxisDrawer {

    private float mMaxYValue = 100;    //Y轴最大值

    private int mMaxXValue = 0;    //X轴最大值

    private float mUnitWeidth;     //单位宽度

    private float mUnitHeight;  //单位高度

    private int mPaddingLeft;   //图标左间距

    private int mPaddingButtom;  //图标下边距

    private int mPaddingRight;   //图标右间距

    private int mPaddingTop;  //图标上边距

    private Paint mXAxisPaint;  //X轴画笔

    private Paint mYAxisPaint;  //Y轴画笔

    private List<DataEntry<String, Float>> mXAxisDataList;   //X轴数据列表

    private List<DataEntry<String, Float>> mYAxisDataList;  //Y轴数据列表

    private int mHeight;

    private int mWidth;

    @Override
    public void DrawXAxis(Canvas canvas, float scrollX) {
        initAxisDrawer(canvas);
        canvas.save();
        canvas.translate(scrollX + mPaddingLeft, mHeight - mPaddingButtom);
        canvas.drawLine(0,0,mMaxXValue,0,mXAxisPaint);
        for (DataEntry<String, Float> xAxisData : mXAxisDataList) {
            mXAxisPaint.setTextAlign(Paint.Align.CENTER);
            canvas.translate(xAxisData.getValue(),0);
            canvas.drawText(xAxisData.getKey(),0,mPaddingButtom/2,mXAxisPaint);
        }

        canvas.restore();
    }

    @Override
    public void DrawYAxis(Canvas canvas, float scrollY) {
        initAxisDrawer(canvas);
        canvas.save();


        canvas.restore();
    }


    private void initAxisDrawer(Canvas canvas) {
        if (mHeight == 0 || mWidth == 0) {
            mHeight = canvas.getHeight();
            mWidth = canvas.getWidth();
        }
    }
}
