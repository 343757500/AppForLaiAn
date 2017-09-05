package cn.meiqu.lainmonitor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kyleduo.switchbutton.SwitchButton;

import java.util.ArrayList;

import cn.meiqu.baseproject.baseRecycle.BaseHolder;
import cn.meiqu.baseproject.baseRecycle.BaseRecycleAdapter;
import cn.meiqu.baseproject.view.RippleView;
import cn.meiqu.lainmonitor.R;
import cn.meiqu.lainmonitor.bean.AirF;


public class RecycleAirFRealAdapter extends BaseRecycleAdapter {
    private Context mContent;
    private ArrayList<AirF> airFs;

    private OnAirClickListener onAirClickListener;

    public OnAirClickListener getOnAirClickListener() {
        return onAirClickListener;
    }

    public void setOnAirClickListener(OnAirClickListener onAirClickListener) {
        this.onAirClickListener = onAirClickListener;
    }

    public interface OnAirClickListener {
        public void onAirClick(int position, String number);
    }

    public RecycleAirFRealAdapter(Context mContent, ArrayList<AirF> airFs) {
        this.mContent = mContent;
        this.airFs = airFs;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(View.inflate(mContent, R.layout.recycle_air2, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((Holder) holder).instanceView(position);
    }

    @Override
    public int getItemCount() {
        return airFs.size();
    }

    class Holder extends BaseHolder implements View.OnClickListener {
        public Holder(View itemView) {
            super(itemView);
            itemView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }

        private TextView mTvAddr;
        private TextView mTvName;
        private TextView mRippleStudyBoot;
        private TextView mRippleStudyOff;
        //private TextView mRippleOn;
        private SwitchButton switchBt;

        public void assignViews() {
            mTvAddr = (TextView) findViewById(R.id.tv_addr);
            mTvName = (TextView) findViewById(R.id.tv_name);
            mRippleStudyBoot = (TextView) findViewById(R.id.ripple_studyBoot);
            mRippleStudyOff = (TextView) findViewById(R.id.ripple_studyOff);
           // mRippleOn = (TextView) findViewById(R.id.ripple_on);
            switchBt= (SwitchButton) findViewById(R.id.switch_bt);

           mRippleStudyBoot.setOnClickListener(this);
            mRippleStudyOff.setOnClickListener(this);
           // mRippleOn.setOnClickListener(this);
            switchBt.setOnClickListener(this);
        }


        @Override
        public void instanceView(final int position) {
            AirF airF = airFs.get(position);
            mTvName.setText(airF.getName() + "");
            mTvAddr.setText(airF.getAddress() + "");
        }

        /*@Override
        public void onComplete(RippleView v) {
            if (getOnAirClickListener() != null) {
                if (mRippleStudyBoot.getId() == v.getId()) {
                    getOnAirClickListener().onAirClick(getPosition(), "1");
                } else if (mRippleStudyOff.getId() == v.getId()) {
                    getOnAirClickListener().onAirClick(getPosition(), "2");
                } else if (mRippleOn.getId() == v.getId()) {
                    getOnAirClickListener().onAirClick(getPosition(), "3");
                } else if (mRippleOff.getId() == v.getId()) {
                    getOnAirClickListener().onAirClick(getPosition(), "4");
                }
            }
        }*/

        @Override
        public void onClick(View v) {
            if (getOnAirClickListener() != null) {
                if (mRippleStudyBoot.getId() == v.getId()) {
                    getOnAirClickListener().onAirClick(getPosition(), "1");
                } else if (mRippleStudyOff.getId() == v.getId()) {
                    getOnAirClickListener().onAirClick(getPosition(), "2");
                } else if (switchBt.isChecked()) {
                    getOnAirClickListener().onAirClick(getPosition(), "3");
                } else if (!switchBt.isChecked()) {
                    getOnAirClickListener().onAirClick(getPosition(), "4");

                }
            }
        }
    }
}
