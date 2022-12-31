package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class p2<T, R> extends b2 {

    /* renamed from: e  reason: collision with root package name */
    private final kotlinx.coroutines.selects.f<R> f8781e;

    /* renamed from: f  reason: collision with root package name */
    private final kotlin.jvm.b.p<T, Continuation<? super R>, Object> f8782f;

    /* JADX WARN: Multi-variable type inference failed */
    public p2(kotlinx.coroutines.selects.f<? super R> fVar, kotlin.jvm.b.p<? super T, ? super Continuation<? super R>, ? extends Object> pVar) {
        this.f8781e = fVar;
        this.f8782f = pVar;
    }

    @Override // kotlinx.coroutines.e0
    public void Q(Throwable th) {
        if (this.f8781e.n()) {
            R().C0(this.f8781e, this.f8782f);
        }
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
        Q(th);
        return kotlin.u.a;
    }
}
