package cn.meiqu.lainmonitor.aui.system;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.ButterKnife;
import cn.meiqu.baseproject.API;
import cn.meiqu.baseproject.baseUi.BaseFragment;
import cn.meiqu.baseproject.util.Config;
import cn.meiqu.lainmonitor.R;
import cn.meiqu.lainmonitor.bean.AdminBean;

/**
 * Created by zsp on 2017/9/13.
 */

public class FragmentLogmewage extends BaseFragment {



    String className = getClass().getName();
    String action_getData = className + API.showCurrentLoginUserUrl;
    String action_update = className +API.updateLoginUserUrl;
    //private ArrayList<AdminBean> mList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_modify,null);
        ButterKnife.bind(this,view);
        initReceiver(new String[]{action_getData,action_update});
        return view;
    }




    @Override
    public void onHttpHandle(String action, String data) {

    }
}
