package com.facebook.ads.redexgen.X;

import android.media.AudioManager;
/* renamed from: com.facebook.ads.redexgen.X.Zz  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1367Zz implements InterfaceC06356k {
    public final /* synthetic */ C1364Zw A00;

    public C1367Zz(C1364Zw c1364Zw) {
        this.A00 = c1364Zw;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        AudioManager audioManager;
        C1364Zw c1364Zw = this.A00;
        audioManager = c1364Zw.A00;
        return c1364Zw.A04(audioManager.getRingerMode());
    }
}
