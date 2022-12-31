package us.pinguo.edit2020.controller;

import kotlin.jvm.internal.Lambda;
/* compiled from: EditBottomTabBeautyController.kt */
/* loaded from: classes4.dex */
final class EditBottomTabBeautyController$onGotoEvent$12 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ us.pinguo.edit2020.model.editgoto.b $editGoto;
    final /* synthetic */ EditBottomTabBeautyController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditBottomTabBeautyController$onGotoEvent$12(EditBottomTabBeautyController editBottomTabBeautyController, us.pinguo.edit2020.model.editgoto.b bVar) {
        super(0);
        this.this$0 = editBottomTabBeautyController;
        this.$editGoto = bVar;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        kotlin.jvm.b.p pVar;
        pVar = this.this$0.f10328g;
        pVar.invoke(null, null);
        this.this$0.z1(this.$editGoto.d());
    }
}
