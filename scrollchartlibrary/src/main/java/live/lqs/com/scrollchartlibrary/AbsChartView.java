package live.lqs.com.scrollchartlibrary;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by dell on 2017/3/23.
 */

public class AbsChartView extends View{
    public AbsChartView(Context context) {
        super(context);
    }

    public AbsChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
