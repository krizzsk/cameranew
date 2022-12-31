package us.pinguo.camera2020.fragment;

import java.util.Map;
import kotlin.jvm.internal.Lambda;
import us.pinguo.camera2020.module.frame.FrameRatioModule;
import us.pinguo.camera2020.viewmodel.CameraViewModel;
import us.pinguo.cameramanger.info.CameraFrame;
import us.pinguo.common.filter.controller.FilterController;
/* compiled from: ViewFinderFragment.kt */
/* loaded from: classes3.dex */
final class ViewFinderFragment$onViewCreated$23 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ FrameRatioModule $frameModule;
    final /* synthetic */ CameraViewModel $viewModel;
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$onViewCreated$23(ViewFinderFragment viewFinderFragment, FrameRatioModule frameRatioModule, CameraViewModel cameraViewModel) {
        super(0);
        this.this$0 = viewFinderFragment;
        this.$frameModule = frameRatioModule;
        this.$viewModel = cameraViewModel;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FilterController filterController = this.this$0.u;
        if (filterController == null) {
            return;
        }
        us.pinguo.camera2020.module.frame.a aVar = null;
        FilterController.n0(filterController, false, 1, null);
        us.pinguo.foundation.statistics.h.b.X();
        us.pinguo.camera2020.module.frame.a g2 = this.$frameModule.g();
        if (g2 == null) {
            Map<CameraFrame, us.pinguo.camera2020.module.frame.a> f2 = this.$frameModule.f();
            if (f2 != null) {
                aVar = f2.get(this.$viewModel.getFrameRatioModule().d().getValue());
            }
        } else {
            aVar = g2;
        }
        FrameRatioModule frameRatioModule = this.$frameModule;
        if (aVar == null) {
            return;
        }
        frameRatioModule.k(aVar);
        this.this$0.r4();
    }
}
