package us.pinguo.edit2020.controller;

import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import us.pinguo.edit2020.R;
import us.pinguo.ui.widget.StickySeekBar;
/* compiled from: AdjustController.kt */
/* loaded from: classes4.dex */
final class AdjustController$onOptionalColorSelected$7 extends Lambda implements kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.g0, kotlin.u> {
    final /* synthetic */ us.pinguo.edit2020.bean.f0 $function;
    final /* synthetic */ Ref$ObjectRef<ConstraintLayout> $layout;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdjustController$onOptionalColorSelected$7(us.pinguo.edit2020.bean.f0 f0Var, Ref$ObjectRef<ConstraintLayout> ref$ObjectRef) {
        super(2);
        this.$function = f0Var;
        this.$layout = ref$ObjectRef;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num, us.pinguo.edit2020.bean.g0 g0Var) {
        invoke(num.intValue(), g0Var);
        return kotlin.u.a;
    }

    public final void invoke(int i2, us.pinguo.edit2020.bean.g0 info) {
        kotlin.jvm.internal.s.h(info, "info");
        this.$function.r(i2);
        ((TextView) this.$layout.element.findViewById(R.id.txtCyanValue)).setText(String.valueOf(info.h().b()));
        ((StickySeekBar) this.$layout.element.findViewById(R.id.sbCyan)).setProgress(info.h().b());
        ((TextView) this.$layout.element.findViewById(R.id.txtMagentaValue)).setText(String.valueOf(info.k().b()));
        ((StickySeekBar) this.$layout.element.findViewById(R.id.sbMagenta)).setProgress(info.k().b());
        ((TextView) this.$layout.element.findViewById(R.id.txtYellowValue)).setText(String.valueOf(info.m().b()));
        ((StickySeekBar) this.$layout.element.findViewById(R.id.sbYellow)).setProgress(info.m().b());
        ((TextView) this.$layout.element.findViewById(R.id.txtBlackValue)).setText(String.valueOf(info.g().b()));
        ((StickySeekBar) this.$layout.element.findViewById(R.id.sbBlack)).setProgress(info.g().b());
    }
}
