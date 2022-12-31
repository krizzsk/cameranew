package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzyi extends zzgw implements zzyg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final String getVersionString() throws RemoteException {
        Parcel zza = zza(9, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void initialize() throws RemoteException {
        zzb(1, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void setAppMuted(boolean z) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.writeBoolean(zzdo, z);
        zzb(4, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void setAppVolume(float f2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeFloat(f2);
        zzb(2, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zza(String str, b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzgx.zza(zzdo, bVar);
        zzb(6, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zzb(b bVar, String str) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzdo.writeString(str);
        zzb(5, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zzcd(String str) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzb(3, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zzce(String str) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzb(10, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final float zzra() throws RemoteException {
        Parcel zza = zza(7, zzdo());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final boolean zzrb() throws RemoteException {
        Parcel zza = zza(8, zzdo());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final List<zzajh> zzrc() throws RemoteException {
        Parcel zza = zza(13, zzdo());
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzajh.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zzrd() throws RemoteException {
        zzb(15, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zza(zzane zzaneVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzaneVar);
        zzb(11, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zza(zzajk zzajkVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzajkVar);
        zzb(12, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzyg
    public final void zza(zzaao zzaaoVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzaaoVar);
        zzb(14, zzdo);
    }
}
