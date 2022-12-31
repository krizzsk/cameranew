package us.pinguo.edit2020.controller;

import android.animation.ValueAnimator;
import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Set;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
import us.pinguo.u3dengine.edit.UnityEditCaller;
import us.pinguo.ui.widget.LanFitTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EliminationController.kt */
/* loaded from: classes4.dex */
public final class EliminationController$showFunctions$1 extends Lambda implements kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.o, kotlin.u> {
    final /* synthetic */ ConstraintLayout $layout;
    final /* synthetic */ EliminationController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EliminationController$showFunctions$1(EliminationController eliminationController, ConstraintLayout constraintLayout) {
        super(2);
        this.this$0 = eliminationController;
        this.$layout = constraintLayout;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num, us.pinguo.edit2020.bean.o oVar) {
        invoke(num.intValue(), oVar);
        return kotlin.u.a;
    }

    public final void invoke(int i2, us.pinguo.edit2020.bean.o func) {
        boolean z;
        boolean z2;
        ConstraintLayout constraintLayout;
        int i3;
        us.pinguo.edit2020.adapter.a0 a0Var;
        ConstraintLayout constraintLayout2;
        int i4;
        ValueAnimator valueAnimator;
        kotlin.jvm.internal.s.h(func, "func");
        this.this$0.f10354f.c();
        if (i2 != 0) {
            if (i2 == 1) {
                this.this$0.q = func;
                if (func.l() == 0) {
                    constraintLayout = this.$layout;
                    i3 = R.id.tvSize;
                } else {
                    constraintLayout = this.$layout;
                    i3 = R.id.tvHardness;
                }
                ((LanFitTextView) constraintLayout.findViewById(i3)).performClick();
                this.this$0.f10353e.setSize(this.this$0.M() * this.this$0.f10360l * 0.85f);
                this.this$0.f10354f.o(this.this$0.f10353e.a());
                UnityEditCaller.RemoveSpot.setSpotRemoveMode(func.g());
                UnityEditCaller.RemoveSpot.setBrushSize(this.this$0.M());
                UnityEditCaller.RemoveSpot.setBrushGassIntensity(func.h() / 100.0f);
            } else if (i2 == 2) {
                a0Var = this.this$0.r;
                Set<Integer> m = a0Var.m();
                if (m != null && m.contains(2)) {
                    return;
                }
                this.this$0.q = func;
                if (func.l() == 0) {
                    constraintLayout2 = this.$layout;
                    i4 = R.id.tvSize;
                } else {
                    constraintLayout2 = this.$layout;
                    i4 = R.id.tvHardness;
                }
                ((LanFitTextView) constraintLayout2.findViewById(i4)).performClick();
                this.this$0.f10353e.setSize(this.this$0.M() * this.this$0.f10360l * 0.85f);
                this.this$0.f10354f.o(this.this$0.f10353e.a());
                UnityEditCaller.RemoveSpot.setSpotRemoveMode(func.g());
                UnityEditCaller.RemoveSpot.setBrushSize(this.this$0.M());
                UnityEditCaller.RemoveSpot.setBrushGassIntensity(func.h() / 100.0f);
                valueAnimator = this.this$0.p;
                valueAnimator.start();
            }
        } else {
            z = this.this$0.s;
            if (!z) {
                z2 = this.this$0.t;
                if (z2) {
                    EliminationController eliminationController = this.this$0;
                    Context context = this.$layout.getContext();
                    kotlin.jvm.internal.s.g(context, "layout.context");
                    eliminationController.i0(context);
                }
            }
        }
        us.pinguo.foundation.statistics.h.b.i0(func.f(), "click");
    }
}
