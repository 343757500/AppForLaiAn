package cn.meiqu.lainmonitor.aui.env.conditoning;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.meiqu.baseproject.API;
import cn.meiqu.baseproject.baseUi.BaseActivity;
import cn.meiqu.baseproject.httpGet.HttpGetController;
import cn.meiqu.lainmonitor.R;
import cn.meiqu.lainmonitor.bean.cinditionbean;

/**
 * Created by Administrator on 2017/8/8.
 * HKControl
 */

public class ConditionActivity extends BaseActivity {

    String className = getClass().getName();
    String action_getHomePage = className + API.getCondition;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.tv4)
    TextView tv4;
    @BindView(R.id.tv5)
    TextView tv5;
    @BindView(R.id.tv6)
    TextView tv6;
    @BindView(R.id.tv7)
    TextView tv7;
    @BindView(R.id.tv8)
    TextView tv8;
    @BindView(R.id.tv9)
    TextView tv9;
    @BindView(R.id.tv10)
    TextView tv10;
    @BindView(R.id.tv11)
    TextView tv11;
    @BindView(R.id.tv12)
    TextView tv12;
    @BindView(R.id.tv13)
    TextView tv13;
    @BindView(R.id.tv14)
    TextView tv14;
    @BindView(R.id.tv15)
    TextView tv15;
    @BindView(R.id.tv16)
    TextView tv16;
    @BindView(R.id.tv17)
    TextView tv17;
    @BindView(R.id.tv18)
    TextView tv18;
    @BindView(R.id.tv19)
    TextView tv19;
    @BindView(R.id.tv20)
    TextView tv20;
    @BindView(R.id.tv21)
    TextView tv21;
    @BindView(R.id.tv22)
    TextView tv22;
    @BindView(R.id.tv23)
    TextView tv23;
    @BindView(R.id.tv24)
    TextView tv24;
    @BindView(R.id.tv25)
    TextView tv25;
    @BindView(R.id.tv26)
    TextView tv26;
    @BindView(R.id.tv27)
    TextView tv27;
    @BindView(R.id.tv28)
    TextView tv28;
    @BindView(R.id.tv29)
    TextView tv29;
    @BindView(R.id.tv30)
    TextView tv30;
    @BindView(R.id.tv31)
    TextView tv31;
    @BindView(R.id.tv32)
    TextView tv32;
    @BindView(R.id.tv33)
    TextView tv33;
    @BindView(R.id.tv34)
    TextView tv34;
    @BindView(R.id.tv35)
    TextView tv35;
    @BindView(R.id.tv36)
    TextView tv36;
    @BindView(R.id.tv37)
    TextView tv37;
    @BindView(R.id.tv38)
    TextView tv38;

    @Override
    public void onHttpHandle(String action, String data) {
        Log.e("hei",data);
        if (action.equals(action_getHomePage)) {
            handleData(data);
        }
    }

    private void handleData(String data) {
        cinditionbean cinditionbean = new Gson().fromJson(data, cinditionbean.class);



        tv1.setText(cinditionbean.getParameterPojo().getIzumiT());

    }

    @Override
    public void initFragment() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condition);
        initReceiver(new String[]{action_getHomePage});
        initTitle("中央空调");
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        requestData();
    }

    private void requestData() {
        HttpGetController.getInstance().getCondition(className);
    }



}
