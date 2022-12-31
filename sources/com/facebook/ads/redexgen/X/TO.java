package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Collection;
/* loaded from: assets/audience_network.dex */
public class TO implements InterfaceC0997Ln {
    public final Collection<String> A00;

    public TO() {
        this.A00 = new ArrayList();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0997Ln
    public final void AD2(String str) {
        this.A00.add(str);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0997Ln
    public final void flush() {
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String line : this.A00) {
            sb.append(line);
            sb.append('\n');
        }
        return sb.toString();
    }
}
