package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class ap extends k implements Cloneable {
    private static Map<String, String> n;
    private static /* synthetic */ boolean o = true;
    private static ao m = new ao();
    public boolean a = true;
    public boolean b = true;
    public boolean c = true;

    /* renamed from: d  reason: collision with root package name */
    public String f7952d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f7953e = "";

    /* renamed from: f  reason: collision with root package name */
    public ao f7954f = null;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, String> f7955g = null;

    /* renamed from: h  reason: collision with root package name */
    public long f7956h = 0;

    /* renamed from: j  reason: collision with root package name */
    private String f7958j = "";

    /* renamed from: k  reason: collision with root package name */
    private String f7959k = "";

    /* renamed from: l  reason: collision with root package name */
    private int f7960l = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f7957i = 0;

    static {
        HashMap hashMap = new HashMap();
        n = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.a, 0);
        jVar.a(this.b, 1);
        jVar.a(this.c, 2);
        String str = this.f7952d;
        if (str != null) {
            jVar.a(str, 3);
        }
        String str2 = this.f7953e;
        if (str2 != null) {
            jVar.a(str2, 4);
        }
        ao aoVar = this.f7954f;
        if (aoVar != null) {
            jVar.a((k) aoVar, 5);
        }
        Map<String, String> map = this.f7955g;
        if (map != null) {
            jVar.a((Map) map, 6);
        }
        jVar.a(this.f7956h, 7);
        String str3 = this.f7958j;
        if (str3 != null) {
            jVar.a(str3, 8);
        }
        String str4 = this.f7959k;
        if (str4 != null) {
            jVar.a(str4, 9);
        }
        jVar.a(this.f7960l, 10);
        jVar.a(this.f7957i, 11);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (o) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        ap apVar = (ap) obj;
        return l.a(this.a, apVar.a) && l.a(this.b, apVar.b) && l.a(this.c, apVar.c) && l.a(this.f7952d, apVar.f7952d) && l.a(this.f7953e, apVar.f7953e) && l.a(this.f7954f, apVar.f7954f) && l.a(this.f7955g, apVar.f7955g) && l.a(this.f7956h, apVar.f7956h) && l.a(this.f7958j, apVar.f7958j) && l.a(this.f7959k, apVar.f7959k) && l.a(this.f7960l, apVar.f7960l) && l.a(this.f7957i, apVar.f7957i);
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.a = iVar.a(0, true);
        this.b = iVar.a(1, true);
        this.c = iVar.a(2, true);
        this.f7952d = iVar.b(3, false);
        this.f7953e = iVar.b(4, false);
        this.f7954f = (ao) iVar.a((k) m, 5, false);
        this.f7955g = (Map) iVar.a((i) n, 6, false);
        this.f7956h = iVar.a(this.f7956h, 7, false);
        this.f7958j = iVar.b(8, false);
        this.f7959k = iVar.b(9, false);
        this.f7960l = iVar.a(this.f7960l, 10, false);
        this.f7957i = iVar.a(this.f7957i, 11, false);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i2) {
        h hVar = new h(sb, i2);
        hVar.a(this.a, "enable");
        hVar.a(this.b, "enableUserInfo");
        hVar.a(this.c, "enableQuery");
        hVar.a(this.f7952d, "url");
        hVar.a(this.f7953e, "expUrl");
        hVar.a((k) this.f7954f, "security");
        hVar.a((Map) this.f7955g, "valueMap");
        hVar.a(this.f7956h, "strategylastUpdateTime");
        hVar.a(this.f7958j, "httpsUrl");
        hVar.a(this.f7959k, "httpsExpUrl");
        hVar.a(this.f7960l, "eventRecordCount");
        hVar.a(this.f7957i, "eventTimeInterval");
    }
}
