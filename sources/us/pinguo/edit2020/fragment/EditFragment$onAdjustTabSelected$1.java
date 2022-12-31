package us.pinguo.edit2020.fragment;

import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.internal.Lambda;
import us.pinguo.common.widget.tab.PGEditBottomTabLayout;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.controller.AdjustController;
import us.pinguo.edit2020.controller.z2;
import us.pinguo.edit2020.viewmodel.EditViewModel;
/* compiled from: EditFragment.kt */
/* loaded from: classes4.dex */
final class EditFragment$onAdjustTabSelected$1 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ EditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFragment$onAdjustTabSelected$1(EditFragment editFragment) {
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
        z2 z2Var;
        AdjustController adjustController;
        us.pinguo.edit2020.view.c0 c0Var;
        AdjustController adjustController2;
        EditViewModel j1;
        us.pinguo.edit2020.view.c0 c0Var2;
        this.this$0.f1(null, null);
        this.this$0.Y0();
        this.this$0.A = null;
        EditFragment editFragment = this.this$0;
        z2Var = editFragment.y;
        editFragment.z = z2Var;
        EditFragment editFragment2 = this.this$0;
        adjustController = editFragment2.f10512h;
        editFragment2.y = adjustController;
        EditFragment editFragment3 = this.this$0;
        int i2 = R.id.bottomTabLayout;
        PGEditBottomTabLayout bottomTabLayout = (PGEditBottomTabLayout) editFragment3._$_findCachedViewById(i2);
        kotlin.jvm.internal.s.g(bottomTabLayout, "bottomTabLayout");
        String string = us.pinguo.foundation.e.b().getResources().getString(R.string.pg_sdk_edit_lightzone_class);
        kotlin.jvm.internal.s.g(string, "getAppContext().resource…sdk_edit_lightzone_class)");
        PGEditBottomTabLayout.h(bottomTabLayout, new String[]{string}, false, null, 6, null);
        ((PGEditBottomTabLayout) this.this$0._$_findCachedViewById(i2)).B();
        c0Var = this.this$0.f10516l;
        if (c0Var != null) {
            c0Var.E();
            adjustController2 = this.this$0.f10512h;
            if (adjustController2 != null) {
                adjustController2.show();
            }
            TextView textView = (TextView) this.this$0._$_findCachedViewById(R.id.txtSave);
            textView.setVisibility(4);
            VdsAgent.onSetViewVisibility(textView, 4);
            j1 = this.this$0.j1();
            j1.O(true);
            c0Var2 = this.this$0.f10516l;
            if (c0Var2 != null) {
                c0Var2.H(false);
                us.pinguo.foundation.statistics.h.b.K("edit_panel_adjustment", null, "click");
                return;
            }
            kotlin.jvm.internal.s.z("operationController");
            throw null;
        }
        kotlin.jvm.internal.s.z("operationController");
        throw null;
    }
}
