package us.pinguo.edit.sdk.core.model;
/* compiled from: PGLanguageInfo.java */
/* loaded from: classes4.dex */
public class c {
    public String a;
    public String b;
    public String c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        String str = this.b;
        if (str == null ? cVar.b == null : str.equals(cVar.b)) {
            String str2 = this.c;
            if (str2 == null ? cVar.c == null : str2.equals(cVar.c)) {
                String str3 = this.a;
                String str4 = cVar.a;
                return str3 == null ? str4 == null : str3.equals(str4);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }
}
