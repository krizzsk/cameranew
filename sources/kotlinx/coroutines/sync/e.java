package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.b.l;
import kotlin.u;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;
import kotlinx.coroutines.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Semaphore.kt */
/* loaded from: classes3.dex */
public final class e implements d {
    private static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "head");

    /* renamed from: d  reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f8836d = AtomicLongFieldUpdater.newUpdater(e.class, "deqIdx");

    /* renamed from: e  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f8837e = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "tail");

    /* renamed from: f  reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f8838f = AtomicLongFieldUpdater.newUpdater(e.class, "enqIdx");

    /* renamed from: g  reason: collision with root package name */
    static final /* synthetic */ AtomicIntegerFieldUpdater f8839g = AtomicIntegerFieldUpdater.newUpdater(e.class, "_availablePermits");
    volatile /* synthetic */ int _availablePermits;
    private final int a;
    private final l<Throwable, u> b;
    private volatile /* synthetic */ long deqIdx;
    private volatile /* synthetic */ long enqIdx;
    private volatile /* synthetic */ Object head;
    private volatile /* synthetic */ Object tail;

    private final Object d(Continuation<? super u> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        q b = s.b(intercepted);
        while (true) {
            if (!e(b)) {
                if (f8839g.getAndDecrement(this) > 0) {
                    b.k(u.a, this.b);
                    break;
                }
            } else {
                break;
            }
        }
        Object u = b.u();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (u == coroutine_suspended) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return u == coroutine_suspended2 ? u : u.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0056, code lost:
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0072, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(kotlinx.coroutines.p<? super kotlin.u> r18) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.e.e(kotlinx.coroutines.p):boolean");
    }

    private final boolean f(p<? super u> pVar) {
        Object A = pVar.A(u.a, null, this.b);
        if (A == null) {
            return false;
        }
        pVar.F(A);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x006e, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean g() {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.e.g():boolean");
    }

    @Override // kotlinx.coroutines.sync.d
    public Object a(Continuation<? super u> continuation) {
        Object coroutine_suspended;
        if (f8839g.getAndDecrement(this) > 0) {
            return u.a;
        }
        Object d2 = d(continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return d2 == coroutine_suspended ? d2 : u.a;
    }

    @Override // kotlinx.coroutines.sync.d
    public void release() {
        while (true) {
            int i2 = this._availablePermits;
            int i3 = this.a;
            if (i2 < i3) {
                if (f8839g.compareAndSet(this, i2, i2 + 1) && (i2 >= 0 || g())) {
                    return;
                }
            } else {
                throw new IllegalStateException(kotlin.jvm.internal.s.q("The number of released permits cannot be greater than ", Integer.valueOf(i3)).toString());
            }
        }
    }
}
