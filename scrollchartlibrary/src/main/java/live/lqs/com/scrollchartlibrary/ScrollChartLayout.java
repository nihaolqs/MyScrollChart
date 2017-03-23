package live.lqs.com.scrollchartlibrary;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by dell on 2017/3/23.
 */

public class ScrollChartLayout extends ViewGroup implements IScroll {

    private IScroll mScroll;


    public ScrollChartLayout(Context context) {
        super(context);
    }

    public ScrollChartLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).layout(l,t,r,b);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public boolean canScroll() {
        return false;
    }

    @Override
    public void doScroll(ViewGroup vg, int x, int y) {
        mScroll.doScroll(vg, x, y);
    }
}
