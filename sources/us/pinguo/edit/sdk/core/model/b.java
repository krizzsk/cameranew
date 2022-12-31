package us.pinguo.edit.sdk.core.model;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
/* compiled from: PGEftDispInfo.java */
/* loaded from: classes4.dex */
public class b {
    public String a;
    public Map<String, c> b = new TreeMap(new a(this));
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public String f10091d;

    /* renamed from: e  reason: collision with root package name */
    public int f10092e;

    /* compiled from: PGEftDispInfo.java */
    /* loaded from: classes4.dex */
    class a implements Comparator {
        a(b bVar) {
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
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        String str = this.f10091d;
        if (str == null ? bVar.f10091d == null : str.equals(bVar.f10091d)) {
            String str2 = this.a;
            if (str2 == null ? bVar.a == null : str2.equals(bVar.a)) {
                String str3 = this.c;
                if (str3 == null ? bVar.c == null : str3.equals(bVar.c)) {
                    return this.b.equals(bVar.b);
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.b.hashCode()) * 31;
        String str2 = this.c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f10091d;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }
}
