package us.pinguo.camera2020.fragment;

import android.view.View;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.internal.Lambda;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.view.StickerViewController;
import us.pinguo.repository2020.database.sticker.StickerCategory;
/* compiled from: ViewFinderFragment.kt */
/* loaded from: classes3.dex */
final class ViewFinderFragment$onViewCreated$15 extends Lambda implements kotlin.jvm.b.l<View, kotlin.u> {
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$onViewCreated$15(ViewFinderFragment viewFinderFragment) {
        super(1);
        this.this$0 = viewFinderFragment;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(View view) {
        invoke2(view);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(View it) {
        StickerViewController stickerViewController;
        String topic_id;
        kotlin.jvm.internal.s.h(it, "it");
        if (us.pinguo.foundation.utils.j.a(1000L)) {
            return;
        }
        us.pinguo.foundation.statistics.h.a.J();
        this.this$0.s4(false);
        stickerViewController = this.this$0.f9173i;
        if (stickerViewController != null) {
            us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
            StickerCategory o = stickerViewController.o();
            String str = "recent_";
            if (o != null && (topic_id = o.getTopic_id()) != null) {
                str = topic_id;
            }
            iVar.I(str, "show");
        }
        View viewRedDot = this.this$0._$_findCachedViewById(R.id.viewRedDot);
        kotlin.jvm.internal.s.g(viewRedDot, "viewRedDot");
        viewRedDot.setVisibility(8);
        VdsAgent.onSetViewVisibility(viewRedDot, 8);
    }
}
