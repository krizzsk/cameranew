package us.pinguo.edit2020.view.loading;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
/* compiled from: BgReplacementLoadingView.kt */
@DebugMetadata(c = "us.pinguo.edit2020.view.loading.BgReplacementLoadingView$showProgressAnim$1$1$1", f = "BgReplacementLoadingView.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class BgReplacementLoadingView$showProgressAnim$1$1$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BgReplacementLoadingView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BgReplacementLoadingView$showProgressAnim$1$1$1(BgReplacementLoadingView bgReplacementLoadingView, Continuation<? super BgReplacementLoadingView$showProgressAnim$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = bgReplacementLoadingView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        BgReplacementLoadingView$showProgressAnim$1$1$1 bgReplacementLoadingView$showProgressAnim$1$1$1 = new BgReplacementLoadingView$showProgressAnim$1$1$1(this.this$0, continuation);
        bgReplacementLoadingView$showProgressAnim$1$1$1.L$0 = obj;
        return bgReplacementLoadingView$showProgressAnim$1$1$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((BgReplacementLoadingView$showProgressAnim$1$1$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object v;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            if (n0.d((m0) this.L$0)) {
                BgReplacementLoadingView bgReplacementLoadingView = this.this$0;
                this.label = 1;
                v = bgReplacementLoadingView.v(this);
                if (v == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j.b(obj);
        }
        return u.a;
    }
}
