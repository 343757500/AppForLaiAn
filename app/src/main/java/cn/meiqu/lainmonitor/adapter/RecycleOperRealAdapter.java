package cn.meiqu.lainmonitor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import cn.meiqu.baseproject.baseRecycle.BaseHolder;
import cn.meiqu.baseproject.baseRecycle.BaseOnRecycleClickListener;
import cn.meiqu.baseproject.baseRecycle.BaseRecycleAdapter;
import cn.meiqu.baseproject.view.RippleView;
import cn.meiqu.lainmonitor.R;
import cn.meiqu.lainmonitor.bean.ElecMachine;
import cn.meiqu.lainmonitor.bean.ServerBean;


public class RecycleOperRealAdapter extends BaseRecycleAdapter {
    private Context mContent;
    private ArrayList<ServerBean> ElecMachines;

    public RecycleOperRealAdapter(Context mContent, ArrayList<ServerBean> ElecMachines) {
        this.mContent = mContent;
        this.ElecMachines = ElecMachines;
    }

    private BaseOnRecycleClickListener clickListener;

    public BaseOnRecycleClickListener getClickListener() {
        return clickListener;
    }

    public void setClickListener(BaseOnRecycleClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(View.inflate(mContent, R.layout.fragment_server2, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((Holder) holder).instanceView(position);
    }

    @Override
    public int getItemCount() {
        return ElecMachines.size();
    }

    class Holder extends BaseHolder  {
        public Holder(View itemView) {
            super(itemView);
            itemView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }

        private TextView cpu_tv1;
        private TextView cpu_tv2;
        private TextView cpu_tv3;
        private TextView cpu_tv4;
        private TextView cpu_tv5;
        private TextView cpu_tv6;
        private TextView cpu_tv7;
        private TextView sys_tv1;
        private TextView sys_tv2;
        private TextView sys_tv3;
        private TextView swap_tv1;
        private TextView swap_tv2;
        private TextView swap_tv3;
        private TextView tv_c1;
        private TextView tv_c2;
        private TextView tv_c3;
        private TextView tv_d1;
        private TextView tv_d2;
        private TextView tv_d3;
        private TextView tv_e1;
        private TextView tv_e2;
        private TextView tv_e3;

        private TextView tv_f1;
        private TextView tv_f2;
        private TextView tv_f3;

        public void assignViews() {
            cpu_tv1 = (TextView) findViewById(R.id.cpu_tv1);
            cpu_tv2 = (TextView) findViewById(R.id.cpu_tv2);
            cpu_tv3 = (TextView) findViewById(R.id.cpu_tv3);
            cpu_tv4 = (TextView) findViewById(R.id.cpu_tv4);
            cpu_tv5 = (TextView) findViewById(R.id.cpu_tv5);
            cpu_tv6 = (TextView) findViewById(R.id.cpu_tv6);
            cpu_tv7 = (TextView) findViewById(R.id.cpu_tv7);
            sys_tv1 = (TextView) findViewById(R.id.sys_tv1);
            sys_tv2 = (TextView) findViewById(R.id.sys_tv2);
            sys_tv3 = (TextView) findViewById(R.id.sys_tv3);
            swap_tv1 = (TextView) findViewById(R.id.swap_tv1);
            swap_tv2 = (TextView) findViewById(R.id.swap_tv2);
            swap_tv3 = (TextView) findViewById(R.id.swap_tv3);
            tv_c1 = (TextView) findViewById(R.id.tv_c1);
            tv_c2 = (TextView) findViewById(R.id.tv_c2);
            tv_c3 = (TextView) findViewById(R.id.tv_c3);
            tv_d1 = (TextView) findViewById(R.id.tv_d1);
            tv_d2 = (TextView) findViewById(R.id.tv_d2);
            tv_d3 = (TextView) findViewById(R.id.tv_d3);
            tv_e1 = (TextView) findViewById(R.id.tv_e1);
            tv_e2 = (TextView) findViewById(R.id.tv_e2);
            tv_e3 = (TextView) findViewById(R.id.tv_e3);
            tv_f1 = (TextView) findViewById(R.id.tv_f1);
            tv_f2 = (TextView) findViewById(R.id.tv_f2);
            tv_f3 = (TextView) findViewById(R.id.tv_f3);
        }


        @Override
        public void instanceView(final int position) {
            ServerBean elecMachine = ElecMachines.get(position);
            cpu_tv1.setText(elecMachine.connectionSum + "");
            cpu_tv2.setText(elecMachine.cpuCombined+"%");
            cpu_tv3.setText(elecMachine.cpuUser+"%");
            cpu_tv4.setText(elecMachine.cpuSys+"%");
            cpu_tv5.setText(elecMachine.cpuWait+"%");
            cpu_tv6.setText(elecMachine.cpuNice+"0%");
            cpu_tv7.setText(elecMachine.cpuIdle+"%");
            sys_tv1.setText("总物理内存    "+elecMachine.memTotal);
            sys_tv2.setText("已使用          "+elecMachine.memUsed);
            sys_tv3.setText("剩余            "+elecMachine.memFree);
            swap_tv1.setText("交换区总量   "+elecMachine.swapTotal);
            swap_tv2.setText("已使用          "+elecMachine.swapUsed);
            swap_tv3.setText("剩余            "+elecMachine.swapFree);
            tv_c1.setText(elecMachine.disInfo.Cdisk[0] + "G");
            tv_c2.setText(elecMachine.disInfo.Cdisk[1] + "G");
            tv_c3.setText(elecMachine.disInfo.Cdisk[2] + "G");
            tv_d1.setText(elecMachine.disInfo.Ddisk[0] + "G");
            tv_d2.setText(elecMachine.disInfo.Ddisk[1] + "G");
            tv_d3.setText(elecMachine.disInfo.Ddisk[2] + "G");
            tv_e1.setText(elecMachine.disInfo.Edisk[0] + "G");
            tv_e2.setText(elecMachine.disInfo.Edisk[1] + "G");
            tv_e3.setText(elecMachine.disInfo.Edisk[2] + "G");
            tv_f1.setText(elecMachine.disInfo.Fdisk[0] + "G");
            tv_f2.setText(elecMachine.disInfo.Fdisk[1] + "G");
            tv_f3.setText(elecMachine.disInfo.Fdisk[2] + "G");
        }


    }
}
