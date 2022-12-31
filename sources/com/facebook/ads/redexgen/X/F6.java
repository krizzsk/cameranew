package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public final class F6 extends AbstractC1511cS {
    public static byte[] A00;
    public static String[] A01 = {"d7tLiGkqyLa7cKOkED7RtvmpIXZH8d0b", "LmA4T64r6T9e", "1EBtOKlPck0twYp3ElEJQmg3d", "uhXcdOUibAChEZNBNQuPqKRIQ2", "Z", "LV0o53GlcsqgEYK9Pr4EwymnJShooL9b", "NLZosIPt4DzrQXhRsvqwWEHVFOTX5bDJ", "MQasnwh7q"};

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 52);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{77, 72, 12, 69, 95, 12, 66, 67, 88, 12, 94, 73, 77, 72, 85, 12, 67, 94, 12, 77, 64, 94, 73, 77, 72, 85, 12, 72, 69, 95, 92, 64, 77, 85, 73, 72, 56, 57, 48, 61, 37};
    }

    static {
        A03();
    }

    public F6(XT xt, C05111o c05111o) {
        super(xt, c05111o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> A01(long j2) {
        HashMap hashMap = new HashMap();
        hashMap.put(A00(36, 5, 104), String.valueOf(System.currentTimeMillis() - j2));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05(List<String> list, Map<String, String> map) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            String[] strArr = A01;
            if (strArr[2].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            A01[0] = "jDIZMq7wlAdnEmkEGDRuOyHBIh8qxobs";
            if (hasNext) {
                new AsyncTaskC1136Qz(this.A0B, map).execute(it.next());
            } else {
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1511cS
    public final void A0J() {
        C1543cy c1543cy = (C1543cy) this.A01;
        if (c1543cy.A0h()) {
            this.A06.A0B(c1543cy);
            return;
        }
        throw new IllegalStateException(A00(0, 36, 24));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1511cS
    public final void A0L(InterfaceC04840n interfaceC04840n, AnonymousClass94 anonymousClass94, AnonymousClass92 anonymousClass92, C05121p c05121p) {
        C1543cy c1543cy = (C1543cy) interfaceC04840n;
        long currentTimeMillis = System.currentTimeMillis();
        C1508cP c1508cP = new C1508cP(this, c05121p, c1543cy, currentTimeMillis, anonymousClass92);
        A0C().postDelayed(c1508cP, anonymousClass94.A05().A05());
        c1543cy.A0Z(this.A0B, new C1507cO(this, c1508cP, currentTimeMillis, anonymousClass92), this.A08, c05121p, C1198Tj.A0I());
    }
}
