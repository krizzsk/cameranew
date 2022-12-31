package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: SequenceBuilder.kt */
/* loaded from: classes3.dex */
final class f<T> extends g<T> implements Iterator<T>, Continuation<u>, kotlin.jvm.internal.z.a {
    private int a;
    private T b;
    private Iterator<? extends T> c;

    /* renamed from: d  reason: collision with root package name */
    private Continuation<? super u> f8682d;

    private final Throwable f() {
        int i2 = this.a;
        if (i2 != 4) {
            if (i2 != 5) {
                return new IllegalStateException("Unexpected state of the iterator: " + this.a);
            }
            return new IllegalStateException("Iterator has failed.");
        }
        return new NoSuchElementException();
    }

    private final T h() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // kotlin.sequences.g
    public Object a(T t, Continuation<? super u> continuation) {
        Object coroutine_suspended;
        Object coroutine_suspended2;
        Object coroutine_suspended3;
        this.b = t;
        this.a = 3;
        this.f8682d = continuation;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == coroutine_suspended2) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended3 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return coroutine_suspended == coroutine_suspended3 ? coroutine_suspended : u.a;
    }

    @Override // kotlin.sequences.g
    public Object c(Iterator<? extends T> it, Continuation<? super u> continuation) {
        Object coroutine_suspended;
        Object coroutine_suspended2;
        Object coroutine_suspended3;
        if (it.hasNext()) {
            this.c = it;
            this.a = 2;
            this.f8682d = continuation;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (coroutine_suspended == coroutine_suspended2) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            coroutine_suspended3 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return coroutine_suspended == coroutine_suspended3 ? coroutine_suspended : u.a;
        }
        return u.a;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (true) {
            int i2 = this.a;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2 || i2 == 3) {
                        return true;
                    }
                    if (i2 == 4) {
                        return false;
                    }
                    throw f();
                }
                Iterator<? extends T> it = this.c;
                s.e(it);
                if (it.hasNext()) {
                    this.a = 2;
                    return true;
                }
                this.c = null;
            }
            this.a = 5;
            Continuation<? super u> continuation = this.f8682d;
            s.e(continuation);
            this.f8682d = null;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m41constructorimpl(u.a));
        }
    }

    public final void i(Continuation<? super u> continuation) {
        this.f8682d = continuation;
    }

    @Override // java.util.Iterator
    public T next() {
        int i2 = this.a;
        if (i2 == 0 || i2 == 1) {
            return h();
        }
        if (i2 == 2) {
            this.a = 1;
            Iterator<? extends T> it = this.c;
            s.e(it);
            return it.next();
        } else if (i2 == 3) {
            this.a = 0;
            T t = this.b;
            this.b = null;
            return t;
        } else {
            throw f();
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        kotlin.j.b(obj);
        this.a = 4;
    }
}
