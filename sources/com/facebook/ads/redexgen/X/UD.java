package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public final class UD implements InterfaceC1592dm<JJ, JO> {
    public UA A00;

    public UD(UA ua) {
        this.A00 = ua;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.dj != com.instagram.common.viewpoint.core.ViewpointData<com.facebook.ads.internal.impressionsecondchannel.model.Impression, com.facebook.ads.internal.impressionsecondchannel.state.ImpressionState> */
    @Override // com.facebook.ads.redexgen.X.InterfaceC1592dm
    public final void A5F(C1589dj<JJ, JO> c1589dj, InterfaceC1578dY interfaceC1578dY) {
        int i2 = JH.A00[interfaceC1578dY.A7g(c1589dj).ordinal()];
        if (i2 != 1 && i2 != 2) {
            return;
        }
        this.A00.A02(c1589dj, interfaceC1578dY);
    }
}
