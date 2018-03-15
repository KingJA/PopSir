package sample.kingja.popsir;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Description:TODO
 * Create Time:2018/3/15 14:51
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Adapter extends BaseAdapter {
    private Context context;

    public Adapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View
                    .inflate(context, R.layout.item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    public class ViewHolder {
        public final View root;

        public ViewHolder(View root) {
            this.root = root;
        }
    }
}
