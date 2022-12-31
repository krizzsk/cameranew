package androidx.room;

import android.os.Build;
import android.os.CancellationSignal;
import androidx.sqlite.db.SupportSQLiteCompat;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.v1;
/* compiled from: CoroutinesRoom.kt */
/* loaded from: classes.dex */
final class CoroutinesRoom$Companion$execute$4$1 extends Lambda implements kotlin.jvm.b.l<Throwable, kotlin.u> {
    final /* synthetic */ CancellationSignal $cancellationSignal;
    final /* synthetic */ v1 $job;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesRoom$Companion$execute$4$1(CancellationSignal cancellationSignal, v1 v1Var) {
        super(1);
        this.$cancellationSignal = cancellationSignal;
        this.$job = v1Var;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
        invoke2(th);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        if (Build.VERSION.SDK_INT >= 16) {
            SupportSQLiteCompat.Api16Impl.cancel(this.$cancellationSignal);
        }
        v1.a.a(this.$job, null, 1, null);
    }
}
