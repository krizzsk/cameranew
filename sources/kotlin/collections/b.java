package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
/* compiled from: AbstractList.kt */
/* loaded from: classes3.dex */
public abstract class b<E> extends AbstractCollection<E> implements List<E>, kotlin.jvm.internal.z.a {
    public static final a a = new a(null);

    /* compiled from: AbstractList.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final void a(int i2, int i3) {
            if (i2 < 0 || i2 >= i3) {
                throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
            }
        }

        public final void b(int i2, int i3) {
            if (i2 < 0 || i2 > i3) {
                throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
            }
        }

        public final void c(int i2, int i3, int i4) {
            if (i2 < 0 || i3 > i4) {
                throw new IndexOutOfBoundsException("fromIndex: " + i2 + ", toIndex: " + i3 + ", size: " + i4);
            } else if (i2 <= i3) {
            } else {
                throw new IllegalArgumentException("fromIndex: " + i2 + " > toIndex: " + i3);
            }
        }

        public final boolean d(Collection<?> c, Collection<?> other) {
            kotlin.jvm.internal.s.h(c, "c");
            kotlin.jvm.internal.s.h(other, "other");
            if (c.size() != other.size()) {
                return false;
            }
            Iterator<?> it = other.iterator();
            Iterator<?> it2 = c.iterator();
            while (it2.hasNext()) {
                if (!kotlin.jvm.internal.s.c(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int e(Collection<?> c) {
            kotlin.jvm.internal.s.h(c, "c");
            Iterator<?> it = c.iterator();
            int i2 = 1;
            while (it.hasNext()) {
                Object next = it.next();
                i2 = (i2 * 31) + (next != null ? next.hashCode() : 0);
            }
            return i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractList.kt */
    /* renamed from: kotlin.collections.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0315b implements Iterator<E>, kotlin.jvm.internal.z.a {
        private int a;

        public C0315b() {
        }

        protected final int a() {
            return this.a;
        }

        protected final void b(int i2) {
            this.a = i2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < b.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext()) {
                b<E> bVar = b.this;
                int i2 = this.a;
                this.a = i2 + 1;
                return bVar.get(i2);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: AbstractList.kt */
    /* loaded from: classes3.dex */
    private class c extends b<E>.C0315b implements ListIterator<E>, kotlin.jvm.internal.z.a {
        public c(int i2) {
            super();
            b.a.b(i2, b.this.size());
            b(i2);
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return a() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return a();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (hasPrevious()) {
                b<E> bVar = b.this;
                b(a() - 1);
                return bVar.get(a());
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return a() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: AbstractList.kt */
    /* loaded from: classes3.dex */
    private static final class d<E> extends b<E> implements RandomAccess {
        private final b<E> b;
        private final int c;

        /* renamed from: d  reason: collision with root package name */
        private int f8671d;

        /* JADX WARN: Multi-variable type inference failed */
        public d(b<? extends E> list, int i2, int i3) {
            kotlin.jvm.internal.s.h(list, "list");
            this.b = list;
            this.c = i2;
            b.a.c(i2, i3, list.size());
            this.f8671d = i3 - i2;
        }

        @Override // kotlin.collections.AbstractCollection
        public int a() {
            return this.f8671d;
        }

        @Override // kotlin.collections.b, java.util.List
        public E get(int i2) {
            b.a.a(i2, this.f8671d);
            return this.b.get(this.c + i2);
        }
    }

    @Override // java.util.List
    public void add(int i2, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i2, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return a.d(this, (Collection) obj);
        }
        return false;
    }

    @Override // java.util.List
    public abstract E get(int i2);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return a.e(this);
    }

    @Override // java.util.List
    public int indexOf(E e2) {
        int i2 = 0;
        for (E e3 : this) {
            if (kotlin.jvm.internal.s.c(e3, e2)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new C0315b();
    }

    @Override // java.util.List
    public int lastIndexOf(E e2) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (kotlin.jvm.internal.s.c(listIterator.previous(), e2)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public E remove(int i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i2, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<E> subList(int i2, int i3) {
        return new d(this, i2, i3);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i2) {
        return new c(i2);
    }
}
