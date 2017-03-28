package live.lqs.com.scrollchartlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;

/**
 * Created by dell on 2017/3/23.
 */

public class ScrollChartLayout extends ViewGroup implements IScrollController, IAxisDrawer {

    private IScrollController mScroll = new BasicScrollController();
    private IAxisDrawer mAxisDrawer;
    private float mScrollX;
    private float mScrollY;
    private float mTouchX;
    private float mTouchY;
    private int mAxisColor;
    private float mAxisTextSize;
    private float mUnitHeight;
    private float mUnitWeidth;
    private int mMaxX;
    private int mMaxY;
    private ChartLayoutBasicStyleData mStyleData;
    //
//    public ScrollChartLayout(Context context) {
//        super(context);
//    }

    public ScrollChartLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ScrollChartLayout);
        mAxisColor = typedArray.getColor(R.styleable.ScrollChartLayout_AxisColor, 0x000000);
        mAxisTextSize = typedArray.getDimension(R.styleable.ScrollChartLayout_AxisTextSize, 15);
        mUnitHeight = typedArray.getDimension(R.styleable.ScrollChartLayout_UnitHeight,4);
        mUnitWeidth = typedArray.getDimension(R.styleable.ScrollChartLayout_UnitWeidth, 60);
        mMaxX = typedArray.getInt(R.styleable.ScrollChartLayout_MaxX, 5);
        mMaxY = typedArray.getInt(R.styleable.ScrollChartLayout_MaxY, 100);
        init();
    }

    private void init() {
        ChartLayoutBasicStyleData.Builder builder = new ChartLayoutBasicStyleData.Builder();
        Paint axisPaint = new Paint();
        axisPaint.setTextSize(mAxisTextSize);
        mStyleData = builder.setmMaxXValue(mMaxX)
                .setmMaxYValue(mMaxY)
                .setmPaddingButtom(getPaddingBottom())
                .setmPaddingLeft(getPaddingLeft())
                .setmPaddingTop(getPaddingTop())
                .setmPaddingRight(getPaddingRight())
                .setmUnitHeight(mUnitHeight)
                .setmUnitWeidth(mUnitWeidth)
                .setmXAxisPaint(axisPaint)
                .setmYAxisPaint(axisPaint)
                .build();

        DefaultAxisDrawer defaultAxisDrawer = new DefaultAxisDrawer();
        defaultAxisDrawer.setmStyleData(mStyleData);
        defaultAxisDrawer.s
        mAxisDrawer = defaultAxisDrawer;

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (mStyleData != null) {
            l = l + mStyleData.getmPaddingLeft();
            t = t + mStyleData.getmPaddingTop();
            r = r - mStyleData.getmPaddingRight();
            b = b - mStyleData.getmPaddingButtom();
        }
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).layout(l, t, r, b);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mAxisDrawer != null) {
            mAxisDrawer.DrawXAxis(canvas, mScrollX);
            mAxisDrawer.DrawYAxis(canvas, mScrollY);
        }
    }

    public boolean canScroll() {
        if (mStyleData != null) {
            return mStyleData.getmUnitWeidth() * mStyleData.getmMaxXValue() > getWidth();
        }
        return false;
    }

    @Override
    public void doScroll(ViewGroup vg, int x, int y) {
        if (mScroll != null) {
            mScroll.doScroll(vg, x, y);
        }
    }

    @Override
    public void DrawXAxis(Canvas canvas, float scrollX) {
        if (mAxisDrawer != null) {
            mAxisDrawer.DrawXAxis(canvas, scrollX);
        }
    }

    @Override
    public void DrawYAxis(Canvas canvas, float scrollY) {
        if (mAxisDrawer != null) {
            mAxisDrawer.DrawYAxis(canvas, scrollY);
        }
    }

    public void setmScroll(IScrollController mScroll) {
        this.mScroll = mScroll;
        invalidate();
    }

    public void setmAxisDrawer(IAxisDrawer mAxisDrawer) {
        this.mAxisDrawer = mAxisDrawer;
        invalidate();
    }

    public void setmStyleData(ChartLayoutBasicStyleData mStyleData) {
        this.mStyleData = mStyleData;
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                mTouchX = getX();
                mTouchY = getY();
            }
            break;

            case MotionEvent.ACTION_MOVE: {

                float x = getX();
                float y = getY();

                mScrollX += (x - mTouchX);
                mScrollY += (y - mTouchY);

                mTouchX = x;
                mTouchY = y;
            }
            break;
        }
        return super.onTouchEvent(event);
    }
}
