package us.pinguo.common.filter.view;

import android.content.Context;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.m0;
import us.pinguo.common.widget.ScrollCenterLayoutManager;
/* compiled from: FilterPanelItemView.kt */
@DebugMetadata(c = "us.pinguo.common.filter.view.FilterPanelItemView$onFilterItemClick$2", f = "FilterPanelItemView.kt", i = {}, l = {141}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class FilterPanelItemView$onFilterItemClick$2 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ Ref$ObjectRef<Integer> $itemPosition;
    final /* synthetic */ ScrollCenterLayoutManager $layoutManager;
    int label;
    final /* synthetic */ FilterPanelItemView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPanelItemView$onFilterItemClick$2(ScrollCenterLayoutManager scrollCenterLayoutManager, FilterPanelItemView filterPanelItemView, Ref$ObjectRef<Integer> ref$ObjectRef, Continuation<? super FilterPanelItemView$onFilterItemClick$2> continuation) {
        super(2, continuation);
        this.$layoutManager = scrollCenterLayoutManager;
        this.this$0 = filterPanelItemView;
        this.$itemPosition = ref$ObjectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new FilterPanelItemView$onFilterItemClick$2(this.$layoutManager, this.this$0, this.$itemPosition, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((FilterPanelItemView$onFilterItemClick$2) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            this.label = 1;
            if (DelayKt.b(30L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlin.j.b(obj);
        }
        ScrollCenterLayoutManager scrollCenterLayoutManager = this.$layoutManager;
        Context context = this.this$0.getContext();
        s.g(context, "context");
        scrollCenterLayoutManager.a(context, this.$itemPosition.element.intValue(), 150.0f);
        return u.a;
    }
}
