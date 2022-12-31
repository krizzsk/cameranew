package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
/* renamed from: com.facebook.ads.redexgen.X.bR  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1457bR extends C05272f {
    public static String[] A02 = {"kCJseLSqSIrXu4CFjUZgH7qP37OfZeHD", "xEAmwUG5TGVzyoKH1PTTnmgJSds6zi0t", "yfye5wiKddzXjwKpYSAHRZ10SdbOyGIS", "FmBYeFx3U0BhjOzbepjZtX", "pFd99JFbVQiCxR8NKRmLZvqZPwpJ8hMq", "9sA", "zOMSQIOQC2uzgyYA4i3GoXbtL5yC1N4Y", "6JUJmYz6"};
    public final C05272f A00 = new C1458bS(this);
    public final C0828Eq A01;

    public C1457bR(C0828Eq c0828Eq) {
        this.A01 = c0828Eq;
    }

    @Override // com.facebook.ads.redexgen.X.C05272f
    public final void A07(View view, AccessibilityEvent accessibilityEvent) {
        super.A07(view, accessibilityEvent);
        accessibilityEvent.setClassName(C0828Eq.class.getName());
        if ((view instanceof C0828Eq) && !A0B()) {
            C0828Eq c0828Eq = (C0828Eq) view;
            if (c0828Eq.getLayoutManager() != null) {
                c0828Eq.getLayoutManager().A1x(accessibilityEvent);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.C05272f
    public final void A08(View view, C3Q c3q) {
        super.A08(view, c3q);
        c3q.A0O(C0828Eq.class.getName());
        if (!A0B() && this.A01.getLayoutManager() != null) {
            this.A01.getLayoutManager().A1F(c3q);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C05272f
    public final boolean A09(View view, int i2, Bundle bundle) {
        if (super.A09(view, i2, bundle)) {
            String[] strArr = A02;
            if (strArr[2].charAt(11) != strArr[0].charAt(11)) {
                throw new RuntimeException();
            }
            A02[4] = "nByhcE3HAON4xHhAaRL71J2smf2uyoDS";
            return true;
        } else if (!A0B() && this.A01.getLayoutManager() != null) {
            C4M layoutManager = this.A01.getLayoutManager();
            if (A02[5].length() != 3) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[7] = "ZdbAAVtg";
            strArr2[3] = "rBKlzqXoYmUf6BYv0O8fT1";
            return layoutManager.A1Z(i2, bundle);
        } else {
            return false;
        }
    }

    public final C05272f A0A() {
        return this.A00;
    }

    public final boolean A0B() {
        return this.A01.A1t();
    }
}
