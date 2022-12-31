package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public class G5 implements InterfaceC1593dn {
    public final List<Cdo> A00 = new ArrayList();

    @Override // com.facebook.ads.redexgen.X.InterfaceC1593dn
    public final Cdo A5V(int i2) {
        return this.A00.get(i2);
    }

    @Override // java.lang.Iterable
    public final Iterator<Cdo> iterator() {
        return this.A00.iterator();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1593dn
    public final int size() {
        return this.A00.size();
    }
}
