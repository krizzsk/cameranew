package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
/* compiled from: CompletionState.kt */
/* loaded from: classes3.dex */
public class c0 {
    private static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(c0.class, "_handled");
    private volatile /* synthetic */ int _handled;
    public final Throwable a;

    public c0(Throwable th, boolean z) {
        this.a = th;
        this._handled = z ? 1 : 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean a() {
        return this._handled;
    }

    public final boolean b() {
        return b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return p0.a(this) + '[' + this.a + ']';
    }

    public /* synthetic */ c0(Throwable th, boolean z, int i2, kotlin.jvm.internal.o oVar) {
        this(th, (i2 & 2) != 0 ? false : z);
    }
}
