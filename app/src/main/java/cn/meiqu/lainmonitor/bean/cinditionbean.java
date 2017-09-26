package cn.meiqu.lainmonitor.bean;

/**
 * Created by Administrator on 2017/9/26.
 */

public class cinditionbean {
    /**
     * malfunctionPojo : {"communicationFailure":0,"environmentTProbe":0,"externalChain":0,"pumpOverload":0,"sumBackwaterProbe":0,"sumIzumiProbe":0,"systemLowT":0,"systemOvertop":0}
     * parameterPojo : {"ascentT":"0","compressorNumber":"0","compressorOut1":0,"compressorOut2":0,"compressorOut3":0,"compressorOut4":0,"elementFinT1":"0","elementFinT2":"0","elementFinT3":"0","elementFinT4":"0","elementIzumitT1":"0","elementIzumitT2":"0","elementPressState1":0,"elementPressState2":0,"elementPressState3":0,"elementPressState4":0,"elementPressTime1":"0","elementPressTime2":"0","elementPressTime3":"0","elementPressTime4":"0","environmentT":"0","fanOut1":0,"fanOut2":0,"faultNumber":"0","izumiT":"122222","loadOut":"0","practicalT":"0","settingT":"0","systemState":0,"workPattern":0}
     * setConditionPojo : {"timingCloseH1":"1","timingCloseH2":"1","timingCloseH3":"1","timingCloseM1":"1","timingCloseM2":"1","timingCloseM3":"1","timingOpenH1":"1","timingOpenH2":"1","timingOpenH3":"1","timingOpenM1":"1","timingOpenM2":"1","timingOpenM3":"1"}
     */

    private MalfunctionPojoBean malfunctionPojo;
    private ParameterPojoBean parameterPojo;
    private SetConditionPojoBean setConditionPojo;

    public MalfunctionPojoBean getMalfunctionPojo() {
        return malfunctionPojo;
    }

    public void setMalfunctionPojo(MalfunctionPojoBean malfunctionPojo) {
        this.malfunctionPojo = malfunctionPojo;
    }

    public ParameterPojoBean getParameterPojo() {
        return parameterPojo;
    }

    public void setParameterPojo(ParameterPojoBean parameterPojo) {
        this.parameterPojo = parameterPojo;
    }

    public SetConditionPojoBean getSetConditionPojo() {
        return setConditionPojo;
    }

    public void setSetConditionPojo(SetConditionPojoBean setConditionPojo) {
        this.setConditionPojo = setConditionPojo;
    }

    public static class MalfunctionPojoBean {
        /**
         * communicationFailure : 0
         * environmentTProbe : 0
         * externalChain : 0
         * pumpOverload : 0
         * sumBackwaterProbe : 0
         * sumIzumiProbe : 0
         * systemLowT : 0
         * systemOvertop : 0
         */

        private int communicationFailure;
        private int environmentTProbe;
        private int externalChain;
        private int pumpOverload;
        private int sumBackwaterProbe;
        private int sumIzumiProbe;
        private int systemLowT;
        private int systemOvertop;

        public int getCommunicationFailure() {
            return communicationFailure;
        }

        public void setCommunicationFailure(int communicationFailure) {
            this.communicationFailure = communicationFailure;
        }

        public int getEnvironmentTProbe() {
            return environmentTProbe;
        }

        public void setEnvironmentTProbe(int environmentTProbe) {
            this.environmentTProbe = environmentTProbe;
        }

        public int getExternalChain() {
            return externalChain;
        }

        public void setExternalChain(int externalChain) {
            this.externalChain = externalChain;
        }

        public int getPumpOverload() {
            return pumpOverload;
        }

        public void setPumpOverload(int pumpOverload) {
            this.pumpOverload = pumpOverload;
        }

        public int getSumBackwaterProbe() {
            return sumBackwaterProbe;
        }

        public void setSumBackwaterProbe(int sumBackwaterProbe) {
            this.sumBackwaterProbe = sumBackwaterProbe;
        }

        public int getSumIzumiProbe() {
            return sumIzumiProbe;
        }

        public void setSumIzumiProbe(int sumIzumiProbe) {
            this.sumIzumiProbe = sumIzumiProbe;
        }

        public int getSystemLowT() {
            return systemLowT;
        }

        public void setSystemLowT(int systemLowT) {
            this.systemLowT = systemLowT;
        }

        public int getSystemOvertop() {
            return systemOvertop;
        }

        public void setSystemOvertop(int systemOvertop) {
            this.systemOvertop = systemOvertop;
        }
    }

    public static class ParameterPojoBean {
        /**
         * ascentT : 0
         * compressorNumber : 0
         * compressorOut1 : 0
         * compressorOut2 : 0
         * compressorOut3 : 0
         * compressorOut4 : 0
         * elementFinT1 : 0
         * elementFinT2 : 0
         * elementFinT3 : 0
         * elementFinT4 : 0
         * elementIzumitT1 : 0
         * elementIzumitT2 : 0
         * elementPressState1 : 0
         * elementPressState2 : 0
         * elementPressState3 : 0
         * elementPressState4 : 0
         * elementPressTime1 : 0
         * elementPressTime2 : 0
         * elementPressTime3 : 0
         * elementPressTime4 : 0
         * environmentT : 0
         * fanOut1 : 0
         * fanOut2 : 0
         * faultNumber : 0
         * izumiT : 122222
         * loadOut : 0
         * practicalT : 0
         * settingT : 0
         * systemState : 0
         * workPattern : 0
         */

        private String ascentT;
        private String compressorNumber;
        private int compressorOut1;
        private int compressorOut2;
        private int compressorOut3;
        private int compressorOut4;
        private String elementFinT1;
        private String elementFinT2;
        private String elementFinT3;
        private String elementFinT4;
        private String elementIzumitT1;
        private String elementIzumitT2;
        private int elementPressState1;
        private int elementPressState2;
        private int elementPressState3;
        private int elementPressState4;
        private String elementPressTime1;
        private String elementPressTime2;
        private String elementPressTime3;
        private String elementPressTime4;
        private String environmentT;
        private int fanOut1;
        private int fanOut2;
        private String faultNumber;
        private String izumiT;
        private String loadOut;
        private String practicalT;
        private String settingT;
        private int systemState;
        private int workPattern;

        public String getAscentT() {
            return ascentT;
        }

        public void setAscentT(String ascentT) {
            this.ascentT = ascentT;
        }

        public String getCompressorNumber() {
            return compressorNumber;
        }

        public void setCompressorNumber(String compressorNumber) {
            this.compressorNumber = compressorNumber;
        }

        public int getCompressorOut1() {
            return compressorOut1;
        }

        public void setCompressorOut1(int compressorOut1) {
            this.compressorOut1 = compressorOut1;
        }

        public int getCompressorOut2() {
            return compressorOut2;
        }

        public void setCompressorOut2(int compressorOut2) {
            this.compressorOut2 = compressorOut2;
        }

        public int getCompressorOut3() {
            return compressorOut3;
        }

        public void setCompressorOut3(int compressorOut3) {
            this.compressorOut3 = compressorOut3;
        }

        public int getCompressorOut4() {
            return compressorOut4;
        }

        public void setCompressorOut4(int compressorOut4) {
            this.compressorOut4 = compressorOut4;
        }

        public String getElementFinT1() {
            return elementFinT1;
        }

        public void setElementFinT1(String elementFinT1) {
            this.elementFinT1 = elementFinT1;
        }

        public String getElementFinT2() {
            return elementFinT2;
        }

        public void setElementFinT2(String elementFinT2) {
            this.elementFinT2 = elementFinT2;
        }

        public String getElementFinT3() {
            return elementFinT3;
        }

        public void setElementFinT3(String elementFinT3) {
            this.elementFinT3 = elementFinT3;
        }

        public String getElementFinT4() {
            return elementFinT4;
        }

        public void setElementFinT4(String elementFinT4) {
            this.elementFinT4 = elementFinT4;
        }

        public String getElementIzumitT1() {
            return elementIzumitT1;
        }

        public void setElementIzumitT1(String elementIzumitT1) {
            this.elementIzumitT1 = elementIzumitT1;
        }

        public String getElementIzumitT2() {
            return elementIzumitT2;
        }

        public void setElementIzumitT2(String elementIzumitT2) {
            this.elementIzumitT2 = elementIzumitT2;
        }

        public int getElementPressState1() {
            return elementPressState1;
        }

        public void setElementPressState1(int elementPressState1) {
            this.elementPressState1 = elementPressState1;
        }

        public int getElementPressState2() {
            return elementPressState2;
        }

        public void setElementPressState2(int elementPressState2) {
            this.elementPressState2 = elementPressState2;
        }

        public int getElementPressState3() {
            return elementPressState3;
        }

        public void setElementPressState3(int elementPressState3) {
            this.elementPressState3 = elementPressState3;
        }

        public int getElementPressState4() {
            return elementPressState4;
        }

        public void setElementPressState4(int elementPressState4) {
            this.elementPressState4 = elementPressState4;
        }

        public String getElementPressTime1() {
            return elementPressTime1;
        }

        public void setElementPressTime1(String elementPressTime1) {
            this.elementPressTime1 = elementPressTime1;
        }

        public String getElementPressTime2() {
            return elementPressTime2;
        }

        public void setElementPressTime2(String elementPressTime2) {
            this.elementPressTime2 = elementPressTime2;
        }

        public String getElementPressTime3() {
            return elementPressTime3;
        }

        public void setElementPressTime3(String elementPressTime3) {
            this.elementPressTime3 = elementPressTime3;
        }

        public String getElementPressTime4() {
            return elementPressTime4;
        }

        public void setElementPressTime4(String elementPressTime4) {
            this.elementPressTime4 = elementPressTime4;
        }

        public String getEnvironmentT() {
            return environmentT;
        }

        public void setEnvironmentT(String environmentT) {
            this.environmentT = environmentT;
        }

        public int getFanOut1() {
            return fanOut1;
        }

        public void setFanOut1(int fanOut1) {
            this.fanOut1 = fanOut1;
        }

        public int getFanOut2() {
            return fanOut2;
        }

        public void setFanOut2(int fanOut2) {
            this.fanOut2 = fanOut2;
        }

        public String getFaultNumber() {
            return faultNumber;
        }

        public void setFaultNumber(String faultNumber) {
            this.faultNumber = faultNumber;
        }

        public String getIzumiT() {
            return izumiT;
        }

        public void setIzumiT(String izumiT) {
            this.izumiT = izumiT;
        }

        public String getLoadOut() {
            return loadOut;
        }

        public void setLoadOut(String loadOut) {
            this.loadOut = loadOut;
        }

        public String getPracticalT() {
            return practicalT;
        }

        public void setPracticalT(String practicalT) {
            this.practicalT = practicalT;
        }

        public String getSettingT() {
            return settingT;
        }

        public void setSettingT(String settingT) {
            this.settingT = settingT;
        }

        public int getSystemState() {
            return systemState;
        }

        public void setSystemState(int systemState) {
            this.systemState = systemState;
        }

        public int getWorkPattern() {
            return workPattern;
        }

        public void setWorkPattern(int workPattern) {
            this.workPattern = workPattern;
        }
    }

    public static class SetConditionPojoBean {
        /**
         * timingCloseH1 : 1
         * timingCloseH2 : 1
         * timingCloseH3 : 1
         * timingCloseM1 : 1
         * timingCloseM2 : 1
         * timingCloseM3 : 1
         * timingOpenH1 : 1
         * timingOpenH2 : 1
         * timingOpenH3 : 1
         * timingOpenM1 : 1
         * timingOpenM2 : 1
         * timingOpenM3 : 1
         */

        private String timingCloseH1;
        private String timingCloseH2;
        private String timingCloseH3;
        private String timingCloseM1;
        private String timingCloseM2;
        private String timingCloseM3;
        private String timingOpenH1;
        private String timingOpenH2;
        private String timingOpenH3;
        private String timingOpenM1;
        private String timingOpenM2;
        private String timingOpenM3;

        public String getTimingCloseH1() {
            return timingCloseH1;
        }

        public void setTimingCloseH1(String timingCloseH1) {
            this.timingCloseH1 = timingCloseH1;
        }

        public String getTimingCloseH2() {
            return timingCloseH2;
        }

        public void setTimingCloseH2(String timingCloseH2) {
            this.timingCloseH2 = timingCloseH2;
        }

        public String getTimingCloseH3() {
            return timingCloseH3;
        }

        public void setTimingCloseH3(String timingCloseH3) {
            this.timingCloseH3 = timingCloseH3;
        }

        public String getTimingCloseM1() {
            return timingCloseM1;
        }

        public void setTimingCloseM1(String timingCloseM1) {
            this.timingCloseM1 = timingCloseM1;
        }

        public String getTimingCloseM2() {
            return timingCloseM2;
        }

        public void setTimingCloseM2(String timingCloseM2) {
            this.timingCloseM2 = timingCloseM2;
        }

        public String getTimingCloseM3() {
            return timingCloseM3;
        }

        public void setTimingCloseM3(String timingCloseM3) {
            this.timingCloseM3 = timingCloseM3;
        }

        public String getTimingOpenH1() {
            return timingOpenH1;
        }

        public void setTimingOpenH1(String timingOpenH1) {
            this.timingOpenH1 = timingOpenH1;
        }

        public String getTimingOpenH2() {
            return timingOpenH2;
        }

        public void setTimingOpenH2(String timingOpenH2) {
            this.timingOpenH2 = timingOpenH2;
        }

        public String getTimingOpenH3() {
            return timingOpenH3;
        }

        public void setTimingOpenH3(String timingOpenH3) {
            this.timingOpenH3 = timingOpenH3;
        }

        public String getTimingOpenM1() {
            return timingOpenM1;
        }

        public void setTimingOpenM1(String timingOpenM1) {
            this.timingOpenM1 = timingOpenM1;
        }

        public String getTimingOpenM2() {
            return timingOpenM2;
        }

        public void setTimingOpenM2(String timingOpenM2) {
            this.timingOpenM2 = timingOpenM2;
        }

        public String getTimingOpenM3() {
            return timingOpenM3;
        }

        public void setTimingOpenM3(String timingOpenM3) {
            this.timingOpenM3 = timingOpenM3;
        }
    }
}
