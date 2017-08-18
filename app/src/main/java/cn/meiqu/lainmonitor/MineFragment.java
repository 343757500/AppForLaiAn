package cn.meiqu.lainmonitor;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.meiqu.baseproject.dao.SettingDao;
import cn.meiqu.lainmonitor.activity.InformationChangeActivity;
import cn.meiqu.lainmonitor.activity.PersonalInfomationActivity;
import cn.meiqu.lainmonitor.activity.SettingActivity;
import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by Administrator on 2017/5/25.
 */

public class MineFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private FancyButton settingTv;
    private TextView personalInfomation;
    private TextView informationChange;
    private TextView passwordChange;

    public MineFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static MineFragment newInstance(int sectionNumber) {
        MineFragment fragment = new MineFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        /**
         * SettingDao.getInstance().setIsLogin();
         SettingDao.getInstance().setAccount(userName);
         SettingDao.getInstance().setPwd(password);
         */

        personalInfomation = (TextView) rootView.findViewById(R.id.personal_information);
        informationChange = (TextView) rootView.findViewById(R.id.information_change);
        passwordChange = (TextView) rootView.findViewById(R.id.password_change);
        settingTv = (FancyButton) rootView.findViewById(R.id.fb_logout);


        initOnClickListener();
        return rootView;
    }

    private void initOnClickListener() {

        personalInfomation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), PersonalInfomationActivity.class));

            }
        });


        informationChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), InformationChangeActivity.class));

            }
        });

        passwordChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });





        settingTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SettingDao.getInstance().setIsLogin(0);
                SettingDao.getInstance().setAccount("");
                SettingDao.getInstance().setPwd("");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getActivity().finish();
                    }
                },300);
            }
        });

    }


    @Override
    public void onResume() {
        super.onResume();
        if(!SettingDao.getInstance().getIsLogin()){
            getActivity().finish();
        }
    }
}
