package com.bytedance.sdk.openadsdk.h;
/* compiled from: IncrementalTimeout.java */
/* loaded from: classes.dex */
public class c {
    private final long a;
    private final long b;
    private final long c;

    public long a(int i2) {
        if (i2 <= 0) {
            return this.a;
        }
        return Math.min(this.a + (this.b * i2), this.c);
    }
}
