package com.tapjoy.internal;
/* loaded from: classes3.dex */
public final class f {
    public String a;
    public String b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public long f7461d;

    /* renamed from: e  reason: collision with root package name */
    public int f7462e;

    /* renamed from: f  reason: collision with root package name */
    public String f7463f;

    /* renamed from: g  reason: collision with root package name */
    public String f7464g;

    public f(String str) {
        bn b = bn.b(str);
        b.h();
        while (b.j()) {
            String l2 = b.l();
            if ("orderId".equals(l2)) {
                this.a = b.m();
            } else if ("packageName".equals(l2)) {
                this.b = b.m();
            } else if ("productId".equals(l2)) {
                this.c = b.m();
            } else if ("purchaseTime".equals(l2)) {
                this.f7461d = b.q();
            } else if ("purchaseState".equals(l2)) {
                this.f7462e = b.r();
            } else if ("developerPayload".equals(l2)) {
                this.f7463f = b.m();
            } else if ("purchaseToken".equals(l2)) {
                this.f7464g = b.m();
            } else {
                b.s();
            }
        }
        b.i();
    }
}
