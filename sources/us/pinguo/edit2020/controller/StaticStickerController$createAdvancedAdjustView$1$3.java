package us.pinguo.edit2020.controller;

import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.viewmodel.module.StaticStickerModule;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerController.kt */
/* loaded from: classes4.dex */
public final class StaticStickerController$createAdvancedAdjustView$1$3 extends Lambda implements kotlin.jvm.b.l<us.pinguo.edit2020.model.f.a, kotlin.u> {
    final /* synthetic */ StaticStickerController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticStickerController$createAdvancedAdjustView$1$3(StaticStickerController staticStickerController) {
        super(1);
        this.this$0 = staticStickerController;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(us.pinguo.edit2020.model.f.a aVar) {
        invoke2(aVar);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(us.pinguo.edit2020.model.f.a blendTypeModel) {
        kotlin.jvm.internal.s.h(blendTypeModel, "blendTypeModel");
        StaticStickerModule.F0(this.this$0.b, blendTypeModel.b(), null, Boolean.TRUE, false, 8, null);
    }
}
