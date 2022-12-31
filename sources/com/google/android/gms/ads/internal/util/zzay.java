package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzaf;
import com.google.android.gms.internal.ads.zzaze;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzbaa;
import com.google.android.gms.internal.ads.zzdzw;
import com.google.android.gms.internal.ads.zzl;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzay {
    private static zzaf a;
    private static final Object b = new Object();

    public zzay(Context context) {
        a(context.getApplicationContext() != null ? context.getApplicationContext() : context);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027 A[Catch: all -> 0x0036, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0010, B:13:0x0027, B:15:0x0030, B:14:0x002c, B:16:0x0032, B:17:0x0034), top: B:22:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002c A[Catch: all -> 0x0036, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0010, B:13:0x0027, B:15:0x0030, B:14:0x002c, B:16:0x0032, B:17:0x0034), top: B:22:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.gms.internal.ads.zzaf a(android.content.Context r3) {
        /*
            java.lang.Object r0 = com.google.android.gms.ads.internal.util.zzay.b
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzaf r1 = com.google.android.gms.ads.internal.util.zzay.a     // Catch: java.lang.Throwable -> L36
            if (r1 != 0) goto L32
            com.google.android.gms.internal.ads.zzabp.initialize(r3)     // Catch: java.lang.Throwable -> L36
            boolean r1 = com.google.android.gms.common.util.e.a()     // Catch: java.lang.Throwable -> L36
            if (r1 != 0) goto L24
            com.google.android.gms.internal.ads.zzaba<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzabp.zzcum     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.internal.ads.zzabl r2 = com.google.android.gms.internal.ads.zzwr.zzqr()     // Catch: java.lang.Throwable -> L36
            java.lang.Object r1 = r2.zzd(r1)     // Catch: java.lang.Throwable -> L36
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L36
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L36
            if (r1 == 0) goto L24
            r1 = 1
            goto L25
        L24:
            r1 = 0
        L25:
            if (r1 == 0) goto L2c
            com.google.android.gms.internal.ads.zzaf r3 = com.google.android.gms.ads.internal.util.zzan.zzbi(r3)     // Catch: java.lang.Throwable -> L36
            goto L30
        L2c:
            com.google.android.gms.internal.ads.zzaf r3 = com.google.android.gms.internal.ads.zzbj.zza(r3)     // Catch: java.lang.Throwable -> L36
        L30:
            com.google.android.gms.ads.internal.util.zzay.a = r3     // Catch: java.lang.Throwable -> L36
        L32:
            com.google.android.gms.internal.ads.zzaf r3 = com.google.android.gms.ads.internal.util.zzay.a     // Catch: java.lang.Throwable -> L36
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L36
            return r3
        L36:
            r3 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L36
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzay.a(android.content.Context):com.google.android.gms.internal.ads.zzaf");
    }

    public static zzdzw<com.google.android.gms.internal.ads.zzz> zzeo(String str) {
        zzbaa zzbaaVar = new zzbaa();
        a.zzd(new zzbe(str, zzbaaVar));
        return zzbaaVar;
    }

    public final zzdzw<String> zza(int i2, String str, @Nullable Map<String, String> map, @Nullable byte[] bArr) {
        n nVar = new n(null);
        m mVar = new m(this, str, nVar);
        zzaze zzazeVar = new zzaze(null);
        l lVar = new l(this, i2, str, nVar, mVar, bArr, map, zzazeVar);
        if (zzaze.isEnabled()) {
            try {
                zzazeVar.zza(str, "GET", lVar.getHeaders(), lVar.zzg());
            } catch (zzl e2) {
                zzazk.zzex(e2.getMessage());
            }
        }
        a.zzd(lVar);
        return nVar;
    }

    public final zzdzw<String> zzb(String str, Map<String, String> map) {
        return zza(0, str, map, null);
    }
}
