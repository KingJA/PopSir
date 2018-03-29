package com.kingja.popwindowsir;

import android.view.ViewGroup;

/**
 * Description:TODO
 * Create Time:2018/3/17 14:00
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class PopConfig {
    public int width = ViewGroup.LayoutParams.MATCH_PARENT;
    public int height = ViewGroup.LayoutParams.WRAP_CONTENT;
    public int animationStyle = R.style.PopupTopAnimation;
    public boolean touchable = true;
    public int maxHeight;

    public PopConfig(Builder builder) {
        this.width = builder.width;
        this.height = builder.height;
        this.animationStyle = builder.animationStyle;
        this.touchable = builder.touchable;
        this.maxHeight = builder.maxHeight;
    }

    public static class Builder {
        private static final int ANIMATION_STYLE_DEFAULT = -1;
        private int width = ViewGroup.LayoutParams.MATCH_PARENT;
        private int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        private int animationStyle = ANIMATION_STYLE_DEFAULT;
        private boolean touchable = true;
        private int maxHeight;


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
