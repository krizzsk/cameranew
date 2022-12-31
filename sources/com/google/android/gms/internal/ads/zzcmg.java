package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzcmg implements zzdyu {
    static final zzdyu zzboq = new zzcmg();

    private zzcmg() {
    }

    @Override // com.google.android.gms.internal.ads.zzdyu
    public final zzdzw zzf(Object obj) {
        return zzdzk.immediateFailedFuture(((ExecutionException) obj).getCause());
    }
}
