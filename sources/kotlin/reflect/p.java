package kotlin.reflect;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.s;
import org.slf4j.Marker;
/* compiled from: KTypeProjection.kt */
/* loaded from: classes3.dex */
public final class p {
    private final KVariance a;
    private final o b;

    /* compiled from: KTypeProjection.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[KVariance.values().length];
            iArr[KVariance.INVARIANT.ordinal()] = 1;
            iArr[KVariance.IN.ordinal()] = 2;
            iArr[KVariance.OUT.ordinal()] = 3;
            a = iArr;
        }
    }

    static {
        new p(null, null);
    }

    public p(KVariance kVariance, o oVar) {
        String str;
        this.a = kVariance;
        this.b = oVar;
        if ((kVariance == null) == (oVar == null)) {
            return;
        }
        if (kVariance == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + kVariance + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public final o a() {
        return this.b;
    }

    public final KVariance b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            return this.a == pVar.a && s.c(this.b, pVar.b);
        }
        return false;
    }

    public int hashCode() {
        KVariance kVariance = this.a;
        int hashCode = (kVariance == null ? 0 : kVariance.hashCode()) * 31;
        o oVar = this.b;
        return hashCode + (oVar != null ? oVar.hashCode() : 0);
    }

    public String toString() {
        KVariance kVariance = this.a;
        int i2 = kVariance == null ? -1 : a.a[kVariance.ordinal()];
        if (i2 != -1) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return "in " + this.b;
                } else if (i2 == 3) {
                    return "out " + this.b;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return String.valueOf(this.b);
        }
        return Marker.ANY_MARKER;
    }
}
