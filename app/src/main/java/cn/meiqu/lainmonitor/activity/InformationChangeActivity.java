package cn.meiqu.lainmonitor.activity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.meiqu.baseproject.API;
import cn.meiqu.baseproject.baseUi.BaseActivity;
import cn.meiqu.lainmonitor.R;
import cn.meiqu.lainmonitor.bean.AdminBean;

/**
 * Created by Administrator on 2017/8/17.
 */

public class InformationChangeActivity extends BaseActivity {



    String className = getClass().getName();
    String action_getData = className + API.showCurrentLoginUserUrl;
    String action_update = className +API.updateLoginUserUrl;


    @BindView(R.id.admin_account_ed)
    EditText mAccountEd;
    @BindView(R.id.admin_email_ed)
    EditText mEmailEd;
    @BindView(R.id.admin_phone_ed)
    EditText mPhoneEd;
    @BindView(R.id.man_ra)
    RadioButton mManRa;
    @BindView(R.id.femal_ra)
    RadioButton mFemRa;
    @BindView(R.id.super_ra)
    RadioButton mSuperRa;
    @BindView(R.id.next_ra)
    RadioButton mNextRa;
    @BindView(R.id.nomal_ra)
    RadioButton mNormalRa;
    private ArrayList<AdminBean> mList = new ArrayList<>();
    AdminBean bean;
    private int type ;
    private int sex;
    private int Mon = 0;
    private int Tues = 0;
    private int Wed = 0;
    private int Thr = 0;
    private int Fri = 0;
    private int Sat = 0;
    private int Sun = 0;
    @BindView(R.id.day1)
    CheckBox mCheck1;
    @BindView(R.id.day2)
    CheckBox mCheck2;
    @BindView(R.id.day3)
    CheckBox mCheck3;
    @BindView(R.id.day4)
    CheckBox mCheck4;
    @BindView(R.id.day5)
    CheckBox mCheck5;
    @BindView(R.id.day6)
    CheckBox mCheck6;
    @BindView(R.id.day7)
    CheckBox mCheck7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infomationchange);
        ButterKnife.bind(this,this);
        initReceiver(new String[]{action_getData,action_update});
        initTitle("信息修改");
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
        ArrayList<AdminBean> temps = new Gson().fromJson(data,new TypeToken<ArrayList<AdminBean>>(){}.getType());
        if(temps != null){
            mList.clear();
            mList.addAll(temps);
            bean = mList.get(0);
            if(bean.flag == true){
                mAccountEd.setText(bean.msg.name);
                mEmailEd.setText(bean.msg.email);
                mPhoneEd.setText(bean.msg.phoneNumber+"");
                if(bean.msg.sex == 1){
                    sex = 1;
                    mManRa.setChecked(true);
                    mFemRa.setChecked(false);
                }else{
                    sex = 2;
                    mManRa.setChecked(false);
                    mFemRa.setChecked(true);
                }
                if(bean.msg.type == 1){
                    type = 1;
                    mSuperRa.setChecked(true);
                    mNextRa.setChecked(false);
                    mNormalRa.setChecked(false);
                }else if(bean.msg.type == 2){
                    type = 2;
                    mSuperRa.setChecked(false);
                    mNextRa.setChecked(true);
                    mNormalRa.setChecked(false);
                }else{
                    type = 3;
                    mSuperRa.setChecked(false);
                    mNextRa.setChecked(false);
                    mNormalRa.setChecked(true);
                }

                if(bean.msg.administratorDutyDayPojo.monday == 1){
                    Mon = 1;
                    mCheck1.setChecked(true);
                }
                if(bean.msg.administratorDutyDayPojo.tuesday == 1){
                    Tues = 1;
                    mCheck2.setChecked(true);
                }
                if(bean.msg.administratorDutyDayPojo.wednesday == 1){
                    Wed = 1;
                    mCheck3.setChecked(true);
                }
                if(bean.msg.administratorDutyDayPojo.thursday == 1){
                    Thr = 1;
                    mCheck4.setChecked(true);
                }
                if(bean.msg.administratorDutyDayPojo.friday == 1){
                    Fri = 1;
                    mCheck5.setChecked(true);
                }
                if(bean.msg.administratorDutyDayPojo.saturday == 1){
                    Sat = 1;
                    mCheck6.setChecked(true);
                }
                if(bean.msg.administratorDutyDayPojo.sunday == 1){
                    Sun = 1;
                    mCheck7.setChecked(true);
                }
            }

        }
    }
}
