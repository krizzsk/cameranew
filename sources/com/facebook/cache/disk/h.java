package com.facebook.cache.disk;

import java.io.IOException;
import javax.annotation.Nullable;
/* compiled from: FileCache.java */
/* loaded from: classes.dex */
public interface h extends com.facebook.common.disk.a {
    boolean a(com.facebook.cache.common.b bVar);

    @Nullable
    com.facebook.binaryresource.a b(com.facebook.cache.common.b bVar);

    boolean c(com.facebook.cache.common.b bVar);

    void d(com.facebook.cache.common.b bVar);

    boolean e(com.facebook.cache.common.b bVar);

    @Nullable
    com.facebook.binaryresource.a f(com.facebook.cache.common.b bVar, com.facebook.cache.common.f fVar) throws IOException;
}
