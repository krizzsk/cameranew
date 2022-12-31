package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzapm extends zzgw implements zzapk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzapm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final zzzc getVideoController() throws RemoteException {
        Parcel zza = zza(5, zzdo());
        zzzc zzk = zzzb.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final void zza(b bVar, String str, Bundle bundle, Bundle bundle2, zzvs zzvsVar, zzapp zzappVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzdo.writeString(str);
        zzgx.zza(zzdo, bundle);
        zzgx.zza(zzdo, bundle2);
        zzgx.zza(zzdo, zzvsVar);
        zzgx.zza(zzdo, zzappVar);
        zzb(1, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final boolean zzaa(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        Parcel zza = zza(17, zzdo);
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final void zzb(String str, String str2, zzvl zzvlVar, b bVar, zzapj zzapjVar, zzank zzankVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzdo.writeString(str2);
        zzgx.zza(zzdo, zzvlVar);
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzapjVar);
        zzgx.zza(zzdo, zzankVar);
        zzb(20, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final void zzdm(String str) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzb(19, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final zzapy zzvc() throws RemoteException {
        Parcel zza = zza(2, zzdo());
        zzapy zzapyVar = (zzapy) zzgx.zza(zza, zzapy.CREATOR);
        zza.recycle();
        return zzapyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final zzapy zzvd() throws RemoteException {
        Parcel zza = zza(3, zzdo());
        zzapy zzapyVar = (zzapy) zzgx.zza(zza, zzapy.CREATOR);
        zza.recycle();
        return zzapyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final void zzy(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(10, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final boolean zzz(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        Parcel zza = zza(15, zzdo);
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final void zza(String[] strArr, Bundle[] bundleArr) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeStringArray(strArr);
        zzdo.writeTypedArray(bundleArr, 0);
        zzb(11, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final void zza(String str, String str2, zzvl zzvlVar, b bVar, zzaoy zzaoyVar, zzank zzankVar, zzvs zzvsVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzdo.writeString(str2);
        zzgx.zza(zzdo, zzvlVar);
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzaoyVar);
        zzgx.zza(zzdo, zzankVar);
        zzgx.zza(zzdo, zzvsVar);
        zzb(13, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final void zza(String str, String str2, zzvl zzvlVar, b bVar, zzapd zzapdVar, zzank zzankVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzdo.writeString(str2);
        zzgx.zza(zzdo, zzvlVar);
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzapdVar);
        zzgx.zza(zzdo, zzankVar);
        zzb(14, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final void zza(String str, String str2, zzvl zzvlVar, b bVar, zzapj zzapjVar, zzank zzankVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzdo.writeString(str2);
        zzgx.zza(zzdo, zzvlVar);
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzapjVar);
        zzgx.zza(zzdo, zzankVar);
        zzb(16, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final void zza(String str, String str2, zzvl zzvlVar, b bVar, zzape zzapeVar, zzank zzankVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzdo.writeString(str2);
        zzgx.zza(zzdo, zzvlVar);
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzapeVar);
        zzgx.zza(zzdo, zzankVar);
        zzb(18, zzdo);
    }
}
