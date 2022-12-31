package us.pinguo.edit2020.controller;

import kotlin.jvm.internal.Lambda;
import us.pinguo.u3dengine.edit.EditModel;
/* compiled from: LongLegController.kt */
/* loaded from: classes4.dex */
final class LongLegController$onWorkflowStarted$7 extends Lambda implements kotlin.jvm.b.l<EditModel, kotlin.u> {
    final /* synthetic */ int $selectedIndex;
    final /* synthetic */ LongLegController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongLegController$onWorkflowStarted$7(LongLegController longLegController, int i2) {
        super(1);
        this.this$0 = longLegController;
        this.$selectedIndex = i2;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(EditModel editModel) {
        invoke2(editModel);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(EditModel it) {
        kotlin.jvm.internal.s.h(it, "it");
        this.this$0.c.h(this.this$0.c.e().get(this.$selectedIndex));
    }
}
