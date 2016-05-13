package demoview.duongkk.com.demoview;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import demoview.duongkk.com.demoview.adapter.PagerAdapter;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager  mViewPager;
    private TabLayout mTabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        mViewPager= (ViewPager)findViewById(R.id.viewpager);
        mViewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        mTabLayout=(TabLayout)findViewById(R.id.tab);
        mTabLayout.setupWithViewPager(mViewPager);

    }
}
