package us.pinguo.camera2020.view;

import android.view.View;
import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AfterCaptureBottomController.kt */
/* loaded from: classes3.dex */
public final class AfterCaptureBottomController$show$8 extends Lambda implements kotlin.jvm.b.l<View, kotlin.u> {
    final /* synthetic */ AfterCaptureBottomController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AfterCaptureBottomController$show$8(AfterCaptureBottomController afterCaptureBottomController) {
        super(1);
        this.this$0 = afterCaptureBottomController;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(View view) {
        invoke2(view);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(View it) {
        kotlin.jvm.internal.s.h(it, "it");
        kotlin.jvm.b.a<kotlin.u> r = this.this$0.r();
        if (r != null) {
            r.invoke();
        }
        this.this$0.a.f();
        this.this$0.d0(false);
    }
}
