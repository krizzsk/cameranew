package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzafz extends zzgw implements zzafx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzafz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzafx
    public final void zza(zzafn zzafnVar, String str) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzafnVar);
        zzdo.writeString(str);
        zzb(1, zzdo);
    }
}
