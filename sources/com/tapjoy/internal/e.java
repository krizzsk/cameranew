package com.tapjoy.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.open.SocialConstants;
/* loaded from: classes3.dex */
public final class e {
    public String a;
    public String b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public String f7391d;

    /* renamed from: e  reason: collision with root package name */
    public String f7392e;

    /* renamed from: f  reason: collision with root package name */
    public String f7393f;

    /* renamed from: g  reason: collision with root package name */
    public long f7394g;

    public e(String str) {
        bn b = bn.b(str);
        b.h();
        while (b.j()) {
            String l2 = b.l();
            if ("productId".equals(l2)) {
                this.a = b.m();
            } else if ("type".equals(l2)) {
                this.b = b.m();
            } else if (FirebaseAnalytics.Param.PRICE.equals(l2)) {
                this.c = b.m();
            } else if ("title".equals(l2)) {
                this.f7391d = b.m();
            } else if (SocialConstants.PARAM_COMMENT.equals(l2)) {
                this.f7392e = b.m();
            } else if ("price_currency_code".equals(l2)) {
                this.f7393f = b.m();
            } else if ("price_amount_micros".equals(l2)) {
                this.f7394g = b.q();
            } else {
                b.s();
            }
        }
        b.i();
    }
}
