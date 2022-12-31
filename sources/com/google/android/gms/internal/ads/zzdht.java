package com.google.android.gms.internal.ads;

import android.os.Build;
import java.util.HashMap;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzdht implements Callable {
    static final Callable zzhca = new zzdht();

    private zzdht() {
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String[] split;
        HashMap hashMap = new HashMap();
        String str = (String) zzwr.zzqr().zzd(zzabp.zzcnm);
        if (str != null && !str.isEmpty()) {
            if (Build.VERSION.SDK_INT >= ((Integer) zzwr.zzqr().zzd(zzabp.zzcnn)).intValue()) {
                for (String str2 : str.split(",", -1)) {
                    hashMap.put(str2, com.google.android.gms.ads.internal.util.zzbx.zzep(str2));
                }
            }
        }
        return new zzdhr(hashMap);
    }
}
