package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StateFlow.kt */
/* loaded from: classes3.dex */
public final class j1 extends kotlinx.coroutines.flow.internal.c<StateFlowImpl<?>> {
    static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(j1.class, Object.class, "_state");
    volatile /* synthetic */ Object _state = null;

    @Override // kotlinx.coroutines.flow.internal.c
    /* renamed from: c */
    public boolean a(StateFlowImpl<?> stateFlowImpl) {
        kotlinx.coroutines.internal.c0 c0Var;
        if (this._state != null) {
            return false;
        }
        c0Var = i1.a;
        this._state = c0Var;
        return true;
    }

    public final Object d(Continuation<? super kotlin.u> continuation) {
        Continuation intercepted;
        kotlinx.coroutines.internal.c0 c0Var;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        kotlinx.coroutines.internal.c0 c0Var2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        kotlinx.coroutines.q qVar = new kotlinx.coroutines.q(intercepted, 1);
        qVar.x();
        if (!kotlinx.coroutines.o0.a() || (!(this._state instanceof kotlinx.coroutines.q))) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            c0Var = i1.a;
            if (!atomicReferenceFieldUpdater.compareAndSet(this, c0Var, qVar)) {
                if (kotlinx.coroutines.o0.a()) {
                    Object obj = this._state;
                    c0Var2 = i1.b;
                    if (!(obj == c0Var2)) {
                        throw new AssertionError();
                    }
                }
                kotlin.u uVar = kotlin.u.a;
                Result.a aVar = Result.Companion;
                qVar.resumeWith(Result.m41constructorimpl(uVar));
            }
            Object u = qVar.u();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (u == coroutine_suspended) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return u == coroutine_suspended2 ? u : kotlin.u.a;
        }
        throw new AssertionError();
    }

    @Override // kotlinx.coroutines.flow.internal.c
    /* renamed from: e */
    public Continuation<kotlin.u>[] b(StateFlowImpl<?> stateFlowImpl) {
        this._state = null;
        return kotlinx.coroutines.flow.internal.b.a;
    }

    public final void f() {
        kotlinx.coroutines.internal.c0 c0Var;
        kotlinx.coroutines.internal.c0 c0Var2;
        kotlinx.coroutines.internal.c0 c0Var3;
        kotlinx.coroutines.internal.c0 c0Var4;
        while (true) {
            Object obj = this._state;
            if (obj == null) {
                return;
            }
            c0Var = i1.b;
            if (obj == c0Var) {
                return;
            }
            c0Var2 = i1.a;
            if (obj == c0Var2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
                c0Var3 = i1.b;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, c0Var3)) {
                    return;
                }
            } else {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = a;
                c0Var4 = i1.a;
                if (atomicReferenceFieldUpdater2.compareAndSet(this, obj, c0Var4)) {
                    kotlin.u uVar = kotlin.u.a;
                    Result.a aVar = Result.Companion;
                    ((kotlinx.coroutines.q) obj).resumeWith(Result.m41constructorimpl(uVar));
                    return;
                }
            }
        }
    }

    public final boolean g() {
        kotlinx.coroutines.internal.c0 c0Var;
        kotlinx.coroutines.internal.c0 c0Var2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        c0Var = i1.a;
        Object andSet = atomicReferenceFieldUpdater.getAndSet(this, c0Var);
        kotlin.jvm.internal.s.e(andSet);
        if (!kotlinx.coroutines.o0.a() || (!(andSet instanceof kotlinx.coroutines.q))) {
            c0Var2 = i1.b;
            return andSet == c0Var2;
        }
        throw new AssertionError();
    }
}
