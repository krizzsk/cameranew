package com.facebook.ads.redexgen.X;

import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
/* renamed from: com.facebook.ads.redexgen.X.Ym  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1328Ym implements InterfaceC06356k {
    public final /* synthetic */ C1326Yk A00;

    public C1328Ym(C1326Yk c1326Yk) {
        this.A00 = c1326Yk;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() throws Exception {
        AbstractC06506z A02;
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        HashMap hashMap = new HashMap();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface nextElement = networkInterfaces.nextElement();
            hashMap.put(nextElement.getDisplayName(), new C1327Yl(nextElement.getInetAddresses(), null));
        }
        A02 = this.A00.A02(hashMap);
        return A02;
    }
}
