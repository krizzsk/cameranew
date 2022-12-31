package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class t {
    public static boolean a(Context context, int i2) {
        if (b(context, i2, "com.google.android.gms")) {
            try {
                return com.google.android.gms.common.d.a(context).b(context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
            } catch (PackageManager.NameNotFoundException unused) {
                if (Log.isLoggable("UidVerifier", 3)) {
                    Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
                }
                return false;
            }
        }
        return false;
    }

    @TargetApi(19)
    public static boolean b(Context context, int i2, String str) {
        return com.google.android.gms.common.wrappers.b.a(context).h(i2, str);
    }
}
