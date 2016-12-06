package bw.ynifang.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import bw.ynifang.R;
import bw.ynifang.view.activity.MainActivity;

/**
 * Created by Administrator on 2016/12/6.
 */

public class DaoHangAdapter extends PagerAdapter {
    private final int[] imageResource;
    private final Context context;

    public DaoHangAdapter(int[] imageResource, Context context) {

        this.imageResource = imageResource;
        this.context = context;
    }
    @Override
    public int getCount() {
        return imageResource.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(context, R.layout.daohang_item, null);
        ImageView iv = (ImageView) view.findViewById(R.id.daohang_item_iv);
        TextView tv = (TextView) view.findViewById(R.id.daoHang_tv);
        tv.setVisibility(View.GONE);
        if(position==3){
            tv.setVisibility(View.VISIBLE);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("user", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putBoolean("login",true);
                    edit.commit();
                    Intent intent = new Intent(context, MainActivity.class);
                    context.startActivity(intent);
                }
            });
        }

        iv.setImageResource(imageResource[position]);
        container.addView(view);
        return view;
    }
}
