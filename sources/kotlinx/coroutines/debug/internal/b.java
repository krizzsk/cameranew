package kotlinx.coroutines.debug.internal;

import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.j;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.y;
import kotlin.u;
import kotlinx.coroutines.v1;
/* compiled from: DebugProbesImpl.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final b a;
    private static final ConcurrentWeakMap<a<?>, Boolean> b;
    private static final l<Boolean, u> c;

    /* renamed from: d  reason: collision with root package name */
    private static final ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfoImpl> f8744d;
    private static volatile int installations;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DebugProbesImpl.kt */
    /* loaded from: classes3.dex */
    public static final class a<T> implements Continuation<T>, CoroutineStackFrame {
        public final Continuation<T> a;
        public final DebugCoroutineInfoImpl b;
        private final CoroutineStackFrame c;

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public CoroutineStackFrame getCallerFrame() {
            CoroutineStackFrame coroutineStackFrame = this.c;
            if (coroutineStackFrame == null) {
                return null;
            }
            return coroutineStackFrame.getCallerFrame();
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.a.getContext();
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public StackTraceElement getStackTraceElement() {
            CoroutineStackFrame coroutineStackFrame = this.c;
            if (coroutineStackFrame == null) {
                return null;
            }
            return coroutineStackFrame.getStackTraceElement();
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object obj) {
            b.a.f(this);
            this.a.resumeWith(obj);
        }

        public String toString() {
            return this.a.toString();
        }
    }

    static {
        b bVar = new b();
        a = bVar;
        new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        b = new ConcurrentWeakMap<>(false, 1, null);
        new ReentrantReadWriteLock();
        c = bVar.d();
        f8744d = new ConcurrentWeakMap<>(true);
        AtomicLongFieldUpdater.newUpdater(c.class, "sequenceNumber");
    }

    private b() {
    }

    private final l<Boolean, u> d() {
        Object m41constructorimpl;
        Object newInstance;
        try {
            Result.a aVar = Result.Companion;
            newInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m41constructorimpl = Result.m41constructorimpl(j.a(th));
        }
        if (newInstance != null) {
            y.d(newInstance, 1);
            m41constructorimpl = Result.m41constructorimpl((l) newInstance);
            if (Result.m47isFailureimpl(m41constructorimpl)) {
                m41constructorimpl = null;
            }
            return (l) m41constructorimpl;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(a<?> aVar) {
        CoroutineContext b2 = aVar.b.b();
        v1 v1Var = b2 == null ? null : (v1) b2.get(v1.b0);
        if (v1Var != null && v1Var.d()) {
            b.remove(aVar);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(a<?> aVar) {
        b.remove(aVar);
        CoroutineStackFrame c2 = aVar.b.c();
        CoroutineStackFrame g2 = c2 == null ? null : g(c2);
        if (g2 == null) {
            return;
        }
        f8744d.remove(g2);
    }

    private final CoroutineStackFrame g(CoroutineStackFrame coroutineStackFrame) {
        do {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        } while (coroutineStackFrame.getStackTraceElement() == null);
        return coroutineStackFrame;
    }
}
