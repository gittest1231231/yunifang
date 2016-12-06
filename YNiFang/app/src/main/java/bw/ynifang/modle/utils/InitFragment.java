package bw.ynifang.modle.utils;

import android.support.v4.app.Fragment;

import java.util.ArrayList;

import bw.ynifang.view.fragment.MainFragment_1;
import bw.ynifang.view.fragment.MainFragment_2;
import bw.ynifang.view.fragment.MainFragment_3;
import bw.ynifang.view.fragment.MainFragment_4;

/**
 * Author：ZhaoTieJin
 * date :  2016/12/6
 */

public class InitFragment {

    public static ArrayList<Fragment> getFragment(){
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new MainFragment_1());
        list.add(new MainFragment_2());
        list.add(new MainFragment_3());
        list.add(new MainFragment_4());
        return list;
    }
}
