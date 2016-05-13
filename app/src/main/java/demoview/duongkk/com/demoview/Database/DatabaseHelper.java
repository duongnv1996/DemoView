package demoview.duongkk.com.demoview.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import demoview.duongkk.com.demoview.Models.Student;

/**
 * Created by MyPC on 10/05/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public final static String DB_NAME= "databasestudent";
    public final static String TABLE_STUDENT = "t_student";
    public final static String ID = "id";
    public final static String LAST_NAME = "last_name";
    public final static String FIRST_NAME = "first_name";
    public final static String MARK = "mark";
    public SQLiteDatabase sqlDb;
    public DatabaseHelper(Context context){
        super(context,DB_NAME,null,1);
    }
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public List<Student> getAllData(){
        sqlDb=this.getWritableDatabase();
        Cursor cursor = sqlDb.rawQuery("Select * from "+ TABLE_STUDENT,null);
        List<Student> studentList = new ArrayList<>();
        if(cursor.moveToFirst()){
            while (cursor.moveToNext()){
                Student student = new Student();
                student.setmFirstName(cursor.getString(cursor.getColumnIndex(DatabaseHelper.FIRST_NAME)));
                student.setmLastName(cursor.getString(cursor.getColumnIndex(DatabaseHelper.LAST_NAME)));
                student.setmMark(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.MARK)));
                student.setmId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.ID)));
                studentList.add(student);
            }
        }
         return studentList;

    }
    public boolean insertData(Student student){
        sqlDb= this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(LAST_NAME,student.getmLastName());
        values.put(FIRST_NAME,student.getmFirstName());
        values.put(MARK,student.getmMark());

        if(sqlDb.insert(TABLE_STUDENT,null,values)!=-1) return true;
        return false;
    }
    public boolean updateData(Student student){
        sqlDb= this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(LAST_NAME,student.getmLastName());
        values.put(FIRST_NAME,student.getmFirstName());
        values.put(MARK,student.getmMark());
        sqlDb.update(TABLE_STUDENT,values,ID+"=?",new  String[]{student.getmId()+""});
        if(sqlDb.insert(TABLE_STUDENT,null,values)!=-1) return true;
        return false;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("Sqlite Database : ","onCreate");
        String sqlQuery = "Create table "+TABLE_STUDENT+" ( "+ ID +" integer primary key autoincrement , "+ LAST_NAME + " text not null , " + FIRST_NAME + " text not null , " + MARK + " integer not null )";
        db.execSQL(sqlQuery );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exist "+TABLE_STUDENT);
        Log.d("Sqlite Database : ","onUpgrade");
        onCreate(db);
    }
}
