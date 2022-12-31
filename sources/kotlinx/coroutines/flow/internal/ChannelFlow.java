package kotlinx.coroutines.flow.internal;

import java.util.ArrayList;
import kotlin.collections.c0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
/* compiled from: ChannelFlow.kt */
/* loaded from: classes3.dex */
public abstract class ChannelFlow<T> implements k<T> {
    public final CoroutineContext a;
    public final int b;
    public final BufferOverflow c;

    public ChannelFlow(CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        this.a = coroutineContext;
        this.b = i2;
        this.c = bufferOverflow;
        if (o0.a()) {
            if (!(i2 != -1)) {
                throw new AssertionError();
            }
        }
    }

    static /* synthetic */ Object g(ChannelFlow channelFlow, kotlinx.coroutines.flow.d dVar, Continuation continuation) {
        Object coroutine_suspended;
        Object b = n0.b(new ChannelFlow$collect$2(dVar, channelFlow, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return b == coroutine_suspended ? b : u.a;
    }

    @Override // kotlinx.coroutines.flow.internal.k
    public kotlinx.coroutines.flow.c<T> b(CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        if (o0.a()) {
            if (!(i2 != -1)) {
                throw new AssertionError();
            }
        }
        CoroutineContext plus = coroutineContext.plus(this.a);
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            int i3 = this.b;
            if (i3 != -3) {
                if (i2 != -3) {
                    if (i3 != -2) {
                        if (i2 != -2) {
                            if (o0.a()) {
                                if (!(this.b >= 0)) {
                                    throw new AssertionError();
                                }
                            }
                            if (o0.a()) {
                                if (!(i2 >= 0)) {
                                    throw new AssertionError();
                                }
                            }
                            i3 = this.b + i2;
                            if (i3 < 0) {
                                i2 = Integer.MAX_VALUE;
                            }
                        }
                    }
                }
                i2 = i3;
            }
            bufferOverflow = this.c;
        }
        return (s.c(plus, this.a) && i2 == this.b && bufferOverflow == this.c) ? this : j(plus, i2, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.c
    public Object d(kotlinx.coroutines.flow.d<? super T> dVar, Continuation<? super u> continuation) {
        return g(this, dVar, continuation);
    }

    protected String e() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object i(kotlinx.coroutines.channels.n<? super T> nVar, Continuation<? super u> continuation);

    protected abstract ChannelFlow<T> j(CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow);

    public final kotlin.jvm.b.p<kotlinx.coroutines.channels.n<? super T>, Continuation<? super u>, Object> k() {
        return new ChannelFlow$collectToFun$1(this, null);
    }

    public final int l() {
        int i2 = this.b;
        if (i2 == -3) {
            return -2;
        }
        return i2;
    }

    public ReceiveChannel<T> m(m0 m0Var) {
        return ProduceKt.f(m0Var, this.a, l(), this.c, CoroutineStart.ATOMIC, null, k(), 16, null);
    }

    public String toString() {
        String J;
        ArrayList arrayList = new ArrayList(4);
        String e2 = e();
        if (e2 != null) {
            arrayList.add(e2);
        }
        CoroutineContext coroutineContext = this.a;
        if (coroutineContext != EmptyCoroutineContext.INSTANCE) {
            arrayList.add(s.q("context=", coroutineContext));
        }
        int i2 = this.b;
        if (i2 != -3) {
            arrayList.add(s.q("capacity=", Integer.valueOf(i2)));
        }
        BufferOverflow bufferOverflow = this.c;
        if (bufferOverflow != BufferOverflow.SUSPEND) {
            arrayList.add(s.q("onBufferOverflow=", bufferOverflow));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(p0.a(this));
        sb.append('[');
        J = c0.J(arrayList, ", ", null, null, 0, null, null, 62, null);
        sb.append(J);
        sb.append(']');
        return sb.toString();
    }
}
