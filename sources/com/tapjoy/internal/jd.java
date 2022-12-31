package com.tapjoy.internal;

import java.io.InterruptedIOException;
/* loaded from: classes3.dex */
public class jd {
    public static final jd a = new jd() { // from class: com.tapjoy.internal.jd.1
        @Override // com.tapjoy.internal.jd
        public final void a() {
        }
    };
    private boolean b;
    private long c;

    public void a() {
        if (!Thread.interrupted()) {
            if (this.b && this.c - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        throw new InterruptedIOException("thread interrupted");
    }
}
