package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzhc extends zzgw implements zzhb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.clearcut.IClearcut");
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void log() throws RemoteException {
        zzb(3, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zza(b bVar, String str) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzdo.writeString(str);
        zzb(2, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zzc(byte[] bArr) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeByteArray(bArr);
        zzb(5, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zzs(int i2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeInt(i2);
        zzb(6, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zzt(int i2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeInt(i2);
        zzb(7, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zza(int[] iArr) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeIntArray(null);
        zzb(4, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zza(b bVar, String str, String str2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzdo.writeString(str);
        zzdo.writeString(null);
        zzb(8, zzdo);
    }
}
