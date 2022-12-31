package us.pinguo.edit2020.view.menuview;

import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.edit2020.bean.i;
/* compiled from: BeautySkinRefreshViewNew.kt */
/* loaded from: classes4.dex */
final class BeautySkinRefreshViewNew$show$1 extends Lambda implements p<Integer, i, u> {
    final /* synthetic */ BeautySkinRefreshViewNew this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautySkinRefreshViewNew$show$1(BeautySkinRefreshViewNew beautySkinRefreshViewNew) {
        super(2);
        this.this$0 = beautySkinRefreshViewNew;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ u invoke(Integer num, i iVar) {
        invoke(num.intValue(), iVar);
        return u.a;
    }

    public final void invoke(int i2, i data) {
        s.h(data, "data");
        if (i2 == -2) {
            l<i, u> g2 = this.this$0.g();
            if (g2 == null) {
                return;
            }
            g2.invoke(null);
            return;
        }
        l<i, u> g3 = this.this$0.g();
        if (g3 == null) {
            return;
        }
        g3.invoke(data);
    }
}
