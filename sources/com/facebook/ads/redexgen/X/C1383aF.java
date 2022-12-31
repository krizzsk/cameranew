package com.facebook.ads.redexgen.X;

import android.content.Context;
import java.io.File;
/* renamed from: com.facebook.ads.redexgen.X.aF  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1383aF implements InterfaceC06356k {
    public final /* synthetic */ C1371a3 A00;

    public C1383aF(C1371a3 c1371a3) {
        this.A00 = c1371a3;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        Context context;
        context = this.A00.A00;
        return this.A00.A06(new File(context.getApplicationInfo().publicSourceDir).length());
    }
}
