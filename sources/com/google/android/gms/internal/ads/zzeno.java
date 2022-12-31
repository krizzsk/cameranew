package com.google.android.gms.internal.ads;

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
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public class zzeno<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzinq;
    private final int zzium;
    private List<zzent> zziun;
    private Map<K, V> zziuo;
    private volatile zzenv zziup;
    private Map<K, V> zziuq;
    private volatile zzenp zziur;

    private zzeno(int i2) {
        this.zzium = i2;
        this.zziun = Collections.emptyList();
        this.zziuo = Collections.emptyMap();
        this.zziuq = Collections.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbkt() {
        if (this.zzinq) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzbku() {
        zzbkt();
        if (this.zziuo.isEmpty() && !(this.zziuo instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zziuo = treeMap;
            this.zziuq = treeMap.descendingMap();
        }
        return (SortedMap) this.zziuo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <FieldDescriptorType extends zzekw<FieldDescriptorType>> zzeno<FieldDescriptorType, Object> zzht(int i2) {
        return new zzenn(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzhv(int i2) {
        zzbkt();
        V v = (V) this.zziun.remove(i2).getValue();
        if (!this.zziuo.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzbku().entrySet().iterator();
            this.zziun.add(new zzent(this, it.next()));
            it.remove();
        }
        return v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        zzbkt();
        if (!this.zziun.isEmpty()) {
            this.zziun.clear();
        }
        if (this.zziuo.isEmpty()) {
            return;
        }
        this.zziuo.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza((zzeno<K, V>) comparable) >= 0 || this.zziuo.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zziup == null) {
            this.zziup = new zzenv(this, null);
        }
        return this.zziup;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzeno)) {
            return super.equals(obj);
        }
        zzeno zzenoVar = (zzeno) obj;
        int size = size();
        if (size != zzenoVar.size()) {
            return false;
        }
        int zzbkq = zzbkq();
        if (zzbkq != zzenoVar.zzbkq()) {
            return entrySet().equals(zzenoVar.entrySet());
        }
        for (int i2 = 0; i2 < zzbkq; i2++) {
            if (!zzhu(i2).equals(zzenoVar.zzhu(i2))) {
                return false;
            }
        }
        if (zzbkq != size) {
            return this.zziuo.equals(zzenoVar.zziuo);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza((zzeno<K, V>) comparable);
        if (zza >= 0) {
            return (V) this.zziun.get(zza).getValue();
        }
        return this.zziuo.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int zzbkq = zzbkq();
        int i2 = 0;
        for (int i3 = 0; i3 < zzbkq; i3++) {
            i2 += this.zziun.get(i3).hashCode();
        }
        return this.zziuo.size() > 0 ? i2 + this.zziuo.hashCode() : i2;
    }

    public final boolean isImmutable() {
        return this.zzinq;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return zza((zzeno<K, V>) ((Comparable) obj), (Comparable) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzbkt();
        Comparable comparable = (Comparable) obj;
        int zza = zza((zzeno<K, V>) comparable);
        if (zza >= 0) {
            return (V) zzhv(zza);
        }
        if (this.zziuo.isEmpty()) {
            return null;
        }
        return this.zziuo.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.zziun.size() + this.zziuo.size();
    }

    public final V zza(K k2, V v) {
        zzbkt();
        int zza = zza((zzeno<K, V>) k2);
        if (zza >= 0) {
            return (V) this.zziun.get(zza).setValue(v);
        }
        zzbkt();
        if (this.zziun.isEmpty() && !(this.zziun instanceof ArrayList)) {
            this.zziun = new ArrayList(this.zzium);
        }
        int i2 = -(zza + 1);
        if (i2 >= this.zzium) {
            return zzbku().put(k2, v);
        }
        int size = this.zziun.size();
        int i3 = this.zzium;
        if (size == i3) {
            zzent remove = this.zziun.remove(i3 - 1);
            zzbku().put((K) remove.getKey(), (V) remove.getValue());
        }
        this.zziun.add(i2, new zzent(this, k2, v));
        return null;
    }

    public void zzbgf() {
        Map<K, V> unmodifiableMap;
        Map<K, V> unmodifiableMap2;
        if (this.zzinq) {
            return;
        }
        if (this.zziuo.isEmpty()) {
            unmodifiableMap = Collections.emptyMap();
        } else {
            unmodifiableMap = Collections.unmodifiableMap(this.zziuo);
        }
        this.zziuo = unmodifiableMap;
        if (this.zziuq.isEmpty()) {
            unmodifiableMap2 = Collections.emptyMap();
        } else {
            unmodifiableMap2 = Collections.unmodifiableMap(this.zziuq);
        }
        this.zziuq = unmodifiableMap2;
        this.zzinq = true;
    }

    public final int zzbkq() {
        return this.zziun.size();
    }

    public final Iterable<Map.Entry<K, V>> zzbkr() {
        if (this.zziuo.isEmpty()) {
            return zzens.zzbkw();
        }
        return this.zziuo.entrySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> zzbks() {
        if (this.zziur == null) {
            this.zziur = new zzenp(this, null);
        }
        return this.zziur;
    }

    public final Map.Entry<K, V> zzhu(int i2) {
        return this.zziun.get(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzeno(int i2, zzenn zzennVar) {
        this(i2);
    }

    private final int zza(K k2) {
        int size = this.zziun.size() - 1;
        if (size >= 0) {
            int compareTo = k2.compareTo((Comparable) this.zziun.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) / 2;
            int compareTo2 = k2.compareTo((Comparable) this.zziun.get(i3).getKey());
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
}
