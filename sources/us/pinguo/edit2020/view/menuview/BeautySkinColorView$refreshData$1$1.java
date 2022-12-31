package us.pinguo.edit2020.view.menuview;

import android.content.Context;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.edit2020.adapter.o0;
import us.pinguo.edit2020.bean.m0;
import us.pinguo.edit2020.widget.CenterLayoutManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BeautySkinColorView.kt */
/* loaded from: classes4.dex */
public final class BeautySkinColorView$refreshData$1$1 extends Lambda implements p<m0, Integer, u> {
    final /* synthetic */ o0 $this_with;
    final /* synthetic */ BeautySkinColorView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautySkinColorView$refreshData$1$1(BeautySkinColorView beautySkinColorView, o0 o0Var) {
        super(2);
        this.this$0 = beautySkinColorView;
        this.$this_with = o0Var;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ u invoke(m0 m0Var, Integer num) {
        invoke(m0Var, num.intValue());
        return u.a;
    }

    public final void invoke(m0 function, int i2) {
        CenterLayoutManager centerLayoutManager;
        s.h(function, "function");
        centerLayoutManager = this.this$0.f10790d;
        if (centerLayoutManager != null) {
            Context context = this.this$0.getContext();
            s.g(context, "context");
            centerLayoutManager.b(context, i2, 100.0f);
            this.$this_with.o(i2);
            l<m0, u> c = this.this$0.c();
            if (c == null) {
                return;
            }
            c.invoke(function);
            return;
        }
        s.z("layoutManager");
        throw null;
    }
}
