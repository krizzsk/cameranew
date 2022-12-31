package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
/* compiled from: BufferedSource.java */
/* loaded from: classes.dex */
public interface e extends s, ReadableByteChannel {
    long a(byte b) throws IOException;

    void a(long j2) throws IOException;

    void a(byte[] bArr) throws IOException;

    @Deprecated
    c c();

    f c(long j2) throws IOException;

    String e(long j2) throws IOException;

    boolean e() throws IOException;

    InputStream f();

    byte[] g(long j2) throws IOException;

    byte h() throws IOException;

    void h(long j2) throws IOException;

    short i() throws IOException;

    int j() throws IOException;

    short k() throws IOException;

    int l() throws IOException;

    long m() throws IOException;

    String p() throws IOException;
}
