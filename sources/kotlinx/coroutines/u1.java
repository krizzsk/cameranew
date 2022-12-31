package kotlinx.coroutines;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class u1 extends b2 {

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.jvm.b.l<Throwable, kotlin.u> f8844e;

    /* JADX WARN: Multi-variable type inference failed */
    public u1(kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar) {
        this.f8844e = lVar;
    }

    @Override // kotlinx.coroutines.e0
    public void Q(Throwable th) {
        this.f8844e.invoke(th);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
        Q(th);
        return kotlin.u.a;
    }
}
