package kotlinx.coroutines.android;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.b1;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.u0;
/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes3.dex */
public abstract class a extends g2 implements u0 {
    private a() {
    }

    public /* synthetic */ a(o oVar) {
        this();
    }

    public b1 m(long j2, Runnable runnable, CoroutineContext coroutineContext) {
        return u0.a.a(this, j2, runnable, coroutineContext);
    }
}
