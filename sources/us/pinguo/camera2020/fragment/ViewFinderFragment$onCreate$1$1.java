package us.pinguo.camera2020.fragment;

import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Lambda;
import us.pinguo.camera2020.viewmodel.CameraViewModel;
/* compiled from: ViewFinderFragment.kt */
/* loaded from: classes3.dex */
final class ViewFinderFragment$onCreate$1$1 extends Lambda implements kotlin.jvm.b.l<String, kotlin.u> {
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$onCreate$1$1(ViewFinderFragment viewFinderFragment) {
        super(1);
        this.this$0 = viewFinderFragment;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(String str) {
        invoke2(str);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        us.pinguo.camera2020.activity.y b = us.pinguo.camera2020.activity.y.b();
        FragmentActivity activity = this.this$0.getActivity();
        b.f(str, activity == null ? null : activity.getIntent());
        CameraViewModel cameraViewModel = this.this$0.f9174j;
        if (cameraViewModel != null) {
            cameraViewModel.cameraAttrUpToStat("preview_save");
            FragmentActivity activity2 = this.this$0.getActivity();
            if (activity2 == null) {
                return;
            }
            activity2.finish();
            return;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }
}
