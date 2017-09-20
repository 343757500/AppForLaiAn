package cn.meiqu.lainmonitor.aui.operation.server;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import cn.meiqu.baseproject.API;
import cn.meiqu.baseproject.httpGet.HttpGetController;
import cn.meiqu.lainmonitor.adapter.RecycleElecMachineRealAdapter;
import cn.meiqu.lainmonitor.adapter.RecycleOperRealAdapter;
import cn.meiqu.lainmonitor.aui.FragmentReal;
import cn.meiqu.lainmonitor.bean.ElecMachine;
import cn.meiqu.lainmonitor.bean.ServerBean;

/**
 * Created by Fatel on 16-5-10.
 */
public class FragmentServer extends FragmentReal {
    //服务器界面
    String action_getData = className + API.ServerUrl;
//    String action_switch = className + API.switchElecMachine;
   public  ArrayList<ServerBean> ElecMachines = new ArrayList<>();
    RecycleOperRealAdapter adapter;


    @Override
    public RecyclerView.Adapter getAdapter() {
        mRecycleV.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RecycleOperRealAdapter(getActivity(), ElecMachines);
        return adapter;
    }

    @Override
    public String getAction() {
        return action_getData;
    }


    public void requestData() {
        HttpGetController.getInstance().getServerData(className);
    }

    public void handleData(String data) {
        ArrayList<ServerBean> temps = new Gson().fromJson(data, new TypeToken<ArrayList<ServerBean>>() {
        }.getType());
        if (!temps.isEmpty()) {
            ElecMachines.clear();
            ElecMachines.addAll(temps);
            adapter.notifyDataSetChanged();
        }

    }
}
