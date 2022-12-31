package kotlinx.coroutines;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;
/* compiled from: DispatchedTask.kt */
/* loaded from: classes3.dex */
public final class x0 {
    public static final <T> void a(w0<? super T> w0Var, int i2) {
        if (o0.a()) {
            if (!(i2 != -1)) {
                throw new AssertionError();
            }
        }
        Continuation<? super T> c = w0Var.c();
        boolean z = i2 == 4;
        if (!z && (c instanceof kotlinx.coroutines.internal.i) && b(i2) == b(w0Var.c)) {
            CoroutineDispatcher coroutineDispatcher = ((kotlinx.coroutines.internal.i) c).f8766d;
            CoroutineContext context = c.getContext();
            if (coroutineDispatcher.isDispatchNeeded(context)) {
                coroutineDispatcher.dispatch(context, w0Var);
                return;
            } else {
                e(w0Var);
                return;
            }
        }
        d(w0Var, c, z);
    }

    public static final boolean b(int i2) {
        return i2 == 1 || i2 == 2;
    }

    public static final boolean c(int i2) {
        return i2 == 2;
    }

    public static final <T> void d(w0<? super T> w0Var, Continuation<? super T> continuation, boolean z) {
        Object f2;
        boolean T0;
        Object i2 = w0Var.i();
        Throwable d2 = w0Var.d(i2);
        if (d2 != null) {
            Result.a aVar = Result.Companion;
            f2 = kotlin.j.a(d2);
        } else {
            Result.a aVar2 = Result.Companion;
            f2 = w0Var.f(i2);
        }
        Object m41constructorimpl = Result.m41constructorimpl(f2);
        if (z) {
            kotlinx.coroutines.internal.i iVar = (kotlinx.coroutines.internal.i) continuation;
            Continuation<T> continuation2 = iVar.f8767e;
            Object obj = iVar.f8769g;
            CoroutineContext context = continuation2.getContext();
            Object c = ThreadContextKt.c(context, obj);
            z2<?> e2 = c != ThreadContextKt.a ? h0.e(continuation2, context, c) : null;
            try {
                iVar.f8767e.resumeWith(m41constructorimpl);
                kotlin.u uVar = kotlin.u.a;
                if (e2 != null) {
                    if (!T0) {
                        return;
                    }
                }
                return;
            } finally {
                if (e2 == null || e2.T0()) {
                    ThreadContextKt.a(context, c);
                }
            }
        }
        continuation.resumeWith(m41constructorimpl);
    }

    private static final void e(w0<?> w0Var) {
        f1 b = v2.a.b();
        if (b.U()) {
            b.Q(w0Var);
            return;
        }
        b.S(true);
        try {
            d(w0Var, w0Var.c(), true);
            do {
            } while (b.X());
        } finally {
            try {
            } finally {
            }
        }
    }
}
