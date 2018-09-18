package com.ray.tf.demo.tfsdk;

import android.app.Application;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by zhangleilei on 2018/9/18.
 */

public class App extends Application {

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        final File defile = new File(Environment.getExternalStorageDirectory() + "/A_tf/deExport.pb");
        if (!defile.exists()) {
            FileUtils.getInstance().copyAssetsToSD("pbs", "/A_tf/")
                    .setFileOperateCallback(new FileUtils.FileOperateCallback() {

                        @Override
                        public void onSuccess() {
                            try {
                                final File enfile = new File(Environment.getExternalStorageDirectory()
                                        + "/A_tf/export.pb");
                                FileEncAndDec.EncFile(new FileInputStream(enfile), defile);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailed(String error) {

                        }
                    });
        }
    }

    public static App getInstance() {
        return instance;
    }
}
