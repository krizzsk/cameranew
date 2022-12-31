package com.google.gson;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: GsonBuilder.java */
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: h  reason: collision with root package name */
    private String f4932h;
    private com.google.gson.internal.c a = com.google.gson.internal.c.DEFAULT;
    private LongSerializationPolicy b = LongSerializationPolicy.DEFAULT;
    private d c = FieldNamingPolicy.IDENTITY;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Type, g<?>> f4928d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final List<r> f4929e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final List<r> f4930f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private boolean f4931g = false;

    /* renamed from: i  reason: collision with root package name */
    private int f4933i = 2;

    /* renamed from: j  reason: collision with root package name */
    private int f4934j = 2;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4935k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f4936l = false;
    private boolean m = true;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;

    private void a(String str, int i2, int i3, List<r> list) {
        a aVar;
        a aVar2;
        a aVar3;
        if (str != null && !"".equals(str.trim())) {
            aVar = new a(Date.class, str);
            aVar2 = new a(Timestamp.class, str);
            aVar3 = new a(java.sql.Date.class, str);
        } else if (i2 == 2 || i3 == 2) {
            return;
        } else {
            a aVar4 = new a(Date.class, i2, i3);
            a aVar5 = new a(Timestamp.class, i2, i3);
            a aVar6 = new a(java.sql.Date.class, i2, i3);
            aVar = aVar4;
            aVar2 = aVar5;
            aVar3 = aVar6;
        }
        list.add(com.google.gson.internal.k.n.b(Date.class, aVar));
        list.add(com.google.gson.internal.k.n.b(Timestamp.class, aVar2));
        list.add(com.google.gson.internal.k.n.b(java.sql.Date.class, aVar3));
    }

    public e b() {
        List<r> arrayList = new ArrayList<>(this.f4929e.size() + this.f4930f.size() + 3);
        arrayList.addAll(this.f4929e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f4930f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.f4932h, this.f4933i, this.f4934j, arrayList);
        return new e(this.a, this.c, this.f4928d, this.f4931g, this.f4935k, this.o, this.m, this.n, this.p, this.f4936l, this.b, this.f4932h, this.f4933i, this.f4934j, this.f4929e, this.f4930f, arrayList);
    }

    public f c() {
        this.m = false;
        return this;
    }

    public f d(Type type, Object obj) {
        boolean z = obj instanceof p;
        com.google.gson.internal.a.a(z || (obj instanceof j) || (obj instanceof g) || (obj instanceof q));
        if (obj instanceof g) {
            this.f4928d.put(type, (g) obj);
        }
        if (z || (obj instanceof j)) {
            this.f4929e.add(com.google.gson.internal.k.l.newFactoryWithMatchRawType(com.google.gson.t.a.get(type), obj));
        }
        if (obj instanceof q) {
            this.f4929e.add(com.google.gson.internal.k.n.a(com.google.gson.t.a.get(type), (q) obj));
        }
        return this;
    }
}
