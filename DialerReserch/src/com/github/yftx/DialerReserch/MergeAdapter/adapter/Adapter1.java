package com.github.yftx.DialerReserch.MergeAdapter.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.github.yftx.DialerReserch.MergeAdapter.swipe.SwipeHelper;
import com.github.yftx.DialerReserch.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yftx on 6/13/14.
 * <p/>
 * Adapter1中返回的view可以滑动删除
 */
public class Adapter1 extends BaseAdapter implements IRefresh, SwipeHelper.OnItemGestureListener {
    List<String> mDatas;
    LayoutInflater mInflater;
    private static String PRE_CONTENT = "Adapter1 @ ";
    private static int BG_COLOR = android.R.color.holo_blue_dark;

    public Adapter1(LayoutInflater layoutInflater) {
        mDatas = new ArrayList<String>();
        mInflater = layoutInflater;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.adapter_layout, null, false);
            holder = new ViewHolder();
            holder.content = (TextView) convertView.findViewById(R.id.content);
            holder.container = convertView.findViewById(R.id.container);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.content.setText(PRE_CONTENT + getItem(position));
        holder.container.setBackgroundResource(BG_COLOR);
        SwipeHelper.setSwipeable(convertView, true);
        return convertView;
    }

    @Override
    public void refresh(int num) {
        mDatas.clear();
        for (int count = 0; count < num; count++) {
            mDatas.add(count + "");
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return MergeAdapter.TYPE1;
    }

    @Override
    public void onSwipe(View view) {

    }

    @Override
    public void onTouch() {

    }

    @Override
    public boolean isSwipeEnabled() {
        return true;
    }

    static class ViewHolder {
        TextView content;
        View container;
    }


}
