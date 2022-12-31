package com.google.android.gms.ads.internal.util;

import com.google.android.gms.common.internal.p;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaw {
    private final double a;
    private final double b;
    public final int count;
    public final String name;
    public final double zzega;

    public zzaw(String str, double d2, double d3, double d4, int i2) {
        this.name = str;
        this.b = d2;
        this.a = d3;
        this.zzega = d4;
        this.count = i2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzaw) {
            zzaw zzawVar = (zzaw) obj;
            return com.google.android.gms.common.internal.p.a(this.name, zzawVar.name) && this.a == zzawVar.a && this.b == zzawVar.b && this.count == zzawVar.count && Double.compare(this.zzega, zzawVar.zzega) == 0;
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.p.b(this.name, Double.valueOf(this.a), Double.valueOf(this.b), Double.valueOf(this.zzega), Integer.valueOf(this.count));
    }

    public final String toString() {
        p.a c = com.google.android.gms.common.internal.p.c(this);
        c.a("name", this.name);
        c.a("minBound", Double.valueOf(this.b));
        c.a("maxBound", Double.valueOf(this.a));
        c.a("percent", Double.valueOf(this.zzega));
        c.a("count", Integer.valueOf(this.count));
        return c.toString();
    }
}
