package com.google.android.play.core.internal;
/* loaded from: classes2.dex */
public final class l1<T> implements n1<T> {
    private n1<T> a;

    public static <T> void b(n1<T> n1Var, n1<T> n1Var2) {
        t0.k(n1Var2);
        l1 l1Var = (l1) n1Var;
        if (l1Var.a != null) {
            throw new IllegalStateException();
        }
        l1Var.a = n1Var2;
    }

    @Override // com.google.android.play.core.internal.n1
    public final T a() {
        n1<T> n1Var = this.a;
        if (n1Var != null) {
            return n1Var.a();
        }
        throw new IllegalStateException();
    }
}
