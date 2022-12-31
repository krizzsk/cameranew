package us.pinguo.edit2020.bean;

import java.util.ArrayList;
import java.util.Collection;
/* compiled from: AdjustFunction.kt */
/* loaded from: classes4.dex */
public final class v extends a {

    /* renamed from: j  reason: collision with root package name */
    private int f10253j;

    /* renamed from: k  reason: collision with root package name */
    private final ArrayList<w> f10254k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(String key, String name, int i2, int i3, int i4, int i5, boolean z) {
        super(key, name, i2, i3, i4, i5, z);
        kotlin.jvm.internal.s.h(key, "key");
        kotlin.jvm.internal.s.h(name, "name");
        this.f10254k = new ArrayList<>();
    }

    @Override // us.pinguo.edit2020.bean.a, us.pinguo.edit2020.bean.x
    public boolean e() {
        boolean z;
        ArrayList<w> arrayList = this.f10254k;
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            for (w wVar : arrayList) {
                if (wVar.g() == h() && wVar.h() == h() && wVar.i() == h()) {
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

    public final void n(v des) {
        kotlin.jvm.internal.s.h(des, "des");
        des.m(k());
        des.l(g());
        des.f10253j = this.f10253j;
        des.f10254k.clear();
        for (w wVar : this.f10254k) {
            w wVar2 = new w(wVar.c(), wVar.m(), wVar.j(), wVar.k(), wVar.l());
            wVar2.n(wVar.g());
            wVar2.o(wVar.h());
            wVar2.p(wVar.i());
            des.o().add(wVar2);
        }
    }

    public final ArrayList<w> o() {
        return this.f10254k;
    }

    public final int p() {
        return this.f10253j;
    }

    public final void q(int i2) {
        this.f10253j = i2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(v src) {
        super(src.f(), src.c(), src.d(), src.h(), src.j(), src.i(), src.a());
        kotlin.jvm.internal.s.h(src, "src");
        this.f10254k = new ArrayList<>();
        src.n(this);
    }
}
