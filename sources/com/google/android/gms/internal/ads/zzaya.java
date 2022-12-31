package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaya extends zzgw implements zzaxy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaya(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    @Override // com.google.android.gms.internal.ads.zzaxy
    public final void zza(b bVar, zzaye zzayeVar, zzaxx zzaxxVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzayeVar);
        zzgx.zza(zzdo, zzaxxVar);
        zzb(1, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzaxy
    public final void zzan(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzb(2, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzaxy
    public final b zzao(b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        Parcel zza = zza(4, zzdo);
        b x0 = b.a.x0(zza.readStrongBinder());
        zza.recycle();
        return x0;
    }

    @Override // com.google.android.gms.internal.ads.zzaxy
    public final b zzb(b bVar, b bVar2) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, bVar2);
        Parcel zza = zza(3, zzdo);
        b x0 = b.a.x0(zza.readStrongBinder());
        zza.recycle();
        return x0;
    }

    @Override // com.google.android.gms.internal.ads.zzaxy
    public final void zza(List<Uri> list, b bVar, zzasj zzasjVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeTypedList(list);
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzasjVar);
        zzb(5, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzaxy
    public final void zzb(List<Uri> list, b bVar, zzasj zzasjVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzdo.writeTypedList(list);
        zzgx.zza(zzdo, bVar);
        zzgx.zza(zzdo, zzasjVar);
        zzb(6, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzaxy
    public final void zza(zzasq zzasqVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzasqVar);
        zzb(7, zzdo);
    }
}
