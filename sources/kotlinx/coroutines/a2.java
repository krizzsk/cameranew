package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Job.kt */
/* loaded from: classes3.dex */
public final /* synthetic */ class a2 {
    public static final a0 a(v1 v1Var) {
        return new x1(v1Var);
    }

    public static /* synthetic */ a0 b(v1 v1Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            v1Var = null;
        }
        return y1.a(v1Var);
    }

    public static final void c(CoroutineContext coroutineContext, CancellationException cancellationException) {
        v1 v1Var = (v1) coroutineContext.get(v1.b0);
        if (v1Var == null) {
            return;
        }
        v1Var.a(cancellationException);
    }

    public static /* synthetic */ void d(CoroutineContext coroutineContext, CancellationException cancellationException, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cancellationException = null;
        }
        y1.c(coroutineContext, cancellationException);
    }

    public static final b1 e(v1 v1Var, b1 b1Var) {
        return v1Var.u(new d1(b1Var));
    }

    public static final void f(CoroutineContext coroutineContext) {
        v1 v1Var = (v1) coroutineContext.get(v1.b0);
        if (v1Var == null) {
            return;
        }
        y1.h(v1Var);
    }

    public static final void g(v1 v1Var) {
        if (!v1Var.isActive()) {
            throw v1Var.t();
        }
    }

    public static final v1 h(CoroutineContext coroutineContext) {
        v1 v1Var = (v1) coroutineContext.get(v1.b0);
        if (v1Var != null) {
            return v1Var;
        }
        throw new IllegalStateException(kotlin.jvm.internal.s.q("Current context doesn't contain Job in it: ", coroutineContext).toString());
    }
}
