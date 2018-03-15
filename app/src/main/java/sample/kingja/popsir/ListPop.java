package sample.kingja.popsir;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/**
 * Description:TODO
 * Create Time:2018/3/15 14:50
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class ListPop extends PopupWindow {
    public ListPop(Context context) {
        super(context);
        View view = View.inflate(context, R.layout.pop, null);
        setContentView(view);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setBackgroundDrawable(new ColorDrawable());
        setOutsideTouchable(true);
        setAnimationStyle(R.style.PopupTopAnimation);
    }

}
