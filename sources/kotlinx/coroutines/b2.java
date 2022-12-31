package kotlinx.coroutines;
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public abstract class b2 extends e0 implements b1, p1 {

    /* renamed from: d  reason: collision with root package name */
    public c2 f8697d;

    public final c2 R() {
        c2 c2Var = this.f8697d;
        if (c2Var != null) {
            return c2Var;
        }
        kotlin.jvm.internal.s.z("job");
        throw null;
    }

    public final void S(c2 c2Var) {
        this.f8697d = c2Var;
    }

    @Override // kotlinx.coroutines.p1
    public h2 d() {
        return null;
    }

    @Override // kotlinx.coroutines.b1
    public void dispose() {
        R().B0(this);
    }

    @Override // kotlinx.coroutines.p1
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.p
    public String toString() {
        return p0.a(this) + '@' + p0.b(this) + "[job@" + p0.b(R()) + ']';
    }
}
