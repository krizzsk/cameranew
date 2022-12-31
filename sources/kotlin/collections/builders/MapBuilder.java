package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.h0;
import kotlin.collections.m;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.z.j;
/* compiled from: MapBuilder.kt */
/* loaded from: classes3.dex */
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, Object {
    private static final a Companion = new a(null);
    @Deprecated
    private static final int INITIAL_CAPACITY = 8;
    @Deprecated
    private static final int INITIAL_MAX_PROBE_DISTANCE = 2;
    @Deprecated
    private static final int MAGIC = -1640531527;
    @Deprecated
    private static final int TOMBSTONE = -1;
    private kotlin.collections.builders.c<K, V> entriesView;
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;
    private K[] keysArray;
    private kotlin.collections.builders.d<K> keysView;
    private int length;
    private int maxProbeDistance;
    private int[] presenceArray;
    private int size;
    private V[] valuesArray;
    private kotlin.collections.builders.e<V> valuesView;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MapBuilder.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int c(int i2) {
            int a;
            a = j.a(i2, 1);
            return Integer.highestOneBit(a * 3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int d(int i2) {
            return Integer.numberOfLeadingZeros(i2) + 1;
        }
    }

    /* compiled from: MapBuilder.kt */
    /* loaded from: classes3.dex */
    public static final class b<K, V> extends d<K, V> implements Iterator<Map.Entry<K, V>>, Object {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MapBuilder<K, V> map) {
            super(map);
            s.h(map, "map");
        }

        @Override // java.util.Iterator
        /* renamed from: g */
        public c<K, V> next() {
            if (a() < ((MapBuilder) c()).length) {
                int a = a();
                e(a + 1);
                f(a);
                c<K, V> cVar = new c<>(c(), b());
                d();
                return cVar;
            }
            throw new NoSuchElementException();
        }

        public final void h(StringBuilder sb) {
            s.h(sb, "sb");
            if (a() < ((MapBuilder) c()).length) {
                int a = a();
                e(a + 1);
                f(a);
                Object obj = ((MapBuilder) c()).keysArray[b()];
                if (s.c(obj, c())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj);
                }
                sb.append('=');
                Object[] objArr = ((MapBuilder) c()).valuesArray;
                s.e(objArr);
                Object obj2 = objArr[b()];
                if (s.c(obj2, c())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj2);
                }
                d();
                return;
            }
            throw new NoSuchElementException();
        }

        public final int i() {
            if (a() < ((MapBuilder) c()).length) {
                int a = a();
                e(a + 1);
                f(a);
                Object obj = ((MapBuilder) c()).keysArray[b()];
                int hashCode = obj != null ? obj.hashCode() : 0;
                Object[] objArr = ((MapBuilder) c()).valuesArray;
                s.e(objArr);
                Object obj2 = objArr[b()];
                int hashCode2 = hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
                d();
                return hashCode2;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: MapBuilder.kt */
    /* loaded from: classes3.dex */
    public static final class c<K, V> implements Map.Entry<K, V>, Object {
        private final MapBuilder<K, V> a;
        private final int b;

        public c(MapBuilder<K, V> map, int i2) {
            s.h(map, "map");
            this.a = map;
            this.b = i2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (s.c(entry.getKey(), getKey()) && s.c(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) ((MapBuilder) this.a).keysArray[this.b];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArr = ((MapBuilder) this.a).valuesArray;
            s.e(objArr);
            return (V) objArr[this.b];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K key = getKey();
            int hashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            return hashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            this.a.checkIsMutable$kotlin_stdlib();
            Object[] allocateValuesArray = this.a.allocateValuesArray();
            int i2 = this.b;
            V v2 = (V) allocateValuesArray[i2];
            allocateValuesArray[i2] = v;
            return v2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* compiled from: MapBuilder.kt */
    /* loaded from: classes3.dex */
    public static class d<K, V> {
        private final MapBuilder<K, V> a;
        private int b;
        private int c;

        public d(MapBuilder<K, V> map) {
            s.h(map, "map");
            this.a = map;
            this.c = -1;
            d();
        }

        public final int a() {
            return this.b;
        }

        public final int b() {
            return this.c;
        }

        public final MapBuilder<K, V> c() {
            return this.a;
        }

        public final void d() {
            while (this.b < ((MapBuilder) this.a).length) {
                int[] iArr = ((MapBuilder) this.a).presenceArray;
                int i2 = this.b;
                if (iArr[i2] >= 0) {
                    return;
                }
                this.b = i2 + 1;
            }
        }

        public final void e(int i2) {
            this.b = i2;
        }

        public final void f(int i2) {
            this.c = i2;
        }

        public final boolean hasNext() {
            return this.b < ((MapBuilder) this.a).length;
        }

        public final void remove() {
            if (this.c != -1) {
                this.a.checkIsMutable$kotlin_stdlib();
                this.a.removeKeyAt(this.c);
                this.c = -1;
                return;
            }
            throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
        }
    }

    /* compiled from: MapBuilder.kt */
    /* loaded from: classes3.dex */
    public static final class e<K, V> extends d<K, V> implements Iterator<K>, Object {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(MapBuilder<K, V> map) {
            super(map);
            s.h(map, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            if (a() < ((MapBuilder) c()).length) {
                int a = a();
                e(a + 1);
                f(a);
                K k2 = (K) ((MapBuilder) c()).keysArray[b()];
                d();
                return k2;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: MapBuilder.kt */
    /* loaded from: classes3.dex */
    public static final class f<K, V> extends d<K, V> implements Iterator<V>, Object {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(MapBuilder<K, V> map) {
            super(map);
            s.h(map, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            if (a() < ((MapBuilder) c()).length) {
                int a = a();
                e(a + 1);
                f(a);
                Object[] objArr = ((MapBuilder) c()).valuesArray;
                s.e(objArr);
                V v = (V) objArr[b()];
                d();
                return v;
            }
            throw new NoSuchElementException();
        }
    }

    private MapBuilder(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i2, int i3) {
        this.keysArray = kArr;
        this.valuesArray = vArr;
        this.presenceArray = iArr;
        this.hashArray = iArr2;
        this.maxProbeDistance = i2;
        this.length = i3;
        this.hashShift = Companion.d(getHashSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V[] allocateValuesArray() {
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) kotlin.collections.builders.b.d(getCapacity());
        this.valuesArray = vArr2;
        return vArr2;
    }

    private final void compact() {
        int i2;
        V[] vArr = this.valuesArray;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i2 = this.length;
            if (i3 >= i2) {
                break;
            }
            if (this.presenceArray[i3] >= 0) {
                K[] kArr = this.keysArray;
                kArr[i4] = kArr[i3];
                if (vArr != null) {
                    vArr[i4] = vArr[i3];
                }
                i4++;
            }
            i3++;
        }
        kotlin.collections.builders.b.g(this.keysArray, i4, i2);
        if (vArr != null) {
            kotlin.collections.builders.b.g(vArr, i4, this.length);
        }
        this.length = i4;
    }

    private final boolean contentEquals(Map<?, ?> map) {
        return size() == map.size() && containsAllEntries$kotlin_stdlib(map.entrySet());
    }

    private final void ensureCapacity(int i2) {
        if (i2 >= 0) {
            if (i2 > getCapacity()) {
                int capacity = (getCapacity() * 3) / 2;
                if (i2 <= capacity) {
                    i2 = capacity;
                }
                this.keysArray = (K[]) kotlin.collections.builders.b.e(this.keysArray, i2);
                V[] vArr = this.valuesArray;
                this.valuesArray = vArr != null ? (V[]) kotlin.collections.builders.b.e(vArr, i2) : null;
                int[] copyOf = Arrays.copyOf(this.presenceArray, i2);
                s.g(copyOf, "copyOf(this, newSize)");
                this.presenceArray = copyOf;
                int c2 = Companion.c(i2);
                if (c2 > getHashSize()) {
                    rehash(c2);
                    return;
                }
                return;
            } else if ((this.length + i2) - size() > getCapacity()) {
                rehash(getHashSize());
                return;
            } else {
                return;
            }
        }
        throw new OutOfMemoryError();
    }

    private final void ensureExtraCapacity(int i2) {
        ensureCapacity(this.length + i2);
    }

    private final int findKey(K k2) {
        int hash = hash(k2);
        int i2 = this.maxProbeDistance;
        while (true) {
            int i3 = this.hashArray[hash];
            if (i3 == 0) {
                return -1;
            }
            if (i3 > 0) {
                int i4 = i3 - 1;
                if (s.c(this.keysArray[i4], k2)) {
                    return i4;
                }
            }
            i2--;
            if (i2 < 0) {
                return -1;
            }
            hash = hash == 0 ? getHashSize() - 1 : hash - 1;
        }
    }

    private final int findValue(V v) {
        int i2 = this.length;
        while (true) {
            i2--;
            if (i2 < 0) {
                return -1;
            }
            if (this.presenceArray[i2] >= 0) {
                V[] vArr = this.valuesArray;
                s.e(vArr);
                if (s.c(vArr[i2], v)) {
                    return i2;
                }
            }
        }
    }

    private final int getCapacity() {
        return this.keysArray.length;
    }

    private final int getHashSize() {
        return this.hashArray.length;
    }

    private final int hash(K k2) {
        return ((k2 != null ? k2.hashCode() : 0) * MAGIC) >>> this.hashShift;
    }

    private final boolean putAllEntries(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z = false;
        if (collection.isEmpty()) {
            return false;
        }
        ensureExtraCapacity(collection.size());
        for (Map.Entry<? extends K, ? extends V> entry : collection) {
            if (putEntry(entry)) {
                z = true;
            }
        }
        return z;
    }

    private final boolean putEntry(Map.Entry<? extends K, ? extends V> entry) {
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
        V[] allocateValuesArray = allocateValuesArray();
        if (addKey$kotlin_stdlib >= 0) {
            allocateValuesArray[addKey$kotlin_stdlib] = entry.getValue();
            return true;
        }
        int i2 = (-addKey$kotlin_stdlib) - 1;
        if (s.c(entry.getValue(), allocateValuesArray[i2])) {
            return false;
        }
        allocateValuesArray[i2] = entry.getValue();
        return true;
    }

    private final boolean putRehash(int i2) {
        int hash = hash(this.keysArray[i2]);
        int i3 = this.maxProbeDistance;
        while (true) {
            int[] iArr = this.hashArray;
            if (iArr[hash] == 0) {
                iArr[hash] = i2 + 1;
                this.presenceArray[i2] = hash;
                return true;
            }
            i3--;
            if (i3 < 0) {
                return false;
            }
            hash = hash == 0 ? getHashSize() - 1 : hash - 1;
        }
    }

    private final void rehash(int i2) {
        if (this.length > size()) {
            compact();
        }
        int i3 = 0;
        if (i2 != getHashSize()) {
            this.hashArray = new int[i2];
            this.hashShift = Companion.d(i2);
        } else {
            m.h(this.hashArray, 0, 0, getHashSize());
        }
        while (i3 < this.length) {
            int i4 = i3 + 1;
            if (!putRehash(i3)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i3 = i4;
        }
    }

    private final void removeHashAt(int i2) {
        int c2;
        c2 = j.c(this.maxProbeDistance * 2, getHashSize() / 2);
        int i3 = c2;
        int i4 = 0;
        int i5 = i2;
        do {
            i2 = i2 == 0 ? getHashSize() - 1 : i2 - 1;
            i4++;
            if (i4 > this.maxProbeDistance) {
                this.hashArray[i5] = 0;
                return;
            }
            int[] iArr = this.hashArray;
            int i6 = iArr[i2];
            if (i6 == 0) {
                iArr[i5] = 0;
                return;
            }
            if (i6 < 0) {
                iArr[i5] = -1;
            } else {
                int i7 = i6 - 1;
                if (((hash(this.keysArray[i7]) - i2) & (getHashSize() - 1)) >= i4) {
                    this.hashArray[i5] = i6;
                    this.presenceArray[i7] = i5;
                }
                i3--;
            }
            i5 = i2;
            i4 = 0;
            i3--;
        } while (i3 >= 0);
        this.hashArray[i5] = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeKeyAt(int i2) {
        kotlin.collections.builders.b.f(this.keysArray, i2);
        removeHashAt(this.presenceArray[i2]);
        this.presenceArray[i2] = -1;
        this.size = size() - 1;
    }

    private final Object writeReplace() {
        if (this.isReadOnly) {
            return new SerializedMap(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    public final int addKey$kotlin_stdlib(K k2) {
        int c2;
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int hash = hash(k2);
            c2 = j.c(this.maxProbeDistance * 2, getHashSize() / 2);
            int i2 = 0;
            while (true) {
                int i3 = this.hashArray[hash];
                if (i3 <= 0) {
                    if (this.length >= getCapacity()) {
                        ensureExtraCapacity(1);
                    } else {
                        int i4 = this.length;
                        int i5 = i4 + 1;
                        this.length = i5;
                        this.keysArray[i4] = k2;
                        this.presenceArray[i4] = hash;
                        this.hashArray[hash] = i5;
                        this.size = size() + 1;
                        if (i2 > this.maxProbeDistance) {
                            this.maxProbeDistance = i2;
                        }
                        return i4;
                    }
                } else if (s.c(this.keysArray[i3 - 1], k2)) {
                    return -i3;
                } else {
                    i2++;
                    if (i2 > c2) {
                        rehash(getHashSize() * 2);
                        break;
                    }
                    hash = hash == 0 ? getHashSize() - 1 : hash - 1;
                }
            }
        }
    }

    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        return this;
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        h0 it = new kotlin.z.d(0, this.length - 1).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            int[] iArr = this.presenceArray;
            int i2 = iArr[nextInt];
            if (i2 >= 0) {
                this.hashArray[i2] = 0;
                iArr[nextInt] = -1;
            }
        }
        kotlin.collections.builders.b.g(this.keysArray, 0, this.length);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            kotlin.collections.builders.b.g(vArr, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
    }

    public final boolean containsAllEntries$kotlin_stdlib(Collection<?> m) {
        s.h(m, "m");
        for (Object obj : m) {
            if (obj != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        s.h(entry, "entry");
        int findKey = findKey(entry.getKey());
        if (findKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        s.e(vArr);
        return s.c(vArr[findKey], entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return findKey(obj) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return findValue(obj) >= 0;
    }

    public final b<K, V> entriesIterator$kotlin_stdlib() {
        return new b<>(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Map) && contentEquals((Map) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object obj) {
        int findKey = findKey(obj);
        if (findKey < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        s.e(vArr);
        return vArr[findKey];
    }

    public Set<Map.Entry<K, V>> getEntries() {
        kotlin.collections.builders.c<K, V> cVar = this.entriesView;
        if (cVar == null) {
            kotlin.collections.builders.c<K, V> cVar2 = new kotlin.collections.builders.c<>(this);
            this.entriesView = cVar2;
            return cVar2;
        }
        return cVar;
    }

    public Set<K> getKeys() {
        kotlin.collections.builders.d<K> dVar = this.keysView;
        if (dVar == null) {
            kotlin.collections.builders.d<K> dVar2 = new kotlin.collections.builders.d<>(this);
            this.keysView = dVar2;
            return dVar2;
        }
        return dVar;
    }

    public int getSize() {
        return this.size;
    }

    public Collection<V> getValues() {
        kotlin.collections.builders.e<V> eVar = this.valuesView;
        if (eVar == null) {
            kotlin.collections.builders.e<V> eVar2 = new kotlin.collections.builders.e<>(this);
            this.valuesView = eVar2;
            return eVar2;
        }
        return eVar;
    }

    @Override // java.util.Map
    public int hashCode() {
        b<K, V> entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i2 = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            i2 += entriesIterator$kotlin_stdlib.i();
        }
        return i2;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public final boolean isReadOnly$kotlin_stdlib() {
        return this.isReadOnly;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    public final e<K, V> keysIterator$kotlin_stdlib() {
        return new e<>(this);
    }

    @Override // java.util.Map
    public V put(K k2, V v) {
        checkIsMutable$kotlin_stdlib();
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(k2);
        V[] allocateValuesArray = allocateValuesArray();
        if (addKey$kotlin_stdlib < 0) {
            int i2 = (-addKey$kotlin_stdlib) - 1;
            V v2 = allocateValuesArray[i2];
            allocateValuesArray[i2] = v;
            return v2;
        }
        allocateValuesArray[addKey$kotlin_stdlib] = v;
        return null;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> from) {
        s.h(from, "from");
        checkIsMutable$kotlin_stdlib();
        putAllEntries(from.entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V remove(Object obj) {
        int removeKey$kotlin_stdlib = removeKey$kotlin_stdlib(obj);
        if (removeKey$kotlin_stdlib < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        s.e(vArr);
        V v = vArr[removeKey$kotlin_stdlib];
        kotlin.collections.builders.b.f(vArr, removeKey$kotlin_stdlib);
        return v;
    }

    public final boolean removeEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        s.h(entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(entry.getKey());
        if (findKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        s.e(vArr);
        if (s.c(vArr[findKey], entry.getValue())) {
            removeKeyAt(findKey);
            return true;
        }
        return false;
    }

    public final int removeKey$kotlin_stdlib(K k2) {
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(k2);
        if (findKey < 0) {
            return -1;
        }
        removeKeyAt(findKey);
        return findKey;
    }

    public final boolean removeValue$kotlin_stdlib(V v) {
        checkIsMutable$kotlin_stdlib();
        int findValue = findValue(v);
        if (findValue < 0) {
            return false;
        }
        removeKeyAt(findValue);
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        b<K, V> entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i2 = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            if (i2 > 0) {
                sb.append(", ");
            }
            entriesIterator$kotlin_stdlib.h(sb);
            i2++;
        }
        sb.append("}");
        String sb2 = sb.toString();
        s.g(sb2, "sb.toString()");
        return sb2;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public final f<K, V> valuesIterator$kotlin_stdlib() {
        return new f<>(this);
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int i2) {
        this(kotlin.collections.builders.b.d(i2), null, new int[i2], new int[Companion.c(i2)], 2, 0);
    }
}
