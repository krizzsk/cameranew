package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
/* compiled from: Delay.kt */
/* loaded from: classes3.dex */
public interface u0 {

    /* compiled from: Delay.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public static b1 a(u0 u0Var, long j2, Runnable runnable, CoroutineContext coroutineContext) {
            return r0.a().m(j2, runnable, coroutineContext);
        }
    }

    void e(long j2, p<? super kotlin.u> pVar);

    b1 m(long j2, Runnable runnable, CoroutineContext coroutineContext);
}
