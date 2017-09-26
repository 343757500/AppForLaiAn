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
import cn.meiqu.lainmonitor.bean.AlertType2;
import cn.meiqu.lainmonitor.bean.Co2;


public class RecycleCo2ManageAdapter extends BaseRecycleAdapter {
    private Context mContent;
    private ArrayList<Co2> Co2s;

    private View mHeaderView;


    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;




    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    @Override
    public int getItemViewType(int position) {
        if(mHeaderView == null) return TYPE_NORMAL;
        if(position == 0) return TYPE_HEADER;
        return TYPE_NORMAL;
    }



    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }

    public interface OnItemClickListner {
        public void onItemDel(int position);

        public void onItemEdit(int position);

    }

    public OnItemClickListner getOnItemClickListner() {
        return onItemClickListner;
    }

    public void setOnItemClickListner(OnItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    private OnItemClickListner onItemClickListner;

    public RecycleCo2ManageAdapter(Context mContent, ArrayList<Co2> Co2s) {
        this.mContent = mContent;
        this.Co2s = Co2s;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(mHeaderView != null && viewType == TYPE_HEADER) {
            return new Holder(mHeaderView);
        }else {
            return new Holder(View.inflate(mContent, R.layout.recycle_co2_manage, null));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position)==TYPE_HEADER){
            return;
        }
        int  pos = getRealPosition(holder);
        ((RecycleCo2ManageAdapter.Holder) holder).instanceView(pos);
    }

    @Override
    public int getItemCount() {

        return mHeaderView == null ? Co2s.size() : Co2s.size() + 1;
    }

    class Holder extends BaseHolder implements View.OnClickListener {

        private TextView mTvAddr;
        private TextView mTvLocationName;
        private TextView mTvName;
        private TextView mTvIp;
        private TextView mTvEdt;
        private TextView mTvDel;
        private TextView mTvAlart;
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
            mTvAlart = (TextView) findViewById(R.id.tv_alart);

            mTvAddr.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvLocationName.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvName.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvIp.setTextColor(mTvName.getResources().getColor(R.color.black3));
            mTvAlart.setTextColor(mTvName.getResources().getColor(R.color.black3));


            mTvEdt.setOnClickListener(this);
            mTvDel.setOnClickListener(this);
        }



        public void assignViews() {

        }

        @Override
        public void instanceView(final int position) {
            if (position % 2 == 0) {
                itemView.setBackgroundColor(mTvName.getResources().getColor(R.color.white));
            } else {
                itemView.setBackgroundColor(mTvName.getResources().getColor(R.color.item_bg));
            }
            Co2 Co2 = Co2s.get(position);
            mTvAddr.setText("" + Co2.getAddress());
            mTvLocationName.setText("" + Co2.getDeviceLocationPojo().getDlName());
            mTvName.setText("" + Co2.getName());
            mTvIp.setText("" + Co2.getIpPort());
            mTvAlart.setText("" + Co2.getAlarmData());
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
