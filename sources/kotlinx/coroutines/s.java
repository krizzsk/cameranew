package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
/* compiled from: CancellableContinuation.kt */
/* loaded from: classes3.dex */
public final class s {
    public static final void a(p<?> pVar, b1 b1Var) {
        pVar.e(new c1(b1Var));
    }

    public static final <T> q<T> b(Continuation<? super T> continuation) {
        if (!(continuation instanceof kotlinx.coroutines.internal.i)) {
            return new q<>(continuation, 1);
        }
        q<T> m = ((kotlinx.coroutines.internal.i) continuation).m();
        if (m == null || !m.J()) {
            m = null;
        }
        return m == null ? new q<>(continuation, 2) : m;
    }

    public static final void c(p<?> pVar, kotlinx.coroutines.internal.p pVar2) {
        pVar.e(new l2(pVar2));
    }
}
