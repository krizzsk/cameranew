package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzxp extends zzgw implements zzxq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final IBinder zza(b bVar, zzvs zzvsVar, String str, zzane zzaneVar, int i2, int i3) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzvsVar);
        zzdo.writeString(str);
        zzgx.zza(zzdo, zzaneVar);
        zzdo.writeInt(204204000);
        zzdo.writeInt(i3);
        Parcel zza = zza(2, zzdo);
        IBinder readStrongBinder = zza.readStrongBinder();
        zza.recycle();
        return readStrongBinder;
    }
}
