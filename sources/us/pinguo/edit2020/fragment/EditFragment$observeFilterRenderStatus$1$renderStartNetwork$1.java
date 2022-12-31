package us.pinguo.edit2020.fragment;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.common.widget.FragmentLoadingView;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.viewmodel.EditViewModel;
import us.pinguo.repository2020.entity.FilterEntry;
/* compiled from: EditFragment.kt */
@DebugMetadata(c = "us.pinguo.edit2020.fragment.EditFragment$observeFilterRenderStatus$1$renderStartNetwork$1", f = "EditFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class EditFragment$observeFilterRenderStatus$1$renderStartNetwork$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ boolean $isNetwork;
    int label;
    final /* synthetic */ EditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFragment$observeFilterRenderStatus$1$renderStartNetwork$1(boolean z, EditFragment editFragment, Continuation<? super EditFragment$observeFilterRenderStatus$1$renderStartNetwork$1> continuation) {
        super(2, continuation);
        this.$isNetwork = z;
        this.this$0 = editFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new EditFragment$observeFilterRenderStatus$1$renderStartNetwork$1(this.$isNetwork, this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((EditFragment$observeFilterRenderStatus$1$renderStartNetwork$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        EditViewModel j1;
        EditViewModel j12;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            if (this.$isNetwork) {
                EditFragment editFragment = this.this$0;
                int i2 = R.id.loadingView;
                ((FragmentLoadingView) editFragment._$_findCachedViewById(i2)).d(true);
                ((FragmentLoadingView) this.this$0._$_findCachedViewById(i2)).g();
                j1 = this.this$0.j1();
                FilterEntry value = j1.i().y().getValue();
                String pkgId = value == null ? null : value.getPkgId();
                if (pkgId != null) {
                    j12 = this.this$0.j1();
                    ((FragmentLoadingView) this.this$0._$_findCachedViewById(i2)).e(j12.i().U(pkgId));
                } else {
                    return kotlin.u.a;
                }
            }
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
