package us.pinguo.camera2020.fragment;

import kotlin.jvm.internal.Lambda;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.widget.ShutterActionView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewFinderFragment.kt */
/* loaded from: classes3.dex */
public final class ViewFinderFragment$handleShutterClick$2 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$handleShutterClick$2(ViewFinderFragment viewFinderFragment) {
        super(0);
        this.this$0 = viewFinderFragment;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (((ShutterActionView) this.this$0._$_findCachedViewById(R.id.shutterAction)) == null) {
            return;
        }
        ViewFinderFragment viewFinderFragment = this.this$0;
        viewFinderFragment.d4();
        viewFinderFragment.W1();
    }
}
