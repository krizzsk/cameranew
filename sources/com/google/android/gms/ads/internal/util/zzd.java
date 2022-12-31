package com.google.android.gms.ads.internal.util;

import android.util.Log;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzazk;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzd extends zzazk {
    public static void zza(String str, Throwable th) {
        if (zzyg()) {
            Log.v("Ads", str, th);
        }
    }

    public static void zzeb(String str) {
        if (zzyg()) {
            Log.v("Ads", str);
        }
    }

    public static boolean zzyg() {
        return zzazk.isLoggable(2) && zzadl.zzdee.get().booleanValue();
    }
}
