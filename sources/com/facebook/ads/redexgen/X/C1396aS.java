package com.facebook.ads.redexgen.X;

import android.content.pm.ConfigurationInfo;
/* renamed from: com.facebook.ads.redexgen.X.aS  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1396aS implements InterfaceC06356k {
    public final /* synthetic */ C1392aO A00;

    public C1396aS(C1392aO c1392aO) {
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
            return c1392aO.A04(configurationInfo2.reqTouchScreen);
        }
        return this.A00.A07(EnumC06466v.A07);
    }
}
