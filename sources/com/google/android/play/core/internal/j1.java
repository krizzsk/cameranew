package com.google.android.play.core.internal;

import java.io.PrintStream;
/* loaded from: classes2.dex */
public final class j1 {
    static final d1 a;

    static {
        d1 h1Var;
        Integer num = null;
        try {
            try {
                num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Exception e2) {
                System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
                e2.printStackTrace(System.err);
            }
            h1Var = (num == null || num.intValue() < 19) ? !Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? new g1() : new h1() : new i1();
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = h1.class.getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 133);
            sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
            sb.append(name);
            sb.append("will be used. The error is: ");
            printStream.println(sb.toString());
            th.printStackTrace(System.err);
            h1Var = new h1();
        }
        a = h1Var;
        if (num == null) {
            return;
        }
        num.intValue();
    }

    public static void a(Throwable th, Throwable th2) {
        a.a(th, th2);
    }
}
