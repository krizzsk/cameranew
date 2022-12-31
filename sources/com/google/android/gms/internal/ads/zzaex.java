package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaex extends zzgw implements zzaev {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaex(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzaev
    public final void destroy() throws RemoteException {
        zzb(4, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzaev
    public final void zza(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(3, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzaev
    public final void zzb(String str, b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzgx.zza(zzdo, bVar);
        zzb(1, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzaev
    public final void zzc(b bVar, int i2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzdo.writeInt(i2);
        zzb(5, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzaev
    public final b zzco(String str) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        Parcel zza = zza(2, zzdo);
        b x0 = b.a.x0(zza.readStrongBinder());
        zza.recycle();
        return x0;
    }

    @Override // com.google.android.gms.internal.ads.zzaev
    public final void zzf(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(6, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzaev
    public final void zzg(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(7, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzaev
    public final void zzh(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(9, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzaev
    public final void zza(zzaem zzaemVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzaemVar);
        zzb(8, zzdo);
    }
}
