package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzavh extends zzgw implements zzavf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzavh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final void zza(b bVar, zzavj zzavjVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzavjVar);
        zzb(7, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final void zzaf(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(1, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final void zzag(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(3, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final void zzah(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(4, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final void zzai(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(5, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final void zzaj(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(6, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final void zzak(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(8, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final void zzal(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(10, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final void zzam(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(11, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final void zzb(Bundle bundle) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bundle);
        zzb(12, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final void zzd(b bVar, int i2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzdo.writeInt(i2);
        zzb(2, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final void zze(b bVar, int i2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzdo.writeInt(i2);
        zzb(9, zzdo);
    }
}
