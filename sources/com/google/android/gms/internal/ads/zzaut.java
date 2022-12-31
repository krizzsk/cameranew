package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaut extends zzgw implements zzaur {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaut(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void destroy() throws RemoteException {
        zzb(8, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final Bundle getAdMetadata() throws RemoteException {
        Parcel zza = zza(15, zzdo());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel zza = zza(12, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final boolean isLoaded() throws RemoteException {
        Parcel zza = zza(5, zzdo());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void pause() throws RemoteException {
        zzb(6, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void resume() throws RemoteException {
        zzb(7, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void setAppPackageName(String str) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzb(17, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void setCustomData(String str) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzb(19, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.writeBoolean(zzdo, z);
        zzb(34, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void setUserId(String str) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzb(13, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void show() throws RemoteException {
        zzb(2, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zza(zzava zzavaVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzavaVar);
        zzb(1, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zzi(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(18, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zzj(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(9, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zzk(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(10, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final zzyx zzki() throws RemoteException {
        Parcel zza = zza(21, zzdo());
        zzyx zzj = zzza.zzj(zza.readStrongBinder());
        zza.recycle();
        return zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zzl(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(11, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final boolean zzrw() throws RemoteException {
        Parcel zza = zza(20, zzdo());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zza(zzauu zzauuVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzauuVar);
        zzb(3, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zza(zzxs zzxsVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzxsVar);
        zzb(14, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzaur
    public final void zza(zzaup zzaupVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzaupVar);
        zzb(16, zzdo);
    }
}
