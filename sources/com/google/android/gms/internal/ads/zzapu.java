package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
final class zzapu implements MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> {
    private final /* synthetic */ zzank zzdon;
    private final /* synthetic */ zzape zzdor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzapu(zzapt zzaptVar, zzape zzapeVar, zzank zzankVar) {
        this.zzdor = zzapeVar;
        this.zzdon = zzankVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* renamed from: zza */
    public final MediationNativeAdCallback onSuccess(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        if (unifiedNativeAdMapper == null) {
            zzazk.zzex("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdor.zzdl("Adapter returned null.");
                return null;
            } catch (RemoteException e2) {
                zzazk.zzc("", e2);
                return null;
            }
        }
        try {
            this.zzdor.zza(new zzaoz(unifiedNativeAdMapper));
        } catch (RemoteException e3) {
            zzazk.zzc("", e3);
        }
        return new zzapz(this.zzdon);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        try {
            this.zzdor.zzdl(str);
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(AdError adError) {
        try {
            this.zzdor.zzg(adError.zzdq());
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }
}
