package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
/* compiled from: CoroutineScope.kt */
/* loaded from: classes3.dex */
public final class n1 implements m0 {
    public static final n1 a = new n1();

    private n1() {
    }

    @Override // kotlinx.coroutines.m0
    public CoroutineContext getCoroutineContext() {
        return EmptyCoroutineContext.INSTANCE;
    }
}
