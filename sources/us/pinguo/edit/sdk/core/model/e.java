package us.pinguo.edit.sdk.core.model;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
/* compiled from: PGParamDispInfo.java */
/* loaded from: classes4.dex */
public class e {
    public String a;
    public String b;
    public Map<String, c> c = new TreeMap(new a(this));

    /* renamed from: d  reason: collision with root package name */
    public String f10101d;

    /* renamed from: e  reason: collision with root package name */
    public String f10102e;

    /* compiled from: PGParamDispInfo.java */
    /* loaded from: classes4.dex */
    class a implements Comparator {
        a(e eVar) {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == null || obj2 == null) {
                return 0;
            }
            return String.valueOf(obj).compareTo(String.valueOf(obj2));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        String str = this.f10102e;
        if (str == null ? eVar.f10102e == null : str.equals(eVar.f10102e)) {
            String str2 = this.a;
            if (str2 == null ? eVar.a == null : str2.equals(eVar.a)) {
                String str3 = this.f10101d;
                if (str3 == null ? eVar.f10101d == null : str3.equals(eVar.f10101d)) {
                    if (this.c.equals(eVar.c)) {
                        String str4 = this.b;
                        String str5 = eVar.b;
                        return str4 == null ? str5 == null : str4.equals(str5);
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
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.c.hashCode()) * 31;
        String str3 = this.f10101d;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f10102e;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }
}
