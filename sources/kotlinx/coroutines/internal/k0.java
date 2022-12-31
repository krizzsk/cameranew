package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.t2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThreadContext.kt */
/* loaded from: classes3.dex */
public final class k0 {
    public final CoroutineContext a;
    private final Object[] b;
    private final t2<Object>[] c;

    /* renamed from: d  reason: collision with root package name */
    private int f8770d;

    public k0(CoroutineContext coroutineContext, int i2) {
        this.a = coroutineContext;
        this.b = new Object[i2];
        this.c = new t2[i2];
    }

    public final void a(t2<?> t2Var, Object obj) {
        Object[] objArr = this.b;
        int i2 = this.f8770d;
        objArr[i2] = obj;
        t2<Object>[] t2VarArr = this.c;
        this.f8770d = i2 + 1;
        t2VarArr[i2] = t2Var;
    }

    public final void b(CoroutineContext coroutineContext) {
        int length = this.c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i2 = length - 1;
            t2<Object> t2Var = this.c[length];
            kotlin.jvm.internal.s.e(t2Var);
            t2Var.n(coroutineContext, this.b[length]);
            if (i2 < 0) {
                return;
            }
            length = i2;
        }
    }
}
