package us.pinguo.foundation.interaction;

import kotlin.jvm.internal.s;
/* compiled from: GotoBean.kt */
/* loaded from: classes4.dex */
public final class d {
    private String a;
    private final String b;
    private final Integer c;

    /* renamed from: d  reason: collision with root package name */
    private final String f11014d;

    /* renamed from: e  reason: collision with root package name */
    private final Boolean f11015e;

    public d(String str, String str2, Integer num, String str3, Boolean bool) {
        this.a = str;
        this.b = str2;
        this.c = num;
        this.f11014d = str3;
        this.f11015e = bool;
    }

    public final Integer a() {
        return this.c;
    }

    public final String b() {
        return this.b;
    }

    public final Boolean c() {
        return this.f11015e;
    }

    public final String d() {
        return this.a;
    }

    public final String e() {
        return this.f11014d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return s.c(this.a, dVar.a) && s.c(this.b, dVar.b) && s.c(this.c, dVar.c) && s.c(this.f11014d, dVar.f11014d) && s.c(this.f11015e, dVar.f11015e);
        }
        return false;
    }

    public final void f(String str) {
        this.a = str;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.c;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.f11014d;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.f11015e;
        return hashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "GotoBean(interactionUri=" + ((Object) this.a) + ", advType=" + ((Object) this.b) + ", advProvider=" + this.c + ", mvId=" + ((Object) this.f11014d) + ", forceInnerBrowser=" + this.f11015e + ')';
    }
}
