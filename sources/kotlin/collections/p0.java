package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
/* compiled from: SlidingWindow.kt */
/* loaded from: classes3.dex */
final class p0<T> extends b<T> implements RandomAccess {
    private final Object[] b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private int f8672d;

    /* renamed from: e  reason: collision with root package name */
    private int f8673e;

    /* compiled from: SlidingWindow.kt */
    /* loaded from: classes3.dex */
    public static final class a extends kotlin.collections.a<T> {
        private int c;

        /* renamed from: d  reason: collision with root package name */
        private int f8674d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ p0<T> f8675e;

        a(p0<T> p0Var) {
            this.f8675e = p0Var;
            this.c = p0Var.size();
            this.f8674d = ((p0) p0Var).f8672d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.collections.a
        protected void a() {
            if (this.c != 0) {
                c(((p0) this.f8675e).b[this.f8674d]);
                this.f8674d = (this.f8674d + 1) % ((p0) this.f8675e).c;
                this.c--;
                return;
            }
            b();
        }
    }

    public p0(Object[] buffer, int i2) {
        kotlin.jvm.internal.s.h(buffer, "buffer");
        this.b = buffer;
        if (i2 >= 0) {
            if (i2 <= buffer.length) {
                this.c = buffer.length;
                this.f8673e = i2;
                return;
            }
            throw new IllegalArgumentException(("ring buffer filled size: " + i2 + " cannot be larger than the buffer size: " + buffer.length).toString());
        }
        throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i2).toString());
    }

    @Override // kotlin.collections.AbstractCollection
    public int a() {
        return this.f8673e;
    }

    public final void e(T t) {
        if (!g()) {
            this.b[(this.f8672d + size()) % this.c] = t;
            this.f8673e = size() + 1;
            return;
        }
        throw new IllegalStateException("ring buffer is full");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final p0<T> f(int i2) {
        int c;
        Object[] array;
        int i3 = this.c;
        c = kotlin.z.j.c(i3 + (i3 >> 1) + 1, i2);
        if (this.f8672d == 0) {
            array = Arrays.copyOf(this.b, c);
            kotlin.jvm.internal.s.g(array, "copyOf(this, newSize)");
        } else {
            array = toArray(new Object[c]);
        }
        return new p0<>(array, size());
    }

    public final boolean g() {
        return size() == this.c;
    }

    @Override // kotlin.collections.b, java.util.List
    public T get(int i2) {
        b.a.a(i2, size());
        return (T) this.b[(this.f8672d + i2) % this.c];
    }

    public final void h(int i2) {
        if (i2 >= 0) {
            if (!(i2 <= size())) {
                throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i2 + ", size = " + size()).toString());
            } else if (i2 > 0) {
                int i3 = this.f8672d;
                int i4 = (i3 + i2) % this.c;
                if (i3 > i4) {
                    m.i(this.b, null, i3, this.c);
                    m.i(this.b, null, 0, i4);
                } else {
                    m.i(this.b, null, i3, i4);
                }
                this.f8672d = i4;
                this.f8673e = size() - i2;
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException(("n shouldn't be negative but it is " + i2).toString());
    }

    @Override // kotlin.collections.b, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return new a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.s.h(array, "array");
        if (array.length < size()) {
            array = (T[]) Arrays.copyOf(array, size());
            kotlin.jvm.internal.s.g(array, "copyOf(this, newSize)");
        }
        int size = size();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = this.f8672d; i3 < size && i4 < this.c; i4++) {
            array[i3] = this.b[i4];
            i3++;
        }
        while (i3 < size) {
            array[i3] = this.b[i2];
            i3++;
            i2++;
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        kotlin.jvm.internal.s.f(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.RingBuffer.toArray>");
        return array;
    }

    public p0(int i2) {
        this(new Object[i2], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
