package us.pinguo.edit2020.fragment;

import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.controller.d3;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditFragment.kt */
/* loaded from: classes4.dex */
public final class EditFragment$onEditWorkFlowCancelClick$2 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ EditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFragment$onEditWorkFlowCancelClick$2(EditFragment editFragment) {
        super(0);
        this.this$0 = editFragment;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        d3 d3Var;
        this.this$0.i1();
        d3Var = this.this$0.f10511g;
        if (d3Var != null) {
            d3Var.g();
            this.this$0.d1();
            return;
        }
        kotlin.jvm.internal.s.z("bottomTabBeautyController");
        throw null;
    }
}
