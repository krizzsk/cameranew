package com.facebook.common.time;
/* compiled from: SystemClock.java */
/* loaded from: classes.dex */
public class c implements a {
    private static final c a = new c();

    private c() {
    }

    public static c a() {
        return a;
    }

    @Override // com.facebook.common.time.a
    public long now() {
        return System.currentTimeMillis();
    }
}
