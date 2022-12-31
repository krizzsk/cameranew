package com.facebook.ads.redexgen.X;

import android.content.pm.ConfigurationInfo;
/* renamed from: com.facebook.ads.redexgen.X.aW  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1400aW implements InterfaceC06356k {
    public final /* synthetic */ C1392aO A00;

    public C1400aW(C1392aO c1392aO) {
        this.A00 = c1392aO;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        ConfigurationInfo configurationInfo;
        ConfigurationInfo configurationInfo2;
        configurationInfo = this.A00.A00;
        if (configurationInfo != null) {
            C1392aO c1392aO = this.A00;
            configurationInfo2 = c1392aO.A00;
            return c1392aO.A08(configurationInfo2.getGlEsVersion());
        }
        return this.A00.A07(EnumC06466v.A07);
    }
}
