package bw.ynifang.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import bw.ynifang.R;

/**
 * Author：ZhaoTieJin
 * date :  2016/12/6
 */

public class LoginActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //初始化界面
        initView();
    }

    //初始化界面
    private void initView() {
        //连接到控件
        ImageView image_login_back = (ImageView) findViewById(R.id.image_login_back);
        //设置点击事件
        image_login_back.setOnClickListener(this);
    }

    //点击时间的方法
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_login_back:
                finish();
                break;
            default:
                break;
        }
    }
}
