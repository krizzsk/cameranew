package com.ironsource.mediationsdk.logger;

import android.util.Log;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
/* compiled from: ConsoleLogger.java */
/* loaded from: classes2.dex */
public class a extends IronSourceLogger {
    public a(int i2) {
        super("console", i2);
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public void d(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i2) {
        if (i2 == 0) {
            Log.v("ironSourceSDK: " + ironSourceTag, str);
        } else if (i2 == 1) {
            Log.i("ironSourceSDK: " + ironSourceTag, str);
        } else if (i2 == 2) {
            Log.w("ironSourceSDK: " + ironSourceTag, str);
        } else if (i2 != 3) {
        } else {
            Log.e("ironSourceSDK: " + ironSourceTag, str);
        }
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public void e(IronSourceLogger.IronSourceTag ironSourceTag, String str, Throwable th) {
        d(ironSourceTag, str + ":stacktrace[" + Log.getStackTraceString(th) + "]", 3);
    }
}
