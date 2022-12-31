package com.google.android.gms.internal.measurement;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public class zzjs<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int zza;
    private boolean zzd;
    private volatile zzjr zze;
    private List<zzjp> zzb = Collections.emptyList();
    private Map<K, V> zzc = Collections.emptyMap();
    private Map<K, V> zzf = Collections.emptyMap();

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzk(int i2) {
        zzm();
        V v = (V) this.zzb.remove(i2).getValue();
        if (!this.zzc.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzn().entrySet().iterator();
            List<zzjp> list = this.zzb;
            Map.Entry<K, V> next = it.next();
            list.add(new zzjp(this, next.getKey(), next.getValue()));
            it.remove();
        }
        return v;
    }

    private final int zzl(K k2) {
        int size = this.zzb.size() - 1;
        int i2 = 0;
        if (size >= 0) {
            int compareTo = k2.compareTo(this.zzb.get(size).zza());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        while (i2 <= size) {
            int i3 = (i2 + size) / 2;
            int compareTo2 = k2.compareTo(this.zzb.get(i3).zza());
            if (compareTo2 < 0) {
                size = i3 - 1;
            } else if (compareTo2 <= 0) {
                return i3;
            } else {
                i2 = i3 + 1;
            }
        }
        return -(i2 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzm() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzn() {
        zzm();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzm();
        if (!this.zzb.isEmpty()) {
            this.zzb.clear();
        }
        if (this.zzc.isEmpty()) {
            return;
        }
        this.zzc.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zzl(comparable) >= 0 || this.zzc.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        if (this.zze == null) {
            this.zze = new zzjr(this, null);
        }
        return this.zze;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzjs)) {
            return super.equals(obj);
        }
        zzjs zzjsVar = (zzjs) obj;
        int size = size();
        if (size != zzjsVar.size()) {
            return false;
        }
        int zzc = zzc();
        if (zzc == zzjsVar.zzc()) {
            for (int i2 = 0; i2 < zzc; i2++) {
                if (!zzd(i2).equals(zzjsVar.zzd(i2))) {
                    return false;
                }
            }
            if (zzc != size) {
                return this.zzc.equals(zzjsVar.zzc);
            }
            return true;
        }
        return entrySet().equals(zzjsVar.entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zzl = zzl(comparable);
        if (zzl >= 0) {
            return (V) this.zzb.get(zzl).getValue();
        }
        return this.zzc.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int zzc = zzc();
        int i2 = 0;
        for (int i3 = 0; i3 < zzc; i3++) {
            i2 += this.zzb.get(i3).hashCode();
        }
        return this.zzc.size() > 0 ? i2 + this.zzc.hashCode() : i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        zzm();
        Comparable comparable = (Comparable) obj;
        int zzl = zzl(comparable);
        if (zzl >= 0) {
            return (V) zzk(zzl);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zzb.size() + this.zzc.size();
    }

    public void zza() {
        Map<K, V> unmodifiableMap;
        Map<K, V> unmodifiableMap2;
        if (this.zzd) {
            return;
        }
        if (this.zzc.isEmpty()) {
            unmodifiableMap = Collections.emptyMap();
        } else {
            unmodifiableMap = Collections.unmodifiableMap(this.zzc);
        }
        this.zzc = unmodifiableMap;
        if (this.zzf.isEmpty()) {
            unmodifiableMap2 = Collections.emptyMap();
        } else {
            unmodifiableMap2 = Collections.unmodifiableMap(this.zzf);
        }
        this.zzf = unmodifiableMap2;
        this.zzd = true;
    }

    public final boolean zzb() {
        return this.zzd;
    }

    public final int zzc() {
        return this.zzb.size();
    }

    public final Map.Entry<K, V> zzd(int i2) {
        return this.zzb.get(i2);
    }

    public final Iterable<Map.Entry<K, V>> zze() {
        return this.zzc.isEmpty() ? zzjo.zza() : this.zzc.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: zzf */
    public final V put(K k2, V v) {
        zzm();
        int zzl = zzl(k2);
        if (zzl >= 0) {
            return (V) this.zzb.get(zzl).setValue(v);
        }
        zzm();
        if (this.zzb.isEmpty() && !(this.zzb instanceof ArrayList)) {
            this.zzb = new ArrayList(this.zza);
        }
        int i2 = -(zzl + 1);
        if (i2 >= this.zza) {
            return zzn().put(k2, v);
        }
        int size = this.zzb.size();
        int i3 = this.zza;
        if (size == i3) {
            zzjp remove = this.zzb.remove(i3 - 1);
            zzn().put((K) remove.zza(), (V) remove.getValue());
        }
        this.zzb.add(i2, new zzjp(this, k2, v));
        return null;
    }
}
