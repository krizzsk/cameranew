package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzarr;
import com.google.android.gms.internal.ads.zzvc;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzw extends zzarr {
    private AdOverlayInfoParcel a;
    private Activity b;
    private boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3465d = false;

    public zzw(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.a = adOverlayInfoParcel;
        this.b = activity;
    }

    private final synchronized void x0() {
        if (!this.f3465d) {
            zzq zzqVar = this.a.zzdsv;
            if (zzqVar != null) {
                zzqVar.zza(zzn.OTHER);
            }
            this.f3465d = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onActivityResult(int i2, int i3, Intent intent) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onBackPressed() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onCreate(Bundle bundle) {
        zzq zzqVar;
        boolean z = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z = true;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.a;
        if (adOverlayInfoParcel == null) {
            this.b.finish();
        } else if (z) {
            this.b.finish();
        } else {
            if (bundle == null) {
                zzvc zzvcVar = adOverlayInfoParcel.zzchd;
                if (zzvcVar != null) {
                    zzvcVar.onAdClicked();
                }
                if (this.b.getIntent() != null && this.b.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) && (zzqVar = this.a.zzdsv) != null) {
                    zzqVar.zzvo();
                }
            }
            com.google.android.gms.ads.internal.zzr.zzkp();
            Activity activity = this.b;
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.a;
            zzd zzdVar = adOverlayInfoParcel2.zzdsu;
            if (zzb.zza(activity, zzdVar, adOverlayInfoParcel2.zzdsz, zzdVar.zzdif)) {
                return;
            }
            this.b.finish();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onDestroy() throws RemoteException {
        if (this.b.isFinishing()) {
            x0();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onPause() throws RemoteException {
        zzq zzqVar = this.a.zzdsv;
        if (zzqVar != null) {
            zzqVar.onPause();
        }
        if (this.b.isFinishing()) {
            x0();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onRestart() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onResume() throws RemoteException {
        if (this.c) {
            this.b.finish();
            return;
        }
        this.c = true;
        zzq zzqVar = this.a.zzdsv;
        if (zzqVar != null) {
            zzqVar.onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.c);
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onStart() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onStop() throws RemoteException {
        if (this.b.isFinishing()) {
            x0();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onUserLeaveHint() throws RemoteException {
        zzq zzqVar = this.a.zzdsv;
        if (zzqVar != null) {
            zzqVar.onUserLeaveHint();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void zzad(com.google.android.gms.dynamic.b bVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void zzdp() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final boolean zzvw() throws RemoteException {
        return false;
    }
}
