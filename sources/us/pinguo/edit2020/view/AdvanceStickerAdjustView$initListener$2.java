package us.pinguo.edit2020.view;

import kotlin.jvm.internal.Lambda;
/* compiled from: AdvanceStickerAdjustView.kt */
/* loaded from: classes4.dex */
final class AdvanceStickerAdjustView$initListener$2 extends Lambda implements kotlin.jvm.b.l<f0, kotlin.u> {
    final /* synthetic */ AdvanceStickerAdjustView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvanceStickerAdjustView$initListener$2(AdvanceStickerAdjustView advanceStickerAdjustView) {
        super(1);
        this.this$0 = advanceStickerAdjustView;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(f0 f0Var) {
        invoke2(f0Var);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(f0 iScrollText) {
        kotlin.jvm.internal.s.h(iScrollText, "iScrollText");
        kotlin.jvm.b.l<us.pinguo.edit2020.model.f.a, kotlin.u> l2 = this.this$0.l();
        if (l2 == null) {
            return;
        }
        l2.invoke((us.pinguo.edit2020.model.f.a) iScrollText);
    }
}
