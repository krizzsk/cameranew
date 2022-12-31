package us.pinguo.edit2020.fragment;

import androidx.constraintlayout.widget.Group;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.common.widget.FragmentLoadingView;
import us.pinguo.edit2020.R;
/* compiled from: EditFragment.kt */
@DebugMetadata(c = "us.pinguo.edit2020.fragment.EditFragment$observeFilterRenderStatus$1$renderFinish$1", f = "EditFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class EditFragment$observeFilterRenderStatus$1$renderFinish$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    int label;
    final /* synthetic */ EditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFragment$observeFilterRenderStatus$1$renderFinish$1(EditFragment editFragment, Continuation<? super EditFragment$observeFilterRenderStatus$1$renderFinish$1> continuation) {
        super(2, continuation);
        this.this$0 = editFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new EditFragment$observeFilterRenderStatus$1$renderFinish$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((EditFragment$observeFilterRenderStatus$1$renderFinish$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            EditFragment editFragment = this.this$0;
            int i2 = R.id.loadingView;
            ((FragmentLoadingView) editFragment._$_findCachedViewById(i2)).e(false);
            ((FragmentLoadingView) this.this$0._$_findCachedViewById(i2)).b();
            Group loadingGroup = (Group) this.this$0._$_findCachedViewById(R.id.loadingGroup);
            kotlin.jvm.internal.s.g(loadingGroup, "loadingGroup");
            loadingGroup.setVisibility(8);
            VdsAgent.onSetViewVisibility(loadingGroup, 8);
            this.this$0.v = false;
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
