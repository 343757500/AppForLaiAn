package cn.meiqu.lainmonitor.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.meiqu.baseproject.API;
import cn.meiqu.baseproject.baseUi.BaseActivity;
import cn.meiqu.baseproject.dao.SettingDao;
import cn.meiqu.baseproject.httpGet.HttpGetController;
import cn.meiqu.lainmonitor.R;
import cn.meiqu.lainmonitor.bean.AdminBean;

/**
 * Created by zsp on 2017/8/17.  信息修改页面
 */

public class InformationChangeActivity extends BaseActivity {



    String className = getClass().getName();
    String action_getData = className + API.showCurrentLoginUserUrl;
    String action_update = className +API.updateLoginUserUrl;


    @BindView(R.id.admin_password_ed)
    EditText mPasswordEd;
    @BindView(R.id.admin_confirm_ed)
    EditText mPsConfirmEd;
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
    private ArrayList<AdminBean> temps;

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
                mAccountEd.setText(bean.msg.name);
                mEmailEd.setText(bean.msg.email);
                mPhoneEd.setText(bean.msg.phoneNumber+"");
                mPasswordEd.setText(bean.msg.password);
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


    @OnClick({R.id.fb_modify,R.id.man_ra,R.id.femal_ra,R.id.super_ra,R.id.next_ra,R.id.nomal_ra,R.id.day1,R.id.day2,R.id.day3,
            R.id.day4,R.id.day5,R.id.day6,R.id.day7})
    public void onClick(View v){

        switch (v.getId()){
            case R.id.fb_modify:
                //提交
                if(!mPasswordEd.getText().toString().equals("") && !mPsConfirmEd.getText().toString().equals("")
                        && !mPhoneEd.getText().toString().equals("")
                        &&!mEmailEd.getText().toString().equals("")
                        && !mAccountEd.getText().toString().equals("")){
                    if(mPasswordEd.getText().toString().equals(mPsConfirmEd.getText().toString())){
                        HttpGetController.getInstance().updateAdmin(className,bean.msg.id,mAccountEd.getText().toString(),
                                mPasswordEd.getText().toString(),Long.parseLong(mPhoneEd.getText().toString()),mEmailEd.getText().toString(),sex,type,Mon,Tues,Wed,
                                Thr,Fri,Sat,Sun);

                        SettingDao.getInstance().setIsLogin(0);
                        SettingDao.getInstance().setAccount("");
                        SettingDao.getInstance().setPwd("");
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                finish();
                            }
                        },3000);
                        Toast.makeText(this,"信息已修改，即将退出",Toast.LENGTH_SHORT).show();
                    }else{
                        toast("两次密码输入不一致！");
                    }
                }
                else{
                    toast("输入不能为空！");
                }
                break;
            case R.id.man_ra:
                if(mManRa.isChecked()){
                    sex = 1;
                }
                break;
            case R.id.femal_ra:
                if(mFemRa.isChecked()){
                    sex = 2;
                }
                break;
            case R.id.super_ra:
                if(mSuperRa.isChecked()){
                    type = 1;
                }
                break;
            case R.id.next_ra:
                if(mNextRa.isChecked()){
                    type = 2;
                }
                break;
            case R.id.nomal_ra:
                if(mNormalRa.isChecked()){
                    type = 3;
                }
                break;
            case R.id.day1:
                if(mCheck1.isChecked()){
                    Mon = 1;
                }else{
                    Mon = 0;
                }
                break;
            case R.id.day2:
                if(mCheck2.isChecked()){
                    Tues = 1;
                }else{
                    Tues = 0;
                }
                break;
            case R.id.day3:
                if(mCheck3.isChecked()){
                    Wed = 1;
                }else{
                    Wed = 0;
                }
                break;
            case R.id.day4:
                if(mCheck4.isChecked()){
                    Thr = 1;
                }else{
                    Thr = 0;
                }
                break;
            case R.id.day5:
                if(mCheck5.isChecked()){
                    Fri = 1;
                }else{
                    Fri = 0;
                }
                break;
            case R.id.day6:
                if(mCheck6.isChecked()){
                    Sat = 1;
                }else{
                    Sat = 0;
                }
                break;
            case R.id.day7:
                if(mCheck7.isChecked()){
                    Sun = 1;
                }else{
                    Sun = 0;
                }
                break;
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
