package kotlin.coroutines.jvm.internal;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.j;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: RunSuspend.kt */
/* loaded from: classes3.dex */
final class RunSuspend implements Continuation<u> {
    private Result<u> result;

    public final void await() {
        synchronized (this) {
            while (true) {
                Result<u> result = this.result;
                if (result == null) {
                    s.f(this, "null cannot be cast to non-null type java.lang.Object");
                    wait();
                } else {
                    j.b(result.m50unboximpl());
                }
            }
        }
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    /* renamed from: getResult-xLWZpok  reason: not valid java name */
    public final Result<u> m51getResultxLWZpok() {
        return this.result;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        synchronized (this) {
            this.result = Result.m40boximpl(obj);
            s.f(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
            u uVar = u.a;
        }
    }

    public final void setResult(Result<u> result) {
        this.result = result;
    }
}
