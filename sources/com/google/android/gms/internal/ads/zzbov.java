package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbov implements zzdzl<zzatq> {
    private final /* synthetic */ zzbou zzfxi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbov(zzbou zzbouVar) {
        this.zzfxi = zzbouVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final /* synthetic */ void onSuccess(@NullableDecl zzatq zzatqVar) {
        zzbvu zzbvuVar;
        zzbvuVar = this.zzfxi.zzfxc;
        zzbvuVar.zzbg(true);
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
        zzbvu zzbvuVar;
        zzbvuVar = this.zzfxi.zzfxc;
        zzbvuVar.zzbg(false);
    }
}
