package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.flow.h1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.internal.c;
import kotlinx.coroutines.flow.y0;
/* compiled from: AbstractSharedFlow.kt */
/* loaded from: classes3.dex */
public abstract class a<S extends c<?>> {
    private S[] a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private y0<Integer> f8756d;

    public final h1<Integer> c() {
        y0<Integer> y0Var;
        synchronized (this) {
            y0Var = this.f8756d;
            if (y0Var == null) {
                y0Var = i1.a(Integer.valueOf(k()));
                this.f8756d = y0Var;
            }
        }
        return y0Var;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final S e() {
        S s;
        y0<Integer> y0Var;
        synchronized (this) {
            S[] l2 = l();
            if (l2 == null) {
                l2 = i(2);
                this.a = l2;
            } else if (k() >= l2.length) {
                Object[] copyOf = Arrays.copyOf(l2, l2.length * 2);
                s.g(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                this.a = (S[]) ((c[]) copyOf);
                l2 = (S[]) ((c[]) copyOf);
            }
            int i2 = this.c;
            do {
                s = l2[i2];
                if (s == null) {
                    s = g();
                    l2[i2] = s;
                }
                i2++;
                if (i2 >= l2.length) {
                    i2 = 0;
                }
            } while (!s.a(this));
            this.c = i2;
            this.b = k() + 1;
            y0Var = this.f8756d;
        }
        if (y0Var != null) {
            i1.e(y0Var, 1);
        }
        return s;
    }

    protected abstract S g();

    protected abstract S[] i(int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j(S s) {
        y0<Integer> y0Var;
        int i2;
        Continuation<u>[] b;
        synchronized (this) {
            this.b = k() - 1;
            y0Var = this.f8756d;
            i2 = 0;
            if (k() == 0) {
                this.c = 0;
            }
            b = s.b(this);
        }
        int length = b.length;
        while (i2 < length) {
            Continuation<u> continuation = b[i2];
            i2++;
            if (continuation != null) {
                u uVar = u.a;
                Result.a aVar = Result.Companion;
                continuation.resumeWith(Result.m41constructorimpl(uVar));
            }
        }
        if (y0Var == null) {
            return;
        }
        i1.e(y0Var, -1);
    }

    protected final int k() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final S[] l() {
        return this.a;
    }
}
