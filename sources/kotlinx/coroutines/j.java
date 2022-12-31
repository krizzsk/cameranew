package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
/* loaded from: classes3.dex */
public final class j {
    public static final <T> s0<T> a(m0 m0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, kotlin.jvm.b.p<? super m0, ? super Continuation<? super T>, ? extends Object> pVar) {
        return l.a(m0Var, coroutineContext, coroutineStart, pVar);
    }

    public static final v1 c(m0 m0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, kotlin.jvm.b.p<? super m0, ? super Continuation<? super kotlin.u>, ? extends Object> pVar) {
        return l.c(m0Var, coroutineContext, coroutineStart, pVar);
    }

    public static /* synthetic */ v1 d(m0 m0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, kotlin.jvm.b.p pVar, int i2, Object obj) {
        return l.d(m0Var, coroutineContext, coroutineStart, pVar, i2, obj);
    }

    public static final <T> T e(CoroutineContext coroutineContext, kotlin.jvm.b.p<? super m0, ? super Continuation<? super T>, ? extends Object> pVar) throws InterruptedException {
        return (T) k.a(coroutineContext, pVar);
    }

    public static /* synthetic */ Object f(CoroutineContext coroutineContext, kotlin.jvm.b.p pVar, int i2, Object obj) throws InterruptedException {
        return k.b(coroutineContext, pVar, i2, obj);
    }

    public static final <T> Object g(CoroutineContext coroutineContext, kotlin.jvm.b.p<? super m0, ? super Continuation<? super T>, ? extends Object> pVar, Continuation<? super T> continuation) {
        return l.e(coroutineContext, pVar, continuation);
    }
}
