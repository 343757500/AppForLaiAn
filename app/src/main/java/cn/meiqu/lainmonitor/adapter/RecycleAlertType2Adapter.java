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


public class RecycleAlertType2Adapter extends BaseRecycleAdapter {
    private Context mContent;
    private ArrayList<AlertType2> AlertType2s;
    private View mHeaderView;


    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;

    public RecycleAlertType2Adapter(Context mContent, ArrayList<AlertType2> AlertType2s) {
        this.mContent = mContent;
        this.AlertType2s = AlertType2s;
    }



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





    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(mHeaderView != null && viewType == TYPE_HEADER) {
            return new Holder(mHeaderView);
        }else {
            return new Holder(View.inflate(mContent, R.layout.recycle_alart_type2, null));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position)==TYPE_HEADER){
            return;
        }
        int  pos = getRealPosition(holder);
        ((RecycleTempManageAdapter.Holder) holder).instanceView(pos);
    }

    @Override
    public int getItemCount() {
        return mHeaderView == null ? AlertType2s.size() : AlertType2s.size() + 1;
    }

    class Holder extends BaseHolder implements View.OnClickListener {
        private TextView mTvAddr;
        private TextView mTvName;
        private TextView mTvInfo;
        private TextView mTvTime;
        private TextView mTvGallry;
        public Holder(View itemView) {
            super(itemView);
            itemView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            itemView.setOnClickListener(this);

            if (itemView==mHeaderView){
                return;
            }
            mTvAddr = (TextView) findViewById(R.id.tv_addr);
            mTvName = (TextView) findViewById(R.id.tv_name);
            mTvInfo = (TextView) findViewById(R.id.tv_info);
            mTvTime = (TextView) findViewById(R.id.tv_time);
            mTvGallry = (TextView) findViewById(R.id.tv_gallery);
            mTvAddr.setTextColor(mTvAddr.getResources().getColor(R.color.black3));
            mTvName.setTextColor(mTvAddr.getResources().getColor(R.color.black3));
            mTvInfo.setTextColor(mTvAddr.getResources().getColor(R.color.black3));
            mTvTime.setTextColor(mTvAddr.getResources().getColor(R.color.black3));
            mTvGallry.setTextColor(mTvAddr.getResources().getColor(R.color.black3));
        }



        public void assignViews() {

        }


        @Override
        public void instanceView(final int position) {
            if (mHeaderView!=itemView ) {
                if (position % 2 == 0) {
                    itemView.setBackgroundColor(mTvAddr.getResources().getColor(R.color.white));
                } else {
                    itemView.setBackgroundColor(mTvAddr.getResources().getColor(R.color.item_bg));
                }
                AlertType2 AlertType2 = AlertType2s.get(position);
                mTvAddr.setText(AlertType2.getLocation() + "");
                mTvName.setText(AlertType2.getName() + "");
                mTvInfo.setText(AlertType2.getInfo() + "");
                mTvTime.setText(AlertType2.getTime() + "");
                mTvGallry.setText(AlertType2.getGallery() + "");
            }
        }


        @Override
        public void onClick(View v) {
            if (getClickListener() != null) {
                getClickListener().OnRecycleItemClick(getPosition());
            }
        }
    }
}
