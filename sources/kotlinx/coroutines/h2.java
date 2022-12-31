package kotlinx.coroutines;
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class h2 extends kotlinx.coroutines.internal.n implements p1 {
    public final String R(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("List{");
        sb.append(str);
        sb.append("}[");
        boolean z = true;
        for (kotlinx.coroutines.internal.p pVar = (kotlinx.coroutines.internal.p) E(); !kotlin.jvm.internal.s.c(pVar, this); pVar = pVar.G()) {
            if (pVar instanceof b2) {
                b2 b2Var = (b2) pVar;
                if (z) {
                    z = false;
                } else {
                    sb.append(", ");
                }
                sb.append(b2Var);
            }
        }
        sb.append("]");
        String sb2 = sb.toString();
        kotlin.jvm.internal.s.g(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @Override // kotlinx.coroutines.p1
    public h2 d() {
        return this;
    }

    @Override // kotlinx.coroutines.p1
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.p
    public String toString() {
        return o0.c() ? R("Active") : super.toString();
    }
}
