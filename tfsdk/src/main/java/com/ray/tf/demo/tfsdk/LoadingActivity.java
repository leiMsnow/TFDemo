package com.ray.tf.demo.tfsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by zhangleilei on 2018/9/25.
 */

public class LoadingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        deFile(this);
    }

    private void deFile(Context context) {
        final String fileName = "/export.pb";
        final File defile = FileUtils.getDefaultDirectory(this, "dtf");
        Log.i("Copy", "准备复制:" + defile.list().length);
        if (defile.list().length == 0) {
            Log.i("Copy", "开始复制");
            FileUtils.getInstance().copyAssetsToSD(context, "pbs", "ctf")
                    .setFileOperateCallback(new FileUtils.FileOperateCallback() {

                        @Override
                        public void onSuccess(String file) {
                            Log.i("Copy", "复制成功:" + file);
                            try {
                                final File enFile = new File(file);
                                if (enFile.isFile()) {
                                    FileEncAndDec.EncFile(new FileInputStream(enFile),
                                            defile.getAbsolutePath() + fileName);
                                    Log.i("Copy", "解析成功");
                                    startActivity(new Intent(LoadingActivity.this, DetectActivity.class));
                                    finish();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.i("Copy", "解析失败:" + e.getMessage());
                            }
                        }

                        @Override
                        public void onFailed(String error) {

                        }
                    });
        } else {
            startActivity(new Intent(this, DetectActivity.class));
            finish();
        }
    }
}
