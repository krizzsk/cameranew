package us.pinguo.camera2020.fragment;

import java.util.ArrayList;
import kotlin.jvm.internal.Lambda;
import us.pinguo.camera2020.viewmodel.CameraViewModel;
/* compiled from: ViewFinderFragment.kt */
/* loaded from: classes3.dex */
final class ViewFinderFragment$onViewCreated$22 extends Lambda implements kotlin.jvm.b.a<ArrayList<String>> {
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$onViewCreated$22(ViewFinderFragment viewFinderFragment) {
        super(0);
        this.this$0 = viewFinderFragment;
    }

    @Override // kotlin.jvm.b.a
    public final ArrayList<String> invoke() {
        CameraViewModel cameraViewModel = this.this$0.f9174j;
        if (cameraViewModel != null) {
            return cameraViewModel.cameraAttrToSubscription();
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }
}
