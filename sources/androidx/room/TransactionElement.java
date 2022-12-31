package androidx.room;

import androidx.annotation.RestrictTo;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.v1;
/* compiled from: RoomDatabase.kt */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class TransactionElement implements CoroutineContext.Element {
    public static final Key Key = new Key(null);
    private final AtomicInteger referenceCount;
    private final ContinuationInterceptor transactionDispatcher;
    private final v1 transactionThreadControlJob;

    /* compiled from: RoomDatabase.kt */
    /* loaded from: classes.dex */
    public static final class Key implements CoroutineContext.Key<TransactionElement> {
        private Key() {
        }

        public /* synthetic */ Key(kotlin.jvm.internal.o oVar) {
            this();
        }
    }

    public TransactionElement(v1 transactionThreadControlJob, ContinuationInterceptor transactionDispatcher) {
        kotlin.jvm.internal.s.h(transactionThreadControlJob, "transactionThreadControlJob");
        kotlin.jvm.internal.s.h(transactionDispatcher, "transactionDispatcher");
        this.transactionThreadControlJob = transactionThreadControlJob;
        this.transactionDispatcher = transactionDispatcher;
        this.referenceCount = new AtomicInteger(0);
    }

    public final void acquire() {
        this.referenceCount.incrementAndGet();
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, kotlin.jvm.b.p<? super R, ? super CoroutineContext.Element, ? extends R> pVar) {
        return (R) CoroutineContext.Element.DefaultImpls.fold(this, r, pVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) CoroutineContext.Element.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineContext.Key<TransactionElement> getKey() {
        return Key;
    }

    public final ContinuationInterceptor getTransactionDispatcher$room_ktx_release() {
        return this.transactionDispatcher;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return CoroutineContext.Element.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.Element.DefaultImpls.plus(this, coroutineContext);
    }

    public final void release() {
        int decrementAndGet = this.referenceCount.decrementAndGet();
        if (decrementAndGet < 0) {
            throw new IllegalStateException("Transaction was never started or was already released.");
        }
        if (decrementAndGet == 0) {
            v1.a.a(this.transactionThreadControlJob, null, 1, null);
        }
    }
}
