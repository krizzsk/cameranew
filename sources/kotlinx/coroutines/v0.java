package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
/* compiled from: Builders.common.kt */
/* loaded from: classes3.dex */
public final class v0<T> extends kotlinx.coroutines.internal.y<T> {

    /* renamed from: d  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f8845d = AtomicIntegerFieldUpdater.newUpdater(v0.class, "_decision");
    private volatile /* synthetic */ int _decision;

    public v0(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
        this._decision = 0;
    }

    private final boolean U0() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f8845d.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean V0() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f8845d.compareAndSet(this, 0, 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.internal.y, kotlinx.coroutines.c2
    public void K(Object obj) {
        O0(obj);
    }

    @Override // kotlinx.coroutines.internal.y, kotlinx.coroutines.c
    protected void O0(Object obj) {
        Continuation intercepted;
        if (U0()) {
            return;
        }
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this.c);
        kotlinx.coroutines.internal.j.c(intercepted, f0.a(obj, this.c), null, 2, null);
    }

    public final Object T0() {
        Object coroutine_suspended;
        if (V0()) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return coroutine_suspended;
        }
        Object h2 = d2.h(h0());
        if (h2 instanceof c0) {
            throw ((c0) h2).a;
        }
        return h2;
    }
}
