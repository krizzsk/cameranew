package androidx.room;

import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.v1;
/* compiled from: RoomDatabase.kt */
/* loaded from: classes.dex */
final class RoomDatabaseKt$acquireTransactionThread$2$1 extends Lambda implements kotlin.jvm.b.l<Throwable, kotlin.u> {
    final /* synthetic */ v1 $controlJob;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomDatabaseKt$acquireTransactionThread$2$1(v1 v1Var) {
        super(1);
        this.$controlJob = v1Var;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
        invoke2(th);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        v1.a.a(this.$controlJob, null, 1, null);
    }
}
