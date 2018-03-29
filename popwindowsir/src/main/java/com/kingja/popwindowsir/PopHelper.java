package com.kingja.popwindowsir;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

import java.util.List;

/**
 * Description:TODO
 * Create Time:2018/3/21 15:42
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class PopHelper {

    private static final String TAG = "PopHelper";
    private ListPop listPop;
    private BaseAdapter adapter;
    private OnItemClickListener onItemClickListener;
    private PopSpinner popSpinner;
    private Context context;
    private List<String> list;
    private PopConfig popConfig;
    private int maxItmeCount;

    public PopHelper(Builder builder) {
        this.context = builder.context;
        this.popSpinner = builder.popSpinner;
        this.list = builder.list;
        this.adapter = builder.adapter;
        this.popConfig = builder.popConfig;
        this.maxItmeCount = builder.maxItemCount;
        this.onItemClickListener = builder.onItemClickListener;
        createPop();
    }

    public void createPop() {
        BaseAdapter adapter = this.adapter == null ? new PopAdapter(context, list) : this.adapter;
        listPop = new ListPop(context, popConfig)
                .setAdapter(adapter)
                .setOnItemClickListener(new ListPop.OnItemClickListener<Object>() {
                    @Override
                    public void onItemClick(Object item, int position) {
                        onItemClickListener.onItemClick(item, position, popSpinner);
                    }
                });

        View listItem = adapter.getView(0, null, (ListView)listPop.getContentView());
        listItem.measure(0, 0);
        int measuredHeight = listItem.getMeasuredHeight();
        if (maxItmeCount != -1) {
            listPop.setHeight(measuredHeight*maxItmeCount);
        }
        listPop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                popSpinner.close();
            }
        });
        popSpinner.setOnSpinnerStatusChangedListener(new PopSpinner.OnSpinnerStatusChangedListener() {
            @Override
            public void setOnSpinnerStatusChanged(boolean opened) {
                if (opened) {
                    listPop.showAsDropDown(popSpinner);
                } else {
                    listPop.dismiss();
                }
            }
        });
    }

    public interface OnItemClickListener<T> {
        public void onItemClick(T item, int position, PopSpinner popSpinner);
    }

    public static class Builder {
        private BaseAdapter adapter;
        private OnItemClickListener onItemClickListener;
        private PopSpinner popSpinner;
        private Context context;
        private List<String> list;
        private int maxItemCount=-1;
        private PopConfig popConfig = new PopConfig.Builder().build();

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setAdapter(BaseAdapter adapter) {
            this.adapter = adapter;
            return this;
        }

        public <T> Builder setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
            return this;
        }

        public Builder setPopSpinner(PopSpinner popSpinner) {
            this.popSpinner = popSpinner;
            return this;
        }

        public Builder setList(List<String> list) {
            this.list = list;
            return this;
        }

        public Builder setPopConfig(PopConfig popConfig) {
            this.popConfig = popConfig;
            return this;
        }

        public Builder setMaxItemCount(int maxItemCount) {
            this.maxItemCount = maxItemCount;
            return this;
        }

        public PopHelper build() {
            return new PopHelper(this);
        }
    }

}
