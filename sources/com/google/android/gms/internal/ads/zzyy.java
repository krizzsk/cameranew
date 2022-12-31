package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzyy extends zzgw implements zzyw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    @Override // com.google.android.gms.internal.ads.zzyw
    public final void zza(zzvu zzvuVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzvuVar);
        zzb(1, zzdo);
    }
}
