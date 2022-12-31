package kotlinx.coroutines.selects;

import kotlin.coroutines.Continuation;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
/* compiled from: SelectUnbiased.kt */
/* loaded from: classes3.dex */
final class UnbiasedSelectBuilderImpl$invoke$3 extends Lambda implements kotlin.jvm.b.a<u> {
    final /* synthetic */ p<Q, Continuation<? super R>, Object> $block;
    final /* synthetic */ P $param;
    final /* synthetic */ e<P, Q> $this_invoke;
    final /* synthetic */ i<R> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    UnbiasedSelectBuilderImpl$invoke$3(e<? super P, ? extends Q> eVar, i<? super R> iVar, P p, p<? super Q, ? super Continuation<? super R>, ? extends Object> pVar) {
        super(0);
        this.$this_invoke = eVar;
        this.$param = p;
        this.$block = pVar;
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
