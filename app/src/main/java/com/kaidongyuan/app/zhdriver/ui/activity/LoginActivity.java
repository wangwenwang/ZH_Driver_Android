package com.kaidongyuan.app.zhdriver.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import com.kaidongyuan.app.basemodule.interfaces.AsyncHttpCallback;
import com.kaidongyuan.app.basemodule.utils.nomalutils.Des3;
import com.kaidongyuan.app.basemodule.widget.MLog;
import com.kaidongyuan.app.basemodule.widget.SlidingTitleView;
import com.kaidongyuan.app.zhdriver.R;
import com.kaidongyuan.app.zhdriver.app.AppContext;
import com.kaidongyuan.app.zhdriver.app.AppManager;
import com.kaidongyuan.app.zhdriver.bean.order.User;
import com.kaidongyuan.app.zhdriver.constants.Constants;
import com.kaidongyuan.app.zhdriver.httpclient.OrderAsyncHttpClient;
import com.kaidongyuan.app.zhdriver.ui.base.BaseActivity;
import com.kaidongyuan.app.zhdriver.utils.SharedPreferencesUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2016/6/2.
 */
public class LoginActivity extends BaseActivity implements AsyncHttpCallback, View.OnClickListener{
    private SlidingTitleView tilteView;
    private EditText username_edit;
    private EditText userpsw_edit;
    private Button login_bn;
    private final String LOGIN = "login";
    private String name, pwd;
    private OrderAsyncHttpClient mClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        tilteView= (SlidingTitleView) findViewById(R.id.title_view_login);
        tilteView.setMode(SlidingTitleView.MODE_NULL);
        tilteView.setText(getString(R.string.login_now));
        username_edit= (EditText) findViewById(R.id.user_name_edit);
        userpsw_edit= (EditText) findViewById(R.id.user_psw_edit);
        if (SharedPreferencesUtils.getValueByName(Constants.BasicInfo,Constants.IsUsedApp,2)){
            username_edit.setText((CharSequence) SharedPreferencesUtils.getValueByName(Constants.BasicInfo, Constants.UserName, 0));
            String strpwd=SharedPreferencesUtils.getValueByName(Constants.BasicInfo,Constants.UserPWD,0);
            try {
                userpsw_edit.setText((CharSequence) Des3.decode(strpwd));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        login_bn= (Button) findViewById(R.id.login_btn);
        login_bn.setOnClickListener(this);
        mClient = new OrderAsyncHttpClient(this, this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_btn: login();
                break;
        }
    }

    private void login() {
        name=username_edit.getText().toString().trim();
        pwd=userpsw_edit.getText().toString().trim();
        if (name.equals("")){
            showToastMsg("请输入用户名~");
            return;
        }
        if (pwd.equals("")){
            showToastMsg("请输入密码~");
            return;
        }
        Map<String,String>params=new HashMap<>();
        params.put("strUserName",name);
        params.put("strPassword",pwd);
//        params.put("UserType","Driver");
//        params.put("CompanyName","CompanyName");
//        params.put("UserName","UserName");
//        params.put("Address","Address");
        params.put("strLicense", "");
        mClient.sendRequest(Constants.URL.Login, params, LOGIN);
    }

    public void saveSharedData(){
        SharedPreferencesUtils.WriteSharedPreferences(Constants.BasicInfo,Constants.UserName,name);
        try {
            SharedPreferencesUtils.WriteSharedPreferences(Constants.BasicInfo,Constants.UserPWD, Des3.encode(pwd));
        } catch (Exception e) {
            e.printStackTrace();
        }
        SharedPreferencesUtils.WriteSharedPreferences(Constants.BasicInfo,Constants.IsUsedApp,true);


//        SharedPreferences sharedPreferences = getSharedPreferences(SharedPreferencesUtils.SHARED_NAME, MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();//获取编辑器
//        editor.putString("name", name);
//        editor.putString("pwd", pwd);
//        //2016.6.6 陈翔 注销掉登录的角色类型“司机”、“客户”
//        //   editor.putString("roleNames", tv_select_role.getText().toString().trim());
//        editor.apply();//提交修改
    }

    @Override
    protected void onDestroy() {
        mClient.cancleRequest(LOGIN);
        super.onDestroy();
    }

    @Override
    public void postSuccessMsg(String msg, String request_tag) {
        synchronized (LoginActivity.this) {
            MLog.w("登录返回结果:"+ msg);
            if (msg.equals("error")) return;
            if (request_tag.equals(LOGIN) && !AppContext.IS_LOGIN) {

                JSONObject jo = JSON.parseObject(msg);
                try {
                    List<User> user = JSON.parseArray(jo.getString("result"), User.class);
                    MLog.e("user.size():" + user.size() + "IDX:" + user.get(0).getIDX());
                    if (user.size() > 0) {
                        user.get(0).setUSER_CODE(username_edit.getText().toString().trim());
                        //   MLog.e("User:"+user.get(0).getIDX());
                        AppContext.getInstance().setUser(user.get(0));
                        AppContext.IS_LOGIN = true;
                    }
                    saveSharedData();
                    SharedPreferencesUtils.saveUserId(AppContext.getInstance().getUser().getIDX());
                    AppManager.getAppManager().finishActivity(MainActivity.class);
                    // startActivity(new Intent(this, MainActivity.class));
                    mStartActivity(MainActivity.class);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}

