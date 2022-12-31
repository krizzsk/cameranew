package com.bytedance.sdk.openadsdk.i;

import java.util.UUID;
import us.pinguo.common.network.common.header.PGTransHeader;
/* compiled from: TTRunnable.java */
/* loaded from: classes.dex */
public abstract class b implements Comparable<b>, Runnable {
    private int a;
    private String b;

    public b(int i2) {
        this.a = -1;
        this.a = i2 == -1 ? 5 : i2;
        this.b = UUID.randomUUID().toString() + PGTransHeader.CONNECTOR + String.valueOf(System.nanoTime());
    }

    public int a() {
        return this.a;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(b bVar) {
        if (a() < bVar.a()) {
            return 1;
        }
        return a() > bVar.a() ? -1 : 0;
    }

    public b() {
        this.a = -1;
        this.a = 5;
        this.b = UUID.randomUUID().toString() + PGTransHeader.CONNECTOR + String.valueOf(System.nanoTime());
    }
}
