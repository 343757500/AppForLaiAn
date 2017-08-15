package cn.meiqu.lainmonitor.aui.env.co2;

import java.util.ArrayList;

import cn.meiqu.baseproject.API;
import cn.meiqu.baseproject.httpGet.HttpGetController;
import cn.meiqu.lainmonitor.aui.FragmentControl;
import cn.meiqu.lainmonitor.aui.env.lwater.FragmentLwaterAlart;
import cn.meiqu.lainmonitor.bean.Co2;

/**
 * Created by Fatel on 16-5-25.
 */
public class FragmentCo2Alart extends FragmentLwaterAlart {
    String action_getData = className + API.getCo2Alart;

    @Override
    public String getAction() {
        return action_getData;
    }


    @Override
    public void requestData(String start, String end, String deviceId) {
        showProgressDialog();
        HttpGetController.getInstance().getCo2Alart(deviceId, start, end, className);
    }

    @Override
    public String[] getDeviceNames() {
        ArrayList<Co2> tempReals = ((FragmentCo2Real) ((FragmentControl) getParentFragment()).fragments.get(0)).co2s;
        String names[] = new String[tempReals.size() + 1];
        for (int i = 1; i < names.length; i++) {
            names[i] = tempReals.get(i - 1).getName();
        }
        return names;
    }

    @Override
    public String getDeviceId(int position) {
        ArrayList<Co2> tempReals = ((FragmentCo2Real) ((FragmentControl) getParentFragment()).fragments.get(0)).co2s;
        return tempReals.get(position - 1).getId() + "";
    }

}
