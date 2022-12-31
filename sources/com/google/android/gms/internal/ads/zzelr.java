package com.google.android.gms.internal.ads;

import java.util.Map;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzelr<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzelp> zziru;

    private zzelr(Map.Entry<K, zzelp> entry) {
        this.zziru = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.zziru.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.zziru.getValue() == null) {
            return null;
        }
        return zzelp.zzbjj();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzemo) {
            return this.zziru.getValue().zzn((zzemo) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzelp zzbjl() {
        return this.zziru.getValue();
    }
}
