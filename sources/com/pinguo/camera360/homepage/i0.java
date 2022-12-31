package com.pinguo.camera360.homepage;

import us.pinguo.advconfigdata.database.AdvItem;
/* compiled from: FunctionItemInfo.kt */
/* loaded from: classes3.dex */
public final class i0 {
    private String a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private Object f6782d;

    /* renamed from: e  reason: collision with root package name */
    private String f6783e;

    /* renamed from: f  reason: collision with root package name */
    private String f6784f;

    /* renamed from: g  reason: collision with root package name */
    private int f6785g;

    /* renamed from: h  reason: collision with root package name */
    private int f6786h;

    /* renamed from: i  reason: collision with root package name */
    private int f6787i;

    /* renamed from: j  reason: collision with root package name */
    private final String f6788j;

    /* renamed from: k  reason: collision with root package name */
    private String f6789k;

    /* renamed from: l  reason: collision with root package name */
    private final us.pinguo.foundation.interaction.d f6790l;
    private AdvItem m;
    private String n;

    public i0(String str, String str2, String description, Object obj, String str3, String eventGoto, int i2, int i3, int i4, String advId, String type, us.pinguo.foundation.interaction.d dVar, AdvItem advItem, String str4) {
        boolean x;
        boolean x2;
        boolean x3;
        kotlin.jvm.internal.s.h(description, "description");
        kotlin.jvm.internal.s.h(eventGoto, "eventGoto");
        kotlin.jvm.internal.s.h(advId, "advId");
        kotlin.jvm.internal.s.h(type, "type");
        this.a = str;
        this.b = str2;
        this.c = description;
        this.f6782d = obj;
        this.f6783e = str3;
        this.f6784f = eventGoto;
        this.f6785g = i2;
        this.f6786h = i3;
        this.f6787i = i4;
        this.f6788j = advId;
        this.f6789k = type;
        this.f6790l = dVar;
        this.m = advItem;
        this.n = str4;
        boolean z = true;
        if (!(str == null || str.length() == 0)) {
            String str5 = this.a;
            kotlin.jvm.internal.s.e(str5);
            x3 = kotlin.text.t.x(str5, "#", false, 2, null);
            if (!x3) {
                this.a = kotlin.jvm.internal.s.q("#", this.a);
            }
        }
        String str6 = this.b;
        if (!(str6 == null || str6.length() == 0)) {
            String str7 = this.b;
            kotlin.jvm.internal.s.e(str7);
            x2 = kotlin.text.t.x(str7, "#", false, 2, null);
            if (!x2) {
                this.b = kotlin.jvm.internal.s.q("#", this.b);
            }
        }
        String str8 = this.n;
        if (str8 != null && str8.length() != 0) {
            z = false;
        }
        if (z) {
            return;
        }
        String str9 = this.n;
        kotlin.jvm.internal.s.e(str9);
        x = kotlin.text.t.x(str9, "#", false, 2, null);
        if (x) {
            return;
        }
        this.n = kotlin.jvm.internal.s.q("#", this.n);
    }

    public final String a() {
        return this.f6788j;
    }

    public final int b() {
        return this.f6787i;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.b;
    }

    public final int e() {
        return this.f6785g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i0) {
            i0 i0Var = (i0) obj;
            return kotlin.jvm.internal.s.c(this.a, i0Var.a) && kotlin.jvm.internal.s.c(this.b, i0Var.b) && kotlin.jvm.internal.s.c(this.c, i0Var.c) && kotlin.jvm.internal.s.c(this.f6782d, i0Var.f6782d) && kotlin.jvm.internal.s.c(this.f6783e, i0Var.f6783e) && kotlin.jvm.internal.s.c(this.f6784f, i0Var.f6784f) && this.f6785g == i0Var.f6785g && this.f6786h == i0Var.f6786h && this.f6787i == i0Var.f6787i && kotlin.jvm.internal.s.c(this.f6788j, i0Var.f6788j) && kotlin.jvm.internal.s.c(this.f6789k, i0Var.f6789k) && kotlin.jvm.internal.s.c(this.f6790l, i0Var.f6790l) && kotlin.jvm.internal.s.c(this.m, i0Var.m) && kotlin.jvm.internal.s.c(this.n, i0Var.n);
        }
        return false;
    }

    public final String f() {
        return this.f6784f;
    }

    public final us.pinguo.foundation.interaction.d g() {
        return this.f6790l;
    }

    public final Object h() {
        return this.f6782d;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.c.hashCode()) * 31;
        Object obj = this.f6782d;
        int hashCode3 = (hashCode2 + (obj == null ? 0 : obj.hashCode())) * 31;
        String str3 = this.f6783e;
        int hashCode4 = (((((((((((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f6784f.hashCode()) * 31) + this.f6785g) * 31) + this.f6786h) * 31) + this.f6787i) * 31) + this.f6788j.hashCode()) * 31) + this.f6789k.hashCode()) * 31;
        us.pinguo.foundation.interaction.d dVar = this.f6790l;
        int hashCode5 = (hashCode4 + (dVar == null ? 0 : dVar.hashCode())) * 31;
        AdvItem advItem = this.m;
        int hashCode6 = (hashCode5 + (advItem == null ? 0 : advItem.hashCode())) * 31;
        String str4 = this.n;
        return hashCode6 + (str4 != null ? str4.hashCode() : 0);
    }

    public final int i() {
        return this.f6786h;
    }

    public final String j() {
        return this.f6783e;
    }

    public final String k() {
        return this.a;
    }

    public final String l() {
        return this.n;
    }

    public final String m() {
        return this.f6789k;
    }

    public String toString() {
        return "FunctionItemInfo(startColor=" + ((Object) this.a) + ", endColor=" + ((Object) this.b) + ", description=" + this.c + ", iconRes=" + this.f6782d + ", picPath=" + ((Object) this.f6783e) + ", eventGoto=" + this.f6784f + ", entryPos=" + this.f6785g + ", iconType=" + this.f6786h + ", bgType=" + this.f6787i + ", advId=" + this.f6788j + ", type=" + this.f6789k + ", gotoBean=" + this.f6790l + ", statsAdvItem=" + this.m + ", textColor=" + ((Object) this.n) + ')';
    }

    public /* synthetic */ i0(String str, String str2, String str3, Object obj, String str4, String str5, int i2, int i3, int i4, String str6, String str7, us.pinguo.foundation.interaction.d dVar, AdvItem advItem, String str8, int i5, kotlin.jvm.internal.o oVar) {
        this(str, str2, str3, obj, str4, str5, i2, i3, i4, str6, str7, dVar, (i5 & 4096) != 0 ? null : advItem, (i5 & 8192) != 0 ? null : str8);
    }
}
