package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
/* renamed from: com.facebook.ads.redexgen.X.7E  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C7E implements Callable<Boolean> {
    public final BlockingQueue<Boolean> A00 = new LinkedBlockingQueue();
    public final /* synthetic */ C7J A01;

    public C7E(C7J c7j, C7I c7i) {
        this.A01 = c7j;
        new Handler(Looper.getMainLooper()).post(new XV(this, c7j, c7i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: A00 */
    public final Boolean call() throws Exception {
        return this.A00.take();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A03(C7I c7i) {
        C8J c8j;
        C8J c8j2;
        c8j = this.A01.A04;
        QN A05 = QN.A05(c8j);
        Uri parse = Uri.parse(c7i.A08);
        long j2 = c7i.A00;
        if (j2 == -1) {
            c8j2 = this.A01.A04;
            j2 = JD.A0M(c8j2);
        }
        A05.A0F(parse, new XU(this), j2);
    }
}
