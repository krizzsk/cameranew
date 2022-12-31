package com.facebook.ads.redexgen.X;

import android.content.ContentResolver;
import android.content.Context;
import android.util.DisplayMetrics;
/* loaded from: assets/audience_network.dex */
public final class Z3 extends C06266b {
    public ContentResolver A00;
    public DisplayMetrics A01;

    public Z3(Context context, AnonymousClass61 anonymousClass61) {
        super(context, anonymousClass61);
        this.A01 = context.getResources().getDisplayMetrics();
        this.A00 = context.getContentResolver();
    }

    public final InterfaceC06356k A0G() {
        return new Z4(this);
    }

    public final InterfaceC06356k A0H() {
        return new Z7(this);
    }

    public final InterfaceC06356k A0I() {
        return new Z6(this);
    }

    public final InterfaceC06356k A0J() {
        return new Z8(this);
    }

    public final InterfaceC06356k A0K() {
        return new Z5(this);
    }
}
