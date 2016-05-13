package demoview.duongkk.com.demoview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import demoview.duongkk.com.demoview.Database.DatabaseHelper;
import demoview.duongkk.com.demoview.Models.Student;
import demoview.duongkk.com.demoview.adapter.AdapterStudentSQLite;
import demoview.duongkk.com.demoview.interfaces.OnClickItem;

public class SqliteActivity extends AppCompatActivity implements View.OnClickListener,OnClickItem {
  private   DatabaseHelper db ;
    private EditText mEdtLastName;
    private EditText mEdtFirstName;
    private EditText mEdtMark;
    private RecyclerView recyclerViewStudent;
    private AdapterStudentSQLite adapterStudentSQLite;
    private List<Student> listStudent;
    private Button mBtnAdd;
    private Student mStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        db= new DatabaseHelper(this);
        mEdtFirstName=(EditText)findViewById(R.id.edt_name);
        mEdtLastName=(EditText)findViewById(R.id.edt_sur_name);
        mEdtMark=(EditText)findViewById(R.id.edt_mark);
        mBtnAdd= (Button)findViewById(R.id.btn_add);
        listStudent= new ArrayList<>();
        listStudent.addAll(db.getAllData());
        adapterStudentSQLite= new AdapterStudentSQLite(this,listStudent,this);
        recyclerViewStudent= (RecyclerView)findViewById(R.id.recycler_view_sql);
        recyclerViewStudent.setHasFixedSize(true);
        recyclerViewStudent.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerViewStudent.setAdapter(adapterStudentSQLite);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:{
                if(!mEdtFirstName.equals("") && !mEdtMark.equals("") && !mEdtLastName.equals("")){
                    Student student = new Student();
                    student.setmFirstName(mEdtFirstName.getText().toString());
                    student.setmLastName(mEdtLastName.getText().toString());
                    student.setmMark(Integer.parseInt(mEdtMark.getText().toString()));
                    if(db.insertData(student)) {
                        Toast.makeText(this,"Them thanh cong",Toast.LENGTH_SHORT).show();
                        updateList();
                        recyclerViewStudent.scrollToPosition(listStudent.size()-1);
                    }
                }
                break;
            }
            case R.id.btn_view:{
                updateList();

                break;
            }
            case R.id.btn_update:{
               db.updateData(mStudent);

                break;
            }
        }
    }

    private void updateView(Student student,int pos) {
        mEdtLastName.setText(student.getmLastName());
        mEdtFirstName.setText(student.getmFirstName());
        mEdtMark.setText(student.getmMark());
    }

    private void updateList() {
        listStudent.clear();
        listStudent.addAll(db.getAllData());
        adapterStudentSQLite.notifyDataSetChanged();
    }

    @Override
    public void onClick(Student student, int pos) {
        mStudent=student;
            updateView(student,pos);
    }
}
