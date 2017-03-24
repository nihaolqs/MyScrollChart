package live.lqs.com.scrollchartlibrary;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by dell on 2017/3/24.
 */

public interface IChartDrawer {
    void onDrawChart(Canvas canvas, float width, float height, Paint paint);

}
