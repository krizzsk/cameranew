package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
final class t1 extends w1 {

    /* renamed from: f  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f8841f = AtomicIntegerFieldUpdater.newUpdater(t1.class, "_invoked");
    private volatile /* synthetic */ int _invoked = 0;

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.jvm.b.l<Throwable, kotlin.u> f8842e;

    /* JADX WARN: Multi-variable type inference failed */
    public t1(kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar) {
        this.f8842e = lVar;
    }

    @Override // kotlinx.coroutines.e0
    public void Q(Throwable th) {
        if (f8841f.compareAndSet(this, 0, 1)) {
            this.f8842e.invoke(th);
        }
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
        Q(th);
        return kotlin.u.a;
    }
}
