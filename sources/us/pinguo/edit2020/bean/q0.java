package us.pinguo.edit2020.bean;

import us.pinguo.edit2020.bean.x;
import us.pinguo.repository2020.database.staticsticker.StaticSticker;
/* compiled from: StickerFunction.kt */
/* loaded from: classes4.dex */
public final class q0 implements x {
    private final StaticSticker a;
    private final boolean b;
    private final String c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10246d;

    public q0(StaticSticker sticker, boolean z) {
        kotlin.jvm.internal.s.h(sticker, "sticker");
        this.a = sticker;
        this.b = z;
        this.c = toString();
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean a() {
        return this.b;
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
        String sid = this.a.getSid();
        return sid == null ? "" : sid;
    }

    public final boolean g() {
        return this.f10246d;
    }

    public final String h() {
        return this.c;
    }

    public final StaticSticker i() {
        return this.a;
    }

    public final void j(boolean z) {
        this.f10246d = z;
    }
}
