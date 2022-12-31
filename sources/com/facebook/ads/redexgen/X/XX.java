package com.facebook.ads.redexgen.X;

import android.os.Handler;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: assets/audience_network.dex */
public class XX extends AbstractRunnableC0981Kv {
    public final /* synthetic */ C7B A00;
    public final /* synthetic */ C7C A01;
    public final /* synthetic */ C7J A02;
    public final /* synthetic */ ArrayList A03;
    public final /* synthetic */ ArrayList A04;

    public XX(C7J c7j, ArrayList arrayList, C7B c7b, C7C c7c, ArrayList arrayList2) {
        this.A02 = c7j;
        this.A03 = arrayList;
        this.A00 = c7b;
        this.A01 = c7c;
        this.A04 = arrayList2;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        AtomicBoolean A0C;
        C8J c8j;
        Handler handler;
        C8J c8j2;
        long j2;
        long j3;
        A0C = C7J.A0C(this.A03);
        c8j = this.A02.A04;
        if (c8j instanceof XT) {
            c8j2 = this.A02.A04;
            XT xt = (XT) c8j2;
            if (A0C.get()) {
                C0R A0D = xt.A0D();
                j3 = this.A02.A00;
                A0D.A3u(C1008Ly.A01(j3));
            } else {
                C0R A0D2 = xt.A0D();
                j2 = this.A02.A00;
                A0D2.A3t(C1008Ly.A01(j2));
            }
        }
        handler = this.A02.A02;
        handler.post(new XY(this, A0C));
        C7J.A0C(this.A04);
    }
}
