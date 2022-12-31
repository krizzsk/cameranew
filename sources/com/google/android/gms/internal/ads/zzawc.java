package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzawc {
    public static zzavm zzd(Context context, String str, zzane zzaneVar) {
        try {
            IBinder zzd = ((zzavs) zzazj.zza(context, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", zzawf.zzbyi)).zzd(d.z0(context), str, zzaneVar, 204204000);
            if (zzd == null) {
                return null;
            }
            IInterface queryLocalInterface = zzd.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            if (queryLocalInterface instanceof zzavm) {
                return (zzavm) queryLocalInterface;
            }
            return new zzavo(zzd);
        } catch (RemoteException | zzazl e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
            return null;
        }
    }
}
