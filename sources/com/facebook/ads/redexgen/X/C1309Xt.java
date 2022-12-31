package com.facebook.ads.redexgen.X;

import android.icu.util.TimeZone;
import android.os.Build;
/* renamed from: com.facebook.ads.redexgen.X.Xt  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1309Xt implements InterfaceC06356k {
    public static String[] A01 = {"smnl8goxbtEXy2ari0oo94M5wBAsJ", "4jdGfKjJVtKongVqtnlXz1qpag9QmJcO", "6HhyQoH63eZiDTc8tIM8lg1a8XmlaMXL", "TRovmJ8dsKeWsGtAEtnO1NLs5DkGdItv", "EJDQOjfPW", "Fvhxx1JOY2tpNVIZJk2UFnorm88CMjoG", "Hr", "QB67UPOvQOrUPNaLWc8iYWX5dhIe7kRi"};
    public final /* synthetic */ C1308Xs A00;

    public C1309Xt(C1308Xs c1308Xs) {
        this.A00 = c1308Xs;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        if (Build.VERSION.SDK_INT < 24) {
            AbstractC06506z A07 = this.A00.A07(EnumC06466v.A05);
            String[] strArr = A01;
            if (strArr[5].charAt(2) != strArr[2].charAt(2)) {
                throw new RuntimeException();
            }
            A01[0] = "zHpdef4a8sETM0qy6DqDlJHNwIYZi";
            return A07;
        }
        return this.A00.A08(TimeZone.getDefault().getDisplayName());
    }
}
