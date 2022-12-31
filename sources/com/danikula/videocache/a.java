package com.danikula.videocache;
/* compiled from: Cache.java */
/* loaded from: classes.dex */
public interface a {
    long available() throws ProxyCacheException;

    void close() throws ProxyCacheException;

    void complete() throws ProxyCacheException;

    boolean d();

    void e(byte[] bArr, int i2) throws ProxyCacheException;

    int f(byte[] bArr, long j2, int i2) throws ProxyCacheException;
}
