package kotlinx.coroutines;
/* compiled from: MainCoroutineDispatcher.kt */
/* loaded from: classes3.dex */
public abstract class g2 extends CoroutineDispatcher {
    /* JADX INFO: Access modifiers changed from: protected */
    public final String A() {
        g2 g2Var;
        g2 c = z0.c();
        if (this == c) {
            return "Dispatchers.Main";
        }
        try {
            g2Var = c.z();
        } catch (UnsupportedOperationException unused) {
            g2Var = null;
        }
        if (this == g2Var) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String A = A();
        if (A == null) {
            return p0.a(this) + '@' + p0.b(this);
        }
        return A;
    }

    public abstract g2 z();
}
