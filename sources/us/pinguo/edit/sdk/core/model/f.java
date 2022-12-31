package us.pinguo.edit.sdk.core.model;
/* compiled from: PGTexture.java */
/* loaded from: classes4.dex */
public class f {
    public String a;
    public int b = Integer.MAX_VALUE;
    public String c = "";

    /* renamed from: d  reason: collision with root package name */
    public int f10103d = Integer.MAX_VALUE;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f10103d == fVar.f10103d && this.b == fVar.b) {
            String str = this.a;
            if (str == null ? fVar.a == null : str.equals(fVar.a)) {
                return this.c.equals(fVar.c);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.b) * 31;
        String str2 = this.c;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f10103d;
    }
}
