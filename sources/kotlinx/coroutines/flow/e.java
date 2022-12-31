package kotlinx.coroutines.flow;

import java.util.Collection;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.v1;
/* loaded from: classes3.dex */
public final class e {
    public static final <S, T extends S> Object A(c<? extends T> cVar, kotlin.jvm.b.q<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> qVar, Continuation<? super S> continuation) {
        return FlowKt__ReduceKt.h(cVar, qVar, continuation);
    }

    public static final <T> Object B(c<? extends T> cVar, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.i(cVar, continuation);
    }

    public static final <T> Object C(c<? extends T> cVar, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.j(cVar, continuation);
    }

    public static final <T, C extends Collection<? super T>> Object D(c<? extends T> cVar, C c, Continuation<? super C> continuation) {
        return FlowKt__CollectionKt.a(cVar, c, continuation);
    }

    public static final <T, R> c<R> E(c<? extends T> cVar, kotlin.jvm.b.q<? super d<? super R>, ? super T, ? super Continuation<? super kotlin.u>, ? extends Object> qVar) {
        return FlowKt__MergeKt.b(cVar, qVar);
    }

    public static final <T> c<T> a(c<? extends T> cVar, int i2, BufferOverflow bufferOverflow) {
        return s.a(cVar, i2, bufferOverflow);
    }

    public static final <T> c<T> c(kotlin.jvm.b.p<? super kotlinx.coroutines.channels.n<? super T>, ? super Continuation<? super kotlin.u>, ? extends Object> pVar) {
        return p.a(pVar);
    }

    public static final <T> Object d(c<? extends T> cVar, d<? super T> dVar, Continuation<? super Throwable> continuation) {
        return FlowKt__ErrorsKt.a(cVar, dVar, continuation);
    }

    public static final Object e(c<?> cVar, Continuation<? super kotlin.u> continuation) {
        return FlowKt__CollectKt.a(cVar, continuation);
    }

    public static final <T> Object f(c<? extends T> cVar, kotlin.jvm.b.p<? super T, ? super Continuation<? super kotlin.u>, ? extends Object> pVar, Continuation<? super kotlin.u> continuation) {
        return FlowKt__CollectKt.b(cVar, pVar, continuation);
    }

    public static final <T> Object g(c<? extends T> cVar, Continuation<? super Integer> continuation) {
        return FlowKt__CountKt.a(cVar, continuation);
    }

    public static final <T> Object h(c<? extends T> cVar, kotlin.jvm.b.p<? super T, ? super Continuation<? super Boolean>, ? extends Object> pVar, Continuation<? super Integer> continuation) {
        return FlowKt__CountKt.b(cVar, pVar, continuation);
    }

    public static final <T> c<T> i(c<? extends T> cVar) {
        return FlowKt__DistinctKt.a(cVar);
    }

    public static final <T> Object j(d<? super T> dVar, ReceiveChannel<? extends T> receiveChannel, Continuation<? super kotlin.u> continuation) {
        return FlowKt__ChannelsKt.b(dVar, receiveChannel, continuation);
    }

    public static final <T> Object k(d<? super T> dVar, c<? extends T> cVar, Continuation<? super kotlin.u> continuation) {
        return FlowKt__CollectKt.c(dVar, cVar, continuation);
    }

    public static final void l(d<?> dVar) {
        FlowKt__EmittersKt.b(dVar);
    }

    public static final <T> Object m(c<? extends T> cVar, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.a(cVar, continuation);
    }

    public static final <T> Object n(c<? extends T> cVar, kotlin.jvm.b.p<? super T, ? super Continuation<? super Boolean>, ? extends Object> pVar, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.b(cVar, pVar, continuation);
    }

    public static final <T> Object o(c<? extends T> cVar, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.c(cVar, continuation);
    }

    public static final <T> Object p(c<? extends T> cVar, kotlin.jvm.b.p<? super T, ? super Continuation<? super Boolean>, ? extends Object> pVar, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.d(cVar, pVar, continuation);
    }

    public static final ReceiveChannel<kotlin.u> q(kotlinx.coroutines.m0 m0Var, long j2, long j3) {
        return FlowKt__DelayKt.a(m0Var, j2, j3);
    }

    public static final <T> c<T> s(kotlin.jvm.b.p<? super d<? super T>, ? super Continuation<? super kotlin.u>, ? extends Object> pVar) {
        return p.b(pVar);
    }

    public static final <T> c<T> t(T t) {
        return p.c(t);
    }

    public static final <T> Object u(c<? extends T> cVar, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.f(cVar, continuation);
    }

    public static final <T> Object v(c<? extends T> cVar, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.g(cVar, continuation);
    }

    public static final <T> v1 w(c<? extends T> cVar, kotlinx.coroutines.m0 m0Var) {
        return FlowKt__CollectKt.d(cVar, m0Var);
    }

    public static final <T, R> c<R> x(c<? extends T> cVar, kotlin.jvm.b.p<? super T, ? super Continuation<? super R>, ? extends Object> pVar) {
        return FlowKt__MergeKt.a(cVar, pVar);
    }

    public static final <T> c<T> y(c<? extends T> cVar, kotlin.jvm.b.p<? super T, ? super Continuation<? super kotlin.u>, ? extends Object> pVar) {
        return FlowKt__TransformKt.a(cVar, pVar);
    }

    public static final <T> c<T> z(ReceiveChannel<? extends T> receiveChannel) {
        return FlowKt__ChannelsKt.d(receiveChannel);
    }
}
