package com.google.android.gms.common.util;

import android.content.Context;
import android.util.Log;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class g {
    public static boolean a(Context context, Throwable th) {
        return b(context, th, 536870912);
    }

    private static boolean b(Context context, Throwable th, int i2) {
        try {
            com.google.android.gms.common.internal.q.j(context);
            com.google.android.gms.common.internal.q.j(th);
            return false;
        } catch (Exception e2) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e2);
            return false;
        }
    }
}
