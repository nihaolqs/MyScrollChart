package live.lqs.com.scrollchartlibrary;

import android.graphics.Canvas;

/**
 * Created by dell on 2017/3/23.
 */

public interface IAxisDrawer {
    void DrawXAxis(Canvas canvas, float scrollX);

    void DrawYAxis(Canvas canvas, float scrollY);
}
