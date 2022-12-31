package com.google.android.gms.internal.firebase_messaging;

import com.tapjoy.TJAdUnitConstants;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* compiled from: com.google.firebase:firebase-messaging@@21.0.1 */
/* loaded from: classes2.dex */
public final class zzh {
    static final Logger zza = Logger.getLogger(zzh.class.getName());

    private zzh() {
    }

    public static void zza(@NullableDecl InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (IOException e2) {
            try {
                zza.logp(Level.WARNING, "com.google.common.io.Closeables", TJAdUnitConstants.String.CLOSE, "IOException thrown while closing Closeable.", (Throwable) e2);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }
    }
}
