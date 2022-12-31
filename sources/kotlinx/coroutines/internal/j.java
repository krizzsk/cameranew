package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.v2;
import kotlinx.coroutines.z2;
/* compiled from: DispatchedContinuation.kt */
/* loaded from: classes3.dex */
public final class j {
    private static final c0 a = new c0("UNDEFINED");
    public static final c0 b = new c0("REUSABLE_CLAIMED");

    public static final <T> void b(Continuation<? super T> continuation, Object obj, kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar) {
        boolean z;
        if (continuation instanceof i) {
            i iVar = (i) continuation;
            Object b2 = kotlinx.coroutines.f0.b(obj, lVar);
            if (iVar.f8766d.isDispatchNeeded(iVar.getContext())) {
                iVar.f8768f = b2;
                iVar.c = 1;
                iVar.f8766d.dispatch(iVar.getContext(), iVar);
                return;
            }
            o0.a();
            f1 b3 = v2.a.b();
            if (b3.U()) {
                iVar.f8768f = b2;
                iVar.c = 1;
                b3.Q(iVar);
                return;
            }
            b3.S(true);
            try {
                v1 v1Var = (v1) iVar.getContext().get(v1.b0);
                if (v1Var == null || v1Var.isActive()) {
                    z = false;
                } else {
                    CancellationException t = v1Var.t();
                    iVar.a(b2, t);
                    Result.a aVar = Result.Companion;
                    iVar.resumeWith(Result.m41constructorimpl(kotlin.j.a(t)));
                    z = true;
                }
                if (!z) {
                    Continuation<T> continuation2 = iVar.f8767e;
                    Object obj2 = iVar.f8769g;
                    CoroutineContext context = continuation2.getContext();
                    Object c = ThreadContextKt.c(context, obj2);
                    z2<?> e2 = c != ThreadContextKt.a ? kotlinx.coroutines.h0.e(continuation2, context, c) : null;
                    iVar.f8767e.resumeWith(obj);
                    kotlin.u uVar = kotlin.u.a;
                    if (e2 == null || e2.T0()) {
                        ThreadContextKt.a(context, c);
                    }
                }
                do {
                } while (b3.X());
            } finally {
                try {
                    return;
                } finally {
                }
            }
            return;
        }
        continuation.resumeWith(obj);
    }

    public static /* synthetic */ void c(Continuation continuation, Object obj, kotlin.jvm.b.l lVar, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            lVar = null;
        }
        b(continuation, obj, lVar);
    }

    public static final boolean d(i<? super kotlin.u> iVar) {
        kotlin.u uVar = kotlin.u.a;
        o0.a();
        f1 b2 = v2.a.b();
        if (b2.V()) {
            return false;
        }
        if (b2.U()) {
            iVar.f8768f = uVar;
            iVar.c = 1;
            b2.Q(iVar);
            return true;
        }
        b2.S(true);
        try {
            iVar.run();
            do {
            } while (b2.X());
        } finally {
            try {
                return false;
            } finally {
            }
        }
        return false;
    }
}
