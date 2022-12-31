package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeqd<K, V> extends zzepy<K, V, V> {
    private static final zzeqo<Map<Object, Object>> zzjca = zzeqe.zzbb(Collections.emptyMap());

    private zzeqd(Map<K, zzeqo<V>> map) {
        super(map);
    }

    public static <K, V> zzeqf<K, V> zzih(int i2) {
        return new zzeqf<>(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        LinkedHashMap zzif = zzeqa.zzif(zzbmm().size());
        for (Map.Entry<K, zzeqo<V>> entry : zzbmm().entrySet()) {
            zzif.put(entry.getKey(), entry.getValue().get());
        }
        return Collections.unmodifiableMap(zzif);
    }
}
