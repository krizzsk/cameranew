package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzemi<K, V> extends LinkedHashMap<K, V> {
    private static final zzemi zzisn;
    private boolean zzilo;

    static {
        zzemi zzemiVar = new zzemi();
        zzisn = zzemiVar;
        zzemiVar.zzilo = false;
    }

    private zzemi() {
        this.zzilo = true;
    }

    private static int zzat(Object obj) {
        if (obj instanceof byte[]) {
            return zzeld.hashCode((byte[]) obj);
        }
        if (!(obj instanceof zzelg)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public static <K, V> zzemi<K, V> zzbjs() {
        return zzisn;
    }

    private final void zzbju() {
        if (!this.zzilo) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzbju();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005c A[RETURN] */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof java.util.Map
            r1 = 0
            if (r0 == 0) goto L5d
            java.util.Map r7 = (java.util.Map) r7
            r0 = 1
            if (r6 == r7) goto L59
            int r2 = r6.size()
            int r3 = r7.size()
            if (r2 == r3) goto L16
        L14:
            r7 = 0
            goto L5a
        L16:
            java.util.Set r2 = r6.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L1e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L59
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            boolean r4 = r7.containsKey(r4)
            if (r4 != 0) goto L35
            goto L14
        L35:
            java.lang.Object r4 = r3.getValue()
            java.lang.Object r3 = r3.getKey()
            java.lang.Object r3 = r7.get(r3)
            boolean r5 = r4 instanceof byte[]
            if (r5 == 0) goto L52
            boolean r5 = r3 instanceof byte[]
            if (r5 == 0) goto L52
            byte[] r4 = (byte[]) r4
            byte[] r3 = (byte[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            goto L56
        L52:
            boolean r3 = r4.equals(r3)
        L56:
            if (r3 != 0) goto L1e
            goto L14
        L59:
            r7 = 1
        L5a:
            if (r7 == 0) goto L5d
            return r0
        L5d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzemi.equals(java.lang.Object):boolean");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i2 = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            i2 += zzat(entry.getValue()) ^ zzat(entry.getKey());
        }
        return i2;
    }

    public final boolean isMutable() {
        return this.zzilo;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k2, V v) {
        zzbju();
        zzeld.checkNotNull(k2);
        zzeld.checkNotNull(v);
        return (V) super.put(k2, v);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        zzbju();
        for (K k2 : map.keySet()) {
            zzeld.checkNotNull(k2);
            zzeld.checkNotNull(map.get(k2));
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        zzbju();
        return (V) super.remove(obj);
    }

    public final void zza(zzemi<K, V> zzemiVar) {
        zzbju();
        if (zzemiVar.isEmpty()) {
            return;
        }
        putAll(zzemiVar);
    }

    public final void zzbgf() {
        this.zzilo = false;
    }

    public final zzemi<K, V> zzbjt() {
        return isEmpty() ? new zzemi<>() : new zzemi<>(this);
    }

    private zzemi(Map<K, V> map) {
        super(map);
        this.zzilo = true;
    }
}
