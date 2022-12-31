package com.bytedance.sdk.openadsdk.multipro;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.utils.o;
/* compiled from: TTMultiInitHelper.java */
/* loaded from: classes.dex */
public class d {
    public static void a(Context context) {
        if (context == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.multipro.d.a.a(context.getApplicationContext());
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            int myPid = Process.myPid();
            String str = context.getPackageName() + myPid;
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    str = runningAppProcessInfo.processName;
                }
            }
            WebView.setDataDirectorySuffix(str);
        } catch (Exception e2) {
            o.b(e2.toString());
        }
    }
}
