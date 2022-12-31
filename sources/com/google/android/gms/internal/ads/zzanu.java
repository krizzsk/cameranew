package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzanu extends zzgw implements zzans {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzanu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final String getAdvertiser() throws RemoteException {
        Parcel zza = zza(7, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final String getBody() throws RemoteException {
        Parcel zza = zza(4, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final String getCallToAction() throws RemoteException {
        Parcel zza = zza(6, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final Bundle getExtras() throws RemoteException {
        Parcel zza = zza(13, zzdo());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final String getHeadline() throws RemoteException {
        Parcel zza = zza(2, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final List getImages() throws RemoteException {
        Parcel zza = zza(3, zzdo());
        ArrayList zzb = zzgx.zzb(zza);
        zza.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final boolean getOverrideClickHandling() throws RemoteException {
        Parcel zza = zza(12, zzdo());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final boolean getOverrideImpressionRecording() throws RemoteException {
        Parcel zza = zza(11, zzdo());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final zzzc getVideoController() throws RemoteException {
        Parcel zza = zza(16, zzdo());
        zzzc zzk = zzzb.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final void recordImpression() throws RemoteException {
        zzb(8, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final void zzc(b bVar, b bVar2, b bVar3) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, bVar2);
        zzgx.zza(zzdo, bVar3);
        zzb(22, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final zzaej zzto() throws RemoteException {
        Parcel zza = zza(19, zzdo());
        zzaej zzm = zzaei.zzm(zza.readStrongBinder());
        zza.recycle();
        return zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final b zztp() throws RemoteException {
        Parcel zza = zza(21, zzdo());
        b x0 = b.a.x0(zza.readStrongBinder());
        zza.recycle();
        return x0;
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final zzaer zztq() throws RemoteException {
        Parcel zza = zza(5, zzdo());
        zzaer zzo = zzaeq.zzo(zza.readStrongBinder());
        zza.recycle();
        return zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final void zzu(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(9, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final void zzv(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(10, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final b zzvg() throws RemoteException {
        Parcel zza = zza(15, zzdo());
        b x0 = b.a.x0(zza.readStrongBinder());
        zza.recycle();
        return x0;
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final b zzvh() throws RemoteException {
        Parcel zza = zza(20, zzdo());
        b x0 = b.a.x0(zza.readStrongBinder());
        zza.recycle();
        return x0;
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final void zzw(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(14, zzdo);
    }
}
