package us.pinguo.camera2020.develop;

import kotlin.jvm.internal.s;
/* compiled from: StickerTestUtil.kt */
/* loaded from: classes2.dex */
public final class d {
    private final String a;
    private final String b;

    public d(String name, String zip) {
        s.h(name, "name");
        s.h(zip, "zip");
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
        if (obj instanceof d) {
            d dVar = (d) obj;
            return s.c(this.a, dVar.a) && s.c(this.b, dVar.b);
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
