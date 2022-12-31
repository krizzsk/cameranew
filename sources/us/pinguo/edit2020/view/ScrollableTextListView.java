package us.pinguo.edit2020.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import us.pinguo.edit2020.widget.CenterLayoutManager;
/* compiled from: ScrollableTextListView.kt */
/* loaded from: classes4.dex */
public final class ScrollableTextListView extends FrameLayout {
    private final l0 a;
    private final RecyclerView b;
    private kotlin.jvm.b.l<? super f0, kotlin.u> c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ScrollableTextListView(Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ScrollableTextListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    public /* synthetic */ ScrollableTextListView(Context context, AttributeSet attributeSet, int i2, int i3, kotlin.jvm.internal.o oVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void c(Context context) {
        RecyclerView recyclerView = this.b;
        recyclerView.addItemDecoration(new o0());
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setAddDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
            itemAnimator.setChangeDuration(0L);
        }
        CenterLayoutManager centerLayoutManager = new CenterLayoutManager(context, 0, false);
        recyclerView.setLayoutManager(centerLayoutManager);
        recyclerView.setAdapter(this.a);
        this.a.m(new ScrollableTextListView$initRecyclerView$1$2(centerLayoutManager, context, this));
    }

    public final kotlin.jvm.b.l<f0, kotlin.u> a() {
        return this.c;
    }

    public final List<f0> b() {
        return this.a.g();
    }

    public final void d(List<? extends f0> list) {
        kotlin.jvm.internal.s.h(list, "list");
        this.a.e(list);
        this.a.l();
    }

    public final void e(int i2) {
        this.b.smoothScrollToPosition(i2);
    }

    public final void f(int i2) {
        this.a.n(i2);
        this.a.l();
    }

    public final void setOnTextClick(kotlin.jvm.b.l<? super f0, kotlin.u> lVar) {
        this.c = lVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollableTextListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.a = new l0(new ArrayList());
        RecyclerView recyclerView = new RecyclerView(context);
        this.b = recyclerView;
        c(context);
        addView(recyclerView, new FrameLayout.LayoutParams(-1, us.pinguo.common.widget.i.a.a(44)));
    }
}
