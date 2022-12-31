package us.pinguo.edit2020.bean;

import us.pinguo.edit2020.bean.x;
import us.pinguo.repository2020.entity.BackgroundBlur;
/* compiled from: BackgroundBlurFunction.kt */
/* loaded from: classes4.dex */
public final class d implements x {
    private final BackgroundBlur a;

    public d(BackgroundBlur backgroundBlur) {
        this.a = backgroundBlur;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean a() {
        Integer vip;
        BackgroundBlur backgroundBlur = this.a;
        return (backgroundBlur == null || (vip = backgroundBlur.getVip()) == null || vip.intValue() != 1) ? false : true;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean b() {
        return x.a.a(this);
    }

    @Override // us.pinguo.edit2020.bean.x
    public String c() {
        String name;
        BackgroundBlur backgroundBlur = this.a;
        return (backgroundBlur == null || (name = backgroundBlur.getName()) == null) ? "" : name;
    }

    @Override // us.pinguo.edit2020.bean.x
    public int d() {
        return 0;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean e() {
        return true;
    }

    @Override // us.pinguo.edit2020.bean.x
    public String f() {
        String pid;
        BackgroundBlur backgroundBlur = this.a;
        return (backgroundBlur == null || (pid = backgroundBlur.getPid()) == null) ? "" : pid;
    }
}
