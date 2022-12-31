package com.facebook.cache.disk;

import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;
/* compiled from: DiskStorage.java */
/* loaded from: classes.dex */
public interface c {

    /* compiled from: DiskStorage.java */
    /* loaded from: classes.dex */
    public interface a {
        long a();

        String getId();

        long getSize();
    }

    /* compiled from: DiskStorage.java */
    /* loaded from: classes.dex */
    public interface b {
        boolean B();

        void C(com.facebook.cache.common.f fVar, Object obj) throws IOException;

        com.facebook.binaryresource.a D(Object obj) throws IOException;
    }

    void a();

    boolean b(String str, Object obj) throws IOException;

    long c(a aVar) throws IOException;

    b d(String str, Object obj) throws IOException;

    boolean e(String str, Object obj) throws IOException;

    @Nullable
    com.facebook.binaryresource.a f(String str, Object obj) throws IOException;

    Collection<a> g() throws IOException;

    boolean isExternal();

    long remove(String str) throws IOException;
}
