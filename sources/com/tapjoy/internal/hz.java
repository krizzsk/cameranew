package com.tapjoy.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import us.pinguo.inspire.api.QiniuAuthToken;
/* loaded from: classes3.dex */
public final class hz {
    public static final bi n = new bi() { // from class: com.tapjoy.internal.hz.1
        @Override // com.tapjoy.internal.bi
        public final /* synthetic */ Object a(bn bnVar) {
            return new hz(bnVar);
        }
    };
    public ib a;
    public ib b;
    public ib c;

    /* renamed from: d  reason: collision with root package name */
    public ib f7657d;

    /* renamed from: e  reason: collision with root package name */
    public int f7658e;

    /* renamed from: f  reason: collision with root package name */
    public int f7659f;

    /* renamed from: g  reason: collision with root package name */
    public String f7660g;

    /* renamed from: h  reason: collision with root package name */
    public String f7661h;

    /* renamed from: i  reason: collision with root package name */
    public String f7662i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f7663j;

    /* renamed from: k  reason: collision with root package name */
    public String f7664k;

    /* renamed from: l  reason: collision with root package name */
    public hx f7665l;
    public hx m;

    public hz(bn bnVar) {
        this.f7658e = 9;
        this.f7659f = 10;
        this.f7663j = false;
        bnVar.h();
        while (bnVar.j()) {
            String l2 = bnVar.l();
            if ("x".equals(l2)) {
                this.a = ib.a(bnVar.m());
            } else if ("y".equals(l2)) {
                this.b = ib.a(bnVar.m());
            } else if ("width".equals(l2)) {
                this.c = ib.a(bnVar.m());
            } else if ("height".equals(l2)) {
                this.f7657d = ib.a(bnVar.m());
            } else if ("url".equals(l2)) {
                this.f7660g = bnVar.m();
            } else if (TapjoyConstants.TJC_REDIRECT_URL.equals(l2)) {
                this.f7661h = bnVar.m();
            } else if ("ad_content".equals(l2)) {
                this.f7662i = bnVar.m();
            } else if (TapjoyConstants.TJC_FULLSCREEN_AD_DISMISS_URL.equals(l2)) {
                this.f7663j = bnVar.n();
            } else if (FirebaseAnalytics.Param.VALUE.equals(l2)) {
                this.f7664k = bnVar.m();
            } else if (QiniuAuthToken.TYPE_IMAGE.equals(l2)) {
                this.f7665l = (hx) hx.f7652e.a(bnVar);
            } else if ("image_clicked".equals(l2)) {
                this.m = (hx) hx.f7652e.a(bnVar);
            } else if ("align".equals(l2)) {
                String m = bnVar.m();
                if (TJAdUnitConstants.String.LEFT.equals(m)) {
                    this.f7658e = 9;
                } else if (TJAdUnitConstants.String.RIGHT.equals(m)) {
                    this.f7658e = 11;
                } else if ("center".equals(m)) {
                    this.f7658e = 14;
                } else {
                    bnVar.s();
                }
            } else if ("valign".equals(l2)) {
                String m2 = bnVar.m();
                if (TJAdUnitConstants.String.TOP.equals(m2)) {
                    this.f7659f = 10;
                } else if ("middle".equals(m2)) {
                    this.f7659f = 15;
                } else if (TJAdUnitConstants.String.BOTTOM.equals(m2)) {
                    this.f7659f = 12;
                } else {
                    bnVar.s();
                }
            } else {
                bnVar.s();
            }
        }
        bnVar.i();
    }
}
