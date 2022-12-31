package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* compiled from: AbstractIterator.kt */
/* loaded from: classes3.dex */
public abstract class a<T> implements Iterator<T>, kotlin.jvm.internal.z.a {
    private State a = State.NotReady;
    private T b;

    /* compiled from: AbstractIterator.kt */
    /* renamed from: kotlin.collections.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public /* synthetic */ class C0314a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[State.values().length];
            iArr[State.Done.ordinal()] = 1;
            iArr[State.Ready.ordinal()] = 2;
            a = iArr;
        }
    }

    private final boolean d() {
        this.a = State.Failed;
        a();
        return this.a == State.Ready;
    }

    protected abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        this.a = State.Done;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(T t) {
        this.b = t;
        this.a = State.Ready;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        State state = this.a;
        if (state != State.Failed) {
            int i2 = C0314a.a[state.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    return d();
                }
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.a = State.NotReady;
            return this.b;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
