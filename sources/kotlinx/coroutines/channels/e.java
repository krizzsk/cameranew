package kotlinx.coroutines.channels;

import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.internal.d0;
/* compiled from: Channel.kt */
/* loaded from: classes3.dex */
public interface e<E> extends s<E>, ReceiveChannel<E> {
    public static final b c0 = b.a;

    /* compiled from: Channel.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public static <E> E a(e<E> eVar) {
            return (E) ReceiveChannel.DefaultImpls.b(eVar);
        }
    }

    /* compiled from: Channel.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        static final /* synthetic */ b a = new b();
        private static final int b = d0.b("kotlinx.coroutines.channels.defaultBuffer", 64, 1, us.pinguo.user.recycler.c.TYPE_EMPTY);

        private b() {
        }

        public final int a() {
            return b;
        }
    }
}
