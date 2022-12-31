package com.facebook.ads.redexgen.X;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* renamed from: com.facebook.ads.redexgen.X.Bw  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0766Bw {
    public final CopyOnWriteArrayList<C0765Bv> A00 = new CopyOnWriteArrayList<>();

    public final void A00() {
        Iterator<C0765Bv> it = this.A00.iterator();
        while (it.hasNext()) {
            C0765Bv handlerAndListener = it.next();
            handlerAndListener.A00.post(new RunnableC0761Br(this, handlerAndListener.A01));
        }
    }

    public final void A01() {
        Iterator<C0765Bv> it = this.A00.iterator();
        while (it.hasNext()) {
            C0765Bv handlerAndListener = it.next();
            handlerAndListener.A00.post(new RunnableC0764Bu(this, handlerAndListener.A01));
        }
    }

    public final void A02() {
        Iterator<C0765Bv> it = this.A00.iterator();
        while (it.hasNext()) {
            C0765Bv handlerAndListener = it.next();
            handlerAndListener.A00.post(new RunnableC0763Bt(this, handlerAndListener.A01));
        }
    }

    public final void A03(Handler handler, InterfaceC0767Bx interfaceC0767Bx) {
        I6.A03((handler == null || interfaceC0767Bx == null) ? false : true);
        this.A00.add(new C0765Bv(handler, interfaceC0767Bx));
    }

    public final void A04(Exception exc) {
        Iterator<C0765Bv> it = this.A00.iterator();
        while (it.hasNext()) {
            C0765Bv next = it.next();
            next.A00.post(new RunnableC0762Bs(this, next.A01, exc));
        }
    }
}
