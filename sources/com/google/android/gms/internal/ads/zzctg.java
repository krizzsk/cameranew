package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzctg extends zzave implements zzbsu {
    @GuardedBy("this")
    private zzbsx zzguf;
    @GuardedBy("this")
    private zzavf zzguh;
    @GuardedBy("this")
    private zzbyn zzgui;

    public final synchronized void zza(zzavf zzavfVar) {
        this.zzguh = zzavfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final synchronized void zzaf(b bVar) throws RemoteException {
        zzavf zzavfVar = this.zzguh;
        if (zzavfVar != null) {
            zzavfVar.zzaf(bVar);
        }
        zzbyn zzbynVar = this.zzgui;
        if (zzbynVar != null) {
            zzbynVar.onInitializationSucceeded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final synchronized void zzag(b bVar) throws RemoteException {
        zzavf zzavfVar = this.zzguh;
        if (zzavfVar != null) {
            zzavfVar.zzag(bVar);
        }
        zzbsx zzbsxVar = this.zzguf;
        if (zzbsxVar != null) {
            zzbsxVar.onAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final synchronized void zzah(b bVar) throws RemoteException {
        zzavf zzavfVar = this.zzguh;
        if (zzavfVar != null) {
            zzavfVar.zzah(bVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final synchronized void zzai(b bVar) throws RemoteException {
        zzavf zzavfVar = this.zzguh;
        if (zzavfVar != null) {
            zzavfVar.zzai(bVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final synchronized void zzaj(b bVar) throws RemoteException {
        zzavf zzavfVar = this.zzguh;
        if (zzavfVar != null) {
            zzavfVar.zzaj(bVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final synchronized void zzak(b bVar) throws RemoteException {
        zzavf zzavfVar = this.zzguh;
        if (zzavfVar != null) {
            zzavfVar.zzak(bVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final synchronized void zzal(b bVar) throws RemoteException {
        zzavf zzavfVar = this.zzguh;
        if (zzavfVar != null) {
            zzavfVar.zzal(bVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final synchronized void zzam(b bVar) throws RemoteException {
        zzavf zzavfVar = this.zzguh;
        if (zzavfVar != null) {
            zzavfVar.zzam(bVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final synchronized void zzb(Bundle bundle) throws RemoteException {
        zzavf zzavfVar = this.zzguh;
        if (zzavfVar != null) {
            zzavfVar.zzb(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final synchronized void zzd(b bVar, int i2) throws RemoteException {
        zzavf zzavfVar = this.zzguh;
        if (zzavfVar != null) {
            zzavfVar.zzd(bVar, i2);
        }
        zzbyn zzbynVar = this.zzgui;
        if (zzbynVar != null) {
            zzbynVar.zzdy(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final synchronized void zze(b bVar, int i2) throws RemoteException {
        zzavf zzavfVar = this.zzguh;
        if (zzavfVar != null) {
            zzavfVar.zze(bVar, i2);
        }
        zzbsx zzbsxVar = this.zzguf;
        if (zzbsxVar != null) {
            zzbsxVar.onAdFailedToLoad(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final synchronized void zza(zzbsx zzbsxVar) {
        this.zzguf = zzbsxVar;
    }

    public final synchronized void zza(zzbyn zzbynVar) {
        this.zzgui = zzbynVar;
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final synchronized void zza(b bVar, zzavj zzavjVar) throws RemoteException {
        zzavf zzavfVar = this.zzguh;
        if (zzavfVar != null) {
            zzavfVar.zza(bVar, zzavjVar);
        }
    }
}
