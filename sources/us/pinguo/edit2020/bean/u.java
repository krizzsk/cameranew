package us.pinguo.edit2020.bean;

import us.pinguo.edit2020.bean.x;
import us.pinguo.repository2020.entity.Graffiti;
/* compiled from: GraffitiFunction.kt */
/* loaded from: classes4.dex */
public final class u implements x {
    private final Graffiti a;

    public u(Graffiti graffiti) {
        kotlin.jvm.internal.s.h(graffiti, "graffiti");
        this.a = graffiti;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean a() {
        Integer vip = this.a.getVip();
        return vip != null && vip.intValue() == 1;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean b() {
        return x.a.a(this);
    }

    @Override // us.pinguo.edit2020.bean.x
    public String c() {
        String name = this.a.getName();
        kotlin.jvm.internal.s.e(name);
        return name;
    }

    @Override // us.pinguo.edit2020.bean.x
    public int d() {
        return 0;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean e() {
        return this.a.getApplied();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof u) && kotlin.jvm.internal.s.c(this.a, ((u) obj).a);
    }

    @Override // us.pinguo.edit2020.bean.x
    public String f() {
        String pid = this.a.getPid();
        kotlin.jvm.internal.s.e(pid);
        return pid;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "GraffitiFunction(graffiti=" + this.a + ')';
    }
}
