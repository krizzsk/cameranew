package com.pinguo.camera360.test;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class CameraInfoActivity_ViewBinding implements Unbinder {
    @UiThread
    public CameraInfoActivity_ViewBinding(CameraInfoActivity cameraInfoActivity, View view) {
        cameraInfoActivity.mCameraInfo = (TextView) butterknife.internal.a.c(view, R.id.camera_infos, "field 'mCameraInfo'", TextView.class);
    }
}
