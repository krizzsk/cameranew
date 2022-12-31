package com.google.android.gms.common.util;

import android.os.SystemClock;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public class h implements Clock {
    private static final h a = new h();

    private h() {
    }

    public static Clock getInstance() {
        return a;
    }

    @Override // com.google.android.gms.common.util.Clock
    public long a() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.gms.common.util.Clock
    public long b() {
        return System.nanoTime();
    }

    @Override // com.google.android.gms.common.util.Clock
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
