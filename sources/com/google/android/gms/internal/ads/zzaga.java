package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaga extends zzgw implements zzafy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaga(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zza(zzafn zzafnVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzafnVar);
        zzb(1, zzdo);
    }
}
