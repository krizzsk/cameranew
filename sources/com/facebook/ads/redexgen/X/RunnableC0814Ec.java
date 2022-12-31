package com.facebook.ads.redexgen.X;

import android.os.ConditionVariable;
/* renamed from: com.facebook.ads.redexgen.X.Ec  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class RunnableC0814Ec implements Runnable {
    public final /* synthetic */ ConditionVariable A00;

    @Override // java.lang.Runnable
    public final void run() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A00.open();
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
