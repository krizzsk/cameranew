package us.pinguo.edit.sdk.core.model;

import java.util.concurrent.ConcurrentHashMap;
/* compiled from: PGEft.java */
/* loaded from: classes4.dex */
public class a {
    public int a;
    public int b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public String f10082d;

    /* renamed from: e  reason: collision with root package name */
    public String f10083e;

    /* renamed from: f  reason: collision with root package name */
    public String f10084f;

    /* renamed from: g  reason: collision with root package name */
    public String f10085g;

    /* renamed from: j  reason: collision with root package name */
    public b f10088j;

    /* renamed from: l  reason: collision with root package name */
    public g f10090l;

    /* renamed from: h  reason: collision with root package name */
    public int f10086h = Integer.MAX_VALUE;

    /* renamed from: i  reason: collision with root package name */
    public int f10087i = Integer.MAX_VALUE;

    /* renamed from: k  reason: collision with root package name */
    public ConcurrentHashMap<String, d> f10089k = new ConcurrentHashMap<>();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.f10085g;
        if (str == null ? aVar.f10085g == null : str.equals(aVar.f10085g)) {
            String str2 = this.c;
            if (str2 == null ? aVar.c == null : str2.equals(aVar.c)) {
                String str3 = this.f10082d;
                if (str3 == null ? aVar.f10082d == null : str3.equals(aVar.f10082d)) {
                    String str4 = this.f10084f;
                    if (str4 == null ? aVar.f10084f == null : str4.equals(aVar.f10084f)) {
                        String str5 = this.f10083e;
                        String str6 = aVar.f10083e;
                        return str5 == null ? str6 == null : str5.equals(str6);
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
        String str = this.c;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f10082d;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f10083e;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f10084f;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f10085g;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }
}
