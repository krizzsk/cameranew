package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzagh extends zzgw implements zzagf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzagh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnPublisherAdViewLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzagf
    public final void zza(zzxl zzxlVar, b bVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzxlVar);
        zzgx.zza(zzdo, bVar);
        zzb(1, zzdo);
    }
}
