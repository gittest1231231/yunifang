package bw.ynifang.view.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import bw.ynifang.R;
import bw.ynifang.view.activity.LoginActivity;
import bw.ynifang.view.activity.MainActivity;
import bw.ynifang.view.activity.SetActivity;
import bw.ynifang.view.adapter.WodeListViewAdapter;

import static bw.ynifang.R.id.image_3;
import static bw.ynifang.R.id.tv_3;
import static bw.ynifang.R.id.viewPager;

/**
 * Author：ZhaoTieJin
 * date :  2016/12/5
 */

public class MainFragment_4 extends Fragment implements View.OnClickListener {

    private ImageView image_setting;
    private ImageView image_login;
    private Button bt_login;
    private LinearLayout ll_wait_1;
    private LinearLayout ll_wait_2;
    private LinearLayout ll_wait_3;
    private LinearLayout ll_wait_4;
    private LinearLayout ll_wait_5;
    private ListView listView_wode;
    private MainActivity activity;
    private int[] imageId;
    private ArrayList<String> list_item_textview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //获得本fragment所依附的activity
        activity = (MainActivity) getActivity();
        //设置本fragment的布局
        View view = View.inflate(activity, R.layout.fragment_activity_4, null);
        //初始化界面
        inintView(view);
        //初始化界面数据
        initData();
        //ListView设置适配器
        WodeListViewAdapter wodeListViewAdapter = new WodeListViewAdapter(activity, imageId, list_item_textview);
        listView_wode.setAdapter(wodeListViewAdapter);
        return view;
    }

    //初始化界面数据
    private void initData() {
        //listview条目图片数组
        imageId = new int[]{R.drawable.my_order_icon, R.drawable.my_invite_gift_icon,
                R.drawable.my_face_test_icon, R.drawable.my_coupon_icon,
                R.drawable.my_lottery_icon, R.drawable.my_collection_icon,
                R.drawable.personal_center_contact_service_icon};
        //listview显示文字的集合
        String[] tv_content = {"我的订单", "邀请有礼", "刷脸测尺寸", "我的现金券", "我的抽奖单",
                "我收藏的商品", "联系客服"};
        list_item_textview = new ArrayList<>();
        for (int i = 0; i < tv_content.length; i++) {
            list_item_textview.add(tv_content[i]);
        }
/*        //listview显示文字的集合
        list_item_textview = new ArrayList<>();
        list_item_textview.add("我的订单");
        list_item_textview.add("邀请有礼");
        list_item_textview.add("刷脸测尺寸");
        list_item_textview.add("我的现金券");
        list_item_textview.add("我的抽奖单");
        list_item_textview.add("我收藏的商品");
        list_item_textview.add("联系客服");*/
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //ListView设置条目点击事件
        listView_wode.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                jumpNext(0);
            }
        });
    }

    //初始化界面
    private void inintView(View view) {
        //连接到控件
        image_setting = (ImageView) view.findViewById(R.id.image_setting);
        image_login = (ImageView) view.findViewById(R.id.image_login);
        bt_login = (Button) view.findViewById(R.id.bt_login);
        ll_wait_1 = (LinearLayout) view.findViewById(R.id.ll_wait_1);
        ll_wait_2 = (LinearLayout) view.findViewById(R.id.ll_wait_2);
        ll_wait_3 = (LinearLayout) view.findViewById(R.id.ll_wait_3);
        ll_wait_4 = (LinearLayout) view.findViewById(R.id.ll_wait_4);
        ll_wait_5 = (LinearLayout) view.findViewById(R.id.ll_wait_5);
        listView_wode = (ListView) view.findViewById(R.id.listView_wode);
        //控件设置点击事件
        image_setting.setOnClickListener(this);
        image_login.setOnClickListener(this);
        bt_login.setOnClickListener(this);
        ll_wait_1.setOnClickListener(this);
        ll_wait_2.setOnClickListener(this);
        ll_wait_3.setOnClickListener(this);
        ll_wait_4.setOnClickListener(this);
        ll_wait_5.setOnClickListener(this);
    }

    //点击事件的方法
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_setting:
                //跳转至设置界面
                Intent intent = new Intent(activity, SetActivity.class);
                startActivity(intent);
                //设置跳转动画
                activity.overridePendingTransition(R.anim.enter, R.anim.exit);
                break;
            case R.id.image_login:

                break;
            case R.id.bt_login:

                break;
            case R.id.ll_wait_1:
                jumpNext(R.id.ll_wait_1);
                break;
            case R.id.ll_wait_2:

                break;
            case R.id.ll_wait_3:

                break;
            case R.id.ll_wait_4:

                break;
            case R.id.ll_wait_5:

                break;
            default:
                break;
        }
    }

    private void jumpNext(int i) {
        //根据是否登录，判断跳转至登录界面，还是自身对应的界面
        SharedPreferences sharedPreferences = activity.getSharedPreferences("test", activity.MODE_PRIVATE);
        if (sharedPreferences.getBoolean("isLogin", false)) {

        } else {
            //跳转至登录界面
            Intent intent = new Intent(activity, LoginActivity.class);
            startActivity(intent);
            //设置跳转动画
            activity.overridePendingTransition(R.anim.enter, R.anim.exit);
        }
    }

}
