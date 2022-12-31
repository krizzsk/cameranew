package kotlinx.coroutines;

import kotlin.Result;
import kotlin.coroutines.Continuation;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class n2 extends b2 {

    /* renamed from: e  reason: collision with root package name */
    private final Continuation<kotlin.u> f8779e;

    /* JADX WARN: Multi-variable type inference failed */
    public n2(Continuation<? super kotlin.u> continuation) {
        this.f8779e = continuation;
    }

    @Override // kotlinx.coroutines.e0
    public void Q(Throwable th) {
        Continuation<kotlin.u> continuation = this.f8779e;
        kotlin.u uVar = kotlin.u.a;
        Result.a aVar = Result.Companion;
        continuation.resumeWith(Result.m41constructorimpl(uVar));
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
        Q(th);
        return kotlin.u.a;
    }
}
