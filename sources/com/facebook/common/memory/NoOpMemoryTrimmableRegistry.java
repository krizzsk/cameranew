package com.facebook.common.memory;
/* loaded from: classes.dex */
public class NoOpMemoryTrimmableRegistry implements c {
    private static NoOpMemoryTrimmableRegistry a;

    public static synchronized NoOpMemoryTrimmableRegistry getInstance() {
        NoOpMemoryTrimmableRegistry noOpMemoryTrimmableRegistry;
        synchronized (NoOpMemoryTrimmableRegistry.class) {
            if (a == null) {
                a = new NoOpMemoryTrimmableRegistry();
            }
            noOpMemoryTrimmableRegistry = a;
        }
        return noOpMemoryTrimmableRegistry;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
