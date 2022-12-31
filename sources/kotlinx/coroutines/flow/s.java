package kotlinx.coroutines.flow;

import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.k;
/* compiled from: Context.kt */
/* loaded from: classes3.dex */
public final /* synthetic */ class s {
    public static final <T> c<T> a(c<? extends T> cVar, int i2, BufferOverflow bufferOverflow) {
        int i3;
        BufferOverflow bufferOverflow2;
        boolean z = true;
        if (i2 >= 0 || i2 == -2 || i2 == -1) {
            if (i2 == -1 && bufferOverflow != BufferOverflow.SUSPEND) {
                z = false;
            }
            if (z) {
                if (i2 == -1) {
                    bufferOverflow2 = BufferOverflow.DROP_OLDEST;
                    i3 = 0;
                } else {
                    i3 = i2;
                    bufferOverflow2 = bufferOverflow;
                }
                return cVar instanceof kotlinx.coroutines.flow.internal.k ? k.a.a((kotlinx.coroutines.flow.internal.k) cVar, null, i3, bufferOverflow2, 1, null) : new kotlinx.coroutines.flow.internal.f(cVar, null, i3, bufferOverflow2, 2, null);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        throw new IllegalArgumentException(kotlin.jvm.internal.s.q("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was ", Integer.valueOf(i2)).toString());
    }

    public static /* synthetic */ c b(c cVar, int i2, BufferOverflow bufferOverflow, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = -2;
        }
        if ((i3 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return e.a(cVar, i2, bufferOverflow);
    }
}
