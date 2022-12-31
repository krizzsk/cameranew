package kotlinx.coroutines;
/* compiled from: EventLoop.common.kt */
/* loaded from: classes3.dex */
public final class v2 {
    public static final v2 a = new v2();
    private static final ThreadLocal<f1> b = new ThreadLocal<>();

    private v2() {
    }

    public final f1 a() {
        return b.get();
    }

    public final f1 b() {
        ThreadLocal<f1> threadLocal = b;
        f1 f1Var = threadLocal.get();
        if (f1Var == null) {
            f1 a2 = i1.a();
            threadLocal.set(a2);
            return a2;
        }
        return f1Var;
    }

    public final void c() {
        b.set(null);
    }

    public final void d(f1 f1Var) {
        b.set(f1Var);
    }
}
