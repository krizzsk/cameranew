package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdsv extends zzgw implements zzdst {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdsv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.omid.IOmid");
    }

    @Override // com.google.android.gms.internal.ads.zzdst
    public final String getVersion() throws RemoteException {
        Parcel zza = zza(6, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzdst
    public final b zza(String str, b bVar, String str2, String str3, String str4, String str5) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzgx.zza(zzdo, bVar);
        zzdo.writeString(str2);
        zzdo.writeString(str3);
        zzdo.writeString(str4);
        zzdo.writeString(str5);
        Parcel zza = zza(9, zzdo);
        b x0 = b.a.x0(zza.readStrongBinder());
        zza.recycle();
        return x0;
    }

    @Override // com.google.android.gms.internal.ads.zzdst
    public final void zzab(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(4, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzdst
    public final void zzac(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(7, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzdst
    public final boolean zzav(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        Parcel zza = zza(2, zzdo);
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzdst
    public final b zzb(String str, b bVar, String str2, String str3, String str4, String str5, String str6, String str7, String str8) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzgx.zza(zzdo, bVar);
        zzdo.writeString(str2);
        zzdo.writeString(str3);
        zzdo.writeString(str4);
        zzdo.writeString(str5);
        zzdo.writeString(str6);
        zzdo.writeString(str7);
        zzdo.writeString(str8);
        Parcel zza = zza(11, zzdo);
        b x0 = b.a.x0(zza.readStrongBinder());
        zza.recycle();
        return x0;
    }

    @Override // com.google.android.gms.internal.ads.zzdst
    public final void zzc(b bVar, b bVar2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, bVar2);
        zzb(5, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzdst
    public final void zzd(b bVar, b bVar2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, bVar2);
        zzb(8, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzdst
    public final b zza(String str, b bVar, String str2, String str3, String str4, String str5, String str6, String str7, String str8) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzgx.zza(zzdo, bVar);
        zzdo.writeString(str2);
        zzdo.writeString(str3);
        zzdo.writeString(str4);
        zzdo.writeString(str5);
        zzdo.writeString(str6);
        zzdo.writeString(str7);
        zzdo.writeString(str8);
        Parcel zza = zza(10, zzdo);
        b x0 = b.a.x0(zza.readStrongBinder());
        zza.recycle();
        return x0;
    }
}
