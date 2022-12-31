package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class d extends c {

    /* renamed from: f  reason: collision with root package name */
    private static HashMap<String, byte[]> f7974f;

    /* renamed from: g  reason: collision with root package name */
    private static HashMap<String, HashMap<String, byte[]>> f7975g;

    /* renamed from: e  reason: collision with root package name */
    private f f7976e;

    public d() {
        f fVar = new f();
        this.f7976e = fVar;
        fVar.a = (short) 2;
    }

    @Override // com.tencent.bugly.proguard.c, com.tencent.bugly.proguard.a
    public final <T> void a(String str, T t) {
        if (!str.startsWith(".")) {
            super.a(str, (String) t);
            return;
        }
        throw new IllegalArgumentException("put name can not startwith . , now is " + str);
    }

    public final void b(String str) {
        this.f7976e.c = str;
    }

    @Override // com.tencent.bugly.proguard.c
    public final void c() {
        super.c();
        this.f7976e.a = (short) 3;
    }

    public final void c(String str) {
        this.f7976e.f7979d = str;
    }

    @Override // com.tencent.bugly.proguard.c, com.tencent.bugly.proguard.a
    public final byte[] a() {
        f fVar = this.f7976e;
        if (fVar.a == 2) {
            if (!fVar.c.equals("")) {
                if (this.f7976e.f7979d.equals("")) {
                    throw new IllegalArgumentException("funcName can not is null");
                }
            } else {
                throw new IllegalArgumentException("servantName can not is null");
            }
        } else {
            if (fVar.c == null) {
                fVar.c = "";
            }
            if (fVar.f7979d == null) {
                fVar.f7979d = "";
            }
        }
        j jVar = new j(0);
        jVar.a(this.b);
        if (this.f7976e.a == 2) {
            jVar.a((Map) this.a, 0);
        } else {
            jVar.a((Map) ((c) this).f7971d, 0);
        }
        this.f7976e.f7980e = l.a(jVar.a());
        j jVar2 = new j(0);
        jVar2.a(this.b);
        this.f7976e.a(jVar2);
        byte[] a = l.a(jVar2.a());
        int length = a.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(a).flip();
        return allocate.array();
    }

    @Override // com.tencent.bugly.proguard.c, com.tencent.bugly.proguard.a
    public final void a(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                i iVar = new i(bArr, 4);
                iVar.a(this.b);
                this.f7976e.a(iVar);
                f fVar = this.f7976e;
                if (fVar.a == 3) {
                    i iVar2 = new i(fVar.f7980e);
                    iVar2.a(this.b);
                    if (f7974f == null) {
                        HashMap<String, byte[]> hashMap = new HashMap<>();
                        f7974f = hashMap;
                        hashMap.put("", new byte[0]);
                    }
                    ((c) this).f7971d = iVar2.a((Map) f7974f, 0, false);
                    return;
                }
                i iVar3 = new i(fVar.f7980e);
                iVar3.a(this.b);
                if (f7975g == null) {
                    f7975g = new HashMap<>();
                    HashMap<String, byte[]> hashMap2 = new HashMap<>();
                    hashMap2.put("", new byte[0]);
                    f7975g.put("", hashMap2);
                }
                this.a = iVar3.a((Map) f7975g, 0, false);
                new HashMap();
                return;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }

    public final void a(int i2) {
        this.f7976e.b = 1;
    }
}
