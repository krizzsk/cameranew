package com.google.android.gms.internal.places;

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
/* loaded from: classes2.dex */
public class zzdb<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzfk;
    private final int zzlp;
    private List<zzdk> zzlq;
    private Map<K, V> zzlr;
    private volatile zzdm zzls;
    private Map<K, V> zzlt;
    private volatile zzdg zzlu;

    private zzdb(int i2) {
        this.zzlp = i2;
        this.zzlq = Collections.emptyList();
        this.zzlr = Collections.emptyMap();
        this.zzlt = Collections.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <FieldDescriptorType extends zzax<FieldDescriptorType>> zzdb<FieldDescriptorType, Object> zzal(int i2) {
        return new zzde(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzan(int i2) {
        zzcx();
        V v = (V) this.zzlq.remove(i2).getValue();
        if (!this.zzlr.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzcy().entrySet().iterator();
            this.zzlq.add(new zzdk(this, it.next()));
            it.remove();
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzcx() {
        if (this.zzfk) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzcy() {
        zzcx();
        if (this.zzlr.isEmpty() && !(this.zzlr instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzlr = treeMap;
            this.zzlt = treeMap.descendingMap();
        }
        return (SortedMap) this.zzlr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        zzcx();
        if (!this.zzlq.isEmpty()) {
            this.zzlq.clear();
        }
        if (this.zzlr.isEmpty()) {
            return;
        }
        this.zzlr.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zzb((zzdb<K, V>) comparable) >= 0 || this.zzlr.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzls == null) {
            this.zzls = new zzdm(this, null);
        }
        return this.zzls;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdb)) {
            return super.equals(obj);
        }
        zzdb zzdbVar = (zzdb) obj;
        int size = size();
        if (size != zzdbVar.size()) {
            return false;
        }
        int zzcu = zzcu();
        if (zzcu != zzdbVar.zzcu()) {
            return entrySet().equals(zzdbVar.entrySet());
        }
        for (int i2 = 0; i2 < zzcu; i2++) {
            if (!zzam(i2).equals(zzdbVar.zzam(i2))) {
                return false;
            }
        }
        if (zzcu != size) {
            return this.zzlr.equals(zzdbVar.zzlr);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zzb = zzb((zzdb<K, V>) comparable);
        if (zzb >= 0) {
            return (V) this.zzlq.get(zzb).getValue();
        }
        return this.zzlr.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int zzcu = zzcu();
        int i2 = 0;
        for (int i3 = 0; i3 < zzcu; i3++) {
            i2 += this.zzlq.get(i3).hashCode();
        }
        return this.zzlr.size() > 0 ? i2 + this.zzlr.hashCode() : i2;
    }

    public final boolean isImmutable() {
        return this.zzfk;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return zzb((zzdb<K, V>) ((Comparable) obj), (Comparable) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzcx();
        Comparable comparable = (Comparable) obj;
        int zzb = zzb((zzdb<K, V>) comparable);
        if (zzb >= 0) {
            return (V) zzan(zzb);
        }
        if (this.zzlr.isEmpty()) {
            return null;
        }
        return this.zzlr.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.zzlq.size() + this.zzlr.size();
    }

    public void zzab() {
        Map<K, V> unmodifiableMap;
        Map<K, V> unmodifiableMap2;
        if (this.zzfk) {
            return;
        }
        if (this.zzlr.isEmpty()) {
            unmodifiableMap = Collections.emptyMap();
        } else {
            unmodifiableMap = Collections.unmodifiableMap(this.zzlr);
        }
        this.zzlr = unmodifiableMap;
        if (this.zzlt.isEmpty()) {
            unmodifiableMap2 = Collections.emptyMap();
        } else {
            unmodifiableMap2 = Collections.unmodifiableMap(this.zzlt);
        }
        this.zzlt = unmodifiableMap2;
        this.zzfk = true;
    }

    public final Map.Entry<K, V> zzam(int i2) {
        return this.zzlq.get(i2);
    }

    public final V zzb(K k2, V v) {
        zzcx();
        int zzb = zzb((zzdb<K, V>) k2);
        if (zzb >= 0) {
            return (V) this.zzlq.get(zzb).setValue(v);
        }
        zzcx();
        if (this.zzlq.isEmpty() && !(this.zzlq instanceof ArrayList)) {
            this.zzlq = new ArrayList(this.zzlp);
        }
        int i2 = -(zzb + 1);
        if (i2 >= this.zzlp) {
            return zzcy().put(k2, v);
        }
        int size = this.zzlq.size();
        int i3 = this.zzlp;
        if (size == i3) {
            zzdk remove = this.zzlq.remove(i3 - 1);
            zzcy().put((K) remove.getKey(), (V) remove.getValue());
        }
        this.zzlq.add(i2, new zzdk(this, k2, v));
        return null;
    }

    public final int zzcu() {
        return this.zzlq.size();
    }

    public final Iterable<Map.Entry<K, V>> zzcv() {
        if (this.zzlr.isEmpty()) {
            return zzdf.zzdf();
        }
        return this.zzlr.entrySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> zzcw() {
        if (this.zzlu == null) {
            this.zzlu = new zzdg(this, null);
        }
        return this.zzlu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdb(int i2, zzde zzdeVar) {
        this(i2);
    }

    private final int zzb(K k2) {
        int size = this.zzlq.size() - 1;
        if (size >= 0) {
            int compareTo = k2.compareTo((Comparable) this.zzlq.get(size).getKey());
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
            int compareTo2 = k2.compareTo((Comparable) this.zzlq.get(i3).getKey());
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
