package bw.ynifang.view.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/6.
 */

public class ShouYeAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> list;
    public ShouYeAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list=list;
    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment = list.get(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
