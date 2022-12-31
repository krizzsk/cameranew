package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzapg extends zzgw implements zzape {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzapg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzape
    public final void zza(zzanx zzanxVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzanxVar);
        zzb(1, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzape
    public final void zzdl(String str) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzb(2, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzape
    public final void zzg(zzvg zzvgVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzvgVar);
        zzb(3, zzdo);
    }
}
