package us.pinguo.edit2020.view.menuview;

import android.content.Context;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.edit2020.bean.n0;
import us.pinguo.edit2020.widget.CenterLayoutManager;
/* compiled from: BeautySkinRefreshView.kt */
/* loaded from: classes4.dex */
final class BeautySkinRefreshView$showManualData$1 extends Lambda implements p<Integer, n0, u> {
    final /* synthetic */ BeautySkinRefreshView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautySkinRefreshView$showManualData$1(BeautySkinRefreshView beautySkinRefreshView) {
        super(2);
        this.this$0 = beautySkinRefreshView;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ u invoke(Integer num, n0 n0Var) {
        invoke(num.intValue(), n0Var);
        return u.a;
    }

    public final void invoke(int i2, n0 data) {
        s.h(data, "data");
        if (i2 == -2) {
            l<n0, u> k2 = this.this$0.k();
            if (k2 == null) {
                return;
            }
            k2.invoke(null);
            return;
        }
        CenterLayoutManager h2 = this.this$0.h();
        Context context = this.this$0.getContext();
        s.g(context, "context");
        h2.b(context, i2, 100.0f);
        l<n0, u> k3 = this.this$0.k();
        if (k3 == null) {
            return;
        }
        k3.invoke(data);
    }
}
