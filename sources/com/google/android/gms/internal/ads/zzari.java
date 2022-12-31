package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzari extends zzgw implements zzarg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzari(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.offline.IOfflineUtilsCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzarg
    public final zzarf zzc(b bVar, zzane zzaneVar, int i2) throws RemoteException {
        zzarf zzarhVar;
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzaneVar);
        zzdo.writeInt(204204000);
        Parcel zza = zza(1, zzdo);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzarhVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtils");
            if (queryLocalInterface instanceof zzarf) {
                zzarhVar = (zzarf) queryLocalInterface;
            } else {
                zzarhVar = new zzarh(readStrongBinder);
            }
        }
        zza.recycle();
        return zzarhVar;
    }
}
