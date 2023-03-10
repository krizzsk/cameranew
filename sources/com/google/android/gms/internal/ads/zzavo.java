package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzavo extends zzgw implements zzavm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzavo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final Bundle getAdMetadata() throws RemoteException {
        Parcel zza = zza(9, zzdo());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel zza = zza(4, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final boolean isLoaded() throws RemoteException {
        Parcel zza = zza(3, zzdo());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.writeBoolean(zzdo, z);
        zzb(15, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final void zza(zzvl zzvlVar, zzavu zzavuVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzvlVar);
        zzgx.zza(zzdo, zzavuVar);
        zzb(1, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final void zzb(zzvl zzvlVar, zzavu zzavuVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzvlVar);
        zzgx.zza(zzdo, zzavuVar);
        zzb(14, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final void zze(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(5, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final zzyx zzki() throws RemoteException {
        Parcel zza = zza(12, zzdo());
        zzyx zzj = zzza.zzj(zza.readStrongBinder());
        zza.recycle();
        return zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final zzavl zzrv() throws RemoteException {
        zzavl zzavnVar;
        Parcel zza = zza(11, zzdo());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzavnVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
            if (queryLocalInterface instanceof zzavl) {
                zzavnVar = (zzavl) queryLocalInterface;
            } else {
                zzavnVar = new zzavn(readStrongBinder);
            }
        }
        zza.recycle();
        return zzavnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final void zza(zzavr zzavrVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzavrVar);
        zzb(2, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final void zza(zzavz zzavzVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzavzVar);
        zzb(6, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final void zza(zzawh zzawhVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzawhVar);
        zzb(7, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final void zza(zzyr zzyrVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzyrVar);
        zzb(8, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final void zza(b bVar, boolean z) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.writeBoolean(zzdo, z);
        zzb(10, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzavm
    public final void zza(zzyw zzywVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzywVar);
        zzb(13, zzdo);
    }
}
