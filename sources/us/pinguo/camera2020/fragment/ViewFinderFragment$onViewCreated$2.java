package us.pinguo.camera2020.fragment;

import android.os.Bundle;
import android.view.View;
import kotlin.jvm.internal.Lambda;
import us.pinguo.camera2020.viewmodel.CameraViewModel;
/* compiled from: ViewFinderFragment.kt */
/* loaded from: classes3.dex */
final class ViewFinderFragment$onViewCreated$2 extends Lambda implements kotlin.jvm.b.l<View, kotlin.u> {
    final /* synthetic */ CameraViewModel $viewModel;
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$onViewCreated$2(ViewFinderFragment viewFinderFragment, CameraViewModel cameraViewModel) {
        super(1);
        this.this$0 = viewFinderFragment;
        this.$viewModel = cameraViewModel;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(View view) {
        invoke2(view);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(View it) {
        boolean B4;
        kotlin.jvm.internal.s.h(it, "it");
        Bundle bundle = new Bundle();
        CameraViewModel cameraViewModel = this.this$0.f9174j;
        if (cameraViewModel != null) {
            bundle.putStringArrayList("camera_stat_attr_subscription", cameraViewModel.cameraAttrToSubscription());
            us.pinguo.camera2020.i.a aVar = us.pinguo.camera2020.i.a.a;
            if (aVar.h()) {
                B4 = this.this$0.B4();
                if (B4) {
                    this.this$0.u4();
                    return;
                }
            }
            if (!us.pinguo.repository2020.abtest.i.a.b() && aVar.g(this.this$0.getContext(), bundle)) {
                CameraViewModel cameraViewModel2 = this.this$0.f9174j;
                if (cameraViewModel2 != null) {
                    cameraViewModel2.cameraAttrUpToStat("preview_edit");
                    return;
                } else {
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                }
            }
            this.$viewModel.getAfterCaptureModule().n();
            return;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }
}
