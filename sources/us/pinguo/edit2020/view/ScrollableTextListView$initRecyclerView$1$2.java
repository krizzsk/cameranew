package us.pinguo.edit2020.view;

import android.content.Context;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.widget.CenterLayoutManager;
/* compiled from: ScrollableTextListView.kt */
/* loaded from: classes4.dex */
final class ScrollableTextListView$initRecyclerView$1$2 extends Lambda implements kotlin.jvm.b.p<f0, Integer, kotlin.u> {
    final /* synthetic */ CenterLayoutManager $centerLayoutManager;
    final /* synthetic */ Context $context;
    final /* synthetic */ ScrollableTextListView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollableTextListView$initRecyclerView$1$2(CenterLayoutManager centerLayoutManager, Context context, ScrollableTextListView scrollableTextListView) {
        super(2);
        this.$centerLayoutManager = centerLayoutManager;
        this.$context = context;
        this.this$0 = scrollableTextListView;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ kotlin.u invoke(f0 f0Var, Integer num) {
        invoke(f0Var, num.intValue());
        return kotlin.u.a;
    }

    public final void invoke(f0 iScrollText, int i2) {
        kotlin.jvm.internal.s.h(iScrollText, "iScrollText");
        this.$centerLayoutManager.b(this.$context, i2, 300.0f);
        kotlin.jvm.b.l<f0, kotlin.u> a = this.this$0.a();
        if (a == null) {
            return;
        }
        a.invoke(iScrollText);
    }
}
