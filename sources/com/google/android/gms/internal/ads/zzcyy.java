package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcyy {
    @Nullable
    @GuardedBy("this")
    private zzyx zzadv;
    @GuardedBy("this")
    private boolean zzafd = false;
    private final String zzbut;
    private final zzczc<zzbnt> zzgyx;

    public zzcyy(zzczc<zzbnt> zzczcVar, String str) {
        this.zzgyx = zzczcVar;
        this.zzbut = str;
    }

    public final synchronized String getMediationAdapterClassName() {
        try {
            zzyx zzyxVar = this.zzadv;
            if (zzyxVar != null) {
                return zzyxVar.getMediationAdapterClassName();
            }
            return null;
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
            return null;
        }
    }

    public final synchronized boolean isLoading() throws RemoteException {
        return this.zzgyx.isLoading();
    }

    public final synchronized void zza(zzvl zzvlVar, int i2) throws RemoteException {
        this.zzadv = null;
        this.zzafd = this.zzgyx.zza(zzvlVar, this.zzbut, new zzczd(i2), new zzcyx(this));
    }

    public final synchronized String zzkh() {
        try {
            zzyx zzyxVar = this.zzadv;
            if (zzyxVar != null) {
                return zzyxVar.getMediationAdapterClassName();
            }
            return null;
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
            return null;
        }
    }
}
