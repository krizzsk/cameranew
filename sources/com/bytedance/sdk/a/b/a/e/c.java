package com.bytedance.sdk.a.b.a.e;
/* compiled from: Header.java */
/* loaded from: classes.dex */
public final class c {
    public static final com.bytedance.sdk.a.a.f a = com.bytedance.sdk.a.a.f.a(":");
    public static final com.bytedance.sdk.a.a.f b = com.bytedance.sdk.a.a.f.a(":status");
    public static final com.bytedance.sdk.a.a.f c = com.bytedance.sdk.a.a.f.a(":method");

    /* renamed from: d  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f947d = com.bytedance.sdk.a.a.f.a(":path");

    /* renamed from: e  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f948e = com.bytedance.sdk.a.a.f.a(":scheme");

    /* renamed from: f  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f949f = com.bytedance.sdk.a.a.f.a(":authority");

    /* renamed from: g  reason: collision with root package name */
    public final com.bytedance.sdk.a.a.f f950g;

    /* renamed from: h  reason: collision with root package name */
    public final com.bytedance.sdk.a.a.f f951h;

    /* renamed from: i  reason: collision with root package name */
    final int f952i;

    public c(String str, String str2) {
        this(com.bytedance.sdk.a.a.f.a(str), com.bytedance.sdk.a.a.f.a(str2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.f950g.equals(cVar.f950g) && this.f951h.equals(cVar.f951h);
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f950g.hashCode()) * 31) + this.f951h.hashCode();
    }

    public String toString() {
        return com.bytedance.sdk.a.b.a.c.a("%s: %s", this.f950g.a(), this.f951h.a());
    }

    public c(com.bytedance.sdk.a.a.f fVar, String str) {
        this(fVar, com.bytedance.sdk.a.a.f.a(str));
    }

    public c(com.bytedance.sdk.a.a.f fVar, com.bytedance.sdk.a.a.f fVar2) {
        this.f950g = fVar;
        this.f951h = fVar2;
        this.f952i = fVar.g() + 32 + fVar2.g();
    }
}
