package demoview.duongkk.com.demoview;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import demoview.duongkk.com.demoview.fragment.Fragment2;
import demoview.duongkk.com.demoview.fragment.FragmentExample;
import demoview.duongkk.com.demoview.interfaces.IComunicateFragment;

public class ActivityDynamicFragment extends AppCompatActivity implements View.OnClickListener,IComunicateFragment{

    private Button btnAddA;
    private Button btnAddB;
    private Button btnRemoveA;
    private Button btnRemoveB;
    private Button btnReplaceAB;
    private Button btnReplaceBA;
    FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);
        findViewById(R.id.btn_add_a).setOnClickListener(this);
        findViewById(R.id.btn_add_b).setOnClickListener(this);
        findViewById(R.id.btn_remove_a).setOnClickListener(this);
        findViewById(R.id.btn_remove_b).setOnClickListener(this);
        findViewById(R.id.btn_replace_a).setOnClickListener(this);
        findViewById(R.id.btn_replace_b).setOnClickListener(this);
        manager= getSupportFragmentManager();



    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_add_a:{
                manager.beginTransaction().add(R.id.ll_hold,new FragmentExample(),"a").addToBackStack(null).commit()   ;
                break;
            }
            case R.id.btn_add_b:{
                manager.beginTransaction().add(R.id.ll_hold,new Fragment2(),"b").addToBackStack(null).commit();
                break;
            }
            case R.id.btn_remove_a:{
                manager.beginTransaction().remove(manager.findFragmentByTag("a")).addToBackStack(null).commit();
                break;
            }
            case R.id.btn_remove_b:{
                manager.beginTransaction().remove(manager.findFragmentByTag("b")).addToBackStack(null).commit();
                break;
            }
            case R.id.btn_replace_a:{
                manager.beginTransaction().replace(R.id.ll_hold,new FragmentExample(),"a").addToBackStack(null).commit();
                break;
            }
            case R.id.btn_replace_b:{
                manager.beginTransaction().replace(R.id.ll_hold,new Fragment2(),"b").addToBackStack(null).commit();
                break;
            }
        }
    }

    @Override
    public void respone(String txt) {

    }
}
