package demoview.duongkk.com.demoview.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import demoview.duongkk.com.demoview.fragment.ViewPagerFragment1;
import demoview.duongkk.com.demoview.fragment.ViewPageFragment2;
import demoview.duongkk.com.demoview.fragment.ViewPagerFragment3;

/**
 * Created by DuongKK on 4/22/2016.
 */
public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: {
                return "Page 1";

            }
            case 1: {
                return "Page 2";

            }
            case 2: {
                return "Page 3";

            }
        }
        return "Page";
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:{
                return new ViewPagerFragment1();

            }
            case 1:{
                return new ViewPageFragment2();

            }
            case 2:{
                return new ViewPagerFragment3();

            }
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
