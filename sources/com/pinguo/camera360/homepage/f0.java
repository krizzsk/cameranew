package com.pinguo.camera360.homepage;

import us.pinguo.advconfigdata.database.AdvItem;
/* compiled from: FunctionItemInfo.kt */
/* loaded from: classes3.dex */
public final class f0 {
    private Object a;
    private String b;
    private final String c;

    /* renamed from: d  reason: collision with root package name */
    private String f6777d;

    /* renamed from: e  reason: collision with root package name */
    private final us.pinguo.foundation.interaction.d f6778e;

    /* renamed from: f  reason: collision with root package name */
    private AdvItem f6779f;

    public f0(Object iconPath, String eventGoto, String advId, String advType, us.pinguo.foundation.interaction.d dVar, AdvItem advItem) {
        kotlin.jvm.internal.s.h(iconPath, "iconPath");
        kotlin.jvm.internal.s.h(eventGoto, "eventGoto");
        kotlin.jvm.internal.s.h(advId, "advId");
        kotlin.jvm.internal.s.h(advType, "advType");
        this.a = iconPath;
        this.b = eventGoto;
        this.c = advId;
        this.f6777d = advType;
        this.f6778e = dVar;
        this.f6779f = advItem;
    }

    public final String a() {
        return this.c;
    }

    public final String b() {
        return this.f6777d;
    }

    public final String c() {
        return this.b;
    }

    public final us.pinguo.foundation.interaction.d d() {
        return this.f6778e;
    }

    public final Object e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f0) {
            f0 f0Var = (f0) obj;
            return kotlin.jvm.internal.s.c(this.a, f0Var.a) && kotlin.jvm.internal.s.c(this.b, f0Var.b) && kotlin.jvm.internal.s.c(this.c, f0Var.c) && kotlin.jvm.internal.s.c(this.f6777d, f0Var.f6777d) && kotlin.jvm.internal.s.c(this.f6778e, f0Var.f6778e) && kotlin.jvm.internal.s.c(this.f6779f, f0Var.f6779f);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.f6777d.hashCode()) * 31;
        us.pinguo.foundation.interaction.d dVar = this.f6778e;
        int hashCode2 = (hashCode + (dVar == null ? 0 : dVar.hashCode())) * 31;
        AdvItem advItem = this.f6779f;
        return hashCode2 + (advItem != null ? advItem.hashCode() : 0);
    }

    public String toString() {
        return "BannerItemInfo(iconPath=" + this.a + ", eventGoto=" + this.b + ", advId=" + this.c + ", advType=" + this.f6777d + ", gotoInfo=" + this.f6778e + ", statsAdvItem=" + this.f6779f + ')';
    }
}
