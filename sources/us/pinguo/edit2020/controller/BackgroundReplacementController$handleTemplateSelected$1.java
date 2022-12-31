package us.pinguo.edit2020.controller;

import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundReplacementController.kt */
/* loaded from: classes4.dex */
public final class BackgroundReplacementController$handleTemplateSelected$1 extends Lambda implements kotlin.jvm.b.p<String, Integer, kotlin.u> {
    final /* synthetic */ us.pinguo.edit2020.bean.f $func;
    final /* synthetic */ BackgroundReplacementController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundReplacementController$handleTemplateSelected$1(us.pinguo.edit2020.bean.f fVar, BackgroundReplacementController backgroundReplacementController) {
        super(2);
        this.$func = fVar;
        this.this$0 = backgroundReplacementController;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ kotlin.u invoke(String str, Integer num) {
        invoke(str, num.intValue());
        return kotlin.u.a;
    }

    public final void invoke(String id, int i2) {
        us.pinguo.edit2020.adapter.u uVar;
        kotlin.jvm.internal.s.h(id, "id");
        this.$func.s(i2);
        uVar = this.this$0.u;
        uVar.n(id);
    }
}
