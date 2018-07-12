package com.kaidongyuan.app.zhdriver.constants;

import android.os.Environment;

import java.security.PublicKey;

/**
 * 存储一些关于服务器地址的常量信息
 *
 */
public class Constants {
    /*
    *  定时多长时间更新订单距离目标地址距离
    */
    public  static  int distanceInterval = 1000 * 60 * 10;
    /**
     *  发起定位请求的间隔时间
     */
    //public static int scanSpan = 1000 * 60 * 10;
    //10分钟
    public static int scanSpan = 1000 * 60 * 10;
    // 提交坐标的时间间隔
    public final static int submitSpan = 10 * 60 * 1000;
    /**
     * 验证码发送时间间隔
     */
    public final static long verifyInterval = 60 * 1000;
    /**
     * 错误信息保存路径
     */
    public static final String LOG_SAVE_PATH = Environment
            .getExternalStorageDirectory().toString() + "/com.kdy/";
    /**
     * 版本更新
     */
    public static final String VERSINO_UPDATE_ACTION = "com.kdy.VersionUpdateAction";
    public static final long ENT_IDX = 9008;
    public static final long BUSINESS_IDX = 7;
    /**
     * MainActivity 中传给 TrackingService 对象用的 key
     */
    public static final String APPCONTEXT_KEY = "com.kaidongyuan.driver.APPCONTEXT_KEY";
    /**
     *@auther: Tom
     *created at 2016/6/2 13:57
     *app基本信息数据
     */
    public static final String BasicInfo="dataBases.BasicInfo";
    public static final String IsUsedApp="isusedapp";
    public static final String UserName="userName";
    public static final String UserPWD="userPwd";
    public static final String UserCode="useCode";
    public static final String UserType="useType";
    public class URL {
        //高德WEBAPI,用于通过地址可以获取经度纬度
        public static final String Gao_De_Web_Url = "http://restapi.amap.com/v3/geocode/geo?";

        //        public static final String Base_Url = "http://192.168.11.19/api/";
        public static final String Test_Url = "http://192.168.11.13/api/";
        //		public static final String Load_Url = "http://192.168.11.19/";
        public static final String LoadVersion_Url = "http://120.77.205.81:89/";   //正式的要打开
        //public static final String LoadVersion_Url = "http://192.168.1.193:89/";    //测试的要注释

        public static final String Load_Url="http://oms.zhaohangwuliu.com:8088/";
        // public static final String Base_Url = "http://oms.zhaohangwuliu.com:8088/api/";

        public static final String Base_Url = "http://120.77.205.81:89/api/"; //正式环境要打开
        //public static final String Base_Url = "http://192.168.1.193:89/api/"; //测试的要注释

        //public static final String Base_Url = "http://192.168.2.253:7001/api/"; //本地wifi

        public static final String register="http://oms.zhaohangwuliu.com:13500/api/"+"register";//注册
        public static final String Login = Base_Url + "Login";//登录
        public static final String ModifyPassword = Base_Url + "modifyPassword";//修改密码
        public static final String GetPartyList = Base_Url + "GetPartyList";//获取客户列表
        public static final String GetAddress = Base_Url + "GetAddress";//获取地址列表
        public static final String GetProductList = Base_Url + "GetProductList";//获取产品列表
        public static final String SubmitOrder = Base_Url + "SubmitOrder";//最终提交订单	需要传客户地址的 IDX，产品的 IDX
        public static final String GetOrderList = Base_Url + "GetOrderList";//获取订单列表
        public static final String GetOrderDetail = Base_Url + "GetOrderDetail";//获取订单详情
        public static final String SubmitOrder1 = Base_Url + "SubmitOrder1";//提交获取促销信息
        public static final String ConfirmOrder = Base_Url + "ConfirmOrder";//最终提交订单
        public static final String GetPaymentType = Base_Url + "GetPaymentType";//获取付款方式 post strLicense  过来就行了
        //郑毅增加
        public static final String GetAppLocationListByOrderIdxs = Base_Url + "GetAppLocationListByOrderIdxs";//通过 ORDER_IDX 集合获取 APP_LOCATION 表信息
        //郑毅增加
        public static final String UpdateAppLocationList = Base_Url + "UpdateAppLocationList"; //更新 APP_LOCATION 表中 REMAIN_DIS

        // 提交订单时 把 KEY 值 送过来
        public static final String GetPartySalePolicy = Base_Url + "GetPartySalePolicy";
        //		public static final String Information = Base_Url + "Information";
        //      public static final String Information = "http://oms.zhaohangwuliu.com:8088/api/" + "Information";
        //      public static final String Information = "http://192.168.11.13/api/" + "Information";
        //      public static final String GetNewDetail = "http://192.168.11.13/api/" + "GetNewDetail";
        public static final String Information = Base_Url + "Information";
        //获取用户推送消息列表和内容
        public static final String GetMessage=Base_Url+"GetMessage";
        public static final String GetMessageDetils=Base_Url+"GetMessageDetils";
        public static final String GetNewDetail = Base_Url + "GetNewDetail";
        // GetNewDetail
        // 获取定位轨迹：GetPosition
        // 参数strPhone, strLicense
        public static final String GetPosition = "http://192.168.11.13/api/" + "GetPosition";
        // 开启定位：AddPosition
        // 参数 strUserId， strStatus， strPosition， strLicense
        /**
         *
         // <param name="userId">用户ID</param>
         /// <param name="status">状态</param>
         /// <param name="positionlng">经度</param>
         /// <param name="positionlat">纬度</param>
         Position(string userId, string status, string positionlng, string positionlat)
         */
//        public static final String UploadPosition = "http://192.168.11.13/api/" + "UploadPosition";
        public static final String UploadPosition = Base_Url + "UploadPosition";
        /**
         * strUserIdx
         * cordinateX
         * cordinateY
         * address
         * strLicense
         */
//        public static final String CurrentLocaltion = Test_Url + "CurrentLocaltion";
        public static final String CurrentLocaltion = Base_Url + "CurrentLocaltion";
        public static final String CurrentLocationList = Base_Url + "CurrentLocaltionList";
        /**
         * 获取报表
         * string strUserId = Request["strUserId"].ToString();用户ID
         string strLicense = Request["strLicense"].ToString();strLicense
         */
//        public static final String CustomerCount = "http://192.168.11.13/api/" + "CustomerCount";
        public static final String CustomerCount = Base_Url + "CustomerCount";
//        public static final String ProductCount = "http://192.168.11.13/api/" + "ProductCount";
        public static final String ProductCount = Base_Url + "ProductCount";
        /**
         * 获取物流信息列表
         * strOrderId
         */
        public static final String GetOrderTmsList = Base_Url + "GetOrderTmsList";
//        public static final String GetOrderTmsList = Test_Url + "GetOrderTmsList";
        /**
         * 获取物流信息详情
         */
//        public static final String GetOrderTmsInfo = Test_Url + "GetOrderTmsInfo";
        public static final String GetOrderTmsInfo = Base_Url + "GetOrderTmsOrderNoInfo";
        /**
         * 获取司机订单列表
         */
//        public static final String GetDriverOrderList = Test_Url + "GetDriverOrderList";
        public static final String GetDriverOrderList = Base_Url + "GetDriverOrderList";
        public static final String GetDriverDateOrderList=Base_Url+"GetDriverDateOrderList";
        public static final String GetDriverDateOrderClientList= Base_Url+"GetDriverDateOrderClientList";
        /**
         * 交付
         * strOrderIdx  strLicense
         */
//      public static final String DriverPay = Test_Url + "DriverPay";
        public static final String DriverPay = Base_Url + "DriverPay";
        /**
         *@auther: Tom
         *created at 2016/11/3 16:23
         * 交付 新加strDeliveNo 回单单号字段
         */
        public static final String DelivePay=Base_Url+"DelivePay";
        /**
         * 获取订单位置信息
         * strOrderIdx  strLicense
         */
//        public static final String GetLocaltion = Test_Url + "GetLocaltion";
        public static final String GetLocaltion = Base_Url + "GetLocaltion";
        /**
         * 获取最新版本 app 信息
         */
        public static final String CheckVersion = Base_Url + "GetVersion";
        /**
         * 获取货物轨迹信息
         */
        public static final String OrderTrackCheck = Base_Url + "GetLocaltionForOrdNo";
        /**
         * 获取电子签名和交货现场图片
         */
        public static final String GETAUTOGRAPH = Base_Url + "GetAutograph";
        /**
         * 增加的装运订单计费明细
         */
        public static final String GetPrice=Base_Url+"GetPrice";
        /**
         * 推送功能，上传CID UserID
         */
        public static final String SavaPushToken=Base_Url+"SavaPushToken";
        /**
         * 2.4 获取装运编号下属指定状态订单列表
         */
        public static final String GetShipmentUnPayOrderList=Base_Url+"GetShipmentUnPayOrderList";
        /**
         * 2.5 订单批量交付
         */
        public static final String DriverListPay=Base_Url+"DriverListPay";
    }

}
