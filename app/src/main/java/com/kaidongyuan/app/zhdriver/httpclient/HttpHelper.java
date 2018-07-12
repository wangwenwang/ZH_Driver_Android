package com.kaidongyuan.app.zhdriver.httpclient;

import com.kaidongyuan.app.basemodule.widget.MLog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

public class HttpHelper {

    public  static String GetHttpRequest(String Url, String Params, String Method)
    {
        OutputStream out = null;   //写
        InputStream in = null;     //读
        int httpStatusCode = 0;  //远程主机响应的 HTTP 状态码
        java.net.URL myUrl = null;
        HttpURLConnection httpURLConnection = null;
        try {
            myUrl = new java.net.URL(Url);
        }catch (MalformedURLException e)
        {
            e.printStackTrace();
        }

        try {
            httpURLConnection = (HttpURLConnection) myUrl.openConnection();
            httpURLConnection.setRequestProperty("Accept", "application/json");  //设置接收数据的格式
            httpURLConnection.setRequestMethod(Method.toUpperCase());
            httpURLConnection.setDoOutput(true);       //指示应用程序要将数据写入URL连接,其值默认为false
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(30000);  //30秒连接超时
            httpURLConnection.setReadTimeout(30000);     //30秒读取超时

            out = httpURLConnection.getOutputStream();
            out.write(Params.getBytes());

            //清空缓冲区,发送数据
            out.flush();

            //获取HTTP 状态码
            httpStatusCode = httpURLConnection.getResponseCode();

            in = httpURLConnection.getInputStream();

            //获取响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String result = "";
            String line;
            while ((line = reader.readLine()) != null){
                result += line;
            }
            reader.close();

            return  result;
        } catch (IOException ex){
            ex.printStackTrace();
        } finally {
            if (in != null){
               try {
                  in.close();
               }catch (Exception e){
                   MLog.w("关闭输入流时发生异常,堆栈信息如下:" + e);
               }
            }
            if (out != null){
               try {
                  out.close();
               }catch (Exception ex){
                   MLog.w("关闭输出流时发生异常,堆栈信息如下:" + ex);
               }
            }
            if (httpURLConnection != null){
                httpURLConnection.disconnect();
                httpURLConnection = null;
            }
        }

        return "";
    }


    //GCJ-02=>BD09 火星(谷歌,高德,腾讯)坐标系=>百度坐标系
    public static double[] gcj2BD09(double glat, double glon)
    {
        double PI = Math.PI;
        double X_PI = PI * 3000.0 / 180.0;

        double x = glon;
        double y = glat;
        double[] latlon = new double[2];
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * X_PI);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * X_PI);
        latlon[0] = z * Math.sin(theta) + 0.006;
        latlon[1] = z * Math.cos(theta) + 0.0065;
        return latlon;
    }

}
