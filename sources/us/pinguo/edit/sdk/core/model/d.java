package us.pinguo.edit.sdk.core.model;
/* compiled from: PGParam.java */
/* loaded from: classes4.dex */
public class d {
    public String a;
    public String b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public String f10093d;

    /* renamed from: e  reason: collision with root package name */
    public String f10094e;

    /* renamed from: f  reason: collision with root package name */
    public String f10095f;

    /* renamed from: g  reason: collision with root package name */
    public String f10096g;

    /* renamed from: h  reason: collision with root package name */
    public String f10097h;

    /* renamed from: i  reason: collision with root package name */
    public String f10098i;

    /* renamed from: j  reason: collision with root package name */
    public String f10099j;

    /* renamed from: k  reason: collision with root package name */
    public e f10100k;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.f10094e;
        if (str == null ? dVar.f10094e == null : str.equals(dVar.f10094e)) {
            String str2 = this.a;
            if (str2 == null ? dVar.a == null : str2.equals(dVar.a)) {
                String str3 = this.b;
                if (str3 == null ? dVar.b == null : str3.equals(dVar.b)) {
                    String str4 = this.f10096g;
                    if (str4 == null ? dVar.f10096g == null : str4.equals(dVar.f10096g)) {
                        String str5 = this.f10097h;
                        if (str5 == null ? dVar.f10097h == null : str5.equals(dVar.f10097h)) {
                            String str6 = this.f10095f;
                            if (str6 == null ? dVar.f10095f == null : str6.equals(dVar.f10095f)) {
                                e eVar = this.f10100k;
                                if (eVar == null ? dVar.f10100k == null : eVar.equals(dVar.f10100k)) {
                                    String str7 = this.c;
                                    if (str7 == null ? dVar.c == null : str7.equals(dVar.c)) {
                                        String str8 = this.f10093d;
                                        if (str8 == null ? dVar.f10093d == null : str8.equals(dVar.f10093d)) {
                                            String str9 = this.f10098i;
                                            if (str9 == null ? dVar.f10098i == null : str9.equals(dVar.f10098i)) {
                                                String str10 = this.f10099j;
                                                String str11 = dVar.f10099j;
                                                return str10 == null ? str11 == null : str10.equals(str11);
                                            }
                                            return false;
                                        }
                                        return false;
                                    }
                                    return false;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
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
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f10093d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f10094e;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f10095f;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f10096g;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.f10097h;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.f10098i;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.f10099j;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        e eVar = this.f10100k;
        return hashCode10 + (eVar != null ? eVar.hashCode() : 0);
    }
}
