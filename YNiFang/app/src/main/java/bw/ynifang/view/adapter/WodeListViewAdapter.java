package bw.ynifang.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import bw.ynifang.R;
import bw.ynifang.view.activity.MainActivity;

/**
 * Author：ZhaoTieJin
 * date :  2016/12/6
 */


public class WodeListViewAdapter extends BaseAdapter {
    private final Context context;
    private final int[] imageId;
    private final ArrayList<String> list;

    public WodeListViewAdapter(Context context, int[] imageId, ArrayList<String> list) {
        this.context = context;
        this.imageId = imageId;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = View.inflate(context, R.layout.listview_wode_item, null);
        }
        //连接到控件
        ImageView listView_wode_item_leftImage = (ImageView) view.findViewById(R.id.listView_wode_item_leftImage);
        TextView listView_wode_item_tv = (TextView) view.findViewById(R.id.listView_wode_item_tv);
        //设置显示内容
        listView_wode_item_leftImage.setImageResource(imageId[i]);
        listView_wode_item_tv.setText(list.get(i));
        return view;
    }
}
