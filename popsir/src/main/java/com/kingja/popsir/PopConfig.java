package com.kingja.popsir;

import android.content.Context;
import android.view.ViewGroup;

/**
 * Description:TODO
 * Create Time:2018/3/17 14:00
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class PopConfig {
    private static final String TAG = "BasePop";
    protected Builder builder;
    public int width = ViewGroup.LayoutParams.MATCH_PARENT;
    public int height = ViewGroup.LayoutParams.WRAP_CONTENT;
    public int animationStyle = R.style.PopupTopAnimation;
    public boolean touchable = true;
    public Context context;
    public int maxHeight;

    public PopConfig(Builder builder) {
        this.width = builder.width;
        this.height = builder.height;
        this.animationStyle = builder.animationStyle;
        this.touchable = builder.touchable;
        this.context = builder.context;
        this.maxHeight = builder.maxHeight;
    }

    public static class Builder {
        private int width = ViewGroup.LayoutParams.MATCH_PARENT;
        private int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        private int animationStyle = R.style.PopupTopAnimation;
        private boolean touchable = true;
        private Context context;
        private int maxHeight;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setPopWidth(int width) {
            this.width = width;
            return this;
        }

        public Builder setPopHeight(int height) {
            this.height = height;
            return this;
        }

        public Builder setPopAnimationStyle(int animationStyle) {
            this.animationStyle = animationStyle;
            return this;
        }

        public Builder setPopOutsideTouchable(boolean touchable) {
            this.touchable = touchable;
            return this;
        }

        public Builder setPopMaxHeight(int maxHeight) {
            this.maxHeight = maxHeight;
            return this;
        }

        public PopConfig build() {
            return new PopConfig(this);
        }
    }
}
