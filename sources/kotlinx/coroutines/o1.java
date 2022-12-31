package kotlinx.coroutines;
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class o1 implements p1 {
    private final h2 a;

    public o1(h2 h2Var) {
        this.a = h2Var;
    }

    @Override // kotlinx.coroutines.p1
    public h2 d() {
        return this.a;
    }

    @Override // kotlinx.coroutines.p1
    public boolean isActive() {
        return false;
    }

    public String toString() {
        return o0.c() ? d().R("New") : super.toString();
    }
}
