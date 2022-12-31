package kotlinx.coroutines.channels;

import kotlin.jvm.internal.Lambda;
/* compiled from: Deprecated.kt */
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$consumes$1 extends Lambda implements kotlin.jvm.b.l<Throwable, kotlin.u> {
    final /* synthetic */ ReceiveChannel<?> $this_consumes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$consumes$1(ReceiveChannel<?> receiveChannel) {
        super(1);
        this.$this_consumes = receiveChannel;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
        invoke2(th);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        i.b(this.$this_consumes, th);
    }
}
