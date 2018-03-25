package sample.kingja.popsir;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kingja.popsir.PopAdapter;

import java.util.List;

/**
 * Description:TODO
 * Create Time:2018/3/24 19:18
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class ItemAdapter extends BaseAdapter {
    private final Context context;
    private final List<PopItem> list;

    public ItemAdapter(Context context, List<PopItem> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View
                    .inflate(context, com.kingja.popsir.R.layout.item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv.setText(list.get(position).getItemName());
        return convertView;
    }

    public class ViewHolder {
        public final View root;
        public TextView tv;

        public ViewHolder(View root) {
            this.root = root;
            tv = root.findViewById(com.kingja.popsir.R.id.tv);
        }
    }
}
