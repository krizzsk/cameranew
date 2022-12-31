package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzsi extends AppOpenAd {
    @NonNull
    private final String zzbut;
    private final zzsk zzbuu;
    private final zzsl zzbuv = new zzsl();
    @Nullable
    private FullScreenContentCallback zzbuw;

    public zzsi(zzsk zzskVar, String str) {
        this.zzbuu = zzskVar;
        this.zzbut = str;
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final String getAdUnitId() {
        return this.zzbut;
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    @Nullable
    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zzbuw;
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final ResponseInfo getResponseInfo() {
        zzyx zzyxVar;
        try {
            zzyxVar = this.zzbuu.zzki();
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
            zzyxVar = null;
        }
        return ResponseInfo.zza(zzyxVar);
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final void setFullScreenContentCallback(@Nullable FullScreenContentCallback fullScreenContentCallback) {
        this.zzbuw = fullScreenContentCallback;
        this.zzbuv.setFullScreenContentCallback(fullScreenContentCallback);
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final void setImmersiveMode(boolean z) {
        try {
            this.zzbuu.setImmersiveMode(z);
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final void show(Activity activity, FullScreenContentCallback fullScreenContentCallback) {
        this.zzbuw = fullScreenContentCallback;
        this.zzbuv.setFullScreenContentCallback(fullScreenContentCallback);
        if (activity == null) {
            zzazk.zzex("The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
        try {
            this.zzbuu.zza(d.z0(activity), this.zzbuv);
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final void zza(zzsq zzsqVar) {
        try {
            this.zzbuu.zza(zzsqVar);
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final zzxl zzdx() {
        try {
            return this.zzbuu.zzdx();
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final void show(@NonNull Activity activity) {
        try {
            this.zzbuu.zza(d.z0(activity), this.zzbuv);
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }
}
