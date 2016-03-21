package demoview.duongkk.com.demoview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import demoview.duongkk.com.demoview.Models.Student;
import demoview.duongkk.com.demoview.R;
import demoview.duongkk.com.demoview.interfaces.OnClickItem;

/**
 * Created by DuongKK on 3/21/2016.
 */
public class AdapterRecyclerview extends RecyclerView.Adapter<AdapterRecyclerview.RecyclerViewHolder> {
    List<Student> students;
    OnClickItem onClickItem;
    public void setOnClickItem(OnClickItem onClickItem) {
        this.onClickItem = onClickItem;
    }


    public AdapterRecyclerview(List<Student> students) {
        this.students = students;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
       View view = inflater.inflate(R.layout.item_recyclerview,parent,false);
        return  new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Student student = students.get(position);
        holder.tvName.setText(student.getmName());
        holder.tvMsv.setText(student.getmMsv());
        holder.tvClass.setText(student.getmClass());
        holder.tvBirth.setText(student.getmBirth());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }
    public void addItem(int pos, Student student){
        students.add(pos, student);
        notifyItemInserted(pos);
    }
    public void removeItem(int pos){
        students.remove(pos);
        notifyItemRemoved(pos);
    }
    public void updateList(List<Student> students){
        this.students=students;
        notifyDataSetChanged();
    }
    public void replaceItem(int pos,Student student) {
        if (pos > 0) {
            students.set(pos, student);
            notifyItemChanged(pos);
        }
    }
    public Student getItem(int pos){
        return students.get(pos);
    }
    class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView tvName;
        public TextView tvClass;
        public TextView tvMsv;
        public TextView tvBirth;
        private LinearLayout layoutItem;
        public RecyclerViewHolder(View itemView) {
            super(itemView);

            tvName=(TextView)itemView.findViewById(R.id.tv_name);
            tvBirth=(TextView)itemView.findViewById(R.id.tv_birth);
            tvClass=(TextView)itemView.findViewById(R.id.tv_class);
            tvMsv=(TextView)itemView.findViewById(R.id.tv_msv);
            layoutItem=(LinearLayout)itemView.findViewById(R.id.ll_item_rcv);
            layoutItem.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            onClickItem.onClick( getItem(getAdapterPosition()),getAdapterPosition());
        }
    }
}
