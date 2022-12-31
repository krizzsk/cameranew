package com.google.android.gms.common.util.v;

import android.os.Process;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
final class c implements Runnable {
    private final Runnable a;
    private final int b;

    public c(Runnable runnable, int i2) {
        this.a = runnable;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.b);
        this.a.run();
    }
}
