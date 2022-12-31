package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcgs implements com.google.android.gms.ads.internal.overlay.zzq, com.google.android.gms.ads.internal.overlay.zzv, zzahi, zzahk, zzvc {
    private zzvc zzchd;
    private zzahi zzdgz;
    private zzahk zzdha;
    private com.google.android.gms.ads.internal.overlay.zzq zzdsv;
    private com.google.android.gms.ads.internal.overlay.zzv zzdsz;

    private zzcgs() {
    }

    @Override // com.google.android.gms.internal.ads.zzvc
    public final synchronized void onAdClicked() {
        zzvc zzvcVar = this.zzchd;
        if (zzvcVar != null) {
            zzvcVar.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final synchronized void onAppEvent(String str, @Nullable String str2) {
        zzahk zzahkVar = this.zzdha;
        if (zzahkVar != null) {
            zzahkVar.onAppEvent(str, str2);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final synchronized void onPause() {
        com.google.android.gms.ads.internal.overlay.zzq zzqVar = this.zzdsv;
        if (zzqVar != null) {
            zzqVar.onPause();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final synchronized void onResume() {
        com.google.android.gms.ads.internal.overlay.zzq zzqVar = this.zzdsv;
        if (zzqVar != null) {
            zzqVar.onResume();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final synchronized void onUserLeaveHint() {
        com.google.android.gms.ads.internal.overlay.zzq zzqVar = this.zzdsv;
        if (zzqVar != null) {
            zzqVar.onUserLeaveHint();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final synchronized void zza(com.google.android.gms.ads.internal.overlay.zzn zznVar) {
        com.google.android.gms.ads.internal.overlay.zzq zzqVar = this.zzdsv;
        if (zzqVar != null) {
            zzqVar.zza(zznVar);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final synchronized void zzvo() {
        com.google.android.gms.ads.internal.overlay.zzq zzqVar = this.zzdsv;
        if (zzqVar != null) {
            zzqVar.zzvo();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzv
    public final synchronized void zzwg() {
        com.google.android.gms.ads.internal.overlay.zzv zzvVar = this.zzdsz;
        if (zzvVar != null) {
            zzvVar.zzwg();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcgs(zzcgl zzcglVar) {
        this();
    }

    @Override // com.google.android.gms.internal.ads.zzahi
    public final synchronized void zza(String str, Bundle bundle) {
        zzahi zzahiVar = this.zzdgz;
        if (zzahiVar != null) {
            zzahiVar.zza(str, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zza(zzvc zzvcVar, zzahi zzahiVar, com.google.android.gms.ads.internal.overlay.zzq zzqVar, zzahk zzahkVar, com.google.android.gms.ads.internal.overlay.zzv zzvVar) {
        this.zzchd = zzvcVar;
        this.zzdgz = zzahiVar;
        this.zzdsv = zzqVar;
        this.zzdha = zzahkVar;
        this.zzdsz = zzvVar;
    }
}
