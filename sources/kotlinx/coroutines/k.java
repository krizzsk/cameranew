package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.kt */
/* loaded from: classes3.dex */
public final /* synthetic */ class k {
    public static final <T> T a(CoroutineContext coroutineContext, kotlin.jvm.b.p<? super m0, ? super Continuation<? super T>, ? extends Object> pVar) throws InterruptedException {
        f1 a;
        CoroutineContext c;
        Thread currentThread = Thread.currentThread();
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.Key);
        if (continuationInterceptor == null) {
            a = v2.a.b();
            c = h0.c(n1.a, coroutineContext.plus(a));
        } else {
            f1 f1Var = null;
            f1 f1Var2 = continuationInterceptor instanceof f1 ? (f1) continuationInterceptor : null;
            if (f1Var2 != null && f1Var2.Y()) {
                f1Var = f1Var2;
            }
            a = f1Var == null ? v2.a.a() : f1Var;
            c = h0.c(n1.a, coroutineContext);
        }
        h hVar = new h(c, currentThread, a);
        hVar.R0(CoroutineStart.DEFAULT, hVar, pVar);
        return (T) hVar.S0();
    }

    public static /* synthetic */ Object b(CoroutineContext coroutineContext, kotlin.jvm.b.p pVar, int i2, Object obj) throws InterruptedException {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return j.e(coroutineContext, pVar);
    }
}
