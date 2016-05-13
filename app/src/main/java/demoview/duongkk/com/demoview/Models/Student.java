package demoview.duongkk.com.demoview.Models;

/**
 * Created by DuongKK on 3/21/2016.
 */
public class Student {
   private String mName;
    private String mClass;
    private String mMsv;
    private String mBirth;

    // SQLite Student
    private String mFirstName;
    private String mLastName;
    private int mId;
    private int mMark;

    public String getmFirstName() {
        return mFirstName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getmMark() {
        return mMark;
    }

    public void setmMark(int mMark) {
        this.mMark = mMark;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmClass() {
        return mClass;
    }

    public void setmClass(String mClass) {
        this.mClass = mClass;
    }

    public String getmMsv() {
        return mMsv;
    }

    public void setmMsv(String mMsv) {
        this.mMsv = mMsv;
    }

    public String getmBirth() {
        return mBirth;
    }

    public void setmBirth(String mBirth) {
        this.mBirth = mBirth;
    }
}
