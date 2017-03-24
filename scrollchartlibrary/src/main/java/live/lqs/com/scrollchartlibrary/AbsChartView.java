package live.lqs.com.scrollchartlibrary;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/3/23.
 */

public class AbsChartView extends View {

    private int width;
    private int height;
    private Paint mPaint;

    private PorterDuffXfermode mXfermode;
    private PorterDuff.Mode mPorterDuffMode = PorterDuff.Mode.DST_OUT;

    private RectF srcRect;
    private RectF dstRect;

    public AbsChartView(Context context) {
        super(context);
    }

    public AbsChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (width == 0 || height == 0) {
            width = getWidth();
            height = getHeight();
            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG| Paint.FILTER_BITMAP_FLAG);
            mXfermode = new PorterDuffXfermode(mPorterDuffMode);

        }

        //背景色设为红色，方便比较效果
        canvas.drawColor(Color.RED);
        mPaint.setColor(Color.GREEN);
        canvas.drawRect(0,0,width,height/2,mPaint);
        //将绘制操作保存到新的图层
        mPaint.setColor(Color.WHITE);
        int saveCount = canvas.saveLayer(srcRect, mPaint, Canvas.ALL_SAVE_FLAG);
        //绘制目标图
        canvas.drawRect(dstRect,mPaint);
        //设置混合模式
        mPaint.setXfermode(mXfermode);
        //绘制源图
        mPaint.setColor(Color.BLUE);
//        canvas.drawLine(0,0,500,500,mPaint);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
//        Path p = new Path();
//        p.moveTo(0,500);
//        p.lineTo(10,400);
//        p.lineTo(20,370);
//        p.lineTo(100,200);
//        p.lineTo(200,300);
//        p.lineTo(300,500);
//        p.lineTo(400,100);
//        p.lineTo(500,500);
//        p.close();
//        canvas.drawPath(p,mPaint);


        LineChartDrawer chartDrawer = new LineChartDrawer();
        List<Map.Entry<String, Float>> list = new ArrayList<>();
        for(int i = 0; i < 20 ; i ++){
            list.add(new LineChartDrawer.DataEntry<String,Float>("X_" + 2*i,80f));
            list.add(new LineChartDrawer.DataEntry<String,Float>("X_" + (2*i +1),30f));
        }
        chartDrawer.setLineChartData(list);

        chartDrawer.onDrawChart(canvas,width,height,mPaint);

        //清除混合模式
        mPaint.setXfermode(null);
        //还原画布
        canvas.restoreToCount(saveCount);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.width = w;
        this.height = h;

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG| Paint.FILTER_BITMAP_FLAG);
        mXfermode = new PorterDuffXfermode(mPorterDuffMode);

        int width = w <= h ? w : h;
        int centerX = w/2;
        int centerY = h/2;
        int quarterWidth = width /2;
        srcRect = new RectF(centerX-quarterWidth, centerY-quarterWidth, centerX+quarterWidth, centerY+quarterWidth);
        dstRect = new RectF(centerX-quarterWidth, centerY-quarterWidth, centerX+quarterWidth, centerY+quarterWidth);
    }
}
