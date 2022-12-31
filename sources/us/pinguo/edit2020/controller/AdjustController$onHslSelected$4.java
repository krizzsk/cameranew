package us.pinguo.edit2020.controller;

import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import us.pinguo.edit2020.R;
import us.pinguo.ui.widget.StickySeekBar;
/* compiled from: AdjustController.kt */
/* loaded from: classes4.dex */
final class AdjustController$onHslSelected$4 extends Lambda implements kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.w, kotlin.u> {
    final /* synthetic */ us.pinguo.edit2020.bean.v $function;
    final /* synthetic */ Ref$ObjectRef<ConstraintLayout> $hslView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdjustController$onHslSelected$4(us.pinguo.edit2020.bean.v vVar, Ref$ObjectRef<ConstraintLayout> ref$ObjectRef) {
        super(2);
        this.$function = vVar;
        this.$hslView = ref$ObjectRef;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num, us.pinguo.edit2020.bean.w wVar) {
        invoke(num.intValue(), wVar);
        return kotlin.u.a;
    }

    public final void invoke(int i2, us.pinguo.edit2020.bean.w hslInfo) {
        int intValue;
        int intValue2;
        kotlin.jvm.internal.s.h(hslInfo, "hslInfo");
        this.$function.q(i2);
        us.pinguo.edit2020.bean.t j2 = hslInfo.j();
        StickySeekBar stickySeekBar = (StickySeekBar) this.$hslView.element.findViewById(R.id.sbHue);
        int[] iArr = new int[3];
        iArr[0] = j2.c();
        Integer b = j2.b();
        if (b == null) {
            intValue = hslInfo.c();
        } else {
            intValue = b.intValue();
        }
        iArr[1] = intValue;
        iArr[2] = j2.a();
        stickySeekBar.setTrackColor(iArr);
        stickySeekBar.setProgress(hslInfo.g());
        ((TextView) this.$hslView.element.findViewById(R.id.txtHueValue)).setText(String.valueOf(hslInfo.g()));
        us.pinguo.edit2020.bean.t k2 = hslInfo.k();
        StickySeekBar stickySeekBar2 = (StickySeekBar) this.$hslView.element.findViewById(R.id.sbBrightness);
        int[] iArr2 = new int[3];
        iArr2[0] = k2.c();
        Integer b2 = k2.b();
        if (b2 == null) {
            intValue2 = hslInfo.c();
        } else {
            intValue2 = b2.intValue();
        }
        iArr2[1] = intValue2;
        iArr2[2] = k2.a();
        stickySeekBar2.setTrackColor(iArr2);
        stickySeekBar2.setProgress(hslInfo.h());
        ((TextView) this.$hslView.element.findViewById(R.id.txtBrightnessValue)).setText(String.valueOf(hslInfo.h()));
        us.pinguo.edit2020.bean.t l2 = hslInfo.l();
        StickySeekBar stickySeekBar3 = (StickySeekBar) this.$hslView.element.findViewById(R.id.sbSaturation);
        stickySeekBar3.setTrackColor(l2.c(), l2.a());
        stickySeekBar3.setProgress(hslInfo.i());
        ((TextView) this.$hslView.element.findViewById(R.id.txtSaturationValue)).setText(String.valueOf(hslInfo.i()));
    }
}
