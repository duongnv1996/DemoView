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
public class ViewPageFragment2 extends Fragment {


    public ViewPageFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_page, container, false);
    }

}
