package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzao {
    private static String TAG = "Volley";
    public static boolean DEBUG = Log.isLoggable("Volley", 2);
    private static final String CLASS_NAME = zzao.class.getName();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static class zza {
        public static final boolean zzbv = zzao.DEBUG;
        private final List<zzaq> zzbw = new ArrayList();
        private boolean mFinished = false;

        protected final void finalize() throws Throwable {
            if (this.mFinished) {
                return;
            }
            zzd("Request on the loose");
            zzao.e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }

        public final synchronized void zza(String str, long j2) {
            if (!this.mFinished) {
                this.zzbw.add(new zzaq(str, j2, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public final synchronized void zzd(String str) {
            long j2;
            this.mFinished = true;
            if (this.zzbw.size() == 0) {
                j2 = 0;
            } else {
                long j3 = this.zzbw.get(0).time;
                List<zzaq> list = this.zzbw;
                j2 = list.get(list.size() - 1).time - j3;
            }
            if (j2 <= 0) {
                return;
            }
            long j4 = this.zzbw.get(0).time;
            zzao.d("(%-4d ms) %s", Long.valueOf(j2), str);
            for (zzaq zzaqVar : this.zzbw) {
                long j5 = zzaqVar.time;
                zzao.d("(+%-4d) [%2d] %s", Long.valueOf(j5 - j4), Long.valueOf(zzaqVar.zzbu), zzaqVar.name);
                j4 = j5;
            }
        }
    }

    public static void d(String str, Object... objArr) {
        Log.d(TAG, zza(str, objArr));
    }

    public static void e(String str, Object... objArr) {
        Log.e(TAG, zza(str, objArr));
    }

    public static void v(String str, Object... objArr) {
        if (DEBUG) {
            Log.v(TAG, zza(str, objArr));
        }
    }

    public static void zza(Throwable th, String str, Object... objArr) {
        Log.e(TAG, zza(str, objArr), th);
    }

    private static String zza(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i2 = 2;
        while (true) {
            if (i2 >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i2].getClassName().equals(CLASS_NAME)) {
                String className = stackTrace[i2].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                String substring2 = substring.substring(substring.lastIndexOf(36) + 1);
                String methodName = stackTrace[i2].getMethodName();
                StringBuilder sb = new StringBuilder(String.valueOf(substring2).length() + 1 + String.valueOf(methodName).length());
                sb.append(substring2);
                sb.append(".");
                sb.append(methodName);
                str2 = sb.toString();
                break;
            } else {
                i2++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }
}
