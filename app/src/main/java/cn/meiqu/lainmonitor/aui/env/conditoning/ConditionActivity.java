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
        if (action.equals(action_getHomePage)&&data!=null) {
            handleData(data);
        }
    }

    private void handleData(String data) {
        cinditionbean cinditionbean = new Gson().fromJson(data, cinditionbean.class);



        tv1.setText(cinditionbean.getParameterPojo().getIzumiT());
        tv2.setText(cinditionbean.getParameterPojo().getElementFinT1());
        tv3.setText(cinditionbean.getParameterPojo().getElementFinT2());
        tv4.setText(cinditionbean.getParameterPojo().getElementFinT3());
        tv5.setText(cinditionbean.getParameterPojo().getElementFinT4());
        tv6.setText(cinditionbean.getParameterPojo().getIzumiT());
        tv7.setText(cinditionbean.getParameterPojo().getIzumiT());
        tv8.setText(cinditionbean.getParameterPojo().getIzumiT());
        tv9.setText(cinditionbean.getParameterPojo().getFaultNumber());
        tv10.setText(cinditionbean.getParameterPojo().getCompressorNumber());
        tv11.setText(cinditionbean.getParameterPojo().getIzumiT());
        tv12.setText(cinditionbean.getParameterPojo().getIzumiT());
        tv13.setText(cinditionbean.getParameterPojo().getIzumiT());
        tv14.setText(cinditionbean.getParameterPojo().getIzumiT());
        tv15.setText(cinditionbean.getParameterPojo().getIzumiT());
        tv16.setText(cinditionbean.getParameterPojo().getIzumiT());
        tv17.setText(cinditionbean.getParameterPojo().getIzumiT());
        tv18.setText(cinditionbean.getParameterPojo().getIzumiT());
        tv19.setText(cinditionbean.getParameterPojo().getIzumiT());
        tv20.setText(cinditionbean.getParameterPojo().getIzumiT());
        tv21.setText(cinditionbean.getParameterPojo().getIzumiT());
        tv22.setText(cinditionbean.getParameterPojo().getIzumiT());
        tv23.setText(cinditionbean.getParameterPojo().getIzumiT());
        tv24.setText(cinditionbean.getParameterPojo().getIzumiT());
        tv25.setText(cinditionbean.getParameterPojo().getIzumiT());
        tv26.setText(cinditionbean.getParameterPojo().getIzumiT());
        tv27.setText(cinditionbean.getParameterPojo().getIzumiT());
        tv28.setText(cinditionbean.getParameterPojo().getIzumiT());
        tv29.setText(cinditionbean.getParameterPojo().getIzumiT());
        tv30.setText(cinditionbean.getParameterPojo().getIzumiT());



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
