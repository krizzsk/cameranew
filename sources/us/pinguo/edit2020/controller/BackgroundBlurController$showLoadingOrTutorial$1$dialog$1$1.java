package us.pinguo.edit2020.controller;

import kotlin.jvm.internal.Lambda;
/* compiled from: BackgroundBlurController.kt */
/* loaded from: classes4.dex */
final class BackgroundBlurController$showLoadingOrTutorial$1$dialog$1$1 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ BackgroundBlurController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundBlurController$showLoadingOrTutorial$1$dialog$1$1(BackgroundBlurController backgroundBlurController) {
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
        this.this$0.o0();
        this.this$0.t = false;
        us.pinguo.repository2020.utils.o.n(us.pinguo.repository2020.utils.o.a, "new_to_bg_blur", false, null, 4, null);
    }
}
