package demoview.duongkk.com.demoview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import demoview.duongkk.com.demoview.Models.Student;
import demoview.duongkk.com.demoview.R;
import demoview.duongkk.com.demoview.adapter.AdapterRecyclerview;
import demoview.duongkk.com.demoview.interfaces.OnClickItem;

/**
 * Created by DuongKK on 3/21/2016.
 */
public class RecyclerviewFragment extends Fragment implements View.OnClickListener,OnClickItem{
    private EditText mEdtName;
    private EditText mEdtMsv;
    private EditText mEdtClass;
    private EditText mEdtBirth;
    private Button mBtnAdd;
    private Button mBtnUpdate;
    private Button mBtnDelete;
    private RecyclerView mRecyclerview;
    private AdapterRecyclerview mAdapter;
    List<Student> studentList;
    private  int mPosition=-1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_recyclerview,null,false);
        initView(view);
        return view;
    }
    public void initView(View view){
        mEdtName=(EditText)view.findViewById(R.id.edt_name);
        mEdtClass=(EditText)view.findViewById(R.id.edt_class);
        mEdtMsv=(EditText)view.findViewById(R.id.edt_msv);
        mEdtBirth=(EditText)view.findViewById(R.id.edt_birth);
        mBtnAdd=(Button)view.findViewById(R.id.btn_add);
        mBtnUpdate=(Button)view.findViewById(R.id.btn_update);
        mBtnDelete=(Button)view.findViewById(R.id.btn_delete);
        mBtnDelete.setVisibility(View.GONE);
        mBtnUpdate.setVisibility(View.GONE);
        setListenView();
          studentList=new ArrayList<>();
        mAdapter =new AdapterRecyclerview(studentList);
        mAdapter.setOnClickItem(this);
        mRecyclerview =(RecyclerView)view.findViewById(R.id.rv_sinhvien);
        mRecyclerview.setAdapter(mAdapter);
        mRecyclerview.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
       // RecyclerView.LayoutManager layoutManager1= new StaggeredGridLayoutManager();
        mRecyclerview.setLayoutManager(layoutManager);

    }
public Student getDataFromView(){
    if( !mEdtName.getText().toString().isEmpty()
            && ! mEdtBirth.getText().toString().isEmpty()
            && !mEdtClass.getText().toString().isEmpty()
            && !mEdtMsv.getText().toString().isEmpty()){
        Student student = new Student();
        student.setmName(mEdtName.getText().toString());
        student.setmBirth(mEdtBirth.getText().toString());
        student.setmClass(mEdtClass.getText().toString());
        student.setmMsv(mEdtMsv.getText().toString());
        return student;
    }else{
        Toast.makeText(getContext(),"Vui long nhap du thong tin",Toast.LENGTH_SHORT).show();
        return null;
    }
}
    @Override
    public void onClick(View v) {
        int id =v.getId();
        switch (id){
            case R.id.btn_add:{
                Student student =getDataFromView();
                if (student!=null) {
                    mAdapter.addItem(studentList.size(), student);
                    break;
                }
            }
            case R.id.btn_update:{
                    if(mPosition!=-1){
                        Student student =getDataFromView();
                        if (student!=null)
                       mAdapter.replaceItem(mPosition,student);
                    }
                break;
            }
            case R.id.btn_delete:{
                if(mPosition!=-1){
                        mAdapter.removeItem(mPosition);
                }
                break;
            }
        }
    }

    public void setListenView(){
        mBtnAdd.setOnClickListener(this);
        mBtnUpdate.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);
    }
public void pushDataToView(Student student){
    mEdtName.setText(student.getmName());
    mEdtBirth.setText(student.getmBirth());
    mEdtClass.setText(student.getmClass());
    mEdtMsv.setText(student.getmMsv());

}
    @Override
    public void onClick(Student student,int pos) {
        mPosition=pos;
        mBtnDelete.setVisibility(View.VISIBLE);
        mBtnUpdate.setVisibility(View.VISIBLE);
            pushDataToView(student);

    }
}
