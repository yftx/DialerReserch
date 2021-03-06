package com.github.yftx.DialerReserch.MergeAdapter.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.github.yftx.DialerReserch.MergeAdapter.swipe.SwipeHelper;
import com.github.yftx.DialerReserch.MergeAdapter.swipe.SwipeLayout;

/**
 * Created by yftx on 6/13/14.
 */
public class MergeAdapter extends BaseAdapter {
    /**
     * 该Adapter显示样式为先显示Adapter1 后显示Adapter2
     */

    Adapter1 mAdapter1;
    Adapter2 mAdapter2;
    DataSetObserver mObserver;
    Context mContext;

    //typeid 必须从0开始基数
    public static final int TYPE1 = 0;
    public static final int TYPE2 = 1;


    public MergeAdapter(Context context, Adapter1 adapter1, Adapter2 adapter2) {
        mContext = context;
        mAdapter1 = adapter1;
        mAdapter2 = adapter2;
        mObserver = new CustomObserver();
        mAdapter1.registerDataSetObserver(mObserver);
        mAdapter2.registerDataSetObserver(mObserver);
    }

    @Override
    public int getCount() {
        return mAdapter1.getCount() + mAdapter2.getCount();
    }

    @Override
    public Object getItem(int position) {
        if (position < mAdapter1.getCount()) {
            return mAdapter1.getItem(position);
        } else {
            return mAdapter2.getItem(getAdustPostion(position));
        }
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public int getItemViewType(int position) {
        return position < mAdapter1.getCount() ?
                mAdapter1.getItemViewType(getAdustPostion(position)) : mAdapter2.getItemViewType(getAdustPostion(position));
    }


    @Override
    public int getViewTypeCount() {
        return mAdapter1.getViewTypeCount() + mAdapter2.getViewTypeCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        switch (type) {
            case TYPE1:
                //adapter1中的view可以滑动删除
                final SwipeLayout wrapper;
                if (convertView == null) {
                    wrapper = new SwipeLayout(mContext);
                } else {
                    wrapper = (SwipeLayout) convertView;
                }
                final View view = mAdapter1.getView(getAdustPostion(position),
                        convertView == null ? null : wrapper.getChildAt(0), parent);
                wrapper.removeAllViews();
                view.setTranslationX(0);
                view.setAlpha(1);
                wrapper.addView(view);
                SwipeHelper.setSwipeable(wrapper, true);
                return wrapper;
            case TYPE2:
                return mAdapter2.getView(getAdustPostion(position), convertView, parent);
            default:
                throw new IllegalArgumentException("undefined view type");
        }
    }


    /**
     * 获取适配器相对postion
     *
     * @param postion
     * @return
     */
    private int getAdustPostion(int postion) {
        /**
         * 目前有两个Adapter，所以显示view的时候，
         * 所给的postion坐标需要转换成相对于每个Adapter的相对坐标
         */
        int relativePostion = postion - mAdapter1.getCount();
        return relativePostion >= 0 ? relativePostion : postion;
    }

    class CustomObserver extends DataSetObserver {
        @Override
        public void onChanged() {
            super.onChanged();
            notifyDataSetChanged();
        }
    }


}
