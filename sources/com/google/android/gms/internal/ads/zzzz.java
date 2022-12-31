package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzzz extends RemoteCreator<zzyh> {
    public zzzz() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzyh getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
        if (queryLocalInterface instanceof zzyh) {
            return (zzyh) queryLocalInterface;
        }
        return new zzyk(iBinder);
    }

    public final zzyg zzh(Context context) {
        try {
            IBinder zzb = getRemoteCreatorInstance(context).zzb(d.z0(context), 204204000);
            if (zzb == null) {
                return null;
            }
            IInterface queryLocalInterface = zzb.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzyg) {
                return (zzyg) queryLocalInterface;
            }
            return new zzyi(zzb);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzazk.zzd("Could not get remote MobileAdsSettingManager.", e2);
            return null;
        }
    }
}
