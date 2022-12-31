package kotlinx.coroutines.selects;

import kotlin.coroutines.Continuation;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
/* compiled from: SelectUnbiased.kt */
/* loaded from: classes3.dex */
final class UnbiasedSelectBuilderImpl$onTimeout$1 extends Lambda implements kotlin.jvm.b.a<u> {
    final /* synthetic */ l<Continuation<? super R>, Object> $block;
    final /* synthetic */ long $timeMillis;
    final /* synthetic */ i<R> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    UnbiasedSelectBuilderImpl$onTimeout$1(i<? super R> iVar, long j2, l<? super Continuation<? super R>, ? extends Object> lVar) {
        super(0);
        this.$timeMillis = j2;
        this.$block = lVar;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ u invoke() {
        invoke2();
        return u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.a();
        throw null;
    }
}
