package us.pinguo.edit2020.controller;

import kotlin.jvm.internal.FunctionReferenceImpl;
/* compiled from: StaticStickerController.kt */
/* loaded from: classes4.dex */
/* synthetic */ class StaticStickerController$enter$2 extends FunctionReferenceImpl implements kotlin.jvm.b.w<String, Float, Float, Float, Float, Float, Float, Integer, Integer, kotlin.u> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public StaticStickerController$enter$2(Object obj) {
        super(9, obj, StaticStickerController.class, "onStickerStatusChangedCallback", "onStickerStatusChangedCallback(Ljava/lang/String;FFFFFFII)V", 0);
    }

    @Override // kotlin.jvm.b.w
    public /* bridge */ /* synthetic */ kotlin.u invoke(String str, Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Integer num, Integer num2) {
        invoke(str, f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue(), f6.floatValue(), f7.floatValue(), num.intValue(), num2.intValue());
        return kotlin.u.a;
    }

    public final void invoke(String p0, float f2, float f3, float f4, float f5, float f6, float f7, int i2, int i3) {
        kotlin.jvm.internal.s.h(p0, "p0");
        ((StaticStickerController) this.receiver).t0(p0, f2, f3, f4, f5, f6, f7, i2, i3);
    }
}
