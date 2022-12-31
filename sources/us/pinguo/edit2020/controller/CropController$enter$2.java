package us.pinguo.edit2020.controller;

import kotlin.jvm.internal.Lambda;
import us.pinguo.u3dengine.edit.EditModel;
/* compiled from: CropController.kt */
/* loaded from: classes4.dex */
final class CropController$enter$2 extends Lambda implements kotlin.jvm.b.l<EditModel, kotlin.u> {
    final /* synthetic */ CropController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CropController$enter$2(CropController cropController) {
        super(1);
        this.this$0 = cropController;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(EditModel editModel) {
        invoke2(editModel);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(EditModel editModel) {
        kotlin.jvm.internal.s.h(editModel, "editModel");
        if (editModel == EditModel.Clip) {
            this.this$0.a.z(this.this$0.f10302e.m());
        }
    }
}
