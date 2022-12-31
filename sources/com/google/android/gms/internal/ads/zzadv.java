package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzadv {
    private static zzacx<Long> zzdfa = zzacx.zzb("gads:ad_loader:timeout_ms", 60000L);
    public static zzacx<Long> zzdfb = zzacx.zzb("gads:rendering:timeout_ms", 60000L);
    private static zzacx<Long> zzdfc = zzacx.zzb("gads:resolve_future:default_timeout_ms", (long) WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
}
