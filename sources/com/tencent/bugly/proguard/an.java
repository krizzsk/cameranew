package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class an extends k {

    /* renamed from: i  reason: collision with root package name */
    private static byte[] f7945i;

    /* renamed from: j  reason: collision with root package name */
    private static Map<String, String> f7946j;
    public byte a = 0;
    public int b = 0;
    public byte[] c = null;

    /* renamed from: f  reason: collision with root package name */
    private String f7949f = "";

    /* renamed from: d  reason: collision with root package name */
    public long f7947d = 0;

    /* renamed from: g  reason: collision with root package name */
    private String f7950g = "";

    /* renamed from: e  reason: collision with root package name */
    public String f7948e = "";

    /* renamed from: h  reason: collision with root package name */
    private Map<String, String> f7951h = null;

    static {
        f7945i = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        f7946j = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.a, 0);
        jVar.a(this.b, 1);
        byte[] bArr = this.c;
        if (bArr != null) {
            jVar.a(bArr, 2);
        }
        String str = this.f7949f;
        if (str != null) {
            jVar.a(str, 3);
        }
        jVar.a(this.f7947d, 4);
        String str2 = this.f7950g;
        if (str2 != null) {
            jVar.a(str2, 5);
        }
        String str3 = this.f7948e;
        if (str3 != null) {
            jVar.a(str3, 6);
        }
        Map<String, String> map = this.f7951h;
        if (map != null) {
            jVar.a((Map) map, 7);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.a = iVar.a(this.a, 0, true);
        this.b = iVar.a(this.b, 1, true);
        this.c = iVar.c(2, false);
        this.f7949f = iVar.b(3, false);
        this.f7947d = iVar.a(this.f7947d, 4, false);
        this.f7950g = iVar.b(5, false);
        this.f7948e = iVar.b(6, false);
        this.f7951h = (Map) iVar.a((i) f7946j, 7, false);
    }
}
