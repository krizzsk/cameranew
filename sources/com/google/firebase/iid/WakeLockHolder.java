package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.stats.a;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.firebase:firebase-iid@@21.0.1 */
/* loaded from: classes2.dex */
public final class WakeLockHolder {
    private static final long WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(1);
    private static final Object syncObject = new Object();
    @GuardedBy("WakeLockHolder.syncObject")
    private static a wakeLock;

    public static void acquireWakeLock(Intent intent, long j2) {
        synchronized (syncObject) {
            if (wakeLock != null) {
                setAsWakefulIntent(intent, true);
                wakeLock.a(j2);
            }
        }
    }

    @GuardedBy("WakeLockHolder.syncObject")
    private static void checkAndInitWakeLock(Context context) {
        if (wakeLock == null) {
            a aVar = new a(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
            wakeLock = aVar;
            aVar.c(true);
        }
    }

    public static void completeWakefulIntent(@NonNull Intent intent) {
        synchronized (syncObject) {
            if (wakeLock != null && isWakefulIntent(intent)) {
                setAsWakefulIntent(intent, false);
                wakeLock.b();
            }
        }
    }

    public static void initWakeLock(Context context) {
        synchronized (syncObject) {
            checkAndInitWakeLock(context);
        }
    }

    @VisibleForTesting
    static boolean isWakefulIntent(@NonNull Intent intent) {
        return intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
    }

    public static void reset() {
        synchronized (syncObject) {
            wakeLock = null;
        }
    }

    private static void setAsWakefulIntent(@NonNull Intent intent, boolean z) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z);
    }

    public static ComponentName startWakefulService(@NonNull Context context, @NonNull Intent intent) {
        synchronized (syncObject) {
            checkAndInitWakeLock(context);
            boolean isWakefulIntent = isWakefulIntent(intent);
            setAsWakefulIntent(intent, true);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            if (!isWakefulIntent) {
                wakeLock.a(WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS);
            }
            return startService;
        }
    }
}
