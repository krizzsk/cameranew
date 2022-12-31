package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Lambda;
/* compiled from: Migration.kt */
/* loaded from: classes3.dex */
final class FlowKt__MigrationKt$onErrorReturn$1 extends Lambda implements kotlin.jvm.b.l<Throwable, Boolean> {
    public static final FlowKt__MigrationKt$onErrorReturn$1 INSTANCE = new FlowKt__MigrationKt$onErrorReturn$1();

    FlowKt__MigrationKt$onErrorReturn$1() {
        super(1);
    }

    @Override // kotlin.jvm.b.l
    public final Boolean invoke(Throwable th) {
        return Boolean.TRUE;
    }
}
