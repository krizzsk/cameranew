package com.facebook.ads.redexgen.X;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.1K  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C1K implements Serializable {
    public static final long serialVersionUID = -2102939945352398575L;
    public final List<String> A00;

    public C1K(List<String> screenshots) {
        this.A00 = screenshots;
    }

    public final List<String> A00() {
        return Collections.unmodifiableList(this.A00);
    }
}
