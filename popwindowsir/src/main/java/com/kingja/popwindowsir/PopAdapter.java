package com.kingja.popwindowsir;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Description:TODO
 * Create Time:2018/3/15 14:51
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class PopAdapter extends BaseAdapter {
    private Context context;
    private List<String> list;

    public PopAdapter(Context context, List<String> list) {
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View
                    .inflate(context, R.layout.item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv.setText(list.get(position));
        return convertView;
    }

    public class ViewHolder {
        public final View root;
        public TextView tv;

        public ViewHolder(View root) {
            this.root = root;
             tv = root.findViewById(R.id.tv);
        }
    }
}
