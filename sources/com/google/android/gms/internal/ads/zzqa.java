package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(17)
/* loaded from: classes2.dex */
public final class zzqa extends Surface {
    private static boolean zzbku;
    private static boolean zzbkv;
    private final boolean zzbcs;
    private final zzqc zzbkw;
    private boolean zzbkx;

    private zzqa(zzqc zzqcVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.zzbkw = zzqcVar;
        this.zzbcs = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized boolean zzc(android.content.Context r6) {
        /*
            java.lang.Class<com.google.android.gms.internal.ads.zzqa> r0 = com.google.android.gms.internal.ads.zzqa.class
            monitor-enter(r0)
            boolean r1 = com.google.android.gms.internal.ads.zzqa.zzbkv     // Catch: java.lang.Throwable -> L53
            if (r1 != 0) goto L4f
            int r1 = com.google.android.gms.internal.ads.zzpt.SDK_INT     // Catch: java.lang.Throwable -> L53
            r2 = 17
            r3 = 1
            if (r1 < r2) goto L4d
            r2 = 0
            android.opengl.EGLDisplay r4 = android.opengl.EGL14.eglGetDisplay(r2)     // Catch: java.lang.Throwable -> L53
            r5 = 12373(0x3055, float:1.7338E-41)
            java.lang.String r4 = android.opengl.EGL14.eglQueryString(r4, r5)     // Catch: java.lang.Throwable -> L53
            if (r4 == 0) goto L4b
            java.lang.String r5 = "EGL_EXT_protected_content"
            boolean r4 = r4.contains(r5)     // Catch: java.lang.Throwable -> L53
            if (r4 == 0) goto L4b
            r4 = 24
            if (r1 != r4) goto L47
            java.lang.String r1 = com.google.android.gms.internal.ads.zzpt.MODEL     // Catch: java.lang.Throwable -> L53
            java.lang.String r4 = "SM-G950"
            boolean r4 = r1.startsWith(r4)     // Catch: java.lang.Throwable -> L53
            if (r4 != 0) goto L39
            java.lang.String r4 = "SM-G955"
            boolean r1 = r1.startsWith(r4)     // Catch: java.lang.Throwable -> L53
            if (r1 == 0) goto L47
        L39:
            android.content.pm.PackageManager r6 = r6.getPackageManager()     // Catch: java.lang.Throwable -> L53
            java.lang.String r1 = "android.hardware.vr.high_performance"
            boolean r6 = r6.hasSystemFeature(r1)     // Catch: java.lang.Throwable -> L53
            if (r6 != 0) goto L47
            r6 = 1
            goto L48
        L47:
            r6 = 0
        L48:
            if (r6 != 0) goto L4b
            r2 = 1
        L4b:
            com.google.android.gms.internal.ads.zzqa.zzbku = r2     // Catch: java.lang.Throwable -> L53
        L4d:
            com.google.android.gms.internal.ads.zzqa.zzbkv = r3     // Catch: java.lang.Throwable -> L53
        L4f:
            boolean r6 = com.google.android.gms.internal.ads.zzqa.zzbku     // Catch: java.lang.Throwable -> L53
            monitor-exit(r0)
            return r6
        L53:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqa.zzc(android.content.Context):boolean");
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.zzbkw) {
            if (!this.zzbkx) {
                this.zzbkw.release();
                this.zzbkx = true;
            }
        }
    }

    public static zzqa zzc(Context context, boolean z) {
        if (zzpt.SDK_INT >= 17) {
            zzpg.checkState(!z || zzc(context));
            return new zzqc().zzm(z);
        }
        throw new UnsupportedOperationException("Unsupported prior to API level 17");
    }
}
