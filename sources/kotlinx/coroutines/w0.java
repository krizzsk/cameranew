package kotlinx.coroutines;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.internal.ThreadContextKt;
/* compiled from: DispatchedTask.kt */
/* loaded from: classes3.dex */
public abstract class w0<T> extends kotlinx.coroutines.scheduling.h {
    public int c;

    public w0(int i2) {
        this.c = i2;
    }

    public void a(Object obj, Throwable th) {
    }

    public abstract Continuation<T> c();

    public Throwable d(Object obj) {
        c0 c0Var = obj instanceof c0 ? (c0) obj : null;
        if (c0Var == null) {
            return null;
        }
        return c0Var.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T f(Object obj) {
        return obj;
    }

    public final void h(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            kotlin.b.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        kotlin.jvm.internal.s.e(th);
        j0.a(c().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object i();

    @Override // java.lang.Runnable
    public final void run() {
        Object m41constructorimpl;
        Object m41constructorimpl2;
        if (o0.a()) {
            if (!(this.c != -1)) {
                throw new AssertionError();
            }
        }
        kotlinx.coroutines.scheduling.i iVar = this.b;
        try {
            kotlinx.coroutines.internal.i iVar2 = (kotlinx.coroutines.internal.i) c();
            Continuation<T> continuation = iVar2.f8767e;
            Object obj = iVar2.f8769g;
            CoroutineContext context = continuation.getContext();
            Object c = ThreadContextKt.c(context, obj);
            z2<?> e2 = c != ThreadContextKt.a ? h0.e(continuation, context, c) : null;
            CoroutineContext context2 = continuation.getContext();
            Object i2 = i();
            Throwable d2 = d(i2);
            v1 v1Var = (d2 == null && x0.b(this.c)) ? (v1) context2.get(v1.b0) : null;
            if (v1Var != null && !v1Var.isActive()) {
                Throwable t = v1Var.t();
                a(i2, t);
                Result.a aVar = Result.Companion;
                if (o0.d() && (continuation instanceof CoroutineStackFrame)) {
                    t = kotlinx.coroutines.internal.b0.a(t, (CoroutineStackFrame) continuation);
                }
                continuation.resumeWith(Result.m41constructorimpl(kotlin.j.a(t)));
            } else if (d2 != null) {
                Result.a aVar2 = Result.Companion;
                continuation.resumeWith(Result.m41constructorimpl(kotlin.j.a(d2)));
            } else {
                T f2 = f(i2);
                Result.a aVar3 = Result.Companion;
                continuation.resumeWith(Result.m41constructorimpl(f2));
            }
            kotlin.u uVar = kotlin.u.a;
            if (e2 == null || e2.T0()) {
                ThreadContextKt.a(context, c);
            }
            try {
                Result.a aVar4 = Result.Companion;
                iVar.v();
                m41constructorimpl2 = Result.m41constructorimpl(uVar);
            } catch (Throwable th) {
                Result.a aVar5 = Result.Companion;
                m41constructorimpl2 = Result.m41constructorimpl(kotlin.j.a(th));
            }
            h(null, Result.m44exceptionOrNullimpl(m41constructorimpl2));
        } catch (Throwable th2) {
            try {
                Result.a aVar6 = Result.Companion;
                iVar.v();
                m41constructorimpl = Result.m41constructorimpl(kotlin.u.a);
            } catch (Throwable th3) {
                Result.a aVar7 = Result.Companion;
                m41constructorimpl = Result.m41constructorimpl(kotlin.j.a(th3));
            }
            h(th2, Result.m44exceptionOrNullimpl(m41constructorimpl));
        }
    }
}
