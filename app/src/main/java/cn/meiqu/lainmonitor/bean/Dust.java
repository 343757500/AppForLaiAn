package cn.meiqu.lainmonitor.bean;

/**
 * Created by Administrator on 2017/9/16.
 */

public class Dust {
    /**
     * currentData : 0.01
     * alarmData : 0.12
     * name : 有毒气体
     */

    private double currentData;
    private double alarmData;
    private String name;

    public double getCurrentData() {
        return currentData;
    }

    public void setCurrentData(double currentData) {
        this.currentData = currentData;
    }

    public double getAlarmData() {
        return alarmData;
    }

    public void setAlarmData(double alarmData) {
        this.alarmData = alarmData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
