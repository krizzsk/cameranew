package kotlinx.coroutines.channels;

import kotlin.jvm.internal.Lambda;
/* compiled from: Deprecated.kt */
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$consumesAll$1 extends Lambda implements kotlin.jvm.b.l<Throwable, kotlin.u> {
    final /* synthetic */ ReceiveChannel<?>[] $channels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$consumesAll$1(ReceiveChannel<?>[] receiveChannelArr) {
        super(1);
        this.$channels = receiveChannelArr;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
        invoke2(th);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        ReceiveChannel<?>[] receiveChannelArr = this.$channels;
        int length = receiveChannelArr.length;
        Throwable th2 = null;
        int i2 = 0;
        while (i2 < length) {
            ReceiveChannel<?> receiveChannel = receiveChannelArr[i2];
            i2++;
            try {
                i.b(receiveChannel, th);
            } catch (Throwable th3) {
                if (th2 == null) {
                    th2 = th3;
                } else {
                    kotlin.b.a(th2, th3);
                }
            }
        }
        if (th2 != null) {
            throw th2;
        }
    }
}
