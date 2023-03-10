package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcxe implements zzcwy<zzbyy> {
    private final Context context;
    private final zzbzy zzgtz;

    public zzcxe(Context context, zzbzy zzbzyVar) {
        this.context = context;
        this.zzgtz = zzbzyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcwy
    public final /* synthetic */ zzbyy zza(zzdnl zzdnlVar, zzdmw zzdmwVar, View view, zzcxb zzcxbVar) {
        zzbza zza = this.zzgtz.zza(new zzboj(zzdnlVar, zzdmwVar, null), new zzcxg(this, zzcxd.zzgxf));
        zzcxbVar.zza(new zzcxf(this, zza));
        return zza.zzahz();
    }
}
