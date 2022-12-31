package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.s;
/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
public final class c<T> implements e<T> {
    private final e<T> a;
    private final boolean b;
    private final kotlin.jvm.b.l<T, Boolean> c;

    /* compiled from: Sequences.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Iterator<T>, kotlin.jvm.internal.z.a {
        private final Iterator<T> a;
        private int b = -1;
        private T c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ c<T> f8681d;

        a(c<T> cVar) {
            this.f8681d = cVar;
            this.a = ((c) cVar).a.iterator();
        }

        private final void a() {
            while (this.a.hasNext()) {
                T next = this.a.next();
                if (((Boolean) ((c) this.f8681d).c.invoke(next)).booleanValue() == ((c) this.f8681d).b) {
                    this.c = next;
                    this.b = 1;
                    return;
                }
            }
            this.b = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b == -1) {
                a();
            }
            return this.b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.b == -1) {
                a();
            }
            if (this.b != 0) {
                T t = this.c;
                this.c = null;
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
    public c(e<? extends T> sequence, boolean z, kotlin.jvm.b.l<? super T, Boolean> predicate) {
        s.h(sequence, "sequence");
        s.h(predicate, "predicate");
        this.a = sequence;
        this.b = z;
        this.c = predicate;
    }

    @Override // kotlin.sequences.e
    public Iterator<T> iterator() {
        return new a(this);
    }
}
