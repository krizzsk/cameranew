package kotlinx.coroutines.debug.internal;

import kotlin.jvm.internal.Lambda;
import kotlin.u;
/* compiled from: DebugProbesImpl.kt */
/* loaded from: classes3.dex */
final class DebugProbesImpl$startWeakRefCleanerThread$1 extends Lambda implements kotlin.jvm.b.a<u> {
    public static final DebugProbesImpl$startWeakRefCleanerThread$1 INSTANCE = new DebugProbesImpl$startWeakRefCleanerThread$1();

    DebugProbesImpl$startWeakRefCleanerThread$1() {
        super(0);
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ u invoke() {
        invoke2();
        return u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ConcurrentWeakMap concurrentWeakMap;
        concurrentWeakMap = b.f8744d;
        concurrentWeakMap.j();
    }
}
