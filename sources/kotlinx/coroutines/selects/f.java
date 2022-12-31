package kotlinx.coroutines.selects;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.b1;
import kotlinx.coroutines.internal.p;
/* compiled from: Select.kt */
/* loaded from: classes3.dex */
public interface f<R> {
    boolean f();

    void j(b1 b1Var);

    Object m(p.c cVar);

    boolean n();

    Continuation<R> o();

    void p(Throwable th);

    Object q(kotlinx.coroutines.internal.b bVar);
}
