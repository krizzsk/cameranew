package com.ironsource.mediationsdk.model;

import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: InterstitialConfigurations.java */
/* loaded from: classes2.dex */
public class j {
    private ArrayList<k> a = new ArrayList<>();
    private d b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5602d;

    /* renamed from: e  reason: collision with root package name */
    private int f5603e;

    /* renamed from: f  reason: collision with root package name */
    private int f5604f;

    /* renamed from: g  reason: collision with root package name */
    private String f5605g;

    /* renamed from: h  reason: collision with root package name */
    private String f5606h;

    /* renamed from: i  reason: collision with root package name */
    private com.ironsource.mediationsdk.utils.b f5607i;

    /* renamed from: j  reason: collision with root package name */
    private k f5608j;

    public j(int i2, boolean z, int i3, d dVar, com.ironsource.mediationsdk.utils.b bVar, int i4) {
        this.c = i2;
        this.f5602d = z;
        this.f5603e = i3;
        this.b = dVar;
        this.f5607i = bVar;
        this.f5604f = i4;
    }

    public void a(k kVar) {
        if (kVar != null) {
            this.a.add(kVar);
            if (this.f5608j == null) {
                this.f5608j = kVar;
            } else if (kVar.b() == 0) {
                this.f5608j = kVar;
            }
        }
    }

    public String b() {
        return this.f5605g;
    }

    public k c() {
        Iterator<k> it = this.a.iterator();
        while (it.hasNext()) {
            k next = it.next();
            if (next.d()) {
                return next;
            }
        }
        return this.f5608j;
    }

    public int d() {
        return this.f5604f;
    }

    public int e() {
        return this.c;
    }

    public int f() {
        return this.f5603e;
    }

    public boolean g() {
        return this.f5602d;
    }

    public com.ironsource.mediationsdk.utils.b h() {
        return this.f5607i;
    }

    public d i() {
        return this.b;
    }

    public k j(String str) {
        Iterator<k> it = this.a.iterator();
        while (it.hasNext()) {
            k next = it.next();
            if (next.c().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public String k() {
        return this.f5606h;
    }

    public void l(String str) {
        this.f5605g = str;
    }

    public void m(String str) {
        this.f5606h = str;
    }
}
