package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzblp extends zzsn {
    private boolean zzbpk = false;
    private final zzxl zzbuz;
    private final zzblq zzfug;
    private final zzdil zzfuh;

    public zzblp(zzblq zzblqVar, zzxl zzxlVar, zzdil zzdilVar) {
        this.zzfug = zzblqVar;
        this.zzbuz = zzxlVar;
        this.zzfuh = zzdilVar;
    }

    @Override // com.google.android.gms.internal.ads.zzsk
    public final void setImmersiveMode(boolean z) {
        this.zzbpk = z;
    }

    @Override // com.google.android.gms.internal.ads.zzsk
    public final void zza(b bVar, zzsv zzsvVar) {
        try {
            this.zzfuh.zza(zzsvVar);
            this.zzfug.zza((Activity) d.y0(bVar), zzsvVar, this.zzbpk);
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsk
    public final void zza(zzsq zzsqVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzsk
    public final zzxl zzdx() {
        return this.zzbuz;
    }

    @Override // com.google.android.gms.internal.ads.zzsk
    public final zzyx zzki() {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcyy)).booleanValue()) {
            return this.zzfug.zzakr();
        }
        return null;
    }
}
