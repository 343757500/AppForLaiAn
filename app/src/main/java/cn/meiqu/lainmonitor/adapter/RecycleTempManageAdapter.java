package cn.meiqu.lainmonitor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import cn.meiqu.baseproject.baseRecycle.BaseHolder;
import cn.meiqu.baseproject.baseRecycle.BaseRecycleAdapter;
import cn.meiqu.lainmonitor.R;
import cn.meiqu.lainmonitor.bean.TempReal;


public class RecycleTempManageAdapter extends BaseRecycleAdapter {
    private Context mContent;
    private ArrayList<TempReal> TempReals;

    private View mHeaderView;


    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;

    public interface OnItemClickListner {
        public void onItemDel(int position);

        public void onItemEdit(int position);

    }


    @Override
    public int getItemViewType(int position) {
        if(mHeaderView == null) return TYPE_NORMAL;
        if(position == 0) return TYPE_HEADER;
        return TYPE_NORMAL;
    }



    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    public View getHeaderView() {
        return mHeaderView;
    }





    public OnItemClickListner getOnItemClickListner() {
        return onItemClickListner;
    }

    public void setOnItemClickListner(OnItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    private OnItemClickListner onItemClickListner;

    public RecycleTempManageAdapter(Context mContent, ArrayList<TempReal> TempReals) {
        this.mContent = mContent;
        this.TempReals = TempReals;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(mHeaderView != null && viewType == TYPE_HEADER) {
            return new Holder(mHeaderView);
        }else {
            return new Holder(View.inflate(mContent, R.layout.recycle_temp_manage, null));
        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position)==TYPE_HEADER){
            return;
        }
       int  pos = getRealPosition(holder);
        ((Holder) holder).instanceView(pos);


    }

    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }

    @Override
    public int getItemCount() {
        return mHeaderView == null ? TempReals.size() : TempReals.size() + 1;
    }

    class Holder extends BaseHolder implements View.OnClickListener {

        private TextView mTvAddr;
        private TextView mTvLocationName;
        private TextView mTvName;
        private TextView mTvMaxTemp;
        private TextView mTvMinTemp;
        private TextView mTvMaxHum;
        private TextView mTvMinHum;
        private TextView mTvInterval;
        private TextView mTvIp;
        private TextView mTvEdt;
        private TextView mTvDel;
        public Holder(View itemView) {
            super(itemView);
            itemView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            if (itemView==mHeaderView){
                return;
            }
            mTvAddr = (TextView)itemView. findViewById(R.id.tv_addr);
            mTvLocationName = (TextView)itemView. findViewById(R.id.tv_locationName);
            mTvName = (TextView)itemView.findViewById(R.id.tv_name);
            mTvMaxTemp = (TextView)itemView. findViewById(R.id.tv_maxTemp);
            mTvMinTemp = (TextView) itemView.findViewById(R.id.tv_minTemp);
            mTvMaxHum = (TextView) itemView.findViewById(R.id.tv_maxHum);
            mTvMinHum = (TextView)itemView. findViewById(R.id.tv_minHum);
            mTvInterval = (TextView) itemView.findViewById(R.id.tv_interval);
            mTvIp = (TextView) itemView.findViewById(R.id.tv_ip);
            mTvEdt = (TextView) itemView.findViewById(R.id.tv_edt);
            mTvDel = (TextView)itemView. findViewById(R.id.tv_del);

            mTvAddr.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvLocationName.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvName.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvIp.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvMaxTemp.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvMinTemp.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvMaxHum.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvMinHum.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvInterval.setTextColor(mTvName.getResources().getColor(R.color.black3));

            mTvEdt.setBackgroundColor(mTvName.getResources().getColor(R.color.colorPrimary));
            mTvDel.setBackgroundColor(mTvName.getResources().getColor(R.color.colorAccent));

            mTvEdt.setOnClickListener(this);
            mTvDel.setOnClickListener(this);
        }



        /*private TextView mTvAddr;
        private TextView mTvLocationName;
        private TextView mTvName;
        private TextView mTvMaxTemp;
        private TextView mTvMinTemp;
        private TextView mTvMaxHum;
        private TextView mTvMinHum;
        private TextView mTvInterval;
        private TextView mTvIp;
        private TextView mTvEdt;
        private TextView mTvDel;*/

        public void assignViews() {
          /*  mTvAddr = (TextView) findViewById(R.id.tv_addr);
            mTvLocationName = (TextView) findViewById(R.id.tv_locationName);
            mTvName = (TextView) findViewById(R.id.tv_name);
            mTvMaxTemp = (TextView) findViewById(R.id.tv_maxTemp);
            mTvMinTemp = (TextView) findViewById(R.id.tv_minTemp);
            mTvMaxHum = (TextView) findViewById(R.id.tv_maxHum);
            mTvMinHum = (TextView) findViewById(R.id.tv_minHum);
            mTvInterval = (TextView) findViewById(R.id.tv_interval);
            mTvIp = (TextView) findViewById(R.id.tv_ip);
            mTvEdt = (TextView) findViewById(R.id.tv_edt);
            mTvDel = (TextView) findViewById(R.id.tv_del);

            mTvAddr.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvLocationName.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvName.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvIp.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvMaxTemp.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvMinTemp.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvMaxHum.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvMinHum.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvInterval.setTextColor(mTvName.getResources().getColor(R.color.black3));

            mTvEdt.setBackgroundColor(mTvName.getResources().getColor(R.color.colorPrimary));
            mTvDel.setBackgroundColor(mTvName.getResources().getColor(R.color.colorAccent));

            mTvEdt.setOnClickListener(this);
            mTvDel.setOnClickListener(this);*/
        }


        @Override
        public void instanceView(final int position) {
            if (mHeaderView!=itemView ) {
                if (position % 2 == 0) {
                    itemView.setBackgroundColor(mTvName.getResources().getColor(R.color.white));
                } else {
                    itemView.setBackgroundColor(mTvName.getResources().getColor(R.color.item_bg));
                }
                TempReal TempReal = TempReals.get(position);
                mTvAddr.setText("" + TempReal.getEhmAddress());
                mTvLocationName.setText("" + TempReal.getDeviceLocationPojo().getDlName());
                mTvName.setText("" + TempReal.getEhmName());
                mTvIp.setText("" + TempReal.getIpPort());
                mTvMaxTemp.setText("" + TempReal.getEhmMaxTemp());
                mTvMinTemp.setText("" + TempReal.getEhmMinTemp());
                mTvMaxHum.setText("" + TempReal.getEhmMaxHum());
                mTvMinHum.setText("" + TempReal.getEhmMinHum());
                mTvInterval.setText("" + TempReal.getEhmInterval());
            }

        }

        @Override
        public void onClick(View v) {
            if (getOnItemClickListner() != null) {
                if (v.getId() == mTvEdt.getId()) {
                    getOnItemClickListner().onItemEdit(getPosition()-1);
                } else if (v.getId() == mTvDel.getId()) {
                    getOnItemClickListner().onItemDel(getPosition()-1);
                }
            }
        }
    }
}
