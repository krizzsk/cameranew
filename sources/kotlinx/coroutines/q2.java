package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
/* compiled from: Builders.common.kt */
/* loaded from: classes3.dex */
class q2 extends c<kotlin.u> {
    public q2(CoroutineContext coroutineContext, boolean z) {
        super(coroutineContext, true, z);
    }

    @Override // kotlinx.coroutines.c2
    protected boolean i0(Throwable th) {
        j0.a(getContext(), th);
        return true;
    }
}
