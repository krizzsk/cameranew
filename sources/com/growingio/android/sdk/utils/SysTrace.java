package com.growingio.android.sdk.utils;

import android.os.Build;
import android.os.Trace;
/* loaded from: classes2.dex */
public final class SysTrace {
    public static void beginSection(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void endSection() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
