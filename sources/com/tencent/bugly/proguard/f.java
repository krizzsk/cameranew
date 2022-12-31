package com.tencent.bugly.proguard;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class f extends k {

    /* renamed from: e  reason: collision with root package name */
    public byte[] f7980e;

    /* renamed from: i  reason: collision with root package name */
    private Map<String, String> f7984i;

    /* renamed from: j  reason: collision with root package name */
    private Map<String, String> f7985j;
    private static /* synthetic */ boolean m = true;

    /* renamed from: k  reason: collision with root package name */
    private static byte[] f7977k = null;

    /* renamed from: l  reason: collision with root package name */
    private static Map<String, String> f7978l = null;
    public short a = 0;

    /* renamed from: f  reason: collision with root package name */
    private byte f7981f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f7982g = 0;
    public int b = 0;
    public String c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f7979d = null;

    /* renamed from: h  reason: collision with root package name */
    private int f7983h = 0;

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.a, 1);
        jVar.a(this.f7981f, 2);
        jVar.a(this.f7982g, 3);
        jVar.a(this.b, 4);
        jVar.a(this.c, 5);
        jVar.a(this.f7979d, 6);
        jVar.a(this.f7980e, 7);
        jVar.a(this.f7983h, 8);
        jVar.a((Map) this.f7984i, 9);
        jVar.a((Map) this.f7985j, 10);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        f fVar = (f) obj;
        return l.a(1, (int) fVar.a) && l.a(1, (int) fVar.f7981f) && l.a(1, fVar.f7982g) && l.a(1, fVar.b) && l.a((Object) 1, (Object) fVar.c) && l.a((Object) 1, (Object) fVar.f7979d) && l.a((Object) 1, (Object) fVar.f7980e) && l.a(1, fVar.f7983h) && l.a((Object) 1, (Object) fVar.f7984i) && l.a((Object) 1, (Object) fVar.f7985j);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        try {
            this.a = iVar.a(this.a, 1, true);
            this.f7981f = iVar.a(this.f7981f, 2, true);
            this.f7982g = iVar.a(this.f7982g, 3, true);
            this.b = iVar.a(this.b, 4, true);
            this.c = iVar.b(5, true);
            this.f7979d = iVar.b(6, true);
            if (f7977k == null) {
                f7977k = new byte[]{0};
            }
            this.f7980e = iVar.c(7, true);
            this.f7983h = iVar.a(this.f7983h, 8, true);
            if (f7978l == null) {
                HashMap hashMap = new HashMap();
                f7978l = hashMap;
                hashMap.put("", "");
            }
            this.f7984i = (Map) iVar.a((i) f7978l, 9, true);
            if (f7978l == null) {
                HashMap hashMap2 = new HashMap();
                f7978l = hashMap2;
                hashMap2.put("", "");
            }
            this.f7985j = (Map) iVar.a((i) f7978l, 10, true);
        } catch (Exception e2) {
            e2.printStackTrace();
            PrintStream printStream = System.out;
            printStream.println("RequestPacket decode error " + e.a(this.f7980e));
            throw new RuntimeException(e2);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i2) {
        h hVar = new h(sb, i2);
        hVar.a(this.a, "iVersion");
        hVar.a(this.f7981f, "cPacketType");
        hVar.a(this.f7982g, "iMessageType");
        hVar.a(this.b, "iRequestId");
        hVar.a(this.c, "sServantName");
        hVar.a(this.f7979d, "sFuncName");
        hVar.a(this.f7980e, "sBuffer");
        hVar.a(this.f7983h, "iTimeout");
        hVar.a((Map) this.f7984i, "context");
        hVar.a((Map) this.f7985j, "status");
    }
}
