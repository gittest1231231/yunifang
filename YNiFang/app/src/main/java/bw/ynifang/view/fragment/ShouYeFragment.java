package bw.ynifang.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import bw.ynifang.R;

/**
 * Created by Administrator on 2016/12/7.
 */

public class ShouYeFragment extends Fragment {

    private String string;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        string = bundle.getString("String");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shouye_viewpager_item, container, false);
        ImageView iv = (ImageView) view.findViewById(R.id.shouYe_viewPager_item_iv);
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(string,iv);
        return view;

    }
    public ShouYeFragment instance(String string){
        ShouYeFragment shouYeFragment = null;
        if (shouYeFragment==null){
            shouYeFragment = new ShouYeFragment();
        }
        Bundle bundle = new Bundle();
        bundle.putString("String",string);
        shouYeFragment.setArguments(bundle);
        return shouYeFragment;
    }
}
