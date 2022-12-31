package us.pinguo.edit2020.controller;

import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.view.AdvanceStickerAdjustView;
import us.pinguo.edit2020.view.BoldTipView;
import us.pinguo.u3dengine.edit.BasicBrushMode;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerController.kt */
/* loaded from: classes4.dex */
public final class StaticStickerController$createAdvancedAdjustView$1$2 extends Lambda implements kotlin.jvm.b.l<Integer, kotlin.u> {
    final /* synthetic */ AdvanceStickerAdjustView $this_apply;
    final /* synthetic */ StaticStickerController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticStickerController$createAdvancedAdjustView$1$2(StaticStickerController staticStickerController, AdvanceStickerAdjustView advanceStickerAdjustView) {
        super(1);
        this.this$0 = staticStickerController;
        this.$this_apply = advanceStickerAdjustView;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num) {
        invoke(num.intValue());
        return kotlin.u.a;
    }

    public final void invoke(int i2) {
        float E0;
        float E02;
        if (i2 == 0) {
            this.this$0.c.g(true);
            this.this$0.b.p0(BasicBrushMode.Erasing, this.this$0.b.u(this.$this_apply.k()));
            E0 = this.this$0.E0(this.$this_apply);
            ((BoldTipView) this.this$0.f10427e.findViewById(R.id.imgBoldTip)).setSize(E0);
        } else if (i2 != 1) {
            this.this$0.c.g(false);
            this.this$0.b.o0(BasicBrushMode.None);
        } else {
            this.this$0.c.g(true);
            this.this$0.b.p0(BasicBrushMode.Brush, this.this$0.b.u(this.$this_apply.k()));
            E02 = this.this$0.E0(this.$this_apply);
            ((BoldTipView) this.this$0.f10427e.findViewById(R.id.imgBoldTip)).setSize(E02);
        }
    }
}
