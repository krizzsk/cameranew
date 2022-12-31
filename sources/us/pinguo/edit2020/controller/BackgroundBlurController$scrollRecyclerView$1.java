package us.pinguo.edit2020.controller;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* compiled from: BackgroundBlurController.kt */
@DebugMetadata(c = "us.pinguo.edit2020.controller.BackgroundBlurController$scrollRecyclerView$1", f = "BackgroundBlurController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class BackgroundBlurController$scrollRecyclerView$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ int $currentBlurMaterialIndex;
    final /* synthetic */ RecyclerView $recyclerView;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundBlurController$scrollRecyclerView$1(RecyclerView recyclerView, int i2, Continuation<? super BackgroundBlurController$scrollRecyclerView$1> continuation) {
        super(2, continuation);
        this.$recyclerView = recyclerView;
        this.$currentBlurMaterialIndex = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new BackgroundBlurController$scrollRecyclerView$1(this.$recyclerView, this.$currentBlurMaterialIndex, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((BackgroundBlurController$scrollRecyclerView$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            RecyclerView.LayoutManager layoutManager = this.$recyclerView.getLayoutManager();
            Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(this.$currentBlurMaterialIndex, us.pinguo.foundation.utils.n0.i() / 2);
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
