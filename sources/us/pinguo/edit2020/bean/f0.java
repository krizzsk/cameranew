package us.pinguo.edit2020.bean;

import java.util.ArrayList;
import java.util.Collection;
import us.pinguo.u3dengine.edit.ColorOptionMode;
/* compiled from: AdjustFunction.kt */
/* loaded from: classes4.dex */
public final class f0 extends a {

    /* renamed from: j  reason: collision with root package name */
    private final ArrayList<g0> f10191j;

    /* renamed from: k  reason: collision with root package name */
    private int f10192k;

    /* renamed from: l  reason: collision with root package name */
    private ColorOptionMode f10193l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(String key, String name, int i2, int i3, int i4, int i5, boolean z) {
        super(key, name, i2, i3, i4, i5, z);
        kotlin.jvm.internal.s.h(key, "key");
        kotlin.jvm.internal.s.h(name, "name");
        this.f10191j = new ArrayList<>();
        this.f10193l = ColorOptionMode.Absolute;
    }

    @Override // us.pinguo.edit2020.bean.a, us.pinguo.edit2020.bean.x
    public boolean e() {
        boolean z;
        ArrayList<g0> arrayList = this.f10191j;
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            for (g0 g0Var : arrayList) {
                if (g0Var.h().b() == h() && g0Var.k().b() == h() && g0Var.m().b() == h() && g0Var.g().b() == h()) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void n(f0 dest) {
        kotlin.jvm.internal.s.h(dest, "dest");
        dest.m(k());
        dest.l(g());
        dest.f10192k = this.f10192k;
        dest.f10193l = this.f10193l;
        dest.f10191j.clear();
        for (g0 g0Var : this.f10191j) {
            dest.o().add(new g0(g0Var.j(), g0Var.l(), g0Var.c(), g0Var.b(), g0Var.d(), new h0(g0Var.h().a(), g0Var.h().b()), new h0(g0Var.k().a(), g0Var.k().b()), new h0(g0Var.m().a(), g0Var.m().b()), new h0(g0Var.g().a(), g0Var.g().b()), g0Var.i()));
        }
    }

    public final ArrayList<g0> o() {
        return this.f10191j;
    }

    public final int p() {
        return this.f10192k;
    }

    public final ColorOptionMode q() {
        return this.f10193l;
    }

    public final void r(int i2) {
        this.f10192k = i2;
    }

    public final void s(ColorOptionMode colorOptionMode) {
        kotlin.jvm.internal.s.h(colorOptionMode, "<set-?>");
        this.f10193l = colorOptionMode;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(f0 src) {
        super(src.f(), src.c(), src.d(), src.h(), src.j(), src.i(), src.a());
        kotlin.jvm.internal.s.h(src, "src");
        this.f10191j = new ArrayList<>();
        this.f10193l = ColorOptionMode.Absolute;
        src.n(this);
    }
}
