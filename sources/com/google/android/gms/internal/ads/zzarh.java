package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzarh extends zzgw implements zzarf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzarh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    @Override // com.google.android.gms.internal.ads.zzarf
    public final void zzc(Intent intent) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, intent);
        zzb(1, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzarf
    public final void zzvt() throws RemoteException {
        zzb(3, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzarf
    public final void zzc(b bVar, String str, String str2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzdo.writeString(str);
        zzdo.writeString(str2);
        zzb(2, zzdo);
    }
}
