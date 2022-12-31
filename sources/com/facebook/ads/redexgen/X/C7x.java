package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.7x  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C7x extends C1027Ms {
    public int A00;
    public boolean A01;
    public final C9P<C06687v> A02;
    public final C9P<C06677u> A03;
    public final C9P<C0977Kr> A04;
    public final C9P<C06667t> A05;
    public final C9P<C0966Ke> A06;
    public final C9P<KR> A07;
    public final C9P<KQ> A08;
    public final C9P<KL> A09;
    public final C9P<KK> A0A;
    public final C1099Po A0B;
    public final AbstractC0971Kk A0C;
    public final KM A0D;

    public C7x(XT xt, JT jt, C1099Po c1099Po, String str) {
        this(xt, jt, c1099Po, new ArrayList(), str);
    }

    public C7x(XT xt, JT jt, C1099Po c1099Po, String str, @Nullable Bundle bundle) {
        this(xt, jt, c1099Po, new ArrayList(), str, bundle, null);
    }

    public C7x(XT xt, JT jt, C1099Po c1099Po, String str, @Nullable Map<String, String> extraParams) {
        this(xt, jt, c1099Po, new ArrayList(), str, null, extraParams);
    }

    public C7x(XT xt, JT jt, C1099Po c1099Po, List<AnonymousClass27> list, String str) {
        super(xt, jt, c1099Po, list, str, !c1099Po.A0h());
        this.A0D = new KM() { // from class: com.facebook.ads.redexgen.X.7y
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(KN kn) {
                C7x.this.A0Z();
            }
        };
        this.A07 = new PY(this);
        this.A03 = new PA(this);
        this.A04 = new P9(this);
        this.A05 = new OT(this);
        this.A02 = new OF(this);
        this.A06 = new OE(this);
        this.A09 = new C1057Nw(this);
        this.A0A = new C1038Nd(this);
        this.A08 = new C1098Pn(this);
        this.A0C = new AbstractC0971Kk() { // from class: com.facebook.ads.redexgen.X.81
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(C0975Ko c0975Ko) {
                C1099Po c1099Po2;
                C7x c7x = C7x.this;
                c1099Po2 = c7x.A0B;
                c7x.A00 = c1099Po2.getDuration();
            }
        };
        this.A01 = false;
        this.A0B = c1099Po;
        this.A0B.getEventBus().A03(this.A0D, this.A05, this.A07, this.A04, this.A03, this.A02, this.A06, this.A09, this.A0A, this.A0C, this.A08);
    }

    public C7x(XT xt, JT jt, C1099Po c1099Po, List<AnonymousClass27> list, String str, @Nullable Bundle bundle, @Nullable Map<String, String> map) {
        super(xt, jt, c1099Po, list, str, !c1099Po.A0h(), bundle, map);
        this.A0D = new KM() { // from class: com.facebook.ads.redexgen.X.7y
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(KN kn) {
                C7x.this.A0Z();
            }
        };
        this.A07 = new PY(this);
        this.A03 = new PA(this);
        this.A04 = new P9(this);
        this.A05 = new OT(this);
        this.A02 = new OF(this);
        this.A06 = new OE(this);
        this.A09 = new C1057Nw(this);
        this.A0A = new C1038Nd(this);
        this.A08 = new C1098Pn(this);
        this.A0C = new AbstractC0971Kk() { // from class: com.facebook.ads.redexgen.X.81
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(C0975Ko c0975Ko) {
                C1099Po c1099Po2;
                C7x c7x = C7x.this;
                c1099Po2 = c7x.A0B;
                c7x.A00 = c1099Po2.getDuration();
            }
        };
        this.A01 = false;
        this.A0B = c1099Po;
        this.A0B.getEventBus().A03(this.A0D, this.A05, this.A07, this.A04, this.A03, this.A02, this.A06, this.A09, this.A0A, this.A08);
    }

    public final void A0g() {
        this.A0B.getStateHandler().post(new C1087Pc(this));
    }
}
