package cn.meiqu.lainmonitor.bean;

/**
 * Created by Administrator on 2017/9/19.
 */

public class NoiseList {

    /**
     * deviceLocationPojo : {"dlId":1,"dlName":"1号监控机房"}
     * devicename : 2 号噪声仪
     * id : 3
     * intervaltime : 30
     * ip : 5
     * ipId : 0
     * ipPort : 192.168.1.222:5100
     * maxNoise : 120
     * minNoise : 30
     * noise : 0
     * noiseAddress : 1
     * number : 0
     * sdlId : 0
     * sn : 0
     */

    private DeviceLocationPojoBean deviceLocationPojo;
    private String devicename;
    private int id;
    private int intervaltime;
    private int ip;
    private int ipId;
    private String ipPort;
    private int maxNoise;
    private int minNoise;
    private int noise;
    private int noiseAddress;
    private int number;
    private int sdlId;
    private int sn;

    public DeviceLocationPojoBean getDeviceLocationPojo() {
        return deviceLocationPojo;
    }

    public void setDeviceLocationPojo(DeviceLocationPojoBean deviceLocationPojo) {
        this.deviceLocationPojo = deviceLocationPojo;
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIntervaltime() {
        return intervaltime;
    }

    public void setIntervaltime(int intervaltime) {
        this.intervaltime = intervaltime;
    }

    public int getIp() {
        return ip;
    }

    public void setIp(int ip) {
        this.ip = ip;
    }

    public int getIpId() {
        return ipId;
    }

    public void setIpId(int ipId) {
        this.ipId = ipId;
    }

    public String getIpPort() {
        return ipPort;
    }

    public void setIpPort(String ipPort) {
        this.ipPort = ipPort;
    }

    public int getMaxNoise() {
        return maxNoise;
    }

    public void setMaxNoise(int maxNoise) {
        this.maxNoise = maxNoise;
    }

    public int getMinNoise() {
        return minNoise;
    }

    public void setMinNoise(int minNoise) {
        this.minNoise = minNoise;
    }

    public int getNoise() {
        return noise;
    }

    public void setNoise(int noise) {
        this.noise = noise;
    }

    public int getNoiseAddress() {
        return noiseAddress;
    }

    public void setNoiseAddress(int noiseAddress) {
        this.noiseAddress = noiseAddress;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSdlId() {
        return sdlId;
    }

    public void setSdlId(int sdlId) {
        this.sdlId = sdlId;
    }

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public static class DeviceLocationPojoBean {
        /**
         * dlId : 1
         * dlName : 1号监控机房
         */

        private int dlId;
        private String dlName;

        public int getDlId() {
            return dlId;
        }

        public void setDlId(int dlId) {
            this.dlId = dlId;
        }

        public String getDlName() {
            return dlName;
        }

        public void setDlName(String dlName) {
            this.dlName = dlName;
        }
    }
}
