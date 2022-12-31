package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcel implements zzdvz<zzz, Bitmap> {
    private final /* synthetic */ double zzghh;
    private final /* synthetic */ boolean zzghi;
    private final /* synthetic */ zzcem zzghj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcel(zzcem zzcemVar, double d2, boolean z) {
        this.zzghj = zzcemVar;
        this.zzghh = d2;
        this.zzghi = z;
    }

    @Override // com.google.android.gms.internal.ads.zzdvz
    public final /* synthetic */ Bitmap apply(zzz zzzVar) {
        Bitmap zza;
        zza = this.zzghj.zza(zzzVar.data, this.zzghh, this.zzghi);
        return zza;
    }
}
