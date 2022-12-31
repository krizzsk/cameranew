package kotlinx.coroutines.internal;
/* compiled from: Atomic.kt */
/* loaded from: classes3.dex */
public abstract class b {
    public d<?> a;

    public abstract void a(d<?> dVar, Object obj);

    public final d<?> b() {
        d<?> dVar = this.a;
        if (dVar != null) {
            return dVar;
        }
        kotlin.jvm.internal.s.z("atomicOp");
        throw null;
    }

    public abstract Object c(d<?> dVar);

    public final void d(d<?> dVar) {
        this.a = dVar;
    }
}
