package cn.meiqu.lainmonitor.aui.env.noise;

import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import cn.meiqu.baseproject.API;
import cn.meiqu.baseproject.httpGet.HttpGetController;
import cn.meiqu.lainmonitor.adapter.RecycleNoiseRealAdapter;
import cn.meiqu.lainmonitor.aui.FragmentReal;
import cn.meiqu.lainmonitor.bean.Noise;

/**
 * Created by Fatel on 16-5-10.
 */
public class FragmentNoiseReal extends FragmentReal {
    String action_getData = className + API.getNoiseReal;
    public ArrayList<Noise> thunders = new ArrayList<>();
    RecycleNoiseRealAdapter adapter;

    @Override
    public RecyclerView.Adapter getAdapter() {
        adapter = new RecycleNoiseRealAdapter(getActivity(), thunders);
        return adapter;
    }

    @Override
    public String getAction() {
        return action_getData;
    }

    public void requestData() {
        HttpGetController.getInstance().getNoiseReal(className);
    }

    public void handleData(String data) {
        String data1=data;
        ArrayList<Noise> temps = new Gson().fromJson(data, new TypeToken<ArrayList<Noise>>() {
        }.getType());
        if (!temps.isEmpty()) {
            thunders.clear();
            thunders.addAll(temps);
            adapter.notifyDataSetChanged();
        }
    }
}
