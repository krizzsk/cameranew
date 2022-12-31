package com.google.android.gms.internal.measurement;

import com.google.firebase.messaging.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzjf {
    private static final zzjf zza = new zzjf();
    private final ConcurrentMap<Class<?>, zzji<?>> zzc = new ConcurrentHashMap();
    private final zzjj zzb = new zzip();

    private zzjf() {
    }

    public static zzjf zza() {
        return zza;
    }

    public final <T> zzji<T> zzb(Class<T> cls) {
        zzia.zzb(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzji<T> zzjiVar = (zzji<T>) this.zzc.get(cls);
        if (zzjiVar == null) {
            zzjiVar = this.zzb.zza(cls);
            zzia.zzb(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
            zzia.zzb(zzjiVar, "schema");
            zzji putIfAbsent = this.zzc.putIfAbsent(cls, zzjiVar);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
        }
        return zzjiVar;
    }
}
