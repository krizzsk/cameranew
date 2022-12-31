package com.facebook.ads.redexgen.X;

import android.os.Build;
import java.util.Locale;
/* renamed from: com.facebook.ads.redexgen.X.Yp  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1331Yp implements InterfaceC06356k {
    public final /* synthetic */ C1329Yn A00;

    public C1331Yp(C1329Yn c1329Yn) {
        this.A00 = c1329Yn;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        if (Build.VERSION.SDK_INT < 21) {
            return this.A00.A07(EnumC06466v.A05);
        }
        return this.A00.A08(Locale.getDefault().getScript());
    }
}
