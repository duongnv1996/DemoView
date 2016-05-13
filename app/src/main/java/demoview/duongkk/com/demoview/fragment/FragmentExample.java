package demoview.duongkk.com.demoview.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import demoview.duongkk.com.demoview.R;
import demoview.duongkk.com.demoview.interfaces.IComunicateFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentExample extends Fragment implements View.OnClickListener{
    IComunicateFragment comunicateFragment;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
       // comunicateFragment=(IComunicateFragment) getActivity();
    }

    public FragmentExample() {
        // Required empty public constructor
    }


    private Button btn;
    int numberOfClick=0;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("numberOfClick",numberOfClick);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn=(Button)view.findViewById(R.id.button);
        btn.setOnClickListener(this);
        if(savedInstanceState!=null){
            numberOfClick=savedInstanceState.getInt("numberOfClick");
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.button:{
                numberOfClick++;
              //  comunicateFragment.respone(numberOfClick+"");
                break;
            }
        }
    }
}
