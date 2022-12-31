package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
public final class d<T> implements e<T> {
    private final kotlin.jvm.b.a<T> a;
    private final kotlin.jvm.b.l<T, T> b;

    /* compiled from: Sequences.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Iterator<T>, kotlin.jvm.internal.z.a {
        private T a;
        private int b = -2;
        final /* synthetic */ d<T> c;

        a(d<T> dVar) {
            this.c = dVar;
        }

        private final void a() {
            T t;
            if (this.b == -2) {
                t = (T) ((d) this.c).a.invoke();
            } else {
                kotlin.jvm.b.l lVar = ((d) this.c).b;
                T t2 = this.a;
                s.e(t2);
                t = (T) lVar.invoke(t2);
            }
            this.a = t;
            this.b = t == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b < 0) {
                a();
            }
            return this.b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.b < 0) {
                a();
            }
            if (this.b != 0) {
                T t = this.a;
                s.f(t, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
                this.b = -1;
                return t;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(kotlin.jvm.b.a<? extends T> getInitialValue, kotlin.jvm.b.l<? super T, ? extends T> getNextValue) {
        s.h(getInitialValue, "getInitialValue");
        s.h(getNextValue, "getNextValue");
        this.a = getInitialValue;
        this.b = getNextValue;
    }

    @Override // kotlin.sequences.e
    public Iterator<T> iterator() {
        return new a(this);
    }
}
