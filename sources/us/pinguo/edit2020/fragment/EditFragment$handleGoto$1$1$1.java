package us.pinguo.edit2020.fragment;

import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.controller.AdjustController;
import us.pinguo.edit2020.controller.EditController;
import us.pinguo.edit2020.controller.EditFilterController;
import us.pinguo.edit2020.controller.d3;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditFragment.kt */
/* loaded from: classes4.dex */
public final class EditFragment$handleGoto$1$1$1 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ us.pinguo.edit2020.model.editgoto.b $editGoto;
    final /* synthetic */ EditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFragment$handleGoto$1$1$1(EditFragment editFragment, us.pinguo.edit2020.model.editgoto.b bVar) {
        super(0);
        this.this$0 = editFragment;
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
        d3 d3Var;
        EditFilterController editFilterController;
        AdjustController adjustController;
        EditController editController;
        EditFragment editFragment = this.this$0;
        us.pinguo.edit2020.model.editgoto.b bVar = this.$editGoto;
        d3Var = editFragment.f10511g;
        if (d3Var == null) {
            kotlin.jvm.internal.s.z("bottomTabBeautyController");
            throw null;
        }
        if (d3Var.L(bVar)) {
            editFragment = null;
        }
        if (editFragment == null) {
            return;
        }
        EditFragment editFragment2 = this.this$0;
        us.pinguo.edit2020.model.editgoto.b bVar2 = this.$editGoto;
        editFilterController = editFragment2.x;
        boolean z = false;
        if (editFilterController != null && editFilterController.L(bVar2)) {
            editFragment = null;
        }
        if (editFragment == null) {
            return;
        }
        EditFragment editFragment3 = this.this$0;
        us.pinguo.edit2020.model.editgoto.b bVar3 = this.$editGoto;
        editFragment3.Y0();
        adjustController = editFragment3.f10512h;
        if (adjustController != null && adjustController.L(bVar3)) {
            z = true;
        }
        if ((z ? null : editFragment) == null) {
            return;
        }
        EditFragment editFragment4 = this.this$0;
        us.pinguo.edit2020.model.editgoto.b bVar4 = this.$editGoto;
        editFragment4.a1();
        editController = editFragment4.f10513i;
        if (editController == null) {
            return;
        }
        editController.L(bVar4);
    }
}
