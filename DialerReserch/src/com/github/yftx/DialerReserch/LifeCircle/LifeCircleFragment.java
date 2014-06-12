package com.github.yftx.DialerReserch.LifeCircle;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.yftx.DialerReserch.R;
import com.github.yftx.DialerReserch.Utils.LogUtils;

/**
 * Created by yftx on 6/12/14.
 */
public class LifeCircleFragment extends Fragment {

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        LogUtils.d();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.d();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LogUtils.d();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtils.d();
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtils.d();
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.d();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.d();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtils.d();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtils.d();
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.d();
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtils.d();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LogUtils.d();
    }

    @Override
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        LogUtils.d();
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        LogUtils.d();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LogUtils.d();
        return inflater.inflate(R.layout.life_circle_fragment, container, false);
    }







}