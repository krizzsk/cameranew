package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.os.StrictMode;
import com.google.android.gms.internal.ads.zzass;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzdws;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbr {
    private static <T> T a(Callable<T> callable) throws Exception {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            return callable.call();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    @Deprecated
    public static <T> T zza(Context context, Callable<T> callable) {
        try {
            return (T) a(callable);
        } catch (Throwable th) {
            zzazk.zzc("Unexpected exception.", th);
            zzass.zzq(context).zza(th, "StrictModeUtil.runWithLaxStrictMode");
            return null;
        }
    }

    public static <T> T zza(zzdws<T> zzdwsVar) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            return zzdwsVar.get();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
