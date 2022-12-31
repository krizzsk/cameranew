package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
final class zzapx implements SignalCallbacks {
    private final /* synthetic */ zzapp zzdov;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzapx(zzapt zzaptVar, zzapp zzappVar) {
        this.zzdov = zzappVar;
    }

    @Override // com.google.android.gms.ads.mediation.rtb.SignalCallbacks
    public final void onFailure(String str) {
        try {
            this.zzdov.onFailure(str);
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.rtb.SignalCallbacks
    public final void onSuccess(String str) {
        try {
            this.zzdov.zzdn(str);
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.rtb.SignalCallbacks
    public final void onFailure(AdError adError) {
        try {
            this.zzdov.zzh(adError.zzdq());
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }
}
