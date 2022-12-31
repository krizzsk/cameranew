package us.pinguo.edit2020.bean;

import us.pinguo.edit2020.bean.x;
import us.pinguo.repository2020.database.staticsticker.Template;
/* compiled from: TemplateFunction.kt */
/* loaded from: classes4.dex */
public final class t0 implements x {
    private final Template a;

    public t0(Template template) {
        kotlin.jvm.internal.s.h(template, "template");
        this.a = template;
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
        return name == null ? "" : name;
    }

    @Override // us.pinguo.edit2020.bean.x
    public int d() {
        return -1;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean e() {
        return true;
    }

    @Override // us.pinguo.edit2020.bean.x
    public String f() {
        String tid = this.a.getTid();
        return tid == null ? "" : tid;
    }

    public final Template g() {
        return this.a;
    }
}
