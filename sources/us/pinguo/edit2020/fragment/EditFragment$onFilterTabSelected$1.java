package us.pinguo.edit2020.fragment;

import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.internal.Lambda;
import us.pinguo.common.filter.controller.FilterController;
import us.pinguo.common.widget.tab.PGEditBottomTabLayout;
import us.pinguo.common.widget.tab.PGEditTabLayout;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.controller.EditFilterController;
import us.pinguo.edit2020.controller.z2;
import us.pinguo.edit2020.viewmodel.EditViewModel;
import us.pinguo.u3dengine.edit.EditModel;
/* compiled from: EditFragment.kt */
/* loaded from: classes4.dex */
final class EditFragment$onFilterTabSelected$1 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ PGEditTabLayout.f $tab;
    final /* synthetic */ EditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFragment$onFilterTabSelected$1(EditFragment editFragment, PGEditTabLayout.f fVar) {
        super(0);
        this.this$0 = editFragment;
        this.$tab = fVar;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        EditFilterController editFilterController;
        us.pinguo.edit2020.view.c0 c0Var;
        z2 z2Var;
        EditFilterController editFilterController2;
        EditViewModel j1;
        EditViewModel j12;
        this.this$0.f1(null, null);
        PGEditTabLayout.f fVar = this.$tab;
        Boolean bool = (Boolean) (fVar == null ? null : fVar.j());
        boolean booleanValue = bool == null ? true : bool.booleanValue();
        editFilterController = this.this$0.x;
        if (editFilterController != null) {
            FilterController.r1(editFilterController, false, booleanValue, 1, null);
        }
        TextView textView = (TextView) this.this$0._$_findCachedViewById(R.id.txtSave);
        textView.setVisibility(4);
        VdsAgent.onSetViewVisibility(textView, 4);
        c0Var = this.this$0.f10516l;
        if (c0Var != null) {
            c0Var.H(false);
            EditFragment editFragment = this.this$0;
            int i2 = R.id.bottomTabLayout;
            PGEditBottomTabLayout bottomTabLayout = (PGEditBottomTabLayout) editFragment._$_findCachedViewById(i2);
            kotlin.jvm.internal.s.g(bottomTabLayout, "bottomTabLayout");
            String string = this.this$0.getResources().getString(R.string.filter);
            kotlin.jvm.internal.s.g(string, "resources.getString(R.string.filter)");
            String[] strArr = {string};
            int i3 = R.color.white;
            PGEditBottomTabLayout.h(bottomTabLayout, strArr, false, Integer.valueOf(us.pinguo.edit2020.utils.d.h(i3)), 2, null);
            ((PGEditBottomTabLayout) this.this$0._$_findCachedViewById(i2)).F(us.pinguo.edit2020.utils.d.h(R.color.edit_filter_panel_color), us.pinguo.edit2020.utils.d.h(i3));
            ((PGEditBottomTabLayout) this.this$0._$_findCachedViewById(i2)).B();
            EditFragment editFragment2 = this.this$0;
            z2Var = editFragment2.y;
            editFragment2.z = z2Var;
            EditFragment editFragment3 = this.this$0;
            editFilterController2 = editFragment3.x;
            editFragment3.y = editFilterController2;
            this.this$0.A = null;
            j1 = this.this$0.j1();
            j1.i().n0(EditModel.Filter);
            j12 = this.this$0.j1();
            j12.O(true);
            us.pinguo.foundation.statistics.h.b.K("edit_panel_filter", null, "click");
            return;
        }
        kotlin.jvm.internal.s.z("operationController");
        throw null;
    }
}
