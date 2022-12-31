package us.pinguo.edit2020.fragment;

import kotlin.jvm.internal.Lambda;
import us.pinguo.common.widget.tab.PGEditBottomTabLayout;
import us.pinguo.edit2020.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditFragment.kt */
/* loaded from: classes4.dex */
public final class EditFragment$checkEditController$4 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ EditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFragment$checkEditController$4(EditFragment editFragment) {
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
        PGEditBottomTabLayout bottomTabLayout = (PGEditBottomTabLayout) this.this$0._$_findCachedViewById(R.id.bottomTabLayout);
        kotlin.jvm.internal.s.g(bottomTabLayout, "bottomTabLayout");
        PGEditBottomTabLayout.A(bottomTabLayout, R.id.pg_edit_first_menu_edit, false, 2, null);
    }
}
