package com.tencent.stat.common;

import android.content.Context;
/* loaded from: classes3.dex */
public class f {
    static long a = -1;

    static long a(Context context, String str) {
        return p.a(context, str, a);
    }

    static void a(Context context, String str, long j2) {
        p.b(context, str, j2);
    }

    public static synchronized boolean a(Context context) {
        boolean z;
        synchronized (f.class) {
            long a2 = a(context, "1.6.2_begin_protection");
            long a3 = a(context, "1.6.2_end__protection");
            if (a2 <= 0 || a3 != a) {
                if (a2 == a) {
                    a(context, "1.6.2_begin_protection", System.currentTimeMillis());
                }
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public static synchronized void b(Context context) {
        synchronized (f.class) {
            if (a(context, "1.6.2_end__protection") == a) {
                a(context, "1.6.2_end__protection", System.currentTimeMillis());
            }
        }
    }
}
