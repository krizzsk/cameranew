package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
/* compiled from: AbstractCoroutine.kt */
/* loaded from: classes3.dex */
public abstract class c<T> extends c2 implements v1, Continuation<T>, m0 {
    private final CoroutineContext b;

    public c(CoroutineContext coroutineContext, boolean z, boolean z2) {
        super(z2);
        if (z) {
            k0((v1) coroutineContext.get(v1.b0));
        }
        this.b = coroutineContext.plus(this);
    }

    protected void O0(Object obj) {
        K(obj);
    }

    protected void P0(Throwable th, boolean z) {
    }

    protected void Q0(T t) {
    }

    public final <R> void R0(CoroutineStart coroutineStart, R r, kotlin.jvm.b.p<? super R, ? super Continuation<? super T>, ? extends Object> pVar) {
        coroutineStart.invoke(pVar, r, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.c2
    public String U() {
        return kotlin.jvm.internal.s.q(p0.a(this), " was cancelled");
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.b;
    }

    @Override // kotlinx.coroutines.m0
    public CoroutineContext getCoroutineContext() {
        return this.b;
    }

    @Override // kotlinx.coroutines.c2, kotlinx.coroutines.v1
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.c2
    public final void j0(Throwable th) {
        j0.a(this.b, th);
    }

    @Override // kotlinx.coroutines.c2
    public String r0() {
        String b = h0.b(this.b);
        if (b == null) {
            return super.r0();
        }
        return '\"' + b + "\":" + super.r0();
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Object p0 = p0(f0.d(obj, null, 1, null));
        if (p0 == d2.b) {
            return;
        }
        O0(p0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.c2
    protected final void w0(Object obj) {
        if (obj instanceof c0) {
            c0 c0Var = (c0) obj;
            P0(c0Var.a, c0Var.a());
            return;
        }
        Q0(obj);
    }
}
