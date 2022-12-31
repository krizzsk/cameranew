package com.facebook.common.disk;

import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class NoOpDiskTrimmableRegistry implements b {
    @Nullable
    private static NoOpDiskTrimmableRegistry a;

    private NoOpDiskTrimmableRegistry() {
    }

    public static synchronized NoOpDiskTrimmableRegistry getInstance() {
        NoOpDiskTrimmableRegistry noOpDiskTrimmableRegistry;
        synchronized (NoOpDiskTrimmableRegistry.class) {
            if (a == null) {
                a = new NoOpDiskTrimmableRegistry();
            }
            noOpDiskTrimmableRegistry = a;
        }
        return noOpDiskTrimmableRegistry;
    }

    @Override // com.facebook.common.disk.b
    public void a(a aVar) {
    }
}
