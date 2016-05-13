package demoview.duongkk.com.demoview.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import demoview.duongkk.com.demoview.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {
    String data;
   private TextView tv;
    public Fragment2() {
        // Required empty public constructor
    }

    public void getData(String txt){
        data=txt;
        tv.setText("So Lan Click =  " +txt);
    }


    // Luu data
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("data",data);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv=(TextView)view.findViewById(R.id.tv_fragment_2);
        if (savedInstanceState!=null){
            tv.setText("So lan click = "+savedInstanceState.getString("data"));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment2, container, false);
    }

}
