package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcox implements zzdzl<ParcelFileDescriptor> {
    private final /* synthetic */ zzatk zzgps;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcox(zzcol zzcolVar, zzatk zzatkVar) {
        this.zzgps = zzatkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final /* synthetic */ void onSuccess(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            this.zzgps.zzb(parcelFileDescriptor);
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zza("Service can't call client", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
        try {
            this.zzgps.zza(com.google.android.gms.ads.internal.util.zzaq.zzc(th));
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zza("Service can't call client", e2);
        }
    }
}
