package live.lqs.com.myscrollchart;

import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;

import java.util.ArrayList;

import live.lqs.com.scrollchartlibrary.DataEntry;
import live.lqs.com.scrollchartlibrary.ScrollChartLayout;

public class MainActivity extends AppCompatActivity {

    private ScrollChartLayout mScrollChartLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
//        for (int i = 0; i < 10; i++) {
//            RadioButton radioButton = new RadioButton(this);
//            radioButton.setText("test");
////radioButton.setButtonDrawable(R.mipmap.ic_launcher);
//            radioGroup.addView(radioButton, LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
//        }
//
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
//
//            }
//        });
//        ScrollView

        mScrollChartLayout = (ScrollChartLayout) findViewById(R.id.scroll_chart_layout);
        ArrayList<DataEntry<String, Float>> xAxisDataList = new ArrayList<>();
        ArrayList<DataEntry<String, Float>> yAxisDataList = new ArrayList<>();
        for(int i = 0; i < 10; i ++){
            xAxisDataList.add(new DataEntry<String, Float>("X" + i,Float.valueOf(i)));
            yAxisDataList.add(new DataEntry<String, Float>("Y" + i*10,Float.valueOf(i*10)));
        }
        mScrollChartLayout.setmXAxisDataList(xAxisDataList);
        mScrollChartLayout.setmYAxisDataList(yAxisDataList);
    }
}
