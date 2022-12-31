package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzayc extends zzgy implements zzayd {
    public static zzayd zzat(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGeneratorCreator");
        if (queryLocalInterface instanceof zzayd) {
            return (zzayd) queryLocalInterface;
        }
        return new zzayf(iBinder);
    }
}
