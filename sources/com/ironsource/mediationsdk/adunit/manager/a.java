package com.ironsource.mediationsdk.adunit.manager;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.l;
import java.util.List;
/* compiled from: AdManagerData.java */
/* loaded from: classes2.dex */
public class a {
    private IronSource.AD_UNIT a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private List<l> f5517d;

    /* renamed from: e  reason: collision with root package name */
    private com.ironsource.mediationsdk.utils.b f5518e;

    /* renamed from: f  reason: collision with root package name */
    private int f5519f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f5520g;

    /* renamed from: h  reason: collision with root package name */
    private int f5521h;

    /* renamed from: i  reason: collision with root package name */
    private int f5522i;

    public a(IronSource.AD_UNIT ad_unit, String str, String str2, List<l> list, com.ironsource.mediationsdk.utils.b bVar, int i2, boolean z, int i3, int i4) {
        this.a = ad_unit;
        this.b = str;
        this.c = str2;
        this.f5517d = list;
        this.f5518e = bVar;
        this.f5519f = i2;
        this.f5520g = z;
        this.f5522i = i3;
        this.f5521h = i4;
    }

    public IronSource.AD_UNIT a() {
        return this.a;
    }

    public boolean b() {
        return this.f5520g;
    }

    public String c() {
        return this.b;
    }

    public com.ironsource.mediationsdk.utils.b d() {
        return this.f5518e;
    }

    public int e() {
        return this.f5521h;
    }

    public int f() {
        return this.f5519f;
    }

    public List<l> g() {
        return this.f5517d;
    }

    public l h(String str) {
        for (l lVar : this.f5517d) {
            if (lVar.k().equals(str)) {
                return lVar;
            }
        }
        return null;
    }

    public int i() {
        return this.f5522i;
    }

    public String j() {
        return this.c;
    }

    public boolean k() {
        return this.f5518e.i() > 0;
    }
}
