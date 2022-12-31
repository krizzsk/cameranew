package kotlinx.coroutines.channels;
/* compiled from: Channel.kt */
/* loaded from: classes3.dex */
public final class g {
    public static final <E> e<E> a(int i2, BufferOverflow bufferOverflow, kotlin.jvm.b.l<? super E, kotlin.u> lVar) {
        if (i2 == -2) {
            return new c(bufferOverflow == BufferOverflow.SUSPEND ? e.c0.a() : 1, bufferOverflow, lVar);
        } else if (i2 == -1) {
            if ((bufferOverflow != BufferOverflow.SUSPEND ? 0 : 1) != 0) {
                return new k(lVar);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        } else if (i2 == 0) {
            if (bufferOverflow == BufferOverflow.SUSPEND) {
                return new q(lVar);
            }
            return new c(1, bufferOverflow, lVar);
        } else if (i2 != Integer.MAX_VALUE) {
            if (i2 == 1 && bufferOverflow == BufferOverflow.DROP_OLDEST) {
                return new k(lVar);
            }
            return new c(i2, bufferOverflow, lVar);
        } else {
            return new l(lVar);
        }
    }

    public static /* synthetic */ e b(int i2, BufferOverflow bufferOverflow, kotlin.jvm.b.l lVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i3 & 4) != 0) {
            lVar = null;
        }
        return a(i2, bufferOverflow, lVar);
    }
}
