package us.pinguo.edit2020.fragment;

import androidx.fragment.app.FragmentManager;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tencent.matrix.report.Issue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.edit2020.widget.dialog.CircleProgressWithResultDialog;
/* compiled from: StickerStoreDetailFragment.kt */
@DebugMetadata(c = "us.pinguo.edit2020.fragment.StickerStoreDetailFragment$initObserver$2", f = "StickerStoreDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class StickerStoreDetailFragment$initObserver$2 extends SuspendLambda implements kotlin.jvm.b.p<Integer, Continuation<? super kotlin.u>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ StickerStoreDetailFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerStoreDetailFragment$initObserver$2(StickerStoreDetailFragment stickerStoreDetailFragment, Continuation<? super StickerStoreDetailFragment$initObserver$2> continuation) {
        super(2, continuation);
        this.this$0 = stickerStoreDetailFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        StickerStoreDetailFragment$initObserver$2 stickerStoreDetailFragment$initObserver$2 = new StickerStoreDetailFragment$initObserver$2(this.this$0, continuation);
        stickerStoreDetailFragment$initObserver$2.I$0 = ((Number) obj).intValue();
        return stickerStoreDetailFragment$initObserver$2;
    }

    public final Object invoke(int i2, Continuation<? super kotlin.u> continuation) {
        return ((StickerStoreDetailFragment$initObserver$2) create(Integer.valueOf(i2), continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super kotlin.u> continuation) {
        return invoke(num.intValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            int i2 = this.I$0;
            if (this.this$0.p0() == null) {
                StickerStoreDetailFragment stickerStoreDetailFragment = this.this$0;
                CircleProgressWithResultDialog circleProgressWithResultDialog = new CircleProgressWithResultDialog();
                StickerStoreDetailFragment stickerStoreDetailFragment2 = this.this$0;
                circleProgressWithResultDialog.m0(new StickerStoreDetailFragment$initObserver$2$1$1(stickerStoreDetailFragment2));
                circleProgressWithResultDialog.l0(new StickerStoreDetailFragment$initObserver$2$1$2(stickerStoreDetailFragment2));
                FragmentManager childFragmentManager = stickerStoreDetailFragment2.getChildFragmentManager();
                circleProgressWithResultDialog.show(childFragmentManager, Issue.ISSUE_REPORT_TAG);
                VdsAgent.showDialogFragment(circleProgressWithResultDialog, childFragmentManager, Issue.ISSUE_REPORT_TAG);
                if (i2 < 0) {
                    circleProgressWithResultDialog.j0(i2);
                }
                stickerStoreDetailFragment.A0(circleProgressWithResultDialog);
            } else if (this.this$0.q0() == i2) {
                return kotlin.u.a;
            } else {
                this.this$0.B0(i2);
                CircleProgressWithResultDialog p0 = this.this$0.p0();
                if (p0 != null) {
                    p0.j0(i2);
                }
            }
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
