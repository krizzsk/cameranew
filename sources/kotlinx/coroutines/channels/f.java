package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.c2;
/* compiled from: ChannelCoroutine.kt */
/* loaded from: classes3.dex */
public class f<E> extends kotlinx.coroutines.c<kotlin.u> implements e<E> {
    private final e<E> c;

    public f(CoroutineContext coroutineContext, e<E> eVar, boolean z, boolean z2) {
        super(coroutineContext, z, z2);
        this.c = eVar;
    }

    @Override // kotlinx.coroutines.channels.s
    public boolean C(Throwable th) {
        return this.c.C(th);
    }

    @Override // kotlinx.coroutines.channels.s
    public Object D(E e2, Continuation<? super kotlin.u> continuation) {
        return this.c.D(e2, continuation);
    }

    @Override // kotlinx.coroutines.channels.s
    public boolean E() {
        return this.c.E();
    }

    @Override // kotlinx.coroutines.c2
    public void R(Throwable th) {
        CancellationException H0 = c2.H0(this, th, null, 1, null);
        this.c.a(H0);
        P(H0);
    }

    public final e<E> S0() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final e<E> T0() {
        return this.c;
    }

    @Override // kotlinx.coroutines.c2, kotlinx.coroutines.v1
    public final void a(CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(U(), null, this);
        }
        R(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator<E> iterator() {
        return this.c.iterator();
    }

    @Override // kotlinx.coroutines.channels.s
    public void m(kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar) {
        this.c.m(lVar);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public E poll() {
        return this.c.poll();
    }

    @Override // kotlinx.coroutines.channels.s
    public Object q(E e2) {
        return this.c.q(e2);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public kotlinx.coroutines.selects.d<E> r() {
        return this.c.r();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public kotlinx.coroutines.selects.d<h<E>> s() {
        return this.c.s();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object y() {
        return this.c.y();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object z(Continuation<? super h<? extends E>> continuation) {
        Object z = this.c.z(continuation);
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return z;
    }
}
