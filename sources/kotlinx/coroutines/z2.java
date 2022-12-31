package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;
/* compiled from: CoroutineContext.kt */
/* loaded from: classes3.dex */
public final class z2<T> extends kotlinx.coroutines.internal.y<T> {

    /* renamed from: d  reason: collision with root package name */
    private CoroutineContext f8849d;

    /* renamed from: e  reason: collision with root package name */
    private Object f8850e;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public z2(kotlin.coroutines.CoroutineContext r3, kotlin.coroutines.Continuation<? super T> r4) {
        /*
            r2 = this;
            kotlinx.coroutines.a3 r0 = kotlinx.coroutines.a3.a
            kotlin.coroutines.CoroutineContext$Element r1 = r3.get(r0)
            if (r1 != 0) goto Lc
            kotlin.coroutines.CoroutineContext r3 = r3.plus(r0)
        Lc:
            r2.<init>(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.z2.<init>(kotlin.coroutines.CoroutineContext, kotlin.coroutines.Continuation):void");
    }

    @Override // kotlinx.coroutines.internal.y, kotlinx.coroutines.c
    protected void O0(Object obj) {
        CoroutineContext coroutineContext = this.f8849d;
        if (coroutineContext != null) {
            ThreadContextKt.a(coroutineContext, this.f8850e);
            this.f8849d = null;
            this.f8850e = null;
        }
        Object a = f0.a(obj, this.c);
        Continuation<T> continuation = this.c;
        CoroutineContext context = continuation.getContext();
        Object c = ThreadContextKt.c(context, null);
        z2<?> e2 = c != ThreadContextKt.a ? h0.e(continuation, context, c) : null;
        try {
            this.c.resumeWith(a);
            kotlin.u uVar = kotlin.u.a;
        } finally {
            if (e2 == null || e2.T0()) {
                ThreadContextKt.a(context, c);
            }
        }
    }

    public final boolean T0() {
        if (this.f8849d == null) {
            return false;
        }
        this.f8849d = null;
        this.f8850e = null;
        return true;
    }

    public final void U0(CoroutineContext coroutineContext, Object obj) {
        this.f8849d = coroutineContext;
        this.f8850e = obj;
    }
}
