package kotlinx.coroutines.scheduling;

import java.util.concurrent.RejectedExecutionException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.q0;
/* compiled from: Dispatcher.kt */
/* loaded from: classes3.dex */
public class b extends ExecutorCoroutineDispatcher {
    private final int a;
    private final int b;
    private final long c;

    /* renamed from: d  reason: collision with root package name */
    private final String f8805d;

    /* renamed from: e  reason: collision with root package name */
    private CoroutineScheduler f8806e;

    public b(int i2, int i3, long j2, String str) {
        this.a = i2;
        this.b = i3;
        this.c = j2;
        this.f8805d = str;
        this.f8806e = z();
    }

    private final CoroutineScheduler z() {
        return new CoroutineScheduler(this.a, this.b, this.c, this.f8805d);
    }

    public final void A(Runnable runnable, i iVar, boolean z) {
        try {
            this.f8806e.u(runnable, iVar, z);
        } catch (RejectedExecutionException unused) {
            q0.f8788f.f0(this.f8806e.e(runnable, iVar));
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            CoroutineScheduler.v(this.f8806e, runnable, null, false, 6, null);
        } catch (RejectedExecutionException unused) {
            q0.f8788f.dispatch(coroutineContext, runnable);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            CoroutineScheduler.v(this.f8806e, runnable, null, true, 2, null);
        } catch (RejectedExecutionException unused) {
            q0.f8788f.dispatchYield(coroutineContext, runnable);
        }
    }

    public /* synthetic */ b(int i2, int i3, String str, int i4, o oVar) {
        this((i4 & 1) != 0 ? k.b : i2, (i4 & 2) != 0 ? k.c : i3, (i4 & 4) != 0 ? "DefaultDispatcher" : str);
    }

    public b(int i2, int i3, String str) {
        this(i2, i3, k.f8810d, str);
    }
}
