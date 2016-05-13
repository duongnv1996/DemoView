package demoview.duongkk.com.demoview.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import demoview.duongkk.com.demoview.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPagerFragment1 extends Fragment {


    public ViewPagerFragment1() {
        // Required empty public constructor
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("onDestroy","onDestroy");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("onStop","onStop");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("onStart","onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("onResume","onResume");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_page1, container, false);
    }

}
