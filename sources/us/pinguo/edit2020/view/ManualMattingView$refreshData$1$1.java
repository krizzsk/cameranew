package us.pinguo.edit2020.view;

import java.util.ArrayList;
import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ManualMattingView.kt */
/* loaded from: classes4.dex */
public final class ManualMattingView$refreshData$1$1 extends Lambda implements kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.c0, kotlin.u> {
    final /* synthetic */ ArrayList<us.pinguo.edit2020.bean.c0> $dataList;
    final /* synthetic */ ManualMattingView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManualMattingView$refreshData$1$1(ArrayList<us.pinguo.edit2020.bean.c0> arrayList, ManualMattingView manualMattingView) {
        super(2);
        this.$dataList = arrayList;
        this.this$0 = manualMattingView;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num, us.pinguo.edit2020.bean.c0 c0Var) {
        invoke(num.intValue(), c0Var);
        return kotlin.u.a;
    }

    public final void invoke(int i2, us.pinguo.edit2020.bean.c0 function) {
        int i3;
        kotlin.jvm.internal.s.h(function, "function");
        if (i2 != 0) {
            i3 = kotlin.collections.u.i(this.$dataList);
            if (i2 != i3) {
                this.this$0.y(function);
            }
        }
        kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.c0, kotlin.u> l2 = this.this$0.l();
        if (l2 == null) {
            return;
        }
        l2.invoke(Integer.valueOf(i2), function);
    }
}
