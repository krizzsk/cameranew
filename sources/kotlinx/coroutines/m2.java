package kotlinx.coroutines;

import kotlin.Result;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class m2<T> extends b2 {

    /* renamed from: e  reason: collision with root package name */
    private final q<T> f8778e;

    /* JADX WARN: Multi-variable type inference failed */
    public m2(q<? super T> qVar) {
        this.f8778e = qVar;
    }

    @Override // kotlinx.coroutines.e0
    public void Q(Throwable th) {
        Object h0 = R().h0();
        if (o0.a() && !(!(h0 instanceof p1))) {
            throw new AssertionError();
        }
        if (h0 instanceof c0) {
            q<T> qVar = this.f8778e;
            Throwable th2 = ((c0) h0).a;
            Result.a aVar = Result.Companion;
            qVar.resumeWith(Result.m41constructorimpl(kotlin.j.a(th2)));
            return;
        }
        q<T> qVar2 = this.f8778e;
        Object h2 = d2.h(h0);
        Result.a aVar2 = Result.Companion;
        qVar2.resumeWith(Result.m41constructorimpl(h2));
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
        Q(th);
        return kotlin.u.a;
    }
}
