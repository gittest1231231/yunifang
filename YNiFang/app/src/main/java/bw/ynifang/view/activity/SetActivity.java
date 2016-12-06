package bw.ynifang.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import bw.ynifang.R;

/**
 * Author：ZhaoTieJin
 * date :  2016/12/6
 */

public class SetActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        //初始化界面
        initView();
    }

    //初始化界面
    private void initView() {
        //连接到控件
        ImageView image_set_back = (ImageView) findViewById(R.id.image_set_back);
        LinearLayout ll_set_1 = (LinearLayout) findViewById(R.id.ll_set_1);
        LinearLayout ll_set_2 = (LinearLayout) findViewById(R.id.ll_set_2);
        LinearLayout ll_set_3 = (LinearLayout) findViewById(R.id.ll_set_3);
        LinearLayout ll_set_4 = (LinearLayout) findViewById(R.id.ll_set_4);
        LinearLayout ll_set_5 = (LinearLayout) findViewById(R.id.ll_set_5);
        LinearLayout ll_set_6 = (LinearLayout) findViewById(R.id.ll_set_6);
        //设置点击事件
        image_set_back.setOnClickListener(this);
        ll_set_1.setOnClickListener(this);
        ll_set_2.setOnClickListener(this);
        ll_set_3.setOnClickListener(this);
        ll_set_4.setOnClickListener(this);
        ll_set_5.setOnClickListener(this);
        ll_set_6.setOnClickListener(this);
    }

    //点击时间的方法
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_set_back:
                finish();
                break;
            case R.id.ll_set_1:
                Toast.makeText(SetActivity.this, "购物须知", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_set_2:
                Toast.makeText(SetActivity.this, "意见反馈", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_set_3:
                Toast.makeText(SetActivity.this, "清除缓存", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_set_4:
                Toast.makeText(SetActivity.this, "关于我们", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_set_5:
                Toast.makeText(SetActivity.this, "拨打电话", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_set_6:
                Toast.makeText(SetActivity.this, "检测更新", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
