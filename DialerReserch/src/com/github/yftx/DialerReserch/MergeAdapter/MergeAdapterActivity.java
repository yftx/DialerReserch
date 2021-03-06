package com.github.yftx.DialerReserch.MergeAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.github.yftx.DialerReserch.MergeAdapter.adapter.Adapter1;
import com.github.yftx.DialerReserch.MergeAdapter.adapter.Adapter2;
import com.github.yftx.DialerReserch.MergeAdapter.adapter.MergeAdapter;
import com.github.yftx.DialerReserch.MergeAdapter.swipe.SwipeListView;
import com.github.yftx.DialerReserch.R;

/**
 * Created by yftx on 6/12/14.
 */
public class MergeAdapterActivity extends Activity implements View.OnClickListener {
    SwipeListView mListView;
    MergeAdapter mAdapter;
    Adapter1 mAdapter1;
    Adapter2 mAdapter2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.merge_adapter_activity);
        findViews();
        initData();
    }

    private void initData() {
        mAdapter1 = new Adapter1(getLayoutInflater());
        mAdapter2 = new Adapter2(getLayoutInflater());
        mAdapter = new MergeAdapter(this,mAdapter1, mAdapter2);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemSwipeListener(mAdapter1);
    }

    private void findViews() {
        mListView = (SwipeListView) findViewById(R.id.content);
        findViewById(R.id.adapter1).setOnClickListener(this);
        findViewById(R.id.adapter2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.adapter1:
                mAdapter1.refresh(10);
                break;
            case R.id.adapter2:
                mAdapter2.refresh(10);
                break;
        }
    }
}