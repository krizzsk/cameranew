package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzqi {
    private final zzqh zzbmo;
    private final boolean zzbmp;
    private final long zzbmq;
    private final long zzbmr;
    private long zzbms;
    private long zzbmt;
    private long zzbmu;
    private boolean zzbmv;
    private long zzbmw;
    private long zzbmx;
    private long zzbmy;

    public zzqi() {
        this(-1.0d);
    }

    private final boolean zzg(long j2, long j3) {
        return Math.abs((j3 - this.zzbmw) - (j2 - this.zzbmx)) > 20000000;
    }

    public final void disable() {
        if (this.zzbmp) {
            this.zzbmo.removeObserver();
        }
    }

    public final void enable() {
        this.zzbmv = false;
        if (this.zzbmp) {
            this.zzbmo.zzjq();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long zzf(long r12, long r14) {
        /*
            r11 = this;
            r0 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r12
            boolean r2 = r11.zzbmv
            if (r2 == 0) goto L42
            long r2 = r11.zzbms
            int r4 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r4 == 0) goto L19
            long r2 = r11.zzbmy
            r4 = 1
            long r2 = r2 + r4
            r11.zzbmy = r2
            long r2 = r11.zzbmu
            r11.zzbmt = r2
        L19:
            long r2 = r11.zzbmy
            r4 = 6
            r6 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 < 0) goto L3a
            long r4 = r11.zzbmx
            long r4 = r0 - r4
            long r4 = r4 / r2
            long r2 = r11.zzbmt
            long r2 = r2 + r4
            boolean r4 = r11.zzg(r2, r14)
            if (r4 == 0) goto L33
            r11.zzbmv = r6
            goto L42
        L33:
            long r4 = r11.zzbmw
            long r4 = r4 + r2
            long r6 = r11.zzbmx
            long r4 = r4 - r6
            goto L44
        L3a:
            boolean r2 = r11.zzg(r0, r14)
            if (r2 == 0) goto L42
            r11.zzbmv = r6
        L42:
            r4 = r14
            r2 = r0
        L44:
            boolean r6 = r11.zzbmv
            r7 = 0
            if (r6 != 0) goto L53
            r11.zzbmx = r0
            r11.zzbmw = r14
            r11.zzbmy = r7
            r14 = 1
            r11.zzbmv = r14
        L53:
            r11.zzbms = r12
            r11.zzbmu = r2
            com.google.android.gms.internal.ads.zzqh r12 = r11.zzbmo
            if (r12 == 0) goto L86
            long r12 = r12.zzbmj
            int r14 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r14 != 0) goto L62
            goto L86
        L62:
            com.google.android.gms.internal.ads.zzqh r12 = r11.zzbmo
            long r12 = r12.zzbmj
            long r14 = r11.zzbmq
            long r0 = r4 - r12
            long r0 = r0 / r14
            long r0 = r0 * r14
            long r12 = r12 + r0
            int r0 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r0 > 0) goto L75
            long r14 = r12 - r14
            goto L79
        L75:
            long r14 = r14 + r12
            r9 = r12
            r12 = r14
            r14 = r9
        L79:
            long r0 = r12 - r4
            long r4 = r4 - r14
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 >= 0) goto L81
            goto L82
        L81:
            r12 = r14
        L82:
            long r14 = r11.zzbmr
            long r12 = r12 - r14
            return r12
        L86:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqi.zzf(long, long):long");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzqi(android.content.Context r3) {
        /*
            r2 = this;
            java.lang.String r0 = "window"
            java.lang.Object r3 = r3.getSystemService(r0)
            android.view.WindowManager r3 = (android.view.WindowManager) r3
            android.view.Display r0 = r3.getDefaultDisplay()
            if (r0 == 0) goto L18
            android.view.Display r3 = r3.getDefaultDisplay()
            float r3 = r3.getRefreshRate()
            double r0 = (double) r3
            goto L1a
        L18:
            r0 = -4616189618054758400(0xbff0000000000000, double:-1.0)
        L1a:
            r2.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqi.<init>(android.content.Context):void");
    }

    private zzqi(double d2) {
        boolean z = d2 != -1.0d;
        this.zzbmp = z;
        if (z) {
            this.zzbmo = zzqh.zzjp();
            long j2 = (long) (1.0E9d / d2);
            this.zzbmq = j2;
            this.zzbmr = (j2 * 80) / 100;
            return;
        }
        this.zzbmo = null;
        this.zzbmq = -1L;
        this.zzbmr = -1L;
    }
}
