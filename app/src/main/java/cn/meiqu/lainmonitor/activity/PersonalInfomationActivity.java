package cn.meiqu.lainmonitor.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.meiqu.baseproject.API;
import cn.meiqu.baseproject.baseUi.BaseActivity;
import cn.meiqu.baseproject.dao.SettingDao;
import cn.meiqu.baseproject.httpGet.HttpGetController;
import cn.meiqu.lainmonitor.R;
import cn.meiqu.lainmonitor.bean.AdminBean;

/**
 * Created by Administrator on 2017/8/17.
 */

public class PersonalInfomationActivity extends BaseActivity {

    String className = getClass().getName();
    String action_getData = className + API.showCurrentLoginUserUrl;
    String action_update = className +API.updateLoginUserUrl;


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_title_more)
    TextView tvTitleMore;
    @BindView(R.id.toolBar)
    Toolbar toolBar;
    @BindView(R.id.admin_account_ed)
    TextView adminAccountEd;
    @BindView(R.id.admin_phone_ed)
    TextView adminPhoneEd;
    @BindView(R.id.admin_email_ed)
    TextView adminEmailEd;
    @BindView(R.id.Gender)
    TextView Gender;
    @BindView(R.id.super_ra)
    TextView superRa;
    @BindView(R.id.tv_workday)
    TextView tvWorkday;

    private ArrayList<AdminBean> mList = new ArrayList<>();
    private ArrayList<AdminBean> temps;
    AdminBean bean;
    private String workday="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persinalinfomation);
        ButterKnife.bind(this);
        initReceiver(new String[]{action_getData,action_update});
        initTitle("个人信息");
    }

    @Override
    public void onHttpHandle(String action, String data) {
        if(action.equals(action_getData)){
            handleGetDate(data);
        }
        if(action.equals(action_update)){
            showMsg(data);
        }
    }

    @Override
    public void initFragment() {

    }


    private void handleGetDate(String data){
        try {
            temps = new Gson().fromJson(data,new TypeToken<ArrayList<AdminBean>>(){}.getType());
        }catch (Exception e){
            Toast.makeText(this,"密码已修改，请重新登录",Toast.LENGTH_SHORT).show();
        }

        if(temps != null){
            mList.clear();
            mList.addAll(temps);
            bean = mList.get(0);
            if(bean.flag == true){
                adminAccountEd.setText(bean.msg.name);
                adminEmailEd.setText(bean.msg.email);
                adminPhoneEd.setText(bean.msg.phoneNumber+"");
                if(bean.msg.sex == 1){
                    Gender.setText("男");

                }else{
                    Gender.setText("女");
                }
                if(bean.msg.type == 1){
                    superRa.setText("超级管理员");
                }else if(bean.msg.type == 2){
                    superRa.setText("管理员");
                }else{
                    superRa.setText("普通管理员");
                }

                if(bean.msg.administratorDutyDayPojo.monday == 1){
                    workday="星期一";
                }
                if(bean.msg.administratorDutyDayPojo.tuesday == 1){
                    workday+=",星期二";
                }
                if(bean.msg.administratorDutyDayPojo.wednesday == 1){
                    workday+=",星期三";
                }
                if(bean.msg.administratorDutyDayPojo.thursday == 1){
                    workday+=",星期四";
                }
                if(bean.msg.administratorDutyDayPojo.friday == 1){
                    workday+=",星期五";
                }
                if(bean.msg.administratorDutyDayPojo.saturday == 1){
                    workday+=",星期六";
                }
                if(bean.msg.administratorDutyDayPojo.sunday == 1){
                    workday+=",星期日";
                }

                tvWorkday.setText(workday);
            }

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        requestData(SettingDao.getInstance().getAccount(),SettingDao.getInstance().getPwd());
    }

    public void requestData(String userName, String password){
        HttpGetController.getInstance().getAdminMessage(className,userName,password);
    }
}
