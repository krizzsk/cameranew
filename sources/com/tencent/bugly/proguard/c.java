package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class c extends a {

    /* renamed from: d  reason: collision with root package name */
    protected HashMap<String, byte[]> f7971d = null;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, Object> f7972e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private i f7973f = new i();

    @Override // com.tencent.bugly.proguard.a
    public final /* bridge */ /* synthetic */ void a(String str) {
        super.a(str);
    }

    public final <T> T b(String str, T t) throws b {
        HashMap<String, byte[]> hashMap = this.f7971d;
        if (hashMap != null) {
            if (hashMap.containsKey(str)) {
                if (this.f7972e.containsKey(str)) {
                    return (T) this.f7972e.get(str);
                }
                try {
                    this.f7973f.a(this.f7971d.get(str));
                    this.f7973f.a(this.b);
                    T t2 = (T) this.f7973f.a((i) t, 0, true);
                    if (t2 != null) {
                        this.f7972e.put(str, t2);
                    }
                    return t2;
                } catch (Exception e2) {
                    throw new b(e2);
                }
            }
            return null;
        } else if (this.a.containsKey(str)) {
            if (this.f7972e.containsKey(str)) {
                return (T) this.f7972e.get(str);
            }
            byte[] bArr = new byte[0];
            Iterator<Map.Entry<String, byte[]>> it = this.a.get(str).entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<String, byte[]> next = it.next();
                next.getKey();
                bArr = next.getValue();
            }
            try {
                this.f7973f.a(bArr);
                this.f7973f.a(this.b);
                T t3 = (T) this.f7973f.a((i) t, 0, true);
                this.f7972e.put(str, t3);
                return t3;
            } catch (Exception e3) {
                throw new b(e3);
            }
        } else {
            return null;
        }
    }

    public void c() {
        this.f7971d = new HashMap<>();
    }

    @Override // com.tencent.bugly.proguard.a
    public <T> void a(String str, T t) {
        if (this.f7971d == null) {
            super.a(str, (String) t);
        } else if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else {
            if (t != null) {
                if (!(t instanceof Set)) {
                    j jVar = new j();
                    jVar.a(this.b);
                    jVar.a(t, 0);
                    this.f7971d.put(str, l.a(jVar.a()));
                    return;
                }
                throw new IllegalArgumentException("can not support Set");
            }
            throw new IllegalArgumentException("put value can not is null");
        }
    }

    @Override // com.tencent.bugly.proguard.a
    public byte[] a() {
        if (this.f7971d != null) {
            j jVar = new j(0);
            jVar.a(this.b);
            jVar.a((Map) this.f7971d, 0);
            return l.a(jVar.a());
        }
        return super.a();
    }

    @Override // com.tencent.bugly.proguard.a
    public void a(byte[] bArr) {
        try {
            super.a(bArr);
        } catch (Exception unused) {
            this.f7973f.a(bArr);
            this.f7973f.a(this.b);
            HashMap hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.f7971d = this.f7973f.a((Map) hashMap, 0, false);
        }
    }
}
