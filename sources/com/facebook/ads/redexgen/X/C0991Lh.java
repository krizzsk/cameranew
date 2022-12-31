package com.facebook.ads.redexgen.X;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
/* renamed from: com.facebook.ads.redexgen.X.Lh  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0991Lh extends Thread implements Closeable {
    public static String[] A02 = {"TlcI8clPy2cAxmBQLm6V1herqnmAITse", "yZ5kpCkqR1osI6zLxCntBCQkuWvFDLL5", "q2c", "jrNyDVk0HDDQUaPHkyGFAgSqoyhAwgQL", "WhGkB9GwGiTJZue6wwGhsu4RprprQOI3", "P0d", "2ZYrdgfLM", "x3INJ1jAMxJto"};
    public boolean A00 = false;
    public final /* synthetic */ C0992Li A01;

    public C0991Lh(C0992Li c0992Li) {
        this.A01 = c0992Li;
        start();
    }

    public final synchronized void A00() {
        C0990Lg c0990Lg;
        c0990Lg = this.A01.A02;
        c0990Lg.A02();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        C0990Lg c0990Lg;
        synchronized (this) {
            this.A00 = true;
            c0990Lg = this.A01.A02;
            c0990Lg.A02();
        }
        try {
            join();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
        if (r1 == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
        r0 = r5.A01.A03;
        r0.run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004d, code lost:
        r2 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x005b, code lost:
        monitor-enter(r5.A01);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x005c, code lost:
        r0 = r5.A01.A02;
        r0.A03();
        r5.A01.A00 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x006b, code lost:
        throw r2;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0055 -> B:39:0x0056). Please submit an issue!!! */
    @Override // java.lang.Thread, java.lang.Runnable
    @android.annotation.SuppressLint({"CatchGeneralException"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 178
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0991Lh.run():void");
    }
}
