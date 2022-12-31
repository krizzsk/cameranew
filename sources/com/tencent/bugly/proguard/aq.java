package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class aq extends k {

    /* renamed from: i  reason: collision with root package name */
    private static Map<String, String> f7961i;
    public long a = 0;
    public byte b = 0;
    public String c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f7962d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f7963e = "";

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f7964f = null;

    /* renamed from: h  reason: collision with root package name */
    private String f7966h = "";

    /* renamed from: g  reason: collision with root package name */
    public boolean f7965g = true;

    static {
        HashMap hashMap = new HashMap();
        f7961i = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.a, 0);
        jVar.a(this.b, 1);
        String str = this.c;
        if (str != null) {
            jVar.a(str, 2);
        }
        String str2 = this.f7962d;
        if (str2 != null) {
            jVar.a(str2, 3);
        }
        String str3 = this.f7963e;
        if (str3 != null) {
            jVar.a(str3, 4);
        }
        Map<String, String> map = this.f7964f;
        if (map != null) {
            jVar.a((Map) map, 5);
        }
        String str4 = this.f7966h;
        if (str4 != null) {
            jVar.a(str4, 6);
        }
        jVar.a(this.f7965g, 7);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.a = iVar.a(this.a, 0, true);
        this.b = iVar.a(this.b, 1, true);
        this.c = iVar.b(2, false);
        this.f7962d = iVar.b(3, false);
        this.f7963e = iVar.b(4, false);
        this.f7964f = (Map) iVar.a((i) f7961i, 5, false);
        this.f7966h = iVar.b(6, false);
        this.f7965g = iVar.a(7, false);
    }
}
