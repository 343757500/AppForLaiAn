package cn.meiqu.lainmonitor.aui.env.dust;

import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import cn.meiqu.baseproject.API;
import cn.meiqu.baseproject.httpGet.HttpGetController;
import cn.meiqu.lainmonitor.adapter.RecycleDustRealAdapter;
import cn.meiqu.lainmonitor.adapter.RecycleThunderRealAdapter;
import cn.meiqu.lainmonitor.aui.FragmentReal;
import cn.meiqu.lainmonitor.bean.Dust;
import cn.meiqu.lainmonitor.bean.Thunder;

/**
 * Created by Fatel on 16-5-10.
 */
public class FragmentDustReal extends FragmentReal {
    String action_getData = className + API.getDustReal;
    public ArrayList<Dust> thunders = new ArrayList<>();
    RecycleDustRealAdapter adapter;

    @Override
    public RecyclerView.Adapter getAdapter() {
        adapter = new RecycleDustRealAdapter(getActivity(), thunders);
        return adapter;
    }

    @Override
    public String getAction() {
        return action_getData;
    }

    public void requestData() {
        HttpGetController.getInstance().getDustReal(className);
    }

    public void handleData(String data) {
        ArrayList<Dust> temps = new Gson().fromJson(data, new TypeToken<ArrayList<Dust>>() {
        }.getType());
        if (!temps.isEmpty()) {
            thunders.clear();
            thunders.addAll(temps);
            adapter.notifyDataSetChanged();
        }
    }
}
