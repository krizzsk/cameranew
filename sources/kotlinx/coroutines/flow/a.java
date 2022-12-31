package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlow;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Channels.kt */
/* loaded from: classes3.dex */
public final class a<T> extends ChannelFlow<T> {

    /* renamed from: f  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f8747f = AtomicIntegerFieldUpdater.newUpdater(a.class, "consumed");
    private volatile /* synthetic */ int consumed;

    /* renamed from: d  reason: collision with root package name */
    private final ReceiveChannel<T> f8748d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f8749e;

    public /* synthetic */ a(ReceiveChannel receiveChannel, boolean z, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow, int i3, kotlin.jvm.internal.o oVar) {
        this(receiveChannel, z, (i3 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i3 & 8) != 0 ? -3 : i2, (i3 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    private final void n() {
        if (this.f8749e) {
            if (!(f8747f.getAndSet(this, 1) == 0)) {
                throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString());
            }
        }
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.c
    public Object d(d<? super T> dVar, Continuation<? super kotlin.u> continuation) {
        Object coroutine_suspended;
        Object c;
        Object coroutine_suspended2;
        if (this.b == -3) {
            n();
            c = FlowKt__ChannelsKt.c(dVar, this.f8748d, this.f8749e, continuation);
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return c == coroutine_suspended2 ? c : kotlin.u.a;
        }
        Object d2 = super.d(dVar, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return d2 == coroutine_suspended ? d2 : kotlin.u.a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected String e() {
        return kotlin.jvm.internal.s.q("channel=", this.f8748d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object i(kotlinx.coroutines.channels.n<? super T> nVar, Continuation<? super kotlin.u> continuation) {
        Object c;
        Object coroutine_suspended;
        c = FlowKt__ChannelsKt.c(new kotlinx.coroutines.flow.internal.p(nVar), this.f8748d, this.f8749e, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return c == coroutine_suspended ? c : kotlin.u.a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected ChannelFlow<T> j(CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        return new a(this.f8748d, this.f8749e, coroutineContext, i2, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ReceiveChannel<T> m(kotlinx.coroutines.m0 m0Var) {
        n();
        if (this.b == -3) {
            return this.f8748d;
        }
        return super.m(m0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(ReceiveChannel<? extends T> receiveChannel, boolean z, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        super(coroutineContext, i2, bufferOverflow);
        this.f8748d = receiveChannel;
        this.f8749e = z;
        this.consumed = 0;
    }
}
