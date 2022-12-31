package com.huawei.hianalytics.util;

import android.content.Context;
/* loaded from: classes2.dex */
public abstract class HiAnalyticTools {
    public static void enableLog(Context context) {
        enableLog(context, 4);
    }

    public static void enableLog(Context context, int i2) {
        com.huawei.hianalytics.b.b.a(context, i2, "hianalytics");
    }
}
