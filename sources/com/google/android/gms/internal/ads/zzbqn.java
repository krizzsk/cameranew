package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbqn implements zzdzl<Boolean> {
    private final /* synthetic */ zzbql zzfye;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbqn(zzbql zzbqlVar) {
        this.zzfye = zzbqlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final /* synthetic */ void onSuccess(@NullableDecl Boolean bool) {
        zzbsd zzbsdVar;
        zzbsdVar = this.zzfye.zzfxz;
        zzbsdVar.onAdImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
    }
}
