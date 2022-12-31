package com.pinguo.camera360;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.tencent.bugly.crashreport.CrashReport;
import java.lang.Thread;
import us.pinguo.androidsdk.PGImageSDK;
/* compiled from: AppCrashHandler.java */
/* loaded from: classes3.dex */
public class c implements Thread.UncaughtExceptionHandler {
    private static final String[] c = {"com.mobvista.msdk.", "com.mob.commons.", "com.umeng.message.", "com.kf.appstore.sdk.", "java.util.regex.Pattern.finalize()", "android.content.res.AssetManager.finalize()", "java.util.regex.Matcher.finalize()", "com.x.c.l.d", "com.android.webview.chromium.", "com.google.android.gcm.GCMBroadcastReceiver", "com.google.android.c2dm.intent.RECEIVE", "com.google.android.gms.", "android.support.v4.app.JobIntentService", "com.android.okhttp.okio.Buffer."};
    private Thread.UncaughtExceptionHandler a;
    private Context b;

    public c(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.b = context;
        this.a = uncaughtExceptionHandler;
    }

    private boolean a(Thread thread, Throwable th) {
        String[] strArr;
        String stackTraceString = Log.getStackTraceString(th);
        for (String str : c) {
            if (stackTraceString.contains(str)) {
                us.pinguo.common.log.a.g("Fatal", "Ignored exception:::", new Object[0]);
                us.pinguo.common.log.a.g("Fatal", stackTraceString, new Object[0]);
                CrashReport.postCatchedException(new IllegalStateException("ignore error:" + str, th));
                return false;
            }
        }
        us.pinguo.common.log.a.g("Fatal", "Fatal exception start ======================================", new Object[0]);
        us.pinguo.common.log.a.g("Fatal", stackTraceString, new Object[0]);
        us.pinguo.common.log.a.g("Fatal", "Fatal exception end ======================================", new Object[0]);
        com.pinguo.camera360.f.b.a.c().d();
        Intent intent = new Intent(this.b, CrashReportActivity.class);
        intent.putExtra("Stacktrace", th);
        if (us.pinguo.common.utils.b.a) {
            intent.setFlags(268468224);
        } else {
            intent.setFlags(PGImageSDK.SDK_STATUS_CREATE);
        }
        if (stackTraceString.contains("Bad notification")) {
            CameraBusinessSettingModel v = CameraBusinessSettingModel.v();
            v.E("bad_notification", true);
            v.b();
        }
        try {
            this.b.startActivity(intent);
        } catch (Throwable unused) {
        }
        return true;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    @TargetApi(11)
    public void uncaughtException(Thread thread, Throwable th) {
        if (a(thread, th)) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
            if (uncaughtExceptionHandler != null && uncaughtExceptionHandler != Thread.getDefaultUncaughtExceptionHandler()) {
                this.a.uncaughtException(thread, th);
            }
            Process.killProcess(Process.myPid());
            System.exit(10);
        }
    }
}
