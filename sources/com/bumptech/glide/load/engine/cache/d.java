package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.a;
import java.io.File;
/* compiled from: DiskLruCacheFactory.java */
/* loaded from: classes.dex */
public class d implements a.InterfaceC0031a {
    private final int a;
    private final a b;

    /* compiled from: DiskLruCacheFactory.java */
    /* loaded from: classes.dex */
    public interface a {
        File a();
    }

    public d(a aVar, int i2) {
        this.a = i2;
        this.b = aVar;
    }

    @Override // com.bumptech.glide.load.engine.cache.a.InterfaceC0031a
    public com.bumptech.glide.load.engine.cache.a build() {
        File a2 = this.b.a();
        if (a2 == null) {
            return null;
        }
        if (a2.mkdirs() || (a2.exists() && a2.isDirectory())) {
            return e.d(a2, this.a);
        }
        return null;
    }
}
