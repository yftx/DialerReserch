package com.github.yftx.DialerReserch.Property;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.github.yftx.DialerReserch.R;
import com.github.yftx.DialerReserch.Utils.LogUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by yftx on 6/12/14.
 * 测试Property类对文件的读取
 */
public class PropertyActivity extends Activity {
    TextView mContent;
    Properties mProperties;
    private static final String CONFIG_PROPERTIES = "config.properties";
    private static final String CONFIG_KEY = "Config";
    private String s = "no content";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.property_activity);
        mContent = (TextView) findViewById(R.id.content);
        readProperty();
        showProperty();

    }

    private void showProperty() {
        if(mProperties!=null){
            s=mProperties.getProperty(CONFIG_KEY);
        }
        mContent.setText(s);
    }

    private void readProperty() {
        try {
            final InputStream fileStream = getAssets().open(CONFIG_PROPERTIES);
            mProperties = new Properties();
            mProperties.load(fileStream);
            fileStream.close();
        } catch (IOException e) {
            LogUtils.e(e.getMessage());
        }

    }


}