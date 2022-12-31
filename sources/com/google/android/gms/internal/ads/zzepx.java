package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzepx<K, V, V2> {
    final LinkedHashMap<K, zzeqo<V>> zzjbv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzepx(int i2) {
        this.zzjbv = zzeqa.zzif(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public zzepx<K, V, V2> zza(K k2, zzeqo<V> zzeqoVar) {
        this.zzjbv.put(zzeqh.zza(k2, "key"), zzeqh.zza(zzeqoVar, "provider"));
        return this;
    }
}
