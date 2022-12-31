package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes2.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new a();
    Comparator<? super K> comparator;
    private LinkedTreeMap<K, V>.b entrySet;
    final e<K, V> header;
    private LinkedTreeMap<K, V>.c keySet;
    int modCount;
    e<K, V> root;
    int size;

    /* loaded from: classes2.dex */
    class a implements Comparator<Comparable> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* loaded from: classes2.dex */
    class b extends AbstractSet<Map.Entry<K, V>> {

        /* loaded from: classes2.dex */
        class a extends LinkedTreeMap<K, V>.d<Map.Entry<K, V>> {
            a(b bVar) {
                super();
            }

            @Override // java.util.Iterator
            /* renamed from: b */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedTreeMap.this.findByEntry((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> findByEntry;
            if ((obj instanceof Map.Entry) && (findByEntry = LinkedTreeMap.this.findByEntry((Map.Entry) obj)) != null) {
                LinkedTreeMap.this.removeInternal(findByEntry, true);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* loaded from: classes2.dex */
    final class c extends AbstractSet<K> {

        /* loaded from: classes2.dex */
        class a extends LinkedTreeMap<K, V>.d<K> {
            a(c cVar) {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f4948f;
            }
        }

        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedTreeMap.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public abstract class d<T> implements Iterator<T> {
        e<K, V> a;
        e<K, V> b = null;
        int c;

        d() {
            this.a = LinkedTreeMap.this.header.f4946d;
            this.c = LinkedTreeMap.this.modCount;
        }

        final e<K, V> a() {
            e<K, V> eVar = this.a;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (eVar != linkedTreeMap.header) {
                if (linkedTreeMap.modCount == this.c) {
                    this.a = eVar.f4946d;
                    this.b = eVar;
                    return eVar;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.a != LinkedTreeMap.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.b;
            if (eVar != null) {
                LinkedTreeMap.this.removeInternal(eVar, true);
                this.b = null;
                this.c = LinkedTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public LinkedTreeMap() {
        this(NATURAL_ORDER);
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void rebalance(e<K, V> eVar, boolean z) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.b;
            e<K, V> eVar3 = eVar.c;
            int i2 = eVar2 != null ? eVar2.f4950h : 0;
            int i3 = eVar3 != null ? eVar3.f4950h : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                e<K, V> eVar4 = eVar3.b;
                e<K, V> eVar5 = eVar3.c;
                int i5 = (eVar4 != null ? eVar4.f4950h : 0) - (eVar5 != null ? eVar5.f4950h : 0);
                if (i5 != -1 && (i5 != 0 || z)) {
                    rotateRight(eVar3);
                    rotateLeft(eVar);
                } else {
                    rotateLeft(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                e<K, V> eVar6 = eVar2.b;
                e<K, V> eVar7 = eVar2.c;
                int i6 = (eVar6 != null ? eVar6.f4950h : 0) - (eVar7 != null ? eVar7.f4950h : 0);
                if (i6 != 1 && (i6 != 0 || z)) {
                    rotateLeft(eVar2);
                    rotateRight(eVar);
                } else {
                    rotateRight(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                eVar.f4950h = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                eVar.f4950h = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            eVar = eVar.a;
        }
    }

    private void replaceInParent(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.a;
        eVar.a = null;
        if (eVar2 != null) {
            eVar2.a = eVar3;
        }
        if (eVar3 != null) {
            if (eVar3.b == eVar) {
                eVar3.b = eVar2;
                return;
            } else {
                eVar3.c = eVar2;
                return;
            }
        }
        this.root = eVar2;
    }

    private void rotateLeft(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.b;
        e<K, V> eVar3 = eVar.c;
        e<K, V> eVar4 = eVar3.b;
        e<K, V> eVar5 = eVar3.c;
        eVar.c = eVar4;
        if (eVar4 != null) {
            eVar4.a = eVar;
        }
        replaceInParent(eVar, eVar3);
        eVar3.b = eVar;
        eVar.a = eVar3;
        int max = Math.max(eVar2 != null ? eVar2.f4950h : 0, eVar4 != null ? eVar4.f4950h : 0) + 1;
        eVar.f4950h = max;
        eVar3.f4950h = Math.max(max, eVar5 != null ? eVar5.f4950h : 0) + 1;
    }

    private void rotateRight(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.b;
        e<K, V> eVar3 = eVar.c;
        e<K, V> eVar4 = eVar2.b;
        e<K, V> eVar5 = eVar2.c;
        eVar.b = eVar5;
        if (eVar5 != null) {
            eVar5.a = eVar;
        }
        replaceInParent(eVar, eVar2);
        eVar2.c = eVar;
        eVar.a = eVar2;
        int max = Math.max(eVar3 != null ? eVar3.f4950h : 0, eVar5 != null ? eVar5.f4950h : 0) + 1;
        eVar.f4950h = max;
        eVar2.f4950h = Math.max(max, eVar4 != null ? eVar4.f4950h : 0) + 1;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        e<K, V> eVar = this.header;
        eVar.f4947e = eVar;
        eVar.f4946d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.b bVar = this.entrySet;
        if (bVar != null) {
            return bVar;
        }
        LinkedTreeMap<K, V>.b bVar2 = new b();
        this.entrySet = bVar2;
        return bVar2;
    }

    e<K, V> find(K k2, boolean z) {
        int i2;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.comparator;
        e<K, V> eVar2 = this.root;
        if (eVar2 != null) {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) k2 : null;
            while (true) {
                if (comparable != null) {
                    i2 = comparable.compareTo(eVar2.f4948f);
                } else {
                    i2 = comparator.compare(k2, (K) eVar2.f4948f);
                }
                if (i2 == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = i2 < 0 ? eVar2.b : eVar2.c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            i2 = 0;
        }
        if (z) {
            e<K, V> eVar4 = this.header;
            if (eVar2 == null) {
                if (comparator == NATURAL_ORDER && !(k2 instanceof Comparable)) {
                    throw new ClassCastException(k2.getClass().getName() + " is not Comparable");
                }
                eVar = new e<>(eVar2, k2, eVar4, eVar4.f4947e);
                this.root = eVar;
            } else {
                eVar = new e<>(eVar2, k2, eVar4, eVar4.f4947e);
                if (i2 < 0) {
                    eVar2.b = eVar;
                } else {
                    eVar2.c = eVar;
                }
                rebalance(eVar2, true);
            }
            this.size++;
            this.modCount++;
            return eVar;
        }
        return null;
    }

    e<K, V> findByEntry(Map.Entry<?, ?> entry) {
        e<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject != null && equal(findByObject.f4949g, entry.getValue())) {
            return findByObject;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    e<K, V> findByObject(Object obj) {
        if (obj != 0) {
            try {
                return find(obj, false);
            } catch (ClassCastException unused) {
                return null;
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.f4949g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedTreeMap<K, V>.c cVar = this.keySet;
        if (cVar != null) {
            return cVar;
        }
        LinkedTreeMap<K, V>.c cVar2 = new c();
        this.keySet = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v) {
        Objects.requireNonNull(k2, "key == null");
        e<K, V> find = find(k2, true);
        V v2 = find.f4949g;
        find.f4949g = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.f4949g;
        }
        return null;
    }

    void removeInternal(e<K, V> eVar, boolean z) {
        int i2;
        if (z) {
            e<K, V> eVar2 = eVar.f4947e;
            eVar2.f4946d = eVar.f4946d;
            eVar.f4946d.f4947e = eVar2;
        }
        e<K, V> eVar3 = eVar.b;
        e<K, V> eVar4 = eVar.c;
        e<K, V> eVar5 = eVar.a;
        int i3 = 0;
        if (eVar3 != null && eVar4 != null) {
            e<K, V> b2 = eVar3.f4950h > eVar4.f4950h ? eVar3.b() : eVar4.a();
            removeInternal(b2, false);
            e<K, V> eVar6 = eVar.b;
            if (eVar6 != null) {
                i2 = eVar6.f4950h;
                b2.b = eVar6;
                eVar6.a = b2;
                eVar.b = null;
            } else {
                i2 = 0;
            }
            e<K, V> eVar7 = eVar.c;
            if (eVar7 != null) {
                i3 = eVar7.f4950h;
                b2.c = eVar7;
                eVar7.a = b2;
                eVar.c = null;
            }
            b2.f4950h = Math.max(i2, i3) + 1;
            replaceInParent(eVar, b2);
            return;
        }
        if (eVar3 != null) {
            replaceInParent(eVar, eVar3);
            eVar.b = null;
        } else if (eVar4 != null) {
            replaceInParent(eVar, eVar4);
            eVar.c = null;
        } else {
            replaceInParent(eVar, null);
        }
        rebalance(eVar5, false);
        this.size--;
        this.modCount++;
    }

    e<K, V> removeInternalByKey(Object obj) {
        e<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public LinkedTreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.header = new e<>();
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class e<K, V> implements Map.Entry<K, V> {
        e<K, V> a;
        e<K, V> b;
        e<K, V> c;

        /* renamed from: d  reason: collision with root package name */
        e<K, V> f4946d;

        /* renamed from: e  reason: collision with root package name */
        e<K, V> f4947e;

        /* renamed from: f  reason: collision with root package name */
        final K f4948f;

        /* renamed from: g  reason: collision with root package name */
        V f4949g;

        /* renamed from: h  reason: collision with root package name */
        int f4950h;

        e() {
            this.f4948f = null;
            this.f4947e = this;
            this.f4946d = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.b; eVar2 != null; eVar2 = eVar2.b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e<K, V> b() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.c; eVar2 != null; eVar2 = eVar2.c) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k2 = this.f4948f;
                if (k2 == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!k2.equals(entry.getKey())) {
                    return false;
                }
                V v = this.f4949g;
                if (v == null) {
                    if (entry.getValue() != null) {
                        return false;
                    }
                } else if (!v.equals(entry.getValue())) {
                    return false;
                }
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f4948f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f4949g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k2 = this.f4948f;
            int hashCode = k2 == null ? 0 : k2.hashCode();
            V v = this.f4949g;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f4949g;
            this.f4949g = v;
            return v2;
        }

        public String toString() {
            return this.f4948f + "=" + this.f4949g;
        }

        e(e<K, V> eVar, K k2, e<K, V> eVar2, e<K, V> eVar3) {
            this.a = eVar;
            this.f4948f = k2;
            this.f4950h = 1;
            this.f4946d = eVar2;
            this.f4947e = eVar3;
            eVar3.f4946d = this;
            eVar2.f4947e = this;
        }
    }
}
