package cn.meiqu.lainmonitor;

import android.app.Application;

import org.xutils.x;

/**
 * Created by zsp on 2017/9/6.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //初始化xutils3框架
        x.Ext.init(this);
    }
}
