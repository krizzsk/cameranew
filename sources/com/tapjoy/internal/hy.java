package com.tapjoy.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyAuctionFlags;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class hy extends ho implements gq {
    public static final bi a = new bi() { // from class: com.tapjoy.internal.hy.1
        @Override // com.tapjoy.internal.bi
        public final /* synthetic */ Object a(bn bnVar) {
            bnVar.h();
            String str = null;
            String str2 = null;
            String str3 = null;
            int i2 = 1;
            while (bnVar.j()) {
                String l2 = bnVar.l();
                if (TapjoyAuctionFlags.AUCTION_ID.equals(l2)) {
                    str = bnVar.m();
                } else if ("name".equals(l2)) {
                    str2 = bnVar.m();
                } else if (FirebaseAnalytics.Param.QUANTITY.equals(l2)) {
                    i2 = bnVar.r();
                } else if ("token".equals(l2)) {
                    str3 = bnVar.m();
                } else {
                    bnVar.s();
                }
            }
            bnVar.i();
            return new hy(str, str2, i2, str3);
        }
    };
    private final String b;
    private final String c;

    /* renamed from: d  reason: collision with root package name */
    private final int f7655d;

    /* renamed from: e  reason: collision with root package name */
    private final String f7656e;

    hy(String str, String str2, int i2, String str3) {
        this.b = str;
        this.c = str2;
        this.f7655d = i2;
        this.f7656e = str3;
    }

    @Override // com.tapjoy.internal.gq
    public final String a() {
        return this.b;
    }

    @Override // com.tapjoy.internal.gq
    public final String b() {
        return this.c;
    }

    @Override // com.tapjoy.internal.gq
    public final int c() {
        return this.f7655d;
    }

    @Override // com.tapjoy.internal.gq
    public final String d() {
        return this.f7656e;
    }
}
