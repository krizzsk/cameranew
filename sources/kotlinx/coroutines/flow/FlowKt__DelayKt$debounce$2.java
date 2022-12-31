package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Lambda;
/* compiled from: Delay.kt */
/* loaded from: classes3.dex */
final class FlowKt__DelayKt$debounce$2 extends Lambda implements kotlin.jvm.b.l<T, Long> {
    final /* synthetic */ long $timeoutMillis;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$debounce$2(long j2) {
        super(1);
        this.$timeoutMillis = j2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.l
    public final Long invoke(T t) {
        return Long.valueOf(this.$timeoutMillis);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ Long invoke(Object obj) {
        return invoke((FlowKt__DelayKt$debounce$2) obj);
    }
}
