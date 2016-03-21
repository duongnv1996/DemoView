package demoview.duongkk.com.demoview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import demoview.duongkk.com.demoview.Models.Card;
import demoview.duongkk.com.demoview.R;
import demoview.duongkk.com.demoview.adapter.AdapterListView;

/**
 * Created by DuongKK on 3/18/2016.
 */
public class ListViewFragment extends Fragment implements View.OnClickListener{
    private Button mBtnAdd;
    private EditText mEdtName;
    private  EditText mEdtNum;
    private List<Card> mCards;
    private AdapterListView mAdapterListView;
    private ListView mListCard;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
    public void initView(View view){
        mBtnAdd = (Button)view.findViewById(R.id.btn_add);
        mEdtName=(EditText)view.findViewById(R.id.edt_name);
        mEdtNum=(EditText)view.findViewById(R.id.edt_number);
        mBtnAdd.setOnClickListener(this);
        mCards= new ArrayList<>();
        mAdapterListView= new AdapterListView(getContext(),mCards);
        mListCard=(ListView)view.findViewById(R.id.listview);
        mListCard.setAdapter(mAdapterListView);
        mListCard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "Click vao item", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listview,container,false);
        initView(view);
        return view;
    }

    @Override
    public void onClick(View v) {
        int id= v.getId();
        switch (id){
            case R.id.btn_add :{
                addToList();
            }
        }
    }

    private void addToList() {
        String name = mEdtName.getText().toString();
        String numbers = mEdtNum.getText().toString();

        if(!name.isEmpty() && !numbers.isEmpty() && mAdapterListView!=null){
            Card card= new Card(name,numbers);
            mCards.add(card);
            mAdapterListView.notifyDataSetChanged();
        }


    }
}
