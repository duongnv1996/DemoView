package demoview.duongkk.com.demoview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import demoview.duongkk.com.demoview.Models.Student;
import demoview.duongkk.com.demoview.R;
import demoview.duongkk.com.demoview.interfaces.OnClickItem;

/**
 * Created by MyPC on 10/05/2016.
 */
public class AdapterStudentSQLite extends RecyclerView.Adapter<AdapterStudentSQLite.ViewHolder> {
    List<Student> listStudent;
    Context context;
    OnClickItem onClickItem;
    public AdapterStudentSQLite(Context context,List<Student> listStudent,OnClickItem onClickItem) {
        this.context = context;
        this.listStudent=listStudent;
        this.onClickItem = onClickItem;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.item_student_sql, null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Student student = listStudent.get(position);
        holder.getmTvFirstName().setText(student.getmFirstName());
        holder.getmTvLastName().setText(student.getmLastName());
        holder.getmTvMark().setText(student.getmMark()+"");
    }

    @Override
    public int getItemCount() {
        return listStudent.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvFirstName;
        private TextView mTvLastName;
        private TextView mTvMark;
        private LinearLayout llHolder;
        public ViewHolder(View itemView) {
            super(itemView);
            mTvFirstName = (TextView) itemView.findViewById(R.id.tv_first_name);
            mTvLastName = (TextView) itemView.findViewById(R.id.tv_last_name);
            mTvMark = (TextView) itemView.findViewById(R.id.tv_mark);
            llHolder= (LinearLayout)itemView.findViewById(R.id.ll_student);
            llHolder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickItem.onClick(listStudent.get(getAdapterPosition()),getAdapterPosition());
                }
            });
        }

        public TextView getmTvFirstName() {
            return mTvFirstName;
        }

        public void setmTvFirstName(TextView mTvFirstName) {
            this.mTvFirstName = mTvFirstName;
        }

        public TextView getmTvLastName() {
            return mTvLastName;
        }

        public void setmTvLastName(TextView mTvLastName) {
            this.mTvLastName = mTvLastName;
        }

        public TextView getmTvMark() {
            return mTvMark;
        }

        public void setmTvMark(TextView mTvMark) {
            this.mTvMark = mTvMark;
        }
    }
}
