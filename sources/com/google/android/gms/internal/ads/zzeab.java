package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdyk;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzeab extends zzdyk.zzh<Void> implements Runnable {
    private final Runnable zziax;

    public zzeab(Runnable runnable) {
        this.zziax = (Runnable) zzdwl.checkNotNull(runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zziax.run();
        } catch (Throwable th) {
            setException(th);
            throw zzdwv.zzj(th);
        }
    }
}
