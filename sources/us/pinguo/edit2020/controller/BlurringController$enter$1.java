package us.pinguo.edit2020.controller;

import android.os.Handler;
import kotlin.jvm.internal.Lambda;
/* compiled from: BlurringController.kt */
/* loaded from: classes4.dex */
final class BlurringController$enter$1 extends Lambda implements kotlin.jvm.b.t<Boolean, Float, Float, Float, Float, Float, kotlin.u> {
    final /* synthetic */ BlurringController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlurringController$enter$1(BlurringController blurringController) {
        super(6);
        this.this$0 = blurringController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m84invoke$lambda0(BlurringController this$0, boolean z, float f2, float f3, float f4, float f5, float f6) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.r(z, f2, f3, f4, f5, f6);
    }

    @Override // kotlin.jvm.b.t
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool, Float f2, Float f3, Float f4, Float f5, Float f6) {
        invoke(bool.booleanValue(), f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue(), f6.floatValue());
        return kotlin.u.a;
    }

    public final void invoke(final boolean z, final float f2, final float f3, final float f4, final float f5, final float f6) {
        Handler handler;
        handler = this.this$0.f10298j;
        final BlurringController blurringController = this.this$0;
        handler.post(new Runnable() { // from class: us.pinguo.edit2020.controller.d0
            @Override // java.lang.Runnable
            public final void run() {
                BlurringController$enter$1.m84invoke$lambda0(BlurringController.this, z, f2, f3, f4, f5, f6);
            }
        });
    }
}
