package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdPlacementType;
/* renamed from: com.facebook.ads.redexgen.X.0s  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C04890s {
    public static InterfaceC04840n A00;

    public final InterfaceC04840n A00(AdPlacementType adPlacementType) {
        InterfaceC04840n interfaceC04840n = A00;
        if (interfaceC04840n != null) {
            return interfaceC04840n;
        }
        int i2 = C04880r.A00[adPlacementType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            return null;
                        }
                        return new FB();
                    }
                    return new FD();
                }
                return new C1543cy();
            }
            return new C1545d0();
        }
        return new C1546d1();
    }
}
