package us.pinguo.edit2020.controller;

import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import us.pinguo.edit2020.view.ManualMattingView;
import us.pinguo.edit2020.viewmodel.module.BackgroundReplacementModule;
import us.pinguo.u3dengine.edit.BasicBrushMode;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundReplacementController.kt */
/* loaded from: classes4.dex */
public final class BackgroundReplacementController$createManualMattingView$1 extends Lambda implements kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.c0, kotlin.u> {
    final /* synthetic */ Ref$ObjectRef<ManualMattingView> $mmv;
    final /* synthetic */ BackgroundReplacementController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundReplacementController$createManualMattingView$1(BackgroundReplacementController backgroundReplacementController, Ref$ObjectRef<ManualMattingView> ref$ObjectRef) {
        super(2);
        this.this$0 = backgroundReplacementController;
        this.$mmv = ref$ObjectRef;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num, us.pinguo.edit2020.bean.c0 c0Var) {
        invoke(num.intValue(), c0Var);
        return kotlin.u.a;
    }

    public final void invoke(int i2, us.pinguo.edit2020.bean.c0 function) {
        boolean z;
        boolean z2;
        Boolean bool;
        Boolean bool2;
        kotlin.jvm.internal.s.h(function, "function");
        if (i2 == 0) {
            z = this.this$0.n;
            us.pinguo.common.log.a.c(kotlin.jvm.internal.s.q("isAutoEnabled===>", Boolean.valueOf(z)), new Object[0]);
            z2 = this.this$0.n;
            if (z2) {
                this.this$0.c.o0();
            }
            this.this$0.n = false;
        } else if (i2 == 1) {
            bool = this.this$0.q;
            Boolean bool3 = Boolean.TRUE;
            if (kotlin.jvm.internal.s.c(bool, bool3)) {
                bool2 = this.this$0.r;
                if (!kotlin.jvm.internal.s.c(bool3, bool2)) {
                    return;
                }
            }
            this.this$0.O0(function);
            float N = this.this$0.c.N(this.$mmv.element.k()) * this.this$0.B * 0.85f;
            this.this$0.f10286g.o(N);
            this.this$0.f10286g.n(N);
            this.this$0.f10285f.setSize(N);
        } else if (i2 != 2) {
            if (i2 != 3) {
                return;
            }
            this.this$0.n = true;
            this.this$0.c.r0();
        } else {
            this.this$0.c.v0(BasicBrushMode.Brush, Float.valueOf(this.this$0.c.N(function.h())), Float.valueOf(function.g() / 100.0f));
            BackgroundReplacementModule backgroundReplacementModule = this.this$0.c;
            ManualMattingView manualMattingView = this.this$0.s;
            kotlin.jvm.internal.s.e(manualMattingView);
            float N2 = backgroundReplacementModule.N(manualMattingView.k()) * this.this$0.B * 0.85f;
            this.this$0.f10286g.o(N2);
            this.this$0.f10286g.n(N2);
            this.this$0.f10285f.setSize(N2);
        }
    }
}
