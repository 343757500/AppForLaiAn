package cn.meiqu.lainmonitor.bean;

/**
 * Created by Administrator on 2017/9/16.
 */

public class Noise {

    /**
     * minNoise : 30
     * devicename : 2 号噪声仪
     * maxNoise : 120
     * noise : 52.3
     */

    private int minNoise;
    private String devicename;
    private int maxNoise;
    private double noise;

    public int getMinNoise() {
        return minNoise;
    }

    public void setMinNoise(int minNoise) {
        this.minNoise = minNoise;
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;
    }

    public int getMaxNoise() {
        return maxNoise;
    }

    public void setMaxNoise(int maxNoise) {
        this.maxNoise = maxNoise;
    }

    public double getNoise() {
        return noise;
    }

    public void setNoise(double noise) {
        this.noise = noise;
    }
}
