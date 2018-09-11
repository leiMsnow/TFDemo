package com.ray.tf.demo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.media.ImageReader;
import android.os.Bundle;
import android.util.Size;
import android.util.TypedValue;
import android.widget.Toast;

import com.ray.tf.demo.tfsdk.CameraActivity;
import com.ray.tf.demo.tfsdk.Classifier;
import com.ray.tf.demo.tfsdk.DetectActivity;
import com.ray.tf.demo.tfsdk.OverlayView;
import com.ray.tf.demo.tfsdk.TensorFlowObjectDetectionAPIModel;
import com.ray.tf.demo.tfsdk.env.BorderedText;
import com.ray.tf.demo.tfsdk.env.ImageUtils;
import com.ray.tf.demo.tfsdk.env.Logger;
import com.ray.tf.demo.tfsdk.tracking.MultiBoxTracker;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends DetectActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
