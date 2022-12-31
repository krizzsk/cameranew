package com.google.android.gms.internal.measurement;

import java.io.PrintStream;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzfz {
    static final zzft zza;

    static {
        zzft zzfxVar;
        Integer num = null;
        try {
            try {
                num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Exception e2) {
                System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
                e2.printStackTrace(System.err);
            }
            if (num == null || num.intValue() < 19) {
                zzfxVar = !Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? new zzfw() : new zzfx();
            } else {
                zzfxVar = new zzfy();
            }
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = zzfx.class.getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 133);
            sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
            sb.append(name);
            sb.append("will be used. The error is: ");
            printStream.println(sb.toString());
            th.printStackTrace(System.err);
            zzfxVar = new zzfx();
        }
        zza = zzfxVar;
        if (num == null) {
            return;
        }
        num.intValue();
    }

    public static void zza(Throwable th, Throwable th2) {
        zza.zza(th, th2);
    }
}
