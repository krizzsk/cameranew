package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import java.util.Collections;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcxw extends zzxo implements zzbtw {
    private final String zzbut;
    @Nullable
    @GuardedBy("this")
    private zzblv zzgxr;
    private final Context zzgxt;
    @GuardedBy("this")
    private final zzdnr zzgxu;
    private final zzdje zzgxx;
    private final zzcxy zzgxy;
    private zzvs zzgxz;

    public zzcxw(Context context, zzvs zzvsVar, String str, zzdje zzdjeVar, zzcxy zzcxyVar) {
        this.zzgxt = context;
        this.zzgxx = zzdjeVar;
        this.zzgxz = zzvsVar;
        this.zzbut = str;
        this.zzgxy = zzcxyVar;
        this.zzgxu = zzdjeVar.zzauj();
        zzdjeVar.zza(this);
    }

    private final synchronized void zzf(zzvs zzvsVar) {
        this.zzgxu.zzg(zzvsVar);
        this.zzgxu.zzbm(this.zzgxz.zzcin);
    }

    private final synchronized boolean zzg(zzvl zzvlVar) throws RemoteException {
        q.e("loadAd must be called on the main UI thread.");
        com.google.android.gms.ads.internal.zzr.zzkr();
        if (com.google.android.gms.ads.internal.util.zzj.zzaz(this.zzgxt) && zzvlVar.zzcia == null) {
            zzazk.zzev("Failed to load the ad because app ID is missing.");
            zzcxy zzcxyVar = this.zzgxy;
            if (zzcxyVar != null) {
                zzcxyVar.zzc(zzdok.zza(zzdom.APP_ID_MISSING, null, null));
            }
            return false;
        }
        zzdod.zze(this.zzgxt, zzvlVar.zzchq);
        return this.zzgxx.zza(zzvlVar, this.zzbut, null, new zzcxv(this));
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void destroy() {
        q.e("destroy must be called on the main UI thread.");
        zzblv zzblvVar = this.zzgxr;
        if (zzblvVar != null) {
            zzblvVar.destroy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final Bundle getAdMetadata() {
        q.e("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized String getAdUnitId() {
        return this.zzbut;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized String getMediationAdapterClassName() {
        zzblv zzblvVar = this.zzgxr;
        if (zzblvVar == null || zzblvVar.zzakr() == null) {
            return null;
        }
        return this.zzgxr.zzakr().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized zzzc getVideoController() {
        q.e("getVideoController must be called from the main thread.");
        zzblv zzblvVar = this.zzgxr;
        if (zzblvVar != null) {
            return zzblvVar.getVideoController();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized boolean isLoading() {
        return this.zzgxx.isLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final boolean isReady() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void pause() {
        q.e("pause must be called on the main UI thread.");
        zzblv zzblvVar = this.zzgxr;
        if (zzblvVar != null) {
            zzblvVar.zzakq().zzcb(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void resume() {
        q.e("resume must be called on the main UI thread.");
        zzblv zzblvVar = this.zzgxr;
        if (zzblvVar != null) {
            zzblvVar.zzakq().zzcc(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void setImmersiveMode(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void setManualImpressionsEnabled(boolean z) {
        q.e("setManualImpressionsEnabled must be called from the main thread.");
        this.zzgxu.zzbn(z);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void setUserId(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void showInterstitial() {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void stopLoading() {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzary zzaryVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzase zzaseVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzauu zzauuVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzsp zzspVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzvl zzvlVar, zzxc zzxcVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzvx zzvxVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzyb zzybVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzzi zzziVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized boolean zza(zzvl zzvlVar) throws RemoteException {
        zzf(this.zzgxz);
        return zzg(zzvlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbtw
    public final synchronized void zzalu() {
        if (this.zzgxx.zzauk()) {
            zzvs zzkg = this.zzgxu.zzkg();
            zzblv zzblvVar = this.zzgxr;
            if (zzblvVar != null && zzblvVar.zzajz() != null && this.zzgxu.zzavi()) {
                zzkg = zzdnu.zzb(this.zzgxt, Collections.singletonList(this.zzgxr.zzajz()));
            }
            zzf(zzkg);
            try {
                zzg(this.zzgxu.zzave());
                return;
            } catch (RemoteException unused) {
                zzazk.zzex("Failed to refresh the banner ad.");
                return;
            }
        }
        this.zzgxx.zzaul();
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zzbl(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zze(b bVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final b zzke() {
        q.e("destroy must be called on the main UI thread.");
        return d.z0(this.zzgxx.zzaui());
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void zzkf() {
        q.e("recordManualImpression must be called on the main UI thread.");
        zzblv zzblvVar = this.zzgxr;
        if (zzblvVar != null) {
            zzblvVar.zzkf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized zzvs zzkg() {
        q.e("getAdSize must be called on the main UI thread.");
        zzblv zzblvVar = this.zzgxr;
        if (zzblvVar != null) {
            return zzdnu.zzb(this.zzgxt, Collections.singletonList(zzblvVar.zzajq()));
        }
        return this.zzgxu.zzkg();
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized String zzkh() {
        zzblv zzblvVar = this.zzgxr;
        if (zzblvVar == null || zzblvVar.zzakr() == null) {
            return null;
        }
        return this.zzgxr.zzakr().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized zzyx zzki() {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcyy)).booleanValue()) {
            zzblv zzblvVar = this.zzgxr;
            if (zzblvVar == null) {
                return null;
            }
            return zzblvVar.zzakr();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzxt zzkj() {
        return this.zzgxy.zzask();
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzwx zzkk() {
        return this.zzgxy.zzasj();
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzwx zzwxVar) {
        q.e("setAdListener must be called on the main UI thread.");
        this.zzgxy.zzc(zzwxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxt zzxtVar) {
        q.e("setAppEventListener must be called on the main UI thread.");
        this.zzgxy.zzb(zzxtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void zza(zzvs zzvsVar) {
        q.e("setAdSize must be called on the main UI thread.");
        this.zzgxu.zzg(zzvsVar);
        this.zzgxz = zzvsVar;
        zzblv zzblvVar = this.zzgxr;
        if (zzblvVar != null) {
            zzblvVar.zza(this.zzgxx.zzaui(), zzvsVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void zza(zzxz zzxzVar) {
        q.e("setCorrelationIdProvider must be called on the main UI thread");
        this.zzgxu.zzc(zzxzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void zza(zzaau zzaauVar) {
        q.e("setVideoOptions must be called on the main UI thread.");
        this.zzgxu.zzc(zzaauVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzww zzwwVar) {
        q.e("setAdListener must be called on the main UI thread.");
        this.zzgxx.zza(zzwwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void zza(zzacl zzaclVar) {
        q.e("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzgxx.zza(zzaclVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzyw zzywVar) {
        q.e("setPaidEventListener must be called on the main UI thread.");
        this.zzgxy.zzb(zzywVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxs zzxsVar) {
        q.e("setAdMetadataListener must be called on the main UI thread.");
    }
}
