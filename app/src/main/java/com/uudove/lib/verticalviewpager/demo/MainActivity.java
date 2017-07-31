package com.uudove.lib.verticalviewpager.demo;

import android.app.Activity;
import android.os.Bundle;

import com.uudove.lib.verticalviewpager.VerticalViewPager;

public class MainActivity extends Activity {
    private VerticalViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (VerticalViewPager) findViewById(R.id.view_pager);
        initView();
    }

    private void initView() {
        DemoPagerAdapter adapter = new DemoPagerAdapter();
        mViewPager.setAdapter(adapter);
    }
}
