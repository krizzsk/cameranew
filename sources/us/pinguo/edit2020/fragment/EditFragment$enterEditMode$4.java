package us.pinguo.edit2020.fragment;

import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.controller.d3;
import us.pinguo.edit2020.viewmodel.EditViewModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditFragment.kt */
/* loaded from: classes4.dex */
public final class EditFragment$enterEditMode$4 extends Lambda implements kotlin.jvm.b.l<Integer, kotlin.u> {
    final /* synthetic */ EditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFragment$enterEditMode$4(EditFragment editFragment) {
        super(1);
        this.this$0 = editFragment;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num) {
        invoke(num.intValue());
        return kotlin.u.a;
    }

    public final void invoke(int i2) {
        EditViewModel j1;
        EditViewModel j12;
        d3 d3Var;
        j1 = this.this$0.j1();
        j1.h().q().setValue(Integer.valueOf(i2));
        j12 = this.this$0.j1();
        j12.h().E0();
        d3Var = this.this$0.f10511g;
        if (d3Var != null) {
            d3Var.o(i2);
        } else {
            kotlin.jvm.internal.s.z("bottomTabBeautyController");
            throw null;
        }
    }
}
