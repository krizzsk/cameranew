package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlow;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.kt */
/* loaded from: classes3.dex */
public class b<T> extends ChannelFlow<T> {

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.jvm.b.p<kotlinx.coroutines.channels.n<? super T>, Continuation<? super kotlin.u>, Object> f8750d;

    /* JADX WARN: Multi-variable type inference failed */
    public b(kotlin.jvm.b.p<? super kotlinx.coroutines.channels.n<? super T>, ? super Continuation<? super kotlin.u>, ? extends Object> pVar, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        super(coroutineContext, i2, bufferOverflow);
        this.f8750d = pVar;
    }

    static /* synthetic */ Object n(b bVar, kotlinx.coroutines.channels.n nVar, Continuation continuation) {
        Object coroutine_suspended;
        Object invoke = bVar.f8750d.invoke(nVar, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return invoke == coroutine_suspended ? invoke : kotlin.u.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object i(kotlinx.coroutines.channels.n<? super T> nVar, Continuation<? super kotlin.u> continuation) {
        return n(this, nVar, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public String toString() {
        return "block[" + this.f8750d + "] -> " + super.toString();
    }
}
