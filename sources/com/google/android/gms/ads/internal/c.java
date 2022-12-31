package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzdsy;
import com.google.android.gms.internal.ads.zzdug;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class c implements zzdug {
    private final /* synthetic */ zzf a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(zzf zzfVar) {
        this.a = zzfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdug
    public final void zza(int i2, long j2) {
        zzdsy zzdsyVar;
        zzdsyVar = this.a.f3505h;
        zzdsyVar.zzh(i2, System.currentTimeMillis() - j2);
    }

    @Override // com.google.android.gms.internal.ads.zzdug
    public final void zza(int i2, long j2, String str) {
        zzdsy zzdsyVar;
        zzdsyVar = this.a.f3505h;
        zzdsyVar.zzb(i2, System.currentTimeMillis() - j2, str);
    }
}
