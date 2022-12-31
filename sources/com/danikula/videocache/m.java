package com.danikula.videocache;
/* compiled from: Source.java */
/* loaded from: classes.dex */
public interface m {
    void a(long j2) throws ProxyCacheException;

    void close() throws ProxyCacheException;

    long length() throws ProxyCacheException;

    int read(byte[] bArr) throws ProxyCacheException;
}
