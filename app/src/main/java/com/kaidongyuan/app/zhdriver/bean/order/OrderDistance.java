package com.kaidongyuan.app.zhdriver.bean.order;

//订单距离,目标地址距离
public class OrderDistance implements java.io.Serializable {
    private Double CURRENT_LOCATION_LON;
    private Double CURRENT_LOCATION_LAT;
    private String IDX;
    private String ORDER_IDX;
    private Double DISTANCE_LOCATION_LON;
    private Double DISTANCE_LOCATION_LAT;
    private String DISTANCE_ADDRESS;            //目标地址
    private String REMAIN_DIS;                   //距离目标地址距离,单位:米


    public String getREMAIN_DIS() {
        return REMAIN_DIS;
    }

    public void setREMAIN_DIS(String REMAIN_DIS) {
        this.REMAIN_DIS = REMAIN_DIS;
    }

    public Double getCURRENT_LOCATION_LAT() {
        return CURRENT_LOCATION_LAT;
    }

    public String getIDX() {
        return IDX;
    }

    public String getORDER_IDX() {
        return ORDER_IDX;
    }

    public Double getDISTANCE_LOCATION_LON() {
        return DISTANCE_LOCATION_LON;
    }

    public Double getDISTANCE_LOCATION_LAT() {
        return DISTANCE_LOCATION_LAT;
    }

    public String getDISTANCE_ADDRESS() {
        return DISTANCE_ADDRESS;
    }

    public void setCURRENT_LOCATION_LAT(Double CURRENT_LOCATION_LAT) {
        this.CURRENT_LOCATION_LAT = CURRENT_LOCATION_LAT;
    }

    public void setIDX(String IDX) {
        this.IDX = IDX;
    }

    public void setORDER_IDX(String ORDER_IDX) {
        this.ORDER_IDX = ORDER_IDX;
    }

    public void setDISTANCE_LOCATION_LON(Double DISTANCE_LOCATION_LON) {
        this.DISTANCE_LOCATION_LON = DISTANCE_LOCATION_LON;
    }

    public void setDISTANCE_LOCATION_LAT(Double DISTANCE_LOCATION_LAT) {
        this.DISTANCE_LOCATION_LAT = DISTANCE_LOCATION_LAT;
    }

    public void setDISTANCE_ADDRESS(String DISTANCE_ADDRESS) {
        this.DISTANCE_ADDRESS = DISTANCE_ADDRESS;
    }


    public Double getCURRENT_LOCATION_LON() {
        return CURRENT_LOCATION_LON;
    }

    public void setCURRENT_LOCATION_LON(Double CURRENT_LOCATION_LON) {
        this.CURRENT_LOCATION_LON = CURRENT_LOCATION_LON;
    }

}
