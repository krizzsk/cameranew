package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.collections.i;
import kotlin.collections.j;
import kotlin.collections.m;
import kotlin.jvm.internal.s;
/* compiled from: ListBuilder.kt */
/* loaded from: classes3.dex */
public final class ListBuilder<E> extends kotlin.collections.e<E> implements List<E>, RandomAccess, Serializable, kotlin.jvm.internal.z.d {
    private E[] array;
    private final ListBuilder<E> backing;
    private boolean isReadOnly;
    private int length;
    private int offset;
    private final ListBuilder<E> root;

    /* compiled from: ListBuilder.kt */
    /* loaded from: classes3.dex */
    private static final class a<E> implements ListIterator<E>, Object {
        private final ListBuilder<E> a;
        private int b;
        private int c;

        public a(ListBuilder<E> list, int i2) {
            s.h(list, "list");
            this.a = list;
            this.b = i2;
            this.c = -1;
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            ListBuilder<E> listBuilder = this.a;
            int i2 = this.b;
            this.b = i2 + 1;
            listBuilder.add(i2, e2);
            this.c = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.b < ((ListBuilder) this.a).length;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            if (this.b < ((ListBuilder) this.a).length) {
                int i2 = this.b;
                this.b = i2 + 1;
                this.c = i2;
                return (E) ((ListBuilder) this.a).array[((ListBuilder) this.a).offset + this.c];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.b;
        }

        @Override // java.util.ListIterator
        public E previous() {
            int i2 = this.b;
            if (i2 > 0) {
                int i3 = i2 - 1;
                this.b = i3;
                this.c = i3;
                return (E) ((ListBuilder) this.a).array[((ListBuilder) this.a).offset + this.c];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int i2 = this.c;
            if (i2 != -1) {
                this.a.remove(i2);
                this.b = this.c;
                this.c = -1;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            int i2 = this.c;
            if (i2 != -1) {
                this.a.set(i2, e2);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        }
    }

    private ListBuilder(E[] eArr, int i2, int i3, boolean z, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.array = eArr;
        this.offset = i2;
        this.length = i3;
        this.isReadOnly = z;
        this.backing = listBuilder;
        this.root = listBuilder2;
    }

    private final void addAllInternal(int i2, Collection<? extends E> collection, int i3) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAllInternal(i2, collection, i3);
            this.array = this.backing.array;
            this.length += i3;
            return;
        }
        insertAtInternal(i2, i3);
        Iterator<? extends E> it = collection.iterator();
        for (int i4 = 0; i4 < i3; i4++) {
            this.array[i2 + i4] = it.next();
        }
    }

    private final void addAtInternal(int i2, E e2) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAtInternal(i2, e2);
            this.array = this.backing.array;
            this.length++;
            return;
        }
        insertAtInternal(i2, 1);
        this.array[i2] = e2;
    }

    private final void checkIsMutable() {
        if (isEffectivelyReadOnly()) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean contentEquals(List<?> list) {
        boolean h2;
        h2 = b.h(this.array, this.offset, this.length, list);
        return h2;
    }

    private final void ensureCapacity(int i2) {
        if (this.backing != null) {
            throw new IllegalStateException();
        }
        if (i2 >= 0) {
            E[] eArr = this.array;
            if (i2 > eArr.length) {
                this.array = (E[]) b.e(this.array, i.a.a(eArr.length, i2));
                return;
            }
            return;
        }
        throw new OutOfMemoryError();
    }

    private final void ensureExtraCapacity(int i2) {
        ensureCapacity(this.length + i2);
    }

    private final void insertAtInternal(int i2, int i3) {
        ensureExtraCapacity(i3);
        E[] eArr = this.array;
        m.e(eArr, eArr, i2 + i3, i2, this.offset + this.length);
        this.length += i3;
    }

    private final boolean isEffectivelyReadOnly() {
        ListBuilder<E> listBuilder;
        return this.isReadOnly || ((listBuilder = this.root) != null && listBuilder.isReadOnly);
    }

    private final E removeAtInternal(int i2) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            this.length--;
            return listBuilder.removeAtInternal(i2);
        }
        E[] eArr = this.array;
        E e2 = eArr[i2];
        m.e(eArr, eArr, i2, i2 + 1, this.offset + this.length);
        b.f(this.array, (this.offset + this.length) - 1);
        this.length--;
        return e2;
    }

    private final void removeRangeInternal(int i2, int i3) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.removeRangeInternal(i2, i3);
        } else {
            E[] eArr = this.array;
            m.e(eArr, eArr, i2, i2 + i3, this.length);
            E[] eArr2 = this.array;
            int i4 = this.length;
            b.g(eArr2, i4 - i3, i4);
        }
        this.length -= i3;
    }

    private final int retainOrRemoveAllInternal(int i2, int i3, Collection<? extends E> collection, boolean z) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            int retainOrRemoveAllInternal = listBuilder.retainOrRemoveAllInternal(i2, i3, collection, z);
            this.length -= retainOrRemoveAllInternal;
            return retainOrRemoveAllInternal;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i2 + i4;
            if (collection.contains(this.array[i6]) == z) {
                E[] eArr = this.array;
                i4++;
                eArr[i5 + i2] = eArr[i6];
                i5++;
            } else {
                i4++;
            }
        }
        int i7 = i3 - i5;
        E[] eArr2 = this.array;
        m.e(eArr2, eArr2, i2 + i5, i3 + i2, this.length);
        E[] eArr3 = this.array;
        int i8 = this.length;
        b.g(eArr3, i8 - i7, i8);
        this.length -= i7;
        return i7;
    }

    private final Object writeReplace() {
        if (isEffectivelyReadOnly()) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e2) {
        checkIsMutable();
        addAtInternal(this.offset + this.length, e2);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        s.h(elements, "elements");
        checkIsMutable();
        int size = elements.size();
        addAllInternal(this.offset + this.length, elements, size);
        return size > 0;
    }

    public final List<E> build() {
        if (this.backing == null) {
            checkIsMutable();
            this.isReadOnly = true;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        checkIsMutable();
        removeRangeInternal(this.offset, this.length);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof List) && contentEquals((List) obj));
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i2) {
        kotlin.collections.b.a.a(i2, this.length);
        return this.array[this.offset + i2];
    }

    @Override // kotlin.collections.e
    public int getSize() {
        return this.length;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i2;
        i2 = b.i(this.array, this.offset, this.length);
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        for (int i2 = 0; i2 < this.length; i2++) {
            if (s.c(this.array[this.offset + i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new a(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        for (int i2 = this.length - 1; i2 >= 0; i2--) {
            if (s.c(this.array[this.offset + i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return new a(this, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        checkIsMutable();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        return indexOf >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> elements) {
        s.h(elements, "elements");
        checkIsMutable();
        return retainOrRemoveAllInternal(this.offset, this.length, elements, false) > 0;
    }

    @Override // kotlin.collections.e
    public E removeAt(int i2) {
        checkIsMutable();
        kotlin.collections.b.a.a(i2, this.length);
        return removeAtInternal(this.offset + i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> elements) {
        s.h(elements, "elements");
        checkIsMutable();
        return retainOrRemoveAllInternal(this.offset, this.length, elements, true) > 0;
    }

    @Override // kotlin.collections.e, java.util.AbstractList, java.util.List
    public E set(int i2, E e2) {
        checkIsMutable();
        kotlin.collections.b.a.a(i2, this.length);
        E[] eArr = this.array;
        int i3 = this.offset;
        E e3 = eArr[i3 + i2];
        eArr[i3 + i2] = e2;
        return e3;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int i2, int i3) {
        kotlin.collections.b.a.c(i2, i3, this.length);
        E[] eArr = this.array;
        int i4 = this.offset + i2;
        int i5 = i3 - i2;
        boolean z = this.isReadOnly;
        ListBuilder<E> listBuilder = this.root;
        return new ListBuilder(eArr, i4, i5, z, this, listBuilder == null ? this : listBuilder);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] destination) {
        s.h(destination, "destination");
        int length = destination.length;
        int i2 = this.length;
        if (length < i2) {
            E[] eArr = this.array;
            int i3 = this.offset;
            T[] tArr = (T[]) Arrays.copyOfRange(eArr, i3, i2 + i3, destination.getClass());
            s.g(tArr, "copyOfRange(array, offse…h, destination.javaClass)");
            return tArr;
        }
        E[] eArr2 = this.array;
        s.f(eArr2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.builders.ListBuilder.toArray>");
        int i4 = this.offset;
        m.e(eArr2, destination, 0, i4, this.length + i4);
        int length2 = destination.length;
        int i5 = this.length;
        if (length2 > i5) {
            destination[i5] = null;
        }
        return destination;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String j2;
        j2 = b.j(this.array, this.offset, this.length);
        return j2;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i2) {
        kotlin.collections.b.a.b(i2, this.length);
        return new a(this, i2);
    }

    @Override // kotlin.collections.e, java.util.AbstractList, java.util.List
    public void add(int i2, E e2) {
        checkIsMutable();
        kotlin.collections.b.a.b(i2, this.length);
        addAtInternal(this.offset + i2, e2);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i2, Collection<? extends E> elements) {
        s.h(elements, "elements");
        checkIsMutable();
        kotlin.collections.b.a.b(i2, this.length);
        int size = elements.size();
        addAllInternal(this.offset + i2, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        E[] eArr = this.array;
        int i2 = this.offset;
        Object[] g2 = j.g(eArr, i2, this.length + i2);
        s.f(g2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        return g2;
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int i2) {
        this(b.d(i2), 0, 0, false, null, null);
    }
}
