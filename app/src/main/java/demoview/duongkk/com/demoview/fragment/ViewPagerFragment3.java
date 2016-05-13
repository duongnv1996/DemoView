package demoview.duongkk.com.demoview.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import demoview.duongkk.com.demoview.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPagerFragment3 extends Fragment {


    public ViewPagerFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_pager2, container, false);
    }

}
