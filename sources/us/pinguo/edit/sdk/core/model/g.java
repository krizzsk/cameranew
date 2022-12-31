package us.pinguo.edit.sdk.core.model;

import java.util.ArrayList;
import java.util.List;
/* compiled from: PGTexturePkg.java */
/* loaded from: classes4.dex */
public class g {
    public String a;
    public String b = "";
    public List<f> c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public int f10104d = Integer.MAX_VALUE;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f10104d == gVar.f10104d && this.b.equals(gVar.b)) {
            String str = this.a;
            if (str == null ? gVar.a == null : str.equals(gVar.a)) {
                return this.c.equals(gVar.c);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        return ((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.c.hashCode()) * 31) + this.f10104d;
    }
}
