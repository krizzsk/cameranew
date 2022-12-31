package com.pinguo.album.data.download;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: IoUtils.java */
/* loaded from: classes3.dex */
public final class b {
    public static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (Exception unused) {
        }
    }

    public static void b(InputStream inputStream) {
        do {
            try {
            } catch (IOException unused) {
            } catch (Throwable th) {
                a(inputStream);
                throw th;
            }
        } while (inputStream.read(new byte[32768], 0, 32768) != -1);
        a(inputStream);
    }
}
