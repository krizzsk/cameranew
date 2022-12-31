package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.w;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public class WakeLockTracker {
    private static WakeLockTracker a = new WakeLockTracker();
    private static Boolean b;

    private static void c(Context context, WakeLockEvent wakeLockEvent) {
        try {
            context.startService(new Intent().setComponent(a.a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", wakeLockEvent));
        } catch (Exception e2) {
            Log.wtf("WakeLockTracker", e2);
        }
    }

    private static boolean d() {
        if (b == null) {
            b = Boolean.FALSE;
        }
        return b.booleanValue();
    }

    public static WakeLockTracker getInstance() {
        return a;
    }

    public void a(Context context, String str, int i2, String str2, String str3, String str4, int i3, List<String> list) {
        b(context, str, i2, str2, str3, str4, i3, list, 0L);
    }

    public void b(Context context, String str, int i2, String str2, String str3, String str4, int i3, List<String> list, long j2) {
        if (d()) {
            if (TextUtils.isEmpty(str)) {
                String valueOf = String.valueOf(str);
                Log.e("WakeLockTracker", valueOf.length() != 0 ? "missing wakeLock key. ".concat(valueOf) : new String("missing wakeLock key. "));
            } else if (7 == i2 || 8 == i2 || 10 == i2 || 11 == i2) {
                c(context, new WakeLockEvent(System.currentTimeMillis(), i2, str2, i3, b.c(list), str, SystemClock.elapsedRealtime(), w.a(context), str3, b.b(context.getPackageName()), w.b(context), j2, str4, false));
            }
        }
    }
}
