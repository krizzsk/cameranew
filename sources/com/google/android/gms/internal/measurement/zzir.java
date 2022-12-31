package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzir<K, V> extends LinkedHashMap<K, V> {
    private static final zzir zzb;
    private boolean zza;

    static {
        zzir zzirVar = new zzir();
        zzb = zzirVar;
        zzirVar.zza = false;
    }

    private zzir() {
        this.zza = true;
    }

    public static <K, V> zzir<K, V> zza() {
        return zzb;
    }

    private static int zzf(Object obj) {
        if (obj instanceof byte[]) {
            return zzia.zzg((byte[]) obj);
        }
        if (!(obj instanceof zzhu)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    private final void zzg() {
        if (!this.zza) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzg();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        boolean equals;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this == map) {
                return true;
            }
            if (size() != map.size()) {
                return false;
            }
            for (Map.Entry<K, V> entry : entrySet()) {
                if (!map.containsKey(entry.getKey())) {
                    return false;
                }
                V value = entry.getValue();
                Object obj2 = map.get(entry.getKey());
                if ((value instanceof byte[]) && (obj2 instanceof byte[])) {
                    equals = Arrays.equals((byte[]) value, (byte[]) obj2);
                    continue;
                } else {
                    equals = value.equals(obj2);
                    continue;
                }
                if (!equals) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i2 = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            i2 += zzf(entry.getValue()) ^ zzf(entry.getKey());
        }
        return i2;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k2, V v) {
        zzg();
        zzia.zza(k2);
        zzia.zza(v);
        return (V) super.put(k2, v);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        zzg();
        for (K k2 : map.keySet()) {
            zzia.zza(k2);
            zzia.zza(map.get(k2));
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        zzg();
        return (V) super.remove(obj);
    }

    public final void zzb(zzir<K, V> zzirVar) {
        zzg();
        if (zzirVar.isEmpty()) {
            return;
        }
        putAll(zzirVar);
    }

    public final zzir<K, V> zzc() {
        return isEmpty() ? new zzir<>() : new zzir<>(this);
    }

    public final void zzd() {
        this.zza = false;
    }

    public final boolean zze() {
        return this.zza;
    }

    private zzir(Map<K, V> map) {
        super(map);
        this.zza = true;
    }
}
