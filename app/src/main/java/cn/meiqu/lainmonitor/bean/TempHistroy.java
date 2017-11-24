package cn.meiqu.lainmonitor.bean;

/**
 * Created by Fatel on 16-6-2.
 */
public class TempHistroy {

    /**
     * ehhHum : 9
     * ehhId : 1
     * ehhName : 1号温湿度
     * ehhTemp : 20
     * ehhTime : 2017-10-17 10:23
     */

    private double ehhHum;
    private int ehhId;
    private String ehhName;
    private double ehhTemp;
    private String ehhTime;

    public double getEhhHum() {
        return ehhHum;
    }

    public void setEhhHum(int ehhHum) {
        this.ehhHum = ehhHum;
    }

    public int getEhhId() {
        return ehhId;
    }

    public void setEhhId(int ehhId) {
        this.ehhId = ehhId;
    }

    public String getEhhName() {
        return ehhName;
    }

    public void setEhhName(String ehhName) {
        this.ehhName = ehhName;
    }

    public double getEhhTemp() {
        return ehhTemp;
    }

    public void setEhhTemp(int ehhTemp) {
        this.ehhTemp = ehhTemp;
    }

    public String getEhhTime() {
        return ehhTime;
    }

    public void setEhhTime(String ehhTime) {
        this.ehhTime = ehhTime;
    }
}
