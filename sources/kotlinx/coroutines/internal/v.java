package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.b1;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.u0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainDispatchers.kt */
/* loaded from: classes3.dex */
public final class v extends g2 implements u0 {
    private final Throwable a;
    private final String b;

    public v(Throwable th, String str) {
        this.a = th;
        this.b = str;
    }

    private final Void R() {
        String q;
        if (this.a != null) {
            String str = this.b;
            String str2 = "";
            if (str != null && (q = kotlin.jvm.internal.s.q(". ", str)) != null) {
                str2 = q;
            }
            throw new IllegalStateException(kotlin.jvm.internal.s.q("Module with the Main dispatcher had failed to initialize", str2), this.a);
        }
        u.c();
        throw null;
    }

    public Void Q(CoroutineContext coroutineContext, Runnable runnable) {
        R();
        throw null;
    }

    public Void S(long j2, kotlinx.coroutines.p<? super kotlin.u> pVar) {
        R();
        throw null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public /* bridge */ /* synthetic */ void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        Q(coroutineContext, runnable);
        throw null;
    }

    @Override // kotlinx.coroutines.u0
    public /* bridge */ /* synthetic */ void e(long j2, kotlinx.coroutines.p pVar) {
        S(j2, pVar);
        throw null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        R();
        throw null;
    }

    @Override // kotlinx.coroutines.u0
    public b1 m(long j2, Runnable runnable, CoroutineContext coroutineContext) {
        R();
        throw null;
    }

    @Override // kotlinx.coroutines.g2, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        Throwable th = this.a;
        sb.append(th != null ? kotlin.jvm.internal.s.q(", cause=", th) : "");
        sb.append(']');
        return sb.toString();
    }

    @Override // kotlinx.coroutines.g2
    public g2 z() {
        return this;
    }
}
