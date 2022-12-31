package kotlinx.coroutines.debug.internal;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.debug.internal.b;
/* compiled from: DebugProbesImpl.kt */
/* loaded from: classes3.dex */
final class DebugProbesImpl$dumpCoroutinesSynchronized$1$2 extends Lambda implements l<b.a<?>, Boolean> {
    public static final DebugProbesImpl$dumpCoroutinesSynchronized$1$2 INSTANCE = new DebugProbesImpl$dumpCoroutinesSynchronized$1$2();

    DebugProbesImpl$dumpCoroutinesSynchronized$1$2() {
        super(1);
    }

    @Override // kotlin.jvm.b.l
    public final Boolean invoke(b.a<?> aVar) {
        boolean e2;
        e2 = b.a.e(aVar);
        return Boolean.valueOf(!e2);
    }
}
