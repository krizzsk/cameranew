package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Lambda;
/* compiled from: Errors.kt */
/* loaded from: classes3.dex */
final class FlowKt__ErrorsKt$onErrorCollect$1 extends Lambda implements kotlin.jvm.b.l<Throwable, Boolean> {
    public static final FlowKt__ErrorsKt$onErrorCollect$1 INSTANCE = new FlowKt__ErrorsKt$onErrorCollect$1();

    FlowKt__ErrorsKt$onErrorCollect$1() {
        super(1);
    }

    @Override // kotlin.jvm.b.l
    public final Boolean invoke(Throwable th) {
        return Boolean.TRUE;
    }
}
