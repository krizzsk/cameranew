package us.pinguo.edit2020.controller;

import kotlin.jvm.internal.Lambda;
/* compiled from: StaticStickerController.kt */
/* loaded from: classes4.dex */
final class StaticStickerController$enter$3 extends Lambda implements kotlin.jvm.b.l<Exception, kotlin.u> {
    final /* synthetic */ us.pinguo.edit2020.model.editgoto.b $editGoto;
    final /* synthetic */ StaticStickerController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticStickerController$enter$3(StaticStickerController staticStickerController, us.pinguo.edit2020.model.editgoto.b bVar) {
        super(1);
        this.this$0 = staticStickerController;
        this.$editGoto = bVar;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Exception exc) {
        invoke2(exc);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Exception exc) {
        this.this$0.f10428f.q();
        StaticStickerController staticStickerController = this.this$0;
        staticStickerController.x0(staticStickerController.f10429g);
        if (this.this$0.f10429g != 0) {
            if (this.this$0.f10429g == 1) {
                us.pinguo.foundation.statistics.h.b.y0("template_tab", "", "click");
            }
        } else {
            us.pinguo.foundation.statistics.h.b.y0("sticker_tab", "", "click");
        }
        this.this$0.f10428f.L(this.$editGoto);
    }
}
