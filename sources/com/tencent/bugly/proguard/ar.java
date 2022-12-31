package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class ar extends k implements Cloneable {

    /* renamed from: f  reason: collision with root package name */
    private static ArrayList<aq> f7967f;

    /* renamed from: g  reason: collision with root package name */
    private static Map<String, String> f7968g;
    public byte a = 0;
    public String b = "";
    public String c = "";

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<aq> f7969d = null;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f7970e = null;

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.a, 0);
        String str = this.b;
        if (str != null) {
            jVar.a(str, 1);
        }
        String str2 = this.c;
        if (str2 != null) {
            jVar.a(str2, 2);
        }
        ArrayList<aq> arrayList = this.f7969d;
        if (arrayList != null) {
            jVar.a((Collection) arrayList, 3);
        }
        Map<String, String> map = this.f7970e;
        if (map != null) {
            jVar.a((Map) map, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.a = iVar.a(this.a, 0, true);
        this.b = iVar.b(1, false);
        this.c = iVar.b(2, false);
        if (f7967f == null) {
            f7967f = new ArrayList<>();
            f7967f.add(new aq());
        }
        this.f7969d = (ArrayList) iVar.a((i) f7967f, 3, false);
        if (f7968g == null) {
            HashMap hashMap = new HashMap();
            f7968g = hashMap;
            hashMap.put("", "");
        }
        this.f7970e = (Map) iVar.a((i) f7968g, 4, false);
    }
}
