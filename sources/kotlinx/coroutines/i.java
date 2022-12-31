package kotlinx.coroutines;
/* compiled from: EventLoop.kt */
/* loaded from: classes3.dex */
public final class i extends g1 {

    /* renamed from: f  reason: collision with root package name */
    private final Thread f8763f;

    public i(Thread thread) {
        this.f8763f = thread;
    }

    @Override // kotlinx.coroutines.h1
    protected Thread Z() {
        return this.f8763f;
    }
}
