package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzajm extends zzgw implements zzajk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzajk
    public final void zze(List<zzajh> list) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeTypedList(list);
        zzb(1, zzdo);
    }
}
