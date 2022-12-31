package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzafp extends zzgw implements zzafn {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzafp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final void destroy() throws RemoteException {
        zzb(8, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final List<String> getAvailableAssetNames() throws RemoteException {
        Parcel zza = zza(3, zzdo());
        ArrayList<String> createStringArrayList = zza.createStringArrayList();
        zza.recycle();
        return createStringArrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final String getCustomTemplateId() throws RemoteException {
        Parcel zza = zza(4, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final zzzc getVideoController() throws RemoteException {
        Parcel zza = zza(7, zzdo());
        zzzc zzk = zzzb.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final void performClick(String str) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzb(5, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final void recordImpression() throws RemoteException {
        zzb(6, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final String zzct(String str) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        Parcel zza = zza(1, zzdo);
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final zzaer zzcu(String str) throws RemoteException {
        zzaer zzaetVar;
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        Parcel zza = zza(2, zzdo);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzaetVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            if (queryLocalInterface instanceof zzaer) {
                zzaetVar = (zzaer) queryLocalInterface;
            } else {
                zzaetVar = new zzaet(readStrongBinder);
            }
        }
        zza.recycle();
        return zzaetVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final boolean zzp(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        Parcel zza = zza(10, zzdo);
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final void zzq(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(14, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final b zztm() throws RemoteException {
        Parcel zza = zza(11, zzdo());
        b x0 = b.a.x0(zza.readStrongBinder());
        zza.recycle();
        return x0;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final b zztr() throws RemoteException {
        Parcel zza = zza(9, zzdo());
        b x0 = b.a.x0(zza.readStrongBinder());
        zza.recycle();
        return x0;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final boolean zzts() throws RemoteException {
        Parcel zza = zza(12, zzdo());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final boolean zztt() throws RemoteException {
        Parcel zza = zza(13, zzdo());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final void zztu() throws RemoteException {
        zzb(15, zzdo());
    }
}
