package us.pinguo.edit2020.controller;

import kotlin.jvm.internal.Lambda;
/* compiled from: EditBottomTabBeautyController.kt */
/* loaded from: classes4.dex */
final class EditBottomTabBeautyController$onGotoEvent$6 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ EditBottomTabBeautyController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditBottomTabBeautyController$onGotoEvent$6(EditBottomTabBeautyController editBottomTabBeautyController) {
        super(0);
        this.this$0 = editBottomTabBeautyController;
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
        if (!this.this$0.f10326e.S()) {
            this.this$0.H1(1, 0);
        } else if (kotlin.jvm.internal.s.c(this.this$0.f10326e.M().get(2).g().getBeautyKey(), "yunfu")) {
            this.this$0.H1(0, 2);
        } else {
            this.this$0.H1(0, 0);
        }
    }
}
