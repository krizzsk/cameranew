package kotlinx.coroutines.channels;

import kotlin.jvm.internal.Lambda;
/* compiled from: Broadcast.kt */
/* loaded from: classes3.dex */
final class BroadcastKt$broadcast$1 extends Lambda implements kotlin.jvm.b.l<Throwable, kotlin.u> {
    final /* synthetic */ ReceiveChannel<E> $this_broadcast;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BroadcastKt$broadcast$1(ReceiveChannel<? extends E> receiveChannel) {
        super(1);
        this.$this_broadcast = receiveChannel;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
        invoke2(th);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        i.b(this.$this_broadcast, th);
    }
}
