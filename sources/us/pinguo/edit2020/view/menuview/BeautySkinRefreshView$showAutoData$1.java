package us.pinguo.edit2020.view.menuview;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.n0;
import us.pinguo.edit2020.widget.CenterLayoutManager;
import us.pinguo.foundation.ui.c;
/* compiled from: BeautySkinRefreshView.kt */
/* loaded from: classes4.dex */
final class BeautySkinRefreshView$showAutoData$1 extends Lambda implements p<Integer, n0, u> {
    final /* synthetic */ BeautySkinRefreshView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautySkinRefreshView$showAutoData$1(BeautySkinRefreshView beautySkinRefreshView) {
        super(2);
        this.this$0 = beautySkinRefreshView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m103invoke$lambda0(BeautySkinRefreshView this$0, int i2) {
        s.h(this$0, "this$0");
        CenterLayoutManager h2 = this$0.h();
        Context context = this$0.getContext();
        s.g(context, "context");
        h2.b(context, i2, 100.0f);
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ u invoke(Integer num, n0 n0Var) {
        invoke(num.intValue(), n0Var);
        return u.a;
    }

    public final void invoke(final int i2, n0 data) {
        s.h(data, "data");
        RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(R.id.recyclerView);
        s.g(recyclerView, "recyclerView");
        final BeautySkinRefreshView beautySkinRefreshView = this.this$0;
        c.c(recyclerView, new Runnable() { // from class: us.pinguo.edit2020.view.menuview.a
            @Override // java.lang.Runnable
            public final void run() {
                BeautySkinRefreshView$showAutoData$1.m103invoke$lambda0(BeautySkinRefreshView.this, i2);
            }
        }, false);
        l<n0, u> j2 = this.this$0.j();
        if (j2 == null) {
            return;
        }
        j2.invoke(data);
    }
}
