package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzajy extends zzgw implements zzajw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void zzda(int i2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeInt(i2);
        zzb(2, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void zzue() throws RemoteException {
        zzb(1, zzdo());
    }
}
