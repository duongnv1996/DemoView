package demoview.duongkk.com.demoview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import demoview.duongkk.com.demoview.Models.Card;
import demoview.duongkk.com.demoview.R;

/**
 * Created by DuongKK on 3/18/2016.
 */
public class AdapterListView extends BaseAdapter {
    Context context;
List<Card> cards;
    public AdapterListView(Context context,List<Card> cards) {
        this.context=context;
        this.cards=cards;

    }

    @Override
    public int getCount() {
        return cards.size();
    }

    @Override
    public Object getItem(int position) {
        return cards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder= new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.item_card,null,false);
            viewHolder.imageView = (ImageView)convertView.findViewById(R.id.img_avatar);
            viewHolder.tvNumber=(TextView)convertView.findViewById(R.id.tv_number);
            viewHolder.tvName =(TextView)convertView.findViewById(R.id.tv_name);

            convertView.setTag(viewHolder);
        }else{
         viewHolder= (ViewHolder) convertView.getTag();
        }
        Card card= cards.get(position);
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /// Toast.makeText(context,"Click vao image",Toast.LENGTH_SHORT).show();
                cards.remove(position);
                notifyDataSetChanged();
            }
        });
        viewHolder.tvName.setText(card.getName());
        viewHolder.tvNumber.setText(card.getNumber());
        viewHolder.imageView.setImageResource(R.mipmap.ic_launcher);
        return convertView;
    }


    class ViewHolder{
        ImageView imageView;
        TextView tvName;
        TextView tvNumber;

    }

}


