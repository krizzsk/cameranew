package com.facebook.ads.redexgen.X;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* renamed from: com.facebook.ads.redexgen.X.dW  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1576dW {
    public final Map<String, C1589dj> A00;
    public final Set<C1589dj> A01;

    public C1576dW() {
        this.A00 = new HashMap();
        this.A01 = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Collection<C1589dj> A00() {
        return this.A01;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Collection<C1589dj> A01() {
        return this.A00.values();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04() {
        this.A00.clear();
        for (C1589dj c1589dj : this.A01) {
            this.A00.put(c1589dj.A03, c1589dj);
        }
        this.A01.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A06(C1589dj c1589dj) {
        if (this.A01.add(c1589dj)) {
            this.A00.remove(c1589dj.A03);
            return true;
        }
        return false;
    }
}
