package live.lqs.com.scrollchartlibrary;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dell on 2017/3/28.
 */

public class BasicScrollController implements IScrollController {
    @Override
    public void doScroll(ViewGroup vg, float x, float y) {
        int childCount = vg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = vg.getChildAt(i);
//            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
//            int height = layoutParams.height;
//            int width = layoutParams.width;
//            float cx = childAt.getX();
//            float cy = childAt.getY();
//            int cWidth = childAt.getWidth();
//            int cHeight = childAt.getHeight();
////            if (cx + cWidth > width ) {
//            childAt.setX(x);
//            childAt.setY(y);

//            childAt.scrollTo((int)x,(int)y);

            childAt.scrollTo((int)x,(int)y);
//            if(childAt instanceof IScrollChart){
//                IScrollChart chart = (IScrollChart) childAt;
//                chart.scrollChartX(x);
//                chart.scrollChartY(y);
//            }
        }
    }
}
