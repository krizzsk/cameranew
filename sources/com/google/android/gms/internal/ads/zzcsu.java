package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzcsu extends zzapb {
    private zzcrl<zzapk, zzctd> zzgtu;
    private final /* synthetic */ zzcsp zzgtv;

    private zzcsu(zzcsp zzcspVar, zzcrl<zzapk, zzctd> zzcrlVar) {
        this.zzgtv = zzcspVar;
        this.zzgtu = zzcrlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaoy
    public final void zzdl(String str) throws RemoteException {
        this.zzgtu.zzgsu.zzc(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzaoy
    public final void zzg(zzvg zzvgVar) throws RemoteException {
        this.zzgtu.zzgsu.zzd(zzvgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaoy
    public final void zzx(b bVar) throws RemoteException {
        this.zzgtv.view = (View) d.y0(bVar);
        this.zzgtu.zzgsu.onAdLoaded();
    }
}
