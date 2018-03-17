package com.kingja.popsir;

import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;

/**
 * Description:TODO
 * Create Time:2018/3/17 14:12
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class ListPop extends BasePop {

    private ListView lv_pop;

    public ListPop(PopConfig popConfig) {
        super(popConfig);
    }

    @Override
    public void initView(View contentView) {
        lv_pop = contentView.findViewById(R.id.lv_pop);

    }
    public ListPop setAdapter(BaseAdapter adapter) {
        lv_pop.setAdapter(adapter);
        return this;
    }

    @Override
    public int getLayoutId() {
        return R.layout.pop;
    }
}
