package us.pinguo.edit2020.bean;

import us.pinguo.edit2020.bean.x;
import us.pinguo.repository2020.database.staticsticker.StaticStickerCategory;
/* compiled from: StickerPackageFunction.kt */
/* loaded from: classes4.dex */
public final class r0 implements x {
    private final StaticStickerCategory a;

    public r0(StaticStickerCategory stickerCategory) {
        kotlin.jvm.internal.s.h(stickerCategory, "stickerCategory");
        this.a = stickerCategory;
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
        String pid = this.a.getPid();
        return pid == null ? "" : pid;
    }
}
