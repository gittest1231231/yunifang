package bw.ynifang.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import bw.ynifang.R;
import bw.ynifang.view.adapter.DaoHangAdapter;

public class DaoHang extends AppCompatActivity {
    private ViewPager viewPager;
    private int[] imageResource={R.mipmap.dh1,R.mipmap.dh2,R.mipmap.dh3,R.mipmap.dh4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dao_hang);
        SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        boolean login = sharedPreferences.getBoolean("login", false);
        if (login){
            Intent intent = new Intent(DaoHang.this, MainActivity.class);
            startActivity(intent);
        }else{
            initView();
            initData();
        }

    }

    private void initData() {
        viewPager.setAdapter(new DaoHangAdapter(imageResource,DaoHang.this));
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);

    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
