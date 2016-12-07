package bw.ynifang.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import bw.ynifang.R;
import bw.ynifang.view.adapter.ShouYeAdapter;

/**
 * Author：ZhaoTieJin
 * date :  2016/12/5
 */

public class MainFragment_1 extends Fragment {
    private String[] imageResource={"http://pic33.nipic.com/20130916/3420027_192919547000_2.jpg","http://pic33.nipic.com/20130916/3420027_192919547000_2.jpg","http://pic33.nipic.com/20130916/3420027_192919547000_2.jpg",
            "http://pic33.nipic.com/20130916/3420027_192919547000_2.jpg","http://pic33.nipic.com/20130916/3420027_192919547000_2.jpg",
            "http://pic33.nipic.com/20130916/3420027_192919547000_2.jpg","http://pic33.nipic.com/20130916/3420027_192919547000_2.jpg","http://pic33.nipic.com/20130916/3420027_192919547000_2.jpg"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_activity_1,null);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ViewPager shouYe_viewPager= (ViewPager) getView().findViewById(R.id.shouYe_viewPager);
        ArrayList<Fragment> list=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            ShouYeFragment shouYeFragment = new ShouYeFragment();
            ShouYeFragment fragment = shouYeFragment.instance(imageResource[i]);
            list.add(fragment);
        }
        shouYe_viewPager.setAdapter(new ShouYeAdapter(getActivity().getSupportFragmentManager(),list));
    }
}
