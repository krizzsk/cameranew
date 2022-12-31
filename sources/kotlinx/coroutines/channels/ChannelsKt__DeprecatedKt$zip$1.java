package kotlinx.coroutines.channels;

import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
/* compiled from: Deprecated.kt */
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$zip$1 extends Lambda implements kotlin.jvm.b.p<E, R, Pair<? extends E, ? extends R>> {
    public static final ChannelsKt__DeprecatedKt$zip$1 INSTANCE = new ChannelsKt__DeprecatedKt$zip$1();

    ChannelsKt__DeprecatedKt$zip$1() {
        super(2);
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((ChannelsKt__DeprecatedKt$zip$1) obj, obj2);
    }

    @Override // kotlin.jvm.b.p
    public final Pair<E, R> invoke(E e2, R r) {
        return kotlin.k.a(e2, r);
    }
}
