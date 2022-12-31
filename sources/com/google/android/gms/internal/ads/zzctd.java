package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzctd extends zzann implements zzbsu {
    @GuardedBy("this")
    private zzank zzdox;
    @GuardedBy("this")
    private zzbsx zzguf;

    @Override // com.google.android.gms.internal.ads.zzank
    public final synchronized void onAdClicked() throws RemoteException {
        zzank zzankVar = this.zzdox;
        if (zzankVar != null) {
            zzankVar.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final synchronized void onAdClosed() throws RemoteException {
        zzank zzankVar = this.zzdox;
        if (zzankVar != null) {
            zzankVar.onAdClosed();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final synchronized void onAdFailedToLoad(int i2) throws RemoteException {
        zzank zzankVar = this.zzdox;
        if (zzankVar != null) {
            zzankVar.onAdFailedToLoad(i2);
        }
        zzbsx zzbsxVar = this.zzguf;
        if (zzbsxVar != null) {
            zzbsxVar.onAdFailedToLoad(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final synchronized void onAdImpression() throws RemoteException {
        zzank zzankVar = this.zzdox;
        if (zzankVar != null) {
            zzankVar.onAdImpression();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final synchronized void onAdLeftApplication() throws RemoteException {
        zzank zzankVar = this.zzdox;
        if (zzankVar != null) {
            zzankVar.onAdLeftApplication();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final synchronized void onAdLoaded() throws RemoteException {
        zzank zzankVar = this.zzdox;
        if (zzankVar != null) {
            zzankVar.onAdLoaded();
        }
        zzbsx zzbsxVar = this.zzguf;
        if (zzbsxVar != null) {
            zzbsxVar.onAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final synchronized void onAdOpened() throws RemoteException {
        zzank zzankVar = this.zzdox;
        if (zzankVar != null) {
            zzankVar.onAdOpened();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final synchronized void onAppEvent(String str, String str2) throws RemoteException {
        zzank zzankVar = this.zzdox;
        if (zzankVar != null) {
            zzankVar.onAppEvent(str, str2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final synchronized void onVideoEnd() throws RemoteException {
        zzank zzankVar = this.zzdox;
        if (zzankVar != null) {
            zzankVar.onVideoEnd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final synchronized void onVideoPause() throws RemoteException {
        zzank zzankVar = this.zzdox;
        if (zzankVar != null) {
            zzankVar.onVideoPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final synchronized void onVideoPlay() throws RemoteException {
        zzank zzankVar = this.zzdox;
        if (zzankVar != null) {
            zzankVar.onVideoPlay();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final synchronized void zza(zzbsx zzbsxVar) {
        this.zzguf = zzbsxVar;
    }

    public final synchronized void zzb(zzank zzankVar) {
        this.zzdox = zzankVar;
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final synchronized void zzc(int i2, String str) throws RemoteException {
        zzank zzankVar = this.zzdox;
        if (zzankVar != null) {
            zzankVar.zzc(i2, str);
        }
        zzbsx zzbsxVar = this.zzguf;
        if (zzbsxVar != null) {
            zzbsxVar.zzf(i2, str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final synchronized void zzd(zzvg zzvgVar) throws RemoteException {
        zzank zzankVar = this.zzdox;
        if (zzankVar != null) {
            zzankVar.zzd(zzvgVar);
        }
        zzbsx zzbsxVar = this.zzguf;
        if (zzbsxVar != null) {
            zzbsxVar.zzc(zzvgVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final synchronized void zzdb(int i2) throws RemoteException {
        zzank zzankVar = this.zzdox;
        if (zzankVar != null) {
            zzankVar.zzdb(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final synchronized void zzdi(String str) throws RemoteException {
        zzank zzankVar = this.zzdox;
        if (zzankVar != null) {
            zzankVar.zzdi(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final synchronized void zzdj(String str) throws RemoteException {
        zzank zzankVar = this.zzdox;
        if (zzankVar != null) {
            zzankVar.zzdj(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final synchronized void zzf(zzvg zzvgVar) throws RemoteException {
        zzank zzankVar = this.zzdox;
        if (zzankVar != null) {
            zzankVar.zzf(zzvgVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final synchronized void zzve() throws RemoteException {
        zzank zzankVar = this.zzdox;
        if (zzankVar != null) {
            zzankVar.zzve();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final synchronized void zzvf() throws RemoteException {
        zzank zzankVar = this.zzdox;
        if (zzankVar != null) {
            zzankVar.zzvf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final synchronized void zza(zzanp zzanpVar) throws RemoteException {
        zzank zzankVar = this.zzdox;
        if (zzankVar != null) {
            zzankVar.zza(zzanpVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final synchronized void zzb(zzavj zzavjVar) throws RemoteException {
        zzank zzankVar = this.zzdox;
        if (zzankVar != null) {
            zzankVar.zzb(zzavjVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final synchronized void zza(zzafn zzafnVar, String str) throws RemoteException {
        zzank zzankVar = this.zzdox;
        if (zzankVar != null) {
            zzankVar.zza(zzafnVar, str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final synchronized void zzb(Bundle bundle) throws RemoteException {
        zzank zzankVar = this.zzdox;
        if (zzankVar != null) {
            zzankVar.zzb(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final synchronized void zza(zzavl zzavlVar) throws RemoteException {
        zzank zzankVar = this.zzdox;
        if (zzankVar != null) {
            zzankVar.zza(zzavlVar);
        }
    }
}
