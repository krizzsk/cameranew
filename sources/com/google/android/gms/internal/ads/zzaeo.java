package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaeo extends zzgw implements zzaem {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaeo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final float getAspectRatio() throws RemoteException {
        Parcel zza = zza(2, zzdo());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final float getCurrentTime() throws RemoteException {
        Parcel zza = zza(6, zzdo());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final float getDuration() throws RemoteException {
        Parcel zza = zza(5, zzdo());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final zzzc getVideoController() throws RemoteException {
        Parcel zza = zza(7, zzdo());
        zzzc zzk = zzzb.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final boolean hasVideoContent() throws RemoteException {
        Parcel zza = zza(8, zzdo());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void zza(zzagd zzagdVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzagdVar);
        zzb(9, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void zzo(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(3, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final b zztl() throws RemoteException {
        Parcel zza = zza(4, zzdo());
        b x0 = b.a.x0(zza.readStrongBinder());
        zza.recycle();
        return x0;
    }
}
