package com.github.yftx.DialerReserch.Utils;

import android.content.Context;
import android.widget.Toast;

/**
 * User: yftx
 * Date: 13-10-18
 */
public class ToastUtils {
    public static void showTips(Context context, String tipsInfo) {
        Toast.makeText(context, tipsInfo, Toast.LENGTH_SHORT).show();
    }
}
