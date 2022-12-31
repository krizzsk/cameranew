package us.pinguo.edit2020.controller;

import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.view.ProgressWheelView;
import us.pinguo.repository2020.entity.BackgroundBlur;
import us.pinguo.ui.widget.StickySeekBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundBlurController.kt */
/* loaded from: classes4.dex */
public final class BackgroundBlurController$initBackgroundBlurCustomizeView$2 extends Lambda implements kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.e, kotlin.u> {
    final /* synthetic */ RecyclerView $rvBackgroundBlurCustomize;
    final /* synthetic */ RecyclerView $rvBackgroundBlurShape;
    final /* synthetic */ StickySeekBar $sbBackgroundBlurCustomize;
    final /* synthetic */ ProgressWheelView $sbBackgroundBlurIntensity;
    final /* synthetic */ BackgroundBlurController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BackgroundBlurController.kt */
    /* renamed from: us.pinguo.edit2020.controller.BackgroundBlurController$initBackgroundBlurCustomizeView$2$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
        final /* synthetic */ BackgroundBlurController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BackgroundBlurController backgroundBlurController) {
            super(0);
            this.this$0 = backgroundBlurController;
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.u invoke() {
            invoke2();
            return kotlin.u.a;
        }

        @Override // kotlin.jvm.b.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.this$0.c.d0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundBlurController$initBackgroundBlurCustomizeView$2(BackgroundBlurController backgroundBlurController, RecyclerView recyclerView, RecyclerView recyclerView2, ProgressWheelView progressWheelView, StickySeekBar stickySeekBar) {
        super(2);
        this.this$0 = backgroundBlurController;
        this.$rvBackgroundBlurCustomize = recyclerView;
        this.$rvBackgroundBlurShape = recyclerView2;
        this.$sbBackgroundBlurIntensity = progressWheelView;
        this.$sbBackgroundBlurCustomize = stickySeekBar;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num, us.pinguo.edit2020.bean.e eVar) {
        invoke(num.intValue(), eVar);
        return kotlin.u.a;
    }

    public final void invoke(int i2, us.pinguo.edit2020.bean.e function) {
        kotlin.jvm.internal.s.h(function, "function");
        BackgroundBlur Q = this.this$0.c.Q();
        if (Q != null) {
            Q.setCurrentBlurLensParamType(function.f());
        }
        this.this$0.c.v0(function);
        BackgroundBlurController backgroundBlurController = this.this$0;
        RecyclerView rvBackgroundBlurCustomize = this.$rvBackgroundBlurCustomize;
        kotlin.jvm.internal.s.g(rvBackgroundBlurCustomize, "rvBackgroundBlurCustomize");
        backgroundBlurController.V0(rvBackgroundBlurCustomize, i2);
        this.this$0.c.q(function.g(), new AnonymousClass1(this.this$0));
        String f2 = function.f();
        if (kotlin.jvm.internal.s.c(f2, "background_blur_shape")) {
            RecyclerView rvBackgroundBlurShape = this.$rvBackgroundBlurShape;
            kotlin.jvm.internal.s.g(rvBackgroundBlurShape, "rvBackgroundBlurShape");
            rvBackgroundBlurShape.setVisibility(0);
            VdsAgent.onSetViewVisibility(rvBackgroundBlurShape, 0);
            ProgressWheelView sbBackgroundBlurIntensity = this.$sbBackgroundBlurIntensity;
            kotlin.jvm.internal.s.g(sbBackgroundBlurIntensity, "sbBackgroundBlurIntensity");
            sbBackgroundBlurIntensity.setVisibility(4);
            VdsAgent.onSetViewVisibility(sbBackgroundBlurIntensity, 4);
            StickySeekBar sbBackgroundBlurCustomize = this.$sbBackgroundBlurCustomize;
            kotlin.jvm.internal.s.g(sbBackgroundBlurCustomize, "sbBackgroundBlurCustomize");
            sbBackgroundBlurCustomize.setVisibility(4);
            VdsAgent.onSetViewVisibility(sbBackgroundBlurCustomize, 4);
        } else if (kotlin.jvm.internal.s.c(f2, "background_blur_intensity")) {
            RecyclerView rvBackgroundBlurShape2 = this.$rvBackgroundBlurShape;
            kotlin.jvm.internal.s.g(rvBackgroundBlurShape2, "rvBackgroundBlurShape");
            rvBackgroundBlurShape2.setVisibility(4);
            VdsAgent.onSetViewVisibility(rvBackgroundBlurShape2, 4);
            StickySeekBar sbBackgroundBlurCustomize2 = this.$sbBackgroundBlurCustomize;
            kotlin.jvm.internal.s.g(sbBackgroundBlurCustomize2, "sbBackgroundBlurCustomize");
            sbBackgroundBlurCustomize2.setVisibility(4);
            VdsAgent.onSetViewVisibility(sbBackgroundBlurCustomize2, 4);
            ProgressWheelView sbBackgroundBlurIntensity2 = this.$sbBackgroundBlurIntensity;
            kotlin.jvm.internal.s.g(sbBackgroundBlurIntensity2, "sbBackgroundBlurIntensity");
            sbBackgroundBlurIntensity2.setVisibility(0);
            VdsAgent.onSetViewVisibility(sbBackgroundBlurIntensity2, 0);
            ProgressWheelView sbBackgroundBlurIntensity3 = this.$sbBackgroundBlurIntensity;
            kotlin.jvm.internal.s.g(sbBackgroundBlurIntensity3, "sbBackgroundBlurIntensity");
            ProgressWheelView.setValue$edit2020_release$default(sbBackgroundBlurIntensity3, this.this$0.c.H(), false, false, 4, null);
        } else {
            RecyclerView rvBackgroundBlurShape3 = this.$rvBackgroundBlurShape;
            kotlin.jvm.internal.s.g(rvBackgroundBlurShape3, "rvBackgroundBlurShape");
            rvBackgroundBlurShape3.setVisibility(4);
            VdsAgent.onSetViewVisibility(rvBackgroundBlurShape3, 4);
            StickySeekBar sbBackgroundBlurCustomize3 = this.$sbBackgroundBlurCustomize;
            kotlin.jvm.internal.s.g(sbBackgroundBlurCustomize3, "sbBackgroundBlurCustomize");
            sbBackgroundBlurCustomize3.setVisibility(0);
            VdsAgent.onSetViewVisibility(sbBackgroundBlurCustomize3, 0);
            ProgressWheelView sbBackgroundBlurIntensity4 = this.$sbBackgroundBlurIntensity;
            kotlin.jvm.internal.s.g(sbBackgroundBlurIntensity4, "sbBackgroundBlurIntensity");
            sbBackgroundBlurIntensity4.setVisibility(4);
            VdsAgent.onSetViewVisibility(sbBackgroundBlurIntensity4, 4);
            this.$sbBackgroundBlurCustomize.setValues(function.j(), function.i(), function.g(), Integer.valueOf(function.h()));
        }
    }
}
