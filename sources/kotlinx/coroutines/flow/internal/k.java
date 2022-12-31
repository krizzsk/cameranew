package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
/* compiled from: ChannelFlow.kt */
/* loaded from: classes3.dex */
public interface k<T> extends kotlinx.coroutines.flow.c<T> {

    /* compiled from: ChannelFlow.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ kotlinx.coroutines.flow.c a(k kVar, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    coroutineContext = EmptyCoroutineContext.INSTANCE;
                }
                if ((i3 & 2) != 0) {
                    i2 = -3;
                }
                if ((i3 & 4) != 0) {
                    bufferOverflow = BufferOverflow.SUSPEND;
                }
                return kVar.b(coroutineContext, i2, bufferOverflow);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
        }
    }

    kotlinx.coroutines.flow.c<T> b(CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow);
}
