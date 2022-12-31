package kotlinx.coroutines;
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public class x1 extends c2 implements a0 {
    private final boolean b;

    public x1(v1 v1Var) {
        super(true);
        k0(v1Var);
        this.b = O0();
    }

    private final boolean O0() {
        v g0 = g0();
        w wVar = g0 instanceof w ? (w) g0 : null;
        if (wVar == null) {
            return false;
        }
        c2 R = wVar.R();
        while (!R.d0()) {
            v g02 = R.g0();
            w wVar2 = g02 instanceof w ? (w) g02 : null;
            if (wVar2 == null) {
                return false;
            }
            R = wVar2.R();
        }
        return true;
    }

    @Override // kotlinx.coroutines.c2
    public boolean d0() {
        return this.b;
    }

    @Override // kotlinx.coroutines.c2
    public boolean e0() {
        return true;
    }
}
