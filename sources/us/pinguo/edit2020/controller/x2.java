package us.pinguo.edit2020.controller;

import android.view.MotionEvent;
import android.view.ViewGroup;
import java.util.List;
import us.pinguo.edit2020.controller.i3;
import us.pinguo.edit2020.model.editgoto.EditGotoType;
import us.pinguo.edit2020.viewmodel.AIEditViewModel;
/* compiled from: AIEditController.kt */
/* loaded from: classes4.dex */
public final class x2 implements i3, e3, c3 {
    private final ViewGroup a;
    private final ImageRestorationController b;
    private i3 c;

    /* compiled from: AIEditController.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EditGotoType.values().length];
            iArr[EditGotoType.IMAGE_RESTORARION.ordinal()] = 1;
            a = iArr;
        }
    }

    public x2(ViewGroup fragmentLayout, AIEditViewModel aiEditViewModel) {
        kotlin.jvm.internal.s.h(fragmentLayout, "fragmentLayout");
        kotlin.jvm.internal.s.h(aiEditViewModel, "aiEditViewModel");
        this.a = fragmentLayout;
        aiEditViewModel.c().b().j(aiEditViewModel.d());
        this.b = new ImageRestorationController(fragmentLayout, aiEditViewModel.c().b());
    }

    @Override // us.pinguo.edit2020.controller.z2
    public EditTabType F() {
        return EditTabType.AI_EDIT;
    }

    @Override // us.pinguo.edit2020.controller.c3
    public boolean L(us.pinguo.edit2020.model.editgoto.b editGoto) {
        kotlin.jvm.internal.s.h(editGoto, "editGoto");
        if (a.a[editGoto.a().ordinal()] == 1) {
            this.b.L(editGoto);
            this.c = this.b;
        }
        return true;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean R() {
        i3 i3Var = this.c;
        return i3Var != null && i3Var.R();
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean S() {
        return i3.a.c(this);
    }

    @Override // us.pinguo.edit2020.controller.e3
    public boolean b(MotionEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        return false;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void d() {
        i3 i3Var = this.c;
        if (i3Var == null) {
            return;
        }
        i3Var.d();
    }

    @Override // us.pinguo.edit2020.controller.i3, us.pinguo.edit2020.controller.z2
    public boolean f() {
        i3 i3Var = this.c;
        return i3Var != null && i3Var.f();
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void g() {
        i3 i3Var = this.c;
        if (i3Var == null) {
            return;
        }
        i3Var.g();
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean onBackPressed() {
        return i3.a.d(this);
    }

    @Override // us.pinguo.edit2020.controller.i3
    public void u(us.pinguo.edit2020.model.editgoto.b bVar) {
        EditGotoType a2 = bVar == null ? null : bVar.a();
        if (a2 != null) {
            int i2 = a.a[a2.ordinal()];
        }
        this.b.u(bVar);
        this.c = this.b;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public List<us.pinguo.edit2020.bean.x> v() {
        i3 i3Var = this.c;
        if (i3Var == null) {
            return null;
        }
        return i3Var.v();
    }
}
