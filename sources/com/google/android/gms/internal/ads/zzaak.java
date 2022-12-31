package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaak extends zzauq {
    private zzauu zzclo;

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void destroy() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final Bundle getAdMetadata() throws RemoteException {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final boolean isLoaded() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void pause() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void resume() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void setAppPackageName(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void setCustomData(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void setImmersiveMode(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void setUserId(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void show() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zza(zzaup zzaupVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zza(zzava zzavaVar) throws RemoteException {
        zzazk.zzev("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzaza.zzaac.post(new zzaan(this));
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zza(zzxs zzxsVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zzi(b bVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zzj(b bVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zzk(b bVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final zzyx zzki() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zzl(b bVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final boolean zzrw() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zza(zzauu zzauuVar) throws RemoteException {
        this.zzclo = zzauuVar;
    }
}
