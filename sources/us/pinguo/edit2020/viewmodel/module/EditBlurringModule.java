package us.pinguo.edit2020.viewmodel.module;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.b.t;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.BlurringType;
import us.pinguo.edit2020.bean.j;
import us.pinguo.edit2020.bean.l0;
import us.pinguo.edit2020.bean.u0;
import us.pinguo.edit2020.model.EditRender;
import us.pinguo.u3dengine.edit.EditModel;
import us.pinguo.util.h;
/* compiled from: EditBlurringModule.kt */
/* loaded from: classes4.dex */
public final class EditBlurringModule {
    private final EditRender a;
    private final ArrayList<j> b;
    private j c;

    public EditBlurringModule(EditRender render) {
        s.h(render, "render");
        this.a = render;
        this.b = new ArrayList<>();
    }

    public final void a() {
        this.a.o(EditModel.Blur);
    }

    public final float b(int i2) {
        Context context = us.pinguo.foundation.e.b();
        s.g(context, "context");
        return (i2 * 3.0f) + us.pinguo.util.g.b(context, 30.0f);
    }

    public final void c(boolean z) {
        this.a.n1(z);
    }

    public final j d() {
        return this.c;
    }

    public final List<j> e() {
        float floatValue;
        float floatValue2;
        if (this.b.isEmpty()) {
            Context context = us.pinguo.foundation.e.b();
            String string = context.getResources().getString(R.string.key_blurring_oval);
            s.g(string, "context.resources.getStr…string.key_blurring_oval)");
            String string2 = context.getResources().getString(R.string.name_blurring_oval);
            s.g(string2, "context.resources.getStr…tring.name_blurring_oval)");
            j jVar = new j(string, string2, false, 0, 100, 0, 100, BlurringType.Oval);
            jVar.s(EditBlurringModule$functions$1.INSTANCE);
            this.b.add(jVar);
            String string3 = context.getResources().getString(R.string.key_blurring_line);
            s.g(string3, "context.resources.getStr…string.key_blurring_line)");
            String string4 = context.getResources().getString(R.string.name_blurring_line);
            s.g(string4, "context.resources.getStr…tring.name_blurring_line)");
            j jVar2 = new j(string3, string4, false, 0, 100, 0, 100, BlurringType.Line);
            jVar2.l().p(l0.f10223j.a());
            jVar2.l().q(b(jVar2.h()));
            l0 l2 = jVar2.l();
            u0 f2 = f();
            Float valueOf = f2 == null ? null : Float.valueOf(f2.h());
            if (valueOf == null) {
                s.g(context, "context");
                floatValue = h.i(context);
            } else {
                floatValue = valueOf.floatValue();
            }
            l2.n(floatValue * 0.5f);
            l0 l3 = jVar2.l();
            u0 f3 = f();
            Float valueOf2 = f3 != null ? Float.valueOf(f3.g()) : null;
            if (valueOf2 == null) {
                s.g(context, "context");
                floatValue2 = h.g(context);
            } else {
                floatValue2 = valueOf2.floatValue();
            }
            l3.o(floatValue2 * 0.5f);
            jVar2.s(EditBlurringModule$functions$2.INSTANCE);
            this.b.add(jVar2);
        }
        return this.b;
    }

    public final u0 f() {
        return this.a.L().getValue();
    }

    public final void g() {
        for (j jVar : e()) {
            jVar.t(jVar.h());
            jVar.r(jVar.g());
        }
    }

    public final float h(int i2, float f2, float f3) {
        Context context = us.pinguo.foundation.e.b();
        s.g(context, "context");
        return us.pinguo.util.g.b(context, 30.0f) + f2 + (i2 * 10.0f * (f2 / (f3 * 5.0f)));
    }

    public final float i(int i2, float f2, float f3) {
        Context context = us.pinguo.foundation.e.b();
        s.g(context, "context");
        return us.pinguo.util.g.b(context, 30.0f) + f3 + (i2 * 10.0f * (f3 / (f2 * 5.0f)));
    }

    public final void j() {
        float floatValue;
        float floatValue2;
        j jVar = this.b.get(0);
        s.g(jVar, "_functions[0]");
        j jVar2 = jVar;
        jVar2.t(0);
        jVar2.r(0);
        j jVar3 = this.b.get(1);
        s.g(jVar3, "_functions[1]");
        j jVar4 = jVar3;
        jVar4.t(0);
        jVar4.r(0);
        jVar4.l().q(b(jVar4.h()));
        jVar4.l().p(l0.f10223j.a());
        Context context = us.pinguo.foundation.e.b();
        l0 l2 = jVar4.l();
        u0 f2 = f();
        Float valueOf = f2 == null ? null : Float.valueOf(f2.h());
        if (valueOf == null) {
            s.g(context, "context");
            floatValue = h.i(context);
        } else {
            floatValue = valueOf.floatValue();
        }
        l2.n(floatValue * 0.5f);
        l0 l3 = jVar4.l();
        u0 f3 = f();
        Float valueOf2 = f3 != null ? Float.valueOf(f3.g()) : null;
        if (valueOf2 == null) {
            s.g(context, "context");
            floatValue2 = h.g(context);
        } else {
            floatValue2 = valueOf2.floatValue();
        }
        l3.o(floatValue2 * 0.5f);
    }

    public final void k(j jVar) {
        this.c = jVar;
    }

    public final void l(t<? super Boolean, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, u> callback) {
        s.h(callback, "callback");
        this.a.c0(callback);
    }
}
