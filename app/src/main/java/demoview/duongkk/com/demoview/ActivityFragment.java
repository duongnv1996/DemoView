package demoview.duongkk.com.demoview;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import demoview.duongkk.com.demoview.fragment.Fragment2;
import demoview.duongkk.com.demoview.interfaces.IComunicateFragment;

public class ActivityFragment extends AppCompatActivity implements IComunicateFragment {
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        fragmentManager=getSupportFragmentManager();
    }
    @Override
    public void respone(String txt) {
        Fragment2 fragmentExample = (Fragment2) fragmentManager.findFragmentById(R.id.fragment2);
        fragmentExample.getData(txt);
    }
}
