package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzayf extends zzgw implements zzayd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzayf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGeneratorCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzayd
    public final zzaxy zze(b bVar, zzane zzaneVar, int i2) throws RemoteException {
        zzaxy zzayaVar;
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzaneVar);
        zzdo.writeInt(204204000);
        Parcel zza = zza(2, zzdo);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzayaVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGenerator");
            if (queryLocalInterface instanceof zzaxy) {
                zzayaVar = (zzaxy) queryLocalInterface;
            } else {
                zzayaVar = new zzaya(readStrongBinder);
            }
        }
        zza.recycle();
        return zzayaVar;
    }
}
