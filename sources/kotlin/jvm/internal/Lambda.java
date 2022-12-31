package kotlin.jvm.internal;

import java.io.Serializable;
/* compiled from: Lambda.kt */
/* loaded from: classes3.dex */
public abstract class Lambda<R> implements q<R>, Serializable {
    private final int arity;

    public Lambda(int i2) {
        this.arity = i2;
    }

    @Override // kotlin.jvm.internal.q
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String k2 = v.k(this);
        s.g(k2, "renderLambdaToString(this)");
        return k2;
    }
}
