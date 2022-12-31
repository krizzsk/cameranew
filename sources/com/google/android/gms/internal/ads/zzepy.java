package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
abstract class zzepy<K, V, V2> implements zzeqb<Map<K, V2>> {
    private final Map<K, zzeqo<V>> zzjbw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzepy(Map<K, zzeqo<V>> map) {
        this.zzjbw = Collections.unmodifiableMap(map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<K, zzeqo<V>> zzbmm() {
        return this.zzjbw;
    }
}
