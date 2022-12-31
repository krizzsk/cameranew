package com.ironsource.mediationsdk.model;

import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: BannerConfigurations.java */
/* loaded from: classes2.dex */
public class g {
    private d a;
    private long b;
    private ArrayList<h> c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private h f5596d;

    /* renamed from: e  reason: collision with root package name */
    private int f5597e;

    /* renamed from: f  reason: collision with root package name */
    private int f5598f;

    /* renamed from: g  reason: collision with root package name */
    private com.ironsource.mediationsdk.utils.b f5599g;

    public g(int i2, long j2, d dVar, int i3, com.ironsource.mediationsdk.utils.b bVar, int i4) {
        this.b = j2;
        this.a = dVar;
        this.f5597e = i3;
        this.f5598f = i4;
        this.f5599g = bVar;
    }

    public void a(h hVar) {
        if (hVar != null) {
            this.c.add(hVar);
            if (this.f5596d == null) {
                this.f5596d = hVar;
            } else if (hVar.b() == 0) {
                this.f5596d = hVar;
            }
        }
    }

    public long b() {
        return this.b;
    }

    public com.ironsource.mediationsdk.utils.b c() {
        return this.f5599g;
    }

    public int d() {
        return this.f5598f;
    }

    public d e() {
        return this.a;
    }

    public h f(String str) {
        Iterator<h> it = this.c.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next.c().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public int g() {
        return this.f5597e;
    }

    public h h() {
        Iterator<h> it = this.c.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next.d()) {
                return next;
            }
        }
        return this.f5596d;
    }
}
