package bw.ynifang.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import bw.ynifang.R;
import bw.ynifang.modle.utils.InitFragment;
import bw.ynifang.view.adapter.MainAdapter;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private LinearLayout ll_1;
    private LinearLayout ll_2;
    private LinearLayout ll_3;
    private LinearLayout ll_4;
    private ImageView image_1;
    private ImageView image_2;
    private ImageView image_3;
    private ImageView image_4;
    private TextView tv_1;
    private TextView tv_2;
    private TextView tv_3;
    private TextView tv_4;
    private ArrayList<ImageView> list_iamgeview;
    private ArrayList<TextView> list_textview;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //得到轻量级储存器
        sharedPreferences = getSharedPreferences("test", MODE_PRIVATE);
        //获得编译器
        editor = sharedPreferences.edit();
        //设置标识，标记是否已经登录，首次使用默认false
        editor.putBoolean("isLogin",false);
        //初始化界面
        initView();
        //初始化数据
        ArrayList<Fragment> list_fragment = initData();
        //ViewPager设置适配器
        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager(), list_fragment);
        viewPager.setAdapter(mainAdapter);

    }

    //初始化数据
    private ArrayList<Fragment> initData() {
        ArrayList<Fragment> list = InitFragment.getFragment();
        return list;
    }

    //初始化界面
    private void initView() {
        //连接到控件
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        ll_1 = (LinearLayout) findViewById(R.id.ll_1);
        ll_2 = (LinearLayout) findViewById(R.id.ll_2);
        ll_3 = (LinearLayout) findViewById(R.id.ll_3);
        ll_4 = (LinearLayout) findViewById(R.id.ll_4);
        image_1 = (ImageView) findViewById(R.id.image_1);
        image_2 = (ImageView) findViewById(R.id.image_2);
        image_3 = (ImageView) findViewById(R.id.image_3);
        image_4 = (ImageView) findViewById(R.id.image_4);
        //把图片放到集合
        list_iamgeview = new ArrayList<>();
        list_iamgeview.add(image_1);
        list_iamgeview.add(image_2);
        list_iamgeview.add(image_3);
        list_iamgeview.add(image_4);
        tv_1 = (TextView) findViewById(R.id.tv_1);
        tv_2 = (TextView) findViewById(R.id.tv_2);
        tv_3 = (TextView) findViewById(R.id.tv_3);
        tv_4 = (TextView) findViewById(R.id.tv_4);
        //把导航名放到集合
        list_textview = new ArrayList<>();
        list_textview.add(tv_1);
        list_textview.add(tv_2);
        list_textview.add(tv_3);
        list_textview.add(tv_4);
        //导航栏设置点击事件
        ll_1.setOnClickListener(this);
        ll_2.setOnClickListener(this);
        ll_3.setOnClickListener(this);
        ll_4.setOnClickListener(this);
    }

    //点击事件
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_1:
                //更改导航栏
                changePager(image_1, tv_1);
                //切换界面
                viewPager.setCurrentItem(0);
                break;
            case R.id.ll_2:
                changePager(image_2, tv_2);
                viewPager.setCurrentItem(1);
                break;
            case R.id.ll_3:
                //根据是否登录，判断切换viewpager页面还是跳转
                if (sharedPreferences.getBoolean("isLogin",false)){
                    changePager(image_3, tv_3);
                    viewPager.setCurrentItem(2);
                }else {
                    //跳转至登录界面
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    //设置跳转动画
                    overridePendingTransition(R.anim.enter,R.anim.exit);
                }
                break;
            case R.id.ll_4:
                changePager(image_4, tv_4);
                viewPager.setCurrentItem(3);
                break;
            default:

                break;
        }
    }

    //点击导航栏更改背景图片及字体颜色
    private void changePager(ImageView image, TextView tv) {
        //更改图片背景
        for (int i = 0; i < list_iamgeview.size(); i++) {
            list_iamgeview.get(i).setSelected(false);
        }
        image.setSelected(true);
        //更改字体颜色
        for (int i = 0; i < list_textview.size(); i++) {
            list_textview.get(i).setTextColor(Color.GRAY);
        }
        tv.setTextColor(Color.RED);
    }
}
