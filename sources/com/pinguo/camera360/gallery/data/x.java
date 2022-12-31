package com.pinguo.camera360.gallery.data;

import java.util.ArrayList;
/* compiled from: MediaObject.java */
/* loaded from: classes3.dex */
public abstract class x {
    private static long c;
    protected long a;
    protected final Path b;

    public x(Path path, long j2) {
        path.j(this);
        this.b = path;
        this.a = j2;
    }

    public static synchronized long j() {
        long j2;
        synchronized (x.class) {
            j2 = c + 1;
            c = j2;
        }
        return j2;
    }

    public void c(boolean z) {
        throw new UnsupportedOperationException();
    }

    public long d() {
        return this.a;
    }

    public v e() {
        return new v();
    }

    public int f() {
        return 1;
    }

    public Path g() {
        return this.b;
    }

    public int h() {
        return 0;
    }

    public void i(ArrayList<Integer> arrayList) {
    }
}
