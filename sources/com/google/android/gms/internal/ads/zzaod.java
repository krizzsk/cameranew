package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
final class zzaod implements InitializationCompleteCallback {
    private final /* synthetic */ zzajj zzdnu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaod(zzaoa zzaoaVar, zzajj zzajjVar) {
        this.zzdnu = zzajjVar;
    }

    @Override // com.google.android.gms.ads.mediation.InitializationCompleteCallback
    public final void onInitializationFailed(String str) {
        try {
            this.zzdnu.onInitializationFailed(str);
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.InitializationCompleteCallback
    public final void onInitializationSucceeded() {
        try {
            this.zzdnu.onInitializationSucceeded();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }
}
