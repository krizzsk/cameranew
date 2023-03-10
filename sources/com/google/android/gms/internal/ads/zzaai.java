package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaai extends zzavp {
    @Override // com.google.android.gms.internal.ads.zzavm
    public final Bundle getAdMetadata() throws RemoteException {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final String getMediationAdapterClassName() throws RemoteException {
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final boolean isLoaded() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final void setImmersiveMode(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final void zza(b bVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final void zza(zzavr zzavrVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final void zza(zzavz zzavzVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final void zza(zzawh zzawhVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final void zza(zzvl zzvlVar, zzavu zzavuVar) throws RemoteException {
        zza(zzavuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final void zza(zzyr zzyrVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final void zza(zzyw zzywVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final void zzb(zzvl zzvlVar, zzavu zzavuVar) throws RemoteException {
        zza(zzavuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final void zze(b bVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final zzyx zzki() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    @Nullable
    public final zzavl zzrv() {
        return null;
    }

    private static void zza(final zzavu zzavuVar) {
        zzazk.zzev("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzaza.zzaac.post(new Runnable(zzavuVar) { // from class: com.google.android.gms.internal.ads.zzaal
            private final zzavu zzclp;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzclp = zzavuVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzavu zzavuVar2 = this.zzclp;
                if (zzavuVar2 != null) {
                    try {
                        zzavuVar2.onRewardedAdFailedToLoad(1);
                    } catch (RemoteException e2) {
                        zzazk.zze("#007 Could not call remote method.", e2);
                    }
                }
            }
        });
    }
}
