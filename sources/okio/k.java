package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
/* compiled from: Timeout.java */
/* loaded from: classes3.dex */
public class k {
    private boolean a;
    private long b;

    public void a() throws IOException {
        if (!Thread.interrupted()) {
            if (this.a && this.b - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    }
}
