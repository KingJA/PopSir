package com.kingja.popsir;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

/**
 * Description:TODO
 * Create Time:2018/3/15 14:50
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public abstract class BasePop extends PopupWindow implements PopupWindow.OnDismissListener {
    private static final String TAG = "BasePop";
    protected Context context;


    public BasePop(PopConfig popConfig) {
        super(popConfig.context);
        this.context = popConfig.context;
        this. setWidth(popConfig.width);
        this. setHeight(popConfig.height);
        this.setBackgroundDrawable(new ColorDrawable());
        this.setOutsideTouchable(popConfig.touchable);
        this.setAnimationStyle(popConfig.animationStyle);
        this.setOnDismissListener(this);
        this.setFocusable(true);
        setContentView(View.inflate(context, getLayoutId(), null));
        initView(getContentView());
    }

    public abstract void initView(View contentView);

    public abstract int getLayoutId();

    @Override
    public void onDismiss() {
        setAlpha(1f);
    }

    @Override
    public void showAsDropDown(View anchor) {
        super.showAsDropDown(anchor);
        setAlpha(0.7f);
    }

    private void setAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = ((Activity) context).getWindow().getAttributes();
        lp.alpha = bgAlpha;
        ((Activity) context).getWindow().setAttributes(lp);
    }

}
