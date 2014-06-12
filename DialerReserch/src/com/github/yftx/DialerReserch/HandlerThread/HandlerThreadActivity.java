package com.github.yftx.DialerReserch.HandlerThread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import com.github.yftx.DialerReserch.R;

/**
 * Created by yftx on 6/12/14.
 */
public class HandlerThreadActivity extends Activity implements View.OnClickListener {
    ProgressBar mPb;
    int mProcess;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            refreshPb(msg.what);
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    Message message = new Message();
                    message.what = mProcess;
                    mProcess++;
                    mHandler.postDelayed(refreshRunabble,10);
                }
            });
        }
    };


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handler_thread_activity);
        findView();
    }

    private void findView() {
        mPb = (ProgressBar) findViewById(R.id.pb);
        findViewById(R.id.handler).setOnClickListener(this);
        findViewById(R.id.handler_thread).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.handler:
                startRefreshPbByHandler();
                break;
            case R.id.handler_thread:
                startRefreshPbByHandlerThread();
                break;
        }
    }

    private void startRefreshPbByHandlerThread() {

    }

    private void startRefreshPbByHandler() {
 /*       Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = mProcess;
                mProcess++;
                mHandler.sendMessage(message);
            }
        });
        t.start();*/

        mHandler.postDelayed(refreshRunabble,10);


    }


    private void refreshPb(int process) {
        mPb.setProgress(process);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHandler.removeCallbacks(refreshRunabble);
    }

    Runnable refreshRunabble = new Runnable() {
        @Override
        public void run() {
            Message message = new Message();
            message.what = mProcess;
            mProcess++;
            mHandler.sendMessage(message);
        }
    };



}