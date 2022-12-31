package us.pinguo.edit2020.controller;

import android.graphics.PointF;
import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerController.kt */
/* loaded from: classes4.dex */
public final class StaticStickerController$initSelectRectView$1 extends Lambda implements kotlin.jvm.b.r<String, Float, PointF, PointF, kotlin.u> {
    final /* synthetic */ StaticStickerController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticStickerController$initSelectRectView$1(StaticStickerController staticStickerController) {
        super(4);
        this.this$0 = staticStickerController;
    }

    @Override // kotlin.jvm.b.r
    public /* bridge */ /* synthetic */ kotlin.u invoke(String str, Float f2, PointF pointF, PointF pointF2) {
        invoke2(str, f2, pointF, pointF2);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String key, Float f2, PointF pointF, PointF pointF2) {
        kotlin.jvm.internal.s.h(key, "key");
        this.this$0.b.G0(key, f2, pointF, pointF2);
    }
}
