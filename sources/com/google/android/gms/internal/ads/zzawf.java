package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzawf implements zzazm {
    static final zzazm zzbyi = new zzawf();

    private zzawf() {
    }

    @Override // com.google.android.gms.internal.ads.zzazm
    public final Object apply(Object obj) {
        IBinder iBinder = (IBinder) obj;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCreator");
        if (queryLocalInterface instanceof zzavs) {
            return (zzavs) queryLocalInterface;
        }
        return new zzavv(iBinder);
    }
}
