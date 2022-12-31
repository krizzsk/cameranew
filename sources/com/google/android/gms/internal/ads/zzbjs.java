package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbjs implements zzdzl<String> {
    private final /* synthetic */ zzbjq zzfrh;
    private final /* synthetic */ String zzfrw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbjs(zzbjq zzbjqVar, String str) {
        this.zzfrh = zzbjqVar;
        this.zzfrw = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final /* synthetic */ void onSuccess(@Nullable String str) {
        zzdnx zzdnxVar;
        zzdsq zzdsqVar;
        zzdnl zzdnlVar;
        zzdmw zzdmwVar;
        zzdmw zzdmwVar2;
        String str2 = str;
        zzdnxVar = this.zzfrh.zzfrk;
        zzdsqVar = this.zzfrh.zzfre;
        zzdnlVar = this.zzfrh.zzfrd;
        zzdmwVar = this.zzfrh.zzfrj;
        String str3 = this.zzfrw;
        zzdmwVar2 = this.zzfrh.zzfrj;
        zzdnxVar.zzj(zzdsqVar.zza(zzdnlVar, zzdmwVar, false, str3, str2, zzdmwVar2.zzdmq));
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
        zzdnx zzdnxVar;
        zzdsq zzdsqVar;
        zzdnl zzdnlVar;
        zzdmw zzdmwVar;
        zzdmw zzdmwVar2;
        zzdnxVar = this.zzfrh.zzfrk;
        zzdsqVar = this.zzfrh.zzfre;
        zzdnlVar = this.zzfrh.zzfrd;
        zzdmwVar = this.zzfrh.zzfrj;
        String str = this.zzfrw;
        zzdmwVar2 = this.zzfrh.zzfrj;
        zzdnxVar.zzj(zzdsqVar.zza(zzdnlVar, zzdmwVar, false, str, null, zzdmwVar2.zzdmq));
    }
}
