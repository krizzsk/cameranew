package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzelu<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zziry;

    public zzelu(Iterator<Map.Entry<K, Object>> it) {
        this.zziry = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zziry.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.zziry.next();
        return next.getValue() instanceof zzelp ? new zzelr(next) : next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zziry.remove();
    }
}
