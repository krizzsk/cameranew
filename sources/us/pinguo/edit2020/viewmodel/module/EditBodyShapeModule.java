package us.pinguo.edit2020.viewmodel.module;

import android.content.Context;
import android.content.res.Resources;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.k;
import us.pinguo.edit2020.bean.p;
import us.pinguo.edit2020.bean.u0;
import us.pinguo.edit2020.bean.x;
import us.pinguo.edit2020.model.EditRender;
import us.pinguo.repository2020.u;
import us.pinguo.repository2020.utils.o;
import us.pinguo.u3dengine.edit.UnityEditCaller;
import us.pinguo.util.h;
/* compiled from: EditBodyShapeModule.kt */
/* loaded from: classes4.dex */
public final class EditBodyShapeModule {
    private final EditRender a;
    private final ArrayList<k> b;
    private u<k> c;

    /* renamed from: d  reason: collision with root package name */
    private u<c> f10860d;

    public EditBodyShapeModule(EditRender render) {
        s.h(render, "render");
        this.a = render;
        this.b = new ArrayList<>();
        this.c = new u<>();
        this.f10860d = new u<>();
    }

    private final void g() {
        Resources resources = us.pinguo.foundation.e.b().getResources();
        String string = resources.getString(R.string.key_push);
        s.g(string, "res.getString(R.string.key_push)");
        String string2 = resources.getString(R.string.shape);
        s.g(string2, "res.getString(R.string.shape)");
        k kVar = new k(string, string2, R.drawable.ic_edit_shape, false);
        kVar.x(false);
        kVar.r(BoldType.BOLD_PUSH_BOLD);
        kVar.A(resources.getDimension(R.dimen.body_shape_line_width) * 2);
        kVar.y(new EditBodyShapeModule$initFunctions$1(this));
        this.b.add(kVar);
        String string3 = resources.getString(R.string.key_narrow);
        s.g(string3, "res.getString(R.string.key_narrow)");
        String string4 = resources.getString(R.string.narrow);
        s.g(string4, "res.getString(R.string.narrow)");
        p pVar = new p(string3, string4, R.drawable.ic_edit_narrow, true);
        pVar.y(EditBodyShapeModule$initFunctions$2.INSTANCE);
        pVar.r(BoldType.BOLD_NARROW);
        String string5 = us.pinguo.foundation.e.b().getString(R.string.press_to_narrow);
        s.g(string5, "getAppContext().getStrin…R.string.press_to_narrow)");
        pVar.t(string5);
        this.b.add(pVar);
        String string6 = resources.getString(R.string.key_expand);
        s.g(string6, "res.getString(R.string.key_expand)");
        String string7 = resources.getString(R.string.swell);
        s.g(string7, "res.getString(R.string.swell)");
        p pVar2 = new p(string6, string7, R.drawable.ic_edit_swell, true);
        pVar2.y(EditBodyShapeModule$initFunctions$3.INSTANCE);
        pVar2.r(BoldType.BOLD_SWELL);
        String string8 = us.pinguo.foundation.e.b().getString(R.string.press_to_expand);
        s.g(string8, "getAppContext().getStrin…R.string.press_to_expand)");
        pVar2.t(string8);
        this.b.add(pVar2);
        us.pinguo.edit2020.bean.b bVar = new us.pinguo.edit2020.bean.b();
        BoldType g2 = bVar.g();
        BoldType boldType = BoldType.BOLD;
        g2.setBrushSize(boldType.getBrushSize());
        bVar.g().setIndicatorSize(boldType.getIndicatorSize());
        bVar.g().setScaleFactor(boldType.getScaleFactor());
        c B = bVar.B();
        B.f(bVar.g());
        B.g(bVar.g().getScaleFactor());
        B.h(BoldType.BOLD3.getIndicatorSize());
        this.b.add(bVar);
        String string9 = resources.getString(R.string.key_reduction);
        s.g(string9, "res.getString(R.string.key_reduction)");
        String string10 = resources.getString(R.string.recover);
        s.g(string10, "res.getString(R.string.recover)");
        k kVar2 = new k(string9, string10, R.drawable.ic_edit_recover, false);
        String string11 = us.pinguo.foundation.e.b().getString(R.string.tap_to_restore);
        s.g(string11, "getAppContext().getString(R.string.tap_to_restore)");
        kVar2.t(string11);
        kVar2.y(EditBodyShapeModule$initFunctions$4.INSTANCE);
        this.b.add(kVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float i() {
        u0 value = this.a.L().getValue();
        return (((value == null ? 1.0f : value.e() / value.f()) * 0.2222f) + 0.7778f) * 0.12f;
    }

    public final void b(boolean z) {
        this.a.n1(z);
    }

    public final u<c> c() {
        return this.f10860d;
    }

    public final u<k> d() {
        return this.c;
    }

    public final List<k> e() {
        if (this.b.isEmpty()) {
            g();
        }
        return this.b;
    }

    public final u0 f() {
        return this.a.L().getValue();
    }

    public final boolean h(x function) {
        s.h(function, "function");
        return o.b(o.a, function.f(), true, null, 4, null);
    }

    public final void j(String records) {
        List<String> o0;
        Integer h2;
        s.h(records, "records");
        o0 = StringsKt__StringsKt.o0(records, new char[]{','}, false, 0, 6, null);
        for (String str : o0) {
            h2 = kotlin.text.s.h(str);
            if (h2 != null && h2.intValue() == 7) {
                e().get(0).q(true);
            } else if (h2 != null && h2.intValue() == 6) {
                e().get(1).q(true);
            } else if (h2 != null && h2.intValue() == 4) {
                e().get(2).q(true);
            } else if (h2 != null && h2.intValue() == 5) {
                e().get(3).q(true);
            } else if (h2 != null && h2.intValue() == 3) {
                e().get(4).q(true);
            }
        }
    }

    public final void k() {
        this.a.reportMagnifierRenderer();
    }

    public final void l() {
        float floatValue;
        Context context = us.pinguo.foundation.e.b();
        for (k kVar : e()) {
            kVar.q(false);
            u0 f2 = f();
            Float valueOf = f2 == null ? null : Float.valueOf(f2.h());
            if (valueOf == null) {
                s.g(context, "context");
                floatValue = h.i(context);
            } else {
                floatValue = valueOf.floatValue();
            }
            if (kVar instanceof p) {
                p pVar = (p) kVar;
                float C = pVar.C() * 2.0f;
                kVar.g().setBrushSize(C / floatValue);
                kVar.g().setScaleFactor(kVar.g().getBrushSize());
                kVar.g().setIndicatorSize(C);
                pVar.G(pVar.C());
                pVar.B().x = Float.NaN;
                pVar.B().y = Float.NaN;
            } else if (s.c(kVar.f(), context.getString(R.string.key_push))) {
                kVar.r(BoldType.BOLD_PUSH_BOLD);
            } else {
                kVar.r(BoldType.BOLD);
                if (kVar instanceof us.pinguo.edit2020.bean.b) {
                    ((us.pinguo.edit2020.bean.b) kVar).D(0);
                }
            }
            kVar.z(null);
            kVar.s(null);
            kVar.w(null);
            kVar.v(null);
        }
        this.c.setValue(null);
        this.f10860d.setValue(null);
    }

    public final void m(float f2, float f3) {
        UnityEditCaller.Common.INSTANCE.setMagnifierPosition(f2, f3);
    }

    public final void n(int i2) {
        UnityEditCaller.Common.INSTANCE.setMagnifierRenderUpdateMode(i2);
    }
}
