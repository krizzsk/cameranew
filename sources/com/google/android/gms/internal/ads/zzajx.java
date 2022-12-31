package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzajx extends zzgw implements zzajv {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    @Override // com.google.android.gms.internal.ads.zzajv
    public final void destroy() throws RemoteException {
        zzb(4, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzajv
    public final zzzc getVideoController() throws RemoteException {
        Parcel zza = zza(3, zzdo());
        zzzc zzk = zzzb.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzajv
    public final void zza(b bVar, zzajw zzajwVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzajwVar);
        zzb(5, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzajv
    public final void zzr(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(6, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzajv
    public final zzaem zzty() throws RemoteException {
        Parcel zza = zza(7, zzdo());
        zzaem zzn = zzaep.zzn(zza.readStrongBinder());
        zza.recycle();
        return zzn;
    }
}
