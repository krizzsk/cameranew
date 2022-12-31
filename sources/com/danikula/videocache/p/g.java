package com.danikula.videocache.p;

import java.io.File;
/* compiled from: TotalSizeLruDiskUsage.java */
/* loaded from: classes.dex */
public class g extends e {
    private final long c;

    public g(long j2) {
        if (j2 > 0) {
            this.c = j2;
            return;
        }
        throw new IllegalArgumentException("Max size must be positive number!");
    }

    @Override // com.danikula.videocache.p.e
    protected boolean b(File file, long j2, int i2) {
        return j2 <= this.c;
    }
}
