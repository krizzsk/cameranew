package com.google.android.gms.internal.ads;

import com.google.firebase.messaging.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzenc {
    private static final zzenc zzito = new zzenc();
    private final ConcurrentMap<Class<?>, zzenj<?>> zzitq = new ConcurrentHashMap();
    private final zzenm zzitp = new zzemb();

    private zzenc() {
    }

    public static zzenc zzbkf() {
        return zzito;
    }

    public final <T> zzenj<T> zzax(T t) {
        return zzh(t.getClass());
    }

    public final <T> zzenj<T> zzh(Class<T> cls) {
        zzeld.zza(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzenj<T> zzenjVar = (zzenj<T>) this.zzitq.get(cls);
        if (zzenjVar == null) {
            zzenj<T> zzg = this.zzitp.zzg(cls);
            zzeld.zza(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
            zzeld.zza(zzg, "schema");
            zzenj<T> zzenjVar2 = (zzenj<T>) this.zzitq.putIfAbsent(cls, zzg);
            return zzenjVar2 != null ? zzenjVar2 : zzg;
        }
        return zzenjVar;
    }
}
