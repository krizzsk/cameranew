package com.facebook.imagepipeline.nativecode;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* compiled from: WebpTranscoder.java */
/* loaded from: classes.dex */
public interface f {
    void a(InputStream inputStream, OutputStream outputStream) throws IOException;

    boolean b(com.facebook.imageformat.c cVar);

    void c(InputStream inputStream, OutputStream outputStream, int i2) throws IOException;
}
