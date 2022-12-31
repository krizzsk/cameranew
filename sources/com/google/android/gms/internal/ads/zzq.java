package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzq implements zzal {
    private final Executor zzaa;

    public zzq(Handler handler) {
        this.zzaa = new zzt(this, handler);
    }

    @Override // com.google.android.gms.internal.ads.zzal
    public final void zza(zzab<?> zzabVar, zzag<?> zzagVar) {
        zza(zzabVar, zzagVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzal
    public final void zza(zzab<?> zzabVar, zzag<?> zzagVar, Runnable runnable) {
        zzabVar.zzk();
        zzabVar.zzc("post-response");
        this.zzaa.execute(new zzs(zzabVar, zzagVar, runnable));
    }

    @Override // com.google.android.gms.internal.ads.zzal
    public final void zza(zzab<?> zzabVar, zzap zzapVar) {
        zzabVar.zzc("post-error");
        this.zzaa.execute(new zzs(zzabVar, zzag.zzc(zzapVar), null));
    }
}
