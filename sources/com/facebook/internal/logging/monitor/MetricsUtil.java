package com.facebook.internal.logging.monitor;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class MetricsUtil {
    private static MetricsUtil a;

    private MetricsUtil() {
        new HashMap();
    }

    public static synchronized MetricsUtil getInstance() {
        synchronized (MetricsUtil.class) {
            if (com.facebook.internal.instrument.e.a.c(MetricsUtil.class)) {
                return null;
            }
            if (a == null) {
                a = new MetricsUtil();
            }
            return a;
        }
    }
}
