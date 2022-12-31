package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzczx implements zzdzl<zzdak> {
    private final /* synthetic */ zzaxx zzgzv;
    private final /* synthetic */ zzczo zzgzw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzczx(zzczo zzczoVar, zzaxx zzaxxVar) {
        this.zzgzw = zzczoVar;
        this.zzgzv = zzaxxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final /* synthetic */ void onSuccess(@Nullable zzdak zzdakVar) {
        zzazn zzaznVar;
        zzdak zzdakVar2 = zzdakVar;
        try {
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzczc)).booleanValue()) {
                zzaznVar = this.zzgzw.zzboz;
                if (zzaznVar.zzehz >= ((Integer) zzwr.zzqr().zzd(zzabp.zzcze)).intValue()) {
                    if (zzdakVar2 == null) {
                        this.zzgzv.zza(null, null, null);
                        return;
                    } else {
                        this.zzgzv.zza(zzdakVar2.zzhae, zzdakVar2.zzhaf, zzdakVar2.zzhag);
                        return;
                    }
                }
            }
            if (zzdakVar2 == null) {
                this.zzgzv.zzj(null, null);
            } else {
                this.zzgzv.zzj(zzdakVar2.zzhae, zzdakVar2.zzhaf);
            }
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
        try {
            zzaxx zzaxxVar = this.zzgzv;
            String valueOf = String.valueOf(th.getMessage());
            zzaxxVar.onError(valueOf.length() != 0 ? "Internal error. ".concat(valueOf) : new String("Internal error. "));
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }
}
