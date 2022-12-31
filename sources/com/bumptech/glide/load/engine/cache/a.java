package com.bumptech.glide.load.engine.cache;

import java.io.File;
/* compiled from: DiskCache.java */
/* loaded from: classes.dex */
public interface a {

    /* compiled from: DiskCache.java */
    /* renamed from: com.bumptech.glide.load.engine.cache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0031a {
        a build();
    }

    /* compiled from: DiskCache.java */
    /* loaded from: classes.dex */
    public interface b {
        boolean a(File file);
    }

    void a(com.bumptech.glide.load.b bVar, b bVar2);

    File b(com.bumptech.glide.load.b bVar);

    void c(com.bumptech.glide.load.b bVar);
}
