package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import java.util.Collections;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaae extends zzyf {
    private zzajk zzcll;

    @Override // com.google.android.gms.internal.ads.zzyg
    public final String getVersionString() {
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void initialize() throws RemoteException {
        zzazk.zzev("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        zzaza.zzaac.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzaah
            private final zzaae zzcln;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcln = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzcln.zzru();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void setAppMuted(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void setAppVolume(float f2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zza(zzaao zzaaoVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zza(zzajk zzajkVar) throws RemoteException {
        this.zzcll = zzajkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zza(zzane zzaneVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zza(String str, b bVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zzb(b bVar, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zzcd(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zzce(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final float zzra() throws RemoteException {
        return 1.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final boolean zzrb() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final List<zzajh> zzrc() throws RemoteException {
        return Collections.emptyList();
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zzrd() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzru() {
        zzajk zzajkVar = this.zzcll;
        if (zzajkVar != null) {
            try {
                zzajkVar.zze(Collections.emptyList());
            } catch (RemoteException e2) {
                zzazk.zzd("Could not notify onComplete event.", e2);
            }
        }
    }
}
