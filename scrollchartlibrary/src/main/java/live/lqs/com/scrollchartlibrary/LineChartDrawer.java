package live.lqs.com.scrollchartlibrary;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/3/24.
 */

public class LineChartDrawer implements IChartDrawer {

    private List<Map.Entry<String, Float>> mDataList;
    private float mUnitWeidth;     //单位宽度
    private float mMaxValue = 100;  // 最大值
    private float mUnitHeight;  //单位高度
    private Path path = new Path();

    @Override
    public void onDrawChart(Canvas canvas, float width, float height, Paint paint) {

        if (mDataList != null || mDataList.size() != 0) {
//            mUnitWeidth = width / mDataList.size();
            mUnitWeidth = 30;
            mUnitHeight = -height / mMaxValue;
            canvas.translate(0, height);
            path.reset();
            path.moveTo(0, mUnitHeight * mDataList.get(0).getValue());
            for (int i = 1; i < mDataList.size(); i++) {
                path.lineTo(i * mUnitWeidth, mUnitHeight * (mDataList.get(i).getValue()));
            }

            canvas.drawPath(path, paint);
        }
    }


    public void setLineChartData(List<Map.Entry<String, Float>> list) {
        this.mDataList = list;
    }


}
