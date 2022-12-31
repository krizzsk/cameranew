package us.pinguo.edit2020.view.menuview;

import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.edit2020.bean.h;
import us.pinguo.edit2020.view.menuview.BeautyMenuView;
/* compiled from: BeautyMenuView.kt */
/* loaded from: classes4.dex */
final class BeautyMenuView$refreshData$1 extends Lambda implements p<Integer, h, u> {
    final /* synthetic */ BeautyMenuView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautyMenuView$refreshData$1(BeautyMenuView beautyMenuView) {
        super(2);
        this.this$0 = beautyMenuView;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ u invoke(Integer num, h hVar) {
        invoke(num.intValue(), hVar);
        return u.a;
    }

    public final void invoke(int i2, h noName_1) {
        s.h(noName_1, "$noName_1");
        switch (i2) {
            case 0:
                BeautyMenuView.a g2 = this.this$0.g();
                if (g2 == null) {
                    return;
                }
                g2.b();
                return;
            case 1:
                BeautyMenuView.a g3 = this.this$0.g();
                if (g3 == null) {
                    return;
                }
                g3.g();
                return;
            case 2:
                BeautyMenuView.a g4 = this.this$0.g();
                if (g4 == null) {
                    return;
                }
                g4.d();
                return;
            case 3:
                BeautyMenuView.a g5 = this.this$0.g();
                if (g5 == null) {
                    return;
                }
                g5.f();
                return;
            case 4:
                BeautyMenuView.a g6 = this.this$0.g();
                if (g6 == null) {
                    return;
                }
                g6.c();
                return;
            case 5:
                BeautyMenuView.a g7 = this.this$0.g();
                if (g7 == null) {
                    return;
                }
                g7.e();
                return;
            case 6:
                BeautyMenuView.a g8 = this.this$0.g();
                if (g8 == null) {
                    return;
                }
                g8.a();
                return;
            default:
                return;
        }
    }
}
