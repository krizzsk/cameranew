package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzid {
    public static final zzid zzaig = new zzic();

    public final boolean isEmpty() {
        return zzff() == 0;
    }

    public final zzie zza(int i2, zzie zzieVar, boolean z) {
        return zza(i2, zzieVar, false, 0L);
    }

    public abstract zzie zza(int i2, zzie zzieVar, boolean z, long j2);

    public abstract zzif zza(int i2, zzif zzifVar, boolean z);

    public abstract int zzc(Object obj);

    public abstract int zzff();

    public abstract int zzfg();

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        if ((zzff() - 1) == 0) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(int r3, com.google.android.gms.internal.ads.zzif r4, com.google.android.gms.internal.ads.zzie r5, int r6) {
        /*
            r2 = this;
            r0 = 0
            r2.zza(r3, r4, r0)
            r2.zza(r0, r5, r0)
            r4 = 1
            if (r3 != 0) goto L31
            r3 = -1
            if (r6 == 0) goto L22
            if (r6 == r4) goto L20
            r1 = 2
            if (r6 != r1) goto L1a
            int r6 = r2.zzff()
            int r6 = r6 - r4
            if (r6 != 0) goto L2a
            goto L20
        L1a:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            r3.<init>()
            throw r3
        L20:
            r4 = 0
            goto L2a
        L22:
            int r6 = r2.zzff()
            int r6 = r6 - r4
            if (r6 != 0) goto L2a
            r4 = -1
        L2a:
            if (r4 != r3) goto L2d
            return r3
        L2d:
            r2.zza(r4, r5, r0)
            return r0
        L31:
            int r3 = r3 + r4
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzid.zza(int, com.google.android.gms.internal.ads.zzif, com.google.android.gms.internal.ads.zzie, int):int");
    }
}
