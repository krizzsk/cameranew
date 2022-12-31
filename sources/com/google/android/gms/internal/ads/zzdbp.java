package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdbp implements zzdfi<zzdfj<Bundle>> {
    private final Executor executor;
    private final zzayo zzbqd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdbp(Executor executor, zzayo zzayoVar) {
        this.executor = executor;
        this.zzbqd = zzayoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdzw<zzdfj<Bundle>> zzasy() {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcse)).booleanValue()) {
            return zzdzk.zzag(null);
        }
        return zzdzk.zzb(this.zzbqd.zzxt(), zzdbo.zzeaj, this.executor);
    }
}
