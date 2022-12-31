package com.pinguo.camera360.test;
/* compiled from: UnityImportActivity.kt */
/* loaded from: classes3.dex */
public final class v0 {
    private final String a;
    private final String b;

    public v0(String name, String zip) {
        kotlin.jvm.internal.s.h(name, "name");
        kotlin.jvm.internal.s.h(zip, "zip");
        this.a = name;
        this.b = zip;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof v0) {
            v0 v0Var = (v0) obj;
            return kotlin.jvm.internal.s.c(this.a, v0Var.a) && kotlin.jvm.internal.s.c(this.b, v0Var.b);
        }
        return false;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "UnityInfo(name=" + this.a + ", zip=" + this.b + ')';
    }
}
