package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzanl extends zzgw implements zzanj {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzanl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void destroy() throws RemoteException {
        zzb(5, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final Bundle getInterstitialAdapterInfo() throws RemoteException {
        Parcel zza = zza(18, zzdo());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final zzzc getVideoController() throws RemoteException {
        Parcel zza = zza(26, zzdo());
        zzzc zzk = zzzb.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final boolean isInitialized() throws RemoteException {
        Parcel zza = zza(13, zzdo());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void pause() throws RemoteException {
        zzb(8, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void resume() throws RemoteException {
        zzb(9, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.writeBoolean(zzdo, z);
        zzb(25, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void showInterstitial() throws RemoteException {
        zzb(4, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void showVideo() throws RemoteException {
        zzb(12, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(b bVar, zzvs zzvsVar, zzvl zzvlVar, String str, zzank zzankVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzvsVar);
        zzgx.zza(zzdo, zzvlVar);
        zzdo.writeString(str);
        zzgx.zza(zzdo, zzankVar);
        zzb(1, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zzb(b bVar, zzvl zzvlVar, String str, zzank zzankVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzvlVar);
        zzdo.writeString(str);
        zzgx.zza(zzdo, zzankVar);
        zzb(28, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zzc(b bVar, zzvl zzvlVar, String str, zzank zzankVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzvlVar);
        zzdo.writeString(str);
        zzgx.zza(zzdo, zzankVar);
        zzb(32, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zzs(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(21, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zzt(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(30, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final b zzuu() throws RemoteException {
        Parcel zza = zza(2, zzdo());
        b x0 = b.a.x0(zza.readStrongBinder());
        zza.recycle();
        return x0;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final zzanr zzuv() throws RemoteException {
        zzanr zzantVar;
        Parcel zza = zza(15, zzdo());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzantVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            if (queryLocalInterface instanceof zzanr) {
                zzantVar = (zzanr) queryLocalInterface;
            } else {
                zzantVar = new zzant(readStrongBinder);
            }
        }
        zza.recycle();
        return zzantVar;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final zzans zzuw() throws RemoteException {
        zzans zzanuVar;
        Parcel zza = zza(16, zzdo());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzanuVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            if (queryLocalInterface instanceof zzans) {
                zzanuVar = (zzans) queryLocalInterface;
            } else {
                zzanuVar = new zzanu(readStrongBinder);
            }
        }
        zza.recycle();
        return zzanuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final Bundle zzux() throws RemoteException {
        Parcel zza = zza(17, zzdo());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final Bundle zzuy() throws RemoteException {
        Parcel zza = zza(19, zzdo());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final boolean zzuz() throws RemoteException {
        Parcel zza = zza(22, zzdo());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final zzafn zzva() throws RemoteException {
        Parcel zza = zza(24, zzdo());
        zzafn zzr = zzafm.zzr(zza.readStrongBinder());
        zza.recycle();
        return zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final zzanx zzvb() throws RemoteException {
        zzanx zzanzVar;
        Parcel zza = zza(27, zzdo());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzanzVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
            if (queryLocalInterface instanceof zzanx) {
                zzanzVar = (zzanx) queryLocalInterface;
            } else {
                zzanzVar = new zzanz(readStrongBinder);
            }
        }
        zza.recycle();
        return zzanzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final zzapy zzvc() throws RemoteException {
        Parcel zza = zza(33, zzdo());
        zzapy zzapyVar = (zzapy) zzgx.zza(zza, zzapy.CREATOR);
        zza.recycle();
        return zzapyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final zzapy zzvd() throws RemoteException {
        Parcel zza = zza(34, zzdo());
        zzapy zzapyVar = (zzapy) zzgx.zza(zza, zzapy.CREATOR);
        zza.recycle();
        return zzapyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(b bVar, zzvl zzvlVar, String str, zzank zzankVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzvlVar);
        zzdo.writeString(str);
        zzgx.zza(zzdo, zzankVar);
        zzb(3, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(b bVar, zzvs zzvsVar, zzvl zzvlVar, String str, String str2, zzank zzankVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzvsVar);
        zzgx.zza(zzdo, zzvlVar);
        zzdo.writeString(str);
        zzdo.writeString(str2);
        zzgx.zza(zzdo, zzankVar);
        zzb(6, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(b bVar, zzvl zzvlVar, String str, String str2, zzank zzankVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzvlVar);
        zzdo.writeString(str);
        zzdo.writeString(str2);
        zzgx.zza(zzdo, zzankVar);
        zzb(7, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(b bVar, zzvl zzvlVar, String str, zzavf zzavfVar, String str2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzvlVar);
        zzdo.writeString(str);
        zzgx.zza(zzdo, zzavfVar);
        zzdo.writeString(str2);
        zzb(10, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(zzvl zzvlVar, String str) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzvlVar);
        zzdo.writeString(str);
        zzb(11, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(b bVar, zzvl zzvlVar, String str, String str2, zzank zzankVar, zzaeh zzaehVar, List<String> list) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzvlVar);
        zzdo.writeString(str);
        zzdo.writeString(str2);
        zzgx.zza(zzdo, zzankVar);
        zzgx.zza(zzdo, zzaehVar);
        zzdo.writeStringList(list);
        zzb(14, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(zzvl zzvlVar, String str, String str2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzvlVar);
        zzdo.writeString(str);
        zzdo.writeString(str2);
        zzb(20, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(b bVar, zzavf zzavfVar, List<String> list) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzavfVar);
        zzdo.writeStringList(list);
        zzb(23, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(b bVar, zzajj zzajjVar, List<zzajr> list) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzajjVar);
        zzdo.writeTypedList(list);
        zzb(31, zzdo);
    }
}
