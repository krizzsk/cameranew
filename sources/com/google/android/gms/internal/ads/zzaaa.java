package com.google.android.gms.internal.ads;

import android.os.RemoteException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaaa extends zzxg {
    final /* synthetic */ zzzy zzclj;

    private zzaaa(zzzy zzzyVar) {
        this.zzclj = zzzyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final boolean isLoading() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final void zza(zzvl zzvlVar, int i2) throws RemoteException {
        zzazk.zzev("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzaza.zzaac.post(new zzaad(this));
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final void zzb(zzvl zzvlVar) throws RemoteException {
        zza(zzvlVar, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final String zzkh() throws RemoteException {
        return null;
    }
}
