package live.lqs.com.scrollchartlibrary;

import android.view.ViewGroup;

/**
 * Created by dell on 2017/3/28.
 */

public class BasicScrollController implements IScrollController {
    @Override
    public void doScroll(ViewGroup vg, int x, int y) {
        int childCount = vg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            vg.getChildAt(i).scrollTo(x,y);
        }
    }
}
