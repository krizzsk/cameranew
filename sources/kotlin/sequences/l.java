package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.s;
/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
public final class l<T, R> implements e<R> {
    private final e<T> a;
    private final kotlin.jvm.b.l<T, R> b;

    /* compiled from: Sequences.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Iterator<R>, kotlin.jvm.internal.z.a {
        private final Iterator<T> a;
        final /* synthetic */ l<T, R> b;

        a(l<T, R> lVar) {
            this.b = lVar;
            this.a = ((l) lVar).a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) ((l) this.b).b.invoke(this.a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(e<? extends T> sequence, kotlin.jvm.b.l<? super T, ? extends R> transformer) {
        s.h(sequence, "sequence");
        s.h(transformer, "transformer");
        this.a = sequence;
        this.b = transformer;
    }

    @Override // kotlin.sequences.e
    public Iterator<R> iterator() {
        return new a(this);
    }
}
