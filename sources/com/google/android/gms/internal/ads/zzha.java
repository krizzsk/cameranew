package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzha extends zzgy implements zzhb {
    public static zzhb zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.clearcut.IClearcut");
        if (queryLocalInterface instanceof zzhb) {
            return (zzhb) queryLocalInterface;
        }
        return new zzhc(iBinder);
    }
}
