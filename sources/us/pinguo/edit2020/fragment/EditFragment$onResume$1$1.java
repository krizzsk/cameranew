package us.pinguo.edit2020.fragment;

import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.viewmodel.EditViewModel;
/* compiled from: EditFragment.kt */
/* loaded from: classes4.dex */
final class EditFragment$onResume$1$1 extends Lambda implements kotlin.jvm.b.l<String, kotlin.u> {
    final /* synthetic */ EditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFragment$onResume$1$1(EditFragment editFragment) {
        super(1);
        this.this$0 = editFragment;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(String str) {
        invoke2(str);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String path) {
        EditViewModel j1;
        kotlin.jvm.internal.s.h(path, "path");
        j1 = this.this$0.j1();
        List<us.pinguo.edit2020.bean.x> i2 = j1.j().a().i();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
        if (i2 != null) {
            for (us.pinguo.edit2020.bean.x xVar : i2) {
                if (xVar instanceof us.pinguo.edit2020.bean.c) {
                    linkedHashSet.add("edit_panel_instant_beauty");
                } else if (xVar instanceof us.pinguo.edit2020.bean.r) {
                    linkedHashSet.add("edit_panel_facial_remodel");
                } else if (xVar instanceof us.pinguo.edit2020.bean.k) {
                    linkedHashSet.add("edit_panel_face_lift");
                } else if (xVar instanceof us.pinguo.edit2020.bean.a) {
                    linkedHashSet.add("edit_panel_adjustment");
                } else if (xVar instanceof us.pinguo.edit2020.bean.s) {
                    linkedHashSet.add("edit_panel_filter");
                } else if (xVar instanceof us.pinguo.edit2020.bean.m) {
                    linkedHashSet.add("edit_panel_tailor");
                } else if (xVar instanceof us.pinguo.edit2020.bean.e0) {
                    linkedHashSet.add("edit_panel_mosaic");
                } else if (xVar instanceof us.pinguo.edit2020.bean.j) {
                    linkedHashSet.add("edit_save_blur");
                } else if (xVar instanceof us.pinguo.edit2020.bean.u) {
                    linkedHashSet.add("edit_panel_graffiti");
                } else if (xVar instanceof us.pinguo.edit2020.bean.j0 ? true : xVar instanceof us.pinguo.edit2020.bean.s0) {
                    linkedHashSet.add("edit_panel_makeup");
                } else if (xVar instanceof us.pinguo.edit2020.bean.o) {
                    linkedHashSet.add("edit_remover");
                } else if (xVar instanceof us.pinguo.edit2020.bean.f) {
                    linkedHashSet.add("edit_panel_backdrop ");
                } else if (xVar instanceof us.pinguo.edit2020.bean.q) {
                    linkedHashSet.add("edit_panel_facial_contour");
                } else if (xVar instanceof us.pinguo.edit2020.bean.q0) {
                    linkedHashSet.add("edit_panel_sticker");
                } else if (xVar instanceof us.pinguo.edit2020.bean.i) {
                    String b = us.pinguo.edit2020.bean.o0.b(xVar.f(), xVar.c());
                    if (b.length() > 0) {
                        linkedHashSet.add(b);
                    }
                } else if (xVar instanceof us.pinguo.edit2020.bean.d0 ? true : xVar instanceof us.pinguo.edit2020.bean.n0) {
                    linkedHashSet.add("edit_panel_skin_refreshing");
                }
            }
        }
        for (String str : linkedHashSet) {
            us.pinguo.foundation.statistics.h.b.v(str, path);
        }
    }
}
