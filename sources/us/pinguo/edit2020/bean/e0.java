package us.pinguo.edit2020.bean;

import us.pinguo.edit2020.bean.x;
import us.pinguo.repository2020.entity.Mosaic;
/* compiled from: MosaicFunction.kt */
/* loaded from: classes4.dex */
public final class e0 implements x {
    private final Mosaic a;

    public e0(Mosaic mosaic) {
        kotlin.jvm.internal.s.h(mosaic, "mosaic");
        this.a = mosaic;
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
        return (obj instanceof e0) && kotlin.jvm.internal.s.c(this.a, ((e0) obj).a);
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
        return "MosaicFunction(mosaic=" + this.a + ')';
    }
}
