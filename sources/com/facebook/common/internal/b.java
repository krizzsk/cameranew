package com.facebook.common.internal;

import androidx.annotation.VisibleForTesting;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
/* compiled from: Closeables.java */
/* loaded from: classes.dex */
public final class b {
    @VisibleForTesting
    static final Logger a = Logger.getLogger(b.class.getName());

    private b() {
    }

    public static void a(@Nullable Closeable closeable, boolean z) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e2) {
            if (z) {
                a.log(Level.WARNING, "IOException thrown while closing Closeable.", (Throwable) e2);
                return;
            }
            throw e2;
        }
    }

    public static void b(@Nullable InputStream inputStream) {
        try {
            a(inputStream, true);
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
