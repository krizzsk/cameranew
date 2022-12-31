package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbjp implements zzdzl<String> {
    private final /* synthetic */ zzbjq zzfrh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbjp(zzbjq zzbjqVar) {
        this.zzfrh = zzbjqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final /* synthetic */ void onSuccess(@Nullable String str) {
        zzdnx zzdnxVar;
        zzdsq zzdsqVar;
        zzdnl zzdnlVar;
        zzdmw zzdmwVar;
        zzdmw zzdmwVar2;
        Context context;
        int i2;
        String str2 = str;
        zzdnxVar = this.zzfrh.zzfrk;
        zzdsqVar = this.zzfrh.zzfre;
        zzdnlVar = this.zzfrh.zzfrd;
        zzdmwVar = this.zzfrh.zzfrj;
        zzdmwVar2 = this.zzfrh.zzfrj;
        List<String> zza = zzdsqVar.zza(zzdnlVar, zzdmwVar, false, "", str2, zzdmwVar2.zzdmp);
        com.google.android.gms.ads.internal.zzr.zzkr();
        context = this.zzfrh.context;
        if (com.google.android.gms.ads.internal.util.zzj.zzba(context)) {
            i2 = zzcqs.zzgru;
        } else {
            i2 = zzcqs.zzgrt;
        }
        zzdnxVar.zza(zza, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
        zzdnx zzdnxVar;
        zzdsq zzdsqVar;
        zzdnl zzdnlVar;
        zzdmw zzdmwVar;
        zzdmw zzdmwVar2;
        Context context;
        int i2;
        zzdnxVar = this.zzfrh.zzfrk;
        zzdsqVar = this.zzfrh.zzfre;
        zzdnlVar = this.zzfrh.zzfrd;
        zzdmwVar = this.zzfrh.zzfrj;
        zzdmwVar2 = this.zzfrh.zzfrj;
        List<String> zza = zzdsqVar.zza(zzdnlVar, zzdmwVar, false, "", "failure_click_attok", zzdmwVar2.zzdmp);
        com.google.android.gms.ads.internal.zzr.zzkr();
        context = this.zzfrh.context;
        if (com.google.android.gms.ads.internal.util.zzj.zzba(context)) {
            i2 = zzcqs.zzgru;
        } else {
            i2 = zzcqs.zzgrt;
        }
        zzdnxVar.zza(zza, i2);
    }
}
