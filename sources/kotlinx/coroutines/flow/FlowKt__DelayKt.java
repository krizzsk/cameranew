package kotlinx.coroutines.flow;

import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
/* compiled from: Delay.kt */
/* loaded from: classes3.dex */
public final /* synthetic */ class FlowKt__DelayKt {
    public static final ReceiveChannel<kotlin.u> a(kotlinx.coroutines.m0 m0Var, long j2, long j3) {
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("Expected non-negative delay, but has " + j2 + " ms").toString());
        }
        if (j3 >= 0) {
            return ProduceKt.e(m0Var, null, 0, new FlowKt__DelayKt$fixedPeriodTicker$3(j3, j2, null), 1, null);
        }
        throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j3 + " ms").toString());
    }

    public static /* synthetic */ ReceiveChannel b(kotlinx.coroutines.m0 m0Var, long j2, long j3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j3 = j2;
        }
        return e.q(m0Var, j2, j3);
    }
}
