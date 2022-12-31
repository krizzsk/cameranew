package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcxt extends zzxg {
    private final zzcyy zzgxs;

    public zzcxt(Context context, zzbgc zzbgcVar, zzdnr zzdnrVar, zzcco zzccoVar, zzwx zzwxVar) {
        zzcza zzczaVar = new zzcza(zzccoVar, zzbgcVar.zzaez());
        zzczaVar.zzd(zzwxVar);
        this.zzgxs = new zzcyy(new zzczg(zzbgcVar, context, zzczaVar, zzdnrVar), zzdnrVar.zzavf());
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final synchronized String getMediationAdapterClassName() {
        return this.zzgxs.getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final synchronized boolean isLoading() throws RemoteException {
        return this.zzgxs.isLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final synchronized void zza(zzvl zzvlVar, int i2) throws RemoteException {
        this.zzgxs.zza(zzvlVar, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final void zzb(zzvl zzvlVar) throws RemoteException {
        this.zzgxs.zza(zzvlVar, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final synchronized String zzkh() {
        return this.zzgxs.zzkh();
    }
}
