package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzvj extends RemoteCreator<zzxq> {
    public zzvj() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzxq getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if (queryLocalInterface instanceof zzxq) {
            return (zzxq) queryLocalInterface;
        }
        return new zzxp(iBinder);
    }

    public final zzxl zza(Context context, zzvs zzvsVar, String str, zzane zzaneVar, int i2) {
        try {
            IBinder zza = getRemoteCreatorInstance(context).zza(d.z0(context), zzvsVar, str, zzaneVar, 204204000, i2);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzxl) {
                return (zzxl) queryLocalInterface;
            }
            return new zzxn(zza);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzazk.zzb("Could not create remote AdManager.", e2);
            return null;
        }
    }
}
