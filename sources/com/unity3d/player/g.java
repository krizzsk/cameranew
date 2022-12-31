package com.unity3d.player;

import android.util.Log;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
/* loaded from: classes3.dex */
final class g {
    protected static boolean a = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public static void Log(int i2, String str) {
        if (a) {
            return;
        }
        if (i2 == 6) {
            Log.e(CrashlyticsReport.DEVELOPMENT_PLATFORM_UNITY, str);
        }
        if (i2 == 5) {
            Log.w(CrashlyticsReport.DEVELOPMENT_PLATFORM_UNITY, str);
        }
    }
}
