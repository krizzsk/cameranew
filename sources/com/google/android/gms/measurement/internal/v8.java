package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.util.Clock;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class v8 {
    private final Clock a;
    private long b;

    public v8(Clock clock) {
        com.google.android.gms.common.internal.q.j(clock);
        this.a = clock;
    }

    public final void a() {
        this.b = this.a.a();
    }

    public final void b() {
        this.b = 0L;
    }

    public final boolean c(long j2) {
        return this.b == 0 || this.a.a() - this.b >= 3600000;
    }
}
