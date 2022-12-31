package com.google.android.play.core.internal;

import android.os.Build;
import java.io.File;
import us.pinguo.common.network.common.header.PGTransHeader;
/* loaded from: classes2.dex */
public final class y {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static x a() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            switch (i2) {
                case 21:
                    return new e0();
                case 22:
                    return new f0();
                case 23:
                    return new j0();
                case 24:
                    return new k0();
                case 25:
                    return new l0();
                case 26:
                    return new o0();
                case 27:
                    if (Build.VERSION.PREVIEW_SDK_INT == 0) {
                        return new p0();
                    }
                    break;
            }
            return new r0();
        }
        throw new AssertionError("Unsupported Android Version");
    }

    public static String b(File file) {
        if (file.getName().endsWith(".apk")) {
            return file.getName().replaceFirst("(_\\d+)?\\.apk", "").replace("base-", "config.").replace(PGTransHeader.CONNECTOR, ".config.").replace(".config.master", "").replace("config.master", "");
        }
        throw new IllegalArgumentException("Non-apk found in splits directory.");
    }

    public static <T> void c(T t, Object obj) {
        if (t == null) {
            throw new NullPointerException((String) obj);
        }
    }

    public static void d(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
