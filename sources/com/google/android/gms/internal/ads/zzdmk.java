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
public final class zzdmk extends zzavp {
    private final String zzbut;
    private final zzdnk zzfyy;
    private final Context zzgxt;
    @GuardedBy("this")
    private boolean zzgyo = ((Boolean) zzwr.zzqr().zzd(zzabp.zzcox)).booleanValue();
    private final zzdmc zzhip;
    private final zzdlh zzhiq;
    @Nullable
    @GuardedBy("this")
    private zzchb zzhir;

    public zzdmk(@Nullable String str, zzdmc zzdmcVar, Context context, zzdlh zzdlhVar, zzdnk zzdnkVar) {
        this.zzbut = str;
        this.zzhip = zzdmcVar;
        this.zzhiq = zzdlhVar;
        this.zzfyy = zzdnkVar;
        this.zzgxt = context;
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final Bundle getAdMetadata() {
        q.e("#008 Must be called on the main UI thread.");
        zzchb zzchbVar = this.zzhir;
        return zzchbVar != null ? zzchbVar.getAdMetadata() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final synchronized String getMediationAdapterClassName() throws RemoteException {
        zzchb zzchbVar = this.zzhir;
        if (zzchbVar == null || zzchbVar.zzakr() == null) {
            return null;
        }
        return this.zzhir.zzakr().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final boolean isLoaded() {
        q.e("#008 Must be called on the main UI thread.");
        zzchb zzchbVar = this.zzhir;
        return (zzchbVar == null || zzchbVar.isUsed()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final synchronized void setImmersiveMode(boolean z) {
        q.e("setImmersiveMode must be called on the main UI thread.");
        this.zzgyo = z;
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final synchronized void zza(zzvl zzvlVar, zzavu zzavuVar) throws RemoteException {
        zza(zzvlVar, zzavuVar, zzdnh.zzhkl);
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final synchronized void zzb(zzvl zzvlVar, zzavu zzavuVar) throws RemoteException {
        zza(zzvlVar, zzavuVar, zzdnh.zzhkm);
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final synchronized void zze(b bVar) throws RemoteException {
        zza(bVar, this.zzgyo);
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final zzyx zzki() {
        zzchb zzchbVar;
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcyy)).booleanValue() && (zzchbVar = this.zzhir) != null) {
            return zzchbVar.zzakr();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    @Nullable
    public final zzavl zzrv() {
        q.e("#008 Must be called on the main UI thread.");
        zzchb zzchbVar = this.zzhir;
        if (zzchbVar != null) {
            return zzchbVar.zzrv();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final synchronized void zza(b bVar, boolean z) throws RemoteException {
        q.e("#008 Must be called on the main UI thread.");
        if (this.zzhir == null) {
            zzazk.zzex("Rewarded can not be shown before loaded");
            this.zzhiq.zzk(zzdok.zza(zzdom.NOT_READY, null, null));
            return;
        }
        this.zzhir.zzb(z, (Activity) d.y0(bVar));
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final void zza(zzavr zzavrVar) {
        q.e("#008 Must be called on the main UI thread.");
        this.zzhiq.zzb(zzavrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final void zza(zzavz zzavzVar) {
        q.e("#008 Must be called on the main UI thread.");
        this.zzhiq.zzb(zzavzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final void zza(zzyr zzyrVar) {
        if (zzyrVar == null) {
            this.zzhiq.zza(null);
        } else {
            this.zzhiq.zza(new zzdmn(this, zzyrVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final synchronized void zza(zzawh zzawhVar) {
        q.e("#008 Must be called on the main UI thread.");
        zzdnk zzdnkVar = this.zzfyy;
        zzdnkVar.zzdzh = zzawhVar.zzdzh;
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcpk)).booleanValue()) {
            zzdnkVar.zzdzi = zzawhVar.zzdzi;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final void zza(zzyw zzywVar) {
        q.e("setOnPaidEventListener must be called on the main UI thread.");
        this.zzhiq.zzd(zzywVar);
    }

    private final synchronized void zza(zzvl zzvlVar, zzavu zzavuVar, int i2) throws RemoteException {
        q.e("#008 Must be called on the main UI thread.");
        this.zzhiq.zzb(zzavuVar);
        com.google.android.gms.ads.internal.zzr.zzkr();
        if (com.google.android.gms.ads.internal.util.zzj.zzaz(this.zzgxt) && zzvlVar.zzcia == null) {
            zzazk.zzev("Failed to load the ad because app ID is missing.");
            this.zzhiq.zzc(zzdok.zza(zzdom.APP_ID_MISSING, null, null));
        } else if (this.zzhir != null) {
        } else {
            zzdmd zzdmdVar = new zzdmd(null);
            this.zzhip.zzec(i2);
            this.zzhip.zza(zzvlVar, this.zzbut, zzdmdVar, new zzdmm(this));
        }
    }
}
