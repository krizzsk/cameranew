package com.google.android.gms.ads.internal.util;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzgw;
import com.google.android.gms.internal.ads.zzgx;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbi extends zzgw implements zzbg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.util.IWorkManagerUtil");
    }

    @Override // com.google.android.gms.ads.internal.util.zzbg
    public final void zzap(com.google.android.gms.dynamic.b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(2, zzdo);
    }

    @Override // com.google.android.gms.ads.internal.util.zzbg
    public final boolean zzd(com.google.android.gms.dynamic.b bVar, String str, String str2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzdo.writeString(str);
        zzdo.writeString(str2);
        Parcel zza = zza(1, zzdo);
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }
}
