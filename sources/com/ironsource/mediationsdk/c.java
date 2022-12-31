package com.ironsource.mediationsdk;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
/* compiled from: AdapterUtils.java */
/* loaded from: classes2.dex */
public class c {
    public static int a(Activity activity, int i2) {
        if (activity == null) {
            com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.API, "AdapterUtils dpToPixels - activity is null, returning dpSize", 3);
            return i2;
        }
        return (int) TypedValue.applyDimension(1, i2, activity.getResources().getDisplayMetrics());
    }

    public static boolean b(Activity activity) {
        if (activity == null) {
            com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.API, "AdapterUtils isLargeScreen - activity is null", 3);
            return false;
        }
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        float f2 = displayMetrics.density;
        return ((float) displayMetrics.heightPixels) / f2 > 720.0f && ((float) displayMetrics.widthPixels) / f2 >= 728.0f;
    }
}
