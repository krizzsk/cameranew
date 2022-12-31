package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcyt extends zzxo {
    private final zzvs zzbpo;
    private final String zzbut;
    private final Context zzgxt;
    private final zzcxy zzgxy;
    private final zzdkx zzgyl;
    private final zzdlh zzgym;
    @Nullable
    @GuardedBy("this")
    private zzbyy zzgyn;
    @GuardedBy("this")
    private boolean zzgyo = ((Boolean) zzwr.zzqr().zzd(zzabp.zzcox)).booleanValue();

    public zzcyt(Context context, zzvs zzvsVar, String str, zzdkx zzdkxVar, zzcxy zzcxyVar, zzdlh zzdlhVar) {
        this.zzbpo = zzvsVar;
        this.zzbut = str;
        this.zzgxt = context;
        this.zzgyl = zzdkxVar;
        this.zzgxy = zzcxyVar;
        this.zzgym = zzdlhVar;
    }

    private final synchronized boolean zzasm() {
        boolean z;
        zzbyy zzbyyVar = this.zzgyn;
        if (zzbyyVar != null) {
            z = zzbyyVar.isClosed() ? false : true;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void destroy() {
        q.e("destroy must be called on the main UI thread.");
        zzbyy zzbyyVar = this.zzgyn;
        if (zzbyyVar != null) {
            zzbyyVar.zzakq().zzcd(null);
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
        zzbyy zzbyyVar = this.zzgyn;
        if (zzbyyVar == null || zzbyyVar.zzakr() == null) {
            return null;
        }
        return this.zzgyn.zzakr().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzzc getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized boolean isLoading() {
        return this.zzgyl.isLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized boolean isReady() {
        q.e("isLoaded must be called on the main UI thread.");
        return zzasm();
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void pause() {
        q.e("pause must be called on the main UI thread.");
        zzbyy zzbyyVar = this.zzgyn;
        if (zzbyyVar != null) {
            zzbyyVar.zzakq().zzcb(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void resume() {
        q.e("resume must be called on the main UI thread.");
        zzbyy zzbyyVar = this.zzgyn;
        if (zzbyyVar != null) {
            zzbyyVar.zzakq().zzcc(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void setImmersiveMode(boolean z) {
        q.e("setImmersiveMode must be called on the main UI thread.");
        this.zzgyo = z;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void setManualImpressionsEnabled(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void setUserId(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void showInterstitial() {
        q.e("showInterstitial must be called on the main UI thread.");
        zzbyy zzbyyVar = this.zzgyn;
        if (zzbyyVar == null) {
            return;
        }
        zzbyyVar.zzb(this.zzgyo, null);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void stopLoading() {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzaau zzaauVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzary zzaryVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzase zzaseVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzsp zzspVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzvs zzvsVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzvx zzvxVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzww zzwwVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxz zzxzVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzzi zzziVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized boolean zza(zzvl zzvlVar) {
        q.e("loadAd must be called on the main UI thread.");
        com.google.android.gms.ads.internal.zzr.zzkr();
        if (com.google.android.gms.ads.internal.util.zzj.zzaz(this.zzgxt) && zzvlVar.zzcia == null) {
            zzazk.zzev("Failed to load the ad because app ID is missing.");
            zzcxy zzcxyVar = this.zzgxy;
            if (zzcxyVar != null) {
                zzcxyVar.zzc(zzdok.zza(zzdom.APP_ID_MISSING, null, null));
            }
            return false;
        } else if (zzasm()) {
            return false;
        } else {
            zzdod.zze(this.zzgxt, zzvlVar.zzchq);
            this.zzgyn = null;
            return this.zzgyl.zza(zzvlVar, this.zzbut, new zzdku(this.zzbpo), new zzcyw(this));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zzbl(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized void zze(b bVar) {
        if (this.zzgyn == null) {
            zzazk.zzex("Interstitial can not be shown before loaded.");
            this.zzgxy.zzk(zzdok.zza(zzdom.NOT_READY, null, null));
            return;
        }
        this.zzgyn.zzb(this.zzgyo, (Activity) d.y0(bVar));
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final b zzke() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zzkf() {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzvs zzkg() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized String zzkh() {
        zzbyy zzbyyVar = this.zzgyn;
        if (zzbyyVar == null || zzbyyVar.zzakr() == null) {
            return null;
        }
        return this.zzgyn.zzakr().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final synchronized zzyx zzki() {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcyy)).booleanValue()) {
            zzbyy zzbyyVar = this.zzgyn;
            if (zzbyyVar == null) {
                return null;
            }
            return zzbyyVar.zzakr();
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
    public final void zza(zzvl zzvlVar, zzxc zzxcVar) {
        this.zzgxy.zza(zzxcVar);
        zza(zzvlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzyb zzybVar) {
        this.zzgxy.zzb(zzybVar);
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
    public final synchronized void zza(zzacl zzaclVar) {
        q.e("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzgyl.zza(zzaclVar);
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

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzauu zzauuVar) {
        this.zzgym.zzb(zzauuVar);
    }
}
