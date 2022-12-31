package us.pinguo.common.filter.guide;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.m0;
/* compiled from: FilterGuideView.kt */
@DebugMetadata(c = "us.pinguo.common.filter.guide.FilterGuideView$doAnimation$1$1$1$1$1", f = "FilterGuideView.kt", i = {}, l = {212}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class FilterGuideView$doAnimation$1$1$1$1$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ ImageView $bubbleView;
    final /* synthetic */ FrameLayout $flContainer;
    final /* synthetic */ ImageView $starView;
    final /* synthetic */ View $view;
    int label;
    final /* synthetic */ FilterGuideView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterGuideView$doAnimation$1$1$1$1$1(FilterGuideView filterGuideView, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, View view, Continuation<? super FilterGuideView$doAnimation$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = filterGuideView;
        this.$flContainer = frameLayout;
        this.$bubbleView = imageView;
        this.$starView = imageView2;
        this.$view = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new FilterGuideView$doAnimation$1$1$1$1$1(this.this$0, this.$flContainer, this.$bubbleView, this.$starView, this.$view, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((FilterGuideView$doAnimation$1$1$1$1$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            this.label = 1;
            if (DelayKt.b(1500L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j.b(obj);
        }
        this.this$0.i(this.$flContainer, this.$bubbleView, this.$starView, this.$view);
        this.this$0.h(this.$view, this.$flContainer);
        return u.a;
    }
}
