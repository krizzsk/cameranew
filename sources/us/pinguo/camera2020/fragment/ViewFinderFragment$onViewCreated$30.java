package us.pinguo.camera2020.fragment;

import kotlin.jvm.internal.Lambda;
import us.pinguo.camera2020.module.AfterCaptureModule;
/* compiled from: ViewFinderFragment.kt */
/* loaded from: classes3.dex */
final class ViewFinderFragment$onViewCreated$30 extends Lambda implements kotlin.jvm.b.l<Integer, kotlin.u> {
    final /* synthetic */ AfterCaptureModule $afterCapture;
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$onViewCreated$30(AfterCaptureModule afterCaptureModule, ViewFinderFragment viewFinderFragment) {
        super(1);
        this.$afterCapture = afterCaptureModule;
        this.this$0 = viewFinderFragment;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num) {
        invoke(num.intValue());
        return kotlin.u.a;
    }

    public final void invoke(int i2) {
        String l2 = this.$afterCapture.l();
        if (l2 == null) {
            return;
        }
        this.this$0.R1(l2, i2);
    }
}
