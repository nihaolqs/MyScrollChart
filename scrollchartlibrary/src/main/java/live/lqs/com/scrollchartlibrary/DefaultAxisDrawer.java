package live.lqs.com.scrollchartlibrary;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.List;

/**
 * Created by dell on 2017/3/27.
 */

public class DefaultAxisDrawer implements IAxisDrawer {

    private ChartLayoutBasicStyleData mStyleData;   //基础数据样式封装类

    private List<DataEntry<String, Float>> mXAxisDataList;   //X轴数据列表

    private List<DataEntry<String, Float>> mYAxisDataList;  //Y轴数据列表

    private int mHeight;

    private int mWidth;

    private int mLineMargin = 0;

    @Override
    public void DrawXAxis(Canvas canvas, float scrollX) {
        initAxisDrawer(canvas);
        canvas.save();
        int paddingLeft = mStyleData.getmPaddingLeft();
        int paddingButtom = mStyleData.getmPaddingButtom();

        canvas.clipRect(paddingLeft, 0, mWidth - mStyleData.getmPaddingRight(), mHeight);  //画布裁剪
        canvas.translate(scrollX + paddingLeft, mHeight - paddingButtom);
        Paint xAxisPaint = mStyleData.getmXAxisPaint();
        float unitWeidth = mStyleData.getmUnitWeidth();
        canvas.drawLine(-mLineMargin-scrollX, mLineMargin, mStyleData.getmMaxXValue() * unitWeidth-mLineMargin -scrollX, mLineMargin, xAxisPaint);
        xAxisPaint.setTextAlign(Paint.Align.CENTER);
        for (DataEntry<String, Float> xAxisData : mXAxisDataList) {
            Float value = xAxisData.getValue();
            canvas.translate(value * unitWeidth, 0);
            canvas.drawText(xAxisData.getKey(), 0, (paddingButtom) / 2+mLineMargin, xAxisPaint);
            canvas.translate(-value * unitWeidth, 0);
        }
        canvas.restore();
    }

    @Override
    public void DrawYAxis(Canvas canvas, float scrollY) {
        initAxisDrawer(canvas);
        canvas.save();
        initAxisDrawer(canvas);
        Paint yAxisPaint = mStyleData.getmYAxisPaint();
        float maxYValue = mStyleData.getmMaxYValue();
        float unitHeight = mStyleData.getmUnitHeight();
        int paddingLeft = mStyleData.getmPaddingLeft();
        int paddingButtom = mStyleData.getmPaddingButtom();

        canvas.clipRect(0, mStyleData.getmPaddingTop(), mWidth, mHeight - paddingButtom);  ////画布裁剪
        canvas.translate(paddingLeft, mHeight + scrollY - paddingButtom);
        canvas.drawLine(-mLineMargin, mLineMargin-scrollY, -mLineMargin,mLineMargin-maxYValue * unitHeight - scrollY, yAxisPaint);
        yAxisPaint.setTextAlign(Paint.Align.RIGHT);
        for (DataEntry<String, Float> entry : mYAxisDataList) {
            Float value = entry.getValue();
            canvas.translate(0,-value * unitHeight);
            canvas.drawText(entry.getKey(), -mLineMargin, 0, yAxisPaint);
            canvas.translate(0,value * unitHeight);
        }
        canvas.restore();
    }


    private void initAxisDrawer(Canvas canvas) {
        if (mHeight == 0 || mWidth == 0) {
            mHeight = canvas.getHeight();
            mWidth = canvas.getWidth();
        }
    }

    public void setmStyleData(ChartLayoutBasicStyleData mStyleData) {
        this.mStyleData = mStyleData;
    }

    public void setmXAxisDataList(List<DataEntry<String, Float>> mXAxisDataList) {
        this.mXAxisDataList = mXAxisDataList;
    }

    public void setmYAxisDataList(List<DataEntry<String, Float>> mYAxisDataList) {
        this.mYAxisDataList = mYAxisDataList;
    }
}
