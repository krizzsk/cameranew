package us.pinguo.edit2020.fragment;

import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.controller.b3;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditFragment.kt */
/* loaded from: classes4.dex */
public final class EditFragment$initBeautyTab$5 extends Lambda implements kotlin.jvm.b.l<Boolean, kotlin.u> {
    final /* synthetic */ EditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFragment$initBeautyTab$5(EditFragment editFragment) {
        super(1);
        this.this$0 = editFragment;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return kotlin.u.a;
    }

    public final void invoke(boolean z) {
        b3 b3Var;
        b3 b3Var2;
        if (z) {
            b3Var2 = this.this$0.f10514j;
            if (b3Var2 != null) {
                b3Var2.v();
                return;
            } else {
                kotlin.jvm.internal.s.z("faceCurveController");
                throw null;
            }
        }
        b3Var = this.this$0.f10514j;
        if (b3Var != null) {
            b3Var.l();
        } else {
            kotlin.jvm.internal.s.z("faceCurveController");
            throw null;
        }
    }
}
