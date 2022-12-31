package us.pinguo.edit2020.controller;

import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageRestorationController.kt */
/* loaded from: classes4.dex */
public final class ImageRestorationController$enter$2 extends Lambda implements kotlin.jvm.b.l<Float, kotlin.u> {
    final /* synthetic */ ImageRestorationController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageRestorationController$enter$2(ImageRestorationController imageRestorationController) {
        super(1);
        this.this$0 = imageRestorationController;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Float f2) {
        invoke(f2.floatValue());
        return kotlin.u.a;
    }

    public final void invoke(float f2) {
        us.pinguo.edit2020.viewmodel.module.a aVar;
        us.pinguo.edit2020.view.d0 d0Var;
        us.pinguo.edit2020.viewmodel.module.a aVar2;
        aVar = this.this$0.b;
        aVar.m(f2);
        d0Var = this.this$0.f10377f;
        if (d0Var == null) {
            return;
        }
        aVar2 = this.this$0.b;
        d0Var.setRate(aVar2.g());
    }
}
