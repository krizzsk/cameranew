package com.pinguo.camera360;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class CrashReportActivity_ViewBinding implements Unbinder {
    @UiThread
    public CrashReportActivity_ViewBinding(CrashReportActivity crashReportActivity, View view) {
        crashReportActivity.mContentTv = (TextView) butterknife.internal.a.c(view, R.id.content_tv, "field 'mContentTv'", TextView.class);
    }
}
