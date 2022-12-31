package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzapa extends zzgw implements zzaoy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzapa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaoy
    public final void zzdl(String str) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzb(2, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzaoy
    public final void zzg(zzvg zzvgVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzvgVar);
        zzb(3, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzaoy
    public final void zzx(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(1, zzdo);
    }
}
