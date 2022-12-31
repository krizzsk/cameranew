package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
final class zzaps implements MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> {
    private final /* synthetic */ zzaoy zzdom;
    private final /* synthetic */ zzank zzdon;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaps(zzapt zzaptVar, zzaoy zzaoyVar, zzank zzankVar) {
        this.zzdom = zzaoyVar;
        this.zzdon = zzankVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* renamed from: zza */
    public final MediationBannerAdCallback onSuccess(MediationBannerAd mediationBannerAd) {
        if (mediationBannerAd == null) {
            zzazk.zzex("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdom.zzdl("Adapter returned null.");
                return null;
            } catch (RemoteException e2) {
                zzazk.zzc("", e2);
                return null;
            }
        }
        try {
            this.zzdom.zzx(d.z0(mediationBannerAd.getView()));
        } catch (RemoteException e3) {
            zzazk.zzc("", e3);
        }
        return new zzapz(this.zzdon);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        try {
            this.zzdom.zzdl(str);
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(AdError adError) {
        try {
            this.zzdom.zzg(adError.zzdq());
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }
}
