package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class s0 {
    private static Object a = new Object();
    @GuardedBy("sLock")
    private static boolean b;
    private static int c;

    public static int a(Context context) {
        b(context);
        return c;
    }

    private static void b(Context context) {
        Bundle bundle;
        synchronized (a) {
            if (b) {
                return;
            }
            b = true;
            try {
                bundle = com.google.android.gms.common.wrappers.b.a(context).c(context.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.wtf("MetadataValueReader", "This should never happen.", e2);
            }
            if (bundle == null) {
                return;
            }
            bundle.getString("com.google.app.id");
            c = bundle.getInt("com.google.android.gms.version");
        }
    }
}
