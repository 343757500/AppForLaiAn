package cn.meiqu.lainmonitor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import cn.meiqu.baseproject.baseRecycle.BaseHolder;
import cn.meiqu.baseproject.baseRecycle.BaseRecycleAdapter;
import cn.meiqu.lainmonitor.R;
import cn.meiqu.lainmonitor.bean.LocationWater;


public class RecycleLocationManageAdapter extends BaseRecycleAdapter {
    private Context mContent;
    private ArrayList<LocationWater> LocationWaters;
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

    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }


    public OnItemClickListner getOnItemClickListner() {
        return onItemClickListner;
    }

    public void setOnItemClickListner(OnItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    private OnItemClickListner onItemClickListner;

    public RecycleLocationManageAdapter(Context mContent, ArrayList<LocationWater> LocationWaters) {
        this.mContent = mContent;
        this.LocationWaters = LocationWaters;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(mHeaderView != null && viewType == TYPE_HEADER) {
            return new Holder(mHeaderView);
        }else {
            return new Holder(View.inflate(mContent, R.layout.recycle_locationwater_manage, null));
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

    @Override
    public int getItemCount() {
        return mHeaderView == null ? LocationWaters.size() : LocationWaters.size() + 1;
    }

    class Holder extends BaseHolder implements View.OnClickListener {
        private TextView mTvAddr;
        private TextView mTvLocationName;
        private TextView mTvName;
        private TextView mTvIp;
        private TextView mTvEdt;
        private TextView mTvDel;
        public Holder(View itemView) {
            super(itemView);
            itemView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            if (itemView==mHeaderView){
                return;
            }
            mTvAddr = (TextView) findViewById(R.id.tv_addr);
            mTvLocationName = (TextView) findViewById(R.id.tv_locationName);
            mTvName = (TextView) findViewById(R.id.tv_name);
            mTvIp = (TextView) findViewById(R.id.tv_ip);
            mTvEdt = (TextView) findViewById(R.id.tv_edt);
            mTvDel = (TextView) findViewById(R.id.tv_del);

            mTvAddr.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvLocationName.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvName.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvIp.setTextColor(mTvName.getResources().getColor(R.color.black3));


            mTvEdt.setOnClickListener(this);
            mTvDel.setOnClickListener(this);
        }



        public void assignViews() {

        }

        @Override
        public void instanceView(final int position) {
            if (mHeaderView!=itemView ) {
                if (position % 2 == 0) {
                    itemView.setBackgroundColor(mTvName.getResources().getColor(R.color.white));
                } else {
                    itemView.setBackgroundColor(mTvName.getResources().getColor(R.color.item_bg));
                }
                LocationWater locationWater = LocationWaters.get(position);
                mTvAddr.setText("" + locationWater.getAddress());
                mTvLocationName.setText("" + locationWater.getDeviceLocationPojo().getDlName());
                mTvName.setText("" + locationWater.getName());
                mTvIp.setText("" + locationWater.getIpPort());
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
