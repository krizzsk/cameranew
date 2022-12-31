package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeoutException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzcne implements zzdyu {
    static final zzdyu zzboq = new zzcne();

    private zzcne() {
    }

    @Override // com.google.android.gms.internal.ads.zzdyu
    public final zzdzw zzf(Object obj) {
        TimeoutException timeoutException = (TimeoutException) obj;
        return zzdzk.immediateFailedFuture(new zzcmb(zzdom.NETWORK_ERROR));
    }
}
