package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
/* renamed from: com.facebook.ads.redexgen.X.bp  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1479bp extends C05272f {
    public static String[] A01 = {"qdMAGnvFuVn0ea0M3RnyzUUMgxm0S2Dt", "2PeyHnmE0bX58Ffgk0gx7OXrgxltyZLW", "2int", "nVrienaBQfkWnV6qIsNJmuY2fGTgVaBy", "EIAfoPo9YRxYx4hqHxVbjlkHHJjThpFm", "", "SPMlRY4DBSEQqdOiv1Q7wDslDeTbAa0F", "kfFOHzhabps7JVIWzUifit9US33gkwJk"};
    public final /* synthetic */ C3F A00;

    public C1479bp(C3F c3f) {
        this.A00 = c3f;
    }

    private boolean A00() {
        return this.A00.A01 != null && this.A00.A01.A05() > 1;
    }

    @Override // com.facebook.ads.redexgen.X.C05272f
    public final void A07(View view, AccessibilityEvent accessibilityEvent) {
        super.A07(view, accessibilityEvent);
        accessibilityEvent.setClassName(C3F.class.getName());
        accessibilityEvent.setScrollable(A00());
        if (accessibilityEvent.getEventType() == 4096 && this.A00.A01 != null) {
            accessibilityEvent.setItemCount(this.A00.A01.A05());
            accessibilityEvent.setFromIndex(this.A00.A00);
            accessibilityEvent.setToIndex(this.A00.A00);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C05272f
    public final void A08(View view, C3Q c3q) {
        super.A08(view, c3q);
        c3q.A0O(C3F.class.getName());
        c3q.A0R(A00());
        if (this.A00.canScrollHorizontally(1)) {
            c3q.A0N(4096);
        }
        if (this.A00.canScrollHorizontally(-1)) {
            c3q.A0N(8192);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C05272f
    public final boolean A09(View view, int i2, Bundle bundle) {
        if (super.A09(view, i2, bundle)) {
            return true;
        }
        if (i2 != 4096) {
            if (i2 == 8192 && this.A00.canScrollHorizontally(-1)) {
                C3F c3f = this.A00;
                c3f.setCurrentItem(c3f.A00 - 1);
                return true;
            }
            return false;
        }
        C3F c3f2 = this.A00;
        String[] strArr = A01;
        if (strArr[3].charAt(13) != strArr[7].charAt(13)) {
            throw new RuntimeException();
        }
        A01[4] = "Vr8sNFSEZwclN9wLDYuYxTMloU2ohTqa";
        if (c3f2.canScrollHorizontally(1)) {
            C3F c3f3 = this.A00;
            c3f3.setCurrentItem(c3f3.A00 + 1);
            return true;
        }
        return false;
    }
}
