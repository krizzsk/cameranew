package us.pinguo.camera2020.fragment;

import kotlin.jvm.internal.Lambda;
import us.pinguo.camera2020.R;
import us.pinguo.common.manager.AdvDialogManager;
import us.pinguo.common.widget.ColorAnimDraweeView;
/* compiled from: ViewFinderFragment.kt */
/* loaded from: classes3.dex */
final class ViewFinderFragment$onViewCreated$10 extends Lambda implements kotlin.jvm.b.l<Boolean, kotlin.u> {
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$onViewCreated$10(ViewFinderFragment viewFinderFragment) {
        super(1);
        this.this$0 = viewFinderFragment;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return kotlin.u.a;
    }

    public final void invoke(boolean z) {
        AdvDialogManager advDialogManager;
        AdvDialogManager advDialogManager2;
        ColorAnimDraweeView colorAnimDraweeView = (ColorAnimDraweeView) this.this$0._$_findCachedViewById(R.id.previewAdvGoto);
        if (colorAnimDraweeView == null) {
            return;
        }
        ViewFinderFragment viewFinderFragment = this.this$0;
        if (!z) {
            advDialogManager2 = viewFinderFragment.S;
            if (advDialogManager2 == null) {
                return;
            }
            advDialogManager2.d(colorAnimDraweeView);
            return;
        }
        advDialogManager = viewFinderFragment.S;
        if (advDialogManager == null) {
            return;
        }
        advDialogManager.f(colorAnimDraweeView);
    }
}
