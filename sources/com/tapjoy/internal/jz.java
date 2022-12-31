package com.tapjoy.internal;

import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public final class jz {
    static final Logger a = Logger.getLogger(jz.class.getName());

    private jz() {
    }

    public static void a(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                try {
                    a.log(Level.WARNING, "IOException thrown while closing Closeable.", (Throwable) e2);
                } catch (IOException e3) {
                    a.log(Level.SEVERE, "IOException should not have been thrown.", (Throwable) e3);
                }
            }
        }
    }
}
