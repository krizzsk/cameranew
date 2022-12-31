package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class w {
    private static long b;
    private static final IntentFilter a = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static float c = Float.NaN;

    @TargetApi(20)
    public static int a(Context context) {
        boolean isScreenOn;
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, a);
        int i2 = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & (o.d() ? 7 : 3)) != 0 ? 1 : 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        if (o.g()) {
            isScreenOn = powerManager.isInteractive();
        } else {
            isScreenOn = powerManager.isScreenOn();
        }
        return (isScreenOn ? 2 : 0) | i2;
    }

    public static synchronized float b(Context context) {
        synchronized (w.class) {
            if (SystemClock.elapsedRealtime() - b < 60000 && !Float.isNaN(c)) {
                return c;
            }
            Intent registerReceiver = context.getApplicationContext().registerReceiver(null, a);
            if (registerReceiver != null) {
                c = registerReceiver.getIntExtra("level", -1) / registerReceiver.getIntExtra("scale", -1);
            }
            b = SystemClock.elapsedRealtime();
            return c;
        }
    }
}
