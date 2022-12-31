package us.pinguo.camera2020.fragment;

import kotlin.jvm.internal.Lambda;
import us.pinguo.camera2020.viewmodel.CameraViewModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewFinderFragment.kt */
/* loaded from: classes3.dex */
public final class ViewFinderFragment$initNewFilter$4 extends Lambda implements kotlin.jvm.b.s<String, Float, Float, Float, Float, kotlin.u> {
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$initNewFilter$4(ViewFinderFragment viewFinderFragment) {
        super(5);
        this.this$0 = viewFinderFragment;
    }

    @Override // kotlin.jvm.b.s
    public /* bridge */ /* synthetic */ kotlin.u invoke(String str, Float f2, Float f3, Float f4, Float f5) {
        invoke(str, f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue());
        return kotlin.u.a;
    }

    public final void invoke(String noName_0, float f2, float f3, float f4, float f5) {
        kotlin.jvm.internal.s.h(noName_0, "$noName_0");
        CameraViewModel cameraViewModel = this.this$0.f9174j;
        if (cameraViewModel != null) {
            cameraViewModel.getAfterCaptureModule().r().postValue(Boolean.FALSE);
            this.this$0.r4();
            return;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }
}
