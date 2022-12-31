package kotlinx.coroutines.channels;

import kotlin.Result;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.p;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
/* compiled from: AbstractChannel.kt */
/* loaded from: classes3.dex */
public class t<E> extends r {

    /* renamed from: d  reason: collision with root package name */
    private final E f8728d;

    /* renamed from: e  reason: collision with root package name */
    public final kotlinx.coroutines.p<kotlin.u> f8729e;

    /* JADX WARN: Multi-variable type inference failed */
    public t(E e2, kotlinx.coroutines.p<? super kotlin.u> pVar) {
        this.f8728d = e2;
        this.f8729e = pVar;
    }

    @Override // kotlinx.coroutines.channels.r
    public void Q() {
        this.f8729e.F(kotlinx.coroutines.r.a);
    }

    @Override // kotlinx.coroutines.channels.r
    public E R() {
        return this.f8728d;
    }

    @Override // kotlinx.coroutines.channels.r
    public void S(j<?> jVar) {
        kotlinx.coroutines.p<kotlin.u> pVar = this.f8729e;
        Throwable Y = jVar.Y();
        Result.a aVar = Result.Companion;
        pVar.resumeWith(Result.m41constructorimpl(kotlin.j.a(Y)));
    }

    @Override // kotlinx.coroutines.channels.r
    public c0 T(p.c cVar) {
        Object b = this.f8729e.b(kotlin.u.a, cVar == null ? null : cVar.c);
        if (b == null) {
            return null;
        }
        if (o0.a()) {
            if (!(b == kotlinx.coroutines.r.a)) {
                throw new AssertionError();
            }
        }
        if (cVar != null) {
            cVar.d();
        }
        return kotlinx.coroutines.r.a;
    }

    @Override // kotlinx.coroutines.internal.p
    public String toString() {
        return p0.a(this) + '@' + p0.b(this) + '(' + R() + ')';
    }
}
