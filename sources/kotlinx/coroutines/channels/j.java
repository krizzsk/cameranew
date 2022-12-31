package kotlinx.coroutines.channels;

import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.p;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
/* compiled from: AbstractChannel.kt */
/* loaded from: classes3.dex */
public final class j<E> extends r implements p<E> {

    /* renamed from: d  reason: collision with root package name */
    public final Throwable f8725d;

    public j(Throwable th) {
        this.f8725d = th;
    }

    @Override // kotlinx.coroutines.channels.r
    public void Q() {
    }

    @Override // kotlinx.coroutines.channels.r
    public /* bridge */ /* synthetic */ Object R() {
        W();
        return this;
    }

    @Override // kotlinx.coroutines.channels.r
    public void S(j<?> jVar) {
        if (o0.a()) {
            throw new AssertionError();
        }
    }

    @Override // kotlinx.coroutines.channels.r
    public c0 T(p.c cVar) {
        c0 c0Var = kotlinx.coroutines.r.a;
        if (cVar != null) {
            cVar.d();
        }
        return c0Var;
    }

    public j<E> V() {
        return this;
    }

    public j<E> W() {
        return this;
    }

    public final Throwable X() {
        Throwable th = this.f8725d;
        return th == null ? new ClosedReceiveChannelException("Channel was closed") : th;
    }

    public final Throwable Y() {
        Throwable th = this.f8725d;
        return th == null ? new ClosedSendChannelException("Channel was closed") : th;
    }

    @Override // kotlinx.coroutines.channels.p
    public /* bridge */ /* synthetic */ Object a() {
        V();
        return this;
    }

    @Override // kotlinx.coroutines.channels.p
    public void i(E e2) {
    }

    @Override // kotlinx.coroutines.channels.p
    public c0 r(E e2, p.c cVar) {
        c0 c0Var = kotlinx.coroutines.r.a;
        if (cVar != null) {
            cVar.d();
        }
        return c0Var;
    }

    @Override // kotlinx.coroutines.internal.p
    public String toString() {
        return "Closed@" + p0.b(this) + '[' + this.f8725d + ']';
    }
}
