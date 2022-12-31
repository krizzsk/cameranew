package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdmq extends zzauq {
    private final zzdnk zzfyy;
    @GuardedBy("this")
    private boolean zzgyo = false;
    private final zzdmc zzhip;
    private final zzdlh zzhiq;
    @Nullable
    @GuardedBy("this")
    private zzchb zzhir;

    public zzdmq(zzdmc zzdmcVar, zzdlh zzdlhVar, zzdnk zzdnkVar) {
        this.zzhip = zzdmcVar;
        this.zzhiq = zzdlhVar;
        this.zzfyy = zzdnkVar;
    }

    private final synchronized boolean zzasm() {
        boolean z;
        zzchb zzchbVar = this.zzhir;
        if (zzchbVar != null) {
            z = zzchbVar.isClosed() ? false : true;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void destroy() throws RemoteException {
        zzl(null);
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final Bundle getAdMetadata() {
        q.e("getAdMetadata can only be called from the UI thread.");
        zzchb zzchbVar = this.zzhir;
        return zzchbVar != null ? zzchbVar.getAdMetadata() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final synchronized String getMediationAdapterClassName() throws RemoteException {
        zzchb zzchbVar = this.zzhir;
        if (zzchbVar == null || zzchbVar.zzakr() == null) {
            return null;
        }
        return this.zzhir.zzakr().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final boolean isLoaded() throws RemoteException {
        q.e("isLoaded must be called on the main UI thread.");
        return zzasm();
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void pause() {
        zzj(null);
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void resume() {
        zzk(null);
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void setAppPackageName(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final synchronized void setCustomData(String str) throws RemoteException {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcpk)).booleanValue()) {
            q.e("#008 Must be called on the main UI thread.: setCustomData");
            this.zzfyy.zzdzi = str;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final synchronized void setImmersiveMode(boolean z) {
        q.e("setImmersiveMode must be called on the main UI thread.");
        this.zzgyo = z;
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final synchronized void setUserId(String str) throws RemoteException {
        q.e("setUserId must be called on the main UI thread.");
        this.zzfyy.zzdzh = str;
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final synchronized void show() throws RemoteException {
        zzi(null);
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final synchronized void zza(zzava zzavaVar) throws RemoteException {
        q.e("loadAd must be called on the main UI thread.");
        if (zzabr.zzcp(zzavaVar.zzbut)) {
            return;
        }
        if (zzasm()) {
            if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzcwh)).booleanValue()) {
                return;
            }
        }
        zzdmd zzdmdVar = new zzdmd(null);
        this.zzhir = null;
        this.zzhip.zzec(zzdnh.zzhkk);
        this.zzhip.zza(zzavaVar.zzdud, zzavaVar.zzbut, zzdmdVar, new zzdmt(this));
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final synchronized void zzi(@Nullable b bVar) throws RemoteException {
        Activity activity;
        q.e("showAd must be called on the main UI thread.");
        if (this.zzhir == null) {
            return;
        }
        if (bVar != null) {
            Object y0 = d.y0(bVar);
            if (y0 instanceof Activity) {
                activity = (Activity) y0;
                this.zzhir.zzb(this.zzgyo, activity);
            }
        }
        activity = null;
        this.zzhir.zzb(this.zzgyo, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final synchronized void zzj(b bVar) {
        q.e("pause must be called on the main UI thread.");
        if (this.zzhir != null) {
            this.zzhir.zzakq().zzcb(bVar == null ? null : (Context) d.y0(bVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final synchronized void zzk(b bVar) {
        q.e("resume must be called on the main UI thread.");
        if (this.zzhir != null) {
            this.zzhir.zzakq().zzcc(bVar == null ? null : (Context) d.y0(bVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final synchronized zzyx zzki() throws RemoteException {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcyy)).booleanValue()) {
            zzchb zzchbVar = this.zzhir;
            if (zzchbVar != null) {
                return zzchbVar.zzakr();
            }
            return null;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final synchronized void zzl(b bVar) {
        q.e("destroy must be called on the main UI thread.");
        Context context = null;
        this.zzhiq.zza(null);
        if (this.zzhir != null) {
            if (bVar != null) {
                context = (Context) d.y0(bVar);
            }
            this.zzhir.zzakq().zzcd(context);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final boolean zzrw() {
        zzchb zzchbVar = this.zzhir;
        return zzchbVar != null && zzchbVar.zzrw();
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zza(zzauu zzauuVar) throws RemoteException {
        q.e("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzhiq.zzb(zzauuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zza(zzaup zzaupVar) {
        q.e("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.zzhiq.zzb(zzaupVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zza(zzxs zzxsVar) {
        q.e("setAdMetadataListener can only be called from the UI thread.");
        if (zzxsVar == null) {
            this.zzhiq.zza(null);
        } else {
            this.zzhiq.zza(new zzdms(this, zzxsVar));
        }
    }
}
