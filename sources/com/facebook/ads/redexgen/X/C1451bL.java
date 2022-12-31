package com.facebook.ads.redexgen.X;

import android.view.View;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;
/* renamed from: com.facebook.ads.redexgen.X.bL  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1451bL implements MU {
    public static String[] A01 = {"JdxG2e87fiw1QxhKtyp6wy4hCZ34K54h", "5l6PiVFmWkFi4LSRmzN6ZIbVVY4PyA16", "qh41B7qjlQhNnOsbjTqj3JtjZfsrgLHf", "L6JKyztUTZrhaC2oSi2AGhNMneOalgfU", "mLvzPn8zSeH", "6Oneq6t5dYPlbDhRy7qxaYTJsizasisX", "J8", "lXMgpjBtmdYXVX4s4nwhe"};
    public final WeakReference<AnonymousClass52> A00;

    public C1451bL(AnonymousClass52 anonymousClass52) {
        this.A00 = new WeakReference<>(anonymousClass52);
    }

    private void A00(AnonymousClass52 anonymousClass52) {
        PM pm;
        RelativeLayout relativeLayout;
        pm = anonymousClass52.A0C;
        if (pm != null) {
            relativeLayout = anonymousClass52.A06;
            relativeLayout.bringChildToFront(pm);
        }
    }

    @Override // com.facebook.ads.redexgen.X.MU
    public final void A3G(View view, int i2, RelativeLayout.LayoutParams layoutParams) {
        RelativeLayout relativeLayout;
        AnonymousClass52 anonymousClass52 = this.A00.get();
        if (anonymousClass52 != null) {
            relativeLayout = anonymousClass52.A06;
            relativeLayout.addView(view, i2, layoutParams);
            A00(anonymousClass52);
        }
    }

    @Override // com.facebook.ads.redexgen.X.MU
    public final void A3H(View view, RelativeLayout.LayoutParams layoutParams) {
        RelativeLayout relativeLayout;
        AnonymousClass52 anonymousClass52 = this.A00.get();
        if (anonymousClass52 != null) {
            relativeLayout = anonymousClass52.A06;
            relativeLayout.addView(view, layoutParams);
            A00(anonymousClass52);
        }
    }

    @Override // com.facebook.ads.redexgen.X.MU
    public void A3q(String str) {
        if (this.A00.get() != null) {
            this.A00.get().A0D(str);
        }
    }

    @Override // com.facebook.ads.redexgen.X.MU
    public void A3r(String str, C9N c9n) {
        if (this.A00.get() != null) {
            this.A00.get().A0F(str, c9n);
        }
    }

    @Override // com.facebook.ads.redexgen.X.MU
    public final void A8a(String str, C1S c1s) {
        if (this.A00.get() != null) {
            AnonymousClass52 anonymousClass52 = this.A00.get();
            String[] strArr = A01;
            if (strArr[0].charAt(19) != strArr[1].charAt(19)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[0] = "LaehfLm13EgRqqa58La6JsJDVjNkKsjm";
            strArr2[1] = "U7opStToMRhy5hKGwjx6Oh4Ofub1lgfJ";
            anonymousClass52.A0E(str, c1s);
        }
    }

    @Override // com.facebook.ads.redexgen.X.MU
    public final void AA3(int i2) {
        AnonymousClass52 anonymousClass52 = this.A00.get();
        if (anonymousClass52 != null) {
            anonymousClass52.finish(i2);
        }
    }
}
