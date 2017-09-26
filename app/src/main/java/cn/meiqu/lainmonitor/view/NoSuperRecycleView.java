package cn.meiqu.lainmonitor.view;

import android.content.Context;
import android.util.AttributeSet;

import cn.meiqu.baseproject.view.superrecyclerview.SuperRecyclerView;

/**
 * Created by zsp on 2017/9/1.
 */

public class NoSuperRecycleView extends SuperRecyclerView {
    public NoSuperRecycleView(Context context) {
        super(context);
    }

    public NoSuperRecycleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoSuperRecycleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int newHeight = MeasureSpec.makeMeasureSpec(1000000, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, newHeight);
    }
}
