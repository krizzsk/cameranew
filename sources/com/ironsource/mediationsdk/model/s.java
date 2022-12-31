package com.ironsource.mediationsdk.model;

import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: RewardedVideoConfigurations.java */
/* loaded from: classes2.dex */
public class s {
    private ArrayList<o> a = new ArrayList<>();
    private d b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5631d;

    /* renamed from: e  reason: collision with root package name */
    private int f5632e;

    /* renamed from: f  reason: collision with root package name */
    private String f5633f;

    /* renamed from: g  reason: collision with root package name */
    private String f5634g;

    /* renamed from: h  reason: collision with root package name */
    private int f5635h;

    /* renamed from: i  reason: collision with root package name */
    private int f5636i;

    /* renamed from: j  reason: collision with root package name */
    private o f5637j;

    /* renamed from: k  reason: collision with root package name */
    private com.ironsource.mediationsdk.utils.b f5638k;

    public s(int i2, boolean z, int i3, int i4, int i5, d dVar, com.ironsource.mediationsdk.utils.b bVar) {
        this.c = i2;
        this.f5631d = z;
        this.f5632e = i3;
        this.f5635h = i4;
        this.b = dVar;
        this.f5636i = i5;
        this.f5638k = bVar;
    }

    public void a(o oVar) {
        if (oVar != null) {
            this.a.add(oVar);
            if (this.f5637j == null) {
                this.f5637j = oVar;
            } else if (oVar.b() == 0) {
                this.f5637j = oVar;
            }
        }
    }

    public String b() {
        return this.f5633f;
    }

    public o c() {
        Iterator<o> it = this.a.iterator();
        while (it.hasNext()) {
            o next = it.next();
            if (next.f()) {
                return next;
            }
        }
        return this.f5637j;
    }

    public int d() {
        return this.f5636i;
    }

    public int e() {
        return this.f5635h;
    }

    public String f() {
        return this.f5634g;
    }

    public int g() {
        return this.c;
    }

    public int h() {
        return this.f5632e;
    }

    public boolean i() {
        return this.f5631d;
    }

    public com.ironsource.mediationsdk.utils.b j() {
        return this.f5638k;
    }

    public d k() {
        return this.b;
    }

    public void l(String str) {
        this.f5633f = str;
    }

    public void m(String str) {
        this.f5634g = str;
    }
}
