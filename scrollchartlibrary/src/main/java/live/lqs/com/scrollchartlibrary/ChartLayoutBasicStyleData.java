package live.lqs.com.scrollchartlibrary;

import android.graphics.Paint;

/**
 * Created by dell on 2017/3/27.
 */

public class ChartLayoutBasicStyleData {

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

    private ChartLayoutBasicStyleData() {
    }

    public float getmMaxYValue() {
        return mMaxYValue;
    }

    public int getmMaxXValue() {
        return mMaxXValue;
    }

    public float getmUnitWeidth() {
        return mUnitWeidth;
    }

    public float getmUnitHeight() {
        return mUnitHeight;
    }

    public int getmPaddingLeft() {
        return mPaddingLeft;
    }

    public int getmPaddingButtom() {
        return mPaddingButtom;
    }

    public int getmPaddingRight() {
        return mPaddingRight;
    }

    public int getmPaddingTop() {
        return mPaddingTop;
    }

    public Paint getmXAxisPaint() {
        return mXAxisPaint;
    }

    public Paint getmYAxisPaint() {
        return mYAxisPaint;
    }

    public static class Builder {
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

        public Builder setmMaxYValue(float mMaxYValue) {
            if (mMaxYValue <= 0) {
                throw new IllegalArgumentException("最大值不能为负数");
            }
            this.mMaxYValue = mMaxYValue;
            return this;
        }

        public Builder setmMaxXValue(int mMaxXValue) {
            if (mMaxXValue <= 0) {
                throw new IllegalArgumentException("最大值不能为负数");
            }
            this.mMaxXValue = mMaxXValue;
            return this;
        }

        public Builder setmUnitWeidth(float mUnitWeidth) {
            if (mUnitWeidth <= 0) {
                throw new IllegalArgumentException("单位宽度不能为负数");
            }
            this.mUnitWeidth = mUnitWeidth;
            return this;
        }

        public Builder setmUnitHeight(float mUnitHeight) {
            if (mUnitHeight <= 0) {
                throw new IllegalArgumentException("单位高度不能为负数");
            }
            this.mUnitHeight = mUnitHeight;
            return this;
        }

        public Builder setmPaddingLeft(int mPaddingLeft) {
            if (mPaddingLeft <= 0) {
                throw new IllegalArgumentException("PaddingLeft不能为负数");
            }
            this.mPaddingLeft = mPaddingLeft;
            return this;
        }

        public Builder setmPaddingButtom(int mPaddingButtom) {
            if (mPaddingButtom <= 0) {
                throw new IllegalArgumentException("mPaddingButtom不能为负数");
            }
            this.mPaddingButtom = mPaddingButtom;
            return this;
        }

        public Builder setmPaddingRight(int mPaddingRight) {
            if (mPaddingRight <= 0) {
                throw new IllegalArgumentException("mPaddingRight不能为负数");
            }
            this.mPaddingRight = mPaddingRight;
            return this;
        }

        public Builder setmPaddingTop(int mPaddingTop) {
            if (mPaddingTop <= 0) {
                throw new IllegalArgumentException("mPaddingTop不能为负数");
            }
            this.mPaddingTop = mPaddingTop;
            return this;
        }

        public Builder setmXAxisPaint(Paint mXAxisPaint) {
            if (mXAxisPaint == null) {
                throw new NullPointerException("mXAxisPaint不能为空");
            }
            this.mXAxisPaint = mXAxisPaint;
            return this;
        }

        public Builder setmYAxisPaint(Paint mYAxisPaint) {
            if (mYAxisPaint == null) {
                throw new NullPointerException("mYAxisPaint不能为空");
            }
            this.mYAxisPaint = mYAxisPaint;
            return this;
        }

        public ChartLayoutBasicStyleData build() {
            ChartLayoutBasicStyleData data = new ChartLayoutBasicStyleData();
            data.mMaxYValue = this.mMaxYValue;
            data.mMaxXValue = this.mMaxXValue;
            data.mUnitWeidth = this.mUnitWeidth;
            data.mUnitHeight = this.mUnitHeight;
            data.mPaddingLeft = this.mPaddingLeft;
            data.mPaddingButtom = this.mPaddingButtom;
            data.mPaddingRight = this.mPaddingRight;
            data.mPaddingTop = this.mPaddingTop;
            data.mXAxisPaint = this.mXAxisPaint;
            data.mYAxisPaint = this.mYAxisPaint;
            return data;
        }
    }

}
