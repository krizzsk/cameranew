package com.facebook.ads.redexgen.X;

import android.os.Handler;
/* loaded from: assets/audience_network.dex */
public final class F5 extends TI<C1505cM> {
    public static String[] A00 = {"ByMq6MLqhjUJsdWB3RBIp", "zuOr3", "msyHKBX3wHVeYE5obxbctQprcgEzI02t", "I3sOgeRwcNYGF4oixOV5Q17", "dcB", "ibtCqc8qysdz0E5AMIDmPhuL1XZA", "mNtKCg4kzaH6sXUtb2oDuqx2", "ObFvkEusatMYzjWaq72f4FkWXHrQjerH"};

    public F5(C1505cM c1505cM) {
        super(c1505cM);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        XT xt;
        Handler handler;
        Runnable runnable;
        C1505cM A07 = A07();
        if (A07 == null) {
            return;
        }
        xt = A07.A08;
        String[] strArr = A00;
        if (strArr[3].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        A00[5] = "SiVLKh";
        if (MM.A02(xt)) {
            A07.A07();
            return;
        }
        handler = A07.A05;
        runnable = A07.A0C;
        handler.postDelayed(runnable, 5000L);
    }
}
