package com.facebook.ads.redexgen.X;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* renamed from: com.facebook.ads.redexgen.X.2W  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class C2W<K, V> {
    public static String[] A03 = {"cnftN0nKJ399Diaxmn3tb8gwwrPO2aP4", "GD6Q0W3wC2KuP8ibvS2RtWU8XnqZN0Aj", "FY51T4e3CIDMofRfjaJn97HmoXO", "oFsWTCKeXQMPzJkbzzVFh0WI6lr", "sX7ClejzrEImqIfblQB7OY3eSnYyqYGK", "70PxY4sPYcKp4dj9du2NwnU3Lx25y2ig", "AJxY89BB1aRneGLKwVE9Pufkgncldx4M", "HDwbCIFP6XJ1qJgKvPjZQVX8jvQoDt8b"};
    /* JADX WARN: Incorrect inner types in field signature: Lcom/facebook/ads/redexgen/X/2W<TK;TV;>.EntrySet; */
    public C2S A00;
    /* JADX WARN: Incorrect inner types in field signature: Lcom/facebook/ads/redexgen/X/2W<TK;TV;>.KeySet; */
    public C2T A01;
    /* JADX WARN: Incorrect inner types in field signature: Lcom/facebook/ads/redexgen/X/2W<TK;TV;>.ValuesCollection; */
    public C2V A02;

    public abstract int A04();

    public abstract int A05(Object obj);

    public abstract int A06(Object obj);

    public abstract Object A07(int i2, int i3);

    public abstract V A08(int i2, V v);

    public abstract Map<K, V> A0A();

    public abstract void A0D();

    public abstract void A0E(int i2);

    public abstract void A0F(K k2, V v);

    public static <K, V> boolean A00(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean A01(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean A02(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public static <T> boolean A03(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set<?> s = (Set) obj;
            try {
                if (set.size() == s.size()) {
                    if (set.containsAll(s)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException unused) {
                return false;
            } catch (NullPointerException unused2) {
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2W != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V> */
    public final Collection<V> A09() {
        if (this.A02 == null) {
            this.A02 = new Collection<V>() { // from class: com.facebook.ads.redexgen.X.2V
                public static String[] A01 = {"WaXEENy4Qqf0iZa9rE7K5Tc", "CdcJslr1GuWzD3hgs8KQ2mZhu", "VqX8APEjT5Wjv2WgYqLWWETF9QEoqL89", "1lDdPMX0zjCtSNVsVcyG9UOAfTksMFfY", "Q30AX00aPMLh2Hp2SxjAPSj4hvT3yuLk", "DGZ9hWDjpXQG3w", "JKstht1TU3rAhNk0s2YNIFhF9tCkCvUD", "xnB3F8eRzgUElZJXVWbAPi1tu19rGp71"};

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2V != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final boolean add(V v) {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2V != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final boolean addAll(Collection<? extends V> collection) {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2V != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final void clear() {
                    C2W.this.A0D();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2V != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final boolean contains(Object obj) {
                    return C2W.this.A06(obj) >= 0;
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2V != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final boolean containsAll(Collection<?> collection) {
                    Iterator<?> it = collection.iterator();
                    while (it.hasNext()) {
                        if (!contains(it.next())) {
                            return false;
                        }
                    }
                    return true;
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2V != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final boolean isEmpty() {
                    return C2W.this.A04() == 0;
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2V != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection, java.lang.Iterable
                public final Iterator<V> iterator() {
                    return new C2R(C2W.this, 1);
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2V != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final boolean remove(Object obj) {
                    int A06 = C2W.this.A06(obj);
                    if (A06 >= 0) {
                        C2W.this.A0E(A06);
                        return true;
                    } else if (A01[6].charAt(4) != 'M') {
                        String[] strArr = A01;
                        strArr[1] = "JaPNh4sPI8rJ5EjhCFrDgKQsA";
                        strArr[5] = "wvLzjGRSTCxgOw";
                        return false;
                    } else {
                        throw new RuntimeException();
                    }
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2V != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final boolean removeAll(Collection<?> collection) {
                    int A04 = C2W.this.A04();
                    boolean z = false;
                    int i2 = 0;
                    while (i2 < A04) {
                        if (collection.contains(C2W.this.A07(i2, 1))) {
                            C2W.this.A0E(i2);
                            i2--;
                            A04--;
                            z = true;
                        }
                        i2++;
                    }
                    return z;
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2V != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final boolean retainAll(Collection<?> collection) {
                    int A04 = C2W.this.A04();
                    boolean z = false;
                    int i2 = 0;
                    while (i2 < A04) {
                        if (!collection.contains(C2W.this.A07(i2, 1))) {
                            C2W.this.A0E(i2);
                            i2--;
                            A04--;
                            z = true;
                        }
                        i2++;
                    }
                    return z;
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2V != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final int size() {
                    return C2W.this.A04();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2V != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final Object[] toArray() {
                    return C2W.this.A0G(1);
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2V != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final <T> T[] toArray(T[] tArr) {
                    T[] array = (T[]) C2W.this.A0H(tArr, 1);
                    return array;
                }
            };
        }
        return this.A02;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2W != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V> */
    public final Set<Map.Entry<K, V>> A0B() {
        if (this.A00 == null) {
            this.A00 = new Set<Map.Entry<K, V>>() { // from class: com.facebook.ads.redexgen.X.2S
                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                /* renamed from: A00 */
                public final boolean add(Map.Entry<K, V> entry) {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
                    int A04 = C2W.this.A04();
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        C2W.this.A0F(entry.getKey(), entry.getValue());
                    }
                    return A04 != C2W.this.A04();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final void clear() {
                    C2W.this.A0D();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean contains(Object obj) {
                    if (obj instanceof Map.Entry) {
                        Map.Entry entry = (Map.Entry) obj;
                        int A05 = C2W.this.A05(entry.getKey());
                        if (A05 < 0) {
                            return false;
                        }
                        return C2P.A04(C2W.this.A07(A05, 1), entry.getValue());
                    }
                    return false;
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean containsAll(Collection<?> collection) {
                    Iterator<?> it = collection.iterator();
                    while (it.hasNext()) {
                        if (!contains(it.next())) {
                            return false;
                        }
                    }
                    return true;
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean equals(Object obj) {
                    return C2W.A03(this, obj);
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final int hashCode() {
                    int i2 = 0;
                    for (int A04 = C2W.this.A04() - 1; A04 >= 0; A04--) {
                        int i3 = 0;
                        Object A07 = C2W.this.A07(A04, 0);
                        Object A072 = C2W.this.A07(A04, 1);
                        int hashCode = A07 == null ? 0 : A07.hashCode();
                        if (A072 != null) {
                            i3 = A072.hashCode();
                        }
                        i2 += i3 ^ hashCode;
                    }
                    return i2;
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean isEmpty() {
                    return C2W.this.A04() == 0;
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection, java.lang.Iterable
                public final Iterator<Map.Entry<K, V>> iterator() {
                    return new C2U(C2W.this);
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean remove(Object obj) {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean removeAll(Collection<?> collection) {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean retainAll(Collection<?> collection) {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final int size() {
                    return C2W.this.A04();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final Object[] toArray() {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2S != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final <T> T[] toArray(T[] tArr) {
                    throw new UnsupportedOperationException();
                }
            };
        }
        C2S c2s = this.A00;
        if (A03[1].charAt(12) != 'P') {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[4] = "9ju5liavVqCXLI9PRLJCuH215nhDnaAN";
        strArr[6] = "X1eenRL1zYDBvWo2ZsNSENOyPnB3gIiL";
        return c2s;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2W != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V> */
    public final Set<K> A0C() {
        if (this.A01 == null) {
            this.A01 = new Set<K>() { // from class: com.facebook.ads.redexgen.X.2T
                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2T != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean add(K k2) {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2T != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean addAll(Collection<? extends K> collection) {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2T != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final void clear() {
                    C2W.this.A0D();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2T != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean contains(Object obj) {
                    return C2W.this.A05(obj) >= 0;
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2T != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean containsAll(Collection<?> collection) {
                    return C2W.A00(C2W.this.A0A(), collection);
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2T != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean equals(Object obj) {
                    return C2W.A03(this, obj);
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2T != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final int hashCode() {
                    int i2 = 0;
                    for (int A04 = C2W.this.A04() - 1; A04 >= 0; A04--) {
                        int i3 = 0;
                        Object obj = C2W.this.A07(A04, 0);
                        if (obj != null) {
                            i3 = obj.hashCode();
                        }
                        i2 += i3;
                    }
                    return i2;
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2T != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean isEmpty() {
                    return C2W.this.A04() == 0;
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2T != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection, java.lang.Iterable
                public final Iterator<K> iterator() {
                    return new C2R(C2W.this, 0);
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2T != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean remove(Object obj) {
                    int A05 = C2W.this.A05(obj);
                    if (A05 >= 0) {
                        C2W.this.A0E(A05);
                        return true;
                    }
                    return false;
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2T != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean removeAll(Collection<?> collection) {
                    return C2W.A01(C2W.this.A0A(), collection);
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2T != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean retainAll(Collection<?> collection) {
                    return C2W.A02(C2W.this.A0A(), collection);
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2T != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final int size() {
                    return C2W.this.A04();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2T != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final Object[] toArray() {
                    return C2W.this.A0G(0);
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2T != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final <T> T[] toArray(T[] tArr) {
                    T[] array = (T[]) C2W.this.A0H(tArr, 0);
                    return array;
                }
            };
        }
        return this.A01;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2W != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V> */
    public final Object[] A0G(int i2) {
        int i3 = A04();
        Object[] objArr = new Object[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            objArr[i4] = A07(i4, i2);
        }
        return objArr;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2W != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T[] A0H(T[] newArray, int i2) {
        int A04 = A04();
        if (newArray.length < A04) {
            newArray = (T[]) ((Object[]) Array.newInstance(newArray.getClass().getComponentType(), A04));
        }
        for (int i3 = 0; i3 < A04; i3++) {
            newArray[i3] = A07(i3, i2);
        }
        if (newArray.length > A04) {
            newArray[A04] = null;
        }
        return newArray;
    }
}
