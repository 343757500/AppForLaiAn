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
import cn.meiqu.lainmonitor.bean.TempAlart;


public class RecycleTempAlertAdapter extends BaseRecycleAdapter {
    private Context mContent;
    private ArrayList<TempAlart> TempAlarts;



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



    public RecycleTempAlertAdapter.OnItemClickListner getOnItemClickListner() {
        return onItemClickListner;
    }

    public void setOnItemClickListner(RecycleTempAlertAdapter.OnItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    private RecycleTempAlertAdapter.OnItemClickListner onItemClickListner;



    public RecycleTempAlertAdapter(Context mContent, ArrayList<TempAlart> TempAlarts) {
        this.mContent = mContent;
        this.TempAlarts = TempAlarts;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(mHeaderView != null && viewType == TYPE_HEADER) {
            return new Holder(mHeaderView);
        }else {
            return new Holder(View.inflate(mContent, R.layout.recycle_alart_message, null));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position)==TYPE_HEADER){
            return;
        }
        int  pos = getRealPosition(holder);
        ((RecycleTempAlertAdapter.Holder) holder).instanceView(pos);

    }

    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;


    }


    @Override
    public int getItemCount() {
        return mHeaderView == null ? TempAlarts.size() : TempAlarts.size() + 1;

    }

    class Holder extends BaseHolder implements View.OnClickListener {

        private TextView mTvAddr;
        private TextView mTvName;
        private TextView mTvInfo;
        private TextView mTvTime;
        public Holder(View itemView) {
            super(itemView);

            itemView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            if (itemView==mHeaderView){
                return;
            }
            mTvAddr = (TextView) findViewById(R.id.tv_addr);
            mTvName = (TextView) findViewById(R.id.tv_name);
            mTvInfo = (TextView) findViewById(R.id.tv_info);
            mTvTime = (TextView) findViewById(R.id.tv_time);

            mTvAddr.setTextColor(mTvAddr.getResources().getColor(R.color.black3));
            mTvName.setTextColor(mTvAddr.getResources().getColor(R.color.black3));
            mTvInfo.setTextColor(mTvAddr.getResources().getColor(R.color.black3));
            mTvTime.setTextColor(mTvAddr.getResources().getColor(R.color.black3));

            itemView.setOnClickListener(this);


        }



        public void assignViews() {


        }


        @Override
        public void instanceView(final int position) {
            if (position % 2 == 0) {
                itemView.setBackgroundColor(mTvAddr.getResources().getColor(R.color.white));
            } else {
                itemView.setBackgroundColor(mTvAddr.getResources().getColor(R.color.item_bg));
            }
            TempAlart TempAlart = TempAlarts.get(position);
            mTvAddr.setText(TempAlart.getEhaLocation() + "");
            mTvName.setText(TempAlart.getEhaName() + "");
            mTvInfo.setText(TempAlart.getEhaInfo() + "");
            mTvTime.setText(TempAlart.getEhaTime() + "");
        }


        @Override
        public void onClick(View v) {
            if (getClickListener() != null) {
                getClickListener().OnRecycleItemClick(getPosition()-1);
            }
        }
    }
}
