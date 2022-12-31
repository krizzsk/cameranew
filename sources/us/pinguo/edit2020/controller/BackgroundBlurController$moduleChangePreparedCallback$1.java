package us.pinguo.edit2020.controller;

import kotlin.jvm.internal.Lambda;
import us.pinguo.u3dengine.edit.EditModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundBlurController.kt */
/* loaded from: classes4.dex */
public final class BackgroundBlurController$moduleChangePreparedCallback$1 extends Lambda implements kotlin.jvm.b.l<EditModel, kotlin.u> {
    final /* synthetic */ BackgroundBlurController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundBlurController$moduleChangePreparedCallback$1(BackgroundBlurController backgroundBlurController) {
        super(1);
        this.this$0 = backgroundBlurController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final void m79invoke$lambda1(BackgroundBlurController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.f1();
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(EditModel editModel) {
        invoke2(editModel);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(EditModel model) {
        kotlin.jvm.internal.s.h(model, "model");
        if (model == EditModel.BackgroundBlur) {
            Float E = this.this$0.c.E();
            if (E != null) {
                BackgroundBlurController backgroundBlurController = this.this$0;
                backgroundBlurController.c.n0(E.floatValue());
            }
            final BackgroundBlurController backgroundBlurController2 = this.this$0;
            us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.edit2020.controller.q
                @Override // java.lang.Runnable
                public final void run() {
                    BackgroundBlurController$moduleChangePreparedCallback$1.m79invoke$lambda1(BackgroundBlurController.this);
                }
            });
        }
    }
}
