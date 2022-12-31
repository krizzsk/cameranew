package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.DelayKt;
/* compiled from: Delay.kt */
/* loaded from: classes3.dex */
final class FlowKt__DelayKt$debounce$3 extends Lambda implements kotlin.jvm.b.l<T, Long> {
    final /* synthetic */ kotlin.jvm.b.l<T, kotlin.time.a> $timeout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__DelayKt$debounce$3(kotlin.jvm.b.l<? super T, kotlin.time.a> lVar) {
        super(1);
        this.$timeout = lVar;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ Long invoke(Object obj) {
        return invoke((FlowKt__DelayKt$debounce$3) obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.l
    public final Long invoke(T t) {
        return Long.valueOf(DelayKt.d(this.$timeout.invoke(t).B()));
    }
}
