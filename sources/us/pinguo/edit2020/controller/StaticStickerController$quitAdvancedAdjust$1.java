package us.pinguo.edit2020.controller;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.internal.Lambda;
import us.pinguo.common.widget.tab.PGEditBottomTabLayout;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.view.SelectRectAdjustView;
import us.pinguo.u3dengine.edit.BasicBrushMode;
import us.pinguo.ui.widget.AutofitTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerController.kt */
/* loaded from: classes4.dex */
public final class StaticStickerController$quitAdvancedAdjust$1 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ StaticStickerController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticStickerController$quitAdvancedAdjust$1(StaticStickerController staticStickerController) {
        super(0);
        this.this$0 = staticStickerController;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        us.pinguo.edit2020.view.c0 c0Var;
        Observer<? super us.pinguo.edit2020.bean.u0> c0;
        ViewGroup viewGroup = this.this$0.f10427e;
        int i2 = R.id.tvSkipToStickerPackage;
        AutofitTextView autofitTextView = (AutofitTextView) viewGroup.findViewById(i2);
        kotlin.jvm.internal.s.g(autofitTextView, "fragmentLayout.tvSkipToStickerPackage");
        if (autofitTextView.getVisibility() == 4) {
            AutofitTextView autofitTextView2 = (AutofitTextView) this.this$0.f10427e.findViewById(i2);
            kotlin.jvm.internal.s.g(autofitTextView2, "fragmentLayout.tvSkipToStickerPackage");
            autofitTextView2.setVisibility(0);
            VdsAgent.onSetViewVisibility(autofitTextView2, 0);
        }
        PGEditBottomTabLayout pGEditBottomTabLayout = (PGEditBottomTabLayout) this.this$0.f10427e.findViewById(R.id.bottomTabLayout);
        kotlin.jvm.internal.s.g(pGEditBottomTabLayout, "fragmentLayout.bottomTabLayout");
        pGEditBottomTabLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(pGEditBottomTabLayout, 0);
        c0Var = this.this$0.f10426d;
        c0Var.F(false);
        ((FrameLayout) this.this$0.f10427e.findViewById(R.id.flViewContainer)).removeView(this.this$0.m);
        this.this$0.c.c();
        this.this$0.b.o0(BasicBrushMode.None);
        us.pinguo.repository2020.u<us.pinguo.edit2020.bean.u0> v = this.this$0.b.v();
        c0 = this.this$0.c0();
        v.removeObserver(c0);
        ViewGroup viewGroup2 = this.this$0.f10427e;
        int i3 = R.id.selectRectAdjustView;
        ((SelectRectAdjustView) viewGroup2.findViewById(i3)).setShowSizeRect(false);
        ((SelectRectAdjustView) this.this$0.f10427e.findViewById(i3)).T();
    }
}
