package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.b0;
/* compiled from: Channel.kt */
/* loaded from: classes3.dex */
public interface ReceiveChannel<E> {

    /* compiled from: Channel.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void a(ReceiveChannel receiveChannel, CancellationException cancellationException, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i2 & 1) != 0) {
                cancellationException = null;
            }
            receiveChannel.a(cancellationException);
        }

        public static <E> E b(ReceiveChannel<? extends E> receiveChannel) {
            E e2 = (E) receiveChannel.y();
            if (h.j(e2)) {
                h.g(e2);
                return e2;
            }
            Throwable e3 = h.e(e2);
            if (e3 == null) {
                return null;
            }
            throw b0.k(e3);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static <E> java.lang.Object c(kotlinx.coroutines.channels.ReceiveChannel<? extends E> r4, kotlin.coroutines.Continuation<? super E> r5) {
            /*
                boolean r0 = r5 instanceof kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1
                if (r0 == 0) goto L13
                r0 = r5
                kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1 r0 = (kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1 r0 = new kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1
                r0.<init>(r5)
            L18:
                java.lang.Object r5 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L37
                if (r2 != r3) goto L2f
                kotlin.j.b(r5)
                kotlinx.coroutines.channels.h r5 = (kotlinx.coroutines.channels.h) r5
                java.lang.Object r4 = r5.l()
                goto L43
            L2f:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L37:
                kotlin.j.b(r5)
                r0.label = r3
                java.lang.Object r4 = r4.z(r0)
                if (r4 != r1) goto L43
                return r1
            L43:
                java.lang.Object r4 = kotlinx.coroutines.channels.h.f(r4)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.c(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    void a(CancellationException cancellationException);

    ChannelIterator<E> iterator();

    E poll();

    kotlinx.coroutines.selects.d<E> r();

    kotlinx.coroutines.selects.d<h<E>> s();

    Object y();

    Object z(Continuation<? super h<? extends E>> continuation);
}
